window.onload = init;

function init() {
  var cb = function(e) {
    var val = e.target.getAttribute("nextstate");
    e.target.value = val;
    switch(val) {
      case "Stop":
        val = "Start";
      break;
      case "Start":
        val = "Stop";
      break;
    }
    e.target.setAttribute("nextstate", val);
  }
  var btn = document.getElementById("myState");
  btn.addEventListener("click", cb, false);

  var setTimeoutFunc = function() {
    var refreshMeEL = document.getElementById("refreshme");
    refreshMeEL.innerHTML = "I'm finally refreshed!";
  }

  setTimeout(setTimeoutFunc, 10000);

  var seconds = 0;
  var minutes= 0;
  var hours = 0;
  var setIntervalFunc = function() {
    var refreshMyTimeEl = document.getElementById("refreshmytime");
    seconds++;
    if (seconds == 60) {
      minutes++;
      seconds =0;
    }
    if (minutes == 60) {
      hours++;
      minutes = 0;
    }
    refreshMyTimeEl.innerHTML = hours + ":" + minutes + ":" + seconds;

  }
  setInterval(setIntervalFunc, 1000);
}
