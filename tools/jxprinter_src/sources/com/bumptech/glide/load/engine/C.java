package com.bumptech.glide.load.engine;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class C implements M0.f {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final z f2929z = new z();
    public final G c;
    public final Pools.Pool d;
    public final z e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final D f2931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p138y0.e f2932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p138y0.e f2933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p138y0.e f2934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p138y0.e f2935j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p126w0.q f2937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2941p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public O f2942q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public p126w0.a f2943r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2944s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public J f2945t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2946u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public H f2947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RunnableC0497m f2948w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f2949x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2950y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B f2930a = new B(new ArrayList(2));
    public final M0.j b = M0.j.newInstance();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f2936k = new AtomicInteger();

    @VisibleForTesting
    public C(p138y0.e eVar, p138y0.e eVar2, p138y0.e eVar3, p138y0.e eVar4, D d, G g6, Pools.Pool<C> pool, z zVar) {
        this.f2932g = eVar;
        this.f2933h = eVar2;
        this.f2934i = eVar3;
        this.f2935j = eVar4;
        this.f2931f = d;
        this.c = g6;
        this.d = pool;
        this.e = zVar;
    }

    public final synchronized void a(I0.m mVar, Executor executor) {
        try {
            this.b.a();
            this.f2930a.f2928a.add(new A(mVar, executor));
            if (this.f2944s) {
                d(1);
                executor.execute(new y(this, mVar, 1));
            } else if (this.f2946u) {
                d(1);
                executor.execute(new y(this, mVar, 0));
            } else {
                L0.q.checkArgument(!this.f2949x, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b() {
        if (e()) {
            return;
        }
        this.f2949x = true;
        RunnableC0497m runnableC0497m = this.f2948w;
        runnableC0497m.f3035D = true;
        InterfaceC0493i interfaceC0493i = runnableC0497m.f3033A;
        if (interfaceC0493i != null) {
            interfaceC0493i.cancel();
        }
        D d = this.f2931f;
        p126w0.q qVar = this.f2937l;
        x xVar = (x) d;
        synchronized (xVar) {
            L l6 = xVar.f3078a;
            l6.getClass();
            HashMap map = this.f2941p ? l6.b : l6.f2962a;
            if (equals(map.get(qVar))) {
                map.remove(qVar);
            }
        }
    }

    public final void c() {
        H h6;
        synchronized (this) {
            try {
                this.b.a();
                L0.q.checkArgument(e(), "Not yet complete!");
                int iDecrementAndGet = this.f2936k.decrementAndGet();
                L0.q.checkArgument(iDecrementAndGet >= 0, "Can't decrement below 0");
                if (iDecrementAndGet == 0) {
                    h6 = this.f2947v;
                    f();
                } else {
                    h6 = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (h6 != null) {
            h6.b();
        }
    }

    @GuardedBy("this")
    public void callCallbackOnLoadFailed(I0.k kVar) {
        try {
            ((I0.m) kVar).d(this.f2945t, 5);
        } catch (Throwable th) {
            throw new C0488d(th);
        }
    }

    @GuardedBy("this")
    public void callCallbackOnResourceReady(I0.k kVar) {
        try {
            ((I0.m) kVar).f(this.f2947v, this.f2943r, this.f2950y);
        } catch (Throwable th) {
            throw new C0488d(th);
        }
    }

    public final synchronized void d(int i5) {
        H h6;
        L0.q.checkArgument(e(), "Not yet complete!");
        if (this.f2936k.getAndAdd(i5) == 0 && (h6 = this.f2947v) != null) {
            h6.a();
        }
    }

    public final boolean e() {
        return this.f2946u || this.f2944s || this.f2949x;
    }

    public final synchronized void f() {
        boolean zA;
        if (this.f2937l == null) {
            throw new IllegalArgumentException();
        }
        this.f2930a.f2928a.clear();
        this.f2937l = null;
        this.f2947v = null;
        this.f2942q = null;
        this.f2946u = false;
        this.f2949x = false;
        this.f2944s = false;
        this.f2950y = false;
        RunnableC0497m runnableC0497m = this.f2948w;
        C0496l c0496l = runnableC0497m.f3041g;
        synchronized (c0496l) {
            c0496l.f3032a = true;
            zA = c0496l.a();
        }
        if (zA) {
            runnableC0497m.g();
        }
        this.f2948w = null;
        this.f2945t = null;
        this.f2943r = null;
        this.d.release(this);
    }

    public final synchronized void g(I0.m mVar) {
        try {
            this.b.a();
            this.f2930a.f2928a.remove(new A(mVar, L0.i.b));
            if (this.f2930a.f2928a.isEmpty()) {
                b();
                if (this.f2944s || this.f2946u) {
                    if (this.f2936k.get() == 0) {
                        f();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // M0.f
    @NonNull
    public M0.j getVerifier() {
        return this.b;
    }

    @VisibleForTesting
    public synchronized C init(p126w0.q qVar, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.f2937l = qVar;
        this.f2938m = z6;
        this.f2939n = z7;
        this.f2940o = z8;
        this.f2941p = z9;
        return this;
    }
}
