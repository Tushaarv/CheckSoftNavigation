# CheckSoftNavigation

# Overview
This Cordova plugin for Android is used to check if the mobile device has a softkeyboard.



#### Example usage

### isSoftNavigationAvailable

              cordova.plugins.CheckSoftNavigation.isSoftNavigationAvailable(
                 function() {
                     console.log("Soft Navigation Bar Present");
                 }, 
                 function(){
                    console.log("Soft Navigation Bar Absent");
                 });


### navigationBarHeight
            cordova.plugins.CheckSoftNavigation.navigationBarHeight(
                 function(height) {
                     console.log("Height Value: " + height);
                 }, 
                 function(){
                    console.log("Error");
                 });
