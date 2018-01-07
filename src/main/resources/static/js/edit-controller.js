bkApp.controller('EditController',
	function($scope, $window, $http){


		$scope.bk={};

		$scope.simpan = function() {
			$http.post('/tambah-buku', $scope.bk).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.batal = function() {
			$window.location.href = "/";
		};

		$scope.updateById = function() {
			id=$window.location.search.split('=')[1];
			console.log(id);
			//$scope.bk.id = id;

			$http.get("/get-bk-by-id/" + id).then(sukses, gagal);

			function sukses(response){
                //$window.location.href = '/';
                $scope.bk = response.data;
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.updateById();

	});