package kotlinx.serialization.json.internal;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1139o extends C1138n {
    public final boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1139o(InterfaceC1147x writer, boolean z6) {
        super(writer);
        kotlin.jvm.internal.E.f(writer, "writer");
        this.b = z6;
    }

    @Override // kotlinx.serialization.json.internal.C1138n
    public void printQuoted(String value) {
        kotlin.jvm.internal.E.f(value, "value");
        if (this.b) {
            super.printQuoted(value);
        } else {
            print(value);
        }
    }
}
