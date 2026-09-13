package p140y2;

import E3.g;
import G3.m;
import O3.p;
import android.bluetooth.BluetoothDevice;
import p007a4.M;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9036a;
    public final /* synthetic */ m b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(m mVar, g gVar) {
        super(2, gVar);
        this.b = mVar;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new i(this.b, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super BluetoothDevice> gVar) {
        return ((i) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i5 = this.f9036a;
        if (i5 != 0) {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return obj;
        }
        v.throwOnFailure(obj);
        this.f9036a = 1;
        Object device = this.b.getDevice(this);
        return device == coroutine_suspended ? coroutine_suspended : device;
    }
}
