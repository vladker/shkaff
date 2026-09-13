package p140y2;

import E3.g;
import F3.i;
import G3.b;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.IntentFilter;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0275f;
import p018c4.A;
import p018c4.InterfaceC0391v;
import p134x2.O;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final g Companion = new g();
    private static final String TAG = "BluetoothScanner";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothAdapter f9040a;
    private InterfaceC0391v channel;
    private final Context context;
    private final l receiver;

    public m(Context context) {
        E.f(context, "context");
        this.context = context;
        this.f9040a = BluetoothAdapter.getDefaultAdapter();
        this.receiver = new l(this);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0050 A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:12:0x0028, B:25:0x0049, B:28:0x0050, B:30:0x005b, B:31:0x0062, B:19:0x0039, B:21:0x003d), top: B:35:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x005b A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:12:0x0028, B:25:0x0049, B:28:0x0050, B:30:0x005b, B:31:0x0062, B:19:0x0039, B:21:0x003d), top: B:35:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getDevice(g<? super BluetoothDevice> gVar) {
        h hVar;
        m mVar;
        BluetoothDevice bluetoothDevice;
        InterfaceC0391v interfaceC0391v;
        if (gVar instanceof h) {
            hVar = (h) gVar;
            int i5 = hVar.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                hVar.d = i5 - Integer.MIN_VALUE;
            } else {
                hVar = new h(this, gVar);
            }
        } else {
            hVar = new h(this, gVar);
        }
        Object objReceive = hVar.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = hVar.d;
        try {
            if (i6 == 0) {
                v.throwOnFailure(objReceive);
                InterfaceC0391v interfaceC0391v2 = this.channel;
                if (interfaceC0391v2 != null) {
                    hVar.f9035a = this;
                    hVar.d = 1;
                    objReceive = interfaceC0391v2.receive(hVar);
                    if (objReceive == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mVar = this;
                } else {
                    mVar = this;
                    bluetoothDevice = null;
                }
                if (bluetoothDevice == null) {
                    mVar.context.unregisterReceiver(mVar.receiver);
                    interfaceC0391v = mVar.channel;
                    if (interfaceC0391v != null) {
                        b.boxBoolean(interfaceC0391v.close(null));
                    }
                    mVar.channel = null;
                }
                return bluetoothDevice;
            }
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mVar = hVar.f9035a;
            v.throwOnFailure(objReceive);
            bluetoothDevice = (BluetoothDevice) objReceive;
            if (bluetoothDevice == null) {
                mVar.context.unregisterReceiver(mVar.receiver);
                interfaceC0391v = mVar.channel;
                if (interfaceC0391v != null) {
                    b.boxBoolean(interfaceC0391v.close(null));
                }
                mVar.channel = null;
            }
            return bluetoothDevice;
        } catch (Exception e) {
            O.INSTANCE.e(TAG, "unregisterReceiver error", e);
            return null;
        }
    }

    public final BluetoothDevice getDeviceSync() {
        return (BluetoothDevice) AbstractC0275f.runBlocking$default(null, new i(this, null), 1, null);
    }

    @SuppressLint({"MissingPermission"})
    /* JADX INFO: renamed from: startDiscovery-d1pmJ48, reason: not valid java name */
    public final Object m1123startDiscoveryd1pmJ48() {
        if (this.channel != null) {
            return u.m1361constructorimpl(v.createFailure(new IllegalStateException("Already started")));
        }
        this.channel = A.a(Integer.MAX_VALUE, 6, null);
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        this.context.registerReceiver(this.receiver, intentFilter);
        this.f9040a.startDiscovery();
        return u.m1361constructorimpl(Q.INSTANCE);
    }

    @SuppressLint({"MissingPermission"})
    public final void stopDiscovery() {
        try {
            InterfaceC0391v interfaceC0391v = this.channel;
            if (interfaceC0391v != null) {
                interfaceC0391v.close(null);
                this.channel = null;
                this.f9040a.cancelDiscovery();
                this.context.unregisterReceiver(this.receiver);
            }
        } catch (Exception e) {
            O.INSTANCE.e(TAG, "stopDiscovery error", e);
        }
    }
}
