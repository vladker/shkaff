package cn.sharesdk.loopshare.utils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || !str.equals(str2)) {
            return str2 != null && str2.equals(str);
        }
        return true;
    }
}
