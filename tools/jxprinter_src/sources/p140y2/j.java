package p140y2;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import android.bluetooth.BluetoothDevice;
import p007a4.M;
import p018c4.InterfaceC0391v;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9037a;
    public final /* synthetic */ m b;
    public final /* synthetic */ BluetoothDevice c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(m mVar, BluetoothDevice bluetoothDevice, g gVar) {
        super(2, gVar);
        this.b = mVar;
        this.c = bluetoothDevice;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new j(this.b, this.c, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super Q> gVar) {
        return ((j) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.f9037a;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            InterfaceC0391v interfaceC0391v = this.b.channel;
            if (interfaceC0391v != null) {
                this.f9037a = 1;
                if (interfaceC0391v.send(this.c, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
        }
        return Q.INSTANCE;
    }
}
