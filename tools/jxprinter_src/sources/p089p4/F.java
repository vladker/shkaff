package p089p4;

import S2.l;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import p060k4.b;
import p072m4.o;
import p072m4.r;
import p072m4.w;
import p078n4.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F implements b {
    public static final F INSTANCE = new F();
    private static final r descriptor = w.buildSerialDescriptor("kotlinx.serialization.json.JsonPrimitive", o.INSTANCE, new r[0], new l(16));

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.a
    public E deserialize(j decoder) {
        E.f(decoder, "decoder");
        m mVarDecodeJsonElement = q.asJsonDecoder(decoder).decodeJsonElement();
        if (mVarDecodeJsonElement instanceof E) {
            return (E) mVarDecodeJsonElement;
        }
        throw kotlinx.serialization.json.internal.E.JsonDecodingException(-1, "Unexpected JSON element, expected JsonPrimitive, had " + U.a(mVarDecodeJsonElement.getClass()), mVarDecodeJsonElement.toString());
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(p078n4.l encoder, E value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        q.asJsonEncoder(encoder);
        if (value instanceof x) {
            encoder.encodeSerializableValue(y.INSTANCE, x.INSTANCE);
        } else {
            encoder.encodeSerializableValue(t.INSTANCE, (s) value);
        }
    }
}
