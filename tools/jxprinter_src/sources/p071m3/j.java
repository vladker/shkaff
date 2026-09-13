package p071m3;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLongArray;
import p094q3.g;
import p122v2.a;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6137a;
    public final int b;
    public final /* synthetic */ k c;

    public j(k kVar, int i5, int i6) {
        this.c = kVar;
        this.f6137a = i5;
        this.b = i6;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.c.b.compareAndSet(this.f6137a + this.b, 0L, 1L)) {
            k kVar = this.c;
            int i5 = this.b;
            if (kVar.b.decrementAndGet(i5 + i5) == 0) {
                kVar.f6144k = true;
                kVar.f6139f.cancel();
                if (kVar.getAndIncrement() == 0) {
                    kVar.f6140g.clear();
                }
            }
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        long j7;
        if (g.f(j6)) {
            k kVar = this.c;
            AtomicLongArray atomicLongArray = kVar.b;
            do {
                j7 = atomicLongArray.get(this.f6137a);
                if (j7 == LocationRequestCompat.PASSIVE_INTERVAL) {
                    return;
                }
            } while (!atomicLongArray.compareAndSet(this.f6137a, j7, a.c(j7, j6)));
            if (kVar.f6145l.get() == this.b) {
                kVar.a();
            }
        }
    }
}
