var appny = angular.module('webApp',[]);

appny.controller('controllerP', function($http) {
	
	var smaweb = this;
		
	smaweb.latestPro = [];
	smaweb.latestBlog = [];
	smaweb.activeblogs = [];
	
	smaweb.fetchData = function() {
		
		//fetching list of latest active projects
		$http.get('/smaholdings/json/data/latestprojects/projects')
			.then(function(response) {
				smaweb.latestPro = response.data;
		});
			
		//fetching latest list of blogs
		$http.get('/smaholdings/json/data/latestblogs/blogs')
		.then(function(response) {
			smaweb.latestBlog = response.data;
		});
		
		//fteching list of active blogs
		$http.get('/smaholdings/json/data/activeblogs')
		 .then(function(response){
			 smaweb.activeblogs = response.data; 
		 });
		
				
	}
	
	
	
	
	
});