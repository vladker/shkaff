package p089p4;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import p078n4.j;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q {
    public static final k asJsonDecoder(j jVar) {
        E.f(jVar, "<this>");
        k kVar = jVar instanceof k ? (k) jVar : null;
        if (kVar != null) {
            return kVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + U.a(jVar.getClass()));
    }

    public static final r asJsonEncoder(l lVar) {
        E.f(lVar, "<this>");
        r rVar = lVar instanceof r ? (r) lVar : null;
        if (rVar != null) {
            return rVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + U.a(lVar.getClass()));
    }
}
