package p146z2;

import E3.g;
import F3.i;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import com.google.android.gms.auth.api.accounttransfer.a;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.E;
import p134x2.H;
import p134x2.M0;
import p134x2.O;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements H {
    private static final String ACTION_USB_PERMISSION = "com.android.sandu.USB_PERMISSION";
    public static final c Companion = new c();
    private static final String TAG = "UsbConnection";
    private UsbDeviceConnection connection;
    private final Context context;
    private final b device;
    private m inEndpoint;
    private final BroadcastReceiver mUsbReceiver;
    private o outEndpoint;
    private d state;
    private UsbInterface usbInterface;
    private final UsbManager usbManager;

    public j(Context context, b device) {
        E.f(context, "context");
        E.f(device, "device");
        this.context = context;
        this.device = device;
        Object systemService = context.getSystemService("usb");
        E.d(systemService, "null cannot be cast to non-null type android.hardware.usb.UsbManager");
        this.usbManager = (UsbManager) systemService;
        this.state = d.f9115a;
        this.mUsbReceiver = new i(this);
    }

    @Override // p134x2.H
    /* JADX INFO: renamed from: close-IoAF18A */
    public Object mo0closeIoAF18A(g<? super u> gVar) {
        O.INSTANCE.i(TAG, "close()     USBPort");
        UsbDeviceConnection usbDeviceConnection = this.connection;
        if (usbDeviceConnection != null) {
            E.c(usbDeviceConnection);
            usbDeviceConnection.releaseInterface(this.usbInterface);
            UsbDeviceConnection usbDeviceConnection2 = this.connection;
            E.c(usbDeviceConnection2);
            usbDeviceConnection2.close();
            this.connection = null;
        }
        return u.m1361constructorimpl(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c4, code lost:
    
        if (p007a4.AbstractC0261a0.delay(1000, r0) == r1) goto L38;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c4 -> B:39:0x00c7). Please report as a decompilation issue!!! */
    @Override // p134x2.H
    /* JADX INFO: renamed from: connect-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo1connectIoAF18A(E3.g<? super p147z3.u> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p146z2.j.mo1connectIoAF18A(E3.g):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: connectInner-IoAF18A, reason: not valid java name */
    public final Object m1124connectInnerIoAF18A(g<? super u> gVar) throws Throwable {
        f fVar;
        Exception exc;
        if (gVar instanceof f) {
            fVar = (f) gVar;
            int i5 = fVar.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                fVar.d = i5 - Integer.MIN_VALUE;
            } else {
                fVar = new f(this, gVar);
            }
        } else {
            fVar = new f(this, gVar);
        }
        Object obj = fVar.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = fVar.d;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            if (!this.usbManager.hasPermission(this.device.getDevice(this.context))) {
                return a.g("permission denied");
            }
            try {
                UsbDevice device = this.device.getDevice(this.context);
                E.c(device);
                this.usbInterface = device.getInterface(0);
                UsbDeviceConnection usbDeviceConnectionOpenDevice = this.usbManager.openDevice(this.device.getDevice(this.context));
                this.connection = usbDeviceConnectionOpenDevice;
                if (usbDeviceConnectionOpenDevice != null && usbDeviceConnectionOpenDevice.claimInterface(this.usbInterface, true)) {
                    UsbInterface usbInterface = this.usbInterface;
                    E.c(usbInterface);
                    int endpointCount = usbInterface.getEndpointCount();
                    for (int i7 = 0; i7 < endpointCount; i7++) {
                        UsbInterface usbInterface2 = this.usbInterface;
                        E.c(usbInterface2);
                        UsbEndpoint endpoint = usbInterface2.getEndpoint(i7);
                        if (endpoint.getType() == 2) {
                            if (endpoint.getDirection() != 0) {
                                UsbDeviceConnection usbDeviceConnection = this.connection;
                                E.c(usbDeviceConnection);
                                this.inEndpoint = new m(usbDeviceConnection, endpoint);
                            } else {
                                UsbDeviceConnection usbDeviceConnection2 = this.connection;
                                E.c(usbDeviceConnection2);
                                this.outEndpoint = new o(usbDeviceConnection2, endpoint);
                            }
                        }
                    }
                    return u.m1361constructorimpl(Q.INSTANCE);
                }
                return u.m1361constructorimpl(v.createFailure(new Exception("open device failed")));
            } catch (Exception e) {
                O.INSTANCE.e(TAG, "connectInner failed", e);
                fVar.f9118a = e;
                fVar.d = 1;
                if (mo0closeIoAF18A(fVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                exc = e;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            exc = fVar.f9118a;
            v.throwOnFailure(obj);
            ((u) obj).getClass();
        }
        return u.m1361constructorimpl(v.createFailure(exc));
    }

    @Override // p134x2.H
    public InputStream getInputStream() {
        return this.inEndpoint;
    }

    @Override // p134x2.H
    public OutputStream getOutputStream() {
        return this.outEndpoint;
    }

    @Override // p134x2.H
    public M0 getPrinterDevice() {
        return this.device;
    }
}
