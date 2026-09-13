package p088p3;

import androidx.core.location.LocationRequestCompat;
import com.bumptech.glide.f;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p017c3.e;
import p079o.J;
import p083o3.b;
import p094q3.g;
import p122v2.a;
import p135x3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends J implements InterfaceC0984q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f7747a = new AtomicInteger();
    public final AtomicLong b = new AtomicLong();
    public final c c;
    public final b d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f7748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Throwable f7749g;

    public k(c cVar, b bVar) {
        this.c = cVar;
        this.d = bVar;
    }

    public boolean o(Object obj, t5.c cVar) {
        return false;
    }

    public final boolean p() {
        return this.f7747a.getAndIncrement() == 0;
    }

    public final boolean q() {
        AtomicInteger atomicInteger = this.f7747a;
        return atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1);
    }

    public final void r(Object obj, p011b3.c cVar) {
        boolean zQ = q();
        c cVar2 = this.c;
        b bVar = this.d;
        if (zQ) {
            long j6 = this.b.get();
            if (j6 == 0) {
                cVar.dispose();
                cVar2.onError(new e("Could not emit buffer due to lack of requests"));
                return;
            } else {
                if (o(obj, cVar2) && j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    t(1L);
                }
                if (this.f7747a.addAndGet(-1) == 0) {
                    return;
                }
            }
        } else {
            bVar.offer(obj);
            if (!p()) {
                return;
            }
        }
        f.d(bVar, cVar2, cVar, this);
    }

    public void request(long j6) {
        if (g.f(j6)) {
            a.a(this.b, j6);
        }
    }

    public final void s(Object obj, p011b3.c cVar) {
        c cVar2 = this.c;
        b bVar = this.d;
        if (q()) {
            long j6 = this.b.get();
            if (j6 == 0) {
                this.e = true;
                cVar.dispose();
                cVar2.onError(new e("Could not emit buffer due to lack of requests"));
                return;
            } else if (bVar.isEmpty()) {
                if (o(obj, cVar2) && j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    t(1L);
                }
                if (this.f7747a.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                bVar.offer(obj);
            }
        } else {
            bVar.offer(obj);
            if (!p()) {
                return;
            }
        }
        f.d(bVar, cVar2, cVar, this);
    }

    public final void t(long j6) {
        this.b.addAndGet(-1L);
    }
}
