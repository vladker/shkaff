package org.apache.commons.compress.archivers.zip;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface UnixStat {
    public static final int DEFAULT_DIR_PERM = 493;
    public static final int DEFAULT_FILE_PERM = 420;
    public static final int DEFAULT_LINK_PERM = 511;
    public static final int DIR_FLAG = 16384;
    public static final int FILE_FLAG = 32768;
    public static final int FILE_TYPE_FLAG = 61440;
    public static final int LINK_FLAG = 40960;
    public static final int PERM_MASK = 4095;
}
