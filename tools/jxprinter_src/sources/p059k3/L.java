package p059k3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0988v;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import p027e3.o;
import p033f3.d;
import p039g3.A;
import p094q3.a;
import p094q3.g;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L extends a implements InterfaceC0988v {
    private static final long serialVersionUID = -8938804753851907758L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5519a;
    public final o b;
    public final AtomicLong c = new AtomicLong();
    public p011b3.c d;
    public volatile Iterator e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f5520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5521g;

    public L(c cVar, o oVar) {
        this.f5519a = cVar;
        this.b = oVar;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        this.f5521g = true;
        return 2;
    }

    @Override // t5.d
    public final void cancel() {
        this.f5520f = true;
        this.d.dispose();
        this.d = d.f3969a;
    }

    @Override // p043h3.j
    public final void clear() {
        this.e = null;
    }

    public final void f() {
        if (getAndIncrement() != 0) {
            return;
        }
        c cVar = this.f5519a;
        Iterator it = this.e;
        if (this.f5521g && it != null) {
            cVar.onNext(null);
            cVar.onComplete();
            return;
        }
        int iAddAndGet = 1;
        while (true) {
            if (it != null) {
                long j6 = this.c.get();
                if (j6 == LocationRequestCompat.PASSIVE_INTERVAL) {
                    while (!this.f5520f) {
                        try {
                            cVar.onNext(it.next());
                            if (this.f5520f) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    cVar.onComplete();
                                    return;
                                }
                            } catch (Throwable th) {
                                p017c3.d.throwIfFatal(th);
                                cVar.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            p017c3.d.throwIfFatal(th2);
                            cVar.onError(th2);
                            return;
                        }
                    }
                    return;
                }
                long j7 = 0;
                while (j7 != j6) {
                    if (this.f5520f) {
                        return;
                    }
                    try {
                        Object next = it.next();
                        A.b(next, "The iterator returned a null value");
                        cVar.onNext(next);
                        if (this.f5520f) {
                            return;
                        }
                        j7++;
                        try {
                            if (!it.hasNext()) {
                                cVar.onComplete();
                                return;
                            }
                        } catch (Throwable th3) {
                            p017c3.d.throwIfFatal(th3);
                            cVar.onError(th3);
                            return;
                        }
                    } catch (Throwable th4) {
                        p017c3.d.throwIfFatal(th4);
                        cVar.onError(th4);
                        return;
                    }
                }
                if (j7 != 0) {
                    p122v2.a.e(this.c, j7);
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
            if (it == null) {
                it = this.e;
            }
        }
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.e == null;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5519a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.d = d.f3969a;
        this.f5519a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        if (d.g(this.d, cVar)) {
            this.d = cVar;
            this.f5519a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        try {
            Iterator it = ((Iterable) this.b.apply(obj)).iterator();
            if (!it.hasNext()) {
                this.f5519a.onComplete();
            } else {
                this.e = it;
                f();
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5519a.onError(th);
        }
    }

    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        Iterator it = this.e;
        if (it == null) {
            return null;
        }
        Object next = it.next();
        A.b(next, "The iterator returned a null value");
        if (!it.hasNext()) {
            this.e = null;
        }
        return next;
    }

    @Override // t5.d
    public final void request(long j6) {
        if (g.f(j6)) {
            p122v2.a.a(this.c, j6);
            f();
        }
    }
}
