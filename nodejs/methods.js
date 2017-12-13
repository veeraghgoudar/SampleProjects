/*var methods = {};
//var output;

this.output;

methods.updateServer = function(){

	console.log('Important function');
}

methods.eatCookies = function(){
	console.log('Chocolate Cookies');
}

methods.node = function(){
	console.log('Nodejs is AWESOME');
}

methods.sumNumbers = function(a, b){
	this.output = a + b;
	return this.output;

}


methods.circleCircumference = function(radius){
	return 2 * Math.PI * radius;

}

methods.areaRectangle = function(a, b){
	return a*b;

}

exports.data = methods;
*/


// -------------------------To suppot Script3.js----------------------
var methods = module.exports = {};
//var output;

this.output;

methods.updateServer = function(){

	console.log('Important function');
}

methods.eatCookies = function(){
	console.log('Chocolate Cookies');
}

methods.node = function(){
	console.log('Nodejs is AWESOME');
}

methods.sumNumbers = function(a, b){
	this.output = a + b;
	return this.output;

}


methods.circleCircumference = function(radius){
	return 2 * Math.PI * radius;

}

methods.areaRectangle = function(a, b){
	return a*b;

}
