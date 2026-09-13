package org.apache.logging.log4j.util;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class LowLevelLogUtil {
    private static PrintWriter writer = new PrintWriter((OutputStream) System.err, true);

    private LowLevelLogUtil() {
    }

    public static void log(String str) {
        if (str != null) {
            writer.println(str);
        }
    }

    public static void logException(Throwable th) {
        if (th != null) {
            th.printStackTrace(writer);
        }
    }

    public static void setOutputStream(OutputStream outputStream) {
        Objects.requireNonNull(outputStream);
        writer = new PrintWriter(outputStream, true);
    }

    public static void setWriter(Writer writer2) {
        Objects.requireNonNull(writer2);
        writer = new PrintWriter(writer2, true);
    }

    public static void logException(String str, Throwable th) {
        log(str);
        logException(th);
    }
}
