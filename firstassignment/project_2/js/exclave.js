//Functionality brought by the drag and drop POC provided by Claude
function startDragItemFunc(e) {
  e.dataTransfer.setData("text", e.target.id);
}

var patt = new RegEXp('div#definitionWidget+[1-5]\.definitionWidget');

function dropItemFunc(e) {
  e.preventDefault();
  var data = e.dataTransfer.getData("text");
  var dragEl = document.getElementById(data);
  
  for(var i = 0; i<e.path.length-1; i++){
    if (patt.test(e.path[i])) {
      var id = e.path[i].split(".");
      id = id.split("#");
      var parent = document.getElementById(id[1]);
      child = parent.querySelector("#holder");
      child.innerHTML = dragEl.innerHTML;
      dragEl.innerHTML = "Empty";
    }
  }
}

function dragOverItemFunc(e) {
  e.preventDefault();
}
function createDropZonesAndDispatchAreas(){
  for(var i = 1; i<6;i++){
    //targets aquired
    var dragItem = document.getElementById("termWidget"+i);
    var dropArea = document.getElementById("dropArea"+i);

    //events created
    dragItem.addEventListener("dragstart", startDragItemFunc, false);
    dropArea.addEventListener("drop", dropItemFunc, false);
    dropArea.addEventListener("dragover", dragOverItemFunc, false);
  }
}
createDropZonesAndDispatchAreas();
