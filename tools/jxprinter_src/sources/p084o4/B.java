package p084o4;

import A3.J;
import N3.a;
import O3.p;
import V3.c;
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
public final class B implements B0 {
    private final ConcurrentHashMap<Class<?>, A0> cache;
    private final p compute;

    public B(p compute) {
        E.f(compute, "compute");
        this.compute = compute;
        this.cache = new ConcurrentHashMap<>();
    }

    @Override // p084o4.B0
    /* JADX INFO: renamed from: get-gIAlu-s, reason: not valid java name */
    public Object mo1041getgIAlus(c key, List<? extends V3.p> types) {
        Object objM1361constructorimpl;
        A0 a0PutIfAbsent;
        E.f(key, "key");
        E.f(types, "types");
        ConcurrentHashMap<Class<?>, A0> concurrentHashMap = this.cache;
        Class<?> javaClass = a.getJavaClass(key);
        A0 a6 = concurrentHashMap.get(javaClass);
        if (a6 == null && (a0PutIfAbsent = concurrentHashMap.putIfAbsent(javaClass, (a6 = new A0()))) != null) {
            a6 = a0PutIfAbsent;
        }
        A0 a7 = a6;
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(types, 10));
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(new C1300b0((V3.p) it.next()));
        }
        ConcurrentHashMap concurrentHashMap2 = a7.serializers;
        Object obj = concurrentHashMap2.get(arrayList);
        if (obj == null) {
            try {
                objM1361constructorimpl = u.m1361constructorimpl((b) this.compute.invoke(key, types));
            } catch (Throwable th) {
                objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(th));
            }
            u uVarA = u.a(objM1361constructorimpl);
            Object objPutIfAbsent = concurrentHashMap2.putIfAbsent(arrayList, uVarA);
            obj = objPutIfAbsent == null ? uVarA : objPutIfAbsent;
        }
        return ((u) obj).b();
    }
}
