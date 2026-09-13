package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z4 extends p088p3.k implements t5.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t5.b f4532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p027e3.o f4533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p011b3.b f4535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public t5.d f4536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicReference f4537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f4538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicLong f4539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f4540p;

    public Z4(p135x3.c cVar, t5.b bVar, p027e3.o oVar, int i5) {
        super(cVar, new p083o3.b());
        this.f4537m = new AtomicReference();
        AtomicLong atomicLong = new AtomicLong();
        this.f4539o = atomicLong;
        this.f4540p = new AtomicBoolean();
        this.f4532h = bVar;
        this.f4533i = oVar;
        this.f4534j = i5;
        this.f4535k = new p011b3.b();
        this.f4538n = new ArrayList();
        atomicLong.lazySet(1L);
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f4540p.compareAndSet(false, true)) {
            p033f3.d.a(this.f4537m);
            if (this.f4539o.decrementAndGet() == 0) {
                this.f4536l.cancel();
            }
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f7748f) {
            return;
        }
        this.f7748f = true;
        if (p()) {
            u();
        }
        if (this.f4539o.decrementAndGet() == 0) {
            this.f4535k.dispose();
        }
        this.c.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f7748f) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f7749g = th;
        this.f7748f = true;
        if (p()) {
            u();
        }
        if (this.f4539o.decrementAndGet() == 0) {
            this.f4535k.dispose();
        }
        this.c.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f7748f) {
            return;
        }
        if (q()) {
            ArrayList arrayList = this.f4538n;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj2 = arrayList.get(i5);
                i5++;
                ((p123v3.d) obj2).onNext(obj);
            }
            if (this.f7747a.addAndGet(-1) == 0) {
                return;
            }
        } else {
            this.d.offer(obj);
            if (!p()) {
                return;
            }
        }
        u();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        AtomicReference atomicReference;
        if (p094q3.g.g(this.f4536l, dVar)) {
            this.f4536l = dVar;
            this.c.onSubscribe(this);
            if (this.f4540p.get()) {
                return;
            }
            E e = new E(this, 1);
            do {
                atomicReference = this.f4537m;
                if (atomicReference.compareAndSet(null, e)) {
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                    this.f4532h.subscribe(e);
                    return;
                }
            } while (atomicReference.get() == null);
        }
    }

    public final void u() {
        p083o3.b bVar = this.d;
        p135x3.c cVar = this.c;
        ArrayList arrayList = this.f4538n;
        int iAddAndGet = 1;
        while (true) {
            boolean z6 = this.f7748f;
            Object objPoll = bVar.poll();
            int i5 = 0;
            boolean z7 = objPoll == null;
            if (z6 && z7) {
                this.f4535k.dispose();
                p033f3.d.a(this.f4537m);
                Throwable th = this.f7749g;
                if (th != null) {
                    int size = arrayList.size();
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        i5++;
                        ((p123v3.d) obj).onError(th);
                    }
                } else {
                    int size2 = arrayList.size();
                    while (i5 < size2) {
                        Object obj2 = arrayList.get(i5);
                        i5++;
                        ((p123v3.d) obj2).onComplete();
                    }
                }
                arrayList.clear();
                return;
            }
            if (z7) {
                iAddAndGet = this.f7747a.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (objPoll instanceof a5) {
                a5 a5Var = (a5) objPoll;
                p123v3.d dVar = a5Var.f4555a;
                if (dVar != null) {
                    if (arrayList.remove(dVar)) {
                        a5Var.f4555a.onComplete();
                        if (this.f4539o.decrementAndGet() == 0) {
                            this.f4535k.dispose();
                            p033f3.d.a(this.f4537m);
                            return;
                        }
                    } else {
                        continue;
                    }
                } else if (!this.f4540p.get()) {
                    p123v3.d dVarCreate = p123v3.d.create(this.f4534j);
                    long j6 = this.b.get();
                    if (j6 != 0) {
                        arrayList.add(dVarCreate);
                        cVar.onNext(dVarCreate);
                        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                            t(1L);
                        }
                        try {
                            Object objApply = this.f4533i.apply(a5Var.b);
                            p039g3.A.b(objApply, "The publisher supplied is null");
                            t5.b bVar2 = (t5.b) objApply;
                            Y4 y6 = new Y4(this, dVarCreate);
                            if (this.f4535k.add(y6)) {
                                this.f4539o.getAndIncrement();
                                bVar2.subscribe(y6);
                            }
                        } catch (Throwable th2) {
                            cancel();
                            cVar.onError(th2);
                        }
                    } else {
                        cancel();
                        cVar.onError(new p017c3.e("Could not deliver new window due to lack of requests"));
                    }
                }
            } else {
                int size3 = arrayList.size();
                while (i5 < size3) {
                    Object obj3 = arrayList.get(i5);
                    i5++;
                    ((p123v3.d) obj3).onNext(objPoll);
                }
            }
        }
    }
}
