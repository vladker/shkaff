package kotlinx.serialization.json.internal;

import p072m4.AbstractC1242b;
import p072m4.AbstractC1246f;
import p089p4.AbstractC1519d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class n0 {
    public static final p072m4.r carrierDescriptor(p072m4.r rVar, p095q4.g module) {
        p072m4.r rVarCarrierDescriptor;
        kotlin.jvm.internal.E.f(rVar, "<this>");
        kotlin.jvm.internal.E.f(module, "module");
        if (!kotlin.jvm.internal.E.a(rVar.getKind(), p072m4.x.INSTANCE)) {
            return rVar.isInline() ? carrierDescriptor(rVar.getElementDescriptor(0), module) : rVar;
        }
        p072m4.r contextualDescriptor = AbstractC1242b.getContextualDescriptor(module, rVar);
        return (contextualDescriptor == null || (rVarCarrierDescriptor = carrierDescriptor(contextualDescriptor, module)) == null) ? rVar : rVarCarrierDescriptor;
    }

    public static final <T, R1 extends T, R2 extends T> T selectMapMode(AbstractC1519d abstractC1519d, p072m4.r mapDescriptor, O3.a ifMap, O3.a ifList) {
        kotlin.jvm.internal.E.f(abstractC1519d, "<this>");
        kotlin.jvm.internal.E.f(mapDescriptor, "mapDescriptor");
        kotlin.jvm.internal.E.f(ifMap, "ifMap");
        kotlin.jvm.internal.E.f(ifList, "ifList");
        p072m4.r rVarCarrierDescriptor = carrierDescriptor(mapDescriptor.getElementDescriptor(0), abstractC1519d.getSerializersModule());
        p072m4.z kind = rVarCarrierDescriptor.getKind();
        if ((kind instanceof p072m4.p) || kotlin.jvm.internal.E.a(kind, p072m4.y.INSTANCE)) {
            return (T) ifMap.invoke();
        }
        if (abstractC1519d.getConfiguration().d) {
            return (T) ifList.invoke();
        }
        throw E.InvalidKeyKindException(rVarCarrierDescriptor);
    }

    public static final m0 switchMode(AbstractC1519d abstractC1519d, p072m4.r desc) {
        kotlin.jvm.internal.E.f(abstractC1519d, "<this>");
        kotlin.jvm.internal.E.f(desc, "desc");
        p072m4.z kind = desc.getKind();
        if (kind instanceof AbstractC1246f) {
            return m0.POLY_OBJ;
        }
        if (kotlin.jvm.internal.E.a(kind, p072m4.B.INSTANCE)) {
            return m0.LIST;
        }
        if (!kotlin.jvm.internal.E.a(kind, p072m4.C.INSTANCE)) {
            return m0.OBJ;
        }
        p072m4.r rVarCarrierDescriptor = carrierDescriptor(desc.getElementDescriptor(0), abstractC1519d.getSerializersModule());
        p072m4.z kind2 = rVarCarrierDescriptor.getKind();
        if ((kind2 instanceof p072m4.p) || kotlin.jvm.internal.E.a(kind2, p072m4.y.INSTANCE)) {
            return m0.MAP;
        }
        if (abstractC1519d.getConfiguration().d) {
            return m0.LIST;
        }
        throw E.InvalidKeyKindException(rVarCarrierDescriptor);
    }
}
