package retrofit2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class e0 extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1621t f8124a;
    public final boolean b;

    public e0(InterfaceC1621t interfaceC1621t, boolean z6) {
        this.f8124a = interfaceC1621t;
        this.b = z6;
    }

    @Override // retrofit2.i0
    public void apply(o0 o0Var, Object obj) {
        if (obj == null) {
            return;
        }
        o0Var.addQueryParam((String) this.f8124a.convert(obj), null, this.b);
    }
}
