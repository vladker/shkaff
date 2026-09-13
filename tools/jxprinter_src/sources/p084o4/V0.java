package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.o;
import p072m4.r;
import p078n4.j;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V0 implements b {
    public static final V0 INSTANCE = new V0();
    private static final r descriptor = new M0("kotlin.String", o.INSTANCE);

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.a
    public String deserialize(j decoder) {
        E.f(decoder, "decoder");
        return decoder.decodeString();
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(l encoder, String value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        encoder.encodeString(value);
    }
}
