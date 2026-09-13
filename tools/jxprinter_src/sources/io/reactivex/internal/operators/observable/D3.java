package io.reactivex.internal.operators.observable;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D3 extends p048i3.s implements p011b3.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final io.reactivex.G f4900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p027e3.o f4901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f4902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p011b3.b f4903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p011b3.c f4904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicReference f4905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f4906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicLong f4907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f4908o;

    public D3(p112t3.e eVar, io.reactivex.G g6, p027e3.o oVar, int i5) {
        super(eVar, new p083o3.b());
        this.f4905l = new AtomicReference();
        AtomicLong atomicLong = new AtomicLong();
        this.f4907n = atomicLong;
        this.f4908o = new AtomicBoolean();
        this.f4900g = g6;
        this.f4901h = oVar;
        this.f4902i = i5;
        this.f4903j = new p011b3.b();
        this.f4906m = new ArrayList();
        atomicLong.lazySet(1L);
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f4908o.compareAndSet(false, true)) {
            p033f3.d.a(this.f4905l);
            if (this.f4907n.decrementAndGet() == 0) {
                this.f4904k.dispose();
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4908o.get();
    }

    public final void h() {
        p083o3.b bVar = this.c;
        p112t3.e eVar = this.b;
        ArrayList arrayList = this.f4906m;
        int iAddAndGet = 1;
        while (true) {
            boolean z6 = this.e;
            Object objPoll = bVar.poll();
            int i5 = 0;
            boolean z7 = objPoll == null;
            if (z6 && z7) {
                this.f4903j.dispose();
                p033f3.d.a(this.f4905l);
                Throwable th = this.f4061f;
                if (th != null) {
                    int size = arrayList.size();
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        i5++;
                        ((p129w3.f) obj).onError(th);
                    }
                } else {
                    int size2 = arrayList.size();
                    while (i5 < size2) {
                        Object obj2 = arrayList.get(i5);
                        i5++;
                        ((p129w3.f) obj2).onComplete();
                    }
                }
                arrayList.clear();
                return;
            }
            if (z7) {
                iAddAndGet = this.f4060a.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (objPoll instanceof E3) {
                E3 e6 = (E3) objPoll;
                p129w3.f fVar = e6.f4917a;
                if (fVar != null) {
                    if (arrayList.remove(fVar)) {
                        e6.f4917a.onComplete();
                        if (this.f4907n.decrementAndGet() == 0) {
                            this.f4903j.dispose();
                            p033f3.d.a(this.f4905l);
                            return;
                        }
                    } else {
                        continue;
                    }
                } else if (!this.f4908o.get()) {
                    p129w3.f fVarCreate = p129w3.f.create(this.f4902i);
                    arrayList.add(fVarCreate);
                    eVar.onNext(fVarCreate);
                    try {
                        Object objApply = this.f4901h.apply(e6.b);
                        p039g3.A.b(objApply, "The ObservableSource supplied is null");
                        io.reactivex.G g6 = (io.reactivex.G) objApply;
                        C3 c6 = new C3(this, fVarCreate);
                        if (this.f4903j.add(c6)) {
                            this.f4907n.getAndIncrement();
                            g6.subscribe(c6);
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        this.f4908o.set(true);
                        eVar.onError(th2);
                    }
                }
            } else {
                int size3 = arrayList.size();
                while (i5 < size3) {
                    Object obj3 = arrayList.get(i5);
                    i5++;
                    ((p129w3.f) obj3).onNext(objPoll);
                }
            }
        }
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.e) {
            return;
        }
        this.e = true;
        if (c()) {
            h();
        }
        if (this.f4907n.decrementAndGet() == 0) {
            this.f4903j.dispose();
        }
        this.b.onComplete();
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onError(Throwable th) {
        if (this.e) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4061f = th;
        this.e = true;
        if (c()) {
            h();
        }
        if (this.f4907n.decrementAndGet() == 0) {
            this.f4903j.dispose();
        }
        this.b.onError(th);
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onNext(Object obj) {
        if (d()) {
            ArrayList arrayList = this.f4906m;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj2 = arrayList.get(i5);
                i5++;
                ((p129w3.f) obj2).onNext(obj);
            }
            if (this.f4060a.addAndGet(-1) == 0) {
                return;
            }
        } else {
            this.c.offer(obj);
            if (!c()) {
                return;
            }
        }
        h();
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        AtomicReference atomicReference;
        if (p033f3.d.g(this.f4904k, cVar)) {
            this.f4904k = cVar;
            this.b.onSubscribe(this);
            if (this.f4908o.get()) {
                return;
            }
            C0954y c0954y = new C0954y(this, 1);
            do {
                atomicReference = this.f4905l;
                if (atomicReference.compareAndSet(null, c0954y)) {
                    this.f4900g.subscribe(c0954y);
                    return;
                }
            } while (atomicReference.get() == null);
        }
    }

    @Override // p048i3.s
    public final void b(io.reactivex.I i5, Object obj) {
    }
}
