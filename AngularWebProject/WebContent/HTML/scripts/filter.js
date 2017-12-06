// ADDING A CUSTOM FILTER FOR GENDER
			app.filter("Gender", function(){
						
						return function(genderVal){
							switch(genderVal)
							{
								case 1:
									return "Male";
																
								case 2:
									return "Female";
							}
							
							
						};
						
						
					});


		  

					 