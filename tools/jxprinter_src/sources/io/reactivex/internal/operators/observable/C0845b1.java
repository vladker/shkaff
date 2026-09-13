package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.b1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0845b1 extends AtomicInteger implements p011b3.c, io.reactivex.G {
    private static final long serialVersionUID = -3852313036005250360L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5147a;
    public final p083o3.d b;
    public final Z0 c;
    public final boolean d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Throwable f5148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f5149g = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f5150h = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f5151i = new AtomicReference();

    public C0845b1(int i5, Z0 z6, Object obj, boolean z7) {
        this.b = new p083o3.d(i5);
        this.c = z6;
        this.f5147a = obj;
        this.d = z7;
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        p083o3.d dVar = this.b;
        boolean z6 = this.d;
        io.reactivex.I i5 = (io.reactivex.I) this.f5151i.get();
        int iAddAndGet = 1;
        while (true) {
            if (i5 != null) {
                while (true) {
                    boolean z7 = this.e;
                    Object objPoll = dVar.poll();
                    boolean z8 = objPoll == null;
                    p083o3.d dVar2 = this.b;
                    AtomicReference atomicReference = this.f5151i;
                    if (this.f5149g.get()) {
                        dVar2.clear();
                        Z0 z9 = this.c;
                        Object obj = this.f5147a;
                        z9.getClass();
                        if (obj == null) {
                            obj = Z0.f5135i;
                        }
                        z9.f5137f.remove(obj);
                        if (z9.decrementAndGet() == 0) {
                            z9.f5138g.dispose();
                        }
                        atomicReference.lazySet(null);
                        return;
                    }
                    if (z7) {
                        if (!z6) {
                            Throwable th = this.f5148f;
                            if (th != null) {
                                dVar2.clear();
                                atomicReference.lazySet(null);
                                i5.onError(th);
                                return;
                            } else if (z8) {
                                atomicReference.lazySet(null);
                                i5.onComplete();
                                return;
                            }
                        } else if (z8) {
                            Throwable th2 = this.f5148f;
                            atomicReference.lazySet(null);
                            if (th2 != null) {
                                i5.onError(th2);
                                return;
                            } else {
                                i5.onComplete();
                                return;
                            }
                        }
                    }
                    if (z8) {
                        break;
                    } else {
                        i5.onNext(objPoll);
                    }
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
            if (i5 == null) {
                i5 = (io.reactivex.I) this.f5151i.get();
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f5149g.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.f5151i.lazySet(null);
            Z0 z6 = this.c;
            z6.getClass();
            Object obj = this.f5147a;
            if (obj == null) {
                obj = Z0.f5135i;
            }
            z6.f5137f.remove(obj);
            if (z6.decrementAndGet() == 0) {
                z6.f5138g.dispose();
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5149g.get();
    }

    @Override // io.reactivex.G
    public final void subscribe(io.reactivex.I i5) {
        if (!this.f5150h.compareAndSet(false, true)) {
            p033f3.e.a(new IllegalStateException("Only one Observer allowed!"), i5);
            return;
        }
        i5.onSubscribe(this);
        AtomicReference atomicReference = this.f5151i;
        atomicReference.lazySet(i5);
        if (this.f5149g.get()) {
            atomicReference.lazySet(null);
        } else {
            a();
        }
    }
}
