package p089p4;

import S2.l;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.C1245e;
import p072m4.r;
import p072m4.w;
import p078n4.j;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements b {
    public static final o INSTANCE = new o();
    private static final r descriptor = w.buildSerialDescriptor("kotlinx.serialization.json.JsonElement", C1245e.INSTANCE, new r[0], new l(17));

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.a
    public m deserialize(j decoder) {
        E.f(decoder, "decoder");
        return q.asJsonDecoder(decoder).decodeJsonElement();
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(p078n4.l encoder, m value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        q.asJsonEncoder(encoder);
        if (value instanceof E) {
            encoder.encodeSerializableValue(F.INSTANCE, value);
        } else if (value instanceof A) {
            encoder.encodeSerializableValue(C.INSTANCE, value);
        } else {
            if (!(value instanceof C1521f)) {
                throw new C1937q();
            }
            encoder.encodeSerializableValue(h.INSTANCE, value);
        }
    }
}
