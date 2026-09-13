package org.apache.poi.util;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class TempFile {
    public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
    private static TempFileCreationStrategy strategy = new DefaultTempFileCreationStrategy();

    private TempFile() {
    }

    public static File createTempDirectory(String str) {
        return strategy.createTempDirectory(str);
    }

    public static File createTempFile(String str, String str2) {
        return strategy.createTempFile(str, str2);
    }

    public static void setTempFileCreationStrategy(TempFileCreationStrategy tempFileCreationStrategy) {
        if (tempFileCreationStrategy == null) {
            throw new IllegalArgumentException("strategy == null");
        }
        strategy = tempFileCreationStrategy;
    }
}
