package cn.sharesdk.framework.network;

import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.network.HTTPPart;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.RawNetworkCallback;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class SSDKNetworkHelper extends NetworkHelper {
    private static SSDKNetworkHelper helper;

    private SSDKNetworkHelper() {
    }

    public static SSDKNetworkHelper getInstance() {
        if (helper == null) {
            helper = new SSDKNetworkHelper();
        }
        return helper;
    }

    private void logEvent(String str, int i5) {
        if (TextUtils.isEmpty(str) || i5 <= 0) {
            return;
        }
        ShareSDK.logApiEvent(str, i5);
    }

    public String httpGet(String str, ArrayList<KVPair<String>> arrayList, String str2, int i5) {
        return httpGet(str, arrayList, null, null, str2, i5);
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, String str2, int i5) {
        return httpPost(str, arrayList, (KVPair<String>) null, str2, i5);
    }

    public String httpPut(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, String str2, int i5) {
        return httpPut(str, arrayList, kVPair, null, null, str2, i5);
    }

    public String jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i5) {
        logEvent(str2, i5);
        return super.jsonPost(str, arrayList, arrayList2, networkTimeOut);
    }

    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, RawNetworkCallback rawNetworkCallback, String str2, int i5) throws Throwable {
        logEvent(str2, i5);
        super.rawPost(str, arrayList, hTTPPart, rawNetworkCallback, (NetworkHelper.NetworkTimeOut) null);
    }

    public String httpGet(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i5) {
        logEvent(str2, i5);
        return super.httpGet(str, arrayList, arrayList2, networkTimeOut);
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, String str2, int i5) {
        return httpPost(str, arrayList, kVPair, null, str2, i5);
    }

    public String httpPut(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i5) {
        logEvent(str2, i5);
        return super.httpPut(str, arrayList, kVPair, arrayList2, networkTimeOut);
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, String str2, int i5) {
        return httpPost(str, arrayList, kVPair, arrayList2, (NetworkHelper.NetworkTimeOut) null, str2, i5);
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i5) {
        logEvent(str2, i5);
        return super.httpPost(str, arrayList, kVPair, arrayList2, networkTimeOut);
    }
}
