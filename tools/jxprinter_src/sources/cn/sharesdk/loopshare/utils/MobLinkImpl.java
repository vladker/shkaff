package cn.sharesdk.loopshare.utils;

import A3.AbstractC0157z;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.loopshare.ActionListener;
import cn.sharesdk.loopshare.LoopShareActivity;
import cn.sharesdk.loopshare.RestoreSceneListener;
import cn.sharesdk.loopshare.Scene;
import cn.sharesdk.loopshare.SceneRestorable;
import cn.sharesdk.loopshare.beans.ConfigData;
import cn.sharesdk.loopshare.beans.SceneData;
import cn.sharesdk.loopshare.beans.ServerData;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class MobLinkImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f2307a;
    private HashMap<String, RestoreSceneListener> b;
    private SceneRestorable c;
    private volatile boolean d;
    private volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Integer f2308f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AppListener f2310h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f2312j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b f2313k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AppStatus f2309g = AppStatus.a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<Class<? extends Activity>> f2311i = new ArrayList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private WeakReference<Activity> f2314l = null;

    /* JADX INFO: renamed from: cn.sharesdk.loopshare.utils.MobLinkImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f2315a;
        final /* synthetic */ Intent b;

        public AnonymousClass1(Activity activity, Intent intent) {
            this.f2315a = activity;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            final Handler handler = new Handler(Looper.myLooper()) { // from class: cn.sharesdk.loopshare.utils.MobLinkImpl.1.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    try {
                        if (message.what == 1) {
                            MobLinkImpl.this.f2309g = AppStatus.a();
                            MobLinkImpl.this.f2309g.a(MobLinkImpl.this.f2310h);
                            MobLinkLog.prepare();
                            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "[loopRequestIsAuth(handler)]Privacy agreement confirmed, start to initialize.");
                            ComponentName componentName = new ComponentName(MobSDK.getContext().getPackageName(), LoopShareActivity.class.getName());
                            Intent intent = new Intent();
                            intent.addFlags(268435456);
                            intent.setComponent(componentName);
                            MobSDK.getContext().startActivity(intent);
                        }
                        Looper.myLooper().quit();
                    } catch (Throwable th) {
                        MobLinkLog.getInstance().w(MobLinkLog.FORMAT, th);
                    }
                }
            };
            handler.post(new Runnable() { // from class: cn.sharesdk.loopshare.utils.MobLinkImpl.1.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int iIsAuth = MobSDK.isAuth();
                        if (iIsAuth == 0) {
                            MobLinkImpl.a();
                            if (MobLinkImpl.f2307a == 90) {
                                handler.removeCallbacks(this);
                                return;
                            } else {
                                Log.e("Moblink", "Privacy Agreement is not agree, Please agree to the privacy agreement first ");
                                handler.postDelayed(this, 1000L);
                                return;
                            }
                        }
                        if (iIsAuth != 1 && iIsAuth != 2) {
                            handler.removeCallbacks(this);
                            return;
                        }
                        if (MobSDK.isForb()) {
                            return;
                        }
                        handler.removeCallbacks(this);
                        if (MobLinkImpl.this.f2314l != null) {
                            ((Activity) MobLinkImpl.this.f2314l.get()).runOnUiThread(new Runnable() { // from class: cn.sharesdk.loopshare.utils.MobLinkImpl.1.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (MobLinkImpl.this.f2310h != null) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        MobLinkImpl.this.b(anonymousClass1.f2315a, anonymousClass1.b);
                                    }
                                }
                            });
                            return;
                        }
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 1;
                        handler.sendMessage(messageObtain);
                    } catch (Throwable th) {
                        MobLinkLog.getInstance().w(MobLinkLog.FORMAT, th);
                    }
                }
            });
            Looper.loop();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AppListener extends AppStatus.OnAppStatusListener {
        private AppListener() {
        }

        @Override // cn.sharesdk.loopshare.utils.AppStatus.OnAppStatusListener
        public void onAppStatusChanged(boolean z6) {
            MobLinkImpl.this.a(z6);
        }

        @Override // com.mob.tools.utils.ActivityTracker.Tracker
        public void onCreated(Activity activity, Bundle bundle) {
            Intent intent = activity.getIntent();
            MobLinkImpl.this.a("onCreated", intent, activity);
            int iIsAuth = MobSDK.isAuth();
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, AbstractC0157z.k(iIsAuth, "onCreated is intAuth, "));
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "onCreated is intAuth className, " + activity.getLocalClassName());
            MobLinkImpl.this.f2308f = Integer.valueOf(iIsAuth);
            SSDKLog.b().a("Moblink", AbstractC0157z.k(iIsAuth, "onCreated(intAuth)=="));
            SSDKLog.b().a("Moblink", "onCreated(activity)==" + activity.getLocalClassName());
            SSDKLog.b().a("Moblink", "onCreated(MOBLINK_INTERNAL_INTENT)==" + intent.getBooleanExtra("moblink_internal_intent", false));
            boolean z6 = activity instanceof LoopShareActivity;
            if (!z6 && !intent.getBooleanExtra("moblink_internal_intent", false)) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Not internal intent, ignore!");
                return;
            }
            if (iIsAuth != 1 && iIsAuth != 2) {
                if (z6) {
                    MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Privacy Agreement is not agree, open client launchAc");
                    MobLinkImpl.this.c(activity, intent);
                    return;
                }
                return;
            }
            intent.putExtra("moblink_internal_intent", false);
            if (!z6) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "=====> Start main logic during CREATE.");
            }
            String stringExtra = intent.getStringExtra("_wxobject_message_ext");
            if (c.a(stringExtra)) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, AbstractC0157z.n("wechat mini program url: ", stringExtra));
                intent.setData(Uri.parse(stringExtra));
                MobLinkImpl.this.b(intent, activity);
            }
            if (!c.b(intent)) {
                SSDKLog.b().a("Moblink", "moblink无数据");
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "NO scene, ignore.");
                return;
            }
            SSDKLog.b().a("Moblink", "onCreated moblink有数据");
            SSDKLog.b().a("Moblink", "onCreated moblink有数据(activity)==" + activity.getLocalClassName());
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "HAS scene, process.");
            MobLinkImpl.this.b(intent, activity);
        }

        @Override // cn.sharesdk.loopshare.utils.AppStatus.OnAppStatusListener, com.mob.tools.utils.ActivityTracker.Tracker
        public void onResumed(Activity activity) {
            super.onResumed(activity);
            Intent intent = activity.getIntent();
            MobLinkImpl.this.a("onResumed", intent, activity);
            if (MobLinkImpl.this.f2308f == null) {
                MobLinkImpl.this.f2308f = Integer.valueOf(MobSDK.isAuth());
            }
            if (MobLinkImpl.this.f2308f.intValue() == 0) {
                MobLinkImpl.this.a(activity, intent);
            }
            SSDKLog.b().a("Moblink", "onResumed(intAuth)==" + MobLinkImpl.this.f2308f);
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "onResumed is saveIsAuth," + MobLinkImpl.this.f2308f);
            if (MobLinkImpl.this.f2308f.intValue() != 1 && MobLinkImpl.this.f2308f.intValue() != 2) {
                if (activity instanceof LoopShareActivity) {
                    MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Privacy Agreement is not agree, open client launchAc");
                    MobLinkImpl.this.c(activity, intent);
                    return;
                }
                return;
            }
            SSDKLog.b().a("Moblink", "onResumed（MOBLINK_INTERNAL_INTENT）==" + intent.getBooleanExtra("moblink_internal_intent", false));
            if (intent.getBooleanExtra("moblink_internal_intent", false)) {
                intent.putExtra("moblink_internal_intent", false);
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "=====> Start main logic during RESUME.");
                MobLinkImpl.this.b(intent, activity);
            } else {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "=====> NO main logic during RESUME.");
            }
            if (intent.getBooleanExtra("moblink_skip_server_restore", false)) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restored through scheme, skip server-restoring.");
                intent.putExtra("moblink_skip_server_restore", false);
            } else if (MobLinkImpl.this.c(intent)) {
                SSDKLog.b().a("Moblink", "onresume里面的服务器还原");
                MobLinkImpl.this.c(intent, activity);
            }
        }

        public /* synthetic */ AppListener(MobLinkImpl mobLinkImpl, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class a extends AsyncProtocol.a<ConfigData> {
        private cn.sharesdk.loopshare.utils.b b;

        private a() {
        }

        public /* synthetic */ a(MobLinkImpl mobLinkImpl, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // cn.sharesdk.loopshare.utils.AsyncProtocol.a, cn.sharesdk.loopshare.utils.AsyncProtocol.DataListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveData(ConfigData configData) {
            super.onReceiveData(configData);
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "config onReceiveData：" + configData);
            if (!ServerData.a(configData) || this.b == null) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "config endRestoreScene：" + configData);
                MobLinkImpl.this.d();
            } else {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "config onReceiveData resume");
                MobLinkImpl.this.a(this.b.b(), this.b.a(), this.b.c());
            }
            this.b = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class b extends AsyncProtocol.a<SceneData> {
        private cn.sharesdk.loopshare.utils.b b;
        private int c;

        private b() {
        }

        public /* synthetic */ b(MobLinkImpl mobLinkImpl, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(int i5) {
            this.c = i5;
        }

        @Override // cn.sharesdk.loopshare.utils.AsyncProtocol.a, cn.sharesdk.loopshare.utils.AsyncProtocol.DataListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveData(SceneData sceneData) {
            super.onReceiveData(sceneData);
            SSDKLog.b().a("Moblink", "我是服务还原data[SceneDataListener]==" + new Hashon().fromObject(sceneData));
            if (sceneData == null || !sceneData.a_() || this.b == null) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Server scene data is invalid, terminate!");
                int i5 = this.c;
                if (i5 == 2) {
                    AsyncProtocol.a("", i5, 3);
                } else if (i5 == 3 && sceneData != null && !sceneData.a_()) {
                    AsyncProtocol.a("", this.c, 3);
                }
                MobLinkImpl.this.d();
            } else {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Server scene data is valid, start restoring!");
                SSDKLog.b().a("Moblink", "我是服务还原data[SceneDataListener]==开始还原");
                MobLinkImpl.this.a(this.b.b(), this.b.a(), sceneData.a(), this.c);
            }
            this.b = null;
        }
    }

    public MobLinkImpl() {
        AnonymousClass1 anonymousClass1 = null;
        this.f2310h = new AppListener(this, anonymousClass1);
        this.f2312j = new a(this, anonymousClass1);
        this.f2313k = new b(this, anonymousClass1);
        if (MobSDK.isForb()) {
            a((Activity) null, (Intent) null);
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "[MobLinkImpl]Enter the countdown for the first time, wait for the privacy agreement, and then initialize.");
        } else {
            MobLinkLog.prepare();
            this.f2309g.a(this.f2310h);
        }
    }

    public static /* synthetic */ int a() {
        int i5 = f2307a;
        f2307a = i5 + 1;
        return i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f(Intent intent, Activity activity) {
        SceneData.Res resA = d.a(intent);
        if (resA == null) {
            MobLinkLog.getInstance().w(MobLinkLog.FORMAT, "CAUTION: Target activity started, but no Scene!");
        } else if (activity instanceof SceneRestorable) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Current activity is SceneRestorable, return scene data to it");
            ((SceneRestorable) activity).onReturnSceneData(resA);
        } else {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Current activity is NOT SceneRestorable, use activity delegate instead");
            SceneRestorable sceneRestorable = this.c;
            if (sceneRestorable != null) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Return scene data to activity delegate");
                sceneRestorable.onReturnSceneData(resA);
            } else {
                MobLinkLog.getInstance().w(MobLinkLog.FORMAT, "CAUTION: No delegate found, scene data can not be returned!");
            }
        }
        a(false);
        d();
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Upload log");
        String strC = c.c(intent.getData());
        String link = resA != null ? resA.getLink() : null;
        if (!TextUtils.isEmpty(strC) && !TextUtils.isEmpty(link)) {
            h.a(strC);
        }
        if (intent.getBooleanExtra("moblink_intent_from_server", false)) {
            return;
        }
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Destroy scene data on server. END flow!");
        AsyncProtocol.b();
    }

    private void g(Intent intent, Activity activity) {
        b(intent, activity);
    }

    private boolean d(Intent intent) {
        ComponentName component;
        boolean z6;
        synchronized (this.f2311i) {
            if (intent != null) {
                try {
                    component = intent.getComponent();
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                component = null;
            }
            String className = component != null ? component.getClassName() : null;
            ArrayList<Class<? extends Activity>> arrayList = this.f2311i;
            int size = arrayList.size();
            boolean zEquals = false;
            int i5 = 0;
            while (i5 < size) {
                Class<? extends Activity> cls = arrayList.get(i5);
                i5++;
                zEquals = cls.getName().equals(className);
                if (zEquals) {
                    break;
                }
            }
            z6 = !zEquals;
        }
        return z6;
    }

    private String e() {
        return "ssdk" + MobSDK.getAppkey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent, Activity activity) {
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "CAUTION: Restore through server!");
        this.e = true;
        a(intent, activity, true);
    }

    private void e(Intent intent, Activity activity) {
        SSDKLog.b().a("Moblink", "jumpToTargetActivity");
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Preparing to jump to target activity");
        int intExtra = intent.getIntExtra("moblink_log_scene_source", 1);
        SceneData.Res resA = d.a(intent);
        if (resA != null) {
            MobLinkLog.getInstance().w(MobLinkLog.FORMAT, "scene:" + resA.getPath() + " params:" + resA.getParams());
        } else {
            MobLinkLog.getInstance().w(MobLinkLog.FORMAT, "scene is null");
        }
        String strC = c.c(intent);
        MobLinkLog.getInstance().w(MobLinkLog.FORMAT, AbstractC0157z.n("jumpToTargetActivity scheme is ,", strC));
        Class clsA = a(strC, resA);
        if (clsA != null) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restoring completed. Clazz from app: ".concat(clsA.getName()));
            a(activity, clsA, intent);
            c(strC, resA);
            AsyncProtocol.a("", intExtra, 1);
            return;
        }
        Class clsA2 = a(resA, intExtra);
        if (clsA2 != null) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restoring completed. No Clazz from app, so obtain from MOB console: ".concat(clsA2.getName()));
            a(activity, clsA2, intent);
            c(strC, resA);
            AsyncProtocol.a("", intExtra, 1);
            return;
        }
        if (resA != null) {
            a(activity);
            b(strC, resA);
            if (clsA2 == null) {
                AsyncProtocol.a("", intExtra, 5);
                return;
            } else {
                AsyncProtocol.a("", intExtra, 6);
                return;
            }
        }
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restoring failed. Clazz can NOT be obtained through either app nor console");
        b(strC, resA);
        AsyncProtocol.a("", intExtra, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Intent intent, Activity activity) {
        this.e = true;
        a(intent, activity, false);
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restore through scheme, mark intent to skip server-restoring.");
        intent.putExtra("moblink_skip_server_restore", true);
    }

    private boolean c() {
        return ServerData.a(AsyncProtocol.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Intent intent) {
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "enableServerRestore: " + this.d);
        return this.d && d(intent);
    }

    private boolean b(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null || !c.d(data)) {
            return false;
        }
        String host = data.getHost();
        ConfigData configDataA = AsyncProtocol.a();
        return host != null && host.equals(configDataA != null ? configDataA.e() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.e = false;
    }

    private void d(Intent intent, Activity activity) {
        if (activity instanceof LoopShareActivity) {
            e(intent, activity);
        } else {
            f(intent, activity);
        }
    }

    public void c(String str, Scene scene) {
        RestoreSceneListener restoreSceneListenerA = a(str);
        if (restoreSceneListenerA != null) {
            restoreSceneListenerA.completeRestore(scene);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity, Intent intent) {
        SSDKLog.b().a("Moblink", "activityName(startAppLaunchActivity)==" + activity.getLocalClassName());
        String strA = a((Context) activity);
        String packageName = DH.SyncMtd.getPackageName();
        Intent intent2 = new Intent();
        intent2.setData(intent.getData());
        intent2.setClassName(packageName, strA);
        intent2.putExtra("moblink_internal_intent", false);
        intent2.putExtra("moblink_start_launcher", true);
        activity.startActivity(intent2);
    }

    public void a(RestoreSceneListener restoreSceneListener) {
        if (this.b == null) {
            this.b = new HashMap<>();
        }
        this.b.put("key_moblink_default_restore_scene_listener", restoreSceneListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, Intent intent) {
        Intent intent2 = new Intent(activity, (Class<?>) LoopShareActivity.class);
        intent.addFlags(268435456);
        intent2.setData(intent.getData());
        activity.startActivity(intent2);
    }

    public void a(String str, RestoreSceneListener restoreSceneListener) {
        if (this.b == null) {
            this.b = new HashMap<>();
        }
        if ("sdfwe435fdsr34656uthfwer32ufeh439==".equals(str)) {
            str = e();
        }
        this.b.put(str, restoreSceneListener);
    }

    public void b(String str, Scene scene) {
        RestoreSceneListener restoreSceneListenerA = a(str);
        if (restoreSceneListenerA != null) {
            restoreSceneListenerA.notFoundScene(scene);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, SceneRestorable sceneRestorable) {
        SceneRestorable sceneRestorable2 = this.c;
        this.c = sceneRestorable;
        Intent intent = activity != null ? activity.getIntent() : null;
        if (!this.e && sceneRestorable2 == null && c.b(intent)) {
            g(intent, activity);
        }
    }

    public void a(Scene scene, ActionListener<String> actionListener) {
        if (MobSDK.isForb()) {
            return;
        }
        cn.sharesdk.loopshare.utils.a.a(scene, actionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, Activity activity, boolean z6) {
        if (!c()) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "NO valid config, obtain config from server first");
            if (!this.f2312j.b()) {
                MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "config is requsting");
                this.f2312j.a();
                this.f2312j.b = new cn.sharesdk.loopshare.utils.b(activity, intent, z6);
                cn.sharesdk.loopshare.utils.a.a(this.f2312j);
                return;
            }
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "config is requsting,so skip it");
            return;
        }
        if (!z6 && b(intent)) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restore Model: App Link");
            String strA = c.a(intent);
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, AbstractC0157z.n("linkId: ", strA));
            if (TextUtils.isEmpty(strA)) {
                d();
                return;
            }
            if (this.f2313k.b()) {
                return;
            }
            this.f2313k.a(2);
            this.f2313k.a();
            this.f2313k.b = new cn.sharesdk.loopshare.utils.b(activity, intent, z6);
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Obtain scene from server through 'ul'");
            cn.sharesdk.loopshare.utils.a.a(strA, this.f2313k);
            return;
        }
        if (!z6 && a(intent)) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restore Model: Scheme");
            intent.putExtra("moblink_log_scene_source", 1);
            d(intent, activity);
            return;
        }
        if (z6 && c(intent)) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Restore Model: YYB or First run");
            boolean zB = AppStatus.a().b();
            ConfigData configDataA = AsyncProtocol.a();
            boolean zA = configDataA != null ? configDataA.a() : true;
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "isAppFirstRun: " + zB + ", isOpenYyb: " + zA);
            if (!zB && !zA) {
                d();
                return;
            }
            this.f2313k.a(3);
            this.f2313k.b = new cn.sharesdk.loopshare.utils.b(activity, intent, z6);
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Obtain scene from server through 'reco'");
            cn.sharesdk.loopshare.utils.a.a(this.f2309g.c(), this.f2313k);
            return;
        }
        d();
    }

    private boolean a(Intent intent) {
        boolean zA;
        Uri data;
        if (intent == null || intent.getData() == null || (data = intent.getData()) == null || !c.e(data)) {
            zA = false;
        } else {
            String str = data.getScheme() + "://" + data.getHost();
            ConfigData configDataA = AsyncProtocol.a();
            zA = g.a(str, configDataA != null ? configDataA.d() : null);
        }
        if (!zA) {
            AsyncProtocol.a("", 1, 3);
        }
        return zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Intent intent, Activity activity) {
        if (intent == null && activity != null) {
            intent = activity.getIntent();
        }
        Uri data = intent != null ? intent.getData() : null;
        Bundle extras = intent != null ? intent.getExtras() : null;
        Boolean boolValueOf = extras != null ? Boolean.valueOf(extras.getBoolean("moblink_internal_intent")) : null;
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "(logIntent, method is)" + str + "(), activity:" + activity + "\nextras: " + extras + "\nmoblink_internal_intent: " + boolValueOf + "\nuri: " + data + "\nintent:" + intent);
    }

    public void a(Class<? extends Activity>... clsArr) {
        if (MobSDK.isForb()) {
            return;
        }
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "CAUTION: 'Skip restore from wx' feature is activated!");
        synchronized (this.f2311i) {
            this.f2311i.clear();
            Collections.addAll(this.f2311i, clsArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z6) {
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "setEnableServerRestore: " + z6);
        this.d = z6;
    }

    public void a(Intent intent, Activity activity) {
        if (MobSDK.isForb()) {
            return;
        }
        a("onNewIntent", intent, activity);
        if (intent == null || !intent.getBooleanExtra("moblink_internal_intent", false)) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "No main logic during NEWINTENT.");
            return;
        }
        intent.putExtra("moblink_internal_intent", false);
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "=====> Start main logic during NEWINTENT.");
        b(intent, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, Intent intent) {
        if (activity != null) {
            this.f2314l = new WeakReference<>(activity);
        }
        new Thread(new AnonymousClass1(activity, intent)).start();
    }

    private Class a(SceneData.Res res, int i5) {
        String action = res != null ? res.getAction() : null;
        if (action == null) {
            AsyncProtocol.a("", i5, 4);
            return null;
        }
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Find controller from SceneData.Res.action. action: ".concat(action));
        try {
            return ReflectHelper.getClass(action);
        } catch (Throwable th) {
            MobLinkLog.getInstance().w(th, MobLinkLog.FORMAT, "CAUTION: Specified class can NOT be found, restoring may terminated!");
            return null;
        }
    }

    public Class a(String str, Scene scene) {
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, AbstractC0157z.n("onWillRestoreScene scheme is, ", str));
        RestoreSceneListener restoreSceneListenerA = a(str);
        if (restoreSceneListenerA != null) {
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, "Global RestoreSceneListener is implemented!");
            return restoreSceneListenerA.willRestoreScene(scene);
        }
        MobLinkLog.getInstance().w(MobLinkLog.FORMAT, "CAUTION: Global RestoreSceneListener is NOT implemented!");
        return null;
    }

    private RestoreSceneListener a(String str) {
        HashMap<String, RestoreSceneListener> map = this.b;
        if (map == null || map.isEmpty()) {
            return null;
        }
        RestoreSceneListener restoreSceneListener = this.b.get("key_moblink_default_restore_scene_listener");
        if (!"key_moblink_default_restore_scene_listener".equals(str) && this.b.containsKey(str)) {
            RestoreSceneListener restoreSceneListener2 = this.b.get(str);
            MobLinkLog.getInstance().d(MobLinkLog.FORMAT, AbstractC0157z.n("Use customized RestoreSceneListener. scheme: ", str));
            return restoreSceneListener2;
        }
        MobLinkLog.getInstance().d(MobLinkLog.FORMAT, AbstractC0157z.n("Use default RestoreSceneListener. scheme: ", str));
        return restoreSceneListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, Activity activity, SceneData.Res res, int i5) {
        Uri uriA = a(res);
        Intent intent2 = new Intent();
        intent2.setData(uriA);
        intent2.putExtra("moblink_intent_from_server", true);
        intent2.putExtra("moblink_log_scene_source", i5);
        SSDKLog.b().a("Moblink", "服务器还原(doRestoreFromServerScene)==" + activity.getLocalClassName());
        e(intent2, activity);
    }

    private void a(Activity activity, Class cls, Intent intent) {
        Intent intent2 = new Intent();
        intent2.setClass(activity, cls);
        intent2.setData(intent.getData());
        intent2.addFlags(536870912);
        intent2.putExtra("moblink_internal_intent", true);
        activity.startActivity(intent2);
    }

    private Uri a(SceneData.Res res) {
        String strA = d.a(res);
        ConfigData configDataA = AsyncProtocol.a();
        String strD = configDataA != null ? configDataA.d() : null;
        if (TextUtils.isEmpty(strD) || TextUtils.isEmpty(strA)) {
            return null;
        }
        StringBuilder sbX = AbstractC0157z.x(strD, "?params=");
        sbX.append(URLEncoder.encode(strA));
        return Uri.parse(sbX.toString());
    }

    public void a(final Activity activity, final SceneRestorable sceneRestorable) {
        if (MobSDK.isForb()) {
            return;
        }
        MobLinkLog.getInstance().w(MobLinkLog.FORMAT, "CAUTION: Activity delegate set, this operation is NOT recommended except Cocos2d or Unity3d!");
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: cn.sharesdk.loopshare.utils.MobLinkImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    MobLinkImpl.this.b(activity, sceneRestorable);
                }
            });
        }
    }

    private String a(Context context) {
        String packageName = DH.SyncMtd.getPackageName();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageName);
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveInfoResolveActivity != null) {
            return resolveInfoResolveActivity.activityInfo.name;
        }
        return null;
    }

    private void a(Activity activity) {
        String strA = a((Context) activity);
        String packageName = DH.SyncMtd.getPackageName();
        Intent intent = new Intent();
        intent.setClassName(packageName, strA);
        intent.putExtra("moblink_internal_intent", false);
        intent.setFlags(268435456);
        activity.startActivity(intent);
    }
}
