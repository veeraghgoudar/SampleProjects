/*var moduleX = require('./mainModule')

moduleX.currentUrl ='http://www.google.com';
console.log('Current Url '+moduleX.currentUrl);*/



var mod = require('./mainModule')

var name = new mod();
name.name('Veeragh', 'Goudar');
console.log("FROM MODULE 1")
name.consoleLog();