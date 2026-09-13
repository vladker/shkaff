package cn.sharesdk.framework.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.e;
import cn.sharesdk.framework.a.b.g;
import cn.sharesdk.framework.a.b.j;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.f;
import com.mob.MobSDK;
import com.mob.commons.CSCenter;
import com.mob.commons.SHARESDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.FileLocker;
import java.io.File;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class d extends f {
    private static d b;
    private Handler d;
    private boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f2163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private File f2164g;
    private a c = a.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FileLocker f2165h = new FileLocker();

    private d() {
        File file = new File(MobSDK.getContext().getFilesDir(), ".statistics");
        this.f2164g = file;
        if (file.exists()) {
            return;
        }
        try {
            this.f2164g.createNewFile();
        } catch (Exception e) {
            SSDKLog.b().a(e);
        }
    }

    public static synchronized d a() {
        try {
            if (b == null) {
                b = new d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public void b(e eVar) {
        try {
            if (MobSDK.isMob() && this.e) {
                a(eVar, new ShareSDKCallback<e>() { // from class: cn.sharesdk.framework.a.d.4
                    @Override // cn.sharesdk.framework.ShareSDKCallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onCallback(e eVar2) {
                        if (!eVar2.g()) {
                            SSDKLog.b().a("Drop event: " + eVar2.toString(), new Object[0]);
                            return;
                        }
                        Message message = new Message();
                        message.what = 3;
                        message.obj = eVar2;
                        try {
                            ((f) d.this).f2230a.sendMessage(message);
                        } catch (Throwable th) {
                            SSDKLog.b().a(th);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            SSDKLog.b().a(androidx.exifinterface.media.a.n("logStart ", th), new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.utils.f
    public void c(Message message) {
        if (this.e) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f2163f;
            g gVar = new g();
            gVar.f2148a = jCurrentTimeMillis;
            a(gVar);
            this.e = false;
            try {
                this.d.sendEmptyMessage(1);
            } catch (Throwable th) {
                SSDKLog.b().a(th);
            }
            b = null;
            this.f2230a.getLooper().quit();
        }
    }

    public void a(Handler handler) {
        this.d = handler;
    }

    @Override // cn.sharesdk.framework.utils.f
    public void a(Message message) {
        if (this.e) {
            return;
        }
        this.e = true;
        try {
            this.f2165h.setLockFile(this.f2164g.getAbsolutePath());
            if (this.f2165h.lock(false)) {
                new Thread(new Runnable() { // from class: cn.sharesdk.framework.a.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.c.a(DeviceAuthorizer.authorize(new SHARESDK()));
                        } catch (Exception e) {
                            SSDKLog.b().a(e);
                        }
                    }
                }).start();
                this.c.a(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.framework.a.d.2
                    @Override // cn.sharesdk.framework.ShareSDKCallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onCallback(Boolean bool) {
                        if (bool == null || !bool.booleanValue()) {
                            return;
                        }
                        d.this.c.a(((f) d.this).f2230a);
                    }
                });
            }
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
    }

    private void c(e eVar) {
        try {
            try {
                boolean zB = b();
                if ((eVar instanceof j) || (eVar instanceof cn.sharesdk.framework.a.b.d)) {
                    if (!zB) {
                        SSDKLog.b().b("SH AU LOG FALSE");
                        return;
                    }
                }
            } catch (Throwable th) {
                SSDKLog.b().a(th);
            }
            this.c.a(eVar);
            eVar.h();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            SSDKLog.b().a(eVar.toString(), new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.utils.f
    public void b(Message message) {
        int i5 = message.what;
        if (i5 == 2) {
            try {
                DH.requester(MobSDK.getContext()).getNetworkType().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.a.d.6
                    @Override // com.mob.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        String networkType = dHResponse.getNetworkType();
                        if ("none".equals(networkType) || TextUtils.isEmpty(networkType)) {
                            return;
                        }
                        d.this.c.b();
                    }
                });
                return;
            } catch (Throwable th) {
                SSDKLog.b().a(th);
                return;
            }
        }
        if (i5 == 3) {
            Object obj = message.obj;
            if (obj != null) {
                c((e) obj);
                this.f2230a.removeMessages(2);
                this.f2230a.sendEmptyMessageDelayed(2, 2000L);
                return;
            }
            return;
        }
        if (i5 != 4) {
            return;
        }
        long jLongValue = cn.sharesdk.framework.a.a.e.a().h().longValue();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jLongValue);
        int i6 = calendar.get(1);
        int i7 = calendar.get(2);
        int i8 = calendar.get(5);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i9 = calendar.get(1);
        int i10 = calendar.get(2);
        int i11 = calendar.get(5);
        if (i6 == i9 && i7 == i10 && i8 == i11) {
            return;
        }
        this.c.a(this.f2230a);
    }

    public void a(final e eVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() { // from class: cn.sharesdk.framework.a.d.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    d.this.b(eVar);
                }
            }.start();
        } else {
            b(eVar);
        }
    }

    private void a(final e eVar, final ShareSDKCallback<e> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getDeviceData().getDetailNetworkTypeForStatic().request(new DH.DHResponder() { // from class: cn.sharesdk.framework.a.d.5
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    eVar.f2137f = DeviceAuthorizer.authorize(new SHARESDK());
                    eVar.f2138g = DH.SyncMtd.getPackageName();
                    eVar.f2139h = DH.SyncMtd.getAppVersion();
                    eVar.f2140i = String.valueOf(ShareSDK.SDK_VERSION_CODE);
                    eVar.f2141j = DH.SyncMtd.getPlatformCode();
                    eVar.f2142k = dHResponse.getDetailNetworkTypeForStatic();
                    if (TextUtils.isEmpty(MobSDK.getAppkey())) {
                        SSDKLog.b().b("ShareSDKCore", "Your appKey of ShareSDK is null , this will cause its data won't be count!");
                    } else if (!"cn.sharesdk.demo".equals(eVar.f2138g) && ("api20".equals(MobSDK.getAppkey()) || "androidv1101".equals(MobSDK.getAppkey()))) {
                        SSDKLog.b().b("ShareSDKCore", "Your app is using the appkey of ShareSDK Demo, this will cause its data won't be count!");
                    }
                    eVar.f2143l = dHResponse.getDeviceData();
                    shareSDKCallback.onCallback(eVar);
                } catch (Throwable th) {
                    SSDKLog.b().a(th);
                }
            }
        });
    }

    private boolean b() {
        try {
            boolean zIsSocietyPlatformDataEnable = CSCenter.getInstance().isSocietyPlatformDataEnable();
            SSDKLog.b().a("platformDataEnable:" + zIsSocietyPlatformDataEnable, new Object[0]);
            return zIsSocietyPlatformDataEnable;
        } catch (Throwable th) {
            SSDKLog.b().a(th);
            return true;
        }
    }
}
