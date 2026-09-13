package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.manager.C0537g;
import com.bumptech.glide.manager.InterfaceC0535e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public com.bumptech.glide.load.engine.x c;
    public com.bumptech.glide.load.engine.bitmap_recycle.c d;

    @Nullable
    private List<I0.i> defaultRequestListeners;
    public com.bumptech.glide.load.engine.bitmap_recycle.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bumptech.glide.load.engine.cache.h f2898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p138y0.e f2899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p138y0.e f2900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bumptech.glide.load.engine.cache.a f2901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bumptech.glide.load.engine.cache.k f2902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public InterfaceC0535e f2903k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public p138y0.e f2906n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2907o;

    @Nullable
    private com.bumptech.glide.manager.u requestManagerFactory;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap f2897a = new ArrayMap();
    public final p075n1.a b = new p075n1.a(6);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2904l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public InterfaceC0484b f2905m = new d();

    @NonNull
    public i addGlobalRequestListener(@NonNull I0.i iVar) {
        if (this.defaultRequestListeners == null) {
            this.defaultRequestListeners = new ArrayList();
        }
        this.defaultRequestListeners.add(iVar);
        return this;
    }

    @NonNull
    public c build(@NonNull Context context, List<Object> list, G0.a aVar) {
        if (this.f2899g == null) {
            this.f2899g = p138y0.e.a().a();
        }
        if (this.f2900h == null) {
            int i5 = p138y0.e.c;
            p138y0.a threadCount = new p138y0.a(true).setThreadCount(1);
            threadCount.d = "disk-cache";
            this.f2900h = threadCount.a();
        }
        if (this.f2906n == null) {
            if (p138y0.e.c == 0) {
                p138y0.e.c = Math.min(4, Runtime.getRuntime().availableProcessors());
            }
            p138y0.a threadCount2 = new p138y0.a(true).setThreadCount(p138y0.e.c >= 4 ? 2 : 1);
            threadCount2.d = "animation";
            this.f2906n = threadCount2.a();
        }
        if (this.f2902j == null) {
            this.f2902j = new com.bumptech.glide.load.engine.cache.k(new com.bumptech.glide.load.engine.cache.i(context));
        }
        if (this.f2903k == null) {
            this.f2903k = new C0537g();
        }
        if (this.d == null) {
            int i6 = this.f2902j.f3008a;
            if (i6 > 0) {
                this.d = new com.bumptech.glide.load.engine.bitmap_recycle.k(i6);
            } else {
                this.d = new com.bumptech.glide.load.engine.bitmap_recycle.d();
            }
        }
        if (this.e == null) {
            this.e = new com.bumptech.glide.load.engine.bitmap_recycle.j(this.f2902j.c);
        }
        if (this.f2898f == null) {
            this.f2898f = new com.bumptech.glide.load.engine.cache.f(this.f2902j.b);
        }
        if (this.f2901i == null) {
            this.f2901i = new S4.h(context);
        }
        if (this.c == null) {
            this.c = new com.bumptech.glide.load.engine.x(this.f2898f, this.f2901i, this.f2900h, this.f2899g, new p138y0.e(new ThreadPoolExecutor(0, Integer.MAX_VALUE, p138y0.e.b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new p138y0.c(new p138y0.b(), "source-unlimited", p138y0.d.f9030m0, false))), this.f2906n, null, null, null, null, null, null, this.f2907o);
        }
        List<I0.i> list2 = this.defaultRequestListeners;
        if (list2 == null) {
            this.defaultRequestListeners = Collections.EMPTY_LIST;
        } else {
            this.defaultRequestListeners = Collections.unmodifiableList(list2);
        }
        p075n1.a aVar2 = this.b;
        aVar2.getClass();
        l lVar = new l(aVar2);
        return new c(context, this.c, this.f2898f, this.d, this.e, new com.bumptech.glide.manager.v(this.requestManagerFactory, lVar), this.f2903k, this.f2904l, this.f2905m, this.f2897a, this.defaultRequestListeners, list, aVar, lVar);
    }

    @NonNull
    public i setAnimationExecutor(@Nullable p138y0.e eVar) {
        this.f2906n = eVar;
        return this;
    }

    @NonNull
    public i setArrayPool(@Nullable com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.e = aVar;
        return this;
    }

    @NonNull
    public i setBitmapPool(@Nullable com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.d = cVar;
        return this;
    }

    @NonNull
    public i setConnectivityMonitorFactory(@Nullable InterfaceC0535e interfaceC0535e) {
        this.f2903k = interfaceC0535e;
        return this;
    }

    @NonNull
    public i setDefaultRequestOptions(@Nullable I0.j jVar) {
        return setDefaultRequestOptions(new e(jVar));
    }

    @NonNull
    public <T> i setDefaultTransitionOptions(@NonNull Class<T> cls, @Nullable B b) {
        this.f2897a.put(cls, b);
        return this;
    }

    @NonNull
    public i setDiskCache(@Nullable com.bumptech.glide.load.engine.cache.a aVar) {
        this.f2901i = aVar;
        return this;
    }

    @NonNull
    public i setDiskCacheExecutor(@Nullable p138y0.e eVar) {
        this.f2900h = eVar;
        return this;
    }

    @NonNull
    public i setIsActiveResourceRetentionAllowed(boolean z6) {
        this.f2907o = z6;
        return this;
    }

    @NonNull
    public i setLogLevel(int i5) {
        if (i5 < 2 || i5 > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.f2904l = i5;
        return this;
    }

    @NonNull
    public i setMemoryCache(@Nullable com.bumptech.glide.load.engine.cache.h hVar) {
        this.f2898f = hVar;
        return this;
    }

    @NonNull
    public i setMemorySizeCalculator(@NonNull com.bumptech.glide.load.engine.cache.i iVar) {
        iVar.getClass();
        return setMemorySizeCalculator(new com.bumptech.glide.load.engine.cache.k(iVar));
    }

    public void setRequestManagerFactory(@Nullable com.bumptech.glide.manager.u uVar) {
        this.requestManagerFactory = uVar;
    }

    @Deprecated
    public i setResizeExecutor(@Nullable p138y0.e eVar) {
        return setSourceExecutor(eVar);
    }

    @NonNull
    public i setSourceExecutor(@Nullable p138y0.e eVar) {
        this.f2899g = eVar;
        return this;
    }

    @NonNull
    public i setDefaultRequestOptions(@NonNull InterfaceC0484b interfaceC0484b) {
        this.f2905m = (InterfaceC0484b) L0.q.checkNotNull(interfaceC0484b);
        return this;
    }

    @NonNull
    public i setMemorySizeCalculator(@Nullable com.bumptech.glide.load.engine.cache.k kVar) {
        this.f2902j = kVar;
        return this;
    }
}
