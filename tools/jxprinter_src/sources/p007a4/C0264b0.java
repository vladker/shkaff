package p007a4;

import E3.g;
import E3.q;
import F3.h;
import F3.i;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p028e4.AbstractC0655i;
import p028e4.D;

/* JADX INFO: renamed from: a4.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0264b0 extends D {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(C0264b0.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    public C0264b0(q qVar, g<Object> gVar) {
        super(qVar, gVar);
    }

    @Override // p028e4.D, p007a4.X0
    public void afterCompletion(Object obj) {
        afterResume(obj);
    }

    @Override // p028e4.D, p007a4.AbstractC0260a
    public void afterResume(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = c;
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 != 0) {
                if (i5 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                AbstractC0655i.resumeCancellableWith(h.intercepted(this.uCont), B.recoverResult(obj, this.uCont));
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }

    public final Object getResult$kotlinx_coroutines_core() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = c;
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 != 0) {
                if (i5 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                Object objUnboxState = Y0.unboxState(getState$kotlinx_coroutines_core());
                if (objUnboxState instanceof C0314z) {
                    throw ((C0314z) objUnboxState).cause;
                }
                return objUnboxState;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 1));
        return i.getCOROUTINE_SUSPENDED();
    }
}
