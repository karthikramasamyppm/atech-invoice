'use strict';

var app = angular.module('app', [
  'ngRoute',
  'appControllers',
  'appServices'
]);

app.config(['$routeProvider', '$locationProvider',
  function($routeProvider, $locationProvider) {

    $routeProvider.
      when('/', {
        templateUrl: 'views/products.html',
        controller: 'ProductCtrl'
      }).
      when('/products', {
        templateUrl: 'views/products.html',
        controller: 'ProductCtrl'
      }).
      when('/products/:id', {
        templateUrl: 'views/product-details.html',
        controller: 'ProductDetailCtrl'
      }).
      when('/invoices', {
        templateUrl: 'views/invoices.html',
        controller: 'InvoiceCtrl'
      }).
      when('/invoices/:id', {
        templateUrl: 'views/invoice-details.html',
        controller: 'InvoiceDetailCtrl'
      }).
      otherwise({
        redirectTo: '/'
      });

  }]
);
