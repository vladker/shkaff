package p144z0;

import K0.d;
import androidx.annotation.NonNull;
import io.reactivex.internal.operators.observable.C0953x2;
import p126w0.v;

/* JADX INFO: renamed from: z0.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1903h implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0953x2 f9082a;

    public C1903h(C0953x2 c0953x2) {
        this.f9082a = c0953x2;
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull byte[] bArr, int i5, int i6, @NonNull v vVar) {
        return new S(new d(bArr), new C1901f(bArr, this.f9082a));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull byte[] bArr) {
        return true;
    }
}
