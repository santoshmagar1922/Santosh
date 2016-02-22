angular.module('companyApp', []);

angular.module('companyApp').controller('companyController', function ($scope, $http) {

	$scope.company = {};
	$scope.companyList = null;
	$scope.companyId;
	$scope.operation = {};
	$scope.baseURL = '/CompInfo/';
	$scope.showCompanyDiv = false;
	
	
	$scope.setFunction = function(operationName) {
		$scope.operation = operationName;
		
		if($scope.operation == 'addCompany') {
			$scope.company = {};
			$scope.companyList = null;
			$scope.showCompanyDiv = true;
		} else if($scope.operation == 'getAllCompanies') {
			$scope.showCompanyDiv = false;
		} else if ($scope.operation =='getCompanyDetails' || $scope.operation=='updateCompany') {
		//	$scope.company = {};
			$scope.companyList = null;
			$scope.showCompanyDiv = false;
		} else if($scope.operation =='addBeneficialOwners') {
			$scope.showCompanyDiv = false;
		}
	};
	
	$scope.submitDetails = function() {
		var url = $scope.baseURL + $scope.operation;
		if($scope.operation == 'updateCompany' || $scope.operation == 'addBeneficialOwners') {
			url = url + '/' + $scope.companyId;
		}
		var responsePromise = postData(url,$scope.company);
		responsePromise.success(function(data, status, headers, config) {
			alert("Operation successful : " + $scope.company.companyId);
		});
		responsePromise.error(function(data, status, headers, config) {
			alert("Sorry.Couldn't add company!");
	    });
	};
	
	$scope.getAllCompanies = function() {
		var responsePromise = $http.get($scope.baseURL + $scope.operation);
	    responsePromise.success(function(data, status, headers, config) {
	    	$scope.companyList = data.data;
	    });
	    responsePromise.error(function(data, status, headers, config) {
			alert("Unable to get data!");
	    });
	};
	
	$scope.getCompanyDetails = function() {
		
		var url = $scope.baseURL + 'getCompanyDetails' + '/' + $scope.companyId;
		var responsePromise = $http.get(url);
	    responsePromise.success(function(data, status, headers, config) {
	    	$scope.company = data.data;
	    	if($scope.operation=='getCompanyDetails' || $scope.operation=='updateCompany' || $scope.operation=='addBeneficialOwners') {
				$scope.showCompanyDiv = true;
			}
	    });
	    responsePromise.error(function(data, status, headers, config) {
			alert("Unable to get data!");
			$scope.showCompanyDiv = false;
	    });
	};
	
	$scope.updateCompanyDetails = function() {
		//$scope.operation = '';
		var url = $scope.baseURL + $scope.operation + '/' + $scope.companyId;
		var responsePromise = postData(url,$scope.company);
	    responsePromise.success(function(data, status, headers, config) {
	    	$scope.company = data.data;
	    });
	    responsePromise.error(function(data, status, headers, config) {
			alert("Unable to get data!");
	    });
	};

	$scope.updateBeneficialOwners = function() {
		//$scope.operation = '';
		var url = $scope.baseURL + $scope.operation + '/' + $scope.companyId;
		var responsePromise = postData(url,$scope.company);
	    responsePromise.success(function(data, status, headers, config) {
	    	$scope.company = data.data;
	    });
	    responsePromise.error(function(data, status, headers, config) {
			alert("Unable to get data!");
	    });
	};
	
	function postData(url,data) {
		
		var response = $http({
						url: url, 
						method: "POST",
						data: angular.toJson(data),
						headers: {'Content-Type': 'application/json'}
					});
		return response;
	}
	
});
