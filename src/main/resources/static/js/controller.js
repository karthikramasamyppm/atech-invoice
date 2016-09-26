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

appControllers.controller('InvoiceCtrl', ['$scope', '$routeParams', 'invoiceServices',
  function($scope, $routeParams, invoiceServices) {
	// Get all invoices
	invoiceServices.all(function(data) {
	  $scope.invoices = data.content;
	});
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
