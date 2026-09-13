package p084o4;

import O3.a;
import java.lang.ref.SoftReference;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: o4.q0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1330q0 {
    public volatile SoftReference<Object> reference;

    public final synchronized Object getOrSetWithLock(a factory) {
        E.f(factory, "factory");
        Object obj = this.reference.get();
        if (obj != null) {
            return obj;
        }
        Object objInvoke = factory.invoke();
        this.reference = new SoftReference<>(objInvoke);
        return objInvoke;
    }
}
