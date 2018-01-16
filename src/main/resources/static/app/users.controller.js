(function (){
    'use strict';

    angular
        .module('app')
        .controller('UsersController', UsersController);

    UsersController.$inject = ['$http'];

    function UsersController($http) {
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

        /* function addUser(){
            var url = "/users/create";
            $http.post(url).then(function(response){
                vm.users = response.data;
            });
        } */

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

        /* NOT WORKING */
        function addUser() {
            console.log("Button clicked, script works");

            var _name = document.getElementById("_name");
            console.log("Input name: " + _name);
            var _surname = document.getElementById("_name");
            console.log("Input surname: " + _surname);
            var _birthDay = document.getElementById("_birthDay");
            console.log("Input birthDay: " + _birthDay);
            var _login = document.getElementById("_login");
            console.log("Input login: " + _login);

            var User = {
                name: _name,
                surname: _surname,
                birthDay: _birthDay,
                login: _login
            };

            var url = "/users/create";
            $http.post(url).then(function (response) {
                vm.users = response.data;
            });
        }
    }

})();
