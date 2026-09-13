package cn.fly.commons.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.fly.commons.x;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f1324a;

    /* JADX INFO: renamed from: cn.fly.commons.c.e$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1326a;

        static {
            int[] iArr = new int[a.values().length];
            f1326a = iArr;
            try {
                iArr[a.XIAOMI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1326a[a.REDMI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1326a[a.MEITU.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1326a[a.BLACKSHARK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1326a[a.IQOO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1326a[a.VIVO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1326a[a.PTAC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1326a[a.WIKO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1326a[a.TIANYI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1326a[a.CMDC.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1326a[a.TDTECH.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1326a[a.LIANTONG.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1326a[a.HUA_WEI.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1326a[a.HORNOR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1326a[a.OPPO.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1326a[a.REALME.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1326a[a.ONEPLUS.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f1326a[a.MOTO.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f1326a[a.ZUK.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f1326a[a.LENOVO.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f1326a[a.ASUS.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f1326a[a.SAMSUNG.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f1326a[a.MEIZU.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f1326a[a.MBLU.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f1326a[a.ALPS.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f1326a[a.NUBIA.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f1326a[a.ZTE.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f1326a[a.FERRMEOS.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f1326a[a.SSUI.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f1326a[a.COOLPAD.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f1326a[a.QIKU.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f1326a[a.COOSEA.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
        }
    }

    public static synchronized void a(Context context) {
        try {
            if (f1324a != null) {
                return;
            }
            a aVarA = a(context, Build.MANUFACTURER, Build.BRAND);
            if (aVarA == a.UNSUPPORT) {
                return;
            }
            switch (AnonymousClass2.f1326a[aVarA.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    f1324a = new q(context);
                    break;
                case 5:
                case 6:
                    f1324a = new p(context);
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    f1324a = new g(context);
                    break;
                case 14:
                    f1324a = new f(context);
                    break;
                case 15:
                case 16:
                    f1324a = new m(context);
                    break;
                case 17:
                    f1324a = new l(context);
                    break;
                case 18:
                case 19:
                case 20:
                    f1324a = new j(context);
                    break;
                case 21:
                    f1324a = new cn.fly.commons.c.a(context);
                    break;
                case 22:
                    f1324a = new o(context);
                    break;
                case 23:
                case 24:
                case 25:
                    f1324a = new i(context);
                    break;
                case 26:
                    f1324a = new k(context);
                    break;
                case 27:
                case 28:
                case 29:
                    f1324a = new r(context);
                    break;
                case 30:
                    f1324a = new b(context);
                    break;
                case 31:
                    f1324a = new n(context);
                    break;
                case 32:
                    f1324a = new c(context);
                    break;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static String b(Context context) {
        a(context);
        h hVar = f1324a;
        if (hVar == null) {
            return null;
        }
        if (hVar instanceof f) {
            String strD = hVar.d();
            if (!TextUtils.isEmpty(strD) && !Pattern.compile("^[0fF\\-]+").matcher(strD).matches()) {
                return strD;
            }
            f1324a = new g(context);
        } else if (hVar instanceof l) {
            String strD2 = hVar.d();
            if (!TextUtils.isEmpty(strD2) && !Pattern.compile("^[0fF\\-]+").matcher(strD2).matches()) {
                return strD2;
            }
            f1324a = new m(context);
        }
        return f1324a.d();
    }

    private static boolean c(Context context) {
        try {
            final Object[] objArr = new Object[1];
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            DH.requester(context).getMpfo(x.b("027b!cjceckObOcjcjXficGcbckcb,eQccchDbeAchcbehcfHii%cjciRh"), 0).request(new DH.DHResponder() { // from class: cn.fly.commons.c.e.1
                @Override // cn.fly.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    objArr[0] = dHResponse.getMpfo(new int[0]);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(3L, TimeUnit.SECONDS);
            return objArr[0] != null;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return false;
        }
    }

    public enum a {
        UNSUPPORT(-1, x.b("009UcfLd=ehcf,ii!cjciFh")),
        HUA_WEI(0, x.b("0065ejdjecfefhdd"), x.b("0216cicjckeecfch$f,cbckcc5eUciehchcj5d6ck+eZcecfch")),
        XIAOMI(1, x.b("006Rffch;cIcjcech"), x.b("023>cicjckcechcfchckcfchckccTeCciehchcj6dTck=dc1ceSe")),
        VIVO(2, x.b("004Yccchcccj"), x.b("018+cicjckccchcccjckcjehckcc7e:ciehchcjDd")),
        OPPO(3, x.b("004Tcj1ii2cj"), x.b("024]cicjckeecfch.f_cbckcc3e%ciehchcjZd?ckcj7ii^cjcicjce")),
        MOTO(4, x.b("008Wcecj0h*cjcicj=fc")),
        LENOVO(5, x.b("006fed=cjcccj")),
        ASUS(6, x.b("004c!ehcfeh")),
        SAMSUNG(7, x.b("007YehXcWceehcfIdTdi")),
        MEIZU(8, x.b("005Wce0e'chfccf")),
        ALPS(9, x.b("004cfi.eh")),
        NUBIA(10, x.b("005d0cfeech,c")),
        ONEPLUS(11, x.b("007Kcj8deifKcfeh")),
        BLACKSHARK(12, x.b("010Gee2fcbHdgehWgc,cidg")),
        ZTE(13, x.b("003Gfc3he")),
        FERRMEOS(14, x.b("008TdeciBee*ceIeZcjeh")),
        SSUI(15, x.b("004Rehehcfch")),
        HORNOR(16, "HONOR"),
        REALME(17, "REALME"),
        REDMI(18, "REDMI"),
        MEITU(19, "MEITU"),
        ZUK(20, "ZUK"),
        MBLU(21, "MBLU"),
        COOLPAD(22, "COOLPAD"),
        COOSEA(23, "COOSEA"),
        QIKU(24, "360OS", x.b("0185cicjckeecfch<f*cbckcfchccTe3ciehchcjYd")),
        IQOO(25, "iqoo"),
        PTAC(26, "PTAC"),
        WIKO(27, "WIKO"),
        TIANYI(28, "TIANYI"),
        CMDC(29, "CMDC"),
        TDTECH(30, "TDTECH"),
        LIANTONG(31, "LIANTONG");


        /* JADX INFO: renamed from: H, reason: collision with root package name */
        private final int f1357H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        private String f1358I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private String f1359J;

        a(int i5, String str) {
            this.f1357H = i5;
            this.f1358I = str;
        }

        a(int i5, String str, String str2) {
            this.f1357H = i5;
            this.f1358I = str;
            this.f1359J = str2;
        }
    }

    private static boolean c() {
        return "PRIZE".equalsIgnoreCase(DH.SyncMtd.getSystemProperties("ro.odm.manufacturer"));
    }

    private static boolean b() {
        String systemProperties = DH.SyncMtd.getSystemProperties(x.b("0151cicjckehehcfchck1iYcicjcbcfIbh"));
        return (TextUtils.isEmpty(systemProperties) || systemProperties.equalsIgnoreCase(x.b("0074cfMdWdg>dVcjefGd"))) ? false : true;
    }

    public static a a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            for (a aVar : a.values()) {
                if (aVar.f1358I.equalsIgnoreCase(str) || aVar.f1358I.equalsIgnoreCase(str2) || !(TextUtils.isEmpty(aVar.f1359J) || TextUtils.isEmpty(DH.SyncMtd.getSystemProperties(aVar.f1359J)))) {
                    return aVar;
                }
            }
        }
        if (!a() && !b()) {
            if (cn.fly.commons.c.a() && c(context)) {
                return a.COOLPAD;
            }
            if (c()) {
                return a.COOSEA;
            }
            return a.UNSUPPORT;
        }
        return a.ZTE;
    }

    private static boolean a() {
        String systemProperties = DH.SyncMtd.getSystemProperties(x.b("021*cicjckeecfchMfDcbckdeci+eeFceGe)ck>fc?eeTef"));
        return !TextUtils.isEmpty(systemProperties) && systemProperties.equalsIgnoreCase(x.b("008.fbfifhfhgbfhfgdk"));
    }
}
