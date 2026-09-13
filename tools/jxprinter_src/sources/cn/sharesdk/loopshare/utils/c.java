package cn.sharesdk.loopshare.utils;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static String a(Intent intent) {
        Uri data;
        String path = (intent == null || (data = intent.getData()) == null) ? null : data.getPath();
        if (path == null) {
            path = "";
        }
        return path.startsWith(PackagingURIHelper.FORWARD_SLASH_STRING) ? path.substring(1, path.length()) : path;
    }

    public static boolean b(Intent intent) {
        if (intent == null) {
            return false;
        }
        return b(intent.getData());
    }

    public static String c(Uri uri) {
        String string = uri != null ? uri.toString() : null;
        return string == null ? "" : string;
    }

    public static boolean d(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        return (ProxyConfig.MATCH_HTTP.equals(scheme) || ProxyConfig.MATCH_HTTPS.equals(scheme)) && !TextUtils.isEmpty(uri.getPath());
    }

    public static boolean e(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        String queryParameter = uri.getQueryParameter("params");
        String queryParameter2 = uri.getQueryParameter("data");
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        return (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2)) ? false : true;
    }

    public static boolean b(Uri uri) {
        return e(uri) || d(uri);
    }

    public static String c(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return null;
        }
        return data.getScheme();
    }

    public static String a(Uri uri) {
        if (uri != null) {
            return uri.getPath();
        }
        return null;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        return d(uri) || e(uri);
    }
}
