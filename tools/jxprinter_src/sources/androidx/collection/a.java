package androidx.collection;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import p147z3.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static double A(double d, double d6, double d7, double d8) {
        return (d * d6) + d7 + d8;
    }

    public static double B(double d, double d6, double d7, double d8) {
        return ((d * d6) + d7) * d8;
    }

    public static double C(double d, double d6, double d7, double d8) {
        return (d * d6 * d7) + d8;
    }

    public static double D(double d, double d6, double d7, double d8) {
        return ((d * d6) + d7) / d8;
    }

    public static double a(double d, double d6, double d7, double d8) {
        return ((d - d6) * d7) + d8;
    }

    public static float b(float f6, float f7, float f8, float f9) {
        return (f8 - (f6 * f7)) / f9;
    }

    public static int c(int i5, int i6, int i7, int i8) {
        return ((i5 * i6) / i7) + i8;
    }

    public static long d(long j6, long j7) {
        return J.m1247constructorimpl(J.m1247constructorimpl(j6) * j7);
    }

    public static Object e(ArrayList arrayList, int i5) {
        return arrayList.get(arrayList.size() - i5);
    }

    public static String f(char c, String str, StringBuilder sb) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    public static String g(int i5, int i6, String str) {
        return str.substring(i6, str.length() - i5);
    }

    public static String h(int i5, int i6, String str, String str2) {
        return str + i5 + str2 + i6;
    }

    public static String i(int i5, String str, String str2) {
        return str + i5 + str2;
    }

    public static String j(long j6, String str) {
        return str + j6;
    }

    public static String k(File file, String str) {
        return str + file;
    }

    public static String l(Object obj, String str) {
        return str + obj;
    }

    public static String m(String str, int i5, int i6, String str2, String str3) {
        return str + i5 + str2 + i6 + str3;
    }

    public static String n(String str, String str2) {
        return str + str2;
    }

    public static String o(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String p(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String q(StringBuilder sb, String str, float f6) {
        sb.append(f6);
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder r(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder s(String str, int i5, int i6, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i5);
        sb.append(str2);
        sb.append(i6);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder t(String str, long j6, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j6);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder u(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static /* synthetic */ void v(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            } else if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            } else {
                if (!(autoCloseable instanceof MediaDrm)) {
                    throw new IllegalArgumentException();
                }
                ((MediaDrm) autoCloseable).release();
                return;
            }
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z6 = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z6) {
                    executorService.shutdownNow();
                    z6 = true;
                }
            }
        }
        if (z6) {
            Thread.currentThread().interrupt();
        }
    }

    public static void w(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
    }

    public static void x(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    public static void y(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static StackTraceElement[] z() {
        return new Throwable().getStackTrace();
    }
}
