window.addEventListener("load", init, false);

function init() {
  function allowDrop(ev) {
    ev.preventDefault();
  }

  function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
  }

  function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    console.log(ev.target);
    ev.target.appendChild(document.getElementById(data));
  }
  var initBox = document.getElementById("initBox");

  var understandTarget = function(e){
    console.log(e);
    console.log(e.target);
  }

  initBox.addEventListener("click", understandTarget, false)
}
