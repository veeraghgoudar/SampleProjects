//creating services

app.factory("mathService", function(){
	
	return{
		sumOfNumbers : function(input1, input2){
						var output=0;
						output = input1+input2;	
						return output;
						}
	
		};
});


