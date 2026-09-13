package p072m4;

import A3.I;
import A3.J;
import V3.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;
import p060k4.b;
import p084o4.P0;
import p095q4.e;
import p095q4.g;

/* JADX INFO: renamed from: m4.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1242b {
    public static final c getCapturedKClass(r rVar) {
        E.f(rVar, "<this>");
        if (rVar instanceof C1243c) {
            return ((C1243c) rVar).kClass;
        }
        if (rVar instanceof P0) {
            return getCapturedKClass(((P0) rVar).getOriginal$kotlinx_serialization_core());
        }
        return null;
    }

    public static final r getContextualDescriptor(g gVar, r descriptor) {
        b contextual;
        E.f(gVar, "<this>");
        E.f(descriptor, "descriptor");
        c capturedKClass = getCapturedKClass(descriptor);
        if (capturedKClass == null || (contextual = gVar.getContextual(capturedKClass, I.emptyList())) == null) {
            return null;
        }
        return contextual.getDescriptor();
    }

    public static final List<r> getPolymorphicDescriptors(g gVar, r descriptor) {
        E.f(gVar, "<this>");
        E.f(descriptor, "descriptor");
        c capturedKClass = getCapturedKClass(descriptor);
        if (capturedKClass == null) {
            return I.emptyList();
        }
        Map<c, b> map = ((e) gVar).polyBase2Serializers.get(capturedKClass);
        Collection<b> collectionValues = map != null ? map.values() : null;
        if (collectionValues == null) {
            collectionValues = I.emptyList();
        }
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(collectionValues, 10));
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(((b) it.next()).getDescriptor());
        }
        return arrayList;
    }

    public static final r withContext(r rVar, c context) {
        E.f(rVar, "<this>");
        E.f(context, "context");
        return new C1243c(rVar, context);
    }

    public static /* synthetic */ void getCapturedKClass$annotations(r rVar) {
    }
}
