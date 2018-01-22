'use strict';

angular
    .module('app')
    .controller('UsersController', UsersController);

function UsersController($scope, $http) {
    var vm = this;
    vm.users = [];
    vm.getAll = getAll;
    vm.getDeleted = getDeleted;
    vm.deleteUser = deleteUser;
    vm.addUser = addUser;

    init();

    function init() {
        getAll();
    }

        function addUser(){
            var url = "/users/create";
            console.log("Trying to add new user");
            var data = {
                name: $scope.name,
                surname: $scope.surname,
                birthDay: $scope.birthDay,
                login: $scope.login
            }
            console.log(data);

            $http.post(url, data).then(function(response){
                vm.users = response.data;
            });

            document.getElementById("inputName").value = "";
            document.getElementById("inputSurname").value = "";
            document.getElementById("inputBirthDay").value = "";
            document.getElementById("inputLogin").value = "";
        }

        function getAll() {
            var url = "/users/all";
            var usersPromise = $http.get(url);
            usersPromise.then(function (response) {
                vm.users = response.data;
            });
        }

        function getDeleted() {
            var url = "/users/deleted";
            var usersPromise = $http.get(url);
            usersPromise.then(function (response) {
                vm.users = response.data;
            });
        }

        function deleteUser(id) {
            var url = "/users/remove/" + id;
            $http.post(url).then(function (response) {
                vm.users = response.data;
            });
        }
}
