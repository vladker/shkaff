package kotlinx.serialization.json.internal;

import org.apache.logging.log4j.util.Chars;
import p089p4.AbstractC1519d;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1141q extends C1138n {
    public int b;
    private final AbstractC1519d json;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1141q(InterfaceC1147x writer, AbstractC1519d json) {
        super(writer);
        kotlin.jvm.internal.E.f(writer, "writer");
        kotlin.jvm.internal.E.f(json, "json");
        this.json = json;
    }

    @Override // kotlinx.serialization.json.internal.C1138n
    public final void a() {
        this.f5744a = true;
        this.b++;
    }

    @Override // kotlinx.serialization.json.internal.C1138n
    public final void b() {
        this.f5744a = false;
        print("\n");
        int i5 = this.b;
        for (int i6 = 0; i6 < i5; i6++) {
            print(this.json.getConfiguration().getPrettyPrintIndent());
        }
    }

    @Override // kotlinx.serialization.json.internal.C1138n
    public final void c() {
        if (this.f5744a) {
            this.f5744a = false;
        } else {
            b();
        }
    }

    @Override // kotlinx.serialization.json.internal.C1138n
    public final void i() {
        e(Chars.SPACE);
    }

    @Override // kotlinx.serialization.json.internal.C1138n
    public final void j() {
        this.b--;
    }
}
