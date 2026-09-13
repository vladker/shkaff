package retrofit2;

import java.io.IOException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class T extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f8108a;
    public final int b;
    public final InterfaceC1621t c;

    public T(Method method, int i5, InterfaceC1621t interfaceC1621t) {
        this.f8108a = method;
        this.b = i5;
        this.c = interfaceC1621t;
    }

    @Override // retrofit2.i0
    public void apply(o0 o0Var, Object obj) {
        int i5 = this.b;
        Method method = this.f8108a;
        if (obj == null) {
            throw B0.h(method, i5, "Body parameter value must not be null.", new Object[0]);
        }
        try {
            o0Var.g((okhttp3.Q) this.c.convert(obj));
        } catch (IOException e) {
            throw B0.i(method, e, i5, "Unable to convert " + obj + " to RequestBody", new Object[0]);
        }
    }
}
