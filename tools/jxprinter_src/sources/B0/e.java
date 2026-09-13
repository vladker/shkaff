package B0;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.O;
import java.security.MessageDigest;
import p126w0.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements z {
    public static final e b = new e();

    @NonNull
    public static <T> e get() {
        return b;
    }

    @Override // p126w0.z, p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }

    @Override // p126w0.z
    @NonNull
    public O transform(@NonNull Context context, @NonNull O o6, int i5, int i6) {
        return o6;
    }
}
