/*var server = require('http'); //http is a module. This is not a local module

//var server = require('./method.js')// This is a local  module. For local module use ./
function engine(request, response){

	response.writeHead(200, {'Content-Type': 'text/Plain', 'MoreInformation':'Veeragh.Goudar.Com'});

	response.end("Node server has started");
}

server.createServer(engine).listen(1337);*/

/*---------------Demo 5---------------------*/

var http = require('http');
var server = http.createServer(engine);

server.listen(1337, function(){

	console.log('Server has been hit');

});


function engine(request, response){

	console.log(response);

	response.writeHead(200, {'Content-Type': 'text/Plain', 'MoreInformation':'Veeragh.Goudar.Com'});

	response.end("Node server has started \n Request from URL :"+request.url);
	
}