'use strict';

var appControllers = angular.module('appControllers', []);

appControllers.controller('ProductCtrl', ['$scope', '$routeParams', 'productServices',
  function($scope, $routeParams, productServices) {
	// Get all products
	productServices.all(function(data) {
	  $scope.products = data.content;
	});
  }]
);

appControllers.controller('ProductDetailCtrl', ['$scope', '$routeParams', 'productServices',
  function($scope, $routeParams, productServices) {
	// Get product by id
	productServices.get($routeParams.id, function(data) {
	  $scope.product = data;
	});
  }]
);

appControllers.controller('InvoiceCtrl', ['$scope', '$routeParams', 'companyServices', 'productServices', 'invoiceServices',
  function($scope, $routeParams, companyServices, productServices, invoiceServices) {
	// Get all companies
	companyServices.all(function(data) {
	  $scope.companies = data.content;
	});

	// Get all products
	productServices.all(function(data) {
	  $scope.products = data.content;
	});

	// Get all invoices
	invoiceServices.all(function(data) {
	  $scope.invoices = data.content;
	});

	$scope.applyFilter = function(type) {
	  var companyId = $scope.selectCompany;
	  var productId = $scope.selectProduct;

	  // Filter result by company id
	  if (type == 'company') {
		$scope.selectProduct = 0;
		invoiceServices.allByCompanyId(companyId, function(data) {
		  $scope.invoices = data.content;
		});
	  }

	  // Filter result by product id
	  if (type == 'product') {
		$scope.selectCompany = 0;
		invoiceServices.allByProductId(productId, function(data) {
		  $scope.invoices = data.content;
		});
	  }
	};
  }]
);

appControllers.controller('InvoiceDetailCtrl', ['$scope', '$routeParams', 'invoiceServices',
  function($scope, $routeParams, invoiceServices) {
	// Get invoice by id
	invoiceServices.get($routeParams.id, function(data) {
	  $scope.invoice = data;
	});
  }]
);
