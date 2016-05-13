materialAdmin.controller('RoleController', function($http, ngTableParams, SecurityService, $scope) {
	$scope.variables = {
		section : 'list',
		param : null,// 当前页面右上角全文检索参数
		roleTable : (function() {
			return new ngTableParams({
				count : 10,
				page : 1,
				sorting : {
					createTime : 'asc'
				}
			}, {
				getData : function($defer, params) {
					var sort = params.sorting(), orderBy = 'createTime', sortBy = 'asc';
					for (key in sort) {
						orderBy = key;
						sortBy = sort[key];
					}
					var obj = {
						pageNumber : params.page() - 1,
						pageSize : params.count(),
						param : $scope.variables.param,
						orderBy : orderBy,
						sortBy : sortBy
					};

					SecurityService.roles(obj).then(function(response) {
						generic.resolveResponse(response, function() {
							$scope.variables.roleTable.total(response.data.totalElements);
							$defer.resolve(response.data.data);
						});
					}, function(response) {
						generic.resolveResponse(response);
					});
				}
			});
		})()
	};

	this.search = function() {
		$scope.variables.roleTable.parameters().page = 1;
		$scope.variables.roleTable.reload();
	};

	this.toNewRolePage = function() {
		$scope.variables.section = "view";
	};
});