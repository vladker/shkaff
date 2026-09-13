package p146z2;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import kotlin.jvm.internal.E;
import p134x2.L0;
import p134x2.M0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements M0 {
    public static final a Companion = new a();
    private UsbDevice _device;
    private final String deviceAddress;
    private final String deviceName;

    public b(String deviceName, String deviceAddress) {
        E.f(deviceName, "deviceName");
        E.f(deviceAddress, "deviceAddress");
        this.deviceName = deviceName;
        this.deviceAddress = deviceAddress;
    }

    public static final String getUsbDeviceAddress(UsbDevice usbDevice) {
        return Companion.getUsbDeviceAddress(usbDevice);
    }

    public final UsbDevice getDevice(Context context) {
        E.f(context, "context");
        if (this._device == null) {
            this._device = k.getUsbDevice(context, this.deviceAddress);
        }
        return this._device;
    }

    @Override // p134x2.M0
    public String getPrintDeviceAddress() {
        return this.deviceAddress;
    }

    @Override // p134x2.M0
    public String getPrintDeviceName() {
        return this.deviceName;
    }

    @Override // p134x2.M0
    public L0 getPrinterType() {
        return L0.b;
    }

    public final UsbDevice get_device() {
        return this._device;
    }

    @Override // p134x2.M0
    public boolean isSameDevice(M0 device) {
        E.f(device, "device");
        if (device instanceof b) {
            b bVar = (b) device;
            if (E.a(this.deviceName, bVar.deviceName) && E.a(this.deviceAddress, bVar.deviceAddress)) {
                return true;
            }
        }
        return false;
    }

    public final void set_device(UsbDevice usbDevice) {
        this._device = usbDevice;
    }
}
