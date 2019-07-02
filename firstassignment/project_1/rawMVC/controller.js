var Controller = (function() {

	var addButtonClickEvent = function(textTrigger, event) {
		var model = this;
		var value = textTrigger.value.trim();
		if(value.length) {
			debugger;
			if(model.notDuplicate(value)) {
				model.Add(value);
				textTrigger.value = null;
			} else {
				alert("Duplicate Value");
			}
		};

	};


	var deleteButtonClickEvent = function(event) {
		var model = this;
		if(event.target.type == "button") {
			model.Delete(event.target.value);

		}

	}
	var onKeyPress = function(textTrigger, event) {

		if(event.keyCode == 13){
			var model = this;
			var value = textTrigger.value.trim();
			if(value.length) {
				if(model.notDuplicate(value)) {
					model.Add(value);
					textTrigger.value = null;
				} else {
					alert("Duplicate Value");
				}
			}
		}


		//var x = event.which || event.keycode;
		/*
		if(x == 13){
			addButtonClickEvent.bind(model, textTrigger);
		}
		*/
	}
	// let testFieldEnterEvent = function(textTrigger, event){
	// 	var model = this;
	// 	var key = event.keyCode;
	// 	var stuff = event;
	// 	debugger;
	// 	if (key== 13) {
	// 		console.log();
	// 		addButtonClickEvent.bind(model, textTrigger,stuff);
	// 	}
	// }
	var constructor = function() {

		var scopeEl;
		var model;
		var view;

		this.init = function(el, m, v) {
			scopeEl = el;
			model = m;
			view = v;
			model.setScope(el);
			model.setView(view);
			model.registerWidget(view.listView());
			model.registerWidget(view.summaryView());
			model.refreshWidgets(view, model);


			var addButton = view.triggerField().getButtonInstance(el);
			var textTrigger = view.triggerField().getTextInstance(el);

			addButton.addEventListener("click", addButtonClickEvent.bind(model, textTrigger));

			var listViewEl = scopeEl.getElementsByClassName('listWrapper')[0];
			listViewEl.addEventListener("click", deleteButtonClickEvent.bind(model));

			//textTrigger.addEventListener("keypress", testFieldEnterEvent.bind(model, textTrigger), false);
			textTrigger.addEventListener("keypress", onKeyPress.bind(model, textTrigger), false);

			//element.addEventListener("keydown", onKeyPress, false);
			//function() { some_function(someVar); }
			//function() { onKeyPress(model, textTrigger); }
			// onKeyPress.bind(model, textTrigger)
			//addEventListener("keypress", onKeyPress.bind(model, textTrigger));

		};

	};

	return new constructor();

});
