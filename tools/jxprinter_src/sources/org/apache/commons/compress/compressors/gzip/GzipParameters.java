package org.apache.commons.compress.compressors.gzip;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GzipParameters {
    private String comment;
    private String filename;
    private long modificationTime;
    private int compressionLevel = -1;
    private int operatingSystem = 255;
    private int bufferSize = 512;

    public int getBufferSize() {
        return this.bufferSize;
    }

    public String getComment() {
        return this.comment;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public String getFilename() {
        return this.filename;
    }

    public long getModificationTime() {
        return this.modificationTime;
    }

    public int getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setBufferSize(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "invalid buffer size: "));
        }
        this.bufferSize = i5;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCompressionLevel(int i5) {
        if (i5 < -1 || i5 > 9) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid gzip compression level: "));
        }
        this.compressionLevel = i5;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setModificationTime(long j6) {
        this.modificationTime = j6;
    }

    public void setOperatingSystem(int i5) {
        this.operatingSystem = i5;
    }
}
