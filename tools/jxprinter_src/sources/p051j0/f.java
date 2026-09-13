package p051j0;

import F3.i;
import L.a;
import android.annotation.SuppressLint;
import android.content.Context;
import com.appdev.standard.api.MainApi;
import com.appdev.standard.model.LastConnectDeviceInfo;
import com.library.base.util.http.Http;
import com.orhanobut.hawk.Hawk;
import io.reactivex.internal.operators.observable.C0953x2;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.AbstractC0275f;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p018c4.G;
import p023d4.C0631u1;
import p113u.g;
import p134x2.K0;
import p134x2.M;
import p134x2.O;
import p134x2.P0;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final f INSTANCE = new f();
    private static final String TAG = "PrintUtil";

    @SuppressLint({"StaticFieldLeak"})
    private static a linkedRecordWorker;
    private static Context mContext;

    public static final void connectBluetoothDevice(String deviceAddress) {
        E.f(deviceAddress, "deviceAddress");
        AbstractC0275f.runBlocking$default(null, new b(deviceAddress, null, 0), 1, null);
    }

    public static final void connectUsbDevice(String deviceName, String deviceAddress) {
        E.f(deviceName, "deviceName");
        E.f(deviceAddress, "deviceAddress");
        AbstractC0275f.runBlocking$default(null, new G(deviceName, deviceAddress, null, 4), 1, null);
    }

    public static final void connectWifiDevice(String deviceName, String ip, int i5) {
        E.f(deviceName, "deviceName");
        E.f(ip, "ip");
        AbstractC0275f.runBlocking$default(null, new c(deviceName, ip, i5, null), 1, null);
    }

    public static final void disconnectDevice() {
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C0631u1(2, null, 1));
    }

    public static final String getPrintDeviceAddress() {
        return p134x2.E.getPrintDeviceAddress();
    }

    public static final String getPrintDeviceName() {
        if (p134x2.E.getPrintDeviceName().length() != 0) {
            return p134x2.E.getPrintDeviceName();
        }
        Context context = mContext;
        E.c(context);
        String string = context.getString(g.text_49);
        E.e(string, "getString(...)");
        return string;
    }

    public static final K0 getPrinter() {
        return p134x2.E.getPrinter();
    }

    public static final void init(Context context) {
        E.f(context, "context");
        a aVar = new a(context);
        aVar.d = null;
        aVar.d = (MainApi) Http.createApi(MainApi.class);
        linkedRecordWorker = aVar;
        mContext = context.getApplicationContext();
        LastConnectDeviceInfo lastConnectDeviceInfo = (LastConnectDeviceInfo) Hawk.get("LastConnectDeviceInfo");
        if (lastConnectDeviceInfo != null) {
            String type = lastConnectDeviceInfo.getType();
            E.e(type, "getType(...)");
            Hawk.put(p134x2.E.LAST_CONNECT_DEVICE_INFO, new M(type, lastConnectDeviceInfo.getBleDeviceMac(), lastConnectDeviceInfo.getBleDeviceName()));
            Hawk.delete("LastConnectDeviceInfo");
        }
        p134x2.E e = p134x2.E.INSTANCE;
        e.init(context, new C0953x2(1));
        e.addEventListener(new d());
        O.INSTANCE.setLogger(new C0953x2(2));
    }

    public static final P0 read_print_info() {
        try {
            return (P0) AbstractC0275f.runBlocking$default(null, new C0631u1(2, null, 2), 1, null);
        } catch (Exception e) {
            a.e(TAG, "read print info error", e);
            return null;
        }
    }

    public static final P0 update_print_info() {
        try {
            return (P0) AbstractC0275f.runBlocking$default(null, new C0631u1(2, null, 3), 1, null);
        } catch (Exception e) {
            a.e(TAG, "update print info error", e);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0064  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object update_print_info_async(E3.g<? super P0> gVar) throws Throwable {
        e eVar;
        u uVarA;
        Object objM1099getPrinterInfoIoAF18A;
        Object objB;
        if (gVar instanceof e) {
            eVar = (e) gVar;
            int i5 = eVar.b;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                eVar.b = i5 - Integer.MIN_VALUE;
            } else {
                eVar = new e(gVar);
            }
        } else {
            eVar = new e(gVar);
        }
        Object obj = eVar.f5397a;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = eVar.b;
        try {
            if (i6 == 0) {
                v.throwOnFailure(obj);
                K0 printer = p134x2.E.getPrinter();
                if (printer != null) {
                    eVar.b = 1;
                    objM1099getPrinterInfoIoAF18A = printer.m1099getPrinterInfoIoAF18A(eVar);
                    if (objM1099getPrinterInfoIoAF18A == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    uVarA = null;
                }
                if (uVarA != null && !(uVarA.b() instanceof u.a)) {
                    objB = uVarA.b();
                    if (objB instanceof u.a) {
                        objB = null;
                    }
                    E.c(objB);
                    a.n((P0) objB);
                }
                return a.h();
            }
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            objM1099getPrinterInfoIoAF18A = ((u) obj).b();
            uVarA = u.a(objM1099getPrinterInfoIoAF18A);
            if (uVarA != null) {
                objB = uVarA.b();
                if (objB instanceof u.a) {
                    objB = null;
                }
                E.c(objB);
                a.n((P0) objB);
            }
            return a.h();
        } catch (Exception e) {
            a.e(TAG, "update print info error", e);
            return null;
        }
    }

    public final Object connectBluetoothDeviceAsync(String str, E3.g<? super Q> gVar) throws Throwable {
        Object objConnectBluetoothDevice = p134x2.E.INSTANCE.connectBluetoothDevice(str, false, gVar);
        return objConnectBluetoothDevice == i.getCOROUTINE_SUSPENDED() ? objConnectBluetoothDevice : Q.INSTANCE;
    }

    public final Object connectUsbDeviceAsync(String str, String str2, E3.g<? super Q> gVar) throws Throwable {
        Object objConnectUsbDevice = p134x2.E.INSTANCE.connectUsbDevice(str, str2, gVar);
        return objConnectUsbDevice == i.getCOROUTINE_SUSPENDED() ? objConnectUsbDevice : Q.INSTANCE;
    }

    public final Object connectWifiDeviceAsync(String str, String str2, int i5, E3.g<? super Q> gVar) throws Throwable {
        Object objConnectWifiDevice = p134x2.E.INSTANCE.connectWifiDevice(str, str2, i5, gVar);
        return objConnectWifiDevice == i.getCOROUTINE_SUSPENDED() ? objConnectWifiDevice : Q.INSTANCE;
    }

    public static /* synthetic */ void getPrintDeviceAddress$annotations() {
    }

    public static /* synthetic */ void getPrintDeviceName$annotations() {
    }

    public static /* synthetic */ void getPrinter$annotations() {
    }

    public static /* synthetic */ void isConnected$annotations() {
    }
}
