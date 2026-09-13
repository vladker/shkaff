package p084o4;

import O3.a;
import java.lang.ref.SoftReference;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: o4.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1342x extends ClassValue {
    @Override // java.lang.ClassValue
    public final /* bridge */ /* synthetic */ Object computeValue(Class cls) {
        return computeValue((Class<?>) cls);
    }

    public final Object getOrSet(Class<?> key, a factory) {
        E.f(key, "key");
        E.f(factory, "factory");
        Object obj = get(key);
        E.e(obj, "get(...)");
        C1330q0 c1330q0 = (C1330q0) obj;
        Object obj2 = c1330q0.reference.get();
        return obj2 != null ? obj2 : c1330q0.getOrSetWithLock(new C1340w(factory));
    }

    public final boolean isStored(Class<?> key) {
        E.f(key, "key");
        return ((C1330q0) get(key)).reference.get() != null;
    }

    @Override // java.lang.ClassValue
    public C1330q0 computeValue(Class<?> type) {
        E.f(type, "type");
        C1330q0 c1330q0 = new C1330q0();
        c1330q0.reference = new SoftReference<>(null);
        return c1330q0;
    }
}
