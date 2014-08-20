package kr.co.purpleworks.cordova.modal;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;

public class Modal extends Plugin {
	private static final int ACTIVITY_MODAL = 1001;							// modal activity request code
	public static final String PARAM_LOAD_URL = "loadUrl";					// passing data

	//private CallbackContext callbackContext;


	public PluginResult execute(String action, JSONArray args, final String callbackId) {
		//this.callbackContext = callbackContext;
        if (action.equals("open")) {
        	try {
            String url = args.getString(0);
            Intent intent = new Intent(this.cordova.getActivity(), ModalActivity.class);
            intent.putExtra(PARAM_LOAD_URL, url);
            this.cordova.setActivityResultCallback(this);
            this.cordova.getActivity().startActivityForResult(intent, ACTIVITY_MODAL);
        	} catch (JSONException e) {
                
                e.printStackTrace();
                return new PluginResult(PluginResult.Status.ERROR, "Invalid JSON args used. expected a string as the first arg.");
            }
            //return true;
        } else if(action.equals("close")) {
        	
        	try {
        		
       
        	if (cordova.getActivity() instanceof ModalActivity) {
        		Intent intent = new Intent();
        		intent.putExtra("param", args.getString(0));

        		this.cordova.getActivity().setResult(Activity.RESULT_OK, intent);
        		this.cordova.getActivity().finish();
			} else {
				//callbackContext.error("Not ModalActivity");
			}
        	} catch (JSONException e1) {
                
                e1.printStackTrace();
                return new PluginResult(PluginResult.Status.ERROR, "Invalid JSON args used. Expected a string array of permissions.");
            }
        	//return true;
        }
        return new PluginResult(PluginResult.Status.OK, "OK");
    }

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if(requestCode == ACTIVITY_MODAL) {
			if(resultCode == Activity.RESULT_OK) {
				String param = intent.getStringExtra("param");
				//this.callbackContext.success(param);
			}
		}
	}
}
