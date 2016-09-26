'use strict';

var appServices = angular.module('appServices', []);

appServices.factory('companyServices', ['$http',
  function($http) {
    return {
      all: function(success, error) {
        $http.get('/api/companies').success(success).error(error)
      }
    };
  }]
);

appServices.factory('productServices', ['$http',
  function($http) {
    return {
      get: function(id, success, error) {
        $http.get('/api/products/' + id).success(success).error(error)
      },
      all: function(success, error) {
        $http.get('/api/products').success(success).error(error)
      }
    };
  }]
);

appServices.factory('invoiceServices', ['$http',
  function($http) {
    return {
      get: function(id, success, error) {
        $http.get('/api/invoices/' + id).success(success).error(error)
      },
      all: function(success, error) {
        $http.get('/api/invoices').success(success).error(error)
      },
      allByCompanyId: function(companyId, success, error) {
        $http.get('/api/invoices?companyId=' + companyId).success(success).error(error)
      },
      allByProductId: function(productId, success, error) {
        $http.get('/api/invoices?productId=' + productId).success(success).error(error)
      }
    };
  }]
);
