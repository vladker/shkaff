package retrofit2;

import A3.AbstractC0157z;
import java.io.EOFException;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: renamed from: retrofit2.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C1604b0 extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f8118a;
    public final int b;
    public final String c;
    public final InterfaceC1621t d;
    public final boolean e;

    public C1604b0(Method method, int i5, String str, InterfaceC1621t interfaceC1621t, boolean z6) {
        this.f8118a = method;
        this.b = i5;
        Objects.requireNonNull(str, "name == null");
        this.c = str;
        this.d = interfaceC1621t;
        this.e = z6;
    }

    @Override // retrofit2.i0
    public void apply(o0 o0Var, Object obj) throws EOFException {
        String str = this.c;
        if (obj != null) {
            o0Var.e(str, (String) this.d.convert(obj), this.e);
        } else {
            throw B0.h(this.f8118a, this.b, AbstractC0157z.o("Path parameter \"", str, "\" value must not be null."), new Object[0]);
        }
    }
}
