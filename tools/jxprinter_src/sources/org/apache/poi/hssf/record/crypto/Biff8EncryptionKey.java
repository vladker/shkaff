package org.apache.poi.hssf.record.crypto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Biff8EncryptionKey {
    private static final ThreadLocal<String> _userPasswordTLS = new ThreadLocal<>();

    public static String getCurrentUserPassword() {
        return _userPasswordTLS.get();
    }

    public static void setCurrentUserPassword(String str) {
        if (str == null) {
            _userPasswordTLS.remove();
        } else {
            _userPasswordTLS.set(str);
        }
    }
}
