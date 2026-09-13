package p138y0;

import Q0.b;
import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f9029a;
    public final String b;
    public final d c;
    public final boolean d;
    public final AtomicInteger e = new AtomicInteger();

    public c(ThreadFactory threadFactory, String str, d dVar, boolean z6) {
        this.f9029a = threadFactory;
        this.b = str;
        this.c = dVar;
        this.d = z6;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        Thread threadNewThread = this.f9029a.newThread(new b(this, 26, runnable, false));
        threadNewThread.setName("glide-" + this.b + "-thread-" + this.e.getAndIncrement());
        return threadNewThread;
    }
}
