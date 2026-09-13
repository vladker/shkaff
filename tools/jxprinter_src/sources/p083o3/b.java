package p083o3;

import java.util.concurrent.atomic.AtomicReference;
import p043h3.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f6442a;
    public final AtomicReference b;

    public b() {
        AtomicReference atomicReference = new AtomicReference();
        this.f6442a = atomicReference;
        AtomicReference atomicReference2 = new AtomicReference();
        this.b = atomicReference2;
        a aVar = new a();
        atomicReference2.lazySet(aVar);
    }

    @Override // p043h3.j
    public final void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return ((a) this.b.get()) == ((a) this.f6442a.get());
    }

    @Override // p043h3.i, p043h3.j
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        a aVar = new a();
        aVar.f6441a = obj;
        ((a) this.f6442a.getAndSet(aVar)).lazySet(aVar);
        return true;
    }

    @Override // p043h3.i, p043h3.j
    public Object poll() {
        a aVar;
        AtomicReference atomicReference = this.b;
        a aVar2 = (a) atomicReference.get();
        a aVar3 = (a) aVar2.get();
        if (aVar3 != null) {
            Object obj = aVar3.f6441a;
            aVar3.f6441a = null;
            atomicReference.lazySet(aVar3);
            return obj;
        }
        if (aVar2 == ((a) this.f6442a.get())) {
            return null;
        }
        do {
            aVar = (a) aVar2.get();
        } while (aVar == null);
        Object obj2 = aVar.f6441a;
        aVar.f6441a = null;
        atomicReference.lazySet(aVar);
        return obj2;
    }

    @Override // p043h3.i, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        offer(obj);
        offer(obj2);
        return true;
    }
}
