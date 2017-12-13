var express = require('express');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var app = express();
var path = require('path');
var fs = require('fs');

app.use(cookieParser());
app.use(bodyParser());
app.use('/cssFiles', express.static(__dirname + '/assets'));
//app.use('/logout', express.static(__dirname + '/../script5/files/'));

app.listen(1337, function(){

	console.log("Listening on the port 1337");
});

app.get('/login', function(request, response){
	response.sendFile("index2.html",{root: path.join(__dirname, '../script5/files')});
});



app.post('/login', function(request, response){

	if(JSON.stringify(request.body.username) === '"veeragh"' && JSON.stringify(request.body.password) === '"veeragh"') {

		console.log("Adding cookie");
		response.cookie('myFirstCookie', 'cookie1 Test')
		response.sendFile("file2.html",{root: path.join(__dirname, '../script5/files')});

	}
	else
	{
		response.end("Invalid credentials");
	}

});

app.get('/logout', function(request, response){
	console.log("Removing cookie");
	response.clearCookie('myFirstCookie');
	//response.end("Cookies invalidated");
	response.sendFile("index.html",{root: path.join(__dirname, '../script5/files')});
});
