package org.apache.logging.log4j.util;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ProcessIdUtil {
    public static final String DEFAULT_PROCESSID = "-";

    public static String getProcessId() {
        try {
            try {
                return ((String) Class.forName("java.lang.management.RuntimeMXBean").getDeclaredMethod("getName", null).invoke(Class.forName("java.lang.management.ManagementFactory").getDeclaredMethod("getRuntimeMXBean", null).invoke(null, null), null)).split("@")[0];
            } catch (Exception unused) {
                return new File("/proc/self").getCanonicalFile().getName();
            }
        } catch (IOException unused2) {
            return DEFAULT_PROCESSID;
        }
    }
}
