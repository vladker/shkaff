package kotlinx.serialization.json.internal;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1130f extends p078n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p095q4.g f5738a;
    public final /* synthetic */ AbstractC1131g b;
    public final /* synthetic */ String c;

    public C1130f(AbstractC1131g abstractC1131g, String str) {
        this.b = abstractC1131g;
        this.c = str;
        this.f5738a = abstractC1131g.getJson().getSerializersModule();
    }

    @Override // p078n4.b, p078n4.l
    public final void a(short s6) {
        i(p147z3.N.m1347toStringimpl(p147z3.N.m1306constructorimpl(s6)));
    }

    @Override // p078n4.b, p078n4.l
    public final void c(int i5) {
        i(Integer.toUnsignedString(p147z3.G.m1188constructorimpl(i5)));
    }

    @Override // p078n4.b, p078n4.l
    public final void d(long j6) {
        i(Long.toUnsignedString(p147z3.J.m1247constructorimpl(j6)));
    }

    @Override // p078n4.b, p078n4.l
    public final void f(byte b) {
        i(p147z3.D.m1172toStringimpl(p147z3.D.m1131constructorimpl(b)));
    }

    @Override // p078n4.b, p078n4.l, p078n4.h
    public final p095q4.g getSerializersModule() {
        return this.f5738a;
    }

    public final void i(String s6) {
        kotlin.jvm.internal.E.f(s6, "s");
        this.b.putElement(this.c, new p089p4.s(s6, false, null));
    }
}
