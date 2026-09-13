package p144z0;

import K0.d;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import kotlin.jvm.internal.D;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class N implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9060a;

    public N(Context context) {
        this.f9060a = context;
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull Uri uri, int i5, int i6, @NonNull v vVar) {
        return new S(new d(uri), new M(this.f9060a, uri));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Uri uri) {
        return D.b(uri);
    }
}
