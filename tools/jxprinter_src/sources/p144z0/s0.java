package p144z0;

import android.content.ContentResolver;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class s0 implements U, r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentResolver f9097a;

    public s0(ContentResolver contentResolver) {
        this.f9097a = contentResolver;
    }

    @Override // p144z0.r0
    public final e a(Uri uri) {
        return new v(this.f9097a, uri);
    }

    @Override // p144z0.U
    @NonNull
    public T build(a0 a0Var) {
        return new t0(this);
    }
}
