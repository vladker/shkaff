package p049i4;

import java.util.concurrent.atomic.AtomicReferenceArray;
import p028e4.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends E {
    public final /* synthetic */ AtomicReferenceArray d;

    public q(long j6, q qVar, int i5) {
        super(j6, qVar, i5);
        this.d = new AtomicReferenceArray(p.b);
    }

    public final boolean cas(int i5, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        do {
            atomicReferenceArray = this.d;
            if (atomicReferenceArray.compareAndSet(i5, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i5) == obj);
        return false;
    }

    @Override // p028e4.E
    public final int e() {
        return p.b;
    }

    public final Object get(int i5) {
        return this.d.get(i5);
    }

    public final Object getAndSet(int i5, Object obj) {
        return this.d.getAndSet(i5, obj);
    }

    @Override // p028e4.E
    public void onCancellation(int i5, Throwable th, E3.q qVar) {
        this.d.set(i5, p.CANCELLED);
        f();
    }

    public final void set(int i5, Object obj) {
        this.d.set(i5, obj);
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.id + ", hashCode=" + hashCode() + ']';
    }
}
