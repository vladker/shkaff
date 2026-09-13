package com.google.android.gms.auth;

import android.text.TextUtils;
import androidx.exifinterface.media.a;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.Preconditions;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: loaded from: classes2.dex */
public final class CookieUtil {
    private CookieUtil() {
    }

    public static String getCookieUrl(String str, Boolean bool) {
        Preconditions.checkNotEmpty(str);
        String str2 = zza(bool) ? ProxyConfig.MATCH_HTTPS : ProxyConfig.MATCH_HTTP;
        return a.e(a.b(str2.length() + 3, str), str2, "://", str);
    }

    public static String getCookieValue(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l6) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(Chars.EQ);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (zza(bool)) {
            sb.append(";HttpOnly");
        }
        if (zza(bool2)) {
            sb.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(";Domain=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(";Path=");
            sb.append(str4);
        }
        if (l6 != null && l6.longValue() > 0) {
            sb.append(";Max-Age=");
            sb.append(l6);
        }
        return sb.toString();
    }

    private static boolean zza(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
