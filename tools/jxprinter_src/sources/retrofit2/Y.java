package retrofit2;

import java.lang.reflect.Method;
import okhttp3.C1375v;
import okhttp3.C1376w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class Y extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f8113a;
    public final int b;

    public Y(Method method, int i5) {
        this.f8113a = method;
        this.b = i5;
    }

    @Override // retrofit2.i0
    public void apply(o0 o0Var, C1376w c1376w) {
        if (c1376w == null) {
            throw B0.h(this.f8113a, this.b, "Headers parameter must not be null.", new Object[0]);
        }
        C1375v c1375v = o0Var.d;
        c1375v.getClass();
        int iF = c1376w.f();
        for (int i5 = 0; i5 < iF; i5++) {
            c1375v.b(c1376w.c(i5), c1376w.g(i5));
        }
    }
}
