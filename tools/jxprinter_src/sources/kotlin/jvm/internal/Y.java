package kotlin.jvm.internal;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractC1127c;
import p147z3.InterfaceC1927g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5691a = false;
    public static String b;

    public static Collection a(Collection collection) {
        if (!(collection instanceof P3.a) || (collection instanceof P3.b)) {
            return collection;
        }
        h(collection, "kotlin.collections.MutableCollection");
        throw null;
    }

    public static Map b(Object obj) {
        if ((obj instanceof P3.a) && !(obj instanceof P3.d)) {
            h(obj, "kotlin.collections.MutableMap");
            throw null;
        }
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            E.j(Y.class.getName(), e);
            throw e;
        }
    }

    public static void c(int i5, Object obj) {
        if (obj == null || g(i5, obj)) {
            return;
        }
        h(obj, "kotlin.jvm.functions.Function" + i5);
        throw null;
    }

    public static boolean d(String str) {
        String str2 = b;
        if (str2 != null) {
            return str2.equals(str);
        }
        if (!TextUtils.isEmpty(e("ro.miui.ui.version.name"))) {
            b = "MIUI";
        } else if (!TextUtils.isEmpty(e("ro.build.version.emui"))) {
            b = "EMUI";
        } else if (!TextUtils.isEmpty(e("ro.build.version.opporom"))) {
            b = "OPPO";
        } else if (!TextUtils.isEmpty(e("ro.vivo.os.version"))) {
            b = "VIVO";
        } else if (!TextUtils.isEmpty(e("ro.smartisan.version"))) {
            b = "SMARTISAN";
        } else if (Build.DISPLAY.toUpperCase().contains("FLYME")) {
            b = "FLYME";
        } else {
            b = Build.MANUFACTURER.toUpperCase();
        }
        return b.equals(str);
    }

    public static String e(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(str)).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                    return line;
                } catch (IOException e) {
                    e.printStackTrace();
                    return line;
                }
            } catch (IOException unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean f(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean g(int i5, Object obj) {
        int arity;
        if (obj instanceof InterfaceC1927g) {
            if (obj instanceof InterfaceC1111z) {
                arity = ((InterfaceC1111z) obj).getArity();
            } else if (obj instanceof O3.a) {
                arity = 0;
            } else if (obj instanceof O3.l) {
                arity = 1;
            } else if (obj instanceof O3.p) {
                arity = 2;
            } else if (obj instanceof O3.q) {
                arity = 3;
            } else {
                arity = obj instanceof O3.r ? 4 : -1;
            }
            if (arity == i5) {
                return true;
            }
        }
        return false;
    }

    public static void h(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(androidx.collection.a.o(obj == null ? AbstractC1127c.NULL : obj.getClass().getName(), " cannot be cast to ", str));
        E.j(Y.class.getName(), classCastException);
        throw classCastException;
    }

    public static long i(String str) {
        if (str != null && str.matches("^\\d{0,20}$")) {
            return Long.valueOf(str).longValue();
        }
        return -1L;
    }
}
