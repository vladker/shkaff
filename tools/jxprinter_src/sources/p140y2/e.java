package p140y2;

import E3.g;
import F3.i;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0261a0;
import p134x2.F;
import p134x2.H;
import p134x2.M0;
import p134x2.O;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements H {
    public static final a Companion = new a();
    private static final String TAG = "BluetoothConnection";
    private final UUID PRINTER_UUID;
    private final BroadcastReceiver boundDeviceReceiver;
    private final Context context;
    private final f device;
    private InputStream inputStream;
    private BluetoothSocket mSocket;
    private OutputStream outputStream;
    private b state;

    public e(Context context, f device) {
        E.f(context, "context");
        E.f(device, "device");
        this.context = context;
        this.device = device;
        UUID uuidFromString = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
        E.e(uuidFromString, "fromString(...)");
        this.PRINTER_UUID = uuidFromString;
        this.state = b.f9032a;
        this.boundDeviceReceiver = new c(this);
    }

    @Override // p134x2.H
    /* JADX INFO: renamed from: close-IoAF18A */
    public Object mo0closeIoAF18A(g<? super u> gVar) {
        try {
            BluetoothSocket bluetoothSocket = this.mSocket;
            if (bluetoothSocket != null) {
                bluetoothSocket.close();
            }
            this.mSocket = null;
            return u.m1361constructorimpl(Q.INSTANCE);
        } catch (Exception e) {
            return u.m1361constructorimpl(v.createFailure(e));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // p134x2.H
    /* JADX INFO: renamed from: connect-IoAF18A */
    public Object mo1connectIoAF18A(g<? super u> gVar) {
        d dVar;
        Object objM1361constructorimpl;
        e eVar;
        if (gVar instanceof d) {
            dVar = (d) gVar;
            int i5 = dVar.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                dVar.d = i5 - Integer.MIN_VALUE;
            } else {
                dVar = new d(this, gVar);
            }
        } else {
            dVar = new d(this, gVar);
        }
        Object obj = dVar.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = dVar.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            if (this.device.getDevice().getBondState() != 10) {
                return this.device.getDevice().getBondState() == 12 ? d() : u.m1361constructorimpl(v.createFailure(new F("device.getBondState() is not BluetoothDevice.BOND_NONE or BluetoothDevice.BOND_BONDED")));
            }
            O.INSTANCE.i(TAG, "device.getBondState() is BluetoothDevice.BOND_NONE");
            try {
                this.context.registerReceiver(this.boundDeviceReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
                Object objInvoke = BluetoothDevice.class.getMethod("createBond", null).invoke(this.device.getDevice(), null);
                E.d(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
                objM1361constructorimpl = !((Boolean) objInvoke).booleanValue() ? u.m1361constructorimpl(v.createFailure(new Exception("createBond failed"))) : u.m1361constructorimpl(Q.INSTANCE);
            } catch (Exception e) {
                objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(e));
            }
            if (objM1361constructorimpl instanceof u.a) {
                return objM1361constructorimpl;
            }
            eVar = this;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar = dVar.f9034a;
            v.throwOnFailure(obj);
        }
        do {
            b bVar = eVar.state;
            if (bVar != b.f9032a) {
                return bVar == b.c ? u.m1361constructorimpl(v.createFailure(new F("bond cancel"))) : eVar.d();
            }
            dVar.f9034a = eVar;
            dVar.d = 1;
        } while (AbstractC0261a0.delay(1000L, dVar) != coroutine_suspended);
        return coroutine_suspended;
    }

    public final Object d() {
        try {
            BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord = this.device.getDevice().createRfcommSocketToServiceRecord(this.PRINTER_UUID);
            this.mSocket = bluetoothSocketCreateRfcommSocketToServiceRecord;
            if (bluetoothSocketCreateRfcommSocketToServiceRecord != null) {
                bluetoothSocketCreateRfcommSocketToServiceRecord.connect();
            }
            BluetoothSocket bluetoothSocket = this.mSocket;
            E.c(bluetoothSocket);
            this.inputStream = bluetoothSocket.getInputStream();
            BluetoothSocket bluetoothSocket2 = this.mSocket;
            E.c(bluetoothSocket2);
            this.outputStream = bluetoothSocket2.getOutputStream();
            return u.m1361constructorimpl(Q.INSTANCE);
        } catch (Exception e) {
            return u.m1361constructorimpl(v.createFailure(e));
        }
    }

    @Override // p134x2.H
    public InputStream getInputStream() {
        return this.inputStream;
    }

    @Override // p134x2.H
    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override // p134x2.H
    public M0 getPrinterDevice() {
        return this.device;
    }
}
