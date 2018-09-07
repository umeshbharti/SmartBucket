angular.module("myModule",[]).controller("myController", function($scope, $http) {
	$scope.message="Welcome to Angular JS";
	$scope.greet = function(id){
		$scope.message = "Hello, Good morning";
		$scope.value = event.srcElement.id;
	};
	
	$scope.login = function(){
		
	};
	
	$scope.signup = function(details){
		
	};
	
});