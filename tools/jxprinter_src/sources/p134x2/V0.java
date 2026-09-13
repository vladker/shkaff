package p134x2;

import A3.AbstractC0151t;
import A3.C;
import O3.l;
import androidx.collection.a;
import java.util.TimerTask;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p007a4.C0306v;
import p018c4.B;
import p018c4.D;
import p147z3.Q;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V0 extends F implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S0 f8884a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V0(S0 s6) {
        super(1);
        this.f8884a = s6;
    }

    @Override // O3.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((byte[]) obj);
        return Q.INSTANCE;
    }

    public final void invoke(byte[] bArr) {
        S0 s6 = this.f8884a;
        if (bArr == null) {
            l listener = s6.getListener();
            if (listener != null) {
                listener.invoke(null);
                return;
            }
            return;
        }
        if (s6.getRecvTimer() != null) {
            TimerTask recvTimer = s6.getRecvTimer();
            E.c(recvTimer);
            recvTimer.cancel();
        }
        AbstractC0151t.copyInto(bArr, s6.getRecvCache(), s6.f8877a, 0, bArr.length);
        s6.f8877a += bArr.length;
        if (s6.getRecvReq() == null) {
            while (true) {
                Object objMo1007tryReceivePtdJZtk = s6.recvChannel.mo1007tryReceivePtdJZtk();
                if (objMo1007tryReceivePtdJZtk instanceof D) {
                    break;
                }
                Object objM1004getOrNullimpl = B.m1004getOrNullimpl(objMo1007tryReceivePtdJZtk);
                E.c(objM1004getOrNullimpl);
                S0.a aVar = (S0.a) objM1004getOrNullimpl;
                if (!aVar.c) {
                    s6.setRecvReq(aVar);
                    break;
                }
                O.INSTANCE.i(S0.TAG, "req " + aVar.b + " recv timeout");
            }
        }
        if (s6.getRecvReq() == null) {
            O.INSTANCE.i(S0.TAG, "recv data size: " + s6.f8877a + ",defaut handle");
            l listener2 = s6.getListener();
            if (listener2 != null) {
                listener2.invoke(C.sliceArray(s6.getRecvCache(), U3.B.until(0, s6.f8877a)));
            }
            s6.f8877a = 0;
            return;
        }
        int i5 = s6.f8877a;
        S0.a recvReq = s6.getRecvReq();
        E.c(recvReq);
        if (i5 >= recvReq.b) {
            O o6 = O.INSTANCE;
            int i6 = s6.f8877a;
            S0.a recvReq2 = s6.getRecvReq();
            E.c(recvReq2);
            o6.i(S0.TAG, a.h(i6, recvReq2.b, "recv data size: ", ", req size: "));
            S0.a recvReq3 = s6.getRecvReq();
            E.c(recvReq3);
            ((C0306v) recvReq3.getDeferred()).makeCompleting$kotlinx_coroutines_core(u.a(u.m1361constructorimpl(C.sliceArray(s6.getRecvCache(), U3.B.until(0, s6.f8877a)))));
            s6.f8877a = 0;
            s6.setRecvReq(null);
        }
    }
}
