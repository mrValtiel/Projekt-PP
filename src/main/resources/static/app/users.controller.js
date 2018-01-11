(function (){
    'use strict';

    angular
        .module('app')
        .controller('UsersController', UsersController);

    UsersController.$inject = ['$http'];

    function UsersController($http){
        var vm = this;
        vm.users = [];
        vm.getAll = getAll;
        vm.getDeleted = getDeleted;
        vm.deleteUser = deleteUser;
        vm.addUser = addUser;

        init();

        function init(){
            getAll();
        }

        function addUser(){
            var url = "/users/create";
            $http.post(url).then(function(response){
                vm.users = response.data;
            });
        }

        function getAll(){
            var url = "/users/all";
            var usersPromise = $http.get(url);
            usersPromise.then(function(response){
                vm.users = response.data;
            });
        }

        function getDeleted(){
            var url = "/users/deleted";
            var usersPromise = $http.get(url);
            usersPromise.then(function(response){
                vm.users = response.data;
            });
        }

        function deleteUser(id){
            var url = "/users/remove/" + id;
            $http.post(url).then(function(response){
                vm.users = response.data;
            });
        }
    }
})();