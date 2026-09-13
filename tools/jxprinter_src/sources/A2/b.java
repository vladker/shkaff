package A2;

import A3.AbstractC0157z;
import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final a Companion = new a();
    private static final String TAG = "[WifiAdmin]";
    private List<? extends WifiConfiguration> configuration;
    private DhcpInfo dhcpInfo;
    private WifiInfo mWifiInfo;
    private WifiManager.WifiLock mWifiLock;
    private final WifiManager mWifiManager;
    private List<ScanResult> wifiList;

    public b(Context context) {
        E.f(context, "context");
        Object systemService = context.getSystemService("wifi");
        E.d(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiManager wifiManager = (WifiManager) systemService;
        this.mWifiManager = wifiManager;
        this.mWifiInfo = wifiManager.getConnectionInfo();
    }

    public final WifiConfiguration CreateWifiInfo(String SSID, String Password, int i5) {
        WifiConfiguration next;
        E.f(SSID, "SSID");
        E.f(Password, "Password");
        Log.i(TAG, "SSID:" + SSID + ",password:" + Password);
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = "\"" + SSID + "\"";
        Iterator<WifiConfiguration> it = this.mWifiManager.getConfiguredNetworks().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!E.a(next.SSID, "\"" + SSID + "\""));
        if (next != null) {
            this.mWifiManager.removeNetwork(next.networkId);
        } else {
            Log.i(TAG, "IsExsits is null.");
        }
        if (i5 == 1) {
            Log.i(TAG, "Type =1.");
            wifiConfiguration.wepKeys[0] = "";
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        }
        if (i5 == 2) {
            Log.i(TAG, "Type =2.");
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.wepKeys[0] = AbstractC0157z.o("\"", Password, "\"");
            wifiConfiguration.allowedAuthAlgorithms.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(0);
            wifiConfiguration.allowedGroupCiphers.set(1);
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        }
        if (i5 == 3) {
            Log.i(TAG, "Type =3.");
            wifiConfiguration.preSharedKey = "\"" + Password + "\"";
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedKeyManagement.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
            wifiConfiguration.status = 2;
        }
        return wifiConfiguration;
    }

    public final boolean addNetwork(WifiConfiguration wifiConfiguration) {
        this.mWifiManager.enableNetwork(this.mWifiManager.addNetwork(wifiConfiguration), true);
        try {
            Thread.sleep(8000L);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return true;
        }
    }

    public final String getBSSID() {
        WifiInfo wifiInfo = this.mWifiInfo;
        if (wifiInfo == null) {
            return "NULL";
        }
        E.c(wifiInfo);
        String bssid = wifiInfo.getBSSID();
        E.e(bssid, "getBSSID(...)");
        return bssid;
    }

    public final List<WifiConfiguration> getConfiguration() {
        return this.configuration;
    }

    public final DhcpInfo getDhcpInfo() {
        DhcpInfo dhcpInfo = this.mWifiManager.getDhcpInfo();
        this.dhcpInfo = dhcpInfo;
        return dhcpInfo;
    }

    public final String getMacAddress() {
        WifiInfo wifiInfo = this.mWifiInfo;
        if (wifiInfo == null) {
            return "NULL";
        }
        E.c(wifiInfo);
        String macAddress = wifiInfo.getMacAddress();
        E.e(macAddress, "getMacAddress(...)");
        return macAddress;
    }

    public final String getSSID() {
        WifiInfo wifiInfo = this.mWifiInfo;
        if (wifiInfo == null) {
            return "NULL";
        }
        E.c(wifiInfo);
        String ssid = wifiInfo.getSSID();
        E.e(ssid, "getSSID(...)");
        return ssid;
    }

    public final WifiInfo getWifiInfo() {
        WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
        this.mWifiInfo = connectionInfo;
        return connectionInfo;
    }

    public final List<ScanResult> getWifiList() {
        return this.wifiList;
    }

    public final String intToIp(int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append(i5 & 255);
        sb.append(Consts.DOT);
        sb.append((i5 >> 8) & 255);
        sb.append(Consts.DOT);
        sb.append((i5 >> 16) & 255);
        return androidx.exifinterface.media.a.q(sb, Consts.DOT, (i5 >> 24) & 255);
    }

    public final StringBuilder lookUpScan() {
        StringBuilder sb = new StringBuilder();
        List<ScanResult> list = this.wifiList;
        E.c(list);
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            sb.append("Index_" + i5 + "1:");
            List<ScanResult> list2 = this.wifiList;
            E.c(list2);
            sb.append(list2.get(i5).toString());
            sb.append("/n");
        }
        return sb;
    }
}
