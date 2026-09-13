package cn.sharesdk.framework;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.MobSDK;
import com.mob.commons.ForbThrowable;
import com.mob.commons.dialog.PolicyThrowable;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.poi.openxml4j.opc.PackageRelationship;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Platform f2191a;
    private PlatformDb b;
    private e c;
    private int d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2193g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2194h;

    public g(Platform platform) {
        this.f2191a = platform;
        String name = platform.getName();
        this.b = new PlatformDb(name, platform.getVersion());
        a(name);
        this.c = new e();
        c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        if (ShareSDK.b()) {
            this.f2193g = !"false".equals(a(this.f2191a.getPlatformId(), "covert_url", (String) null));
            this.f2191a.setNetworkDevinfo();
            return true;
        }
        try {
            ShareSDK.a(new ShareSDKCallback<Boolean>() { // from class: cn.sharesdk.framework.g.1
                @Override // cn.sharesdk.framework.ShareSDKCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onCallback(Boolean bool) {
                    if (bool.booleanValue()) {
                        g gVar = g.this;
                        String strA = gVar.a(gVar.f2191a.getPlatformId(), "covert_url", (String) null);
                        if (strA != null) {
                            strA = strA.trim();
                        }
                        g.this.f2193g = !"false".equals(strA);
                        g.this.f2191a.setNetworkDevinfo();
                    }
                }
            });
            return false;
        } catch (Throwable th) {
            SSDKLog.b().b(th);
            return false;
        }
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        try {
            if ("TencentWeibo".equals(this.f2191a.getName())) {
                SSDKLog.b().c("user id %s ==>>", g().getUserName());
                sb.append(Data.urlEncode(g().getUserName(), "utf-8"));
            } else {
                sb.append(Data.urlEncode(g().getUserId(), "utf-8"));
            }
            sb.append("|");
            sb.append(Data.urlEncode(g().get("secretType"), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(g().get("gender"), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(g().get("birthday"), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(g().get("educationJSONArrayStr"), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(g().get("workJSONArrayStr"), "utf-8"));
        } catch (Throwable th) {
            SSDKLog.b().b(th);
        }
        return sb.toString();
    }

    public boolean d() {
        return this.b.isValid();
    }

    public boolean e() {
        return this.f2192f;
    }

    public boolean f() {
        return this.f2194h;
    }

    public PlatformDb g() {
        return this.b;
    }

    public void h() {
        this.b.removeAccount();
    }

    public PlatformActionListener i() {
        return this.c;
    }

    public PlatformActionListener c() {
        return this.c.a();
    }

    public String d(String str) {
        return ShareSDK.a(str);
    }

    public int b() {
        return this.e;
    }

    public void c(final int i5, final Object obj) {
        new Thread(a(i5)) { // from class: cn.sharesdk.framework.g.5
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    if (!MobSDK.isForb() && a.a()) {
                        try {
                            int iIsAuth = MobSDK.isAuth();
                            if (iIsAuth == 1 || iIsAuth == 2) {
                                g.this.j();
                                SSDKLog.b().a("The user is using the privacy version without a popup newThreadJob 001");
                            }
                        } catch (Throwable th) {
                            g.this.j();
                            SSDKLog.b().a("The user is using the version before going to the second pop-up box newThreadJob 001 " + th);
                        }
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a("newThreadJob  " + th2);
                }
            }
        }.start();
        new Thread() { // from class: cn.sharesdk.framework.g.6
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    if (MobSDK.isForb()) {
                        g gVar = g.this;
                        gVar.a(gVar.c, i5);
                        return;
                    }
                    try {
                        try {
                            int iIsAuth = MobSDK.isAuth();
                            if (iIsAuth == 1 || iIsAuth == 2) {
                                if (!a.a()) {
                                    g gVar2 = g.this;
                                    gVar2.b(gVar2.c, i5);
                                } else if (g.this.f2191a.checkAuthorize(i5, obj)) {
                                    g.this.b(i5, obj);
                                    SSDKLog.b().a("The user is using the privacy version without a popup newThreadJob 002");
                                }
                            } else if (g.this.c != null) {
                                g.this.c.onError(g.this.f2191a, i5, new PolicyThrowable());
                            }
                        } catch (Throwable th) {
                            if (!a.a()) {
                                g gVar3 = g.this;
                                gVar3.b(gVar3.c, i5);
                            } else if (g.this.f2191a.checkAuthorize(i5, obj)) {
                                g.this.b(i5, obj);
                            }
                            SSDKLog.b().a("The user is using the non-privacy version newThreadJob 002 " + th);
                        }
                    } catch (Throwable unused) {
                        ProvicyCanContinue.a().a(new ProvicyCanContinue.OnBusinessListener() { // from class: cn.sharesdk.framework.g.6.1
                            @Override // cn.sharesdk.framework.ProvicyCanContinue.OnBusinessListener
                            public void onContinue() {
                                if (a.a()) {
                                    Platform platform = g.this.f2191a;
                                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                    if (platform.checkAuthorize(i5, obj)) {
                                        AnonymousClass6 anonymousClass7 = AnonymousClass6.this;
                                        g.this.b(i5, obj);
                                    }
                                } else {
                                    g gVar4 = g.this;
                                    gVar4.b(gVar4.c, i5);
                                }
                                SSDKLog.b().a("The user is using the framed privacy version newThreadJob 002");
                            }

                            @Override // cn.sharesdk.framework.ProvicyCanContinue.OnBusinessListener
                            public void onError(Throwable th2) {
                                if (g.this.c != null) {
                                    g.this.c.onError(g.this.f2191a, i5, th2);
                                }
                            }

                            @Override // cn.sharesdk.framework.ProvicyCanContinue.OnBusinessListener
                            public void onStop() {
                                if (g.this.c != null) {
                                    g.this.c.onError(g.this.f2191a, i5, new PolicyThrowable());
                                }
                            }
                        });
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(androidx.exifinterface.media.a.n("new Thread(getThreadName(action)) ", th2), new Object[0]);
                }
            }
        }.start();
    }

    private String b(int i5) {
        if (i5 == 1) {
            return "ACTION_AUTHORIZING";
        }
        if (i5 != 2) {
            switch (i5) {
                case 5:
                    return "ACTION_SENDING_DIRECT_MESSAGE";
                case 6:
                    return "ACTION_FOLLOWING_USER";
                case 7:
                    return "ACTION_TIMELINE";
                case 8:
                    return "ACTION_USER_INFOR";
                case 9:
                    return "ACTION_SHARE";
                case 10:
                    return "ACTION_GETTING_BILATERAL_LIST";
                case 11:
                    return "ACTION_GETTING_FOLLOWER_LIST";
                default:
                    return "ACTION_CUSTOMER";
            }
        }
        return "ACTION_GETTING_FRIEND_LIST";
    }

    public void a(String str) {
        try {
            this.d = ResHelper.parseInt(String.valueOf(ShareSDK.getDevinfo(str, PackageRelationship.ID_ATTRIBUTE_NAME)).trim());
        } catch (Throwable unused) {
            if (!(this.f2191a instanceof CustomPlatform)) {
                SSDKLog.b().a(this.f2191a.getName() + " failed to parse Id, this will cause method getId() always returens 0", new Object[0]);
            }
        }
        try {
            this.e = ResHelper.parseInt(String.valueOf(ShareSDK.getDevinfo(str, "SortId")).trim());
        } catch (Throwable unused2) {
            if (!(this.f2191a instanceof CustomPlatform)) {
                SSDKLog.b().a(this.f2191a.getName() + " failed to parse SortId, this won't cause any problem, don't worry", new Object[0]);
            }
        }
        String devinfo = ShareSDK.getDevinfo(str, "Enable");
        if (devinfo == null) {
            this.f2194h = true;
            if (!(this.f2191a instanceof CustomPlatform)) {
                SSDKLog.b().a(this.f2191a.getName() + " failed to parse Enable, this will cause platform always be enable", new Object[0]);
            }
        } else {
            this.f2194h = "true".equals(devinfo.trim());
        }
        this.f2191a.initDevInfo(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Platform.ShareParams shareParams) {
        try {
            if (shareParams == null) {
                e eVar = this.c;
                if (eVar != null) {
                    eVar.onError(this.f2191a, 9, new NullPointerException());
                    return;
                }
                return;
            }
            try {
                if (!shareParams.getOpenCustomEven()) {
                    ShareSDK.logDemoEvent(3, this.f2191a);
                }
            } catch (Throwable unused) {
            }
            c(9, shareParams);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
    }

    public void c(String str) {
        c(8, str);
    }

    public void b(int i5, Object obj) {
        if (i5 == 1) {
            e eVar = this.c;
            if (eVar != null) {
                eVar.onComplete(this.f2191a, 1, null);
                return;
            }
            return;
        }
        if (i5 != 2) {
            switch (i5) {
                case 6:
                    this.f2191a.follow((String) obj);
                    break;
                case 7:
                    Object[] objArr = (Object[]) obj;
                    this.f2191a.timeline(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), (String) objArr[2]);
                    break;
                case 8:
                    this.f2191a.userInfor(obj != null ? (String) obj : null);
                    break;
                case 9:
                    final Platform.ShareParams shareParams = (Platform.ShareParams) obj;
                    if (this.c != null) {
                        this.c.a(this.f2191a, shareParams);
                    }
                    try {
                        if (shareParams.getLoopshareCustomParams().size() > 0 && shareParams.getLoopshareCustomParams() != null) {
                            if (this.f2191a.getName().equals("QQ")) {
                                if (!TextUtils.isEmpty(shareParams.getTitleUrl())) {
                                    ShareSDK.mobLinkGetMobID(shareParams.getLoopshareCustomParams(), new MoblinkActionListener() { // from class: cn.sharesdk.framework.g.3
                                        @Override // cn.sharesdk.framework.loopshare.MoblinkActionListener
                                        public void onError(Throwable th) {
                                            if (g.this.c != null) {
                                                g.this.c.onError(g.this.f2191a, 9, th);
                                            }
                                        }

                                        @Override // cn.sharesdk.framework.loopshare.MoblinkActionListener
                                        public void onResult(Object obj2) {
                                            if (TextUtils.isEmpty(Uri.parse(shareParams.getTitleUrl()).getEncodedQuery())) {
                                                shareParams.setTitleUrl(shareParams.getTitleUrl() + "?mobid=" + obj2);
                                            } else {
                                                shareParams.setTitleUrl(shareParams.getTitleUrl() + "&mobid=" + obj2);
                                            }
                                            new Thread() { // from class: cn.sharesdk.framework.g.3.1
                                                @Override // java.lang.Thread, java.lang.Runnable
                                                public void run() {
                                                    super.run();
                                                    g.this.f2191a.doShare(shareParams);
                                                }
                                            }.start();
                                        }
                                    });
                                } else if (this.c != null) {
                                    this.c.onError(this.f2191a, 9, new Throwable("TitleUrl cannot be empty if setLoopshareCustomParams is used in QQ"));
                                }
                            } else if (!TextUtils.isEmpty(shareParams.getUrl())) {
                                if (this.c != null) {
                                    ShareSDK.mobLinkGetMobID(shareParams.getLoopshareCustomParams(), new MoblinkActionListener() { // from class: cn.sharesdk.framework.g.4
                                        @Override // cn.sharesdk.framework.loopshare.MoblinkActionListener
                                        public void onError(Throwable th) {
                                            if (g.this.c != null) {
                                                g.this.c.onError(g.this.f2191a, 9, th);
                                            }
                                        }

                                        @Override // cn.sharesdk.framework.loopshare.MoblinkActionListener
                                        public void onResult(Object obj2) {
                                            if (TextUtils.isEmpty(Uri.parse(shareParams.getUrl()).getEncodedQuery())) {
                                                shareParams.setUrl(shareParams.getUrl() + "?mobid=" + obj2);
                                            } else {
                                                shareParams.setUrl(shareParams.getUrl() + "&mobid=" + obj2);
                                            }
                                            new Thread() { // from class: cn.sharesdk.framework.g.4.1
                                                @Override // java.lang.Thread, java.lang.Runnable
                                                public void run() {
                                                    super.run();
                                                    g.this.f2191a.doShare(shareParams);
                                                }
                                            }.start();
                                        }
                                    });
                                }
                            } else if (this.c != null) {
                                this.c.onError(this.f2191a, 9, new Throwable("SetUrl cannot be empty if setLoopshareCustomParams is used"));
                            }
                        } else {
                            this.f2191a.doShare(shareParams);
                        }
                    } catch (Throwable th) {
                        SSDKLog.b().a(androidx.exifinterface.media.a.n("PlatformImpl platform.doshare() ", th), new Object[0]);
                        return;
                    }
                    break;
                default:
                    Object[] objArr2 = (Object[]) obj;
                    this.f2191a.doCustomerProtocol(String.valueOf(objArr2[0]), String.valueOf(objArr2[1]), i5, (HashMap) objArr2[2], (HashMap) objArr2[3]);
                    break;
            }
            return;
        }
        Object[] objArr3 = (Object[]) obj;
        this.f2191a.getFriendList(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue(), (String) objArr3[2]);
    }

    public int a() {
        return this.d;
    }

    public void a(PlatformActionListener platformActionListener) {
        this.c.a(platformActionListener);
    }

    public void a(boolean z6) {
        this.f2192f = z6;
    }

    private String a(int i5) {
        return "ShareSDK_" + this.f2191a.getName() + "_" + b(i5);
    }

    public String a(int i5, String str, String str2) {
        String strA = ShareSDK.a(i5, str);
        if (!TextUtils.isEmpty(strA) && !AbstractC1127c.NULL.equals(strA)) {
            return strA;
        }
        Platform platform = this.f2191a;
        return platform.getDevinfo(platform.getName(), str2);
    }

    public void a(int i5, Object obj) {
        this.c.a(this.f2191a, i5, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, int i5) {
        if (eVar != null) {
            eVar.onError(this.f2191a, i5, new ForbThrowable());
        }
    }

    public void a(final Platform.ShareParams shareParams) {
        if (shareParams == null) {
            e eVar = this.c;
            if (eVar != null) {
                eVar.onError(this.f2191a, 9, new NullPointerException());
                return;
            }
            return;
        }
        new Thread(a(1)) { // from class: cn.sharesdk.framework.g.7
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    g.this.f2191a.subscribeAuth(shareParams);
                    SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, "subscribeAuth start on PlatformImpl");
                } catch (Throwable th) {
                    SSDKLog.b().a(OnekeyShare.SHARESDK_TAG, androidx.exifinterface.media.a.n(" subscribeAuth catch ", th));
                }
            }
        }.start();
    }

    public void a(final String[] strArr) {
        try {
            if (MobSDK.isGppVer() && !cn.sharesdk.framework.a.a.e.a().i("no_use_gpp")) {
                if (!cn.sharesdk.framework.a.a.e.a().i("gpp_ver_sent")) {
                    AgreementDialog agreementDialog = new AgreementDialog();
                    agreementDialog.setShareParam(new AgreementDialog.OnDialogDismiss() { // from class: cn.sharesdk.framework.g.8
                        @Override // cn.sharesdk.framework.AgreementDialog.OnDialogDismiss
                        public void consent() {
                            cn.sharesdk.framework.a.a.e.a().a(true);
                            g.this.b(strArr);
                        }

                        @Override // cn.sharesdk.framework.AgreementDialog.OnDialogDismiss
                        public void refuse() {
                            if (g.this.c != null) {
                                g.this.c.onError(g.this.f2191a, 21, null);
                            }
                        }
                    });
                    agreementDialog.show(MobSDK.getContext(), null);
                    return;
                }
                b(strArr);
                return;
            }
            b(strArr);
        } catch (Throwable th) {
            SSDKLog.b().b(th);
            b(strArr);
        }
    }

    public void a(String str, int i5, int i6) {
        c(7, new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), str});
    }

    public void a(int i5, int i6, String str) {
        c(2, new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), str});
    }

    public void a(String str, String str2, short s6, HashMap<String, Object> map, HashMap<String, String> map2) {
        c(s6 | 655360, new Object[]{str, str2, map, map2});
    }

    public void a(String str, boolean z6, ShareSDKCallback<String> shareSDKCallback) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.f2193g) {
            SSDKLog.b().b("getShortLintk use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(str);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            SSDKLog.b().b("getShortLintk use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback(str);
                return;
            }
            return;
        }
        ShareSDK.a(str, z6, this.f2191a.getPlatformId(), k(), shareSDKCallback);
        SSDKLog.b().b("getShortLintk use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar, int i5) {
        if (eVar != null) {
            eVar.onError(this.f2191a, i5, new Throwable("'appkey' is illegal"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String[] strArr) {
        new Thread(a(1)) { // from class: cn.sharesdk.framework.g.9
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    if (!MobSDK.isForb() && a.a()) {
                        try {
                            int iIsAuth = MobSDK.isAuth();
                            if (iIsAuth == 1 || iIsAuth == 2) {
                                g.this.j();
                                SSDKLog.b().a("The user is using the privacy version without a popup authorize 001");
                            }
                        } catch (Throwable th) {
                            g.this.j();
                            SSDKLog.b().a("The user is using the version before going to the second pop-up box authorize 001 " + th);
                        }
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(androidx.exifinterface.media.a.n("authorize(final String[] permissions) ", th2), new Object[0]);
                }
            }
        }.start();
        new Thread() { // from class: cn.sharesdk.framework.g.10
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    if (MobSDK.isForb()) {
                        g gVar = g.this;
                        gVar.a(gVar.c, 1);
                        return;
                    }
                    try {
                        try {
                            int iIsAuth = MobSDK.isAuth();
                            if (iIsAuth == 1 || iIsAuth == 2) {
                                if (a.a()) {
                                    g.this.f2191a.doAuthorize(strArr);
                                } else {
                                    g gVar2 = g.this;
                                    gVar2.b(gVar2.c, 1);
                                }
                            } else if (g.this.c != null) {
                                g.this.c.onError(g.this.f2191a, 1, new PolicyThrowable());
                            }
                        } catch (Throwable th) {
                            if (a.a()) {
                                g.this.f2191a.doAuthorize(strArr);
                            } else {
                                g gVar3 = g.this;
                                gVar3.b(gVar3.c, 1);
                            }
                            SSDKLog.b().a("The user is using the non-privacy version authorize 002 " + th);
                        }
                    } catch (Throwable unused) {
                        ProvicyCanContinue.a().a(new ProvicyCanContinue.OnBusinessListener() { // from class: cn.sharesdk.framework.g.10.1
                            @Override // cn.sharesdk.framework.ProvicyCanContinue.OnBusinessListener
                            public void onContinue() {
                                if (a.a()) {
                                    g.this.f2191a.doAuthorize(strArr);
                                } else {
                                    g gVar4 = g.this;
                                    gVar4.b(gVar4.c, 1);
                                }
                                SSDKLog.b().a("The user is using the privacy version with a pop-up box authorize 002");
                            }

                            @Override // cn.sharesdk.framework.ProvicyCanContinue.OnBusinessListener
                            public void onError(Throwable th2) {
                                if (g.this.c != null) {
                                    g.this.c.onError(g.this.f2191a, 1, new PolicyThrowable());
                                }
                            }

                            @Override // cn.sharesdk.framework.ProvicyCanContinue.OnBusinessListener
                            public void onStop() {
                                if (g.this.c != null) {
                                    g.this.c.onError(g.this.f2191a, 1, new PolicyThrowable());
                                }
                            }
                        });
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(androidx.exifinterface.media.a.n("new Thread Platform.ACTION_AUTHORIZING ", th2), new Object[0]);
                }
            }
        }.start();
    }

    public String a(Bitmap bitmap) {
        return ShareSDK.a(bitmap);
    }

    public String a(String str, boolean z6, HashMap<String, String> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.f2193g) {
            SSDKLog.b().b("getShortLintk use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            SSDKLog.b().b("getShortLintk use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return str;
        }
        String strA = cn.sharesdk.framework.a.a.a().a(str, this.f2191a.getPlatformId(), z6, k(), map);
        SSDKLog.b().b("getShortLintk use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return strA;
    }

    public void b(final Platform.ShareParams shareParams) {
        try {
            if (MobSDK.isGppVer() && !cn.sharesdk.framework.a.a.e.a().i("no_use_gpp")) {
                if (!cn.sharesdk.framework.a.a.e.a().i("gpp_ver_sent")) {
                    AgreementDialog agreementDialog = new AgreementDialog();
                    agreementDialog.setShareParam(new AgreementDialog.OnDialogDismiss() { // from class: cn.sharesdk.framework.g.2
                        @Override // cn.sharesdk.framework.AgreementDialog.OnDialogDismiss
                        public void consent() {
                            cn.sharesdk.framework.a.a.e.a().a(true);
                            g.this.c(shareParams);
                        }

                        @Override // cn.sharesdk.framework.AgreementDialog.OnDialogDismiss
                        public void refuse() {
                            if (g.this.c != null) {
                                g.this.c.onError(g.this.f2191a, 21, new Throwable("The user rejected the request to read the applist"));
                            }
                        }
                    });
                    agreementDialog.show(MobSDK.getContext(), null);
                    return;
                }
                c(shareParams);
                return;
            }
            c(shareParams);
        } catch (Throwable unused) {
            c(shareParams);
        }
    }

    public void b(String str) {
        c(6, str);
    }
}
