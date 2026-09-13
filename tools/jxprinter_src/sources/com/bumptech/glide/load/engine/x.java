package com.bumptech.glide.load.engine;

import A3.AbstractC0157z;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class x implements D, com.bumptech.glide.load.engine.cache.g, G {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f3077i = Log.isLoggable("Engine", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L f3078a;
    public final F b;
    public final com.bumptech.glide.load.engine.cache.h c;
    public final C0504u d;
    public final T e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0505v f3079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0502s f3080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0487c f3081h;

    @VisibleForTesting
    public x(com.bumptech.glide.load.engine.cache.h hVar, com.bumptech.glide.load.engine.cache.a aVar, p138y0.e eVar, p138y0.e eVar2, p138y0.e eVar3, p138y0.e eVar4, L l6, F f6, C0487c c0487c, C0504u c0504u, C0502s c0502s, T t6, boolean z6) {
        this.c = hVar;
        C0505v c0505v = new C0505v(aVar);
        this.f3079f = c0505v;
        C0487c c0487c2 = c0487c == null ? new C0487c(z6, Executors.newSingleThreadExecutor(new ThreadFactoryC0485a())) : c0487c;
        this.f3081h = c0487c2;
        synchronized (this) {
            synchronized (c0487c2) {
                c0487c2.d = this;
            }
        }
        this.b = f6 == null ? new F() : f6;
        this.f3078a = l6 == null ? new L() : l6;
        this.d = c0504u == null ? new C0504u(eVar, eVar2, eVar3, eVar4, this, this) : c0504u;
        this.f3080g = c0502s == null ? new C0502s(c0505v) : c0502s;
        this.e = t6 == null ? new T() : t6;
        ((com.bumptech.glide.load.engine.cache.f) hVar).setResourceRemovedListener(this);
    }

    public static void b(String str, long j6, E e) {
        StringBuilder sbX = AbstractC0157z.x(str, " in ");
        sbX.append(L0.l.a(j6));
        sbX.append("ms, key: ");
        sbX.append(e);
        Log.v("Engine", sbX.toString());
    }

    public static void e(O o6) {
        if (!(o6 instanceof H)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((H) o6).b();
    }

    @Nullable
    private H loadFromActiveResources(p126w0.q qVar) {
        H h6 = this.f3081h.get(qVar);
        if (h6 != null) {
            h6.a();
        }
        return h6;
    }

    @Nullable
    private H loadFromMemory(E e, boolean z6, long j6) {
        x xVar;
        E e6;
        H h6;
        if (z6) {
            H hLoadFromActiveResources = loadFromActiveResources(e);
            boolean z7 = f3077i;
            if (hLoadFromActiveResources != null) {
                if (z7) {
                    b("Loaded resource from active resources", j6, e);
                }
                return hLoadFromActiveResources;
            }
            O oRemove = ((com.bumptech.glide.load.engine.cache.f) this.c).remove((p126w0.q) e);
            if (oRemove == null) {
                xVar = this;
                e6 = e;
                h6 = null;
            } else if (oRemove instanceof H) {
                h6 = (H) oRemove;
                xVar = this;
                e6 = e;
            } else {
                xVar = this;
                e6 = e;
                h6 = new H(oRemove, true, true, e6, xVar);
            }
            if (h6 != null) {
                h6.a();
                xVar.f3081h.a(e6, h6);
            }
            if (h6 != null) {
                if (z7) {
                    b("Loaded resource from cache", j6, e6);
                }
                return h6;
            }
        }
        return null;
    }

    public final w a(com.bumptech.glide.j jVar, Object obj, p126w0.q qVar, int i5, int i6, Class cls, Class cls2, com.bumptech.glide.o oVar, AbstractC0501q abstractC0501q, Map map, boolean z6, boolean z7, p126w0.v vVar, boolean z8, boolean z9, boolean z10, boolean z11, I0.m mVar, Executor executor) {
        long logTime = f3077i ? L0.l.getLogTime() : 0L;
        this.b.getClass();
        E e = new E(obj, qVar, i5, i6, map, cls, cls2, vVar);
        synchronized (this) {
            try {
                H hLoadFromMemory = loadFromMemory(e, z8, logTime);
                if (hLoadFromMemory == null) {
                    return f(jVar, obj, qVar, i5, i6, cls, cls2, oVar, abstractC0501q, map, z6, z7, vVar, z8, z9, z10, z11, mVar, executor, e, logTime);
                }
                mVar.f(hLoadFromMemory, p126w0.a.e, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void c(C c, p126w0.q qVar, H h6) {
        if (h6 != null) {
            try {
                if (h6.f2956a) {
                    this.f3081h.a(qVar, h6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        L l6 = this.f3078a;
        l6.getClass();
        HashMap map = c.f2941p ? l6.b : l6.f2962a;
        if (c.equals(map.get(qVar))) {
            map.remove(qVar);
        }
    }

    public final void d(p126w0.q qVar, H h6) {
        C0487c c0487c = this.f3081h;
        synchronized (c0487c) {
            C0487c.a aVarRemove = c0487c.activeEngineResources.remove(qVar);
            if (aVarRemove != null) {
                aVarRemove.resource = null;
                aVarRemove.clear();
            }
        }
        if (h6.f2956a) {
            ((com.bumptech.glide.load.engine.cache.f) this.c).put(qVar, (O) h6);
        } else {
            this.e.a(h6, false);
        }
    }

    public final w f(com.bumptech.glide.j jVar, Object obj, p126w0.q qVar, int i5, int i6, Class cls, Class cls2, com.bumptech.glide.o oVar, AbstractC0501q abstractC0501q, Map map, boolean z6, boolean z7, p126w0.v vVar, boolean z8, boolean z9, boolean z10, boolean z11, I0.m mVar, Executor executor, E e, long j6) {
        p138y0.e eVar;
        L l6 = this.f3078a;
        C c = (C) (z11 ? l6.b : l6.f2962a).get(e);
        if (c != null) {
            c.a(mVar, executor);
            if (f3077i) {
                b("Added to existing load", j6, e);
            }
            return new w(this, mVar, c);
        }
        C cInit = ((C) L0.q.checkNotNull((C) this.d.f3074g.acquire())).init(e, z8, z9, z10, z11);
        C0502s c0502s = this.f3080g;
        RunnableC0497m runnableC0497m = (RunnableC0497m) L0.q.checkNotNull((RunnableC0497m) c0502s.b.acquire());
        int i7 = c0502s.c;
        c0502s.c = i7 + 1;
        C0494j c0494j = runnableC0497m.f3039a;
        C0505v c0505v = runnableC0497m.d;
        c0494j.c = jVar;
        c0494j.d = obj;
        c0494j.f3026n = qVar;
        c0494j.e = i5;
        c0494j.f3018f = i6;
        c0494j.f3028p = abstractC0501q;
        c0494j.f3019g = cls;
        c0494j.f3020h = c0505v;
        c0494j.f3023k = cls2;
        c0494j.f3027o = oVar;
        c0494j.f3021i = vVar;
        c0494j.f3022j = map;
        c0494j.f3029q = z6;
        c0494j.f3030r = z7;
        runnableC0497m.f3042h = jVar;
        runnableC0497m.f3043i = qVar;
        runnableC0497m.f3044j = oVar;
        runnableC0497m.f3045k = e;
        runnableC0497m.f3046l = i5;
        runnableC0497m.f3047m = i6;
        runnableC0497m.f3048n = abstractC0501q;
        runnableC0497m.f3053s = z11;
        runnableC0497m.f3049o = vVar;
        runnableC0497m.f3050p = cInit;
        runnableC0497m.f3051q = i7;
        runnableC0497m.f3038I = 1;
        runnableC0497m.f3054t = obj;
        L l7 = this.f3078a;
        l7.getClass();
        (cInit.f2941p ? l7.b : l7.f2962a).put(e, cInit);
        cInit.a(mVar, executor);
        synchronized (cInit) {
            cInit.f2948w = runnableC0497m;
            int iD = runnableC0497m.d(1);
            if (iD == 2 || iD == 3) {
                eVar = cInit.f2932g;
            } else if (cInit.f2939n) {
                eVar = cInit.f2934i;
            } else {
                eVar = cInit.f2940o ? cInit.f2935j : cInit.f2933h;
            }
            eVar.execute(runnableC0497m);
        }
        if (f3077i) {
            b("Started new load", j6, e);
        }
        return new w(this, mVar, cInit);
    }

    @Override // com.bumptech.glide.load.engine.cache.g
    public void onResourceRemoved(@NonNull O o6) {
        this.e.a(o6, true);
    }

    @VisibleForTesting
    public void shutdown() {
        this.d.shutdown();
        this.f3079f.clearDiskCacheIfCreated();
        this.f3081h.shutdown();
    }
}
