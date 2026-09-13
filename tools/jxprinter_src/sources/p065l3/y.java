package p065l3;

import io.reactivex.AbstractC0985s;
import io.reactivex.I;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p027e3.o;
import p039g3.A;
import p083o3.d;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends AtomicInteger implements I, c {
    private static final long serialVersionUID = -9140123220065488293L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f5889a;
    public final o b;
    public final p100r3.c c = new p100r3.c();
    public final x d = new x(this);
    public final d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f5891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f5894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile int f5895k;

    public y(I i5, o oVar, int i6, int i7) {
        this.f5889a = i5;
        this.b = oVar;
        this.f5890f = i7;
        this.e = new d(i6);
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        I i5 = this.f5889a;
        int i6 = this.f5890f;
        d dVar = this.e;
        p100r3.c cVar = this.c;
        int iAddAndGet = 1;
        while (true) {
            if (!this.f5893i) {
                int i7 = this.f5895k;
                if (cVar.get() != null && (i6 == 1 || (i6 == 2 && i7 == 0))) {
                    break;
                }
                if (i7 == 0) {
                    boolean z6 = this.f5892h;
                    Object objPoll = dVar.poll();
                    boolean z7 = objPoll == null;
                    if (z6 && z7) {
                        Throwable thB = g.b(cVar);
                        if (thB == null) {
                            i5.onComplete();
                            return;
                        } else {
                            i5.onError(thB);
                            return;
                        }
                    }
                    if (!z7) {
                        try {
                            Object objApply = this.b.apply(objPoll);
                            A.b(objApply, "The mapper returned a null MaybeSource");
                            io.reactivex.y yVar = (io.reactivex.y) objApply;
                            this.f5895k = 1;
                            ((AbstractC0985s) yVar).subscribe(this.d);
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            this.f5891g.dispose();
                            dVar.clear();
                            g.a(cVar, th);
                            i5.onError(g.b(cVar));
                            return;
                        }
                    }
                } else if (i7 == 2) {
                    Object obj = this.f5894j;
                    this.f5894j = null;
                    i5.onNext(obj);
                    this.f5895k = 0;
                }
            } else {
                dVar.clear();
                this.f5894j = null;
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        dVar.clear();
        this.f5894j = null;
        i5.onError(g.b(cVar));
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5893i = true;
        this.f5891g.dispose();
        x xVar = this.d;
        xVar.getClass();
        p033f3.d.a(xVar);
        if (getAndIncrement() == 0) {
            this.e.clear();
            this.f5894j = null;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5893i;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5892h = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p100r3.c cVar = this.c;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (this.f5890f == 1) {
            x xVar = this.d;
            xVar.getClass();
            p033f3.d.a(xVar);
        }
        this.f5892h = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.e.offer(obj);
        a();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        if (p033f3.d.g(this.f5891g, cVar)) {
            this.f5891g = cVar;
            this.f5889a.onSubscribe(this);
        }
    }
}
