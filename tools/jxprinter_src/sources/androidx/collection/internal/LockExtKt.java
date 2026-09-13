package androidx.collection.internal;

import O3.a;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class LockExtKt {
    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <T> T m966synchronized(Lock lock, a block) {
        T t6;
        E.f(lock, "<this>");
        E.f(block, "block");
        synchronized (lock) {
            t6 = (T) block.invoke();
        }
        return t6;
    }
}
