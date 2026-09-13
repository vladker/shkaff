package p102s;

import androidx.webkit.a;
import com.appdev.standard.dialog.C0462o;
import com.appdev.standard.page.MainActivity;
import com.idlefish.flutterboost.FlutterBoost;
import java.util.HashMap;
import kotlin.jvm.internal.E;
import org.opencv.videoio.Videoio;
import p108t.P;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class B implements P {
    public static final A Companion = new A();
    private static C0462o datePickerDialog;

    public static void a() {
        C0462o c0462o = datePickerDialog;
        if (c0462o != null) {
            E.c(c0462o);
            c0462o.dismiss();
            datePickerDialog = null;
        }
    }

    public static void b() {
        C0462o c0462o = datePickerDialog;
        if (c0462o != null) {
            E.c(c0462o);
            c0462o.dismiss();
            datePickerDialog = null;
        }
    }

    public static void c(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("startTime", str);
        map.put("endTime", str2);
        map.put("callbackId", str3);
        C0462o c0462o = datePickerDialog;
        if (c0462o != null) {
            try {
                c0462o.dismiss();
            } catch (Exception unused) {
            }
            datePickerDialog = null;
        }
        C0462o c0462o2 = new C0462o();
        c0462o2.f2650a = "date_picker";
        c0462o2.b = map;
        c0462o2.e = Videoio.CAP_PROP_XI_BINNING_PATTERN;
        datePickerDialog = c0462o2;
        c0462o2.f2651f = false;
        E.c(c0462o2);
        MainActivity mainActivity = G.Companion.getMainActivity();
        E.c(mainActivity);
        c0462o2.show(mainActivity.getSupportFragmentManager(), "flutter");
    }

    @Override // p108t.P
    public void selectLogTime(String startTime, String endTime, String callbackId) {
        E.f(startTime, "startTime");
        E.f(endTime, "endTime");
        E.f(callbackId, "callbackId");
        FlutterBoost.instance().currentActivity().runOnUiThread(new a(startTime, 13, endTime, callbackId));
    }

    @Override // p108t.P
    public void selectedLogTime(String startTime, String endTime, String callbackId) {
        E.f(startTime, "startTime");
        E.f(endTime, "endTime");
        E.f(callbackId, "callbackId");
        FlutterBoost.instance().currentActivity().runOnUiThread(new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(8));
        HashMap map = new HashMap();
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        map.put("callbackId", endTime);
        FlutterBoost.instance().sendEventToFlutter(callbackId, map);
    }
}
