package p072m4;

import A3.AbstractC0157z;
import A3.C;
import O3.l;
import V3.p;
import X3.b0;
import kotlin.jvm.internal.E;
import p084o4.C1305e;
import p084o4.N0;
import p084o4.P;
import p084o4.P0;
import p084o4.S;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w {
    public static final r PrimitiveSerialDescriptor(String serialName, p kind) {
        E.f(serialName, "serialName");
        E.f(kind, "kind");
        if (b0.isBlank(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        return N0.PrimitiveDescriptorSafe(serialName, kind);
    }

    public static final r SerialDescriptor(String serialName, r original) {
        E.f(serialName, "serialName");
        E.f(original, "original");
        if (b0.isBlank(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (original.getKind() instanceof p) {
            throw new IllegalArgumentException("For primitive descriptors please use 'PrimitiveSerialDescriptor' instead");
        }
        if (!serialName.equals(original.getSerialName())) {
            return new F(serialName, original);
        }
        StringBuilder sbY = AbstractC0157z.y("The name of the wrapped descriptor (", serialName, ") cannot be the same as the name of the original descriptor (");
        sbY.append(original.getSerialName());
        sbY.append(')');
        throw new IllegalArgumentException(sbY.toString().toString());
    }

    public static final r buildClassSerialDescriptor(String serialName, r[] typeParameters, l builderAction) {
        E.f(serialName, "serialName");
        E.f(typeParameters, "typeParameters");
        E.f(builderAction, "builderAction");
        if (b0.isBlank(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        C1241a c1241a = new C1241a(serialName);
        builderAction.invoke(c1241a);
        return new s(serialName, A.INSTANCE, c1241a.getElementNames$kotlinx_serialization_core().size(), C.toList(typeParameters), c1241a);
    }

    public static final r buildSerialDescriptor(String serialName, z kind, r[] typeParameters, l builder) {
        E.f(serialName, "serialName");
        E.f(kind, "kind");
        E.f(typeParameters, "typeParameters");
        E.f(builder, "builder");
        if (b0.isBlank(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (kind.equals(A.INSTANCE)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        C1241a c1241a = new C1241a(serialName);
        builder.invoke(c1241a);
        return new s(serialName, kind, c1241a.getElementNames$kotlinx_serialization_core().size(), C.toList(typeParameters), c1241a);
    }

    public static final r getNonNullOriginal(r rVar) {
        E.f(rVar, "<this>");
        return rVar instanceof P0 ? ((P0) rVar).getOriginal$kotlinx_serialization_core() : rVar;
    }

    public static final r getNullable(r rVar) {
        E.f(rVar, "<this>");
        return rVar.a() ? rVar : new P0(rVar);
    }

    public static final r listSerialDescriptor(r elementDescriptor) {
        E.f(elementDescriptor, "elementDescriptor");
        return new C1305e(elementDescriptor);
    }

    public static final r mapSerialDescriptor(r keyDescriptor, r valueDescriptor) {
        E.f(keyDescriptor, "keyDescriptor");
        E.f(valueDescriptor, "valueDescriptor");
        return new P(keyDescriptor, valueDescriptor);
    }

    public static final r serialDescriptor(p type) {
        E.f(type, "type");
        return p060k4.p.serializer(type).getDescriptor();
    }

    public static final r setSerialDescriptor(r elementDescriptor) {
        E.f(elementDescriptor, "elementDescriptor");
        return new S(elementDescriptor);
    }

    public static final <T> r listSerialDescriptor() {
        E.l();
        throw null;
    }

    public static final <K, V> r mapSerialDescriptor() {
        E.l();
        throw null;
    }

    public static final <T> r setSerialDescriptor() {
        E.l();
        throw null;
    }

    public static /* synthetic */ void getNonNullOriginal$annotations(r rVar) {
    }
}
