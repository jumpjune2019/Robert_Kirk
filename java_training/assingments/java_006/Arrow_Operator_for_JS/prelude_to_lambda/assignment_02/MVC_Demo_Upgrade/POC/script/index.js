window.addEventListener("load", init, false);

function init() {
  var ctrl = (() => {

  	var micbutton = (event) =>{
      event.preventDefault();
      debugger;
  		console.log(this);
  	}
    var constructor = function() {
      console.log("model being created");
      var model;
      model = 888888;
      debugger;
      var btn = document.getElementById("but");

      btn.addEventListener("click", micbutton(), false);

    };

    return new constructor();

  });
  return new ctrl();
}
