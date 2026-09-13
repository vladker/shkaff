package p094q3;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p017c3.g;
import p039g3.A;
import p122v2.a;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class f extends AtomicInteger implements d {
    private static final long serialVersionUID = -2189523197179400958L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f7845a;
    public long b;
    public final AtomicReference c = new AtomicReference();
    public final AtomicLong d = new AtomicLong();
    public final AtomicLong e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f7846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f7847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7848h;

    public f(boolean z6) {
        this.f7846f = z6;
    }

    public final void c() {
        int iAddAndGet = 1;
        long jC = 0;
        d dVar = null;
        do {
            d dVar2 = (d) this.c.get();
            if (dVar2 != null) {
                dVar2 = (d) this.c.getAndSet(null);
            }
            long andSet = this.d.get();
            if (andSet != 0) {
                andSet = this.d.getAndSet(0L);
            }
            long andSet2 = this.e.get();
            if (andSet2 != 0) {
                andSet2 = this.e.getAndSet(0L);
            }
            d dVar3 = this.f7845a;
            if (this.f7847g) {
                if (dVar3 != null) {
                    dVar3.cancel();
                    this.f7845a = null;
                }
                if (dVar2 != null) {
                    dVar2.cancel();
                }
            } else {
                long jC2 = this.b;
                if (jC2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    jC2 = a.c(jC2, andSet);
                    if (jC2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                        jC2 -= andSet2;
                        if (jC2 < 0) {
                            io.reactivex.plugins.a.onError(new g(androidx.collection.a.j(jC2, "More produced than requested: ")));
                            jC2 = 0;
                        }
                    }
                    this.b = jC2;
                }
                if (dVar2 != null) {
                    if (dVar3 != null && this.f7846f) {
                        dVar3.cancel();
                    }
                    this.f7845a = dVar2;
                    if (jC2 != 0) {
                        jC = a.c(jC, jC2);
                        dVar = dVar2;
                    }
                } else if (dVar3 != null && andSet != 0) {
                    jC = a.c(jC, andSet);
                    dVar = dVar3;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
        if (jC != 0) {
            dVar.request(jC);
        }
    }

    public void cancel() {
        if (this.f7847g) {
            return;
        }
        this.f7847g = true;
        if (getAndIncrement() != 0) {
            return;
        }
        c();
    }

    public final void d(long j6) {
        if (this.f7848h) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            a.a(this.e, j6);
            if (getAndIncrement() != 0) {
                return;
            }
            c();
            return;
        }
        long j7 = this.b;
        if (j7 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long j8 = j7 - j6;
            if (j8 < 0) {
                io.reactivex.plugins.a.onError(new g(androidx.collection.a.j(j8, "More produced than requested: ")));
                j8 = 0;
            }
            this.b = j8;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        c();
    }

    public final void e(d dVar) {
        if (this.f7847g) {
            dVar.cancel();
            return;
        }
        A.b(dVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            d dVar2 = (d) this.c.getAndSet(dVar);
            if (dVar2 != null && this.f7846f) {
                dVar2.cancel();
            }
            if (getAndIncrement() != 0) {
                return;
            }
            c();
            return;
        }
        d dVar3 = this.f7845a;
        if (dVar3 != null && this.f7846f) {
            dVar3.cancel();
        }
        this.f7845a = dVar;
        long j6 = this.b;
        if (decrementAndGet() != 0) {
            c();
        }
        if (j6 != 0) {
            dVar.request(j6);
        }
    }

    public void onSubscribe(d dVar) {
        e(dVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        if (!g.f(j6) || this.f7848h) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            a.a(this.d, j6);
            if (getAndIncrement() != 0) {
                return;
            }
            c();
            return;
        }
        long j7 = this.b;
        if (j7 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long jC = a.c(j7, j6);
            this.b = jC;
            if (jC == LocationRequestCompat.PASSIVE_INTERVAL) {
                this.f7848h = true;
            }
        }
        d dVar = this.f7845a;
        if (decrementAndGet() != 0) {
            c();
        }
        if (dVar != null) {
            dVar.request(j6);
        }
    }
}
