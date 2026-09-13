package androidx.datastore.core;

import O3.l;
import kotlin.jvm.internal.E;
import p049i4.b;
import p049i4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MutexUtilsKt {
    public static final <R> R withTryLock(b bVar, Object obj, l block) {
        E.f(bVar, "<this>");
        E.f(block, "block");
        g gVar = (g) bVar;
        boolean zTryLock = gVar.tryLock(obj);
        try {
            return (R) block.invoke(Boolean.valueOf(zTryLock));
        } finally {
            if (zTryLock) {
                gVar.unlock(obj);
            }
        }
    }

    public static /* synthetic */ Object withTryLock$default(b bVar, Object obj, l block, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            obj = null;
        }
        E.f(bVar, "<this>");
        E.f(block, "block");
        g gVar = (g) bVar;
        boolean zTryLock = gVar.tryLock(obj);
        try {
            return block.invoke(Boolean.valueOf(zTryLock));
        } finally {
            if (zTryLock) {
                gVar.unlock(obj);
            }
        }
    }
}
