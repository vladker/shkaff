package cn.sharesdk.framework.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2224a;
    private static String b;

    public static boolean a() {
        return a("MIUI");
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String b(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                try {
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                        return line;
                    } catch (IOException e) {
                        SSDKLog.b().a("CheckRomAll getProp finally catch " + e, new Object[0]);
                        return line;
                    }
                } catch (IOException e6) {
                    e = e6;
                    SSDKLog.b().a("CheckRomAll unable to read prop " + str + " ex " + e, new Object[0]);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            SSDKLog.b().a("CheckRomAll getProp finally catch " + e7, new Object[0]);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e8) {
                        SSDKLog.b().a("CheckRomAll getProp finally catch " + e8, new Object[0]);
                    }
                }
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    public static boolean a(String str) throws Throwable {
        String str2 = f2224a;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strB = b("ro.miui.ui.version.name");
        b = strB;
        if (TextUtils.isEmpty(strB)) {
            String strB2 = b("ro.build.version.emui");
            b = strB2;
            if (TextUtils.isEmpty(strB2)) {
                String strB3 = b("ro.build.version.opporom");
                b = strB3;
                if (TextUtils.isEmpty(strB3)) {
                    String strB4 = b("ro.vivo.os.version");
                    b = strB4;
                    if (TextUtils.isEmpty(strB4)) {
                        String strB5 = b("ro.smartisan.version");
                        b = strB5;
                        if (TextUtils.isEmpty(strB5)) {
                            String str3 = Build.DISPLAY;
                            b = str3;
                            if (str3.toUpperCase().contains("FLYME")) {
                                f2224a = "FLYME";
                            } else {
                                b = EnvironmentCompat.MEDIA_UNKNOWN;
                                f2224a = Build.MANUFACTURER.toUpperCase();
                            }
                        } else {
                            f2224a = "SMARTISAN";
                        }
                    } else {
                        f2224a = "VIVO";
                    }
                } else {
                    f2224a = "OPPO";
                }
            } else {
                f2224a = "EMUI";
            }
        } else {
            f2224a = "MIUI";
        }
        return f2224a.equals(str);
    }
}
