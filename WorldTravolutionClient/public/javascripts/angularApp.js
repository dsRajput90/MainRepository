var app=angular.module('worldTravolution',['ui.router','angularModalService']);

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
'$scope','$http','tourFactory','ModalService',
function($scope,$http,tourFactory,ModalService){
		$scope.tours = [];
		$scope.init = function () {
          return $http.get(tourFactory.baseUri + '/api/tour/all').
	    then(function(response) {
					angular.copy(response.data.data, $scope.tours);
	  });
	};

	$scope.show = function(scope) {
				ModalService.showModal({
						templateUrl: 'template/modal.html',
						controller: "ModalController",
						animation: "false",
						resolve: {
							test: function(){
								return 'test variable';
							}
						},
						inputs:{
						scope:scope
						}
				}).then(function(modal) {

						modal.element.modal();
						modal.close.then(function(result) {
							 // $scope.message = "You said " + result;
						});
				});
		};

$scope.packageClicked = function(index){
	$scope.selector=angular.element(document.querySelector("#modal-window"));

	$scope.title=$scope.tours[index].tour_name;
	$scope.cost=$scope.tours[index].tour_price;

$scope.show($scope);
	//modal window
	//dynamix modal window

	$scope.building_modal='<div id="myModal" class="modal fade" role="dialog">';
	$scope.building_modal+='<div class="modal-dialog">';



			$scope.building_modal+='<div class="modal-content">';
				$scope.building_modal+='<div class="modal-header">';
					$scope.building_modal+='<button type="button" class="close" data-dismiss="modal">&times;</button>';
					$scope.building_modal+='<h4 class="modal-title">'+$scope.title+'</h4>';
				$scope.building_modal+='</div>';
				$scope.building_modal+='<div class="modal-body">';

			$scope.building_modal+='<div class="">';
					$scope.building_modal+='<ul class="nav nav-tabs">';
					$scope.building_modal+='<li class="active"><a href="#tab1" data-toggle="tab">Description</a></li>';
					$scope.building_modal+='<li><a href="#tab2" data-toggle="tab">Book</a></li>';
					$scope.building_modal+='</ul>';
					$scope.building_modal+='<div class="tab-content">';
					$scope.building_modal+='<div class="tab-pane active" id="tab1">';
							$scope.building_modal+='Detailed Description About Package';
					$scope.building_modal+='</div>';
					$scope.building_modal+='<div class="tab-pane form-group" style="padding-top:2%" id="tab2">';
				$scope.building_modal+='<div class="full-container">';

			$scope.building_modal+='<div class="row">';
					$scope.building_modal+='<div class="col-sm-3"><label style="color:#737125,padding-top:2%">Name : </label></div>';
					$scope.building_modal+='<div class="col-sm-9"><input type="text" value="" required/></div>';

				$scope.building_modal+='</div>';

				$scope.building_modal+='<div class="row">';
				$scope.building_modal+='<div class="col-sm-3"><label style="color:#737125,padding-top:2%">Phone No : </label></div>';
				$scope.building_modal+='<div class="col-sm-9"><input type="text" value="" required/></div>';
				$scope.building_modal+='</div>';

				$scope.building_modal+='<div class="row">';
				$scope.building_modal+='<div class="col-sm-3"><label style="color:#737125,padding-top:2%">Email Id : </label></div>';
				$scope.building_modal+='<div class="col-sm-9"><input type="text" value="" /></div>';

				$scope.building_modal+='</div>';


					$scope.building_modal+='</div>        </div>        </div>      </div>';
				$scope.building_modal+='<div class="modal-footer">';
					$scope.building_modal+='<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
			$scope.building_modal+='<button type="button" class="btn btn-default" onclick=sendToServer()>Submit</button>';
				$scope.building_modal+='</div>';
			$scope.building_modal+='</div>  </div></div></div>';

};

}]);

app.controller('ModalController', function($scope, close,scope){
  $scope.scope=scope;

 $scope.close = function(result) {
	console.log("From the close");
	 $('.modal-backdrop').remove();
 	close(result); // close, but give 500ms for bootstrap to animate
 };

});
