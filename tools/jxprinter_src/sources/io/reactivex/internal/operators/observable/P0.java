package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P0 extends AtomicReference implements io.reactivex.S, p011b3.c {
    private static final long serialVersionUID = -502562646270949838L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Q0 f5073a;

    public P0(Q0 q6) {
        this.f5073a = q6;
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
        Q0 q6 = this.f5073a;
        p011b3.b bVar = q6.c;
        bVar.delete(this);
        p100r3.c cVar = q6.e;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        if (!q6.b) {
            q6.f5092h.dispose();
            bVar.dispose();
        }
        q6.d.decrementAndGet();
        if (q6.getAndIncrement() == 0) {
            q6.a();
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:27:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x007e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:45:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x005d A[EDGE_INSN: B:47:0x005d->B:26:0x005d BREAK  A[LOOP:0: B:24:0x0055->B:49:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x005d A[EDGE_INSN: B:48:0x005d->B:26:0x005d BREAK  A[LOOP:0: B:24:0x0055->B:49:?, LOOP_LABEL: LOOP:0: B:24:0x0055->B:49:?], SYNTHETIC] */
    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        AtomicReference atomicReference;
        p083o3.d dVar;
        p083o3.d dVar2;
        Q0 q6 = this.f5073a;
        q6.c.delete(this);
        if (q6.get() == 0) {
            if (q6.compareAndSet(0, 1)) {
                q6.f5089a.onNext(obj);
                boolean z6 = q6.d.decrementAndGet() == 0;
                p083o3.d dVar3 = (p083o3.d) q6.f5091g.get();
                if (z6 && (dVar3 == null || dVar3.isEmpty())) {
                    p100r3.c cVar = q6.e;
                    cVar.getClass();
                    Throwable thB = p100r3.g.b(cVar);
                    if (thB != null) {
                        q6.f5089a.onError(thB);
                        return;
                    } else {
                        q6.f5089a.onComplete();
                        return;
                    }
                }
                if (q6.decrementAndGet() == 0) {
                    return;
                }
            } else {
                atomicReference = q6.f5091g;
                loop0: while (true) {
                    dVar = (p083o3.d) atomicReference.get();
                    if (dVar != null) {
                        break;
                    }
                    dVar = new p083o3.d(AbstractC0979l.f5366a);
                    do {
                        if (atomicReference.compareAndSet(null, dVar)) {
                            break loop0;
                        }
                    } while (atomicReference.get() == null);
                }
                dVar2 = dVar;
                synchronized (dVar2) {
                    dVar2.offer(obj);
                }
                q6.d.decrementAndGet();
                if (q6.getAndIncrement() != 0) {
                    return;
                }
            }
        } else {
            atomicReference = q6.f5091g;
            loop0: while (true) {
                dVar = (p083o3.d) atomicReference.get();
                if (dVar != null) {
                    break;
                    break;
                }
                dVar = new p083o3.d(AbstractC0979l.f5366a);
                do {
                    if (atomicReference.compareAndSet(null, dVar)) {
                        break loop0;
                        break loop0;
                    }
                } while (atomicReference.get() == null);
            }
            dVar2 = dVar;
            synchronized (dVar2) {
                dVar2.offer(obj);
                q6.d.decrementAndGet();
                if (q6.getAndIncrement() != 0) {
                    return;
                }
            }
        }
        q6.a();
    }
}
