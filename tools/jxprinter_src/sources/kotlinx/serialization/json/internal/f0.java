package kotlinx.serialization.json.internal;

import A3.w0;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f0 {
    private static final Set<p072m4.r> unsignedNumberDescriptors = w0.setOf((Object[]) new p072m4.r[]{p066l4.a.serializer(p147z3.G.Companion).getDescriptor(), p066l4.a.serializer(p147z3.J.Companion).getDescriptor(), p066l4.a.serializer(p147z3.D.Companion).getDescriptor(), p066l4.a.serializer(p147z3.N.Companion).getDescriptor()});

    public static final boolean isUnquotedLiteral(p072m4.r rVar) {
        kotlin.jvm.internal.E.f(rVar, "<this>");
        return rVar.isInline() && rVar.equals(p089p4.n.getJsonUnquotedLiteralDescriptor());
    }

    public static final boolean isUnsignedNumber(p072m4.r rVar) {
        kotlin.jvm.internal.E.f(rVar, "<this>");
        return rVar.isInline() && unsignedNumberDescriptors.contains(rVar);
    }
}
