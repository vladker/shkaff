package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.p1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0775p1 extends AtomicReference implements InterfaceC0988v, p011b3.c {
    private static final long serialVersionUID = -502562646270949838L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0781q1 f4726a;

    public C0775p1(C0781q1 c0781q1) {
        this.f4726a = c0781q1;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) get());
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        C0781q1 c0781q1 = this.f4726a;
        int i5 = c0781q1.c;
        t5.c cVar = c0781q1.f4734a;
        AtomicInteger atomicInteger = c0781q1.f4735f;
        c0781q1.e.delete(this);
        if (c0781q1.get() == 0) {
            if (c0781q1.compareAndSet(0, 1)) {
                boolean z6 = atomicInteger.decrementAndGet() == 0;
                p083o3.d dVar = (p083o3.d) c0781q1.f4738i.get();
                if (!z6 || (dVar != null && !dVar.isEmpty())) {
                    if (i5 != Integer.MAX_VALUE) {
                        c0781q1.f4739j.request(1L);
                    }
                    if (c0781q1.decrementAndGet() == 0) {
                        return;
                    }
                    c0781q1.a();
                    return;
                }
                p100r3.c cVar2 = c0781q1.f4736g;
                cVar2.getClass();
                Throwable thB = p100r3.g.b(cVar2);
                if (thB != null) {
                    cVar.onError(thB);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
        }
        atomicInteger.decrementAndGet();
        if (i5 != Integer.MAX_VALUE) {
            c0781q1.f4739j.request(1L);
        }
        if (c0781q1.getAndIncrement() == 0) {
            c0781q1.a();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        C0781q1 c0781q1 = this.f4726a;
        p011b3.b bVar = c0781q1.e;
        bVar.delete(this);
        p100r3.c cVar = c0781q1.f4736g;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        if (!c0781q1.b) {
            c0781q1.f4739j.cancel();
            bVar.dispose();
        } else if (c0781q1.c != Integer.MAX_VALUE) {
            c0781q1.f4739j.request(1L);
        }
        c0781q1.f4735f.decrementAndGet();
        if (c0781q1.getAndIncrement() == 0) {
            c0781q1.a();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0093 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        p083o3.d dVarB;
        C0781q1 c0781q1 = this.f4726a;
        c0781q1.e.delete(this);
        if (c0781q1.get() == 0) {
            if (c0781q1.compareAndSet(0, 1)) {
                boolean z6 = c0781q1.f4735f.decrementAndGet() == 0;
                if (c0781q1.d.get() != 0) {
                    c0781q1.f4734a.onNext(obj);
                    p083o3.d dVar = (p083o3.d) c0781q1.f4738i.get();
                    if (z6 && (dVar == null || dVar.isEmpty())) {
                        p100r3.c cVar = c0781q1.f4736g;
                        cVar.getClass();
                        Throwable thB = p100r3.g.b(cVar);
                        if (thB != null) {
                            c0781q1.f4734a.onError(thB);
                            return;
                        } else {
                            c0781q1.f4734a.onComplete();
                            return;
                        }
                    }
                    p122v2.a.e(c0781q1.d, 1L);
                    if (c0781q1.c != Integer.MAX_VALUE) {
                        c0781q1.f4739j.request(1L);
                    }
                } else {
                    p083o3.d dVarB2 = c0781q1.b();
                    synchronized (dVarB2) {
                        dVarB2.offer(obj);
                    }
                }
                if (c0781q1.decrementAndGet() == 0) {
                    return;
                }
            } else {
                dVarB = c0781q1.b();
                synchronized (dVarB) {
                    dVarB.offer(obj);
                }
                c0781q1.f4735f.decrementAndGet();
                if (c0781q1.getAndIncrement() != 0) {
                    return;
                }
            }
        } else {
            dVarB = c0781q1.b();
            synchronized (dVarB) {
                dVarB.offer(obj);
                c0781q1.f4735f.decrementAndGet();
                if (c0781q1.getAndIncrement() != 0) {
                    return;
                }
            }
        }
        c0781q1.a();
    }
}
