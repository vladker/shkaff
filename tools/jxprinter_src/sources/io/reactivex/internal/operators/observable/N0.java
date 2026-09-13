package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N0 extends AtomicReference implements InterfaceC0988v, p011b3.c {
    private static final long serialVersionUID = -502562646270949838L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ O0 f5036a;

    public N0(O0 o6) {
        this.f5036a = o6;
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
        O0 o6 = this.f5036a;
        io.reactivex.I i5 = o6.f5054a;
        AtomicInteger atomicInteger = o6.d;
        o6.c.delete(this);
        if (o6.get() == 0) {
            if (o6.compareAndSet(0, 1)) {
                boolean z6 = atomicInteger.decrementAndGet() == 0;
                p083o3.d dVar = (p083o3.d) o6.f5056g.get();
                if (!z6 || (dVar != null && !dVar.isEmpty())) {
                    if (o6.decrementAndGet() == 0) {
                        return;
                    }
                    o6.a();
                    return;
                }
                p100r3.c cVar = o6.e;
                cVar.getClass();
                Throwable thB = p100r3.g.b(cVar);
                if (thB != null) {
                    i5.onError(thB);
                    return;
                } else {
                    i5.onComplete();
                    return;
                }
            }
        }
        atomicInteger.decrementAndGet();
        if (o6.getAndIncrement() == 0) {
            o6.a();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        O0 o6 = this.f5036a;
        p011b3.b bVar = o6.c;
        bVar.delete(this);
        p100r3.c cVar = o6.e;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        if (!o6.b) {
            o6.f5057h.dispose();
            bVar.dispose();
        }
        o6.d.decrementAndGet();
        if (o6.getAndIncrement() == 0) {
            o6.a();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
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
    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        AtomicReference atomicReference;
        p083o3.d dVar;
        p083o3.d dVar2;
        O0 o6 = this.f5036a;
        o6.c.delete(this);
        if (o6.get() == 0) {
            if (o6.compareAndSet(0, 1)) {
                o6.f5054a.onNext(obj);
                boolean z6 = o6.d.decrementAndGet() == 0;
                p083o3.d dVar3 = (p083o3.d) o6.f5056g.get();
                if (z6 && (dVar3 == null || dVar3.isEmpty())) {
                    p100r3.c cVar = o6.e;
                    cVar.getClass();
                    Throwable thB = p100r3.g.b(cVar);
                    if (thB != null) {
                        o6.f5054a.onError(thB);
                        return;
                    } else {
                        o6.f5054a.onComplete();
                        return;
                    }
                }
                if (o6.decrementAndGet() == 0) {
                    return;
                }
            } else {
                atomicReference = o6.f5056g;
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
                o6.d.decrementAndGet();
                if (o6.getAndIncrement() != 0) {
                    return;
                }
            }
        } else {
            atomicReference = o6.f5056g;
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
                o6.d.decrementAndGet();
                if (o6.getAndIncrement() != 0) {
                    return;
                }
            }
        }
        o6.a();
    }
}
