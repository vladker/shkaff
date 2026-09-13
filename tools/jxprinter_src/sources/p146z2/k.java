package p146z2;

import A3.T;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static final k INSTANCE = new k();

    public static final UsbDevice getUsbDevice(Context context, String deviceAddress) {
        E.f(context, "context");
        E.f(deviceAddress, "deviceAddress");
        Object systemService = context.getSystemService("usb");
        E.d(systemService, "null cannot be cast to non-null type android.hardware.usb.UsbManager");
        Iterator<Map.Entry<String, UsbDevice>> it = ((UsbManager) systemService).getDeviceList().entrySet().iterator();
        while (it.hasNext()) {
            UsbDevice value = it.next().getValue();
            E.c(value);
            if (E.a(getUsbDeviceAddress(value), deviceAddress)) {
                return value;
            }
        }
        return null;
    }

    public static final String getUsbDeviceAddress(UsbDevice device) {
        E.f(device, "device");
        return device.getProductName() + "_" + device.getProductId() + "_" + device.getVendorId();
    }

    public static final List<UsbDevice> getUsbDevices(Context context) {
        E.f(context, "context");
        Object systemService = context.getSystemService("usb");
        E.d(systemService, "null cannot be cast to non-null type android.hardware.usb.UsbManager");
        Collection<UsbDevice> collectionValues = ((UsbManager) systemService).getDeviceList().values();
        E.e(collectionValues, "<get-values>(...)");
        return T.toList(collectionValues);
    }
}
