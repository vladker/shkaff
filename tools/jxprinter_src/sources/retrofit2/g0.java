package retrofit2;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class g0 extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f8128a;
    public final int b;

    public g0(Method method, int i5) {
        this.f8128a = method;
        this.b = i5;
    }

    @Override // retrofit2.i0
    public void apply(o0 o0Var, Object obj) {
        if (obj != null) {
            o0Var.h(obj);
        } else {
            throw B0.h(this.f8128a, this.b, "@Url parameter is null.", new Object[0]);
        }
    }
}
