package p125w;

import A3.AbstractC0157z;
import U4.h;
import V4.e;
import V4.f;
import V4.g;
import W2.c;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.common.net.HttpHeaders;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractC1127c;
import okhttp3.B;
import okhttp3.G;
import okhttp3.H;
import okhttp3.K;
import okhttp3.L;
import okhttp3.Q;
import okhttp3.T;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.i;
import org.jsoup.nodes.m;
import p036g.a;
import p107s4.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f8800a = new Handler(Looper.getMainLooper());
    public static final a b;

    static {
        a aVar = new a();
        aVar.put("google", "com.android.vending");
        aVar.put("huawei", "com.huawei.appmarket");
        aVar.put("xiaomi", "com.xiaomi.market");
        aVar.put("vivo", "com.vivo.appstore");
        aVar.put("meizu", "com.meizu.mstore");
        aVar.put("tencent", "com.tencent.android.qqdownloader");
        b = aVar;
    }

    public static void a(final Context context, String str, final d dVar) {
        String lowerCase = str.toLowerCase();
        lowerCase.getClass();
        final int i5 = 4;
        final int i6 = 3;
        final int i7 = 2;
        final int i8 = 1;
        final int i9 = 0;
        switch (lowerCase) {
            case "tencent":
                new Thread(new Runnable() { // from class: w.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        m mVarNextElementSibling;
                        switch (i5) {
                            case 0:
                                Context context2 = context;
                                Handler handler = f.f8800a;
                                try {
                                    g gVarA = h.a("https://app.meizu.com/apps/public/detail?package_name=" + context2.getPackageName());
                                    gVarA.c();
                                    i iVar = gVarA.get();
                                    m mVarFirst = iVar.Q("li span.app_title:containsOwn(版      本：) ~ div.app_content").first();
                                    final d dVar2 = dVar;
                                    if (mVarFirst != null) {
                                        final String strTrim = mVarFirst.S().trim();
                                        final String strG = f.g(context2);
                                        if (f.b(strG, strTrim) < 0) {
                                            final int i10 = 5;
                                            handler.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i10) {
                                                        case 0:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 1:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 2:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 3:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 4:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 5:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        default:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar2);
                                            handler.post(new c(dVar2, 19));
                                        }
                                    } else {
                                        m mVarFirst2 = iVar.Q("li:has(span.app_title:containsOwn(版      本：)) div.app_content").first();
                                        if (mVarFirst2 != null) {
                                            final String strTrim2 = mVarFirst2.S().trim();
                                            final String strG2 = f.g(context2);
                                            if (f.b(strG2, strTrim2) < 0) {
                                                final int i11 = 6;
                                                handler.post(new Runnable() { // from class: w.b
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        switch (i11) {
                                                            case 0:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 1:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 2:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 3:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 4:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 5:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            default:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                        }
                                                    }
                                                });
                                            } else {
                                                Objects.requireNonNull(dVar2);
                                                handler.post(new c(dVar2, 19));
                                            }
                                        } else {
                                            p051j0.a.d("AppUpdateChecker", "无法找到魅族商店版本号信息");
                                        }
                                    }
                                } catch (Exception e) {
                                    p051j0.a.e("AppUpdateChecker", "魅族商店检测失败", e);
                                    return;
                                }
                                break;
                            case 1:
                                Context context3 = context;
                                Handler handler2 = f.f8800a;
                                try {
                                    g gVarA2 = h.a("https://app.mi.com/details?id=" + context3.getPackageName());
                                    gVarA2.c();
                                    i iVar2 = gVarA2.get();
                                    m mVarFirst3 = iVar2.Q("div:containsOwn(版本号)").first();
                                    final d dVar3 = dVar;
                                    if (mVarFirst3 == null || (mVarNextElementSibling = mVarFirst3.nextElementSibling()) == null) {
                                        m mVarFirst4 = iVar2.Q("div:containsOwn(版本号) + div").first();
                                        if (mVarFirst4 != null) {
                                            final String strTrim3 = mVarFirst4.S().trim();
                                            final String strG3 = f.g(context3);
                                            if (f.b(strG3, strTrim3) < 0) {
                                                final int i12 = 1;
                                                handler2.post(new Runnable() { // from class: w.b
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        switch (i12) {
                                                            case 0:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 1:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 2:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 3:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 4:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 5:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            default:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                        }
                                                    }
                                                });
                                            } else {
                                                Objects.requireNonNull(dVar3);
                                                handler2.post(new c(dVar3, 19));
                                            }
                                        } else {
                                            p051j0.a.d("AppUpdateChecker", "无法找到小米商店版本号信息");
                                        }
                                    } else {
                                        final String strTrim4 = mVarNextElementSibling.S().trim();
                                        final String strG4 = f.g(context3);
                                        if (f.b(strG4, strTrim4) < 0) {
                                            final int i13 = 0;
                                            handler2.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i13) {
                                                        case 0:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 1:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 2:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 3:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 4:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 5:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        default:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar3);
                                            handler2.post(new c(dVar3, 19));
                                        }
                                    }
                                } catch (Exception e6) {
                                    p051j0.a.e("AppUpdateChecker", "小米商店检测失败", e6);
                                    return;
                                }
                                break;
                            case 2:
                                Context context4 = context;
                                Handler handler3 = f.f8800a;
                                try {
                                    String strReplace = UUID.randomUUID().toString().replace(ProcessIdUtil.DEFAULT_PROCESSID, "");
                                    String strF = f.f(strReplace);
                                    if (strF == null || strF.isEmpty()) {
                                        p051j0.a.d("AppUpdateChecker", "获取interface-code失败");
                                    } else {
                                        String strD = f.d(strReplace, strF);
                                        if (strD == null) {
                                            p051j0.a.d("AppUpdateChecker", "获取应用信息失败");
                                        } else {
                                            final String strC = f.c(strD);
                                            if (strC == null) {
                                                p051j0.a.d("AppUpdateChecker", "解析versionName失败，原始响应: ".concat(strD));
                                            } else {
                                                final String strG5 = f.g(context4);
                                                int iB = f.b(strG5, strC);
                                                final d dVar4 = dVar;
                                                if (iB < 0) {
                                                    final int i14 = 3;
                                                    handler3.post(new Runnable() { // from class: w.b
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            switch (i14) {
                                                                case 0:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 1:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 2:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 3:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 4:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 5:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                default:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                            }
                                                        }
                                                    });
                                                } else {
                                                    Objects.requireNonNull(dVar4);
                                                    handler3.post(new c(dVar4, 19));
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e7) {
                                    p051j0.a.e("AppUpdateChecker", "华为商店检测失败", e7);
                                    return;
                                }
                                break;
                            case 3:
                                Context context5 = context;
                                Handler handler4 = f.f8800a;
                                try {
                                    g gVarA3 = h.a("https://h5-api.appstore.vivo.com.cn/detail/3667544?frompage=messageh5&imei=1234567890&av=18&app_version=2100&pictype=webp&h5_websource=h5appstore");
                                    e eVar = gVarA3.f783a;
                                    eVar.f772j = true;
                                    gVarA3.c();
                                    eVar.getClass();
                                    eVar.f768f = 10000;
                                    final String string = new JSONObject(((f) gVarA3.execute()).f()).getString("version_name");
                                    if (string == null || string.isEmpty()) {
                                        p051j0.a.d("AppUpdateChecker", "无法从vivo商店API获取版本号信息");
                                    } else {
                                        final String strG6 = f.g(context5);
                                        int iB2 = f.b(strG6, string);
                                        final d dVar5 = dVar;
                                        if (iB2 < 0) {
                                            final int i15 = 2;
                                            handler4.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i15) {
                                                        case 0:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 1:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 2:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 3:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 4:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 5:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        default:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar5);
                                            handler4.post(new c(dVar5, 19));
                                        }
                                    }
                                } catch (SocketTimeoutException e8) {
                                    p051j0.a.e("AppUpdateChecker", "连接vivo商店API超时", e8);
                                    return;
                                } catch (JSONException e9) {
                                    p051j0.a.e("AppUpdateChecker", "解析vivo商店API返回的JSON数据失败", e9);
                                    return;
                                } catch (Exception e10) {
                                    p051j0.a.e("AppUpdateChecker", "vivo商店检测失败", e10);
                                    return;
                                }
                                break;
                            default:
                                Context context6 = context;
                                Handler handler5 = f.f8800a;
                                try {
                                    g gVarA4 = h.a("https://sj.qq.com/myapp/detail.htm?apkName=" + context6.getPackageName());
                                    gVarA4.c();
                                    i iVar3 = gVarA4.get();
                                    m mVarFirst5 = iVar3.Q("div.AppInfo_detailItem__MZbUR:has(p.AppInfo_detailName__bl08f:containsOwn(版本号)) p.AppInfo_detailContent__CBuk_").first();
                                    if (mVarFirst5 == null) {
                                        mVarFirst5 = iVar3.Q("div[class^=AppInfo_detailItem]:has(p[class^=AppInfo_detailName]:containsOwn(版本号)) p[class^=AppInfo_detailContent]").first();
                                    }
                                    if (mVarFirst5 == null) {
                                        mVarFirst5 = iVar3.Q("div:has(> p:containsOwn(版本号)) + div p").first();
                                    }
                                    if (mVarFirst5 == null) {
                                        p051j0.a.d("AppUpdateChecker", "无法找到应用宝版本号信息");
                                    } else {
                                        final String strTrim5 = mVarFirst5.S().trim();
                                        final String strG7 = f.g(context6);
                                        int iB3 = f.b(strG7, strTrim5);
                                        final d dVar6 = dVar;
                                        if (iB3 >= 0) {
                                            Objects.requireNonNull(dVar6);
                                            handler5.post(new c(dVar6, 19));
                                        } else {
                                            final int i16 = 4;
                                            handler5.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i16) {
                                                        case 0:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 1:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 2:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 3:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 4:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 5:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        default:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                    }
                                                }
                                            });
                                        }
                                    }
                                } catch (Exception e11) {
                                    p051j0.a.e("AppUpdateChecker", "应用宝检测失败", e11);
                                }
                                break;
                        }
                    }
                }).start();
                return;
            case "huawei":
                new Thread(new Runnable() { // from class: w.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        m mVarNextElementSibling;
                        switch (i7) {
                            case 0:
                                Context context2 = context;
                                Handler handler = f.f8800a;
                                try {
                                    g gVarA = h.a("https://app.meizu.com/apps/public/detail?package_name=" + context2.getPackageName());
                                    gVarA.c();
                                    i iVar = gVarA.get();
                                    m mVarFirst = iVar.Q("li span.app_title:containsOwn(版      本：) ~ div.app_content").first();
                                    final d dVar2 = dVar;
                                    if (mVarFirst != null) {
                                        final String strTrim = mVarFirst.S().trim();
                                        final String strG = f.g(context2);
                                        if (f.b(strG, strTrim) < 0) {
                                            final int i10 = 5;
                                            handler.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i10) {
                                                        case 0:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 1:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 2:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 3:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 4:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 5:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        default:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar2);
                                            handler.post(new c(dVar2, 19));
                                        }
                                    } else {
                                        m mVarFirst2 = iVar.Q("li:has(span.app_title:containsOwn(版      本：)) div.app_content").first();
                                        if (mVarFirst2 != null) {
                                            final String strTrim2 = mVarFirst2.S().trim();
                                            final String strG2 = f.g(context2);
                                            if (f.b(strG2, strTrim2) < 0) {
                                                final int i11 = 6;
                                                handler.post(new Runnable() { // from class: w.b
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        switch (i11) {
                                                            case 0:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 1:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 2:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 3:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 4:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 5:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            default:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                        }
                                                    }
                                                });
                                            } else {
                                                Objects.requireNonNull(dVar2);
                                                handler.post(new c(dVar2, 19));
                                            }
                                        } else {
                                            p051j0.a.d("AppUpdateChecker", "无法找到魅族商店版本号信息");
                                        }
                                    }
                                } catch (Exception e) {
                                    p051j0.a.e("AppUpdateChecker", "魅族商店检测失败", e);
                                    return;
                                }
                                break;
                            case 1:
                                Context context3 = context;
                                Handler handler2 = f.f8800a;
                                try {
                                    g gVarA2 = h.a("https://app.mi.com/details?id=" + context3.getPackageName());
                                    gVarA2.c();
                                    i iVar2 = gVarA2.get();
                                    m mVarFirst3 = iVar2.Q("div:containsOwn(版本号)").first();
                                    final d dVar3 = dVar;
                                    if (mVarFirst3 == null || (mVarNextElementSibling = mVarFirst3.nextElementSibling()) == null) {
                                        m mVarFirst4 = iVar2.Q("div:containsOwn(版本号) + div").first();
                                        if (mVarFirst4 != null) {
                                            final String strTrim3 = mVarFirst4.S().trim();
                                            final String strG3 = f.g(context3);
                                            if (f.b(strG3, strTrim3) < 0) {
                                                final int i12 = 1;
                                                handler2.post(new Runnable() { // from class: w.b
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        switch (i12) {
                                                            case 0:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 1:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 2:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 3:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 4:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 5:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            default:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                        }
                                                    }
                                                });
                                            } else {
                                                Objects.requireNonNull(dVar3);
                                                handler2.post(new c(dVar3, 19));
                                            }
                                        } else {
                                            p051j0.a.d("AppUpdateChecker", "无法找到小米商店版本号信息");
                                        }
                                    } else {
                                        final String strTrim4 = mVarNextElementSibling.S().trim();
                                        final String strG4 = f.g(context3);
                                        if (f.b(strG4, strTrim4) < 0) {
                                            final int i13 = 0;
                                            handler2.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i13) {
                                                        case 0:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 1:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 2:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 3:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 4:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 5:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        default:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar3);
                                            handler2.post(new c(dVar3, 19));
                                        }
                                    }
                                } catch (Exception e6) {
                                    p051j0.a.e("AppUpdateChecker", "小米商店检测失败", e6);
                                    return;
                                }
                                break;
                            case 2:
                                Context context4 = context;
                                Handler handler3 = f.f8800a;
                                try {
                                    String strReplace = UUID.randomUUID().toString().replace(ProcessIdUtil.DEFAULT_PROCESSID, "");
                                    String strF = f.f(strReplace);
                                    if (strF == null || strF.isEmpty()) {
                                        p051j0.a.d("AppUpdateChecker", "获取interface-code失败");
                                    } else {
                                        String strD = f.d(strReplace, strF);
                                        if (strD == null) {
                                            p051j0.a.d("AppUpdateChecker", "获取应用信息失败");
                                        } else {
                                            final String strC = f.c(strD);
                                            if (strC == null) {
                                                p051j0.a.d("AppUpdateChecker", "解析versionName失败，原始响应: ".concat(strD));
                                            } else {
                                                final String strG5 = f.g(context4);
                                                int iB = f.b(strG5, strC);
                                                final d dVar4 = dVar;
                                                if (iB < 0) {
                                                    final int i14 = 3;
                                                    handler3.post(new Runnable() { // from class: w.b
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            switch (i14) {
                                                                case 0:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 1:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 2:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 3:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 4:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 5:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                default:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                            }
                                                        }
                                                    });
                                                } else {
                                                    Objects.requireNonNull(dVar4);
                                                    handler3.post(new c(dVar4, 19));
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e7) {
                                    p051j0.a.e("AppUpdateChecker", "华为商店检测失败", e7);
                                    return;
                                }
                                break;
                            case 3:
                                Context context5 = context;
                                Handler handler4 = f.f8800a;
                                try {
                                    g gVarA3 = h.a("https://h5-api.appstore.vivo.com.cn/detail/3667544?frompage=messageh5&imei=1234567890&av=18&app_version=2100&pictype=webp&h5_websource=h5appstore");
                                    e eVar = gVarA3.f783a;
                                    eVar.f772j = true;
                                    gVarA3.c();
                                    eVar.getClass();
                                    eVar.f768f = 10000;
                                    final String string = new JSONObject(((f) gVarA3.execute()).f()).getString("version_name");
                                    if (string == null || string.isEmpty()) {
                                        p051j0.a.d("AppUpdateChecker", "无法从vivo商店API获取版本号信息");
                                    } else {
                                        final String strG6 = f.g(context5);
                                        int iB2 = f.b(strG6, string);
                                        final d dVar5 = dVar;
                                        if (iB2 < 0) {
                                            final int i15 = 2;
                                            handler4.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i15) {
                                                        case 0:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 1:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 2:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 3:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 4:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 5:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        default:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar5);
                                            handler4.post(new c(dVar5, 19));
                                        }
                                    }
                                } catch (SocketTimeoutException e8) {
                                    p051j0.a.e("AppUpdateChecker", "连接vivo商店API超时", e8);
                                    return;
                                } catch (JSONException e9) {
                                    p051j0.a.e("AppUpdateChecker", "解析vivo商店API返回的JSON数据失败", e9);
                                    return;
                                } catch (Exception e10) {
                                    p051j0.a.e("AppUpdateChecker", "vivo商店检测失败", e10);
                                    return;
                                }
                                break;
                            default:
                                Context context6 = context;
                                Handler handler5 = f.f8800a;
                                try {
                                    g gVarA4 = h.a("https://sj.qq.com/myapp/detail.htm?apkName=" + context6.getPackageName());
                                    gVarA4.c();
                                    i iVar3 = gVarA4.get();
                                    m mVarFirst5 = iVar3.Q("div.AppInfo_detailItem__MZbUR:has(p.AppInfo_detailName__bl08f:containsOwn(版本号)) p.AppInfo_detailContent__CBuk_").first();
                                    if (mVarFirst5 == null) {
                                        mVarFirst5 = iVar3.Q("div[class^=AppInfo_detailItem]:has(p[class^=AppInfo_detailName]:containsOwn(版本号)) p[class^=AppInfo_detailContent]").first();
                                    }
                                    if (mVarFirst5 == null) {
                                        mVarFirst5 = iVar3.Q("div:has(> p:containsOwn(版本号)) + div p").first();
                                    }
                                    if (mVarFirst5 == null) {
                                        p051j0.a.d("AppUpdateChecker", "无法找到应用宝版本号信息");
                                    } else {
                                        final String strTrim5 = mVarFirst5.S().trim();
                                        final String strG7 = f.g(context6);
                                        int iB3 = f.b(strG7, strTrim5);
                                        final d dVar6 = dVar;
                                        if (iB3 >= 0) {
                                            Objects.requireNonNull(dVar6);
                                            handler5.post(new c(dVar6, 19));
                                        } else {
                                            final int i16 = 4;
                                            handler5.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i16) {
                                                        case 0:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 1:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 2:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 3:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 4:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 5:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        default:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                    }
                                                }
                                            });
                                        }
                                    }
                                } catch (Exception e11) {
                                    p051j0.a.e("AppUpdateChecker", "应用宝检测失败", e11);
                                }
                                break;
                        }
                    }
                }).start();
                return;
            case "xiaomi":
                new Thread(new Runnable() { // from class: w.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        m mVarNextElementSibling;
                        switch (i8) {
                            case 0:
                                Context context2 = context;
                                Handler handler = f.f8800a;
                                try {
                                    g gVarA = h.a("https://app.meizu.com/apps/public/detail?package_name=" + context2.getPackageName());
                                    gVarA.c();
                                    i iVar = gVarA.get();
                                    m mVarFirst = iVar.Q("li span.app_title:containsOwn(版      本：) ~ div.app_content").first();
                                    final d dVar2 = dVar;
                                    if (mVarFirst != null) {
                                        final String strTrim = mVarFirst.S().trim();
                                        final String strG = f.g(context2);
                                        if (f.b(strG, strTrim) < 0) {
                                            final int i10 = 5;
                                            handler.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i10) {
                                                        case 0:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 1:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 2:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 3:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 4:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 5:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        default:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar2);
                                            handler.post(new c(dVar2, 19));
                                        }
                                    } else {
                                        m mVarFirst2 = iVar.Q("li:has(span.app_title:containsOwn(版      本：)) div.app_content").first();
                                        if (mVarFirst2 != null) {
                                            final String strTrim2 = mVarFirst2.S().trim();
                                            final String strG2 = f.g(context2);
                                            if (f.b(strG2, strTrim2) < 0) {
                                                final int i11 = 6;
                                                handler.post(new Runnable() { // from class: w.b
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        switch (i11) {
                                                            case 0:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 1:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 2:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 3:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 4:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 5:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            default:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                        }
                                                    }
                                                });
                                            } else {
                                                Objects.requireNonNull(dVar2);
                                                handler.post(new c(dVar2, 19));
                                            }
                                        } else {
                                            p051j0.a.d("AppUpdateChecker", "无法找到魅族商店版本号信息");
                                        }
                                    }
                                } catch (Exception e) {
                                    p051j0.a.e("AppUpdateChecker", "魅族商店检测失败", e);
                                    return;
                                }
                                break;
                            case 1:
                                Context context3 = context;
                                Handler handler2 = f.f8800a;
                                try {
                                    g gVarA2 = h.a("https://app.mi.com/details?id=" + context3.getPackageName());
                                    gVarA2.c();
                                    i iVar2 = gVarA2.get();
                                    m mVarFirst3 = iVar2.Q("div:containsOwn(版本号)").first();
                                    final d dVar3 = dVar;
                                    if (mVarFirst3 == null || (mVarNextElementSibling = mVarFirst3.nextElementSibling()) == null) {
                                        m mVarFirst4 = iVar2.Q("div:containsOwn(版本号) + div").first();
                                        if (mVarFirst4 != null) {
                                            final String strTrim3 = mVarFirst4.S().trim();
                                            final String strG3 = f.g(context3);
                                            if (f.b(strG3, strTrim3) < 0) {
                                                final int i12 = 1;
                                                handler2.post(new Runnable() { // from class: w.b
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        switch (i12) {
                                                            case 0:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 1:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 2:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 3:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 4:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 5:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            default:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                        }
                                                    }
                                                });
                                            } else {
                                                Objects.requireNonNull(dVar3);
                                                handler2.post(new c(dVar3, 19));
                                            }
                                        } else {
                                            p051j0.a.d("AppUpdateChecker", "无法找到小米商店版本号信息");
                                        }
                                    } else {
                                        final String strTrim4 = mVarNextElementSibling.S().trim();
                                        final String strG4 = f.g(context3);
                                        if (f.b(strG4, strTrim4) < 0) {
                                            final int i13 = 0;
                                            handler2.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i13) {
                                                        case 0:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 1:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 2:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 3:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 4:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 5:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        default:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar3);
                                            handler2.post(new c(dVar3, 19));
                                        }
                                    }
                                } catch (Exception e6) {
                                    p051j0.a.e("AppUpdateChecker", "小米商店检测失败", e6);
                                    return;
                                }
                                break;
                            case 2:
                                Context context4 = context;
                                Handler handler3 = f.f8800a;
                                try {
                                    String strReplace = UUID.randomUUID().toString().replace(ProcessIdUtil.DEFAULT_PROCESSID, "");
                                    String strF = f.f(strReplace);
                                    if (strF == null || strF.isEmpty()) {
                                        p051j0.a.d("AppUpdateChecker", "获取interface-code失败");
                                    } else {
                                        String strD = f.d(strReplace, strF);
                                        if (strD == null) {
                                            p051j0.a.d("AppUpdateChecker", "获取应用信息失败");
                                        } else {
                                            final String strC = f.c(strD);
                                            if (strC == null) {
                                                p051j0.a.d("AppUpdateChecker", "解析versionName失败，原始响应: ".concat(strD));
                                            } else {
                                                final String strG5 = f.g(context4);
                                                int iB = f.b(strG5, strC);
                                                final d dVar4 = dVar;
                                                if (iB < 0) {
                                                    final int i14 = 3;
                                                    handler3.post(new Runnable() { // from class: w.b
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            switch (i14) {
                                                                case 0:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 1:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 2:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 3:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 4:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 5:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                default:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                            }
                                                        }
                                                    });
                                                } else {
                                                    Objects.requireNonNull(dVar4);
                                                    handler3.post(new c(dVar4, 19));
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e7) {
                                    p051j0.a.e("AppUpdateChecker", "华为商店检测失败", e7);
                                    return;
                                }
                                break;
                            case 3:
                                Context context5 = context;
                                Handler handler4 = f.f8800a;
                                try {
                                    g gVarA3 = h.a("https://h5-api.appstore.vivo.com.cn/detail/3667544?frompage=messageh5&imei=1234567890&av=18&app_version=2100&pictype=webp&h5_websource=h5appstore");
                                    e eVar = gVarA3.f783a;
                                    eVar.f772j = true;
                                    gVarA3.c();
                                    eVar.getClass();
                                    eVar.f768f = 10000;
                                    final String string = new JSONObject(((f) gVarA3.execute()).f()).getString("version_name");
                                    if (string == null || string.isEmpty()) {
                                        p051j0.a.d("AppUpdateChecker", "无法从vivo商店API获取版本号信息");
                                    } else {
                                        final String strG6 = f.g(context5);
                                        int iB2 = f.b(strG6, string);
                                        final d dVar5 = dVar;
                                        if (iB2 < 0) {
                                            final int i15 = 2;
                                            handler4.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i15) {
                                                        case 0:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 1:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 2:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 3:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 4:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 5:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        default:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar5);
                                            handler4.post(new c(dVar5, 19));
                                        }
                                    }
                                } catch (SocketTimeoutException e8) {
                                    p051j0.a.e("AppUpdateChecker", "连接vivo商店API超时", e8);
                                    return;
                                } catch (JSONException e9) {
                                    p051j0.a.e("AppUpdateChecker", "解析vivo商店API返回的JSON数据失败", e9);
                                    return;
                                } catch (Exception e10) {
                                    p051j0.a.e("AppUpdateChecker", "vivo商店检测失败", e10);
                                    return;
                                }
                                break;
                            default:
                                Context context6 = context;
                                Handler handler5 = f.f8800a;
                                try {
                                    g gVarA4 = h.a("https://sj.qq.com/myapp/detail.htm?apkName=" + context6.getPackageName());
                                    gVarA4.c();
                                    i iVar3 = gVarA4.get();
                                    m mVarFirst5 = iVar3.Q("div.AppInfo_detailItem__MZbUR:has(p.AppInfo_detailName__bl08f:containsOwn(版本号)) p.AppInfo_detailContent__CBuk_").first();
                                    if (mVarFirst5 == null) {
                                        mVarFirst5 = iVar3.Q("div[class^=AppInfo_detailItem]:has(p[class^=AppInfo_detailName]:containsOwn(版本号)) p[class^=AppInfo_detailContent]").first();
                                    }
                                    if (mVarFirst5 == null) {
                                        mVarFirst5 = iVar3.Q("div:has(> p:containsOwn(版本号)) + div p").first();
                                    }
                                    if (mVarFirst5 == null) {
                                        p051j0.a.d("AppUpdateChecker", "无法找到应用宝版本号信息");
                                    } else {
                                        final String strTrim5 = mVarFirst5.S().trim();
                                        final String strG7 = f.g(context6);
                                        int iB3 = f.b(strG7, strTrim5);
                                        final d dVar6 = dVar;
                                        if (iB3 >= 0) {
                                            Objects.requireNonNull(dVar6);
                                            handler5.post(new c(dVar6, 19));
                                        } else {
                                            final int i16 = 4;
                                            handler5.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i16) {
                                                        case 0:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 1:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 2:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 3:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 4:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 5:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        default:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                    }
                                                }
                                            });
                                        }
                                    }
                                } catch (Exception e11) {
                                    p051j0.a.e("AppUpdateChecker", "应用宝检测失败", e11);
                                }
                                break;
                        }
                    }
                }).start();
                return;
            case "vivo":
                new Thread(new Runnable() { // from class: w.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        m mVarNextElementSibling;
                        switch (i6) {
                            case 0:
                                Context context2 = context;
                                Handler handler = f.f8800a;
                                try {
                                    g gVarA = h.a("https://app.meizu.com/apps/public/detail?package_name=" + context2.getPackageName());
                                    gVarA.c();
                                    i iVar = gVarA.get();
                                    m mVarFirst = iVar.Q("li span.app_title:containsOwn(版      本：) ~ div.app_content").first();
                                    final d dVar2 = dVar;
                                    if (mVarFirst != null) {
                                        final String strTrim = mVarFirst.S().trim();
                                        final String strG = f.g(context2);
                                        if (f.b(strG, strTrim) < 0) {
                                            final int i10 = 5;
                                            handler.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i10) {
                                                        case 0:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 1:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 2:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 3:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 4:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 5:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        default:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar2);
                                            handler.post(new c(dVar2, 19));
                                        }
                                    } else {
                                        m mVarFirst2 = iVar.Q("li:has(span.app_title:containsOwn(版      本：)) div.app_content").first();
                                        if (mVarFirst2 != null) {
                                            final String strTrim2 = mVarFirst2.S().trim();
                                            final String strG2 = f.g(context2);
                                            if (f.b(strG2, strTrim2) < 0) {
                                                final int i11 = 6;
                                                handler.post(new Runnable() { // from class: w.b
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        switch (i11) {
                                                            case 0:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 1:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 2:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 3:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 4:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 5:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            default:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                        }
                                                    }
                                                });
                                            } else {
                                                Objects.requireNonNull(dVar2);
                                                handler.post(new c(dVar2, 19));
                                            }
                                        } else {
                                            p051j0.a.d("AppUpdateChecker", "无法找到魅族商店版本号信息");
                                        }
                                    }
                                } catch (Exception e) {
                                    p051j0.a.e("AppUpdateChecker", "魅族商店检测失败", e);
                                    return;
                                }
                                break;
                            case 1:
                                Context context3 = context;
                                Handler handler2 = f.f8800a;
                                try {
                                    g gVarA2 = h.a("https://app.mi.com/details?id=" + context3.getPackageName());
                                    gVarA2.c();
                                    i iVar2 = gVarA2.get();
                                    m mVarFirst3 = iVar2.Q("div:containsOwn(版本号)").first();
                                    final d dVar3 = dVar;
                                    if (mVarFirst3 == null || (mVarNextElementSibling = mVarFirst3.nextElementSibling()) == null) {
                                        m mVarFirst4 = iVar2.Q("div:containsOwn(版本号) + div").first();
                                        if (mVarFirst4 != null) {
                                            final String strTrim3 = mVarFirst4.S().trim();
                                            final String strG3 = f.g(context3);
                                            if (f.b(strG3, strTrim3) < 0) {
                                                final int i12 = 1;
                                                handler2.post(new Runnable() { // from class: w.b
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        switch (i12) {
                                                            case 0:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 1:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 2:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 3:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 4:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 5:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            default:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                        }
                                                    }
                                                });
                                            } else {
                                                Objects.requireNonNull(dVar3);
                                                handler2.post(new c(dVar3, 19));
                                            }
                                        } else {
                                            p051j0.a.d("AppUpdateChecker", "无法找到小米商店版本号信息");
                                        }
                                    } else {
                                        final String strTrim4 = mVarNextElementSibling.S().trim();
                                        final String strG4 = f.g(context3);
                                        if (f.b(strG4, strTrim4) < 0) {
                                            final int i13 = 0;
                                            handler2.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i13) {
                                                        case 0:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 1:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 2:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 3:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 4:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 5:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        default:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar3);
                                            handler2.post(new c(dVar3, 19));
                                        }
                                    }
                                } catch (Exception e6) {
                                    p051j0.a.e("AppUpdateChecker", "小米商店检测失败", e6);
                                    return;
                                }
                                break;
                            case 2:
                                Context context4 = context;
                                Handler handler3 = f.f8800a;
                                try {
                                    String strReplace = UUID.randomUUID().toString().replace(ProcessIdUtil.DEFAULT_PROCESSID, "");
                                    String strF = f.f(strReplace);
                                    if (strF == null || strF.isEmpty()) {
                                        p051j0.a.d("AppUpdateChecker", "获取interface-code失败");
                                    } else {
                                        String strD = f.d(strReplace, strF);
                                        if (strD == null) {
                                            p051j0.a.d("AppUpdateChecker", "获取应用信息失败");
                                        } else {
                                            final String strC = f.c(strD);
                                            if (strC == null) {
                                                p051j0.a.d("AppUpdateChecker", "解析versionName失败，原始响应: ".concat(strD));
                                            } else {
                                                final String strG5 = f.g(context4);
                                                int iB = f.b(strG5, strC);
                                                final d dVar4 = dVar;
                                                if (iB < 0) {
                                                    final int i14 = 3;
                                                    handler3.post(new Runnable() { // from class: w.b
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            switch (i14) {
                                                                case 0:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 1:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 2:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 3:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 4:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 5:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                default:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                            }
                                                        }
                                                    });
                                                } else {
                                                    Objects.requireNonNull(dVar4);
                                                    handler3.post(new c(dVar4, 19));
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e7) {
                                    p051j0.a.e("AppUpdateChecker", "华为商店检测失败", e7);
                                    return;
                                }
                                break;
                            case 3:
                                Context context5 = context;
                                Handler handler4 = f.f8800a;
                                try {
                                    g gVarA3 = h.a("https://h5-api.appstore.vivo.com.cn/detail/3667544?frompage=messageh5&imei=1234567890&av=18&app_version=2100&pictype=webp&h5_websource=h5appstore");
                                    e eVar = gVarA3.f783a;
                                    eVar.f772j = true;
                                    gVarA3.c();
                                    eVar.getClass();
                                    eVar.f768f = 10000;
                                    final String string = new JSONObject(((f) gVarA3.execute()).f()).getString("version_name");
                                    if (string == null || string.isEmpty()) {
                                        p051j0.a.d("AppUpdateChecker", "无法从vivo商店API获取版本号信息");
                                    } else {
                                        final String strG6 = f.g(context5);
                                        int iB2 = f.b(strG6, string);
                                        final d dVar5 = dVar;
                                        if (iB2 < 0) {
                                            final int i15 = 2;
                                            handler4.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i15) {
                                                        case 0:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 1:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 2:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 3:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 4:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 5:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        default:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar5);
                                            handler4.post(new c(dVar5, 19));
                                        }
                                    }
                                } catch (SocketTimeoutException e8) {
                                    p051j0.a.e("AppUpdateChecker", "连接vivo商店API超时", e8);
                                    return;
                                } catch (JSONException e9) {
                                    p051j0.a.e("AppUpdateChecker", "解析vivo商店API返回的JSON数据失败", e9);
                                    return;
                                } catch (Exception e10) {
                                    p051j0.a.e("AppUpdateChecker", "vivo商店检测失败", e10);
                                    return;
                                }
                                break;
                            default:
                                Context context6 = context;
                                Handler handler5 = f.f8800a;
                                try {
                                    g gVarA4 = h.a("https://sj.qq.com/myapp/detail.htm?apkName=" + context6.getPackageName());
                                    gVarA4.c();
                                    i iVar3 = gVarA4.get();
                                    m mVarFirst5 = iVar3.Q("div.AppInfo_detailItem__MZbUR:has(p.AppInfo_detailName__bl08f:containsOwn(版本号)) p.AppInfo_detailContent__CBuk_").first();
                                    if (mVarFirst5 == null) {
                                        mVarFirst5 = iVar3.Q("div[class^=AppInfo_detailItem]:has(p[class^=AppInfo_detailName]:containsOwn(版本号)) p[class^=AppInfo_detailContent]").first();
                                    }
                                    if (mVarFirst5 == null) {
                                        mVarFirst5 = iVar3.Q("div:has(> p:containsOwn(版本号)) + div p").first();
                                    }
                                    if (mVarFirst5 == null) {
                                        p051j0.a.d("AppUpdateChecker", "无法找到应用宝版本号信息");
                                    } else {
                                        final String strTrim5 = mVarFirst5.S().trim();
                                        final String strG7 = f.g(context6);
                                        int iB3 = f.b(strG7, strTrim5);
                                        final d dVar6 = dVar;
                                        if (iB3 >= 0) {
                                            Objects.requireNonNull(dVar6);
                                            handler5.post(new c(dVar6, 19));
                                        } else {
                                            final int i16 = 4;
                                            handler5.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i16) {
                                                        case 0:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 1:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 2:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 3:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 4:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 5:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        default:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                    }
                                                }
                                            });
                                        }
                                    }
                                } catch (Exception e11) {
                                    p051j0.a.e("AppUpdateChecker", "应用宝检测失败", e11);
                                }
                                break;
                        }
                    }
                }).start();
                break;
            case "meizu":
                new Thread(new Runnable() { // from class: w.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        m mVarNextElementSibling;
                        switch (i9) {
                            case 0:
                                Context context2 = context;
                                Handler handler = f.f8800a;
                                try {
                                    g gVarA = h.a("https://app.meizu.com/apps/public/detail?package_name=" + context2.getPackageName());
                                    gVarA.c();
                                    i iVar = gVarA.get();
                                    m mVarFirst = iVar.Q("li span.app_title:containsOwn(版      本：) ~ div.app_content").first();
                                    final d dVar2 = dVar;
                                    if (mVarFirst != null) {
                                        final String strTrim = mVarFirst.S().trim();
                                        final String strG = f.g(context2);
                                        if (f.b(strG, strTrim) < 0) {
                                            final int i10 = 5;
                                            handler.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i10) {
                                                        case 0:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 1:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 2:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 3:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 4:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        case 5:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                        default:
                                                            dVar2.onUpdateAvailable(strG, strTrim);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar2);
                                            handler.post(new c(dVar2, 19));
                                        }
                                    } else {
                                        m mVarFirst2 = iVar.Q("li:has(span.app_title:containsOwn(版      本：)) div.app_content").first();
                                        if (mVarFirst2 != null) {
                                            final String strTrim2 = mVarFirst2.S().trim();
                                            final String strG2 = f.g(context2);
                                            if (f.b(strG2, strTrim2) < 0) {
                                                final int i11 = 6;
                                                handler.post(new Runnable() { // from class: w.b
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        switch (i11) {
                                                            case 0:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 1:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 2:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 3:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 4:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            case 5:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                            default:
                                                                dVar2.onUpdateAvailable(strG2, strTrim2);
                                                                break;
                                                        }
                                                    }
                                                });
                                            } else {
                                                Objects.requireNonNull(dVar2);
                                                handler.post(new c(dVar2, 19));
                                            }
                                        } else {
                                            p051j0.a.d("AppUpdateChecker", "无法找到魅族商店版本号信息");
                                        }
                                    }
                                } catch (Exception e) {
                                    p051j0.a.e("AppUpdateChecker", "魅族商店检测失败", e);
                                    return;
                                }
                                break;
                            case 1:
                                Context context3 = context;
                                Handler handler2 = f.f8800a;
                                try {
                                    g gVarA2 = h.a("https://app.mi.com/details?id=" + context3.getPackageName());
                                    gVarA2.c();
                                    i iVar2 = gVarA2.get();
                                    m mVarFirst3 = iVar2.Q("div:containsOwn(版本号)").first();
                                    final d dVar3 = dVar;
                                    if (mVarFirst3 == null || (mVarNextElementSibling = mVarFirst3.nextElementSibling()) == null) {
                                        m mVarFirst4 = iVar2.Q("div:containsOwn(版本号) + div").first();
                                        if (mVarFirst4 != null) {
                                            final String strTrim3 = mVarFirst4.S().trim();
                                            final String strG3 = f.g(context3);
                                            if (f.b(strG3, strTrim3) < 0) {
                                                final int i12 = 1;
                                                handler2.post(new Runnable() { // from class: w.b
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        switch (i12) {
                                                            case 0:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 1:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 2:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 3:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 4:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            case 5:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                            default:
                                                                dVar3.onUpdateAvailable(strG3, strTrim3);
                                                                break;
                                                        }
                                                    }
                                                });
                                            } else {
                                                Objects.requireNonNull(dVar3);
                                                handler2.post(new c(dVar3, 19));
                                            }
                                        } else {
                                            p051j0.a.d("AppUpdateChecker", "无法找到小米商店版本号信息");
                                        }
                                    } else {
                                        final String strTrim4 = mVarNextElementSibling.S().trim();
                                        final String strG4 = f.g(context3);
                                        if (f.b(strG4, strTrim4) < 0) {
                                            final int i13 = 0;
                                            handler2.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i13) {
                                                        case 0:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 1:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 2:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 3:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 4:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        case 5:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                        default:
                                                            dVar3.onUpdateAvailable(strG4, strTrim4);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar3);
                                            handler2.post(new c(dVar3, 19));
                                        }
                                    }
                                } catch (Exception e6) {
                                    p051j0.a.e("AppUpdateChecker", "小米商店检测失败", e6);
                                    return;
                                }
                                break;
                            case 2:
                                Context context4 = context;
                                Handler handler3 = f.f8800a;
                                try {
                                    String strReplace = UUID.randomUUID().toString().replace(ProcessIdUtil.DEFAULT_PROCESSID, "");
                                    String strF = f.f(strReplace);
                                    if (strF == null || strF.isEmpty()) {
                                        p051j0.a.d("AppUpdateChecker", "获取interface-code失败");
                                    } else {
                                        String strD = f.d(strReplace, strF);
                                        if (strD == null) {
                                            p051j0.a.d("AppUpdateChecker", "获取应用信息失败");
                                        } else {
                                            final String strC = f.c(strD);
                                            if (strC == null) {
                                                p051j0.a.d("AppUpdateChecker", "解析versionName失败，原始响应: ".concat(strD));
                                            } else {
                                                final String strG5 = f.g(context4);
                                                int iB = f.b(strG5, strC);
                                                final d dVar4 = dVar;
                                                if (iB < 0) {
                                                    final int i14 = 3;
                                                    handler3.post(new Runnable() { // from class: w.b
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            switch (i14) {
                                                                case 0:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 1:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 2:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 3:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 4:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                case 5:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                                default:
                                                                    dVar4.onUpdateAvailable(strG5, strC);
                                                                    break;
                                                            }
                                                        }
                                                    });
                                                } else {
                                                    Objects.requireNonNull(dVar4);
                                                    handler3.post(new c(dVar4, 19));
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e7) {
                                    p051j0.a.e("AppUpdateChecker", "华为商店检测失败", e7);
                                    return;
                                }
                                break;
                            case 3:
                                Context context5 = context;
                                Handler handler4 = f.f8800a;
                                try {
                                    g gVarA3 = h.a("https://h5-api.appstore.vivo.com.cn/detail/3667544?frompage=messageh5&imei=1234567890&av=18&app_version=2100&pictype=webp&h5_websource=h5appstore");
                                    e eVar = gVarA3.f783a;
                                    eVar.f772j = true;
                                    gVarA3.c();
                                    eVar.getClass();
                                    eVar.f768f = 10000;
                                    final String string = new JSONObject(((f) gVarA3.execute()).f()).getString("version_name");
                                    if (string == null || string.isEmpty()) {
                                        p051j0.a.d("AppUpdateChecker", "无法从vivo商店API获取版本号信息");
                                    } else {
                                        final String strG6 = f.g(context5);
                                        int iB2 = f.b(strG6, string);
                                        final d dVar5 = dVar;
                                        if (iB2 < 0) {
                                            final int i15 = 2;
                                            handler4.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i15) {
                                                        case 0:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 1:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 2:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 3:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 4:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        case 5:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                        default:
                                                            dVar5.onUpdateAvailable(strG6, string);
                                                            break;
                                                    }
                                                }
                                            });
                                        } else {
                                            Objects.requireNonNull(dVar5);
                                            handler4.post(new c(dVar5, 19));
                                        }
                                    }
                                } catch (SocketTimeoutException e8) {
                                    p051j0.a.e("AppUpdateChecker", "连接vivo商店API超时", e8);
                                    return;
                                } catch (JSONException e9) {
                                    p051j0.a.e("AppUpdateChecker", "解析vivo商店API返回的JSON数据失败", e9);
                                    return;
                                } catch (Exception e10) {
                                    p051j0.a.e("AppUpdateChecker", "vivo商店检测失败", e10);
                                    return;
                                }
                                break;
                            default:
                                Context context6 = context;
                                Handler handler5 = f.f8800a;
                                try {
                                    g gVarA4 = h.a("https://sj.qq.com/myapp/detail.htm?apkName=" + context6.getPackageName());
                                    gVarA4.c();
                                    i iVar3 = gVarA4.get();
                                    m mVarFirst5 = iVar3.Q("div.AppInfo_detailItem__MZbUR:has(p.AppInfo_detailName__bl08f:containsOwn(版本号)) p.AppInfo_detailContent__CBuk_").first();
                                    if (mVarFirst5 == null) {
                                        mVarFirst5 = iVar3.Q("div[class^=AppInfo_detailItem]:has(p[class^=AppInfo_detailName]:containsOwn(版本号)) p[class^=AppInfo_detailContent]").first();
                                    }
                                    if (mVarFirst5 == null) {
                                        mVarFirst5 = iVar3.Q("div:has(> p:containsOwn(版本号)) + div p").first();
                                    }
                                    if (mVarFirst5 == null) {
                                        p051j0.a.d("AppUpdateChecker", "无法找到应用宝版本号信息");
                                    } else {
                                        final String strTrim5 = mVarFirst5.S().trim();
                                        final String strG7 = f.g(context6);
                                        int iB3 = f.b(strG7, strTrim5);
                                        final d dVar6 = dVar;
                                        if (iB3 >= 0) {
                                            Objects.requireNonNull(dVar6);
                                            handler5.post(new c(dVar6, 19));
                                        } else {
                                            final int i16 = 4;
                                            handler5.post(new Runnable() { // from class: w.b
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    switch (i16) {
                                                        case 0:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 1:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 2:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 3:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 4:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        case 5:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                        default:
                                                            dVar6.onUpdateAvailable(strG7, strTrim5);
                                                            break;
                                                    }
                                                }
                                            });
                                        }
                                    }
                                } catch (Exception e11) {
                                    p051j0.a.e("AppUpdateChecker", "应用宝检测失败", e11);
                                }
                                break;
                        }
                    }
                }).start();
                return;
        }
        p051j0.a.d("AppUpdateChecker", "暂不支持该商店检测: ".concat(str));
    }

    public static int b(String str, String str2) {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
        int i5 = 0;
        while (i5 < iMax) {
            int i6 = i5 < strArrSplit.length ? Integer.parseInt(strArrSplit[i5]) : 0;
            int i7 = i5 < strArrSplit2.length ? Integer.parseInt(strArrSplit2[i5]) : 0;
            if (i6 < i7) {
                return -1;
            }
            if (i6 > i7) {
                return 1;
            }
            i5++;
        }
        return 0;
    }

    public static String c(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("layoutData");
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i5);
                if ("detailappinfocard".equals(jSONObject.optString("layoutName"))) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("dataList");
                    if (jSONArray2.length() > 0) {
                        return jSONArray2.getJSONObject(0).optString("version");
                    }
                }
            }
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                if (jSONObject2.has("dataList")) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("dataList");
                    for (int i7 = 0; i7 < jSONArray3.length(); i7++) {
                        JSONObject jSONObject3 = jSONArray3.getJSONObject(i7);
                        if (jSONObject3.has("versionName")) {
                            return jSONObject3.getString("versionName");
                        }
                    }
                }
            }
            return null;
        } catch (JSONException e) {
            p051j0.a.e("AppUpdateChecker", "JSON解析异常", e);
            return null;
        }
    }

    public static void checkUpdate(@NonNull Context context, @NonNull d dVar) {
        try {
            context.getPackageManager().getPackageInfo((String) b.get("google"), 0);
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (!lowerCase.contains("huawei") && !lowerCase.contains("xiaomi") && !lowerCase.contains("oppo") && !lowerCase.contains("vivo") && !lowerCase.contains("meizu")) {
                AppUpdateManagerFactory.create(context).getAppUpdateInfo().addOnSuccessListener(new c(dVar, context)).addOnFailureListener(new c(context, dVar));
                return;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        String strE = e(context);
        if (TextUtils.isEmpty(strE)) {
            dVar.onNoStoreInstalled();
        } else {
            dVar.onStoreDetected(strE);
            a(context, strE, dVar);
        }
    }

    public static String d(String str, String str2) {
        try {
            String str3 = str2 + "_" + System.currentTimeMillis();
            System.out.println("加上" + str3);
            G g6 = new G();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            g6.f6506t = d.b(15L, timeUnit);
            g6.f6507u = d.b(15L, timeUnit);
            g6.a(new e());
            H h6 = new H(g6);
            L l6 = new L();
            l6.c("https://web-drcn.hispace.dbankcloud.com/edge/uowap/index?method=internal.getTabDetail&serviceType=20&reqPageNum=1&maxResults=25&uri=app%7CC110758385&shareTo=&currentUrl=https%253A%252F%252Fappgallery.huawei.com%252Fapp%252FC110758385&accessId=&appid=C110758385&zone=&locale=zh");
            L lMethod = l6.method(ShareTarget.METHOD_GET, null);
            lMethod.b.a(HttpHeaders.ACCEPT, "application/json, text/plain, */*");
            lMethod.b.a(HttpHeaders.CONTENT_TYPE, "application/json");
            lMethod.b.a("identity-id", str);
            lMethod.b.a("interface-code", str3);
            lMethod.b.a(HttpHeaders.REFERER, "https://web-drcn.hispace.dbankcloud.com/");
            lMethod.b.a("User-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36 Edg/136.0.0.0");
            T tExecute = K.a(h6, lMethod.a()).execute();
            if (tExecute.a()) {
                return tExecute.body().string();
            }
            p051j0.a.d("AppUpdateChecker", "请求失败: " + tExecute.c + " - " + (tExecute.body() != null ? tExecute.body().string() : AbstractC1127c.NULL));
            return null;
        } catch (Exception e) {
            p051j0.a.e("AppUpdateChecker", "请求异常", e);
            return null;
        }
    }

    public static String e(Context context) {
        for (Map.Entry entry : b.entrySet()) {
            try {
                context.getPackageManager().getPackageInfo((String) entry.getValue(), 0);
                return (String) entry.getKey();
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static String f(String str) {
        try {
            H h6 = new H();
            Q qCreate = Q.create(B.parse("application/json"), "{}");
            L l6 = new L();
            l6.c("https://web-drcn.hispace.dbankcloud.com/edge/webedge/getInterfaceCode");
            L lMethod = l6.method(ShareTarget.METHOD_POST, qCreate);
            lMethod.b.a(HttpHeaders.ACCEPT, "application/json, text/plain, */*");
            lMethod.b.a("Content-type", "application/json");
            lMethod.b.a("identity-id", str);
            lMethod.b.a("interface-code", "null_" + new Date().getTime());
            lMethod.b.a(HttpHeaders.REFERER, "https://web-drcn.hispace.dbankcloud.com/");
            lMethod.b.a("User-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36 Edg/136.0.0.0");
            T tExecute = K.a(h6, lMethod.a()).execute();
            if (!tExecute.a()) {
                return null;
            }
            String strString = tExecute.body().string();
            return (strString.startsWith("\"") && strString.endsWith("\"")) ? strString.substring(1, strString.length() - 1) : tExecute.body().string();
        } catch (Exception e) {
            p051j0.a.e("AppUpdateChecker", "获取interface-code异常", e);
            return null;
        }
    }

    public static String g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "1.0.0";
        }
    }

    public static void h(Context context, String str) {
        String str2 = (String) b.get(str.toLowerCase());
        try {
            context.getPackageManager().getPackageInfo(str2, 0);
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("market://details?id=" + context.getPackageName()));
                intent.setPackage(str2);
                context.startActivity(intent);
            } catch (Exception unused) {
                i(context);
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            i(context);
        }
    }

    public static void i(Context context) {
        String strN;
        String strE = e(context);
        String packageName = context.getPackageName();
        if (strE != null) {
            String lowerCase = strE.toLowerCase();
            lowerCase.getClass();
            switch (lowerCase) {
                case "tencent":
                    strN = AbstractC0157z.n("https://sj.qq.com/myapp/detail.htm?apkName=", packageName);
                    break;
                case "google":
                    strN = AbstractC0157z.n("https://play.google.com/store/apps/details?id=", packageName);
                    break;
                case "huawei":
                    strN = "https://appgallery.huawei.com/app/C110758385";
                    break;
                case "xiaomi":
                    strN = AbstractC0157z.n("https://app.mi.com/details?id=", packageName);
                    break;
                case "vivo":
                    strN = "https://h5.appstore.vivo.com.cn/#/details?search_word=%E7%B2%BE%E5%83%8F%E4%BA%91%E6%A0%87&search_action=4&app_id=3667544&app_pos=1&source=5&appId=3667544&frompage=searchResultApp&listpos=1";
                    break;
                case "meizu":
                    strN = AbstractC0157z.n("https://app.meizu.com/apps/public/detail?package_name=", packageName);
                    break;
                default:
                    strN = AbstractC0157z.n("https://play.google.com/store/apps/details?id=", packageName);
                    break;
            }
        } else {
            strN = AbstractC0157z.n("https://play.google.com/store/apps/details?id=", packageName);
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(strN)));
        } catch (Exception unused) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strN));
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
