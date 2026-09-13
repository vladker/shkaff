package retrofit2;

import A3.AbstractC0157z;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class X extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f8112a;
    public final int b;
    public final InterfaceC1621t c;
    public final boolean d;

    public X(Method method, int i5, InterfaceC1621t interfaceC1621t, boolean z6) {
        this.f8112a = method;
        this.b = i5;
        this.c = interfaceC1621t;
        this.d = z6;
    }

    @Override // retrofit2.i0
    public void apply(o0 o0Var, Map<String, Object> map) {
        int i5 = this.b;
        Method method = this.f8112a;
        if (map == null) {
            throw B0.h(method, i5, "Header map was null.", new Object[0]);
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key == null) {
                throw B0.h(method, i5, "Header map contained null key.", new Object[0]);
            }
            Object value = entry.getValue();
            if (value == null) {
                throw B0.h(method, i5, AbstractC0157z.o("Header map contained null value for key '", key, "'."), new Object[0]);
            }
            o0Var.b(key, (String) this.c.convert(value), this.d);
        }
    }
}
