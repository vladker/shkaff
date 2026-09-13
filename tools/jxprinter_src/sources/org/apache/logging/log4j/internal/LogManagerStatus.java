package org.apache.logging.log4j.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LogManagerStatus {
    private static boolean initialized = false;

    public static boolean isInitialized() {
        return initialized;
    }

    public static void setInitialized(boolean z6) {
        initialized = z6;
    }
}
