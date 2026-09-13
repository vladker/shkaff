package org.apache.logging.log4j.util;

import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Constants {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Object[] EMPTY_OBJECT_ARRAY;
    public static final boolean ENABLE_THREADLOCALS;
    public static final boolean IS_WEB_APP;
    public static final int JAVA_MAJOR_VERSION;
    public static final String LOG4J2_DEBUG = "log4j2.debug";
    public static final int MAX_REUSABLE_MESSAGE_SIZE;

    static {
        boolean booleanProperty = PropertiesUtil.getProperties().getBooleanProperty("log4j2.is.webapp", isClassAvailable("javax.servlet.Servlet") || isClassAvailable("jakarta.servlet.Servlet"));
        IS_WEB_APP = booleanProperty;
        ENABLE_THREADLOCALS = !booleanProperty && PropertiesUtil.getProperties().getBooleanProperty("log4j2.enable.threadlocals", true);
        JAVA_MAJOR_VERSION = getMajorVersion();
        MAX_REUSABLE_MESSAGE_SIZE = size("log4j.maxReusableMsgSize", Videoio.CAP_PROP_XI_LENS_FEATURE);
        EMPTY_OBJECT_ARRAY = new Object[0];
        EMPTY_BYTE_ARRAY = new byte[0];
    }

    private Constants() {
    }

    private static int getMajorVersion() {
        return getMajorVersion(System.getProperty("java.version"));
    }

    private static boolean isClassAvailable(String str) {
        try {
            return LoaderUtil.loadClass(str) != null;
        } catch (Throwable unused) {
        }
    }

    private static int size(String str, int i5) {
        return PropertiesUtil.getProperties().getIntegerProperty(str, i5);
    }

    public static int getMajorVersion(String str) {
        String[] strArrSplit = str.split("-|\\.");
        try {
            int i5 = Integer.parseInt(strArrSplit[0]);
            return i5 != 1 ? i5 : Integer.parseInt(strArrSplit[1]);
        } catch (Exception unused) {
            return 0;
        }
    }
}
