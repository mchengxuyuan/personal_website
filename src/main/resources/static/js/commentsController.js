app
		.controller(
				'CommentsController',
				function($scope, $http, $location, $routeParams) {

					var urlBase = "";
					// $scope.toggle = true;
					$scope.selection = [];
					$scope.statuses = [ 'ACTIVE', 'COMPLETED' ];
					$scope.priorities = [ 'HIGH', 'LOW', 'MEDIUM' ];
					$http.defaults.headers.post["Content-Type"] = "application/json";
					// $scope.comments=undefined;
					// $scope.userPropertyName = 'user_NAME';
					$scope.reverse = false;

					$scope.getComments = function() {
						$http.get(urlBase + '/getAllComments').success(
								function(data) {
									$scope.comments = data;
									
									$location.path('/comments');
								});
					}

				
					// CSV Report Generation
					$scope.generateUserCSVReport = function() {
						$http
								.get(urlBase + '/generateUserCSVReport')
								.success(
										function(data) {

											$scope.genCsvStatus = data;
											$scope.isUserCSVReportSuccess = $scope.genCsvStatus.isSuccess;
											$scope.userCsvFilePath = $scope.genCsvStatus.filePath
													+ $scope.genCsvStatus.fileName;
										});
					}

					// Dynamic Sort operation
					$scope.sortUserBy = function(userPropertyName) {

						$scope.reverse = ($scope.userPropertyName === userPropertyName) ? !$scope.reverse
								: false;
						$scope.userPropertyName = userPropertyName;

					};

					// Summit Comments
					$scope.saveComments = function(comment) {

						if (isUnvalid(comment.comments)) {
							return;
						}
						comment.time = Date.parse(new Date());
						if (comment.id === undefined) {

							$http.post(urlBase + '/addComments', comment)
									.success(function(data) {
										$scope.isSaveSuccess = data;
										if (data) {
											$scope.comments.push(comment);
										}
									});

						}

					}

					function isUnvalid(field) {

						if (field === undefined) {
							$scope.isInValid = true;
							$scope.validationMessage = "Massage cannot be blank";
							return true;

						} else if (field.length > 200) {
							$scope.isInValid = true;
							$scope.validationMessage = "Massage limit to 200 letters";
							return true;
						} else {
							$scope.isInValid = false;
							return false;
						}
					}
					
					$scope.showResume=function()
					{
						$location.path('/resume');
					}
					// Load the Google Map view for all users
					$scope.getUserMapCountView = function() {

						$location.path('/user/mapcountview');
					}

					// Loads all Static data from database
					$scope.initStaticDataList = function() {

						$http.get(urlBase + '/loadAllStaticData', {
							cache : true
						}).success(function(data) {

							$scope.userStaticData = data;
						});

					}
				});
