package com.baozhe.cordova;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class PrjPlugin extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("echo")) {
			String message = args.getString(0);
			this.echo(message, callbackContext);
			return true;
		} else if (action.equals("md5")) {
			String message = args.getString(0);
			this.md5(message, callbackContext);
			return true;
		} else
			return false;
	}

	private void echo(String message, CallbackContext callbackContext) {
		if (message != null && message.length() > 0) {
			callbackContext.success("Into plugins and echo [" + message + "]");
		} else {
			callbackContext.error("Expected one non-empty string argument.");
		}
	}

	private void md5(String message, CallbackContext callbackContext) {
		if (message != null && message.length() > 0) {
			callbackContext.success("Into plugin and echo [ " + message + " ] with md5 ["
					+ new String(Hex.encodeHex(DigestUtils.md5(message))) + "]");
		} else {
			callbackContext.error("Expected one non-empty string argument.");
		}
	}

}
