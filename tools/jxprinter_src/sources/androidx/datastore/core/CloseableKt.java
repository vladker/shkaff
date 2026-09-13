package androidx.datastore.core;

import O3.l;
import kotlin.jvm.internal.E;
import p147z3.AbstractC1926f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CloseableKt {
    public static final <T extends Closeable, R> R use(T t6, l block) throws Throwable {
        E.f(t6, "<this>");
        E.f(block, "block");
        try {
            R r6 = (R) block.invoke(t6);
            try {
                t6.close();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            if (th == null) {
                return r6;
            }
            throw th;
        } catch (Throwable th2) {
            try {
                t6.close();
            } catch (Throwable th3) {
                AbstractC1926f.addSuppressed(th2, th3);
            }
            throw th2;
        }
    }
}
