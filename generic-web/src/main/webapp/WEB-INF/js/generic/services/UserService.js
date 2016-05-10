materialAdmin.service('UserService', [ '$http', '$q', function($http, $q) {
	var user = {
		resources : undefined
	};
	return {
		resources : function() {
			var deferred = $q.defer();
			if (user.resources) {
				deferred.resolve({
					data : user.resources
				});
			} else {
				$http.get('generic/system/personalresources').then(function(response) {
					deferred.resolve(response);
				}, function(error) {
					deferred.reject(error);
				});
			}
			return deferred.promise;
		}
	};
} ])