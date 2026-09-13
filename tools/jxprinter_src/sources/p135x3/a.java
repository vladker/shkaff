package p135x3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p039g3.A;
import p094q3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements InterfaceC0984q, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f8954a = new AtomicReference();

    @Override // p011b3.c
    public final void dispose() {
        g.a(this.f8954a);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f8954a.get() == g.f7849a;
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        AtomicReference atomicReference;
        Class<?> cls = getClass();
        A.b(dVar, "next is null");
        do {
            atomicReference = this.f8954a;
            if (atomicReference.compareAndSet(null, dVar)) {
                ((d) atomicReference.get()).request(LocationRequestCompat.PASSIVE_INTERVAL);
                return;
            }
        } while (atomicReference.get() == null);
        dVar.cancel();
        if (atomicReference.get() != g.f7849a) {
            p002a.d.b(cls);
        }
    }
}
