var CheckSoftNavigation = (function() {

    var CheckSoftNavigation = {};

    CheckSoftNavigation.isSoftNavigationAvailable = function(success, error) {
        return cordova.exec(success, error, "CheckSoftNavigation", "isSoftNavigationAvailable", []);
    };

    CheckSoftNavigation.navigationBarHeight = function(success, error) {
        return cordova.exec(success, error, "CheckSoftNavigation", "navigationBarHeight", []);
    };

    return CheckSoftNavigation;
});

module.exports = new CheckSoftNavigation();