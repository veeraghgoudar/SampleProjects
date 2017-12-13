var events = require('events');




var eventEmitter = new events.EventEmitter();


eventEmitter.on('myCustomEvent', function(x, y){

	console.log('Event Fired'+x+y);


});



setTimeout(function(){

	eventEmitter.emit('myCustomEvent', 'Veeragh', 'Goudar');

}, 5000)