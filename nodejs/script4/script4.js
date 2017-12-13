// how to read files

var fs = require('fs');

console.log('Executed before File Reading');

// Reads files asynch

fs.readFile('./files/file', 'utf8', function(error, data){
	console.log("Asynchronously called"+data);
});


// To read synchronously
var data = fs.readFileSync('./files/file', 'utf8');

console.log("synchronously called"+data);

console.log('Executed after File Reading');