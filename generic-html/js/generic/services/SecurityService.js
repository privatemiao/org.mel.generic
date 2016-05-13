materialAdmin.service('SecurityService', [ '$http', '$q', function($http, $q) {

	return {
		/**
		 * obj = {param : search param, pageNumber : base on zore, pageSize :
		 * size of page}
		 */
		roles : function(obj) {
			console.log('SecurityService.js >> roles >>', JSON.stringify(obj));
			var deferred = $q.defer();
			$http.post('generic/system/roles', obj).then(function(response) {
				deferred.resolve(response);
			}, function(response) {
				deferred.reject(response);
			});
			return deferred.promise;

		}
	};

} ])