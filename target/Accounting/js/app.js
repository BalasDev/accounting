'use strict';
var app = angular.module('Accounting', ['ngMaterial','ngMessages','ngRoute']);
app.config(['$routeProvider','$httpProvider',
	function($routeProvider,$httpProvider) {
		 $routeProvider.
          when('/login', {
          templateUrl: 'login.html',
          controller: 'LoginController'
        }).
         when('/', {
             templateUrl: 'home.html',
             controller: 'HomeController'
         }).
         when('/reg', {
             templateUrl: 'registration.html',
             controller: 'RegController'
         }).
         when('/logout', {
             templateUrl: 'home.html',
             controller: 'LogoutController'
         }).
         otherwise({
             redirectTo: '/'
         });

        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
       /* $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';*/
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/json';
    }
])
app.controller('HomeController', ['$scope','$http', function($scope,$http){
    $http.get('/roles')
    .success(function (data) {
        $scope.roles = data;

    });
}]);
app.controller('RegController', ['$scope','$http',function($scope,$http){

    $scope.reg = function () {
        /*var data =
            {
                'firstName':$scope.user.firstName,
                'secondName': $scope.user.secondName,
                'lastName' : $scope.user.lastName,
                'login' : $scope.user.login,
                'password' : $scope.user.password,
                'birthday' : $scope.user.birthday
            }
        ;*/
        var personalInformation =
         {
         'firstName':$scope.user.firstName,
         'secondName': $scope.user.secondName,
         'lastName' : $scope.user.lastName,
         'birthday' : $scope.user.birthday
         }
         ;
        var data =
         {

         'login' : $scope.user.login,
         'password' : $scope.user.password,
         'email' : $scope.user.email,
         'personalInformation' : {
             'firstName':$scope.user.firstName,
             'secondName': $scope.user.secondName,
             'lastName' : $scope.user.lastName,
             'birthday' : $scope.user.birthday
          }
         }
         ;

        /*var data =
            'firstName=' + $scope.user.firstName; +
            '&secondName=' + $scope.user.secondName +
            '&lastName=' + $scope.user.lastName +
            '&login=' + $scope.user.login +
            '&password=' + $scope.user.password;*/



        $http.post('/register', data)
            .success(function (data, status, headers, config) {

            });
    }
}]);
app.controller('LoginController', ['$scope','$http',function($scope,$http) {

    $scope.login = function () {
        if ($scope.user) {
            var data = 'username=' + $scope.user.login + '&password=' + $scope.user.password;

           /* var data =
                {
                    'username': $scope.user.login,
                    'password': $scope.user.password
                };*/
            $http.post('/authenticate', data,{headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                }}
                )
                .success(function (data, status, headers, config) {
                    $scope.authenticated = data.name;/*$scope.user.login;*/
                }).error(function (data, status, header, config) {
                $scope.authenticated = data.message;
            });
        }
    }
    /*
     var headers =  {
     authorization : "Basic "
     + btoa($scope.user.login + ":"
     + $scope.user.password)
     }

     $http.get('user', {
     headers : headers
     }).success(function(data) {
     $scope.authenticated = data.name;
     })
     }*/
    /*$http.get('/authenticate',{
     params:{login:"user",password:"user"}})
     .success(function (data){
     $scope.authenticated = true;
     });*/
    $scope.logout = function () {


    /*.finally(function() {
     $rootScope.authenticated = false;
     $location.path("/");
     });*/
}
}]);
app.controller('LogoutController', ['$scope','$http',function($scope,$http) {
    $http.post('/logout');
}]);





