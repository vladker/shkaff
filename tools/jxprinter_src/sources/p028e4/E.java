package p028e4;

import E3.q;
import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p007a4.InterfaceC0274e1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class E extends AbstractC0648b implements InterfaceC0274e1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(E.class, "cleanedAndPointers$volatile");
    private volatile /* synthetic */ int cleanedAndPointers$volatile;
    public final long id;

    public E(long j6, E e, int i5) {
        super(e);
        this.id = j6;
        this.cleanedAndPointers$volatile = i5 << 16;
    }

    @Override // p028e4.AbstractC0648b
    public final boolean b() {
        return c.get(this) == e() && getNext() != null;
    }

    public final boolean d() {
        return c.addAndGet(this, SupportMenu.CATEGORY_MASK) == e() && getNext() != null;
    }

    public abstract int e();

    public final void f() {
        if (c.incrementAndGet(this) == e()) {
            c();
        }
    }

    public final boolean g() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i5;
        do {
            atomicIntegerFieldUpdater = c;
            i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 == e() && getNext() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, 65536 + i5));
        return true;
    }

    public abstract void onCancellation(int i5, Throwable th, q qVar);
}
