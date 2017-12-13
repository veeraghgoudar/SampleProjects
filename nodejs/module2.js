/*var moduleX = require('./mainModule')

console.log('Current Url '+moduleX.currentUrl);
*/





var mod = require('./mainModule')

var name = new mod();
name.name('Ravi', 'Singh');
console.log("FROM MODULE 2")
name.consoleLog();