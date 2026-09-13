package com.zlylib.fileselectorlib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FileSizeUtil {
    public static final int SIZETYPE_B = 1;
    public static final int SIZETYPE_GB = 4;
    public static final int SIZETYPE_KB = 2;
    public static final int SIZETYPE_MB = 3;
    private static final String TAG = "FileSizeUtil";

    private static String FormetFileSize(long j6) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j6 == 0) {
            return "0B";
        }
        if (j6 < 1024) {
            return decimalFormat.format(j6) + "B";
        }
        if (j6 < 1048576) {
            return decimalFormat.format(j6 / 1024.0d) + "KB";
        }
        if (j6 < 1073741824) {
            return decimalFormat.format(j6 / 1048576.0d) + "MB";
        }
        return decimalFormat.format(j6 / 1.073741824E9d) + "GB";
    }

    public static String getAutoFileOrFilesSize(File file) {
        long fileSizes;
        try {
            fileSizes = file.isDirectory() ? getFileSizes(file) : file.length();
        } catch (Exception e) {
            e.printStackTrace();
            fileSizes = 0;
        }
        return FormetFileSize(fileSizes);
    }

    public static double getFileOrFilesSize(String str, int i5) {
        long fileSizes;
        File file = new File(str);
        try {
            fileSizes = file.isDirectory() ? getFileSizes(file) : getFileSize(file);
        } catch (Exception e) {
            e.printStackTrace();
            fileSizes = 0;
        }
        return FormetFileSize(fileSizes, i5);
    }

    private static long getFileSize(File file) throws IOException {
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        file.createNewFile();
        return 0L;
    }

    private static long getFileSizes(File file) {
        File[] fileArrListFiles = file.listFiles();
        long fileSizes = 0;
        for (int i5 = 0; i5 < fileArrListFiles.length; i5++) {
            fileSizes += fileArrListFiles[i5].isDirectory() ? getFileSizes(fileArrListFiles[i5]) : getFileSize(fileArrListFiles[i5]);
        }
        return fileSizes;
    }

    private static double FormetFileSize(long j6, int i5) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (i5 == 1) {
            return Double.valueOf(decimalFormat.format(j6)).doubleValue();
        }
        if (i5 == 2) {
            return Double.valueOf(decimalFormat.format(j6 / 1024.0d)).doubleValue();
        }
        if (i5 == 3) {
            return Double.valueOf(decimalFormat.format(j6 / 1048576.0d)).doubleValue();
        }
        if (i5 != 4) {
            return 0.0d;
        }
        return Double.valueOf(decimalFormat.format(j6 / 1.073741824E9d)).doubleValue();
    }
}
