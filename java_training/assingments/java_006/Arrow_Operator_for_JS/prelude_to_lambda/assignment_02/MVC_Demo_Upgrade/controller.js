var Controller = (function() {

	var addButtonClickEvent = function(textTrigger, event) {
		var model = this;
		console.log(model);

		var value = textTrigger.value.trim();
		if(value.length) {
			if(model.notDuplicate(value)) {
				model.Add(value);
				textTrigger.value = null;
			} else {
				alert("Duplicate Value");
			}
		};
	};

	// CG: 06/27/2019
	// needs a unit test
	// the event is from the textTrigger
	// we invoke the click() method of the addButton passed if keyCode == 13 which is the Enter keyCode
	var addTextTriggerKeypressEvent = function(addButton, event) {
		if(event.keyCode == 13) {
			addButton.click();
		}
	};

	var deleteButtonClickEvent = function (event){
		var model = this;

		if(event.target.type == "button") {
			model.Delete(event.target.value);

		}

	}
	/*
		var deleteButtonClickEvent = ((event, constructor)=>{
			var model = constructor.model;
			if(event.target.type =="button"){
				model.Delete(event.target.value);
			}
		})(event, constructor)
	*/

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

			// CG: 06/27/2019
			// needs a unit test
			// adding the keyPress event to the textTrigger
			// the callback gets the addButton, if keyCode == 13, addButton's click() method gets invoke in the callback.
			textTrigger.addEventListener("keypress", addTextTriggerKeypressEvent.bind(model, addButton));


			// var deletethings = ((model)=>{
			// 	deleteButtonClickEvent();
			// })(model);



			var listViewEl = scopeEl.getElementsByClassName('listWrapper')[0];
			//listViewEl.addEventListener("click", (e)=>{this.deleteButtonClickEvent(e)});
			//listViewEl.addEventListener("click", (e, model)=>{deleteButtonClickEvent(e)(model)});
			//listViewEl.addEventListener("click", ((model, event)=>{deleteButtonClickEvent(event);})(model));
			listViewEl.addEventListener("click", deleteButtonClickEvent.bind(model));
			//listViewEl.addEventListener("click", deleteButtonClickEvent2);
			//(scope) => { deleteButton();})(scope)
		};

		/*
		var scope = {
			foo: "bar"
		}
		var ctrl = (function() {
			// this is a closure using typical anonymous callback
			console.log('self starting in a simple closure without arrow operator with foo value of: ' + this.foo);
		}.bind(scope))();

		var ctrl2 = ((scope) => {
			console.log('self starting in a simple closure with arrow operator with foo value of: ' + scope.foo);
		})(scope);
		*/
		// ((e, scope)=>{
		// 	deleteButtonClickEvent(e);
		// })(model);



	}

	return new constructor();

});
