package p007a4;

import androidx.collection.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class t1 {
    public static final AbstractC0309w0 newFixedThreadPoolContext(final int i5, final String str) {
        if (i5 < 1) {
            throw new IllegalArgumentException(a.i(i5, "Expected at least one thread, but ", " specified").toString());
        }
        final AtomicInteger atomicInteger = new AtomicInteger();
        return AbstractC0313y0.from((ExecutorService) Executors.newScheduledThreadPool(i5, new ThreadFactory() { // from class: a4.s1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                int i6 = i5;
                String str2 = str;
                if (i6 != 1) {
                    str2 = str2 + '-' + atomicInteger.incrementAndGet();
                }
                Thread thread = new Thread(runnable, str2);
                thread.setDaemon(true);
                return thread;
            }
        }));
    }
}
