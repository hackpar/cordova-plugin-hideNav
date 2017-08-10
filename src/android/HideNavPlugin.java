package com.Qinxue.HideNav;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import android.util.DisplayMetrics;
import android.view.Display;
import java.lang.reflect.Method;
import android.view.WindowManager;
import android.view.View;
import android.view.Window;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class HideNavPlugin extends CordovaPlugin {


    private static final String TAG = "HideNav";

    /*
     * (non-Javadoc)
     *
     * @see org.apache.cordova.api.Plugin#execute(java.lang.String,
     * org.json.JSONArray, java.lang.String)
     */
    @Override
    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        LOG.v(TAG, "HideNav: initialization");
        super.initialize(cordova, webView);

    }

    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
            if("hideNav".equals(action)){
                hideNav(callbackContext);
            }
            if("showNav".equals(action)){
                callbackContext.success("show");
                showNav();
            }

        return false;
    }

	public void hideNav(final CallbackContext callbackContext) {

       cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);


              View decorView = cordova.getActivity().getWindow().getDecorView();
                  decorView.setSystemUiVisibility(
                          View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                          | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
	}
	public void showNav() {


       cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
	}


    private int getDpi(){
        int dpi = 0;
        Display display = cordova.getActivity().getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            dpi = dm.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dpi;
    }
}
