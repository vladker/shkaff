package p134x2;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import kotlin.jvm.internal.E;
import p007a4.M;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: x2.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1892y extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8949a;
    public final /* synthetic */ M b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1892y(M m6, g gVar) {
        super(2, gVar);
        this.b = m6;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new C1892y(this.b, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super Q> gVar) {
        return ((C1892y) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.f8949a;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            E e = E.INSTANCE;
            M m6 = this.b;
            String bleDeviceName = m6.getBleDeviceName();
            E.c(bleDeviceName);
            String bleDeviceMac = m6.getBleDeviceMac();
            E.c(bleDeviceMac);
            this.f8949a = 1;
            if (e.connectUsbDevice(bleDeviceName, bleDeviceMac, this) == coroutine_suspended) {
                return coroutine_suspended;
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
