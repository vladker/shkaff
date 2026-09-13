package p102s;

import E3.g;
import F3.i;
import G3.b;
import G3.m;
import O3.l;
import O3.p;
import android.bluetooth.BluetoothDevice;
import kotlin.jvm.internal.E;
import p007a4.M;
import p108t.C1770b;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: renamed from: s.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1632e extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8171a;
    public final /* synthetic */ C1633f b;
    public final /* synthetic */ long c;
    public final /* synthetic */ l d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1632e(C1633f c1633f, long j6, l lVar, g gVar) {
        super(2, gVar);
        this.b = c1633f;
        this.c = j6;
        this.d = lVar;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        return new C1632e(this.b, this.c, this.d, gVar);
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C1632e) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0040  */
    /* JADX WARN: Code duplicated, block: B:19:0x0050  */
    /* JADX WARN: Code duplicated, block: B:21:0x006a  */
    /* JADX WARN: Code duplicated, block: B:27:0x009a  */
    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        BluetoothDevice bluetoothDevice;
        l lVar;
        p140y2.m mVar;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i5 = this.f8171a;
        long j6 = this.c;
        C1633f c1633f = this.b;
        if (i5 == 0) {
            v.throwOnFailure(obj);
            p140y2.m mVar2 = (p140y2.m) c1633f.scanner_manager.get(b.boxLong(j6));
            if (mVar2 != null) {
                this.f8171a = 1;
                obj = mVar2.getDevice(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                bluetoothDevice = null;
            }
            lVar = this.d;
            if (bluetoothDevice == null) {
                mVar = (p140y2.m) c1633f.scanner_manager.get(b.boxLong(j6));
                if (mVar != null) {
                    mVar.stopDiscovery();
                }
                c1633f.scanner_manager.remove(b.boxLong(j6));
                lVar.invoke(u.a(u.m1361constructorimpl(null)));
            } else if (bluetoothDevice.getName() != null || bluetoothDevice.getAddress() == null) {
                lVar.invoke(u.a(u.m1361constructorimpl(null)));
            } else {
                String name = bluetoothDevice.getName();
                E.e(name, "getName(...)");
                String address = bluetoothDevice.getAddress();
                E.e(address, "getAddress(...)");
                lVar.invoke(u.a(u.m1361constructorimpl(new C1770b(name, address))));
            }
            return Q.INSTANCE;
        }
        if (i5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v.throwOnFailure(obj);
        bluetoothDevice = (BluetoothDevice) obj;
        lVar = this.d;
        if (bluetoothDevice == null) {
            mVar = (p140y2.m) c1633f.scanner_manager.get(b.boxLong(j6));
            if (mVar != null) {
                mVar.stopDiscovery();
            }
            c1633f.scanner_manager.remove(b.boxLong(j6));
            lVar.invoke(u.a(u.m1361constructorimpl(null)));
        } else if (bluetoothDevice.getName() != null) {
            lVar.invoke(u.a(u.m1361constructorimpl(null)));
        } else {
            lVar.invoke(u.a(u.m1361constructorimpl(null)));
        }
        return Q.INSTANCE;
    }
}
