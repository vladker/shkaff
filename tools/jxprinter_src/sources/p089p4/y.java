package p089p4;

import S2.l;
import kotlin.jvm.internal.E;
import kotlinx.serialization.json.internal.C1149z;
import p060k4.b;
import p072m4.r;
import p072m4.w;
import p078n4.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements b {
    public static final y INSTANCE = new y();
    private static final r descriptor = w.buildSerialDescriptor("kotlinx.serialization.json.JsonNull", p072m4.y.INSTANCE, new r[0], new l(16));

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.a
    public x deserialize(j decoder) {
        E.f(decoder, "decoder");
        q.asJsonDecoder(decoder);
        if (decoder.decodeNotNullMark()) {
            throw new C1149z("Expected 'null' literal");
        }
        decoder.decodeNull();
        return x.INSTANCE;
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(p078n4.l encoder, x value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        q.asJsonEncoder(encoder);
        encoder.encodeNull();
    }
}
