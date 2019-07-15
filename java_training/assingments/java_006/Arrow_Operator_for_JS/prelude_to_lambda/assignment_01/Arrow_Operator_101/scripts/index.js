window.addEventListener("load", init, false);
function init() {
	let x;
	let multiplier = (arg1, arg2) => x = arg1*arg2;

	multiplier(2,2);
	console.log("loggging multiplier: " + multiplier);
	console.log("loging x: " +x);


	let y = (a, b)=>	{return a/b};
	y(x,0.01);

	console.log(y);

	let z = y(x,0.01);
	console.log(z);

	//Borrowed code from:
	//https://www.sitepoint.com/es6-arrow-functions-new-fat-concise-syntax-javascript/

	const smartPhones = [
	  { name:'iphone', price:649 },
	  { name:'Galaxy S6', price:576 },
	  { name:'Galaxy Note 5', price:489 }
	];
	const prices = smartPhones.map(smartPhone => smartPhone.price);

	console.log(prices); // [649, 576, 489]

	var adder = {
	  base: 1,

	  add: function(a) {
	    var f = v => v + this.base;
	    return f(a);
	  },

	  addThruCall: function(a) {
	    var f = v => v + this.base;
	    var b = {
	      base: 2
	    };

	    return f.call(b, a);
	  }
	};

	console.log(adder.add(1));         // This would log 2
	console.log(adder.addThruCall(1)); // This would log 2 still

}
