package kotlin.jvm.internal;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.util.Arrays;
import p147z3.C1930j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class E {
    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean areEqual(Double d, Double d6) {
        if (d == null) {
            return d6 == null;
        }
        return d6 != null && d.doubleValue() == d6.doubleValue();
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str.concat(" must not be null"));
        j(E.class.getName(), illegalStateException);
        throw illegalStateException;
    }

    public static void c(Object obj) {
        if (obj == null) {
            throwJavaNpe();
        }
    }

    public static void checkHasClass(String str) throws ClassNotFoundException {
        String strReplace = str.replace('/', '.');
        try {
            Class.forName(strReplace);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = new ClassNotFoundException(AbstractC0157z.o("Class ", strReplace, " is not found. Please update the Kotlin runtime to the latest version"), e);
            j(E.class.getName(), classNotFoundException);
            throw classNotFoundException;
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            throwJavaNpe(str);
        }
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        j(E.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void f(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(i(str));
        j(E.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static void g(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(i(str));
        j(E.class.getName(), illegalArgumentException);
        throw illegalArgumentException;
    }

    public static int h(int i5, int i6) {
        if (i5 < i6) {
            return -1;
        }
        return i5 == i6 ? 0 : 1;
    }

    public static String i(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = E.class.getName();
        int i5 = 0;
        while (!stackTrace[i5].getClassName().equals(name)) {
            i5++;
        }
        while (stackTrace[i5].getClassName().equals(name)) {
            i5++;
        }
        StackTraceElement stackTraceElement = stackTrace[i5];
        StringBuilder sbU = androidx.collection.a.u("Parameter specified as non-null is null: method ", stackTraceElement.getClassName(), Consts.DOT, stackTraceElement.getMethodName(), ", parameter ");
        sbU.append(str);
        return sbU.toString();
    }

    public static void j(String str, Exception exc) {
        StackTraceElement[] stackTrace = exc.getStackTrace();
        int length = stackTrace.length;
        int i5 = -1;
        for (int i6 = 0; i6 < length; i6++) {
            if (str.equals(stackTrace[i6].getClassName())) {
                i5 = i6;
            }
        }
        exc.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i5 + 1, length));
    }

    public static void k() {
        C1930j c1930j = new C1930j();
        j(E.class.getName(), c1930j);
        throw c1930j;
    }

    public static void l() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void m(String str) {
        p147z3.P p6 = new p147z3.P(AbstractC0157z.o("lateinit property ", str, " has not been initialized"));
        j(E.class.getName(), p6);
        throw p6;
    }

    public static void throwJavaNpe() {
        NullPointerException nullPointerException = new NullPointerException();
        j(E.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static boolean areEqual(Double d, double d6) {
        return d != null && d.doubleValue() == d6;
    }

    public static boolean areEqual(double d, Double d6) {
        return d6 != null && d == d6.doubleValue();
    }

    public static boolean areEqual(Float f6, Float f7) {
        if (f6 == null) {
            return f7 == null;
        }
        return f7 != null && f6.floatValue() == f7.floatValue();
    }

    public static void throwJavaNpe(String str) {
        NullPointerException nullPointerException = new NullPointerException(str);
        j(E.class.getName(), nullPointerException);
        throw nullPointerException;
    }

    public static boolean areEqual(Float f6, float f7) {
        return f6 != null && f6.floatValue() == f7;
    }

    public static boolean areEqual(float f6, Float f7) {
        return f7 != null && f6 == f7.floatValue();
    }

    public static void checkHasClass(String str, String str2) throws ClassNotFoundException {
        String strReplace = str.replace('/', '.');
        try {
            Class.forName(strReplace);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = new ClassNotFoundException(androidx.exifinterface.media.a.m("Class ", strReplace, " is not found: this code requires the Kotlin runtime of version at least ", str2), e);
            j(E.class.getName(), classNotFoundException);
            throw classNotFoundException;
        }
    }
}
