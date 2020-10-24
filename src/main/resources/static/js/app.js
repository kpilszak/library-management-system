var app = angular.module("MyApp", []);

var app = angular.module("Search", ['ui.bootstrap']).controller("SearchController",
    function($scope, $http) {
        // it's for default check box thing...
        $scope.books = "getBooks";
        $scope.rounds = 5;
        $scope.getBooks = "Search all Book Details";
        $scope.count = "No of Books";
        $scope.addBook = "Add New Book";
        $scope.delBook = "Delete Existing Book";
        $scope.borrowBook = "Booking";
        $scope.cancelBorrow = "Cancel Booking";
        $scope.bookCart = [{
            'isbn': '',
            'title': '',
            'cover': '',
            'publisher': '',
            'pages': '',
            'available': ''
        }];
        $scope.delCart = [];
        $scope.orderCart = {
            'booking_id': "",
            'isbn': "isbn",
            'booking_date': "",
            'quantity': "quantity"
        };
        $scope.cancelCart;
        $scope.search = function() {
            var choice = $scope.books;
            $scope.searchBook = false;
            $scope.addBookFlag = false;
            $scope.countFlag = false;
            $scope.delBookFlag = false;
            $scope.displayStandardMessage = false;
            $scope.displayError = false;
            $scope.borrowFlag = false;
            $scope.cancelBooking = false;
            $scope.displayBookingSucess = false;
            $scope.displayCancelSucess = false;
            // Pagination Logic
            if (choice == 'getBooks') {
                $scope.searchBook = true;
                var url = 'http://localhost:8080/api/' + choice;
                $http.get(url).
                then(function(response) {
                    $scope.output = response.data;
                    pagination();
                });
            } else if (choice == 'addBook') {
                // clear before adding books....
                clear();
                $scope.addBookFlag = true;

            } else if (choice == 'delBook') {
                $scope.delBookFlag = true;
                searchBooks();

            } else if (choice == 'count') {
                $scope.countFlag = true;

            } else if (choice == 'borrowBook') {
                $scope.borrowFlag = true;
                loadBooks();

            } else if (choice == 'cancelBorrow') {
                $scope.cancelBooking = true;
                loadBookedThings();

            } else {
                $scope.searchBook = true;
                var url = 'http://localhost:8080/api/' + choice;
                $http.get(url).
                then(function(response) {
                    $scope.output = response.data;
                });
            }
        }