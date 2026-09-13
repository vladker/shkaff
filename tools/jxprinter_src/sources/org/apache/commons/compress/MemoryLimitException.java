package org.apache.commons.compress;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MemoryLimitException extends IOException {
    private static final long serialVersionUID = 1;
    private final int memoryLimitInKb;
    private final long memoryNeededInKb;

    public MemoryLimitException(long j6, int i5) {
        super(buildMessage(j6, i5));
        this.memoryNeededInKb = j6;
        this.memoryLimitInKb = i5;
    }

    private static String buildMessage(long j6, int i5) {
        return j6 + " kb of memory would be needed; limit was " + i5 + " kb. If the file is not corrupt, consider increasing the memory limit.";
    }

    public int getMemoryLimitInKb() {
        return this.memoryLimitInKb;
    }

    public long getMemoryNeededInKb() {
        return this.memoryNeededInKb;
    }

    public MemoryLimitException(long j6, int i5, Exception exc) {
        super(buildMessage(j6, i5), exc);
        this.memoryNeededInKb = j6;
        this.memoryLimitInKb = i5;
    }
}
