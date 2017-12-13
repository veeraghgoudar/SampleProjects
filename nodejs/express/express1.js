var express = require('express');
var path = require('path');
var fs = require('fs');
var app = express();
//console.log(app);
//console.log(path);

app.listen(1337, function(){

	console.log("Listening on the port 1337");
})

console.log(__dirname);

app.use('/cssFiles', express.static(__dirname + '/assets'))
//http://localhost:port/cssFiles
//Using regular expressions


app.get('/helloWorld', function(request, response){

	response.send("Hello World Example from expres. No server restart required");

});


app.get('/getFile', function(request, response){

	response.sendFile("index.html",{root: path.join(__dirname, '../script5/files')});

});



app.get(/^(.+)$/, function(request,response){

	console.log(request.params);

	try{
	if(fs.statSync(path.join(__dirname,'../script5/files', request.params[0]+'.html')).isFile){
		response.sendFile(request.params[0]+'.html', {root: path.join(__dirname, '../script5/files')});
	}
	}
	catch(error)
	{
		response.sendFile('pageNotFound.html', {root: path.join(__dirname, '../script5/files')});
		console.log("EXCEPTIONNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNnnnnn-"+error);
	}


	


});

