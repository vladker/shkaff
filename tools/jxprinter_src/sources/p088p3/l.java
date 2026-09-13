package p088p3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;
import p094q3.g;
import p122v2.a;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends AtomicLong implements InterfaceC0984q, d {
    private static final long serialVersionUID = 7917814472626990048L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f7750a;
    public d b;
    public Object c;
    public long d;

    public l(c cVar) {
        this.f7750a = cVar;
    }

    public final void a(Object obj) {
        long j6 = this.d;
        if (j6 != 0) {
            a.e(this, j6);
        }
        while (true) {
            long j7 = get();
            if ((j7 & Long.MIN_VALUE) != 0) {
                b(obj);
                return;
            }
            if ((j7 & LocationRequestCompat.PASSIVE_INTERVAL) != 0) {
                lazySet(-9223372036854775807L);
                c cVar = this.f7750a;
                cVar.onNext(obj);
                cVar.onComplete();
                return;
            }
            this.c = obj;
            if (compareAndSet(0L, Long.MIN_VALUE)) {
                return;
            } else {
                this.c = null;
            }
        }
    }

    public void cancel() {
        this.b.cancel();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.g(this.b, dVar)) {
            this.b = dVar;
            this.f7750a.onSubscribe(this);
        }
    }

    public void onSuccess(Object obj) {
        a(obj);
    }

    @Override // t5.d
    public final void request(long j6) {
        long j7;
        if (g.f(j6)) {
            do {
                j7 = get();
                if ((j7 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        Object obj = this.c;
                        c cVar = this.f7750a;
                        cVar.onNext(obj);
                        cVar.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j7, a.c(j7, j6)));
            this.b.request(j6);
        }
    }

    public void b(Object obj) {
    }
}
