/*module.exports = {
	
	currentUrl:'http://codedamn.com'

}*/


function construct_function(){

	var nameHolder;
	return{

		name: function(fName, lName){
			
			nameHolder = fName +' '+ lName;			
		},
		consoleLog: function(){
			console.log(nameHolder);
		}

	}

}

module.exports = construct_function;