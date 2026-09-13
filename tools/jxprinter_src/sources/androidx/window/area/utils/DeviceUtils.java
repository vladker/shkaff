package androidx.window.area.utils;

import A3.G;
import android.util.DisplayMetrics;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(17)
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();
    private static final List<DeviceMetrics> deviceList;

    static {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.widthPixels = 1080;
        displayMetrics.heightPixels = 2092;
        displayMetrics.density = 2.625f;
        displayMetrics.densityDpi = 420;
        deviceList = G.listOf(new DeviceMetrics("google", "pixel fold", displayMetrics));
    }

    private DeviceUtils() {
    }

    public final DisplayMetrics getRearDisplayMetrics$window_release(String manufacturer, String model) {
        Object next;
        E.f(manufacturer, "manufacturer");
        E.f(model, "model");
        Iterator<T> it = deviceList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            DeviceMetrics deviceMetrics = (DeviceMetrics) next;
            String manufacturer2 = deviceMetrics.getManufacturer();
            Locale US = Locale.US;
            E.e(US, "US");
            String lowerCase = manufacturer.toLowerCase(US);
            E.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (E.a(manufacturer2, lowerCase)) {
                String model2 = deviceMetrics.getModel();
                E.e(US, "US");
                String lowerCase2 = model.toLowerCase(US);
                E.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                if (E.a(model2, lowerCase2)) {
                    break;
                }
            }
        }
        DeviceMetrics deviceMetrics2 = (DeviceMetrics) next;
        if (deviceMetrics2 != null) {
            return deviceMetrics2.getRearDisplayMetrics();
        }
        return null;
    }

    public final boolean hasDeviceMetrics$window_release(String manufacturer, String model) {
        E.f(manufacturer, "manufacturer");
        E.f(model, "model");
        List<DeviceMetrics> list = deviceList;
        if (list != null && list.isEmpty()) {
            return false;
        }
        for (DeviceMetrics deviceMetrics : list) {
            String manufacturer2 = deviceMetrics.getManufacturer();
            Locale US = Locale.US;
            E.e(US, "US");
            String lowerCase = manufacturer.toLowerCase(US);
            E.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (E.a(manufacturer2, lowerCase)) {
                String model2 = deviceMetrics.getModel();
                E.e(US, "US");
                String lowerCase2 = model.toLowerCase(US);
                E.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                if (E.a(model2, lowerCase2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
