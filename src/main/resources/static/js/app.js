var app = angular.module('app', ['ngRoute','ngResource']);

app.config(function($routeProvider){
    $routeProvider
      // .when('/', {
    	//   templateUrl: '/views/home.html',
    	//   controller: 'HomeController'
    	//})
		.when('/comments', {
			templateUrl: 'views/comments.html',
			controller: 'CommentsController'
		})
		.when('/resume', {
			templateUrl: 'views/resume.html',
			
		})
		.when('/user/:id/edit', {
			templateUrl: 'views/user/navEditUser.html',
			controller: 'UserController'
		})
		.when('/server/view', {
			templateUrl: 'views/server/viewServers.html',
			controller: 'ServerController'
		})
		.when('/server/:id/edit', {
			templateUrl: 'views/server/navEditServer.html',
			controller: 'ServerController'
		})
		.when('/server/:id/delete', {
			templateUrl: 'views/server/deleteServer.html',
			controller: 'ServerController'
		})
		.when('/backup/view', {
			templateUrl: 'views/backup/viewBackups.html',
			controller: 'BackupController'
		})
		.when('/backup/:id/edit', {
			templateUrl: 'views/backup/navEditBackup.html',
			controller: 'BackupController'
		})
		.when('/backup/:id/delete', {
			templateUrl: 'views/backup/deleteBackup.html',
			controller: 'BackupController'
		})
       .otherwise(
            { redirectTo: '/'}
        );
});

