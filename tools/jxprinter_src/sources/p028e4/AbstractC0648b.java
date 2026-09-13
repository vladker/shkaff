package p028e4;

import O3.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.E;
import p147z3.C1929i;

/* JADX INFO: renamed from: e4.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0648b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3939a = AtomicReferenceFieldUpdater.newUpdater(AbstractC0648b.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(AbstractC0648b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public AbstractC0648b(AbstractC0648b abstractC0648b) {
        this._prev$volatile = abstractC0648b;
    }

    public final void a() {
        b.set(this, null);
    }

    public abstract boolean b();

    public final void c() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AbstractC0648b next;
        if (getNext() == null) {
            return;
        }
        while (true) {
            AbstractC0648b prev = getPrev();
            while (true) {
                atomicReferenceFieldUpdater = b;
                if (prev == null || !prev.b()) {
                    break;
                } else {
                    prev = (AbstractC0648b) atomicReferenceFieldUpdater.get(prev);
                }
            }
            AbstractC0648b next2 = getNext();
            E.c(next2);
            while (next2.b() && (next = next2.getNext()) != null) {
                next2 = next;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(next2);
                AbstractC0648b abstractC0648b = ((AbstractC0648b) obj) == null ? null : prev;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(next2, obj, abstractC0648b)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(next2) != obj) {
                    }
                }
            }
            if (prev != null) {
                f3939a.set(prev, next2);
            }
            if (!next2.b() || next2.getNext() == null) {
                if (prev == null || !prev.b()) {
                    return;
                }
            }
        }
    }

    public final AbstractC0648b getNext() {
        Object obj = f3939a.get(this);
        if (obj == AbstractC0647a.CLOSED) {
            return null;
        }
        return (AbstractC0648b) obj;
    }

    public final AbstractC0648b getPrev() {
        return (AbstractC0648b) b.get(this);
    }

    public final AbstractC0648b nextOrIfClosed(a aVar) {
        Object obj = f3939a.get(this);
        if (obj != AbstractC0647a.CLOSED) {
            return (AbstractC0648b) obj;
        }
        aVar.invoke();
        throw new C1929i();
    }

    public final boolean trySetNext(AbstractC0648b abstractC0648b) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = f3939a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, abstractC0648b)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return false;
    }
}
