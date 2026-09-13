package p048i3;

import com.bumptech.glide.f;
import io.reactivex.I;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p079o.AbstractC1275d;
import p083o3.b;
import p112t3.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends AbstractC1275d implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f4060a = new AtomicInteger();
    public final e b;
    public final b c;
    public volatile boolean d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Throwable f4061f;

    public s(e eVar, b bVar) {
        this.b = eVar;
        this.c = bVar;
    }

    public final boolean c() {
        return this.f4060a.getAndIncrement() == 0;
    }

    public final boolean d() {
        AtomicInteger atomicInteger = this.f4060a;
        return atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1);
    }

    public final void f(Object obj, c cVar) {
        AtomicInteger atomicInteger = this.f4060a;
        int i5 = atomicInteger.get();
        e eVar = this.b;
        b bVar = this.c;
        if (i5 == 0 && atomicInteger.compareAndSet(0, 1)) {
            b(eVar, obj);
            if (atomicInteger.addAndGet(-1) == 0) {
                return;
            }
        } else {
            bVar.offer(obj);
            if (!c()) {
                return;
            }
        }
        f.c(bVar, eVar, cVar, this);
    }

    public final void g(Object obj, c cVar) {
        AtomicInteger atomicInteger = this.f4060a;
        int i5 = atomicInteger.get();
        e eVar = this.b;
        b bVar = this.c;
        if (i5 != 0 || !atomicInteger.compareAndSet(0, 1)) {
            bVar.offer(obj);
            if (!c()) {
                return;
            }
        } else if (bVar.isEmpty()) {
            b(eVar, obj);
            if (atomicInteger.addAndGet(-1) == 0) {
                return;
            }
        } else {
            bVar.offer(obj);
        }
        f.c(bVar, eVar, cVar, this);
    }

    @Override // io.reactivex.I
    public abstract /* synthetic */ void onError(Throwable th);

    @Override // io.reactivex.I
    public abstract /* synthetic */ void onNext(Object obj);

    @Override // io.reactivex.I
    public abstract /* synthetic */ void onSubscribe(c cVar);

    public void b(I i5, Object obj) {
    }
}
