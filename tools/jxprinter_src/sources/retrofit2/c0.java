package retrofit2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class c0 extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8120a;
    public final InterfaceC1621t b;
    public final boolean c;

    public c0(String str, InterfaceC1621t interfaceC1621t, boolean z6) {
        Objects.requireNonNull(str, "name == null");
        this.f8120a = str;
        this.b = interfaceC1621t;
        this.c = z6;
    }

    @Override // retrofit2.i0
    public void apply(o0 o0Var, Object obj) {
        String str;
        if (obj == null || (str = (String) this.b.convert(obj)) == null) {
            return;
        }
        o0Var.addQueryParam(this.f8120a, str, this.c);
    }
}
