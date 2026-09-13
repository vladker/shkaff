package org.apache.logging.log4j.util;

import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class StackLocatorUtil {
    private static volatile boolean errorLogged;
    private static StackLocator stackLocator = StackLocator.getInstance();

    private StackLocatorUtil() {
    }

    public static StackTraceElement calcLocation(String str) {
        try {
            return stackLocator.calcLocation(str);
        } catch (NoSuchElementException e) {
            if (errorLogged) {
                return null;
            }
            errorLogged = true;
            StatusLogger.getLogger().warn("Unable to locate stack trace element for {}", str, e);
            return null;
        }
    }

    @PerformanceSensitive
    public static Class<?> getCallerClass(int i5) {
        return stackLocator.getCallerClass(i5 + 1);
    }

    @PerformanceSensitive
    public static ClassLoader getCallerClassLoader(int i5) {
        Class<?> callerClass = stackLocator.getCallerClass(i5 + 1);
        if (callerClass != null) {
            return callerClass.getClassLoader();
        }
        return null;
    }

    @PerformanceSensitive
    public static Deque<Class<?>> getCurrentStackTrace() {
        return stackLocator.getCurrentStackTrace();
    }

    public static StackTraceElement getStackTraceElement(int i5) {
        return stackLocator.getStackTraceElement(i5 + 1);
    }

    @PerformanceSensitive
    public static Class<?> getCallerClass(String str) {
        return getCallerClass(str, "");
    }

    @PerformanceSensitive
    public static Class<?> getCallerClass(String str, String str2) {
        return stackLocator.getCallerClass(str, str2);
    }

    @PerformanceSensitive
    public static Class<?> getCallerClass(Class<?> cls, Predicate<Class<?>> predicate) {
        return stackLocator.getCallerClass(cls, predicate);
    }

    @PerformanceSensitive
    public static Class<?> getCallerClass(Class<?> cls) {
        return stackLocator.getCallerClass(cls);
    }
}
