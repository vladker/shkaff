package p084o4;

import A3.AbstractC0157z;
import O3.l;
import V3.c;
import V3.e;
import V3.p;
import V3.q;
import V3.t;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.E;
import p060k4.a;
import p060k4.b;
import p060k4.m;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class D0 {
    private static final r[] EMPTY_DESCRIPTOR_ARRAY = new r[0];

    public static final Set<String> cachedSerialNames(r rVar) {
        E.f(rVar, "<this>");
        if (rVar instanceof InterfaceC1323n) {
            return ((InterfaceC1323n) rVar).getSerialNames();
        }
        HashSet hashSet = new HashSet(rVar.b());
        int iB = rVar.b();
        for (int i5 = 0; i5 < iB; i5++) {
            hashSet.add(rVar.getElementName(i5));
        }
        return hashSet;
    }

    public static final <T> a cast(a aVar) {
        E.f(aVar, "<this>");
        return aVar;
    }

    public static final r[] compactArray(List<? extends r> list) {
        r[] rVarArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (rVarArr = (r[]) list.toArray(new r[0])) == null) ? EMPTY_DESCRIPTOR_ARRAY : rVarArr;
    }

    public static final <T, K> int elementsHashCodeBy(Iterable<? extends T> iterable, l lVar) {
        Iterator itC = AbstractC0157z.C(iterable, "<this>", lVar, "selector");
        int iHashCode = 1;
        while (itC.hasNext()) {
            int i5 = iHashCode * 31;
            Object objInvoke = lVar.invoke(itC.next());
            iHashCode = i5 + (objInvoke != null ? objInvoke.hashCode() : 0);
        }
        return iHashCode;
    }

    public static final c kclass(p pVar) {
        E.f(pVar, "<this>");
        e classifier = pVar.getClassifier();
        if (classifier instanceof c) {
            return (c) classifier;
        }
        if (!(classifier instanceof q)) {
            throw new IllegalArgumentException("Only KClass supported as classifier, got " + classifier);
        }
        throw new IllegalArgumentException("Captured type parameter " + classifier + " from generic non-reified function. Such functionality cannot be supported because " + classifier + " is erased, either specify serializer explicitly or make calling function inline with reified " + classifier + '.');
    }

    public static final String notRegisteredMessage(c cVar) {
        E.f(cVar, "<this>");
        String simpleName = cVar.getSimpleName();
        if (simpleName == null) {
            simpleName = "<local class name not available>";
        }
        return notRegisteredMessage(simpleName);
    }

    public static final Void serializerNotRegistered(c cVar) {
        E.f(cVar, "<this>");
        throw new p060k4.l(notRegisteredMessage(cVar));
    }

    public static final p typeOrThrow(t tVar) {
        E.f(tVar, "<this>");
        p type = tVar.getType();
        if (type != null) {
            return type;
        }
        throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + tVar.getType()).toString());
    }

    public static final <T> b cast(b bVar) {
        E.f(bVar, "<this>");
        return bVar;
    }

    public static final String notRegisteredMessage(String className) {
        E.f(className, "className");
        return "Serializer for class '" + className + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n";
    }

    public static final <T> m cast(m mVar) {
        E.f(mVar, "<this>");
        return mVar;
    }
}
