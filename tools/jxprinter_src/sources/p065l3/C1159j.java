package p065l3;

import io.reactivex.InterfaceC0984q;
import io.reactivex.O;
import io.reactivex.V;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p017c3.e;
import p027e3.o;
import p039g3.A;
import p100r3.g;
import t5.c;
import t5.d;

/* JADX INFO: renamed from: l3.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1159j extends AtomicInteger implements InterfaceC0984q, d {
    private static final long serialVersionUID = -9140123220065488293L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5844a;
    public final o b;
    public final int c;
    public final AtomicLong d = new AtomicLong();
    public final p100r3.c e = new p100r3.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1158i f5845f = new C1158i(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p083o3.c f5846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f5848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f5849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f5850k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5851l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5852m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f5853n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile int f5854o;

    public C1159j(c cVar, o oVar, int i5, int i6) {
        this.f5844a = cVar;
        this.b = oVar;
        this.c = i5;
        this.f5847h = i6;
        this.f5846g = new p083o3.c(i5);
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        c cVar = this.f5844a;
        int i5 = this.f5847h;
        p083o3.c cVar2 = this.f5846g;
        p100r3.c cVar3 = this.e;
        AtomicLong atomicLong = this.d;
        int i6 = this.c;
        int i7 = i6 - (i6 >> 1);
        int iAddAndGet = 1;
        while (true) {
            if (!this.f5850k) {
                int i8 = this.f5854o;
                if (cVar3.get() != null && (i5 == 1 || (i5 == 2 && i8 == 0))) {
                    break;
                }
                if (i8 == 0) {
                    boolean z6 = this.f5849j;
                    Object objPoll = cVar2.poll();
                    boolean z7 = objPoll == null;
                    if (z6 && z7) {
                        Throwable thB = g.b(cVar3);
                        if (thB == null) {
                            cVar.onComplete();
                            return;
                        } else {
                            cVar.onError(thB);
                            return;
                        }
                    }
                    if (!z7) {
                        int i9 = this.f5852m + 1;
                        if (i9 == i7) {
                            this.f5852m = 0;
                            this.f5848i.request(i7);
                        } else {
                            this.f5852m = i9;
                        }
                        try {
                            Object objApply = this.b.apply(objPoll);
                            A.b(objApply, "The mapper returned a null SingleSource");
                            V v6 = (V) objApply;
                            this.f5854o = 1;
                            ((O) v6).subscribe(this.f5845f);
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            this.f5848i.cancel();
                            cVar2.clear();
                            g.a(cVar3, th);
                            cVar.onError(g.b(cVar3));
                            return;
                        }
                    }
                } else if (i8 == 2) {
                    long j6 = this.f5851l;
                    if (j6 != atomicLong.get()) {
                        Object obj = this.f5853n;
                        this.f5853n = null;
                        cVar.onNext(obj);
                        this.f5851l = j6 + 1;
                        this.f5854o = 0;
                    }
                }
            } else {
                cVar2.clear();
                this.f5853n = null;
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        cVar2.clear();
        this.f5853n = null;
        cVar.onError(g.b(cVar3));
    }

    @Override // t5.d
    public final void cancel() {
        this.f5850k = true;
        this.f5848i.cancel();
        C1158i c1158i = this.f5845f;
        c1158i.getClass();
        p033f3.d.a(c1158i);
        if (getAndIncrement() == 0) {
            this.f5846g.clear();
            this.f5853n = null;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f5849j = true;
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p100r3.c cVar = this.e;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (this.f5847h == 1) {
            C1158i c1158i = this.f5845f;
            c1158i.getClass();
            p033f3.d.a(c1158i);
        }
        this.f5849j = true;
        a();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f5846g.offer(obj)) {
            a();
        } else {
            this.f5848i.cancel();
            onError(new e("queue full?!"));
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (p094q3.g.g(this.f5848i, dVar)) {
            this.f5848i = dVar;
            this.f5844a.onSubscribe(this);
            dVar.request(this.c);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        p122v2.a.a(this.d, j6);
        a();
    }
}
