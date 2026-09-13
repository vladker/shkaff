package p144z0;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.l;

/* JADX INFO: renamed from: z0.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1897b implements U, InterfaceC1896a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f9073a;

    public C1897b(AssetManager assetManager) {
        this.f9073a = assetManager;
    }

    @Override // p144z0.InterfaceC1896a
    public final e a(AssetManager assetManager, String str) {
        return new l(assetManager, str);
    }

    @Override // p144z0.U
    @NonNull
    public T build(a0 a0Var) {
        return new C1899d(this.f9073a, this);
    }
}
