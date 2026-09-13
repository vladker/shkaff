package K0;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import p126w0.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements q {
    public static final c b = new c();

    @NonNull
    public static c obtain() {
        return b;
    }

    public final String toString() {
        return "EmptySignature";
    }

    @Override // p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
