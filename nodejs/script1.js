/*------------ DEMO 1------------------------

console.log("Hello World")


for (var i = 0; i <=10; i++) {
	console.log("Hello World : "+i)
}*/

var response = require('./methods.js');

console.log(response);

console.log(response.data.updateServer);

console.log("sumNumbers is ---"+response.data.sumNumbers(10,32));

console.log("circleCircumference is ---"+response.data.circleCircumference(10));

console.log("areaRectangle is ---"+response.data.areaRectangle(10,32));

console.log("output is ---"+response.data.output);

