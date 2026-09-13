package p084o4;

import N3.a;
import O3.l;
import V3.c;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.E;
import p060k4.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A implements R0 {
    private final ConcurrentHashMap<Class<?>, C1321m> cache;
    private final l compute;

    public A(l compute) {
        E.f(compute, "compute");
        this.compute = compute;
        this.cache = new ConcurrentHashMap<>();
    }

    @Override // p084o4.R0
    public b get(c key) {
        C1321m c1321mPutIfAbsent;
        E.f(key, "key");
        ConcurrentHashMap<Class<?>, C1321m> concurrentHashMap = this.cache;
        Class<?> javaClass = a.getJavaClass(key);
        C1321m c1321m = concurrentHashMap.get(javaClass);
        if (c1321m == null && (c1321mPutIfAbsent = concurrentHashMap.putIfAbsent(javaClass, (c1321m = new C1321m((b) this.compute.invoke(key))))) != null) {
            c1321m = c1321mPutIfAbsent;
        }
        return c1321m.serializer;
    }

    @Override // p084o4.R0
    public boolean isStored(c key) {
        E.f(key, "key");
        return this.cache.containsKey(a.getJavaClass(key));
    }
}
