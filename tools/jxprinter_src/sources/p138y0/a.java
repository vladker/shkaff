package p138y0;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9028a;
    public int b;
    public int c;
    public String d;

    @NonNull
    private final ThreadFactory threadFactory = new b();

    @NonNull
    private d uncaughtThrowableStrategy = d.f9030m0;

    public a(boolean z6) {
        this.f9028a = z6;
    }

    public final e a() {
        if (!TextUtils.isEmpty(this.d)) {
            return new e(new ThreadPoolExecutor(this.b, this.c, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new c(this.threadFactory, this.d, this.uncaughtThrowableStrategy, this.f9028a)));
        }
        throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.d);
    }

    public a setThreadCount(@IntRange(from = 1) int i5) {
        this.b = i5;
        this.c = i5;
        return this;
    }

    public a setUncaughtThrowableStrategy(@NonNull d dVar) {
        this.uncaughtThrowableStrategy = dVar;
        return this;
    }
}
