package p102s;

import A2.h;
import A3.J;
import com.idlefish.flutterboost.FlutterBoost;
import com.orhanobut.hawk.Hawk;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p108t.X;
import p108t.d0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class E implements X {
    @Override // p108t.X
    public void addDevice(d0 device) {
        kotlin.jvm.internal.E.f(device, "device");
        long j6 = device.f8527a;
        List<h> list = (List) Hawk.get("wifi_devices", new ArrayList());
        for (h hVar : list) {
            if (kotlin.jvm.internal.E.a(hVar.getIp(), device.getIp()) && hVar.f28a == ((int) j6)) {
                return;
            }
        }
        list.add(new h(device.getIp(), (int) j6, device.getName()));
        Hawk.put("wifi_devices", list);
        FlutterBoost.instance().sendEventToFlutter("refresh_wifi_list", new LinkedHashMap());
    }

    @Override // p108t.X
    public List<d0> getDevices() {
        List<h> list = (List) Hawk.get("wifi_devices", new ArrayList());
        kotlin.jvm.internal.E.c(list);
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(list, 10));
        for (h hVar : list) {
            arrayList.add(new d0(hVar.getPrintDeviceName(), hVar.getIp(), hVar.f28a));
        }
        return arrayList;
    }

    @Override // p108t.X
    public void removeDevice(d0 device) {
        kotlin.jvm.internal.E.f(device, "device");
        List<h> list = (List) Hawk.get("wifi_devices", new ArrayList());
        for (h hVar : list) {
            if (kotlin.jvm.internal.E.a(hVar.getIp(), device.getIp()) && hVar.f28a == ((int) device.f8527a)) {
                list.remove(hVar);
                break;
            }
        }
        Hawk.put("wifi_devices", list);
        FlutterBoost.instance().sendEventToFlutter("refresh_wifi_list", new LinkedHashMap());
    }

    @Override // p108t.X
    public void updateDevice(d0 oldDevice, d0 newDevice) {
        kotlin.jvm.internal.E.f(oldDevice, "oldDevice");
        kotlin.jvm.internal.E.f(newDevice, "newDevice");
        List<h> list = (List) Hawk.get("wifi_devices", new ArrayList());
        int i5 = 0;
        for (h hVar : list) {
            if (kotlin.jvm.internal.E.a(hVar.getIp(), oldDevice.getIp()) && hVar.f28a == ((int) oldDevice.f8527a)) {
                list.set(i5, new h(newDevice.getIp(), (int) newDevice.f8527a, newDevice.getName()));
                break;
            }
            i5++;
        }
        Hawk.put("wifi_devices", list);
        FlutterBoost.instance().sendEventToFlutter("refresh_wifi_list", new LinkedHashMap());
    }
}
