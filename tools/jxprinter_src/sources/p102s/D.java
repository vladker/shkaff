package p102s;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.idlefish.flutterboost.FlutterBoost;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;
import p108t.U;
import p108t.b0;
import p146z2.k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class D implements U {
    @Override // p108t.U
    public List<b0> getDevices() {
        Object systemService = FlutterBoost.instance().currentActivity().getSystemService("usb");
        E.d(systemService, "null cannot be cast to non-null type android.hardware.usb.UsbManager");
        HashMap<String, UsbDevice> deviceList = ((UsbManager) systemService).getDeviceList();
        ArrayList arrayList = new ArrayList();
        E.c(deviceList);
        for (Map.Entry<String, UsbDevice> entry : deviceList.entrySet()) {
            String deviceName = entry.getValue().getDeviceName();
            E.e(deviceName, "getDeviceName(...)");
            UsbDevice value = entry.getValue();
            E.e(value, "<get-value>(...)");
            arrayList.add(new b0(deviceName, k.getUsbDeviceAddress(value)));
        }
        return arrayList;
    }
}
