package p144z0;

import K0.d;
import androidx.annotation.NonNull;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class o0 implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f9089a = new o0();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class a implements U {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9090a = new a();

        @Deprecated
        public a() {
        }

        @Override // p144z0.U
        @NonNull
        public T build(a0 a0Var) {
            return o0.f9089a;
        }
    }

    @Deprecated
    public o0() {
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull Object obj, int i5, int i6, @NonNull v vVar) {
        return new S(new d(obj), new p0(obj));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Object obj) {
        return true;
    }
}
