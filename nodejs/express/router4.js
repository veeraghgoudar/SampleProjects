var express = require('express');
var app = express();

var router = express.Router();


app.use('/myFirstRouter', router);

router.get('/firstLink', function(request, response){

	response.end('What is going on ? By - firstLink');

	});

router.get('/secondLink', function(request, response){

	response.end('What is going on Again ? By - secondLink');

	});

router.get('/secondLink/:username', function(request, response){

	response.end(JSON.stringify(request.params));

	});


app.listen(1337, function(){

	console.log("YEAH!!!!!!!!!! Server started");

})