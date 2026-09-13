package p102s;

import A2.b;
import A3.k0;
import O3.l;
import X3.b0;
import android.app.Activity;
import android.content.Intent;
import androidx.activity.result.a;
import androidx.fragment.app.FragmentActivity;
import com.appdev.standard.dialog.C0462o;
import com.appdev.standard.dialog.C0463p;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.page.BootActivity;
import com.appdev.standard.page.LocalFlutterBoostActivity;
import com.appdev.standard.page.MainActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.idlefish.flutterboost.FlutterBoost;
import com.library.base.frame.FrameApplication;
import com.orhanobut.hawk.Hawk;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.E;
import p108t.InterfaceC1784p;
import p147z3.A;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements InterfaceC1784p {
    @Override // p108t.InterfaceC1784p
    public Object get(String key, Object defaultValue) {
        E.f(key, "key");
        E.f(defaultValue, "defaultValue");
        Object obj = Hawk.get(key, defaultValue);
        E.e(obj, "get(...)");
        return obj;
    }

    @Override // p108t.InterfaceC1784p
    public String getCachePath() {
        F f6 = G.Companion;
        MainActivity mainActivity = f6.getMainActivity();
        E.c(mainActivity);
        if (mainActivity.getExternalCacheDir() != null) {
            MainActivity mainActivity2 = f6.getMainActivity();
            E.c(mainActivity2);
            return String.valueOf(mainActivity2.getExternalCacheDir());
        }
        MainActivity mainActivity3 = f6.getMainActivity();
        E.c(mainActivity3);
        String string = mainActivity3.getCacheDir().toString();
        E.e(string, "toString(...)");
        return string;
    }

    @Override // p108t.InterfaceC1784p
    public String getLanguage() {
        String str = (String) Hawk.get("current_language", FrameApplication.defaultLang);
        E.c(str);
        return str;
    }

    @Override // p108t.InterfaceC1784p
    public String getLanguageMode() {
        Object obj = Hawk.get("current_language", "system");
        E.e(obj, "get(...)");
        return (String) obj;
    }

    @Override // p108t.InterfaceC1784p
    public String getSystemLanguage() {
        String defaultLang = FrameApplication.defaultLang;
        E.e(defaultLang, "defaultLang");
        return defaultLang;
    }

    @Override // p108t.InterfaceC1784p
    public void getWifiSsid(l callback) {
        E.f(callback, "callback");
        Activity activityCurrentActivity = FlutterBoost.instance().currentActivity();
        E.e(activityCurrentActivity, "currentActivity(...)");
        callback.invoke(u.a(u.m1361constructorimpl(new b(activityCurrentActivity).getSSID())));
    }

    @Override // p108t.InterfaceC1784p
    public void needBlueToothPermission(String prompt, l callback) {
        E.f(prompt, "prompt");
        E.f(callback, "callback");
        Activity activityCurrentActivity = FlutterBoost.instance().currentActivity();
        if (activityCurrentActivity instanceof LocalFlutterBoostActivity) {
            ((LocalFlutterBoostActivity) activityCurrentActivity).needBlueToothPermission(new PermissionTipDialog(activityCurrentActivity, prompt), new C1634g(0, callback));
        }
    }

    @Override // p108t.InterfaceC1784p
    public void needCameraPermission(String prompt, l callback) {
        E.f(prompt, "prompt");
        E.f(callback, "callback");
        Activity activityCurrentActivity = FlutterBoost.instance().currentActivity();
        if (activityCurrentActivity instanceof LocalFlutterBoostActivity) {
            ((LocalFlutterBoostActivity) activityCurrentActivity).needCameraPermission(new PermissionTipDialog(activityCurrentActivity, prompt), new C1634g(1, callback));
        }
    }

    @Override // p108t.InterfaceC1784p
    public void needPermission(List<String> permissions, String prompt, l callback) {
        E.f(permissions, "permissions");
        E.f(prompt, "prompt");
        E.f(callback, "callback");
        Activity activityCurrentActivity = FlutterBoost.instance().currentActivity();
        if (activityCurrentActivity instanceof LocalFlutterBoostActivity) {
            ((LocalFlutterBoostActivity) activityCurrentActivity).checkAndRequestPermissions((String[]) permissions.toArray(new String[0]), new PermissionTipDialog(activityCurrentActivity, prompt), new C1634g(2, callback));
        }
    }

    @Override // p108t.InterfaceC1784p
    public void needStoragePermission(String prompt, l callback) {
        E.f(prompt, "prompt");
        E.f(callback, "callback");
        callback.invoke(u.a(u.m1361constructorimpl(Boolean.TRUE)));
    }

    @Override // p108t.InterfaceC1784p
    public void selectImage(l callback) {
        E.f(callback, "callback");
        Activity activityCurrentActivity = FlutterBoost.instance().currentActivity();
        if (activityCurrentActivity instanceof LocalFlutterBoostActivity) {
            ((LocalFlutterBoostActivity) activityCurrentActivity).getMediaPicker().pick(new S4.h(callback, 15));
        }
    }

    @Override // p108t.InterfaceC1784p
    public void set(String key, Object value) {
        E.f(key, "key");
        E.f(value, "value");
        Hawk.put(key, value);
    }

    @Override // p108t.InterfaceC1784p
    public void setLanguage(String language) {
        String lowerCase;
        E.f(language, "language");
        if (language.equals("system")) {
            Hawk.delete("current_language");
        } else {
            if (b0.contains((CharSequence) language, (CharSequence) "_", false)) {
                List<String> listSplit = b0.split((CharSequence) language, new String[]{"_"}, false, 0);
                String lowerCase2 = listSplit.get(0).toLowerCase(Locale.ROOT);
                E.e(lowerCase2, "toLowerCase(...)");
                lowerCase = lowerCase2 + "_" + ((Object) listSplit.get(1));
            } else {
                lowerCase = language.toLowerCase(Locale.ROOT);
                E.e(lowerCase, "toLowerCase(...)");
            }
            Hawk.put("current_language", lowerCase);
        }
        V1.b.h().getClass();
        V1.b.f();
        MainActivity mainActivity = G.Companion.getMainActivity();
        E.c(mainActivity);
        FlutterBoost.instance().currentActivity().startActivity(new Intent(mainActivity, (Class<?>) BootActivity.class));
    }

    @Override // p108t.InterfaceC1784p
    public void showBottomDialog(String dialogUrl, long j6, Map<String, ? extends Object> map, l callback) {
        E.f(dialogUrl, "dialogUrl");
        E.f(callback, "callback");
        Activity activityCurrentActivity = FlutterBoost.instance().currentActivity();
        if (activityCurrentActivity instanceof FragmentActivity) {
            C0462o c0462o = new C0462o(dialogUrl, (int) j6, map, new a(3, callback));
            c0462o.f2651f = false;
            c0462o.show(((FragmentActivity) activityCurrentActivity).getSupportFragmentManager(), "flutter");
        }
    }

    @Override // p108t.InterfaceC1784p
    public void showDialog(String dialogUrl, Map<String, ? extends Object> map, l callback) {
        E.f(dialogUrl, "dialogUrl");
        E.f(callback, "callback");
        Activity activityCurrentActivity = FlutterBoost.instance().currentActivity();
        if (activityCurrentActivity instanceof FragmentActivity) {
            new C0463p(dialogUrl, map, new a(4, callback)).show(((FragmentActivity) activityCurrentActivity).getSupportFragmentManager(), "flutter");
        }
    }

    @Override // p108t.InterfaceC1784p
    public void showPromptDialog(String title, String content, l callback) {
        E.f(title, "title");
        E.f(content, "content");
        E.f(callback, "callback");
        Activity activityCurrentActivity = FlutterBoost.instance().currentActivity();
        if (activityCurrentActivity instanceof FragmentActivity) {
            new C0463p("prompt_dialog", k0.mapOf(A.to("title", title), A.to(FirebaseAnalytics.Param.CONTENT, content)), new a(2, callback)).show(((FragmentActivity) activityCurrentActivity).getSupportFragmentManager(), "flutter");
        }
    }
}
