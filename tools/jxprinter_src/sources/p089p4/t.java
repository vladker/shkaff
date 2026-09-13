package p089p4;

import X3.V;
import X3.b0;
import X3.g0;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import p060k4.b;
import p066l4.a;
import p072m4.o;
import p072m4.r;
import p072m4.w;
import p078n4.j;
import p078n4.l;
import p147z3.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements b {
    public static final t INSTANCE = new t();
    private static final r descriptor = w.PrimitiveSerialDescriptor("kotlinx.serialization.json.JsonLiteral", o.INSTANCE);

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.a
    public s deserialize(j decoder) {
        E.f(decoder, "decoder");
        m mVarDecodeJsonElement = q.asJsonDecoder(decoder).decodeJsonElement();
        if (mVarDecodeJsonElement instanceof s) {
            return (s) mVarDecodeJsonElement;
        }
        throw kotlinx.serialization.json.internal.E.JsonDecodingException(-1, "Unexpected JSON element, expected JsonLiteral, had " + U.a(mVarDecodeJsonElement.getClass()), mVarDecodeJsonElement.toString());
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(l encoder, s value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        q.asJsonEncoder(encoder);
        if (value.f7768a) {
            encoder.encodeString(value.getContent());
            return;
        }
        if (value.getCoerceToInlineType$kotlinx_serialization_json() != null) {
            encoder.encodeInline(value.getCoerceToInlineType$kotlinx_serialization_json()).encodeString(value.getContent());
            return;
        }
        Long longOrNull = V.toLongOrNull(value.getContent());
        if (longOrNull != null) {
            encoder.d(longOrNull.longValue());
            return;
        }
        J uLongOrNull = g0.toULongOrNull(value.getContent());
        if (uLongOrNull != null) {
            encoder.encodeInline(a.serializer(J.Companion).getDescriptor()).d(uLongOrNull.f9126a);
            return;
        }
        Double doubleOrNull = X3.U.toDoubleOrNull(value.getContent());
        if (doubleOrNull != null) {
            encoder.h(doubleOrNull.doubleValue());
            return;
        }
        Boolean booleanStrictOrNull = b0.toBooleanStrictOrNull(value.getContent());
        if (booleanStrictOrNull != null) {
            encoder.b(booleanStrictOrNull.booleanValue());
        } else {
            encoder.encodeString(value.getContent());
        }
    }
}
