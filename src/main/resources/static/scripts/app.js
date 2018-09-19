angular.module("myModule",[]).controller("myController", function($scope, $http) {
	$scope.message="Welcome to Angular JS";
	$scope.greet = function(id){
		$scope.message = "Hello, Good morning";
		$scope.value = event.srcElement.id;
	};
	
	$scope.login = function(){
		
	};
	
	$scope.signup = function(){
		console.log(data);
		windows.alert('java script inside signup()');
		$scope.response = $http.post('http://localhost:8090/signup/',data, config)
		.success(function (data, status, headers, config) {
            $scope.PostDataResponse = data;
        })
        .error(function (data, status, header, config) {
            $scope.ResponseDetails = "Data: " + data +
                "<hr />status: " + status +
                "<hr />headers: " + header +
                "<hr />config: " + config;
        });
	};
	
});

