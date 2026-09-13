package p144z0;

import K0.d;
import androidx.annotation.NonNull;
import p126w0.v;

/* JADX INFO: renamed from: z0.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1912q implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1910o f9093a;

    public C1912q(C1910o c1910o) {
        this.f9093a = c1910o;
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull Object obj, int i5, int i6, @NonNull v vVar) {
        return new S(new d(obj), new C1909n(obj.toString(), this.f9093a));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Object obj) {
        return obj.toString().startsWith("data:image");
    }
}
