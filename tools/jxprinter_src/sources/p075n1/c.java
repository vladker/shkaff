package p075n1;

import U4.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6214a;

    public static synchronized void tryApplyFixes() {
        if (f6214a) {
            return;
        }
        try {
            tryInstallLinuxPRNGSecureRandom();
            f6214a = true;
        } catch (Throwable th) {
            throw new i("Error fixing the Android's SecureRandom", th);
        }
    }

    private static void tryInstallLinuxPRNGSecureRandom() {
    }
}
