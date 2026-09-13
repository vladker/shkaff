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

/* JADX INFO: renamed from: o4.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1338v implements B0 {
    private final C1342x classValue;
    private final p compute;

    public C1338v(p compute) {
        E.f(compute, "compute");
        this.compute = compute;
        this.classValue = new C1342x();
    }

    @Override // p084o4.B0
    /* JADX INFO: renamed from: get-gIAlu-s */
    public Object mo1041getgIAlus(c key, List<? extends V3.p> types) {
        Object objM1361constructorimpl;
        E.f(key, "key");
        E.f(types, "types");
        Object obj = this.classValue.get(a.getJavaClass(key));
        E.e(obj, "get(...)");
        C1330q0 c1330q0 = (C1330q0) obj;
        Object orSetWithLock = c1330q0.reference.get();
        if (orSetWithLock == null) {
            orSetWithLock = c1330q0.getOrSetWithLock(new C1336u());
        }
        A0 a6 = (A0) orSetWithLock;
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(types, 10));
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(new C1300b0((V3.p) it.next()));
        }
        ConcurrentHashMap concurrentHashMap = a6.serializers;
        Object obj2 = concurrentHashMap.get(arrayList);
        if (obj2 == null) {
            try {
                objM1361constructorimpl = u.m1361constructorimpl((b) this.compute.invoke(key, types));
            } catch (Throwable th) {
                objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(th));
            }
            u uVarA = u.a(objM1361constructorimpl);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(arrayList, uVarA);
            obj2 = objPutIfAbsent == null ? uVarA : objPutIfAbsent;
        }
        return ((u) obj2).b();
    }
}
