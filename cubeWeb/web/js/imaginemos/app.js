/**
 * js encargado de la construccion de casos de prueba para el problema Cube Summation
 * @type @exp;angular@call;module
 */
var cuboApp = angular.module("cubeApp", ['ui.bootstrap']);
cuboApp.controller("ControllerCubeApp", ['$scope', '$http', function ($scope, $http) {
        $scope.cases = [];
        $scope.numCases = 0;
        $scope.numOperations = 0;
        $scope.operations = [];
        $scope.results=[];
        $scope.n;
        $scope.operationType = 1;
        $scope.operation = {};
        $scope.color = '';
        $scope.queryObject = {type: 1, x1: "", x2: "", y1: "", y2: "", z1: "", z2: ""};
        $scope.updateObject = {type: 2, x: "", y: "", z: "", value: ""};
        $scope.operationsTypes = [{id: 1, name: 'QUERY'}, {id: 2, name: 'UPDATE'}];
        $scope.alerts = [];
        /**
         * funcion ecnargada de agregar una operacion de tipo consulta
         * @returns {void}
         */
        $scope.addQuery = function () {
            $scope.alerts = [];
            if ($scope.constraints() || $scope.constraintsQuery()) {
                return;
            }
            $scope.operations[$scope.numOperations] = angular.copy($scope.queryObject);
            $scope.numOperations++;
            $scope.queryObject = {type: 1, x1: "", x2: "", y1: "", y2: "", z1: "", z2: ""};
            $scope.color = '#ddd';
            $scope.results=[];

        };
        /**
         * funcion que construlle una validacion boolena y retorna el valor de la ejecucion
         * @param {long} valor
         * @param {long} valor1
         * @param {String} operador
         * @returns {Boolean}
         */
        $scope.validar = function (valor, valor1, operador) {
            var condition = valor + " " + operador + " " + valor1;
            return eval(condition);
        };
        /**
         *  funcion encarga de validar rangos y construir el mensaje de error
         * @param {String} name
         * @param {String} name1
         * @param {long} value
         * @param {long} value1
         * @param {String} operador
         * @returns {Boolean}
         */
        $scope.validador = function (name, name1, value, value1, operador) {
            if (isNaN(value1) || value1.toString().trim() === '') {
                $scope.alerts.push({type: 'danger', msg: name1 + ' is required'});
            } else if (isNaN(value) || value.toString().trim() === '') {
                $scope.alerts.push({type: 'danger', msg: name + ' is required'});
            } else if (operador === '>' && !$scope.validar(value, value1, operador)) {
                $scope.alerts.push({type: 'danger', msg: name + ' must be greater than ' + name1});
            } else if (operador === '>=' && !$scope.validar(value, value1, operador)) {
                $scope.alerts.push({type: 'danger', msg: name + ' must be greater or equal to ' + name1});
            } else if (operador === '<' && !$scope.validar(value, value1, operador)) {
                $scope.alerts.push({type: 'danger', msg: name + ' should be less than ' + name1});
            } else if (operador === '<=' && !$scope.validar(value, value1, operador)) {
                $scope.alerts.push({type: 'danger', msg: name + ' must be less or equal to ' + name1});
            } else {
                return true;
            }
            return false;
        };
        /**
         *  funcion encargada de realizar la validacion de constraints para las querys
         * @returns {Boolean}
         */
        $scope.constraintsQuery = function () {
            var add = true;
            add = add & $scope.validador('x1', '1', $scope.queryObject.x1, 1, '>=');
            add = add & $scope.validador('y1', '1', $scope.queryObject.y1, 1, '>=');
            add = add & $scope.validador('z1', '1', $scope.queryObject.z1, 1, '>=');
            add = add & $scope.validador('x2', '1', $scope.queryObject.x2, 1, '>=');
            add = add & $scope.validador('y2', '1', $scope.queryObject.y2, 1, '>=');
            add = add & $scope.validador('z2', '1', $scope.queryObject.z2, 1, '>=');
            add = add & $scope.validador('x1', 'N', $scope.queryObject.x1, $scope.n, '<=');
            add = add & $scope.validador('y1', 'N', $scope.queryObject.y1, $scope.n, '<=');
            add = add & $scope.validador('z1', 'N', $scope.queryObject.z1, $scope.n, '<=');
            add = add & $scope.validador('x2', 'N', $scope.queryObject.x2, $scope.n, '<=');
            add = add & $scope.validador('y2', 'N', $scope.queryObject.y2, $scope.n, '<=');
            add = add & $scope.validador('z2', 'N', $scope.queryObject.z2, $scope.n, '<=');
            add = add & $scope.validador('x1', 'x2', $scope.queryObject.x1, $scope.queryObject.x2, '<=');
            add = add & $scope.validador('y1', 'y2', $scope.queryObject.y1, $scope.queryObject.y2, '<=');
            add = add & $scope.validador('z1', 'z2', $scope.queryObject.z1, $scope.queryObject.z2, '<=');
            return !add;
        };
        /** 
         * funcion encargada de realizar el chequeo de las restricciones generales
         * @returns {Boolean}
         */
        $scope.constraints = function () {
            if ($scope.numOperations >= 50) {
                $scope.alerts.push({type: 'danger', msg: '1<= cases <=50'});
            }
            if ($scope.n < 1 || $scope.n > 100) {
                $scope.alerts.push({type: 'danger', msg: '1<= N <=100'});
            } else {
                return false;
            }
            return true;
        };
        /**
         * funcion que valida las restricciones para realizar un update
         * @returns {Boolean}
         */
        $scope.constraintsUpdate = function () {
            var add = true;
            add = add & $scope.validador('x', '1', $scope.updateObject.x, 1, '>=');
            add = add & $scope.validador('y', '1', $scope.updateObject.y, 1, '>=');
            add = add & $scope.validador('z', '1', $scope.updateObject.z, 1, '>=');
            add = add & $scope.validador('x', 'N', $scope.updateObject.x, $scope.n, '<=');
            add = add & $scope.validador('y', 'N', $scope.updateObject.y, $scope.n, '<=');
            add = add & $scope.validador('z', 'N', $scope.updateObject.z, $scope.n, '<=');
            add = add & $scope.validador('VALUE', '10000000000', $scope.updateObject.value, 10000000000, '<=');
            add = add & $scope.validador('VALUE', '-10000000000', $scope.updateObject.value, -10000000000, '>=');
            return !add;
        };
        /**
         * funcion que se encarga de crear una operacion para actualizar un valor del cubo
         * @returns {undefined}
         */
        $scope.addUpdate = function () {
            $scope.alerts = [];
            if ($scope.constraints() || $scope.constraintsUpdate()) {
                return;
            }
            $scope.operations[$scope.numOperations] = angular.copy($scope.updateObject);
            $scope.numOperations++;
            $scope.updateObject = {type: 2, x: "", y: "", z: "", value: ""};
            $scope.color = '#ddd';
            $scope.results=[];

        };
        /**
         * funcion encarga de adicionar un caso de prueba
         * @returns {void}
         */
        $scope.addCase = function () {
            if ($scope.constraints()) {
                return;
            }
            if ($scope.numOperations > 0) {
                var opString = [];
                for (var i = 0; i < $scope.operations.length; i++) {
                    if ($scope.operations[i].type === 1) {
                        opString[i] = "QUERY "
                                + $scope.operations[i].x1 + " "
                                + $scope.operations[i].y1 + " "
                                + $scope.operations[i].z1 + " "
                                + $scope.operations[i].x2 + " "
                                + $scope.operations[i].y2 + " "
                                + $scope.operations[i].z2;
                    } else if ($scope.operations[i].type === 2) {
                        opString[i] = "UPDATE "
                                + $scope.operations[i].x + " "
                                + $scope.operations[i].y + " "
                                + $scope.operations[i].z + " "
                                + $scope.operations[i].value;
                    }
                }
                $scope.cases[$scope.numCases] = {n: angular.copy($scope.n), operations: opString};
                $scope.numCases++;
                $scope.operations = [];
                $scope.updateObject = {type: 2, x: "", y: "", z: "", value: ""};
                $scope.queryObject = {type: 1, x1: "", x2: "", y1: "", y2: "", z1: "", z2: ""};
                $scope.n = 0;
                $scope.numOperations = 0;
                $scope.color = '';
            } else {
                $scope.alerts.push({type: 'danger', msg: ' case is required '});
            }

        };
        /**
         * funcion que se encarga de cerrar las notificaciones de alerta.
         * @param {int} index
         * @returns {void}
         */
        $scope.closeAlert = function (index) {
            $scope.alerts.splice(index, 1);
        };
        /**
         * funcion encargada de realizar las operaciones de casos de prueba
         * @returns {void}
         */
        $scope.calculate = function () {
            if ($scope.numCases > 0) {

            } else {
                $scope.alerts.push({type: 'danger', msg: ' case is required '});
            }
        };

    }]);
