package org.apache.poi.openxml4j.util;

import java.io.File;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ZipSecureFile extends ZipFile {
    static final long DEFAULT_MAX_ENTRY_SIZE = 4294967295L;
    private final String fileName;
    private static final Logger LOG = LogManager.getLogger((Class<?>) ZipSecureFile.class);
    static double MIN_INFLATE_RATIO = 0.01d;
    static long MAX_ENTRY_SIZE = 4294967295L;
    static final long DEFAULT_MAX_TEXT_SIZE = 10485760;
    private static long MAX_TEXT_SIZE = DEFAULT_MAX_TEXT_SIZE;

    public ZipSecureFile(File file) {
        super(file);
        this.fileName = file.getAbsolutePath();
    }

    public static long getMaxEntrySize() {
        return MAX_ENTRY_SIZE;
    }

    public static long getMaxTextSize() {
        return MAX_TEXT_SIZE;
    }

    public static double getMinInflateRatio() {
        return MIN_INFLATE_RATIO;
    }

    public static void setMaxEntrySize(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("Max entry size must be greater than or equal to zero");
        }
        if (j6 > 4294967295L) {
            LOG.atWarn().log("setting max entry size greater than 4Gb can be risky; set to " + j6 + " bytes");
        }
        MAX_ENTRY_SIZE = j6;
    }

    public static void setMaxTextSize(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("Max text size must be greater than or equal to zero");
        }
        if (j6 > DEFAULT_MAX_TEXT_SIZE) {
            LOG.atWarn().log("setting max text size greater than 10485760 can be risky; set to " + j6 + " chars");
        }
        MAX_TEXT_SIZE = j6;
    }

    public static void setMinInflateRatio(double d) {
        MIN_INFLATE_RATIO = d;
    }

    public String getName() {
        return this.fileName;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipFile
    public ZipArchiveThresholdInputStream getInputStream(ZipArchiveEntry zipArchiveEntry) {
        ZipArchiveThresholdInputStream zipArchiveThresholdInputStream = new ZipArchiveThresholdInputStream(super.getInputStream(zipArchiveEntry));
        zipArchiveThresholdInputStream.setEntry(zipArchiveEntry);
        return zipArchiveThresholdInputStream;
    }

    public ZipSecureFile(String str) {
        super(str);
        this.fileName = new File(str).getAbsolutePath();
    }
}
