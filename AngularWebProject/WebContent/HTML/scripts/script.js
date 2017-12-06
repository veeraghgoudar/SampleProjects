var app = angular.module("Demo", ["ngRoute"])
				 .config(function($routeProvider){
					 $routeProvider.caseInsensitiveMatch=true;
					 $routeProvider
					 			.when("/home",{
					 				templateUrl: "HTML/screens/templates/Home.html",
					 				controller:"homeController",
					 				controllerAs : "homeCtrl"
					 			})
					 			.when("/courses",{
					 				templateUrl: "HTML/screens/templates/courses.html",
					 				controller:"coursesController",
					 				caseInsensitiveMatch:true
					 			})
					 			.when("/students",{
					 				templateUrl: "HTML/screens/templates/student.html",
					 				controller:"studentController"
					 			})
					 			//: specifies parameter. :id is the parameter
					 			.when("/students/:id",{
					 				templateUrl: "HTML/screens/templates/studentInfo.html",
					 				controller:"studentController"
					 			})
					 			.when("/service",{
					 				templateUrl: "HTML/screens/templates/service.html",
					 				controller:"serviceController"
					 			})
					 			.when("/geography",{
					 				templateUrl: "HTML/screens/templates/GeographyInfo.html",
					 				controller:"geographyController",
					 				controllerAs : "geoCtrl"
					 			})
					 			.when("/inlineHtml",{
					 				template: "<h1>In Line HTML Example</h1>",
					 			})
					 			.when("/scope",{
					 				templateUrl: "HTML/screens/templates/scopeVsRouteScope.html"
					 			})
					 			.otherwise({
					 				//redirectTo : "/service"
					 				templateUrl: "HTML/screens/templates/Error.html"
					 			});
					 			
		 
				 })
				 .controller("homeController", function (){
					 this.message = "Welcome to Home Page";
					 
				 })
				 .controller("coursesController", function ($scope){
					 $scope.courses = ["C#", "javaScript", "angularJs", "Java"];
					 $scope.coursesMessage = "Welcome to Courses Page";
					 
				 }) 
				 .controller("studentController", function ($scope, $http, $routeParams, $route){
					 
					 // Canceling route changes using $route parameter
					 
					 $scope.$on("$routeChangeStart", function(event, next, current){
						 
						 if(!confirm("Are you sure you want to navigate away from this page to "+next.$$route.originalPath))
							 event.preventDefault();
					 }	);			 
					 
					 $scope.studentList = 
						[{id:'1',firstName:'Veeragh', lastName:'Goudar', gender:1, salary:502,salary2:'298923', dob:new Date("June 18, 1988")}, 
						{id:'2',firstName:'Ravi', lastName:'Goudar', gender:1, salary:50,salary2:'298923', dob:new Date("June 18, 1988")},
						{id:'3',firstName:'Laxman', lastName:'Goudar', gender:1, salary:500,salary2:'298923', dob:new Date("June 18, 1988")},
						{id:'4',firstName:'Maati', lastName:'Goudar', gender:2, salary:300,salary2:'298923', dob:new Date("June 18, 1988")},
						{id:'5',firstName:'Aravind', lastName:'Goudar', gender:1, salary:700,salary2:'298923', dob:new Date("June 18, 1988")},
						{id:'6',firstName:'Satyam', lastName:'Goudar', gender:1, salary:100,salary2:'298923', dob:new Date("June 18, 1988")}];
				 
					 $scope.studentmessage = "Welcome to Students Page";
					 
					 $scope.employeeInfo =  $scope.studentList[$routeParams.id];
					 
				 }) 
				 .controller("serviceController", function($scope, mathService, $rootScope, $log){
/*					 $scope.$on("$locationChangeStart", function(event, next, current){
							if(!confirm("Are you sure you want to navigate away from this page to "+next)){
								event.preventDefault();
							}				
						});*/
					 
					 $scope.$on("$locationChangeStart", function(event, next, current){
						$log.debug("$locationChangeStart is FIRED")
						$log.debug(event);
						$log.debug(next);
						$log.debug(current);
						
					});
					
					$scope.$on("$routeChangeStart", function(event, next, current){
						$log.debug("$routeChangeStart is FIRED")
						$log.debug(event);
						$log.debug(next);
						$log.debug(current);					
					});
					
					$rootScope.$on("$locationChangeSuccess", function(){
						$log.debug("$locationChangeSuccess is FIRED")			
					});
					
					$rootScope.$on("$routeChangeSuccess", function(){
						$log.debug("$routeChangeSuccess is FIRED")
						
					});
					 
				
					$scope.doMathOperation = function(input1, input2){
					$scope.output = mathService.sumOfNumbers(input1, input2);
					}
				})
				.controller("geographyController", function(){
					this.message = "Geography Area";
					
				})
				.controller("country", function(){
					
					this.name = "India";
					
				})
				.controller("states", function(){
					
					this.name = "karnataka";
					
				})
				.controller("city", function(){
					
					this.name = "Bengaluru";
					
				})
				.controller("redColor", function($rootScope){
					// $rootScope is like global variable could be use in any controller
					this.color = "Red";
					$rootScope.color = "Blue";
					
				})
				.controller("greenColor", function(){
					
					this.color = "Green";
					
				});