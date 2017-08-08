package com.artraktiv.NavHide;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import android.util.DisplayMetrics;
import android.view.Display;
import java.lang.reflect.Method;
import android.view.WindowManager;

import android.content.Context;
import android.net.wifi.WifiManager;


public class HideNavPlugin extends CordovaPlugin {

    

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.cordova.api.Plugin#execute(java.lang.String,
     * org.json.JSONArray, java.lang.String)
     */
    @Override
     public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    	super( cordova, webView);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		ViewGroup view = (ViewGroup)getWindow().getDecorView();
		view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		super.loadUrl(Config.getStartUrl());
       
    }

	public void hideNav() {
		// getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		//WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//ViewGroup view = (ViewGroup)getWindow().getDecorView();
		//view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		//super.loadUrl(Config.getStartUrl());


            if(getDpi() > getWindowManager().getDefaultDisplay().getHeight()){

              View decorView = getWindow().getDecorView();
              int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                                      | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                                      | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                                      | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                decorView.setSystemUiVisibility(uiOptions);

            }
	}


    private int getDpi(){
        int dpi = 0;
        Display display = getWindowManager().getDefaultDisplay();
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
