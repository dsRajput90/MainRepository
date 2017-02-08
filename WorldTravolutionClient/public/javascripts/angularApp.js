var app=angular.module('flapperNews',['ui.router']);

app.config([
'$stateProvider',
'$urlRouterProvider',
function($stateProvider,$urlRouterProvider){

	$stateProvider
	  .state('login', {
		url:'/login',
		templateUrl:'template/login.html',
		controller:'AuthCtrl',
		onEnter: ['$state','auth',function($state,auth) {
			if(auth.isLoggedIn()) {
				$state.go('home');
			}
		}]
		})
	  .state('register', {
		url:'/register',
		templateUrl:'template/register.html',
		controller:'AuthCtrl',
		onEnter:['$state', 'auth', function($state, auth){
		    if(auth.isLoggedIn()){
		      $state.go('home');
		    }
		  }]
		})
	  .state('home', {
		url: '/home',
		templateUrl: 'template/home.html',
		controller: 'CafeTabController'
		})
	  .state('posts', {
		url: '/posts/{id}',
		templateUrl: 'template/posts.html',
		controller: 'PostsCtrl',
		resolve: {
			post: ['$stateParams','posts', function($stateParams,posts) {
				return posts.get($stateParams.id);
			}]
		}
		});
	$urlRouterProvider.otherwise('home');
}]);

app.factory('auth', ['$http', '$window', function($http, $window){
   var auth = {};
   auth.baseUri = 'http://localhost:9081';
   auth.saveToken = function (token){
  $window.localStorage['flapper-news-token'] = token;
};

auth.getToken = function (){
  return $window.localStorage['flapper-news-token'];
}

auth.isLoggedIn = function(){
  var token = auth.getToken();

  if(token){
    var payload = JSON.parse($window.atob(token.split('.')[1]));

    return payload.exp > Date.now() / 1000;
  } else {
    return false;
  }
};

auth.currentUser = function(){
  if(auth.isLoggedIn()){
    var token = auth.getToken();
    var payload = JSON.parse($window.atob(token.split('.')[1]));

    return payload.username;
  }
};
auth.register = function(user){
  return $http.post('/register', user).success(function(data){
    auth.saveToken(data.token);
  });
};

auth.logIn = function(user){
  return $http.post('/login', user).success(function(data){
    auth.saveToken(data.token);
  });
};

auth.logOut = function(){
  $window.localStorage.removeItem('flapper-news-token');
};
  return auth;
}]);

app.controller('AuthCtrl', [
'$scope',
'$state',
'auth',
function($scope, $state, auth){
  $scope.user = {};

  $scope.register = function(){
    auth.register($scope.user).error(function(error){
      $scope.error = error;
    }).then(function(){
      $state.go('home');
    });
  };

  $scope.logIn = function(){
    auth.logIn($scope.user).error(function(error){
      $scope.error = error;
    }).then(function(){
      $state.go('home');
    });
  };

}])


app.factory('posts',['$http','auth',function($http,auth){
	var o = {
		posts:[]
	};
 	o.getAll = function () {
          return $http.get(auth.baseUri + '/api/post/all').
	    then(function(response) {
		angular.copy(response.data.data, o.posts);
	  });
	};
	o.create = function(post) {
		return $http.post('/posts',post, {
			headers: {Authorization: 'Bearer' + auth.getToken() }
		}).success(function(data) {
			o.posts.push(data);
		});
	};
	o.upvote = function(post) {
	  return $http.put('/posts/' + post._id + '/upvote', null, {
	    headers: {Authorization: 'Bearer '+auth.getToken()}
	  }).success(function(data){
	    post.upvotes += 1;
	  });
	};

	o.get = function(id) {
	  return $http.get('/posts/' + id).then(function(res){
	    return res.data;
	  });
	};
	o.addComment = function(id,comment) {
		return $http.post('/posts/'+id + '/comments' , comment,
			{headers: {Authorization:'Bearer' +auth.getToken()}
		});
	};
	o.upvoteComment = function(post, comment) {
	  return $http.put('/posts/' + post._id + '/comments/'+ comment._id + '/upvote', null, {
		    headers: {Authorization: 'Bearer '+auth.getToken()}
		})
	    .success(function(data){
	      comment.upvotes += 1;
	    });
	};

	return o;
}]);

app.controller('NavCtrl', [
'$scope',
'auth',
function($scope, auth){
  $scope.isLoggedIn = auth.isLoggedIn;
  $scope.currentUser = auth.currentUser;
  $scope.logOut = auth.logOut;
}]);

app.controller('PostsCtrl', [
 '$scope','posts','post','auth',
 function($scope,posts,post,auth){
	$scope.post = post;
	$scope.isLoggedIn = auth.isLoggedIn;
	$scope.addComment = function(){
	  if($scope.body === '') { return; }
	  posts.addComment(post._id, {
	    body: $scope.body,
	    author: 'user',
	  }).success(function(comment) {
	    $scope.post.comments.push(comment);
	  });
	  $scope.body = '';
	};

	$scope.incrementUpvotes = function(comment){
	  posts.upvoteComment(post, comment);
	};

 }]);

app.controller('MainCtrl', [
'$scope','$http','posts','auth',
function($scope,$http,posts,auth){
  $scope.isLoggedIn = auth.isLoggedIn;
  $scope.posts = posts.posts;
  $scope.addPost = function(){
     if(!$scope.title || $scope.title == '') { return; }
     posts.create({title : $scope.title , link: $scope.link, upvotes : 0});
     $scope.title='';
     $scope.link='';
  };
  $scope.incrementUpvotes = function(post){
   post.upvotes+=1;
  };
}]);

app.controller('CafeTabController', [
'$scope','$timeout',
function($scope,$timeout){
	$scope.tabs = [{
						tab: 1,
            title: 'Cafe Menu',
            url: 'template/cafemenu.html'
        }, {
						tab: 2,
            title: 'Store Locator',
            url: 'template/storeLocator.html'
        }, {
						tab: 3,
            title: 'Schemes',
            url: 'template/schemes.html'
    		}, {
						tab: 4,
            title: 'About us',
            url: 'template/aboutUs.html'
  }];
	$scope.hovering = false;
	$scope.showIt = function () {
      timer = $timeout(function () {
          $scope.hovering = true;
      }, 100);
  };

  // mouseleave event
  $scope.hideIt = function () {
      $timeout.cancel(timer);
      $scope.hovering = false;
  };
	$scope.currentTab = 'template/cafemenu.html';

$scope.setTab = function(newTab){
	$scope.currentTab = newTab.url;
};

$scope.isSet = function(taburl){
	return $scope.currentTab == taburl;
};
}]);