var express = require('express');
var bodyParser = require('body-parser');
var sessions = require('express-session');
var session;
var path = require('path');
var app = express();

app.use('/cssFiles', express.static(__dirname + '/assets'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));
app.use(sessions({
	secret: 'CVBNM<JK',
	resave: false,
	saveUninitialized: true

}));


app.get('/',function(request, response){

	session = request.session;
		if(session.uniqueId){

			response.redirect('/redirects');

		}else{
			response.redirect('/login');
		}


});

app.get('/login',function(request, response){

		session = request.session;
	
		if(session.uniqueId){

			response.redirect('/redirects');

		}

	response.sendFile("/login.html",{root: path.join(__dirname, '/HTML')});
});



app.post('/login',function(request, response){

	session = request.session;
	
	if(session.uniqueId){

		response.redirect('/redirects');

	}

	if(request.body.username == 'veeragh' && request.body.password == 'veeragh') {

		console.log("Adding cookie and session");
		response.cookie('myFirstCookie', 'cookie1 Test')
		session.uniqueId = request.body.username;
		
	}
	else{
		//response.end("Invalid credentials");
	}

	response.redirect('/redirects');


});

app.get('/logout', function(request, response){
	
	request.session.destroy(function(error){
		console.log(error);

		response.redirect('/login');
		
	})
	console.log("Removing cookie");
	response.clearCookie('myFirstCookie');
	
});


app.get('/main', function(request, response){
  session = request.session;
	
	if(session.uniqueId){
	response.sendFile("main.html",{root: path.join(__dirname, '/HTML')});
	}else{
		response.send("Unauthorized login");
	}
});


app.get('/redirects', function(request, response){
	session = request.session;
	
	if(session.uniqueId){

		console.log(session.uniqueId);
		response.redirect('/main');
		//response.sendFile("main.html",{root: path.join(__dirname, '/HTML')});
	}
	else{
		response.end('who are you ?');
	}

});

app.listen(1337,function(){

	console.log('Yeah!!!!!!! Server started');

});
