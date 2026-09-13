package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0978k;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I1 extends AtomicLong implements InterfaceC0978k, t5.d {
    private static final long serialVersionUID = 7565982551505011832L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4282a;
    public final p027e3.c b;
    public final p027e3.g c;
    public Object d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4284g;

    public I1(t5.c cVar, p027e3.c cVar2, p027e3.g gVar, Object obj) {
        this.f4282a = cVar;
        this.b = cVar2;
        this.c = gVar;
        this.d = obj;
    }

    public final void a(Object obj) {
        try {
            this.c.accept(obj);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // t5.d
    public final void cancel() {
        if (this.e) {
            return;
        }
        this.e = true;
        if (p122v2.a.a(this, 1L) == 0) {
            Object obj = this.d;
            this.d = null;
            a(obj);
        }
    }

    @Override // io.reactivex.InterfaceC0978k
    public final void onError(Throwable th) {
        if (this.f4283f) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f4283f = true;
        this.f4282a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0978k
    public final void onNext(Object obj) {
        if (this.f4283f) {
            return;
        }
        if (this.f4284g) {
            onError(new IllegalStateException("onNext already called in this generate turn"));
        } else if (obj == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.f4284g = true;
            this.f4282a.onNext(obj);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6) && p122v2.a.a(this, j6) == 0) {
            Object objApply = this.d;
            p027e3.c cVar = this.b;
            do {
                long j7 = 0;
                while (true) {
                    if (j7 == j6) {
                        j6 = get();
                        if (j7 == j6) {
                            break;
                        }
                    } else {
                        if (this.e) {
                            this.d = null;
                            a(objApply);
                            return;
                        }
                        this.f4284g = false;
                        try {
                            objApply = cVar.apply(objApply, this);
                            if (this.f4283f) {
                                this.e = true;
                                this.d = null;
                                a(objApply);
                                return;
                            }
                            j7++;
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            this.e = true;
                            this.d = null;
                            onError(th);
                            a(objApply);
                            return;
                        }
                    }
                }
                this.d = objApply;
                j6 = addAndGet(-j7);
            } while (j6 != 0);
        }
    }
}
