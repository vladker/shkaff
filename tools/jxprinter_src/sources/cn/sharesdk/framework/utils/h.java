package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import com.mob.tools.utils.DH;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public static String a() {
        try {
            String oSLanguage = DH.SyncMtd.getOSLanguage();
            if (!TextUtils.isEmpty(oSLanguage)) {
                return oSLanguage;
            }
            SSDKLog.b().a("osl null", new Object[0]);
            return "";
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return "";
        }
    }

    public static String b() {
        try {
            String oSCountry = DH.SyncMtd.getOSCountry();
            if (!TextUtils.isEmpty(oSCountry)) {
                return oSCountry;
            }
            SSDKLog.b().a("osc null", new Object[0]);
            return "";
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return "";
        }
    }
}
