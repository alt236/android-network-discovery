/*
 * Copyright (C) 2009-2010 Aubort Jean-Baptiste (Rorist)
 * Licensed under GNU's GPL 2, see README
 */

// http://standards.ieee.org/regauth/oui/oui.txt

package info.lamatricexiste.network.Network;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.util.Log;

public class UserCommentry {

    private final static String TAG = "UserCommentry";
    private final static String REQ = "select vendor from oui where mac=?";
    private static final Map <String, String> MAP_DEVICE_NAME = populateDeviceNames();
    private static final Map <String, String> MAP_DEVICE_DESC = populateDeviceDescriptions();
    
    public UserCommentry(Activity activity) {
    }

    public static String getDeviceName(String mac) {
    	if(mac == null){return null;}
    	return MAP_DEVICE_NAME.get(mac.toUpperCase());
    }
    
    public static String getDeviceDesc(String mac) {
    	if(mac == null){return null;}
    	
    	return MAP_DEVICE_DESC.get(mac.toUpperCase());
    }
    
	private static Map<String, String> populateDeviceNames() {
		Map<String, String> result = new HashMap<String, String>();


	
		return Collections.unmodifiableMap(result);
	}
	
	
	private static Map<String, String> populateDeviceDescriptions() {
		Map<String, String> result = new HashMap<String, String>();

		return Collections.unmodifiableMap(result);
	}
}
