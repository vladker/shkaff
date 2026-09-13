package retrofit2;

import A3.AbstractC0157z;
import com.google.common.net.HttpHeaders;
import java.lang.reflect.Method;
import java.util.Map;
import okhttp3.C1376w;

/* JADX INFO: renamed from: retrofit2.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C1602a0 extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f8116a;
    public final int b;
    public final InterfaceC1621t c;
    public final String d;

    public C1602a0(Method method, int i5, InterfaceC1621t interfaceC1621t, String str) {
        this.f8116a = method;
        this.b = i5;
        this.c = interfaceC1621t;
        this.d = str;
    }

    @Override // retrofit2.i0
    public void apply(o0 o0Var, Map<String, Object> map) {
        int i5 = this.b;
        Method method = this.f8116a;
        if (map == null) {
            throw B0.h(method, i5, "Part map was null.", new Object[0]);
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key == null) {
                throw B0.h(method, i5, "Part map contained null key.", new Object[0]);
            }
            Object value = entry.getValue();
            if (value == null) {
                throw B0.h(method, i5, AbstractC0157z.o("Part map contained null value for key '", key, "'."), new Object[0]);
            }
            o0Var.c(C1376w.e(HttpHeaders.CONTENT_DISPOSITION, AbstractC0157z.o("form-data; name=\"", key, "\""), "Content-Transfer-Encoding", this.d), (okhttp3.Q) this.c.convert(value));
        }
    }
}
