var bkApp= angular.module('BkApp', []);

bkApp.controller('BkController', 
    function($scope, $http, $window) {
        $scope.daftarBk = [];
        $scope.updateDaftarBk = function(){
            $http.get('/daftar-buku').then(sukses, gagal);
            
            function sukses(response){
            	console.log(response);
            	//isidata mahasiswa
            	$scope.daftarBk = response.data;
            };
            function gagal(response){
            	console.log(response);
        	};
        };

        $scope.ubah = function(bk){
            //console.log(mhs);
            $window.location.href="/form-edit?id=" + bk.id;
        };
        
        $scope.hapus = function(bk){
            $http.delete('/hapus-data/' + bk.id).then(sukses, gagal);

            function sukses(response){
                $scope.updateDaftarBk();
            } ;

            function gagal(response){
                console.log(response);
            } ;
        };

        $scope.keluar = function() {
            $http.get('/keluar').then(sukses, gagal);

            function sukses(response){
                $window.location.href="/";
                
                
            };
            function gagal(response){
                console.log(response);
            };
        

        };

        $scope.updateDaftarBk();
    });
bkApp.controller('FormController', 
    function($scope, $http, $window){
        $scope.simpan = function() {
            $http.post('/tambah-bk', $scope.bk).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
        };

        $scope.batal = function() {
            $window.location.href = '/';
        };
    });