package cn.fly.tools.utils;

import android.text.TextUtils;
import cn.fly.commons.m;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f1970a;

    /* JADX INFO: renamed from: cn.fly.tools.utils.f$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1971a;

        static {
            int[] iArr = new int[a.values().length];
            f1971a = iArr;
            try {
                iArr[a.MIUI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1971a[a.EMUI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1971a[a.AMIGO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1971a[a.FLYME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1971a[a.LENOVO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1971a[a.ONEUI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1971a[a.COLOR_OS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1971a[a.FUNTOUCH_OS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1971a[a.EUI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1971a[a.SENSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1971a[a.GOOGLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1971a[a.SMARTISAN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1971a[a.ONEPLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1971a[a.YUNOS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1971a[a.QIHOO.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1971a[a.NUBIA.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1971a[a.LGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public enum a {
        MIUI(m.a("006Bgkfk9fBfmfhfk")),
        EMUI(m.a("006j0fi0f1hi+h>fk")),
        FLYME(m.a("005HfhFh1fkiffi")),
        ONEUI(m.a("007%hkVf1fhhkfi,gCgl")),
        COLOR_OS(m.a("004Gfm?llXfm")),
        FUNTOUCH_OS(m.a("004 fffkfffm")),
        EUI(m.a("004ihk4ff")),
        SENSE(m.a("003jke")),
        GOOGLE(m.a("006Gglfmfmgl7ih")),
        LENOVO(m.a("006ihg_fmfffm")),
        SMARTISAN(m.a("006ejTfifkiffk")),
        ONEPLUS(m.a("007JfmXghli@fihk")),
        YUNOS(m.a("005*gefi.g!fmhk")),
        QIHOO(m.a("005TfgfkXjQfmfm")),
        NUBIA(m.a("005g>fihhfk@f")),
        LGE(m.a("002i>gl")),
        AMIGO(m.a("0055jifkPgiVfk")),
        OTHER("");


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private String f1987s;

        a(String str) {
            this.f1987s = str;
        }

        public String a() {
            return this.f1987s;
        }
    }

    private f() {
    }

    public static f a() {
        if (f1970a == null) {
            synchronized (f.class) {
                try {
                    if (f1970a == null) {
                        f1970a = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1970a;
    }

    private a c() {
        if (!TextUtils.isEmpty(a("ro.miui.ui.version.code")) || !TextUtils.isEmpty(a(m.a("023?flfmfnfhfkfifkfnfifkfnffDh3flhkfkfm6gUfnPgf3fh(h"))) || !TextUtils.isEmpty(a("ro.miui.internal.storage"))) {
            return a.MIUI;
        }
        if (!TextUtils.isEmpty(a(m.a("021.flfmfnhhfifkQi1fefnff<h>flhkfkfm[g8fn*hEfhfifk"))) || !TextUtils.isEmpty(a("ro.build.hw_emui_api_level")) || !TextUtils.isEmpty(a("ro.confg.hw_systemversion"))) {
            return a.EMUI;
        }
        if (!TextUtils.isEmpty(a(m.a("026lh'flhkfkhkVkUfnhkgehkfnfihkFh fnghJiHgefhZh=fnfkTe0fm.g"))) || !TextUtils.isEmpty(a(m.a("026Hflfmfnfh-h>fkiffifnhk$hkUfi4l2hifkif@f!flfefnghDi gefh h"))) || !TextUtils.isEmpty(a(m.a("018Fflfmfngh=i9gefh<h^fn!lOfihhBiDfkhk<jhCfe")))) {
            return a.FLYME;
        }
        if (!TextUtils.isEmpty(a(m.a("024e:fmfhfnhk>f8fhhkfi-g2glfnhkUlhJglfnfefkhk0f=hh$ih"))) || !TextUtils.isEmpty(a("init.svc.health-hal-2-1-samsung"))) {
            return a.ONEUI;
        }
        if (!TextUtils.isEmpty(a(m.a("024QflfmfnhhfifkCiPfefnff1h,flhkfkfm4g1fnfm llLfmflfmfh")))) {
            return a.COLOR_OS;
        }
        if (!TextUtils.isEmpty(a(m.a("027]flfmfnfffkfffmfnfmhkfnhhfifk>iXfefnfefkhkSlif,gefnfkfe"))) || !TextUtils.isEmpty(a(m.a("018MflfmfnfffkfffmfnfmhkfnffBh$flhkfkfm:g")))) {
            return a.FUNTOUCH_OS;
        }
        if (!TextUtils.isEmpty(a(m.a("023FflfmfnRihkUfffnfl!hihfQhk!h(fnffChJflhkfkfm0g")))) {
            return a.EUI;
        }
        if (!TextUtils.isEmpty(a(m.a("022Qflfmfnhhfifk1iMfefnhkNhgZhkRh$fnff+h>flhkfkfm g")))) {
            return a.SENSE;
        }
        if (m.a("014fg_feflfmfkfejmglfmfmgl*ih").equals(a(m.a("026Rflfmfn]e6fmfhfnglfmfmgl'ihGfnBeiRfk6hgkUfkfehh8f^hkKh")))) {
            return a.GOOGLE;
        }
        if (!TextUtils.isEmpty(a(m.a("020Pflfmfnhkfh<f%fl;kKfkhkBfgLfnffUh!flhkfkfmVg")))) {
            return a.SMARTISAN;
        }
        if (!TextUtils.isEmpty(a(m.a("014Gflfmfnflfmfhfnff<h0flhkfkfm5g")))) {
            return a.ONEPLUS;
        }
        if (!TextUtils.isEmpty(a(m.a("020MflfmfnQekfPfngefi8g<fmhkfnff7h[flhkfkfmAg")))) {
            return a.YUNOS;
        }
        if (!TextUtils.isEmpty(a(m.a("018!flfmfnhhfifkNiHfefnfifkff<h@flhkfkfm_g")))) {
            return a.QIHOO;
        }
        if (!TextUtils.isEmpty(a(m.a("023Yflfmfnhhfifk-iZfefn5gKfihhfkRfSfnflfmfhfn.eWfmfeMh"))) || !TextUtils.isEmpty(a(m.a("015(flfmfnhhfifk<i?fefnflfmfhfnfkfe")))) {
            return a.NUBIA;
        }
        if (!TextUtils.isEmpty(a(m.a("021ChkgehkfnKi9gl0h;fnFiOglfhfefhfjff=hUflhkfkfm,g")))) {
            return a.LGE;
        }
        if (!TextUtils.isEmpty(a(m.a("019_flfmfnhhfifk0i'fefnfefkhkBlifIgefnfkfe"))) && a(m.a("019!flfmfnhhfifkBi:fefnfefkhk=lifTgefnfkfe")).matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return a.AMIGO;
        }
        for (a aVar : a.values()) {
            if (aVar.a().equalsIgnoreCase(DH.SyncMtd.getManufacturerForFly())) {
                return aVar;
            }
        }
        return a.OTHER;
    }

    public String b() {
        String strA;
        switch (AnonymousClass1.f1971a[c().ordinal()]) {
            case 1:
                strA = a(m.a("023 flfmfnfhfkfifkfnfifkfnff4hZflhkfkfmLg,fn.gfUfh,h"));
                break;
            case 2:
                strA = a(m.a("021%flfmfnhhfifk[iPfefnff[hKflhkfkfm6g:fn7h+fhfifk"));
                break;
            case 3:
            case 4:
                strA = a(m.a("019Aflfmfnhhfifk4i;fefnfefkhkGlifQgefnfkfe"));
                break;
            case 5:
            case 6:
                strA = a(m.a("028[flfmfnhhfifk;i3fefnff.hJflhkfkfm4g=fnfkQge3flYh-fhJhgkfi"));
                break;
            case 7:
                strA = a(m.a("024*flfmfnhhfifk_i2fefnffPh$flhkfkfm'g;fnfmNll=fmflfmfh"));
                break;
            case 8:
                strA = a(m.a("027>flfmfnfffkfffmfnfmhkfnhhfifk)i(fefnfefkhkSlifXgefnfkfe"));
                if (TextUtils.isEmpty(strA)) {
                    strA = a(m.a("018<flfmfnfffkfffmfnfmhkfnff(h?flhkfkfm+g"));
                }
                break;
            case 9:
                strA = a(m.a("023Mflfmfn5ihk[fffnfl-hihf>hkHh6fnffQh3flhkfkfmSg"));
                break;
            case 10:
                strA = a(m.a("022$flfmfnhhfifk]i@fefnhk7hg?hk6h7fnff<hRflhkfkfm@g"));
                break;
            case 11:
                strA = a(m.a("024Lflfmfnhhfifk)iSfefnff4hRflhkfkfm>gGfnfl8hihfThk h"));
                break;
            case 12:
                strA = a(m.a("020Hflfmfnhkfh_f+flGk'fkhk]fgYfnffWh]flhkfkfm!g"));
                break;
            case 13:
                strA = a(m.a("014GflfmfnflfmfhfnffZh_flhkfkfm+g"));
                break;
            case 14:
                strA = a(m.a("020MflfmfnHekfEfngefiLgFfmhkfnff?h2flhkfkfm!g"));
                break;
            case 15:
                strA = a(m.a("018Mflfmfnhhfifk(iSfefnfifkff)h4flhkfkfmPg"));
                break;
            case 16:
                strA = a(m.a("023?flfmfnhhfifkBiVfefn9gVfihhfk=fRfnflfmfhfnUe'fmfe[h"));
                if (TextUtils.isEmpty(strA)) {
                    strA = a(m.a("0151flfmfnhhfifk]iOfefnflfmfhfnfkfe"));
                }
                break;
            case 17:
                strA = a(m.a("021:hkgehkfn0iNglWh'fnKiYglfhfefhfjff$h;flhkfkfmOg"));
                break;
            default:
                strA = a(m.a("019DflfmfnhhfifkTiBfefnfefkhk1lifDgefnfkfe"));
                break;
        }
        return TextUtils.isEmpty(strA) ? a(m.a("019_flfmfnhhfifk_i+fefnfefkhk8lif$gefnfkfe")) : strA;
    }

    private String a(String str) {
        return DH.SyncMtd.getSystemProperties(str);
    }
}
