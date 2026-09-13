package org.apache.logging.log4j.util;

import java.lang.reflect.Method;
import org.apache.logging.log4j.LoggingException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Base64Util {
    private static Method encodeMethod;
    private static Object encoder;

    static {
        try {
            try {
                Class<?> clsLoadClass = LoaderUtil.loadClass("java.util.Base64");
                Class<?> clsLoadClass2 = LoaderUtil.loadClass("java.util.Base64$Encoder");
                encoder = clsLoadClass.getMethod("getEncoder", null).invoke(null, null);
                encodeMethod = clsLoadClass2.getMethod("encodeToString", byte[].class);
            } catch (Exception unused) {
                encodeMethod = LoaderUtil.loadClass("javax.xml.bind.DataTypeConverter").getMethod("printBase64Binary", null);
            }
        } catch (Exception e) {
            LowLevelLogUtil.logException("Unable to create a Base64 Encoder", e);
        }
    }

    private Base64Util() {
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        Method method = encodeMethod;
        if (method == null) {
            throw new LoggingException("No Encoder, unable to encode string");
        }
        try {
            return (String) method.invoke(encoder, bytes);
        } catch (Exception e) {
            throw new LoggingException("Unable to encode String", e);
        }
    }
}
