var express = require('express');
var path = require('path');
var fs = require('fs');

var bodyParser = require('body-parser');

var app = express();

app.use(bodyParser());
//console.log(app);
//console.log(path);

app.listen(1337, function(){

	console.log("Listening on the port 1337");
})

console.log(__dirname);

app.use('/cssFiles', express.static(__dirname + '/assets'))
//http://localhost:port/cssFiles
//Using regular expressions


app.get('/', function(request, response){

	response.sendFile("index2.html",{root: path.join(__dirname, '../script5/files')});


});



app.post('/', function(request, response){

	//response.sendFile("index2.html",{root: path.join(__dirname, '../script5/files')});

	console.log(JSON.stringify(request.body.username)+"   "+JSON.stringify(request.body.password));

	if(JSON.stringify(request.body.username) === '"veeragh"' && JSON.stringify(request.body.password) === '"veeragh"') {

	//if(request.body.username == 'souju' && request.body.password == 'souju') {

		//response.end(JSON.stringify(request.body));
		response.sendFile("file2.html",{root: path.join(__dirname, '../script5/files')});

	}
	else
	{
	

		response.end("Invalid credentials");

	}

/*	var resp = "Hello  "+request.query.firstName
	console.log(+request.query);
	response.end(resp);*/

});
