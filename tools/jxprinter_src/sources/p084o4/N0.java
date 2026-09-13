package p084o4;

import A3.AbstractC0157z;
import V3.c;
import X3.O;
import java.util.Map;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import p060k4.b;
import p072m4.p;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class N0 {
    private static final Map<c, b> BUILTIN_SERIALIZERS = C0.initBuiltins();

    public static final r PrimitiveDescriptorSafe(String serialName, p kind) {
        E.f(serialName, "serialName");
        E.f(kind, "kind");
        for (b bVar : BUILTIN_SERIALIZERS.values()) {
            if (serialName.equals(bVar.getDescriptor().getSerialName())) {
                StringBuilder sbY = AbstractC0157z.y("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", serialName, " there already exists ");
                sbY.append(U.a(bVar.getClass()).getSimpleName());
                sbY.append(".\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                throw new IllegalArgumentException(O.trimIndent(sbY.toString()));
            }
        }
        return new M0(serialName, kind);
    }

    public static final <T> b builtinSerializerOrNull(c cVar) {
        E.f(cVar, "<this>");
        return BUILTIN_SERIALIZERS.get(cVar);
    }
}
