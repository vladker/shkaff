package kotlinx.serialization.json.internal;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1140p extends C1138n {
    public final boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1140p(InterfaceC1147x writer, boolean z6) {
        super(writer);
        kotlin.jvm.internal.E.f(writer, "writer");
        this.b = z6;
    }

    @Override // kotlinx.serialization.json.internal.C1138n
    public final void d(byte b) {
        boolean z6 = this.b;
        String strM1172toStringimpl = p147z3.D.m1172toStringimpl(p147z3.D.m1131constructorimpl(b));
        if (z6) {
            printQuoted(strM1172toStringimpl);
        } else {
            print(strM1172toStringimpl);
        }
    }

    @Override // kotlinx.serialization.json.internal.C1138n
    public final void f(int i5) {
        boolean z6 = this.b;
        String unsignedString = Integer.toUnsignedString(p147z3.G.m1188constructorimpl(i5));
        if (z6) {
            printQuoted(unsignedString);
        } else {
            print(unsignedString);
        }
    }

    @Override // kotlinx.serialization.json.internal.C1138n
    public final void g(long j6) {
        boolean z6 = this.b;
        String unsignedString = Long.toUnsignedString(p147z3.J.m1247constructorimpl(j6));
        if (z6) {
            printQuoted(unsignedString);
        } else {
            print(unsignedString);
        }
    }

    @Override // kotlinx.serialization.json.internal.C1138n
    public final void h(short s6) {
        boolean z6 = this.b;
        String strM1347toStringimpl = p147z3.N.m1347toStringimpl(p147z3.N.m1306constructorimpl(s6));
        if (z6) {
            printQuoted(strM1347toStringimpl);
        } else {
            print(strM1347toStringimpl);
        }
    }
}
