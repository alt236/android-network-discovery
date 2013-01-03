/*
 * Copyright (C) 2009-2010 Aubort Jean-Baptiste (Rorist)
 * Licensed under GNU's GPL 2, see README
 */

package info.lamatricexiste.network.tasks;

import info.lamatricexiste.network.activities.ActivityDiscovery;
import info.lamatricexiste.network.network.HardwareAddress;
import info.lamatricexiste.network.network.HostBean;
import info.lamatricexiste.network.network.NetInfo;
import info.lamatricexiste.network.utils.Prefs;

import java.io.IOException;
import java.net.InetAddress;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.util.Log;

public class DnsDiscovery extends AbstractDiscovery {

    private final String TAG = "DnsDiscovery";

    public DnsDiscovery(ActivityDiscovery discover) {
        super(discover);
    }

    @Override
    protected Void doInBackground(Void... params) {
        if (mDiscover != null) {
            final ActivityDiscovery discover = mDiscover.get();
            if (discover != null) {
                Log.i(TAG, "start=" + NetInfo.getIpFromLongUnsigned(start) + " (" + start
                        + "), end=" + NetInfo.getIpFromLongUnsigned(end) + " (" + end
                        + "), length=" + size);

                int timeout = Integer.parseInt(discover.getPrefs().getString(Prefs.KEY_TIMEOUT_DISCOVER,
                        Prefs.DEFAULT_TIMEOUT_DISCOVER));
                Log.i(TAG, "timeout=" + timeout + "ms");

                for (long i = start; i < end + 1; i++) {
                    hosts_done++;
                    HostBean host = new HostBean();
                    host.ipAddress = NetInfo.getIpFromLongUnsigned(i);
                    try {
                        InetAddress ia = InetAddress.getByName(host.ipAddress);
                        host.hostname = ia.getCanonicalHostName();
                        host.isAlive = ia.isReachable(timeout) ? 1 : 0;
                    } catch (java.net.UnknownHostException e) {
                        Log.e(TAG, e.getMessage());
                    } catch (IOException e) {
                        Log.e(TAG, e.getMessage());
                    }
                    if (host.hostname != null && !host.hostname.equals(host.ipAddress)) {
                        // Is gateway ?
                        if (discover.getNetInfo().gatewayIp.equals(host.ipAddress)) {
                            host.deviceType = 1;
                        }
                        // Mac Addr
                        host.setHardwareAddress(HardwareAddress.getHardwareAddress(host.ipAddress));
                        // NIC vendor
                        try {
                            host.nicVendor = HardwareAddress.getNicVendor(host.getHardwareAddress());
                        } catch (SQLiteDatabaseCorruptException e) {
                            Log.e(TAG, e.getMessage());
                        }
                        publishProgress(host);
                    } else {
                        publishProgress((HostBean) null);
                    }
                }
            }
        }
        return null;
    }

}
