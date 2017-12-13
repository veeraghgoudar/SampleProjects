// how to read files

var fs = require('fs');

var date = new Date();

console.log('Executed before File Writing');

var message = 'Hello whats up ? New message on DATE -- '+date.toUTCString()+'  '+date.getMinutes();
// To write Asynchronously
fs.writeFile('./files/file2', message, 'utf8', function(error){
	if(error) throw error;
	console.log("Asynchronously called");
	console.log('file saved')
});


var data = fs.writeFileSync('./files/synchfile2', message, 'utf8');

console.log("synchronously called"+data);

console.log('Executed after File writing');