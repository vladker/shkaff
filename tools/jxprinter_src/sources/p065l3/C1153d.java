package p065l3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p017c3.e;
import p027e3.o;
import p039g3.A;
import p100r3.g;
import t5.d;

/* JADX INFO: renamed from: l3.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1153d extends AtomicInteger implements InterfaceC0984q, c {
    private static final long serialVersionUID = 3610901111000061034L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5821a;
    public final o b;
    public final int c;
    public final p100r3.c d = new p100r3.c();
    public final C1152c e = new C1152c(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p083o3.c f5823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f5824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f5826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f5827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5828l;

    public C1153d(InterfaceC0679f interfaceC0679f, o oVar, int i5, int i6) {
        this.f5821a = interfaceC0679f;
        this.b = oVar;
        this.c = i5;
        this.f5822f = i6;
        this.f5823g = new p083o3.c(i6);
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        while (!this.f5827k) {
            if (!this.f5825i) {
                if (this.c == 2 && this.d.get() != null) {
                    this.f5823g.clear();
                    p100r3.c cVar = this.d;
                    cVar.getClass();
                    this.f5821a.onError(g.b(cVar));
                    return;
                }
                boolean z6 = this.f5826j;
                Object objPoll = this.f5823g.poll();
                boolean z7 = objPoll == null;
                if (z6 && z7) {
                    p100r3.c cVar2 = this.d;
                    cVar2.getClass();
                    Throwable thB = g.b(cVar2);
                    if (thB != null) {
                        this.f5821a.onError(thB);
                        return;
                    } else {
                        this.f5821a.onComplete();
                        return;
                    }
                }
                if (!z7) {
                    int i5 = this.f5822f;
                    int i6 = i5 - (i5 >> 1);
                    int i7 = this.f5828l + 1;
                    if (i7 == i6) {
                        this.f5828l = 0;
                        this.f5824h.request(i6);
                    } else {
                        this.f5828l = i7;
                    }
                    try {
                        Object objApply = this.b.apply(objPoll);
                        A.b(objApply, "The mapper returned a null CompletableSource");
                        InterfaceC0682i interfaceC0682i = (InterfaceC0682i) objApply;
                        this.f5825i = true;
                        ((AbstractC0676c) interfaceC0682i).subscribe(this.e);
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        this.f5823g.clear();
                        this.f5824h.cancel();
                        p100r3.c cVar3 = this.d;
                        cVar3.getClass();
                        g.a(cVar3, th);
                        p100r3.c cVar4 = this.d;
                        cVar4.getClass();
                        this.f5821a.onError(g.b(cVar4));
                        return;
                    }
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        this.f5823g.clear();
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5827k = true;
        this.f5824h.cancel();
        C1152c c1152c = this.e;
        c1152c.getClass();
        p033f3.d.a(c1152c);
        if (getAndIncrement() == 0) {
            this.f5823g.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5827k;
    }

    @Override // t5.c
    public final void onComplete() {
        this.f5826j = true;
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p100r3.c cVar = this.d;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (this.c != 1) {
            this.f5826j = true;
            a();
            return;
        }
        C1152c c1152c = this.e;
        c1152c.getClass();
        p033f3.d.a(c1152c);
        p100r3.c cVar2 = this.d;
        cVar2.getClass();
        Throwable thB = g.b(cVar2);
        if (thB != g.f7961a) {
            this.f5821a.onError(thB);
        }
        if (getAndIncrement() == 0) {
            this.f5823g.clear();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f5823g.offer(obj)) {
            a();
        } else {
            this.f5824h.cancel();
            onError(new e("Queue full?!"));
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (p094q3.g.g(this.f5824h, dVar)) {
            this.f5824h = dVar;
            this.f5821a.onSubscribe(this);
            dVar.request(this.f5822f);
        }
    }
}
