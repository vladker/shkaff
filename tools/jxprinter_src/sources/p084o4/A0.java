package p084o4;

import A3.J;
import O3.a;
import V3.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.E;
import p060k4.b;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A0 {
    private final ConcurrentHashMap<List<C1300b0>, u> serializers = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: computeIfAbsent-gIAlu-s, reason: not valid java name */
    public final Object m1040computeIfAbsentgIAlus(List<? extends p> types, a producer) {
        Object objM1361constructorimpl;
        E.f(types, "types");
        E.f(producer, "producer");
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(types, 10));
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(new C1300b0((p) it.next()));
        }
        ConcurrentHashMap<List<C1300b0>, u> concurrentHashMap = this.serializers;
        u uVar = concurrentHashMap.get(arrayList);
        if (uVar == null) {
            try {
                objM1361constructorimpl = u.m1361constructorimpl((b) producer.invoke());
            } catch (Throwable th) {
                objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(th));
            }
            u uVarA = u.a(objM1361constructorimpl);
            u uVarPutIfAbsent = concurrentHashMap.putIfAbsent(arrayList, uVarA);
            uVar = uVarPutIfAbsent == null ? uVarA : uVarPutIfAbsent;
        }
        return uVar.b();
    }
}
