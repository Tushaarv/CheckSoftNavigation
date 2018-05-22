package com.tushar.CheckSoftNavigation;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class CheckSoftNavigation extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("isSoftNavigationAvailable")) {
            this.isSoftNavigationAvailable(callbackContext);
            return true;
        }
        if (action.equals("navigationBarHeight")) {
            this.navigationBarHeight(callbackContext);
            return true;
        }
        return false;
    }

    private void isSoftNavigationAvailable(CallbackContext callbackContext) {
        // boolean hasSoftKey = ViewConfiguration.get(this.cordova.getActivity()).hasPermanentMenuKey();
        if (isNavigationBarAvailable()) {
            callbackContext.success();
        } else {
            callbackContext.error("error");
        }
    }

    public boolean isNavigationBarAvailable(){

        boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
        boolean hasHomeKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_HOME);

        return (!(hasBackKey && hasHomeKey));
    }

    public void navigationBarHeight(CallbackContext callbackContext) {
        Resources resources = this.cordova.getActivity().getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();

        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int heightInPixels= resources.getDimensionPixelSize(resourceId);
        float heightInDP = heightInPixels / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);

        if (resourceId > 0) {
             callbackContext.success((int) heightInDP);
            }
        callbackContext.success(0);
    }
}
