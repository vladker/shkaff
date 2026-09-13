package retrofit2;

import java.io.IOException;
import java.lang.reflect.Method;
import okhttp3.C1376w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class Z extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f8114a;
    public final int b;
    public final C1376w c;
    public final InterfaceC1621t d;

    public Z(Method method, int i5, C1376w c1376w, InterfaceC1621t interfaceC1621t) {
        this.f8114a = method;
        this.b = i5;
        this.c = c1376w;
        this.d = interfaceC1621t;
    }

    @Override // retrofit2.i0
    public void apply(o0 o0Var, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            o0Var.c(this.c, (okhttp3.Q) this.d.convert(obj));
        } catch (IOException e) {
            throw B0.h(this.f8114a, this.b, "Unable to convert " + obj + " to RequestBody", e);
        }
    }
}
