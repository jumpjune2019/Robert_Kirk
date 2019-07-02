$.ready(function() {
	// $.get('title').innerHTML = $.string.format("Quiz Game {0}", $.getVersion());
  //global variables
  var seconds = 0;
  var minutes= 0;
  var hours = 0;
  var intervalInst;
  var quizInProgress = false;
  var quizStarted = false;
  var quizEnded = false;

  var roundsPlayed = 0;
  var score = 0;

  var moves = [];
  var questionList=[];
  //var secondaryQuestionList=[];


   var xhr = new XMLHttpRequest();

 	 xhr.successCallBack = function() {

 		// I am an array, if I can be parsed correctly
 		var data = JSON.parse(xhr.responseText);
    //questionList = data;\
    for(var inc = 0; inc<data.length; inc++){
      questionList.push(data[inc]);
    }
    console.log(questionList);
 	}

 	xhr.failureCallback = function() {
 		alert('Request failed.  Returned status of ' + xhr.status);
 	}

 	xhr.open('GET', 'data/quiz.json');

 	xhr.onload = function() {
 		if (xhr.status === 200) {
 			xhr.successCallBack();
 		}
 		else {
 			xhr.failureCallback();
 		}
 	};
 	xhr.send();



  var listOfCurrentQuestion = [];
  var checkListForCurrentQuestion = [];
  function resetCurrentQuestions(){
    listOfCurrentQuestionAndCheckList = [];
    checkListForCurrentQuestion = [];
  }

  var count = 0;
  var listConstructor = function() {

    var len = questionList.length;
    //Math.floor(Math.random() * 10) + 1;
    var lot = $.randomInt(len,0);

    var x = questionList[lot];

    questionList[lot] = questionList[len-1];
    questionList[len-1] = x;

    var selectedQuestion = questionList.pop();

    listOfCurrentQuestion.push(selectedQuestion);
    checkListForCurrentQuestion.push(selectedQuestion);
    count++;
    if(count<5){
      listConstructor();
    }else {
      console.log(questionList);
      count = 0;
      console.log("this is the list of current questions: " +listOfCurrentQuestion);
    }

  }

  var answerSlots = [1,2,3,4,5];
  var questionSlots = [1,2,3,4,5];
  var slated = 0;
  var startQuiz = function() {
    console.log(questionList);
    //Reset Values
    document.getElementById('holder1').innerHTML="Slot";
    document.getElementById('holder2').innerHTML="Slot";
    document.getElementById('holder3').innerHTML="Slot";
    document.getElementById('holder4').innerHTML="Slot";
    document.getElementById('holder5').innerHTML="Slot";

    var len = answerSlots.length;

    //slot determinor
    var x = $.randomInt(len, 0);
    var y = $.randomInt(len, 0);

    // console.log("x= " + x);
    // console.log("y= " + y);

    //slot val picked for replacement
    var ansId = answerSlots[x];
    var questId = questionSlots[y];

    // console.log("ansId " +ansId);
    // console.log("questId " + questId);
    //maintain values not selected and pop one of the positions off
    answerSlots[x] = answerSlots[len-1];
    answerSlots.pop();
    questionSlots[y] = questionSlots[len-1];
    questionSlots.pop();

    //Example
    // "question": "The teacher of our JUMP class.",
    // "answer": "Claude"
    var index = $.randomInt(listOfCurrentQuestion.length, 0);
    var obj = listOfCurrentQuestion[index];
    listOfCurrentQuestion[index] = listOfCurrentQuestion[len-1];

    listOfCurrentQuestion[len-1] = obj;
    listOfCurrentQuestion.pop();
    var question = obj.question;
    var answer = obj.answer;
    slated++;
    //assign values
    document.getElementById("def"+questId).innerHTML = question;
    document.getElementById("termWidget"+ansId).innerHTML = answer;

    if(slated < 5){
      startQuiz();
    }else{
      slated =0;
      answerSlots = [1,2,3,4,5];
      questionSlots = [1,2,3,4,5];
    }
  }
  function checkScore() {
    for(var i = 1; i<6; i++){
      var quest = document.getElementById('def'+i).innerHTML;
      var guess = document.getElementById('holder'+i).innerHTML;
      for(var j = 0; j<5; j++){
        var questList = checkListForCurrentQuestion[j].question;
        var ansList = checkListForCurrentQuestion[j].answer;
        if(quest == questList){
          if(guess == ansList){
            score++;
            document.getElementById('definitionWidget'+i).style.setProperty("background-color", "green");
          }else{
            document.getElementById('definitionWidget'+i).style.setProperty("background-color", "red");
          }
        }
      }
      console.log(score);
    }
    document.getElementById('score').innerHTML= "Score: "+ score;

  }


  //move actions
  function storeMove(id, text){
    var move = {
      "locationId": id,
      "text":text
     }
     console.log(move);
    moves.push(move);
  }


  var undoButton = document.getElementById('undo')
  //Undo button Functionality
  function undoAction() {
    var answeredSlot = moves.pop();
    var answerPosition = moves.pop();
    var slot = document.getElementById(answeredSlot.locationId);
    slot.innerHTML = answeredSlot.text;
    var answerHolder = document.getElementById(answerPosition.locationId);
    answerHolder.innerHTML = answerPosition.text;
    console.log(moves);
  }
  undoButton.addEventListener("click", undoAction, false);

  function overrideAction(){
    //For the case of a user trying to override a definition choice. Function will return the occupying answer to initial slot
    //to be completed if time permits
  }

  //*** TIMER SECTION!***
  var setIntervalFunc = function() {
    if(quizInProgress){
      var timer = document.getElementById("timer");
      seconds++;
      if (seconds == 60) {
        minutes++;
        seconds =0;
      }
      if (minutes == 60) {
        hours++;
        minutes = 0;
      }
      timer.innerHTML = hours + ":" + minutes + ":" + seconds;
    }
  }
  function changeButtonText(){
    //id="controlButton" state="Start" nextstate = "Endround"
    var btn = document.getElementById('controlButton');
    if(roundsPlayed < 6){
      if (btn.innerHTML == "Start" || btn.innerHTML == "Next Round") {
        //btn.state = "Endround";
        btn.innerHTML = "End Round";
        // btn.nextState = "NextRound";
      }else{
        //btn.state = "Endround";
        btn.innerHTML = "Next Round";
        // btn.nextState = "NextRound";
      }
    }else{
      btn.innerHTML = "END GAME"
    }

  }
  var controlFunc = function(event){
    changeButtonText();
    event.preventDefault();
    if(roundsPlayed < 6){
      if(!quizStarted && !quizInProgress && !quizEnded){
        intervalInst = setInterval(setIntervalFunc, 1000);
        quizInProgress = true;
        quizStarted = true;
        roundsPlayed++;

        listConstructor();
        startQuiz();

        //function starting the quiz
      }else if (quizInProgress) {
         //fucntion to stop the game
         checkScore();
         quizInProgress = false;
         roundsPlayed++;
         resetCurrentQuestions();
      }else if (!quizEnded && !quizInProgress){
        //start next round

        listConstructor();
        startQuiz();
        quizInProgress = true;
        document.getElementById('definitionWidget1').style.setProperty("background-color", "blue");
        document.getElementById('definitionWidget2').style.setProperty("background-color", "blue");
        document.getElementById('definitionWidget3').style.setProperty("background-color", "blue");
        document.getElementById('definitionWidget4').style.setProperty("background-color", "blue");
        document.getElementById('definitionWidget5').style.setProperty("background-color", "blue");
      }
    }else {
      var time = document.getElementById('timer').innerHTML;
      alert("Your final Score is: " + score + "." +
      "\n It took you " + time + "." +
      "\nPlease reload the page if you want to play again")
    }
  }

  var controlButton = document.getElementById("controlButton");
  //setInterval(setIntervalFunc, 1000);
  controlButton.addEventListener("click", controlFunc, false);


  //Functionality brought by the drag and drop POC provided by Claude
  function startDragItemFunc(e) {
      e.dataTransfer.setData("text", e.target.id);
      if((moves.length+1)%2 === 0 && moves.length != 0){
        moves.pop();
      }

      storeMove(e.target.id, e.target.innerHTML.trim());

  }

  //regex pattern to get the targeted parent div
  var patt = new RegExp('div#definitionWidget+[1-5]\.definitionWidget');

  function dropItemFunc(e) {
    if (quizInProgress&& e.currentTarget.firstElementChild.innerHTML==="Slot") {
      e.preventDefault();
      console.log(e);
      var data = e.dataTransfer.getData("text");
      var dragEl = document.getElementById(data);
      //e.target.innerHTML = dragEl.innerHTML;
      //console.log(e.currentTarget.firstElementChild);
      e.currentTarget.firstElementChild.innerHTML = dragEl.innerHTML;
      //dragEl.innerHTML = "";
      dragEl.innerHTML = "Empty";
      storeMove(e.currentTarget.firstElementChild.id, "Slot");
    }else{
      moves.pop();
    }
  }

  function dragOverItemFunc(e) {
    e.preventDefault();
  }

  // var understandTarget = function(e){
  //   console.log(e);
  //   console.log(e.target);
  // }
  function createDropZonesAndDispatchAreas(){
    for(var i = 1; i<6;i++){
      //targets aquired
      var dragItem = document.getElementById("termWidget"+i);
      var dropArea = document.getElementById("definitionWidget"+i);


      //events created
      dragItem.addEventListener("dragstart", startDragItemFunc, false);
      dropArea.addEventListener("drop", dropItemFunc, false);
      dropArea.addEventListener("dragover", dragOverItemFunc, false);
      //dropArea.addEventListener("click", understandTarget, false);
      //var initBox = document.getElementById("initBox");
    }
  }
  createDropZonesAndDispatchAreas();


});
