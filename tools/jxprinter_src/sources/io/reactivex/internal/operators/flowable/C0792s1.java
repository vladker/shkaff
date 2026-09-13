package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.s1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0792s1 extends AtomicReference implements io.reactivex.S, p011b3.c {
    private static final long serialVersionUID = -502562646270949838L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0798t1 f4762a;

    public C0792s1(C0798t1 c0798t1) {
        this.f4762a = c0798t1;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) get());
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        C0798t1 c0798t1 = this.f4762a;
        p011b3.b bVar = c0798t1.e;
        bVar.delete(this);
        p100r3.c cVar = c0798t1.f4772g;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        if (!c0798t1.b) {
            c0798t1.f4775j.cancel();
            bVar.dispose();
        } else if (c0798t1.c != Integer.MAX_VALUE) {
            c0798t1.f4775j.request(1L);
        }
        c0798t1.f4771f.decrementAndGet();
        if (c0798t1.getAndIncrement() == 0) {
            c0798t1.a();
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0093 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        p083o3.d dVarB;
        C0798t1 c0798t1 = this.f4762a;
        c0798t1.e.delete(this);
        if (c0798t1.get() == 0) {
            if (c0798t1.compareAndSet(0, 1)) {
                boolean z6 = c0798t1.f4771f.decrementAndGet() == 0;
                if (c0798t1.d.get() != 0) {
                    c0798t1.f4770a.onNext(obj);
                    p083o3.d dVar = (p083o3.d) c0798t1.f4774i.get();
                    if (z6 && (dVar == null || dVar.isEmpty())) {
                        p100r3.c cVar = c0798t1.f4772g;
                        cVar.getClass();
                        Throwable thB = p100r3.g.b(cVar);
                        if (thB != null) {
                            c0798t1.f4770a.onError(thB);
                            return;
                        } else {
                            c0798t1.f4770a.onComplete();
                            return;
                        }
                    }
                    p122v2.a.e(c0798t1.d, 1L);
                    if (c0798t1.c != Integer.MAX_VALUE) {
                        c0798t1.f4775j.request(1L);
                    }
                } else {
                    p083o3.d dVarB2 = c0798t1.b();
                    synchronized (dVarB2) {
                        dVarB2.offer(obj);
                    }
                }
                if (c0798t1.decrementAndGet() == 0) {
                    return;
                }
            } else {
                dVarB = c0798t1.b();
                synchronized (dVarB) {
                    dVarB.offer(obj);
                }
                c0798t1.f4771f.decrementAndGet();
                if (c0798t1.getAndIncrement() != 0) {
                    return;
                }
            }
        } else {
            dVarB = c0798t1.b();
            synchronized (dVarB) {
                dVarB.offer(obj);
                c0798t1.f4771f.decrementAndGet();
                if (c0798t1.getAndIncrement() != 0) {
                    return;
                }
            }
        }
        c0798t1.a();
    }
}
