package p144z0;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import com.bumptech.glide.load.data.a;
import com.bumptech.glide.load.data.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements U, r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9075a;
    public final Object b;

    public /* synthetic */ c0(Object obj, int i5) {
        this.f9075a = i5;
        this.b = obj;
    }

    @Override // p144z0.r0
    public e a(Uri uri) {
        return new a((ContentResolver) this.b, uri);
    }

    @Override // p144z0.U
    public final T build(a0 a0Var) {
        switch (this.f9075a) {
            case 0:
                return new f0((Resources) this.b, a0Var.build(Uri.class, AssetFileDescriptor.class));
            default:
                return new t0(this);
        }
    }
}
