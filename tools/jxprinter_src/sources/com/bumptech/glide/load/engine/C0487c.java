package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0487c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3002a;
    public final Executor b;

    @Nullable
    private volatile InterfaceC0486b cb;
    public x d;
    public volatile boolean e;

    @VisibleForTesting
    final Map<p126w0.q, a> activeEngineResources = new HashMap();
    public final ReferenceQueue c = new ReferenceQueue();

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.c$a */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a extends WeakReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p126w0.q f3003a;
        public final boolean b;

        @Nullable
        O resource;

        public a(@NonNull p126w0.q qVar, @NonNull H h6, @NonNull ReferenceQueue<? super H> referenceQueue, boolean z6) {
            super(h6, referenceQueue);
            this.f3003a = (p126w0.q) L0.q.checkNotNull(qVar);
            this.resource = (h6.f2956a && z6) ? (O) L0.q.checkNotNull(h6.c) : null;
            this.b = h6.f2956a;
        }
    }

    @VisibleForTesting
    public C0487c(boolean z6, Executor executor) {
        this.f3002a = z6;
        this.b = executor;
        executor.execute(new H2.c(this, 12));
    }

    public final synchronized void a(p126w0.q qVar, H h6) {
        a aVarPut = this.activeEngineResources.put(qVar, new a(qVar, h6, this.c, this.f3002a));
        if (aVarPut != null) {
            aVarPut.resource = null;
            aVarPut.clear();
        }
    }

    public void cleanupActiveReference(@NonNull a aVar) {
        O o6;
        synchronized (this) {
            this.activeEngineResources.remove(aVar.f3003a);
            if (aVar.b && (o6 = aVar.resource) != null) {
                this.d.d(aVar.f3003a, new H(o6, true, false, aVar.f3003a, this.d));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public synchronized H get(p126w0.q qVar) {
        a aVar = this.activeEngineResources.get(qVar);
        if (aVar == null) {
            return null;
        }
        H h6 = (H) aVar.get();
        if (h6 == null) {
            cleanupActiveReference(aVar);
        }
        return h6;
    }

    @VisibleForTesting
    public void shutdown() {
        this.e = true;
        Executor executor = this.b;
        if (executor instanceof ExecutorService) {
            L0.i.shutdownAndAwaitTermination((ExecutorService) executor);
        }
    }

    @VisibleForTesting
    public void setDequeuedResourceCallback(InterfaceC0486b interfaceC0486b) {
    }
}
