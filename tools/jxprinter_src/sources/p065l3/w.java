package p065l3;

import io.reactivex.AbstractC0676c;
import io.reactivex.I;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p017c3.d;
import p027e3.o;
import p039g3.A;
import p043h3.e;
import p043h3.j;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends AtomicInteger implements I, c {
    private static final long serialVersionUID = 3610901111000061034L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5881a;
    public final o b;
    public final int c;
    public final p100r3.c d = new p100r3.c();
    public final v e = new v(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f5883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f5884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f5886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f5887k;

    public w(InterfaceC0679f interfaceC0679f, o oVar, int i5, int i6) {
        this.f5881a = interfaceC0679f;
        this.b = oVar;
        this.c = i5;
        this.f5882f = i6;
    }

    public final void a() {
        InterfaceC0682i interfaceC0682i;
        boolean z6;
        if (getAndIncrement() != 0) {
            return;
        }
        p100r3.c cVar = this.d;
        int i5 = this.c;
        while (!this.f5887k) {
            if (!this.f5885i) {
                if (i5 == 2 && cVar.get() != null) {
                    this.f5887k = true;
                    this.f5883g.clear();
                    this.f5881a.onError(g.b(cVar));
                    return;
                }
                boolean z7 = this.f5886j;
                try {
                    Object objPoll = this.f5883g.poll();
                    if (objPoll != null) {
                        Object objApply = this.b.apply(objPoll);
                        A.b(objApply, "The mapper returned a null CompletableSource");
                        interfaceC0682i = (InterfaceC0682i) objApply;
                        z6 = false;
                    } else {
                        interfaceC0682i = null;
                        z6 = true;
                    }
                    if (z7 && z6) {
                        this.f5887k = true;
                        cVar.getClass();
                        Throwable thB = g.b(cVar);
                        if (thB != null) {
                            this.f5881a.onError(thB);
                            return;
                        } else {
                            this.f5881a.onComplete();
                            return;
                        }
                    }
                    if (!z6) {
                        this.f5885i = true;
                        ((AbstractC0676c) interfaceC0682i).subscribe(this.e);
                    }
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    this.f5887k = true;
                    this.f5883g.clear();
                    this.f5884h.dispose();
                    cVar.getClass();
                    g.a(cVar, th);
                    this.f5881a.onError(g.b(cVar));
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        this.f5883g.clear();
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5887k = true;
        this.f5884h.dispose();
        v vVar = this.e;
        vVar.getClass();
        p033f3.d.a(vVar);
        if (getAndIncrement() == 0) {
            this.f5883g.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5887k;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5886j = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p100r3.c cVar = this.d;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (this.c != 1) {
            this.f5886j = true;
            a();
            return;
        }
        this.f5887k = true;
        v vVar = this.e;
        vVar.getClass();
        p033f3.d.a(vVar);
        p100r3.c cVar2 = this.d;
        cVar2.getClass();
        Throwable thB = g.b(cVar2);
        if (thB != g.f7961a) {
            this.f5881a.onError(thB);
        }
        if (getAndIncrement() == 0) {
            this.f5883g.clear();
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (obj != null) {
            this.f5883g.offer(obj);
        }
        a();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        if (p033f3.d.g(this.f5884h, cVar)) {
            this.f5884h = cVar;
            if (cVar instanceof e) {
                e eVar = (e) cVar;
                int iC = eVar.c(3);
                if (iC == 1) {
                    this.f5883g = eVar;
                    this.f5886j = true;
                    this.f5881a.onSubscribe(this);
                    a();
                    return;
                }
                if (iC == 2) {
                    this.f5883g = eVar;
                    this.f5881a.onSubscribe(this);
                    return;
                }
            }
            this.f5883g = new p083o3.d(this.f5882f);
            this.f5881a.onSubscribe(this);
        }
    }
}
