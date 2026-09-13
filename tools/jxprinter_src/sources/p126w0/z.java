package p126w0;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.O;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface z extends q {
    @NonNull
    O transform(@NonNull Context context, @NonNull O o6, int i5, int i6);

    @Override // p126w0.q
    /* synthetic */ void updateDiskCacheKey(@NonNull MessageDigest messageDigest);
}
