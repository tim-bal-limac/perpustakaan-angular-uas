var cobaApp = angular.module('CobaApp', []);

cobaApp.controller('CobaController', function($scope, $http) {
	$scope.daftarNama = [];

	$scope.tambah = function() {
		$scope.daftarNama.push($scope.nama);

	};

	$scope.ambilData = function() {
		$http.get("/get-nama").then(sukses, gagal);

		function sukses(response) {
			$scope.user = response.data.nama;
		}

		function gagal(response) {
			console.log(response);
		}
	};

});