package I0;

import A3.AbstractC0157z;
import L0.s;
import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.J;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements c, i {
    public static final g c = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f329a;
    public final int b;

    @Nullable
    @GuardedBy("this")
    private J exception;

    @GuardedBy("this")
    private boolean isCancelled;

    @GuardedBy("this")
    private boolean loadFailed;

    @Nullable
    @GuardedBy("this")
    private d request;

    @Nullable
    @GuardedBy("this")
    private Object resource;

    @GuardedBy("this")
    private boolean resultReceived;

    public h(int i5, int i6) {
        this.f329a = i5;
        this.b = i6;
    }

    private synchronized Object doGet(Long l6) {
        if (!isDone() && !s.d()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
        if (this.isCancelled) {
            throw new CancellationException();
        }
        if (this.loadFailed) {
            throw new ExecutionException(this.exception);
        }
        if (this.resultReceived) {
            return this.resource;
        }
        if (l6 == null) {
            c.waitForTimeout(this, 0L);
        } else if (l6.longValue() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = l6.longValue() + jCurrentTimeMillis;
            while (!isDone() && jCurrentTimeMillis < jLongValue) {
                c.waitForTimeout(this, jLongValue - jCurrentTimeMillis);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.loadFailed) {
            throw new ExecutionException(this.exception);
        }
        if (this.isCancelled) {
            throw new CancellationException();
        }
        if (!this.resultReceived) {
            throw new TimeoutException();
        }
        return this.resource;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.isCancelled = true;
                notifyAll();
                d dVar = null;
                if (z6) {
                    d dVar2 = this.request;
                    this.request = null;
                    dVar = dVar2;
                }
                if (dVar != null) {
                    dVar.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // I0.c, com.bumptech.glide.request.target.k
    @Nullable
    public synchronized d getRequest() {
        return this.request;
    }

    @Override // I0.c, com.bumptech.glide.request.target.k
    public void getSize(@NonNull com.bumptech.glide.request.target.j jVar) throws Throwable {
        ((m) jVar).h(this.f329a, this.b);
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isDone() {
        return this.isCancelled || this.resultReceived || this.loadFailed;
    }

    @Override // I0.c, com.bumptech.glide.request.target.k
    public synchronized void onLoadFailed(@Nullable Drawable drawable) {
    }

    @Override // I0.c, com.bumptech.glide.request.target.k
    public synchronized void onResourceReady(@NonNull Object obj, @Nullable J0.d dVar) {
    }

    @Override // I0.c, com.bumptech.glide.request.target.k
    public synchronized void setRequest(@Nullable d dVar) {
        this.request = dVar;
    }

    public final String toString() {
        d dVar;
        String str;
        String strS = AbstractC0157z.s(new StringBuilder(), super.toString(), "[status=");
        synchronized (this) {
            try {
                dVar = null;
                if (this.isCancelled) {
                    str = "CANCELLED";
                } else if (this.loadFailed) {
                    str = "FAILURE";
                } else if (this.resultReceived) {
                    str = "SUCCESS";
                } else {
                    str = "PENDING";
                    dVar = this.request;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (dVar == null) {
            return androidx.collection.a.o(strS, str, "]");
        }
        return strS + str + ", request=[" + dVar + "]]";
    }

    @Override // I0.i
    public synchronized boolean onLoadFailed(@Nullable J j6, Object obj, com.bumptech.glide.request.target.k kVar, boolean z6) {
        this.loadFailed = true;
        this.exception = j6;
        notifyAll();
        return false;
    }

    @Override // I0.i
    public final synchronized boolean onResourceReady(Object obj, Object obj2, com.bumptech.glide.request.target.k kVar, p126w0.a aVar, boolean z6) {
        this.resultReceived = true;
        this.resource = obj;
        notifyAll();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j6, @NonNull TimeUnit timeUnit) {
        return doGet(Long.valueOf(timeUnit.toMillis(j6)));
    }

    @Override // com.bumptech.glide.manager.m
    public final void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.m
    public final void onStart() {
    }

    @Override // com.bumptech.glide.manager.m
    public final void onStop() {
    }

    @Override // I0.c, com.bumptech.glide.request.target.k
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // I0.c, com.bumptech.glide.request.target.k
    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    @Override // I0.c, com.bumptech.glide.request.target.k
    public void removeCallback(@NonNull com.bumptech.glide.request.target.j jVar) {
    }
}
