package p075n1;

import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends SecureRandom {
    @Override // java.security.SecureRandom, java.util.Random
    public final synchronized void nextBytes(byte[] bArr) {
        c.tryApplyFixes();
        super.nextBytes(bArr);
    }
}
