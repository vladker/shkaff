package p028e4;

import W3.L;
import W3.z;
import java.util.Arrays;
import java.util.Collection;
import java.util.ServiceConfigurationError;
import p007a4.H;
import p012b4.b;

/* JADX INFO: renamed from: e4.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0651e {
    private static final Collection<H> platformExceptionHandlers;

    static {
        try {
            platformExceptionHandlers = L.toList(z.asSequence(Arrays.asList(new b()).iterator()));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    public static final void ensurePlatformExceptionHandlerLoaded(H h6) {
        if (!platformExceptionHandlers.contains(h6)) {
            throw new IllegalStateException("Exception handler was not found via a ServiceLoader");
        }
    }

    public static final Collection<H> getPlatformExceptionHandlers() {
        return platformExceptionHandlers;
    }

    public static final void propagateExceptionFinalResort(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
