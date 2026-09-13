package org.apache.logging.log4j.util;

import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class StackLocator {
    private static final Class<?> DEFAULT_CALLER_CLASS = null;
    private static final Method GET_CALLER_CLASS_METHOD;
    private static final StackLocator INSTANCE;
    static final int JDK_7U25_OFFSET;

    static {
        int i5 = 0;
        int i6 = -1;
        Method method = null;
        try {
            Class<?> clsLoadClass = LoaderUtil.loadClass("sun.reflect.Reflection");
            Method declaredMethod = clsLoadClass.getDeclaredMethod("getCallerClass", Integer.TYPE);
            Object objInvoke = declaredMethod.invoke(null, 0);
            declaredMethod.invoke(null, 0);
            if (objInvoke == null || objInvoke != clsLoadClass) {
                i5 = -1;
            } else {
                if (declaredMethod.invoke(null, 1) == clsLoadClass) {
                    System.out.println("WARNING: Unexpected result from sun.reflect.Reflection.getCallerClass(int), adjusting offset for future calls.");
                    i5 = 1;
                }
                method = declaredMethod;
            }
            i6 = i5;
        } catch (Exception | LinkageError unused) {
            System.out.println("WARNING: sun.reflect.Reflection.getCallerClass is not supported. This will impact performance.");
        }
        GET_CALLER_CLASS_METHOD = method;
        JDK_7U25_OFFSET = i6;
        INSTANCE = new StackLocator();
    }

    private StackLocator() {
    }

    public static StackLocator getInstance() {
        return INSTANCE;
    }

    private boolean isValid(StackTraceElement stackTraceElement) {
        if (stackTraceElement.isNativeMethod()) {
            return false;
        }
        String className = stackTraceElement.getClassName();
        if (className.startsWith("sun.reflect.")) {
            return false;
        }
        String methodName = stackTraceElement.getMethodName();
        if ((className.startsWith("java.lang.reflect.") && (methodName.equals("invoke") || methodName.equals("newInstance"))) || className.startsWith("jdk.internal.reflect.")) {
            return false;
        }
        if (className.equals("java.lang.Class") && methodName.equals("newInstance")) {
            return false;
        }
        return (className.equals("java.lang.invoke.MethodHandle") && methodName.startsWith("invoke")) ? false : true;
    }

    public StackTraceElement calcLocation(String str) {
        if (str == null) {
            return null;
        }
        StackTraceElement[] stackTraceElementArrZ = androidx.collection.a.z();
        boolean z6 = false;
        for (int i5 = 0; i5 < stackTraceElementArrZ.length; i5++) {
            String className = stackTraceElementArrZ[i5].getClassName();
            if (str.equals(className)) {
                z6 = true;
            } else if (z6 && !str.equals(className)) {
                return stackTraceElementArrZ[i5];
            }
        }
        return null;
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(Class<?> cls, Predicate<Class<?>> predicate) {
        if (cls == null) {
            throw new IllegalArgumentException("sentinelClass cannot be null");
        }
        if (predicate == null) {
            throw new IllegalArgumentException("callerPredicate cannot be null");
        }
        boolean z6 = false;
        int i5 = 2;
        while (true) {
            Class<?> callerClass = getCallerClass(i5);
            if (callerClass == null) {
                return DEFAULT_CALLER_CLASS;
            }
            if (cls.equals(callerClass)) {
                z6 = true;
            } else if (z6 && predicate.test(callerClass)) {
                return callerClass;
            }
            i5++;
        }
    }

    @PerformanceSensitive
    public Deque<Class<?>> getCurrentStackTrace() {
        if (PrivateSecurityManagerStackTraceUtil.isEnabled()) {
            return PrivateSecurityManagerStackTraceUtil.getCurrentStackTrace();
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i5 = 1;
        while (true) {
            Class<?> callerClass = getCallerClass(i5);
            if (callerClass == null) {
                return arrayDeque;
            }
            arrayDeque.push(callerClass);
            i5++;
        }
    }

    public StackTraceElement getStackTraceElement(int i5) {
        int i6 = 0;
        for (StackTraceElement stackTraceElement : androidx.collection.a.z()) {
            if (isValid(stackTraceElement)) {
                if (i6 == i5) {
                    return stackTraceElement;
                }
                i6++;
            }
        }
        throw new IndexOutOfBoundsException(Integer.toString(i5));
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(int i5) {
        if (i5 >= 0) {
            Method method = GET_CALLER_CLASS_METHOD;
            if (method == null) {
                return DEFAULT_CALLER_CLASS;
            }
            try {
                return (Class) method.invoke(null, Integer.valueOf(i5 + 1 + JDK_7U25_OFFSET));
            } catch (Exception unused) {
                return DEFAULT_CALLER_CLASS;
            }
        }
        throw new IndexOutOfBoundsException(Integer.toString(i5));
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(String str, String str2) {
        boolean z6 = false;
        int i5 = 2;
        while (true) {
            Class<?> callerClass = getCallerClass(i5);
            if (callerClass != null) {
                if (str.equals(callerClass.getName())) {
                    z6 = true;
                } else if (z6 && callerClass.getName().startsWith(str2)) {
                    return callerClass;
                }
                i5++;
            } else {
                return DEFAULT_CALLER_CLASS;
            }
        }
    }

    @PerformanceSensitive
    public Class<?> getCallerClass(Class<?> cls) {
        boolean z6 = false;
        int i5 = 2;
        while (true) {
            Class<?> callerClass = getCallerClass(i5);
            if (callerClass != null) {
                if (cls.equals(callerClass)) {
                    z6 = true;
                } else if (z6) {
                    return callerClass;
                }
                i5++;
            } else {
                return Object.class;
            }
        }
    }
}
