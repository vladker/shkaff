package p134x2;

import A3.T;
import G3.d;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.google.android.gms.auth.api.accounttransfer.a;
import com.orhanobut.hawk.Hawk;
import io.reactivex.internal.operators.observable.C0953x2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.opencv.videoio.Videoio;
import p007a4.AbstractC0272e;
import p007a4.AbstractC0275f;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p007a4.H0;
import p007a4.N;
import p049i4.b;
import p049i4.g;
import p049i4.i;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E {
    public static final String LAST_CONNECT_DEVICE_INFO = "LastConnectDevice";
    private static final String MD5_CHECK_FAILED = "MD5 check failed";
    private static final String TAG = "CurrentPrinter";
    private static K0 _printer = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f8851a = -1;
    private static Context context;
    private static M0 curDevice;
    private static H0 reconnectJob;
    private static H0 stateJob;
    private static Q0 store;
    public static final E INSTANCE = new E();
    private static final b lock = i.Mutex(false);
    private static final List<O0> eventListeners = new ArrayList();
    public static long b = -1;
    private static BroadcastReceiver bluetoothReceiver = new C1857g();

    /* JADX WARN: Code duplicated, block: B:45:0x00a2 A[Catch: all -> 0x0036, LOOP:0: B:43:0x009c->B:45:0x00a2, LOOP_END, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0032, B:38:0x0090, B:39:0x0092, B:41:0x0097, B:42:0x0098, B:43:0x009c, B:45:0x00a2, B:48:0x00b4, B:49:0x00b5, B:40:0x0093), top: B:57:0x0032, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public static final Object a(E e, long j6, d dVar) throws Throwable {
        C1884u c1884u;
        b bVar;
        b bVar2;
        Throwable th;
        M0 printerDevice;
        List<O0> list;
        Iterator it;
        e.getClass();
        if (dVar instanceof C1884u) {
            c1884u = (C1884u) dVar;
            int i5 = c1884u.f8941f;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1884u.f8941f = i5 - Integer.MIN_VALUE;
            } else {
                c1884u = new C1884u(e, dVar);
            }
        } else {
            c1884u = new C1884u(e, dVar);
        }
        Object obj = c1884u.d;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = c1884u.f8941f;
        try {
            if (i6 == 0) {
                v.throwOnFailure(obj);
                b bVar3 = lock;
                c1884u.b = bVar3;
                c1884u.f8940a = j6;
                c1884u.f8941f = 1;
                bVar = (g) bVar3;
                if (bVar.lock(null, c1884u) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                printerDevice = c1884u.c;
                bVar2 = c1884u.b;
                try {
                    v.throwOnFailure(obj);
                    list = eventListeners;
                    synchronized (list) {
                        List mutableList = T.toMutableList((Collection) list);
                    }
                    it = mutableList.iterator();
                    while (it.hasNext()) {
                        ((O0) it.next()).onPrinterError(printerDevice, false, N0.c, "disconnectByDeviceAsync");
                    }
                    bVar = bVar2;
                    ((g) bVar).unlock(null);
                    return Q.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    ((g) bVar2).unlock(null);
                    throw th;
                }
            }
            j6 = c1884u.f8940a;
            b bVar4 = c1884u.b;
            v.throwOnFailure(obj);
            bVar = bVar4;
            long j7 = f8851a;
            if (j7 != -1 && j6 >= j7 - ((long) Videoio.CAP_UEYE)) {
                K0 printer = getPrinter();
                printerDevice = printer != null ? printer.getPrinterDevice() : null;
                E e6 = INSTANCE;
                c1884u.b = bVar;
                c1884u.c = printerDevice;
                c1884u.f8941f = 2;
                if (e6.j(true, c1884u) != coroutine_suspended) {
                    bVar2 = bVar;
                    list = eventListeners;
                    synchronized (list) {
                        List mutableList2 = T.toMutableList((Collection) list);
                        it = mutableList2.iterator();
                        while (it.hasNext()) {
                            ((O0) it.next()).onPrinterError(printerDevice, false, N0.c, "disconnectByDeviceAsync");
                        }
                        bVar = bVar2;
                    }
                }
                return coroutine_suspended;
            }
            O.INSTANCE.i(TAG, "disconnectByDeviceAsync return.latestConnectSuccessTime:" + j6 + ",connectSuccessTime:" + j7);
            ((g) bVar).unlock(null);
            return Q.INSTANCE;
        } catch (Throwable th3) {
            bVar2 = bVar;
            th = th3;
            ((g) bVar2).unlock(null);
            throw th;
        }
    }

    public static final void connectBluetoothDeviceSync(String deviceAddress) {
        kotlin.jvm.internal.E.f(deviceAddress, "deviceAddress");
        AbstractC0275f.runBlocking$default(null, new C1875p(deviceAddress, null), 1, null);
    }

    public static final void connectUsbDeviceSync(String deviceName, String deviceAddress) {
        kotlin.jvm.internal.E.f(deviceName, "deviceName");
        kotlin.jvm.internal.E.f(deviceAddress, "deviceAddress");
        AbstractC0275f.runBlocking$default(null, new r(deviceName, deviceAddress, null), 1, null);
    }

    public static final void connectWifiDeviceSync(String deviceName, String ip, int i5) {
        kotlin.jvm.internal.E.f(deviceName, "deviceName");
        kotlin.jvm.internal.E.f(ip, "ip");
        AbstractC0275f.runBlocking$default(null, new C1882t(deviceName, ip, i5, null), 1, null);
    }

    public static final void disconnectDeviceSync() {
        AbstractC0275f.runBlocking$default(null, new C1888w(2, null), 1, null);
    }

    public static final String getPrintDeviceAddress() {
        K0 k6 = _printer;
        if (k6 == null) {
            return "";
        }
        kotlin.jvm.internal.E.c(k6);
        if (!k6.b()) {
            return "";
        }
        K0 k7 = _printer;
        kotlin.jvm.internal.E.c(k7);
        M0 printerDevice = k7.getPrinterDevice();
        kotlin.jvm.internal.E.c(printerDevice);
        return printerDevice.getPrintDeviceAddress();
    }

    public static final String getPrintDeviceName() {
        K0 k6 = _printer;
        if (k6 == null) {
            return "";
        }
        kotlin.jvm.internal.E.c(k6);
        if (!k6.b()) {
            return "";
        }
        K0 k7 = _printer;
        kotlin.jvm.internal.E.c(k7);
        M0 printerDevice = k7.getPrinterDevice();
        kotlin.jvm.internal.E.c(printerDevice);
        return printerDevice.getPrintDeviceName();
    }

    public static final K0 getPrinter() {
        return _printer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: initJxDeviceState-gIAlu-s, reason: not valid java name */
    public static final Object m1096initJxDeviceStategIAlus(boolean z6, E3.g<? super u> gVar) throws Throwable {
        A a6;
        Object objM1100getPrinterStateIoAF18A;
        List<O0> mutableList;
        if (gVar instanceof A) {
            a6 = (A) gVar;
            int i5 = a6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                a6.c = i5 - Integer.MIN_VALUE;
            } else {
                a6 = new A(gVar);
            }
        } else {
            a6 = new A(gVar);
        }
        Object obj = a6.b;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = a6.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            K0 printer = getPrinter();
            kotlin.jvm.internal.E.c(printer);
            a6.f8843a = z6;
            a6.c = 1;
            objM1100getPrinterStateIoAF18A = printer.m1100getPrinterStateIoAF18A(a6);
            if (objM1100getPrinterStateIoAF18A != coroutine_suspended) {
            }
        }
        if (i6 != 1) {
            if (i6 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        z6 = a6.f8843a;
        v.throwOnFailure(obj);
        objM1100getPrinterStateIoAF18A = ((u) obj).b();
        boolean z7 = objM1100getPrinterStateIoAF18A instanceof u.a;
        if (z7) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(objM1100getPrinterStateIoAF18A);
            kotlin.jvm.internal.E.c(thM1362exceptionOrNullimpl);
            return u.m1361constructorimpl(v.createFailure(thM1362exceptionOrNullimpl));
        }
        K0 printer2 = getPrinter();
        M0 printerDevice = printer2 != null ? printer2.getPrinterDevice() : null;
        List<O0> list = eventListeners;
        synchronized (list) {
            mutableList = T.toMutableList((Collection) list);
        }
        for (O0 o6 : mutableList) {
            Object obj2 = z7 ? null : objM1100getPrinterStateIoAF18A;
            kotlin.jvm.internal.E.c(obj2);
            o6.onPrinterConnected(printerDevice, z6, (byte[]) obj2);
        }
        E e = INSTANCE;
        a6.c = 2;
        Object objM = e.m(z6, a6);
        return objM == coroutine_suspended ? coroutine_suspended : objM;
    }

    public static M l() {
        try {
            Object obj = store != null ? Hawk.get(LAST_CONNECT_DEVICE_INFO) : null;
            if (obj != null) {
                if (obj instanceof M) {
                    return (M) obj;
                }
                O.INSTANCE.e(TAG, "Invalid last connect device info: ".concat(obj.getClass().getName()));
                if (store != null) {
                    Hawk.delete(LAST_CONNECT_DEVICE_INFO);
                    return null;
                }
            }
        } catch (Exception e) {
            O.INSTANCE.e(TAG, "Read last connect device info failed: " + e.getMessage());
            if (store != null) {
                Hawk.delete(LAST_CONNECT_DEVICE_INFO);
            }
        }
        return null;
    }

    public static final boolean n() {
        if (getPrinter() == null) {
            return false;
        }
        K0 k6 = _printer;
        kotlin.jvm.internal.E.c(k6);
        return k6.b();
    }

    public final void addEventListener(O0 listener) {
        kotlin.jvm.internal.E.f(listener, "listener");
        List<O0> list = eventListeners;
        synchronized (list) {
            list.add(listener);
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00dc, code lost:
    
        if (r11.j(false, r0) == r1) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object connectBluetoothDevice(java.lang.String r10, boolean r11, E3.g<? super p147z3.Q> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p134x2.E.connectBluetoothDevice(java.lang.String, boolean, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f5, code lost:
    
        if (r14.k(r3, true, false, r1) == r2) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v23, types: [java.lang.Object, z3.Q] */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object connectUsbDevice(java.lang.String r13, java.lang.String r14, E3.g<? super p147z3.Q> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p134x2.E.connectUsbDevice(java.lang.String, java.lang.String, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f9, code lost:
    
        if (r13.k(r3, true, false, r1) == r2) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v23, types: [java.lang.Object, z3.Q] */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object connectWifiDevice(java.lang.String r12, java.lang.String r13, int r14, E3.g<? super p147z3.Q> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p134x2.E.connectWifiDevice(java.lang.String, java.lang.String, int, E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007c A[Catch: all -> 0x0031, TryCatch #1 {all -> 0x0031, blocks: (B:13:0x002d, B:33:0x0078, B:35:0x007c, B:36:0x0085, B:37:0x0087, B:39:0x008c, B:40:0x008d, B:41:0x0091, B:43:0x0097, B:48:0x00aa, B:49:0x00ab, B:38:0x0088), top: B:54:0x002d, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0097 A[Catch: all -> 0x0031, LOOP:0: B:41:0x0091->B:43:0x0097, LOOP_END, TRY_LEAVE, TryCatch #1 {all -> 0x0031, blocks: (B:13:0x002d, B:33:0x0078, B:35:0x007c, B:36:0x0085, B:37:0x0087, B:39:0x008c, B:40:0x008d, B:41:0x0091, B:43:0x0097, B:48:0x00aa, B:49:0x00ab, B:38:0x0088), top: B:54:0x002d, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object disconnectDevice(E3.g<? super Q> gVar) throws Throwable {
        C1886v c1886v;
        b bVar;
        b bVar2;
        Throwable th;
        M0 m6;
        List<O0> list;
        Iterator it;
        if (gVar instanceof C1886v) {
            c1886v = (C1886v) gVar;
            int i5 = c1886v.e;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1886v.e = i5 - Integer.MIN_VALUE;
            } else {
                c1886v = new C1886v(this, gVar);
            }
        } else {
            c1886v = new C1886v(this, gVar);
        }
        Object obj = c1886v.c;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = c1886v.e;
        try {
            if (i6 == 0) {
                v.throwOnFailure(obj);
                b bVar3 = lock;
                c1886v.f8943a = bVar3;
                c1886v.e = 1;
                bVar = (g) bVar3;
                if (bVar.lock(null, c1886v) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m6 = c1886v.b;
                bVar2 = c1886v.f8943a;
                try {
                    v.throwOnFailure(obj);
                    if (store != null) {
                        G3.b.boxBoolean(Hawk.delete(LAST_CONNECT_DEVICE_INFO));
                    }
                    list = eventListeners;
                    synchronized (list) {
                        List mutableList = T.toMutableList((Collection) list);
                    }
                    it = mutableList.iterator();
                    while (it.hasNext()) {
                        ((O0) it.next()).onPrinterDisconnected(m6);
                    }
                    ((g) bVar2).unlock(null);
                    return Q.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    ((g) bVar2).unlock(null);
                    throw th;
                }
            }
            b bVar4 = c1886v.f8943a;
            v.throwOnFailure(obj);
            bVar = bVar4;
            K0 printer = getPrinter();
            M0 printerDevice = printer != null ? printer.getPrinterDevice() : null;
            E e = INSTANCE;
            c1886v.f8943a = bVar;
            c1886v.b = printerDevice;
            c1886v.e = 2;
            if (e.j(false, c1886v) != coroutine_suspended) {
                bVar2 = bVar;
                m6 = printerDevice;
                if (store != null) {
                    G3.b.boxBoolean(Hawk.delete(LAST_CONNECT_DEVICE_INFO));
                }
                list = eventListeners;
                synchronized (list) {
                    List mutableList2 = T.toMutableList((Collection) list);
                    it = mutableList2.iterator();
                    while (it.hasNext()) {
                        ((O0) it.next()).onPrinterDisconnected(m6);
                    }
                    ((g) bVar2).unlock(null);
                    return Q.INSTANCE;
                }
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            bVar2 = bVar;
            th = th3;
            ((g) bVar2).unlock(null);
            throw th;
        }
    }

    public final BroadcastReceiver getBluetoothReceiver() {
        return bluetoothReceiver;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object i(d dVar) throws Throwable {
        C1859h c1859h;
        String str;
        Object objB;
        HashSet hashSet;
        if (dVar instanceof C1859h) {
            c1859h = (C1859h) dVar;
            int i5 = c1859h.e;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1859h.e = i5 - Integer.MIN_VALUE;
            } else {
                c1859h = new C1859h(this, dVar);
            }
        } else {
            c1859h = new C1859h(this, dVar);
        }
        Object obj = c1859h.c;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = c1859h.e;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            K0 printer = getPrinter();
            kotlin.jvm.internal.E.c(printer);
            M0 printerDevice = printer.getPrinterDevice();
            kotlin.jvm.internal.E.c(printerDevice);
            String printDeviceAddress = printerDevice.getPrintDeviceAddress();
            HashSet hashSet2 = new HashSet();
            if (store != null) {
                hashSet2 = (HashSet) Hawk.get("verified_printer", new HashSet());
                if (hashSet2.contains(printDeviceAddress)) {
                    return u.m1361constructorimpl(Q.INSTANCE);
                }
            }
            K0 printer2 = getPrinter();
            kotlin.jvm.internal.E.c(printer2);
            c1859h.f8902a = printDeviceAddress;
            c1859h.b = hashSet2;
            c1859h.e = 1;
            Object objM1097checkMd5IoAF18A = printer2.m1097checkMd5IoAF18A(c1859h);
            if (objM1097checkMd5IoAF18A == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = printDeviceAddress;
            objB = objM1097checkMd5IoAF18A;
            hashSet = hashSet2;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hashSet = c1859h.b;
            str = c1859h.f8902a;
            v.throwOnFailure(obj);
            objB = ((u) obj).b();
        }
        boolean z6 = objB instanceof u.a;
        if (z6) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(objB);
            kotlin.jvm.internal.E.c(thM1362exceptionOrNullimpl);
            return u.m1361constructorimpl(v.createFailure(thM1362exceptionOrNullimpl));
        }
        if (z6) {
            objB = null;
        }
        kotlin.jvm.internal.E.c(objB);
        if (!((Boolean) objB).booleanValue()) {
            return a.g(MD5_CHECK_FAILED);
        }
        if (store != null) {
            hashSet.add(str);
            Q0 q6 = store;
            kotlin.jvm.internal.E.c(q6);
            ((C0953x2) q6).getClass();
            Hawk.put("verified_printer", hashSet);
        }
        return u.m1361constructorimpl(Q.INSTANCE);
    }

    public final void init(Context context2, Q0 store2) {
        kotlin.jvm.internal.E.f(context2, "context");
        kotlin.jvm.internal.E.f(store2, "store");
        store = store2;
        context = context2.getApplicationContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        Context context3 = context;
        kotlin.jvm.internal.E.c(context3);
        context3.registerReceiver(bluetoothReceiver, intentFilter);
        M mL = l();
        if (mL != null) {
            String type = mL.getType();
            L l6 = M.Companion;
            if (kotlin.jvm.internal.E.a(type, l6.getBluetoothDevice())) {
                AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C1890x(mL, null));
            } else if (kotlin.jvm.internal.E.a(mL.getType(), l6.getUsbDevice())) {
                AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C1892y(mL, null));
            } else if (kotlin.jvm.internal.E.a(mL.getType(), l6.getWifiDevice())) {
                AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C1894z(mL, null));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0066  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object j(boolean z6, d dVar) throws Throwable {
        C1861i c1861i;
        E e;
        if (dVar instanceof C1861i) {
            c1861i = (C1861i) dVar;
            int i5 = c1861i.e;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1861i.e = i5 - Integer.MIN_VALUE;
            } else {
                c1861i = new C1861i(this, dVar);
            }
        } else {
            c1861i = new C1861i(this, dVar);
        }
        Object obj = c1861i.c;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = c1861i.e;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            K0 k6 = _printer;
            if (k6 != null) {
                c1861i.f8904a = this;
                c1861i.b = z6;
                c1861i.e = 1;
                if (k6.close(c1861i) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                e = this;
            }
            if (!z6) {
                curDevice = null;
            }
            return Q.INSTANCE;
        }
        if (i6 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z6 = c1861i.b;
        e = c1861i.f8904a;
        v.throwOnFailure(obj);
        e.getClass();
        _printer = null;
        if (z6) {
            AbstractC0272e.b(N.CoroutineScope(C0276f0.getDefault()), null, 3, new D(2, null));
        }
        if (!z6) {
            curDevice = null;
        }
        return Q.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x0198 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0131  */
    /* JADX WARN: Code duplicated, block: B:57:0x0151  */
    /* JADX WARN: Code duplicated, block: B:60:0x0161  */
    /* JADX WARN: Code duplicated, block: B:68:0x0174 A[LOOP:1: B:66:0x016e->B:68:0x0174, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x0185  */
    /* JADX WARN: Code duplicated, block: B:75:0x0194  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:83:0x01a7 A[LOOP:0: B:81:0x01a1->B:83:0x01a7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:94:0x01ca A[LOOP:2: B:92:0x01c4->B:94:0x01ca, LOOP_END] */
    public final Object k(M0 m6, boolean z6, boolean z7, d dVar) throws Throwable {
        C1863j c1863j;
        Object objM1098connect0E7RQCE;
        E e;
        Object objM1096initJxDeviceStategIAlus;
        M0 m7;
        boolean z8;
        List mutableList;
        List<O0> list;
        Iterator it;
        Throwable thM1362exceptionOrNullimpl;
        M0 m8;
        M0 m9;
        List<O0> list2;
        Iterator it2;
        List<O0> list3;
        Iterator it3;
        if (dVar instanceof C1863j) {
            c1863j = (C1863j) dVar;
            int i5 = c1863j.f8908g;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c1863j.f8908g = i5 - Integer.MIN_VALUE;
            } else {
                c1863j = new C1863j(this, dVar);
            }
        } else {
            c1863j = new C1863j(this, dVar);
        }
        Object obj = c1863j.e;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = c1863j.f8908g;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            K0 k6 = new K0();
            _printer = k6;
            Context context2 = context;
            kotlin.jvm.internal.E.c(context2);
            c1863j.f8906a = this;
            c1863j.b = m6;
            c1863j.c = z6;
            c1863j.d = z7;
            c1863j.f8908g = 1;
            objM1098connect0E7RQCE = k6.m1098connect0E7RQCE(context2, m6, c1863j);
            if (objM1098connect0E7RQCE != coroutine_suspended) {
                e = this;
            }
            return coroutine_suspended;
        }
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    z8 = c1863j.c;
                    m9 = (M0) c1863j.f8906a;
                    v.throwOnFailure(obj);
                    list2 = eventListeners;
                    synchronized (list2) {
                        List mutableList2 = T.toMutableList((Collection) list2);
                    }
                    it2 = mutableList2.iterator();
                    while (it2.hasNext()) {
                        ((O0) it2.next()).onPrinterError(m9, z8, N0.b, MD5_CHECK_FAILED);
                    }
                    return Q.INSTANCE;
                }
                if (i6 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z8 = c1863j.c;
                m8 = (M0) c1863j.f8906a;
                v.throwOnFailure(obj);
                list3 = eventListeners;
                synchronized (list3) {
                    List mutableList3 = T.toMutableList((Collection) list3);
                }
                it3 = mutableList3.iterator();
                while (it3.hasNext()) {
                    ((O0) it3.next()).onPrinterError(m8, z8, N0.f8860a, "connectDevice error");
                }
                return Q.INSTANCE;
            }
            z8 = c1863j.d;
            z6 = c1863j.c;
            m7 = c1863j.b;
            e = (E) c1863j.f8906a;
            v.throwOnFailure(obj);
            objM1096initJxDeviceStategIAlus = ((u) obj).b();
            if (objM1096initJxDeviceStategIAlus instanceof u.a) {
                O.INSTANCE.e(TAG, "connectDevice error", u.m1362exceptionOrNullimpl(objM1096initJxDeviceStategIAlus));
                thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(objM1096initJxDeviceStategIAlus);
                kotlin.jvm.internal.E.c(thM1362exceptionOrNullimpl);
                if (kotlin.jvm.internal.E.a(thM1362exceptionOrNullimpl.getMessage(), MD5_CHECK_FAILED)) {
                    c1863j.f8906a = m7;
                    c1863j.b = null;
                    c1863j.c = z8;
                    c1863j.f8908g = 3;
                    if (e.j(false, c1863j) != coroutine_suspended) {
                        m9 = m7;
                        list2 = eventListeners;
                        synchronized (list2) {
                            List mutableList4 = T.toMutableList((Collection) list2);
                            it2 = mutableList4.iterator();
                            while (it2.hasNext()) {
                                ((O0) it2.next()).onPrinterError(m9, z8, N0.b, MD5_CHECK_FAILED);
                            }
                        }
                    }
                } else {
                    c1863j.f8906a = m7;
                    c1863j.b = null;
                    c1863j.c = z8;
                    c1863j.f8908g = 4;
                    if (e.j(z6, c1863j) != coroutine_suspended) {
                        m8 = m7;
                        list3 = eventListeners;
                        synchronized (list3) {
                            List mutableList5 = T.toMutableList((Collection) list3);
                            it3 = mutableList5.iterator();
                            while (it3.hasNext()) {
                                ((O0) it3.next()).onPrinterError(m8, z8, N0.f8860a, "connectDevice error");
                            }
                        }
                    }
                }
                return coroutine_suspended;
            }
            list = eventListeners;
            synchronized (list) {
                List mutableList6 = T.toMutableList((Collection) list);
            }
            it = mutableList6.iterator();
            while (it.hasNext()) {
                ((O0) it.next()).onVerfiyPrinterSuccess(m7, z8);
            }
            return Q.INSTANCE;
        }
        z7 = c1863j.d;
        z6 = c1863j.c;
        m6 = c1863j.b;
        e = (E) c1863j.f8906a;
        v.throwOnFailure(obj);
        objM1098connect0E7RQCE = ((u) obj).b();
        if (objM1098connect0E7RQCE instanceof u.a) {
            O.INSTANCE.e(TAG, "connectDevice error", u.m1362exceptionOrNullimpl(objM1098connect0E7RQCE));
            e.getClass();
            _printer = null;
            List<O0> list4 = eventListeners;
            synchronized (list4) {
                mutableList = T.toMutableList((Collection) list4);
            }
            Iterator it4 = mutableList.iterator();
            while (it4.hasNext()) {
                ((O0) it4.next()).onPrinterError(m6, z7, N0.f8860a, "connectDevice error");
            }
            if (!(u.m1362exceptionOrNullimpl(objM1098connect0E7RQCE) instanceof F) && z6) {
                AbstractC0272e.b(N.CoroutineScope(C0276f0.getDefault()), null, 3, new D(2, null));
            }
            return Q.INSTANCE;
        }
        K0 printer = getPrinter();
        if (printer != null) {
            printer.setRecvListener(new C1867l(m6));
        }
        K0 printer2 = getPrinter();
        if (printer2 != null) {
            printer2.setSendFailedListener(new C1871n(m6));
        }
        f8851a = System.currentTimeMillis();
        O.INSTANCE.i(TAG, "connectDevice success");
        c1863j.f8906a = e;
        c1863j.b = m6;
        c1863j.c = z6;
        c1863j.d = z7;
        c1863j.f8908g = 2;
        objM1096initJxDeviceStategIAlus = m1096initJxDeviceStategIAlus(z7, c1863j);
        if (objM1096initJxDeviceStategIAlus != coroutine_suspended) {
            boolean z9 = z7;
            m7 = m6;
            z8 = z9;
            if (objM1096initJxDeviceStategIAlus instanceof u.a) {
                O.INSTANCE.e(TAG, "connectDevice error", u.m1362exceptionOrNullimpl(objM1096initJxDeviceStategIAlus));
                thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(objM1096initJxDeviceStategIAlus);
                kotlin.jvm.internal.E.c(thM1362exceptionOrNullimpl);
                if (kotlin.jvm.internal.E.a(thM1362exceptionOrNullimpl.getMessage(), MD5_CHECK_FAILED)) {
                    c1863j.f8906a = m7;
                    c1863j.b = null;
                    c1863j.c = z8;
                    c1863j.f8908g = 3;
                    if (e.j(false, c1863j) != coroutine_suspended) {
                        m9 = m7;
                        list2 = eventListeners;
                        synchronized (list2) {
                            List mutableList7 = T.toMutableList((Collection) list2);
                            it2 = mutableList7.iterator();
                            while (it2.hasNext()) {
                                ((O0) it2.next()).onPrinterError(m9, z8, N0.b, MD5_CHECK_FAILED);
                            }
                        }
                    }
                } else {
                    c1863j.f8906a = m7;
                    c1863j.b = null;
                    c1863j.c = z8;
                    c1863j.f8908g = 4;
                    if (e.j(z6, c1863j) != coroutine_suspended) {
                        m8 = m7;
                        list3 = eventListeners;
                        synchronized (list3) {
                            List mutableList8 = T.toMutableList((Collection) list3);
                            it3 = mutableList8.iterator();
                            while (it3.hasNext()) {
                                ((O0) it3.next()).onPrinterError(m8, z8, N0.f8860a, "connectDevice error");
                            }
                        }
                    }
                }
            } else {
                list = eventListeners;
                synchronized (list) {
                    List mutableList9 = T.toMutableList((Collection) list);
                    it = mutableList9.iterator();
                    while (it.hasNext()) {
                        ((O0) it.next()).onVerfiyPrinterSuccess(m7, z8);
                    }
                }
            }
            return Q.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0099  */
    /* JADX WARN: Code duplicated, block: B:26:0x009d  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object m(boolean z6, d dVar) throws Throwable {
        B b6;
        K0 k6;
        K0 k7;
        M0 printerDevice;
        M0 printerDevice2;
        Object objM1099getPrinterInfoIoAF18A;
        E e;
        List mutableList;
        if (dVar instanceof B) {
            b6 = (B) dVar;
            int i5 = b6.e;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                b6.e = i5 - Integer.MIN_VALUE;
            } else {
                b6 = new B(this, dVar);
            }
        } else {
            b6 = new B(this, dVar);
        }
        Object obj = b6.c;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = b6.e;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            K0 k8 = _printer;
            if (k8 != null) {
                M0 printerDevice3 = k8.getPrinterDevice();
                kotlin.jvm.internal.E.c(printerDevice3);
                if (printerDevice3.getPrinterType() != L0.f8859a) {
                    k6 = _printer;
                    if (k6 != null) {
                        printerDevice2 = k6.getPrinterDevice();
                        kotlin.jvm.internal.E.c(printerDevice2);
                        if (printerDevice2.getPrinterType() == L0.b) {
                            k7 = _printer;
                            if (k7 != null) {
                                printerDevice = k7.getPrinterDevice();
                                kotlin.jvm.internal.E.c(printerDevice);
                                if (printerDevice.getPrinterType() == L0.c && store != null) {
                                    String wifiDevice = M.Companion.getWifiDevice();
                                    K0 k9 = _printer;
                                    kotlin.jvm.internal.E.c(k9);
                                    M0 printerDevice4 = k9.getPrinterDevice();
                                    kotlin.jvm.internal.E.c(printerDevice4);
                                    String printDeviceAddress = printerDevice4.getPrintDeviceAddress();
                                    K0 k10 = _printer;
                                    kotlin.jvm.internal.E.c(k10);
                                    M0 printerDevice5 = k10.getPrinterDevice();
                                    kotlin.jvm.internal.E.c(printerDevice5);
                                    G3.b.boxBoolean(Hawk.put(LAST_CONNECT_DEVICE_INFO, new M(wifiDevice, printDeviceAddress, printerDevice5.getPrintDeviceName())));
                                }
                            }
                        } else if (store != null) {
                            String usbDevice = M.Companion.getUsbDevice();
                            K0 k11 = _printer;
                            kotlin.jvm.internal.E.c(k11);
                            M0 printerDevice6 = k11.getPrinterDevice();
                            kotlin.jvm.internal.E.c(printerDevice6);
                            String printDeviceAddress2 = printerDevice6.getPrintDeviceAddress();
                            K0 k12 = _printer;
                            kotlin.jvm.internal.E.c(k12);
                            M0 printerDevice7 = k12.getPrinterDevice();
                            kotlin.jvm.internal.E.c(printerDevice7);
                            G3.b.boxBoolean(Hawk.put(LAST_CONNECT_DEVICE_INFO, new M(usbDevice, printDeviceAddress2, printerDevice7.getPrintDeviceName())));
                        }
                    } else {
                        k7 = _printer;
                        if (k7 != null) {
                            printerDevice = k7.getPrinterDevice();
                            kotlin.jvm.internal.E.c(printerDevice);
                            if (printerDevice.getPrinterType() == L0.c) {
                                String wifiDevice2 = M.Companion.getWifiDevice();
                                K0 k13 = _printer;
                                kotlin.jvm.internal.E.c(k13);
                                M0 printerDevice8 = k13.getPrinterDevice();
                                kotlin.jvm.internal.E.c(printerDevice8);
                                String printDeviceAddress3 = printerDevice8.getPrintDeviceAddress();
                                K0 k14 = _printer;
                                kotlin.jvm.internal.E.c(k14);
                                M0 printerDevice9 = k14.getPrinterDevice();
                                kotlin.jvm.internal.E.c(printerDevice9);
                                G3.b.boxBoolean(Hawk.put(LAST_CONNECT_DEVICE_INFO, new M(wifiDevice2, printDeviceAddress3, printerDevice9.getPrintDeviceName())));
                            }
                        }
                    }
                } else if (store != null) {
                    String bluetoothDevice = M.Companion.getBluetoothDevice();
                    K0 k15 = _printer;
                    kotlin.jvm.internal.E.c(k15);
                    M0 printerDevice10 = k15.getPrinterDevice();
                    kotlin.jvm.internal.E.c(printerDevice10);
                    String printDeviceAddress4 = printerDevice10.getPrintDeviceAddress();
                    K0 k16 = _printer;
                    kotlin.jvm.internal.E.c(k16);
                    M0 printerDevice11 = k16.getPrinterDevice();
                    kotlin.jvm.internal.E.c(printerDevice11);
                    G3.b.boxBoolean(Hawk.put(LAST_CONNECT_DEVICE_INFO, new M(bluetoothDevice, printDeviceAddress4, printerDevice11.getPrintDeviceName())));
                }
            } else {
                k6 = _printer;
                if (k6 != null) {
                    printerDevice2 = k6.getPrinterDevice();
                    kotlin.jvm.internal.E.c(printerDevice2);
                    if (printerDevice2.getPrinterType() == L0.b) {
                        k7 = _printer;
                        if (k7 != null) {
                            printerDevice = k7.getPrinterDevice();
                            kotlin.jvm.internal.E.c(printerDevice);
                            if (printerDevice.getPrinterType() == L0.c) {
                                String wifiDevice3 = M.Companion.getWifiDevice();
                                K0 k17 = _printer;
                                kotlin.jvm.internal.E.c(k17);
                                M0 printerDevice12 = k17.getPrinterDevice();
                                kotlin.jvm.internal.E.c(printerDevice12);
                                String printDeviceAddress5 = printerDevice12.getPrintDeviceAddress();
                                K0 k18 = _printer;
                                kotlin.jvm.internal.E.c(k18);
                                M0 printerDevice13 = k18.getPrinterDevice();
                                kotlin.jvm.internal.E.c(printerDevice13);
                                G3.b.boxBoolean(Hawk.put(LAST_CONNECT_DEVICE_INFO, new M(wifiDevice3, printDeviceAddress5, printerDevice13.getPrintDeviceName())));
                            }
                        }
                    } else if (store != null) {
                        String usbDevice2 = M.Companion.getUsbDevice();
                        K0 k19 = _printer;
                        kotlin.jvm.internal.E.c(k19);
                        M0 printerDevice14 = k19.getPrinterDevice();
                        kotlin.jvm.internal.E.c(printerDevice14);
                        String printDeviceAddress6 = printerDevice14.getPrintDeviceAddress();
                        K0 k110 = _printer;
                        kotlin.jvm.internal.E.c(k110);
                        M0 printerDevice15 = k110.getPrinterDevice();
                        kotlin.jvm.internal.E.c(printerDevice15);
                        G3.b.boxBoolean(Hawk.put(LAST_CONNECT_DEVICE_INFO, new M(usbDevice2, printDeviceAddress6, printerDevice15.getPrintDeviceName())));
                    }
                } else {
                    k7 = _printer;
                    if (k7 != null) {
                        printerDevice = k7.getPrinterDevice();
                        kotlin.jvm.internal.E.c(printerDevice);
                        if (printerDevice.getPrinterType() == L0.c) {
                            String wifiDevice4 = M.Companion.getWifiDevice();
                            K0 k111 = _printer;
                            kotlin.jvm.internal.E.c(k111);
                            M0 printerDevice16 = k111.getPrinterDevice();
                            kotlin.jvm.internal.E.c(printerDevice16);
                            String printDeviceAddress7 = printerDevice16.getPrintDeviceAddress();
                            K0 k112 = _printer;
                            kotlin.jvm.internal.E.c(k112);
                            M0 printerDevice17 = k112.getPrinterDevice();
                            kotlin.jvm.internal.E.c(printerDevice17);
                            G3.b.boxBoolean(Hawk.put(LAST_CONNECT_DEVICE_INFO, new M(wifiDevice4, printDeviceAddress7, printerDevice17.getPrintDeviceName())));
                        }
                    }
                }
            }
            K0 printer = getPrinter();
            kotlin.jvm.internal.E.c(printer);
            b6.f8845a = this;
            b6.b = z6;
            b6.e = 1;
            objM1099getPrinterInfoIoAF18A = printer.m1099getPrinterInfoIoAF18A(b6);
            if (objM1099getPrinterInfoIoAF18A != coroutine_suspended) {
                e = this;
            }
        }
        if (i6 != 1) {
            if (i6 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.throwOnFailure(obj);
            return ((u) obj).b();
        }
        z6 = b6.b;
        e = b6.f8845a;
        v.throwOnFailure(obj);
        objM1099getPrinterInfoIoAF18A = ((u) obj).b();
        boolean z7 = objM1099getPrinterInfoIoAF18A instanceof u.a;
        if (z7) {
            O.INSTANCE.e(TAG, "获取打印机信息失败");
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(objM1099getPrinterInfoIoAF18A);
            kotlin.jvm.internal.E.c(thM1362exceptionOrNullimpl);
            return u.m1361constructorimpl(v.createFailure(thM1362exceptionOrNullimpl));
        }
        List<O0> list = eventListeners;
        synchronized (list) {
            mutableList = T.toMutableList((Collection) list);
        }
        Iterator it = mutableList.iterator();
        while (true) {
            Object obj2 = null;
            if (!it.hasNext()) {
                break;
            }
            O0 o6 = (O0) it.next();
            K0 printer2 = getPrinter();
            M0 printerDevice18 = printer2 != null ? printer2.getPrinterDevice() : null;
            if (!z7) {
                obj2 = objM1099getPrinterInfoIoAF18A;
            }
            kotlin.jvm.internal.E.c(obj2);
            o6.onGetPrinterInfo(printerDevice18, z6, (P0) obj2);
        }
        b6.f8845a = null;
        b6.e = 2;
        Object objI = e.i(b6);
        return objI == coroutine_suspended ? coroutine_suspended : objI;
    }

    public final void removeEventListener(O0 listener) {
        kotlin.jvm.internal.E.f(listener, "listener");
        List<O0> list = eventListeners;
        synchronized (list) {
            list.remove(listener);
        }
    }

    public final void setBluetoothReceiver(BroadcastReceiver broadcastReceiver) {
        kotlin.jvm.internal.E.f(broadcastReceiver, "<set-?>");
        bluetoothReceiver = broadcastReceiver;
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
