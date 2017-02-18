var app=angular.module('worldTravolution',['ui.router']);

app.config([
'$stateProvider',
'$urlRouterProvider',
function($stateProvider,$urlRouterProvider){
	$stateProvider
		.state('tours', {
		url:'/tours',
		templateUrl:'template/tours.html',
		controller:'TourCtrl'
	});
	$urlRouterProvider.otherwise('tours');
}]);

app.factory('tourFactory', ['$http', '$window', function($http, $window){
   var auth = {};
   auth.baseUri = 'http://localhost:9081';
   return auth;
}]);

app.controller('TourCtrl', [
'$scope','$http','tourFactory',
function($scope,$http,tourFactory){
		$scope.tours = [];
		$scope.init = function () {
          return $http.get(tourFactory.baseUri + '/api/tour/all').
	    then(function(response) {
					angular.copy(response.data.data, $scope.tours);
					console.log($scope.tours);
	  });
	};
}]);
