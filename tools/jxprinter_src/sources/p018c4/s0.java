package p018c4;

import E3.g;
import G3.b;
import O3.l;
import androidx.collection.a;
import kotlin.jvm.internal.U;
import p028e4.A;
import p028e4.Q;
import p044h4.o;
import p147z3.AbstractC1926f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class s0 extends C0376f {
    private final EnumC0368b onBufferOverflow;

    public s0(int i5, EnumC0368b enumC0368b, l lVar) {
        super(i5, lVar);
        this.onBufferOverflow = enumC0368b;
        if (enumC0368b != EnumC0368b.f1135a) {
            if (i5 < 1) {
                throw new IllegalArgumentException(a.i(i5, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + U.a(C0376f.class).getSimpleName() + " instead").toString());
        }
    }

    public final Object E(Object obj, boolean z6) {
        l lVar;
        Q qCallUndeliveredElementCatchingException;
        if (this.onBufferOverflow != EnumC0368b.c) {
            return m1012trySendDropOldestJP2dKIU(obj);
        }
        Object objMo1011trySendJP2dKIU = super.mo1011trySendJP2dKIU(obj);
        if (!(objMo1011trySendJP2dKIU instanceof D) || (objMo1011trySendJP2dKIU instanceof B.a)) {
            return objMo1011trySendJP2dKIU;
        }
        if (!z6 || (lVar = this.onUndeliveredElement) == null || (qCallUndeliveredElementCatchingException = A.callUndeliveredElementCatchingException(lVar, obj, null)) == null) {
            return B.Companion.m1010successJP2dKIU(p147z3.Q.INSTANCE);
        }
        throw qCallUndeliveredElementCatchingException;
    }

    @Override // p018c4.C0376f
    public final boolean r() {
        return this.onBufferOverflow == EnumC0368b.b;
    }

    @Override // p018c4.C0376f
    public void registerSelectForSend(o oVar, Object obj) {
        Object objMo1011trySendJP2dKIU = mo1011trySendJP2dKIU(obj);
        if (!(objMo1011trySendJP2dKIU instanceof D)) {
            oVar.selectInRegistrationPhase(p147z3.Q.INSTANCE);
        } else {
            if (!(objMo1011trySendJP2dKIU instanceof B.a)) {
                throw new IllegalStateException("unreachable");
            }
            B.m1003exceptionOrNullimpl(objMo1011trySendJP2dKIU);
            oVar.selectInRegistrationPhase(AbstractC0388s.getCHANNEL_CLOSED());
        }
    }

    @Override // p018c4.C0376f, p018c4.InterfaceC0391v, p018c4.D0
    public Object send(Object obj, g<? super p147z3.Q> gVar) throws Throwable {
        Q qCallUndeliveredElementCatchingException;
        Object objE = E(obj, true);
        if (!(objE instanceof B.a)) {
            return p147z3.Q.INSTANCE;
        }
        B.m1003exceptionOrNullimpl(objE);
        l lVar = this.onUndeliveredElement;
        if (lVar == null || (qCallUndeliveredElementCatchingException = A.callUndeliveredElementCatchingException(lVar, obj, null)) == null) {
            throw getSendException();
        }
        AbstractC1926f.addSuppressed(qCallUndeliveredElementCatchingException, getSendException());
        throw qCallUndeliveredElementCatchingException;
    }

    @Override // p018c4.C0376f
    public Object sendBroadcast$kotlinx_coroutines_core(Object obj, g<? super Boolean> gVar) {
        Object objE = E(obj, true);
        if (objE instanceof D) {
            return b.boxBoolean(false);
        }
        return b.boxBoolean(true);
    }

    @Override // p018c4.C0376f, p018c4.InterfaceC0391v, p018c4.D0
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo1011trySendJP2dKIU(Object obj) {
        return E(obj, false);
    }
}
