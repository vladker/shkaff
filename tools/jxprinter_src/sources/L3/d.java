package L3;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.E;
import p147z3.AbstractC1926f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final void closeFinally(Closeable closeable, Throwable th) throws IllegalAccessException, IOException, InvocationTargetException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                AbstractC1926f.addSuppressed(th, th2);
            }
        }
    }

    private static final <T extends Closeable, R> R use(T t6, O3.l block) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(block, "block");
        try {
            R r6 = (R) block.invoke(t6);
            if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                closeFinally(t6, null);
            } else if (t6 != null) {
                t6.close();
            }
            return r6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (I3.c.apiVersionIsAtLeast(1, 1, 0)) {
                    closeFinally(t6, th);
                } else if (t6 != null) {
                    try {
                        t6.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }
}
