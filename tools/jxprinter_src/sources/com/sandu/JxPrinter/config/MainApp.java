package com.sandu.JxPrinter.config;

import F4.e;
import S4.d;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.standard.page.printerlabel.util.FontDataManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.idlefish.flutterboost.FlutterBoost;
import com.library.base.frame.FrameApplication;
import com.library.base.util.http.Http;
import com.orhanobut.hawk.Hawk;
import io.flutter.embedding.engine.FlutterEngine;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.opencv.android.OpenCVLoader;
import p037g0.c;
import p051j0.f;
import p056k0.g;
import p056k0.n;
import p102s.B;
import p102s.C;
import p102s.C1631d;
import p102s.C1633f;
import p102s.D;
import p102s.E;
import p102s.h;
import p102s.k;
import p102s.l;
import p102s.o;
import p102s.r;
import p102s.t;
import p102s.u;
import p102s.v;
import p102s.z;
import p108t.F;
import p108t.I;
import p108t.InterfaceC1778j;
import p108t.InterfaceC1781m;
import p108t.InterfaceC1784p;
import p108t.InterfaceC1786s;
import p108t.InterfaceC1789v;
import p108t.InterfaceC1792y;
import p108t.M;
import p108t.P;
import p108t.S;
import p108t.U;
import p108t.X;
import p134x2.P0;
import p137y.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class MainApp extends FrameApplication {
    protected final String KEY_ROTATE = "rotate";
    protected final String KEY_LOCKLOCATION = "lockLocation";

    private void activateVip() {
        P0 p0H = p051j0.a.h();
        if (p0H == null) {
            return;
        }
        String strG = p051j0.a.g(p0H);
        c cVar = new c(this);
        cVar.b = new b();
        cVar.a(p0H.getDeviceName(), strG, p0H.getFactoryName(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRotateInt(Map<String, Object> map, int i5) {
        Object obj = map.get("rotate");
        if (obj != null) {
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
            try {
                return (int) Float.parseFloat(String.valueOf(obj));
            } catch (Exception unused) {
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStringArg(Map<String, Object> map, String str, String str2) {
        String str3 = (String) map.get(str);
        return (str3 == null || str3.isEmpty()) ? str2 : str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$onCreate$0(FlutterEngine flutterEngine) {
        I.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new v());
        F.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new u());
        S.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new C());
        M.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new z());
        InterfaceC1789v.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new l());
        InterfaceC1792y.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new o());
        InterfaceC1784p.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new h());
        P.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new B());
        InterfaceC1781m.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new C1633f());
        X.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new E());
        U.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new D());
        p108t.B.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new r());
        InterfaceC1778j.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new C1631d());
        InterfaceC1786s.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new k());
        p108t.D.Companion.setUp(flutterEngine.getDartExecutor().getBinaryMessenger(), new t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int parseIntSafely(String str, int i5) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i5;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getSVar()" because "arg" is null
    	at jadx.core.dex.instructions.args.RegisterArg.sameCodeVar(RegisterArg.java:193)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.extractConstNumber(SwitchOverStringVisitor.java:369)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.collectPart1RegionCases(SwitchOverStringVisitor.java:207)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:108)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    @Override // com.library.base.frame.FrameApplication, android.app.Application
    public void onCreate() {
        p042h2.b bVar;
        super.onCreate();
        d.b().j(this);
        FlutterBoost.instance().setup(this, new a(this), new e(20));
        File externalCacheDir = getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = getCacheDir();
        }
        externalCacheDir.getAbsolutePath();
        byte b = 9;
        p051j0.a.f5394a = 9;
        Http.initHttp("https://osapi.eleph-label.com/");
        Http.addHeader("platform", "1");
        Http.addHeader("version", "1.1.8.102");
        Hawk.put("appType", "sanduOverseas");
        Http.addHeader("channel", "1");
        g.setCachePath(externalCacheDir.getAbsolutePath());
        Locale locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        FrameApplication.defaultLang = locale.getLanguage();
        if (locale.getCountry().equals("TW") || locale.getCountry().equals("HK") || locale.getCountry().equals("MO")) {
            FrameApplication.defaultLang = "zh_TW";
        }
        Http.addHeader(FirebaseAnalytics.Param.SOURCE, ExifInterface.GPS_MEASUREMENT_2D);
        String str = (String) Hawk.get("current_language", FrameApplication.defaultLang);
        System.out.println("当前语言类型：" + str);
        str.getClass();
        switch (str.hashCode()) {
            case 3201:
                b = !str.equals("de") ? (byte) -1 : (byte) 0;
                break;
            case 3241:
                b = !str.equals("en") ? (byte) -1 : (byte) 1;
                break;
            case 3246:
                b = !str.equals("es") ? (byte) -1 : (byte) 2;
                break;
            case 3276:
                b = !str.equals("fr") ? (byte) -1 : (byte) 3;
                break;
            case 3371:
                b = !str.equals("it") ? (byte) -1 : (byte) 4;
                break;
            case 3383:
                b = !str.equals("ja") ? (byte) -1 : (byte) 5;
                break;
            case 3428:
                b = !str.equals("ko") ? (byte) -1 : (byte) 6;
                break;
            case 3588:
                b = !str.equals("pt") ? (byte) -1 : (byte) 7;
                break;
            case 3651:
                b = !str.equals("ru") ? (byte) -1 : (byte) 8;
                break;
            case 3710:
                if (!str.equals("tr")) {
                    b = -1;
                }
                break;
            case 3763:
                b = !str.equals("vi") ? (byte) -1 : (byte) 10;
                break;
            case 3886:
                b = !str.equals("zh") ? (byte) -1 : (byte) 11;
                break;
            case 115861812:
                b = !str.equals("zh_TW") ? (byte) -1 : (byte) 12;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                Http.addHeader("lang", "de");
                break;
            case 1:
                Http.addHeader("lang", "en_US");
                break;
            case 2:
                Http.addHeader("lang", "es");
                break;
            case 3:
                Http.addHeader("lang", "fr");
                break;
            case 4:
                Http.addHeader("lang", "it");
                break;
            case 5:
                Http.addHeader("lang", "ja");
                break;
            case 6:
                Http.addHeader("lang", "ko");
                break;
            case 7:
                Http.addHeader("lang", "pt");
                break;
            case 8:
                Http.addHeader("lang", "ru");
                break;
            case 9:
                Http.addHeader("lang", "tr");
                break;
            case 10:
                Http.addHeader("lang", "vi");
                break;
            case 11:
                Http.addHeader("lang", "zh_CN");
                break;
            case 12:
                Http.addHeader("lang", "zh_HK");
                break;
            default:
                Http.addHeader("lang", "en");
                FrameApplication.defaultLang = "en";
                break;
        }
        ARouter.init(this);
        int i5 = p131x.b.f8837a;
        String str2 = (String) Hawk.get("current_language", FrameApplication.defaultLang);
        Locale locale2 = str2.split("_").length > 1 ? new Locale(str2.split("_")[0], str2.split("_")[1]) : new Locale(str2);
        Locale.setDefault(locale2);
        Configuration configuration = getResources().getConfiguration();
        configuration.setLocale(locale2);
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        p042h2.d.b = getApplicationContext();
        Context applicationContext = getApplicationContext();
        p047i2.a.b = applicationContext;
        p047i2.a.f4045a = com.bumptech.glide.c.with(applicationContext);
        FontDataManager.init(this);
        if (OpenCVLoader.initDebug()) {
            p051j0.a.d("StandardApp", "OpenCV库加载成功");
        } else {
            p051j0.a.d("StandardApp", "OpenCV库加载失败");
        }
        f.init(this);
        Context applicationContext2 = getApplicationContext();
        if (!n.b) {
            n.b = true;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) applicationContext2.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                p051j0.a.c("ModelFileDownloadUtil", "Not on WiFi, skip model download");
            } else {
                n.a(applicationContext2, false);
            }
        }
        synchronized (p042h2.b.class) {
            try {
                if (p042h2.b.f4028f == null) {
                    p042h2.b bVar2 = new p042h2.b();
                    bVar2.c = new HashMap();
                    bVar2.d = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                    bVar2.e = p042h2.b.class.getSimpleName();
                    p042h2.b.f4028f = bVar2;
                }
                bVar = p042h2.b.f4028f;
            } catch (Throwable th) {
                throw th;
            }
        }
        bVar.b = this;
        bVar.f4029a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(bVar);
        p035f5.b.b = this;
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onDeviceEvent(i iVar) {
        if (iVar.f9014a == 6 && p042h2.e.f4031a.g()) {
            activateVip();
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
        d.b().m(this);
    }
}
