package p018c4;

import E3.q;
import O3.l;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p007a4.B1;
import p028e4.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E extends p028e4.E {
    private final C0376f _channel;
    public final /* synthetic */ AtomicReferenceArray d;

    public E(long j6, E e, C0376f c0376f, int i5) {
        super(j6, e, i5);
        this._channel = c0376f;
        this.d = new AtomicReferenceArray(AbstractC0388s.SEGMENT_SIZE * 2);
    }

    public final boolean casState$kotlinx_coroutines_core(int i5, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i6 = (i5 * 2) + 1;
        do {
            atomicReferenceArray = this.d;
            if (atomicReferenceArray.compareAndSet(i6, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i6) == obj);
        return false;
    }

    @Override // p028e4.E
    public final int e() {
        return AbstractC0388s.SEGMENT_SIZE;
    }

    public final Object getAndSetState$kotlinx_coroutines_core(int i5, Object obj) {
        return this.d.getAndSet((i5 * 2) + 1, obj);
    }

    public final C0376f getChannel() {
        C0376f c0376f = this._channel;
        kotlin.jvm.internal.E.c(c0376f);
        return c0376f;
    }

    public final Object getState$kotlinx_coroutines_core(int i5) {
        return this.d.get((i5 * 2) + 1);
    }

    public final Object h(int i5) {
        return this.d.get(i5 * 2);
    }

    public final void i(int i5, boolean z6) {
        if (z6) {
            getChannel().D((this.id * ((long) AbstractC0388s.SEGMENT_SIZE)) + ((long) i5));
        }
        f();
    }

    public final void j(int i5, Object obj) {
        this.d.set(i5 * 2, obj);
    }

    @Override // p028e4.E
    public void onCancellation(int i5, Throwable th, q qVar) {
        l lVar;
        l lVar2;
        int i6 = AbstractC0388s.SEGMENT_SIZE;
        boolean z6 = i5 >= i6;
        if (z6) {
            i5 -= i6;
        }
        Object objH = h(i5);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core(i5);
            if ((state$kotlinx_coroutines_core instanceof B1) || (state$kotlinx_coroutines_core instanceof E0)) {
                if (casState$kotlinx_coroutines_core(i5, state$kotlinx_coroutines_core, z6 ? AbstractC0388s.INTERRUPTED_SEND : AbstractC0388s.INTERRUPTED_RCV)) {
                    j(i5, null);
                    i(i5, !z6);
                    if (!z6 || (lVar = getChannel().onUndeliveredElement) == null) {
                        return;
                    }
                    A.callUndeliveredElement(lVar, objH, qVar);
                    return;
                }
            } else {
                if (state$kotlinx_coroutines_core == AbstractC0388s.INTERRUPTED_SEND || state$kotlinx_coroutines_core == AbstractC0388s.INTERRUPTED_RCV) {
                    break;
                }
                if (state$kotlinx_coroutines_core != AbstractC0388s.RESUMING_BY_EB && state$kotlinx_coroutines_core != AbstractC0388s.RESUMING_BY_RCV) {
                    if (state$kotlinx_coroutines_core == AbstractC0388s.DONE_RCV || state$kotlinx_coroutines_core == AbstractC0388s.BUFFERED || state$kotlinx_coroutines_core == AbstractC0388s.getCHANNEL_CLOSED()) {
                        return;
                    }
                    throw new IllegalStateException(("unexpected state: " + state$kotlinx_coroutines_core).toString());
                }
            }
        }
        j(i5, null);
        if (!z6 || (lVar2 = getChannel().onUndeliveredElement) == null) {
            return;
        }
        A.callUndeliveredElement(lVar2, objH, qVar);
    }

    public final void setState$kotlinx_coroutines_core(int i5, Object obj) {
        this.d.set((i5 * 2) + 1, obj);
    }
}
