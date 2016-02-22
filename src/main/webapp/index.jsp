<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Company Information!!</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script src="resources/js/companyInfo.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/company.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>
<body>
	
	<div class="container" ng-app="companyApp" ng-controller="companyController">
		<div >
			<h3>
				<span class="label label-default">Available functions</span><BR><BR>
				<input type="button" class="btn btn-danger" value="Add Company" ng-click="setFunction('addCompany')"><BR><BR>
				<input type="button" class="btn btn-danger" ng-click="setFunction('getAllCompanies');getAllCompanies()" value="Get all companies list"><BR><BR>
				<input type="button" class="btn btn-danger" ng-click="setFunction('getCompanyDetails')" value="Get company details"><BR><BR>
				<input type="submit" class="btn btn-danger" ng-click="setFunction('addBeneficialOwners');updateBeneficialOwners()" value="Update beneficiery owners"><BR><BR>
			</h3>
		</div>
		<div>
	        <div class="row" ng-show="operation=='getCompanyDetails' || operation=='updateCompany' || operation=='addBeneficialOwners'">
		        <label class="col-xs-2" for="username">Enter Company Id : </label>
			    <input class="col-xs-5 form-control" type="text" name="companyId" id="companyId" ng-model="companyId" />
			    <input type="button" class="btn btn-danger" ng-click="getCompanyDetails()" value="Get details" />			    
			</div>
		</div>
		<div id="addCompanyDiv" ng-show="showCompanyDiv">
			<div class="col-md-6 col-md-offset-3">
    			<h2>Company</h2>
			    <form name="form" role="form">
			        <div class="form-group">
			        	<table class="table table-striped table-bordered">
			        	<tr><td width="100px">
			            <label for="username">Company Id : </label>
			            <input type="text" name="companyId" id="companyId" class="form-control" ng-model="company.companyId" ng-disabled="operation=='addBeneficialOwners'" required />
			            </td></tr><tr><td width="100px">
			            <label for="username">Company Name : </label>
			            <input type="text" name="companyName" id="companyName" class="form-control" ng-model="company.companyName" ng-disabled="operation =='addBeneficialOwners'" required />
			        	</td></tr><tr><td width="100px">
			            <label>Address : </label>
			            <input type="text" name="address" id="address" class="form-control" ng-model="company.address" ng-disabled="operation =='addBeneficialOwners'" required />
			        	</td></tr><tr><td width="100px">
			            <label>City : </label>
			            <input type="text" name="city" id="city" class="form-control" ng-model="company.city" ng-disabled="operation =='addBeneficialOwners'" required />
			        	</td></tr><tr><td width="100px">
			            <label>Country : </label>
			            <input type="text" name="country" id="coountry" class="form-control" ng-model="company.country" ng-disabled="operation =='addBeneficialOwners'" required />
			        	</td></tr><tr><td width="100px">
			            <label>Email : </label>
			            <input type="text" name="email" id="email" class="form-control" ng-model="company.email" ng-disabled="operation =='addBeneficialOwners'" />
			        	</td></tr><tr><td width="100px">
			            <label>Phone Number : </label>
			            <input type="text" name="phoneNumber" id="phoneNumber" class="form-control" ng-model="company.phoneNumber" ng-disabled="operation =='addBeneficialOwners'" />
			        	</td></tr><tr><td width="100px">
			            <label>Beneficial Owners : </label>
			            <input type="text" name="beneficialOwners" id="beneficialOwners" class="form-control" ng-model="company.beneficialOwners" />
			            </td></tr>
			            </table>
			        </div>
			        <div>
			            <button type="submit" ng-click="submitDetails()" class="btn btn-primary" ng-hide="operation != 'addCompany'">Submit</button>
			            <input type="submit" class="btn btn-danger" ng-click="setFunction('updateCompany');updateCompanyDetails()" ng-hide="operation == 'addCompany'" value="Update">
			        </div>
			    </form>
			</div>
		</div>
		<div id="companyListDiv" ng-show="companyList">
			<table class="table table-striped table-bordered">
				<thead>
					<th>Company ID</th>
					<th>Company Name</th>
					<th>Address</th>
					<th>City</th>
					<th>Country</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Beneficial Owners</th>
				</thead>
				<tr ng-repeat="company in companyList">
					<td>{{company.companyId}}</td>
					<td>{{company.companyName}}</td>
					<td>{{company.address}}</td>
					<td>{{company.city}}</td>
					<td>{{company.country}}</td>
					<td>{{company.email}}</td>
					<td>{{company.phoneNumber}}</td>
					<td>{{company.beneficialOwners}}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
