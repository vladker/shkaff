package org.apache.poi.ss.formula.functions;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class StatsLib {
    private StatsLib() {
    }

    public static double avedev(double[] dArr) {
        double dAbs = 0.0d;
        double d = 0.0d;
        for (double d6 : dArr) {
            d += d6;
        }
        double length = d / ((double) dArr.length);
        for (double d7 : dArr) {
            dAbs += Math.abs(d7 - length);
        }
        return dAbs / ((double) dArr.length);
    }

    public static double devsq(double[] dArr) {
        if (dArr == null || dArr.length < 1) {
            return Double.NaN;
        }
        int length = dArr.length;
        double d = 0.0d;
        for (double d6 : dArr) {
            d += d6;
        }
        double d7 = d / ((double) length);
        double d8 = 0.0d;
        for (double d9 : dArr) {
            double d10 = d9 - d7;
            d8 += d10 * d10;
        }
        if (length == 1) {
            return 0.0d;
        }
        return d8;
    }

    public static double kthLargest(double[] dArr, int i5) {
        int i6 = i5 - 1;
        if (dArr == null || dArr.length <= i6 || i6 < 0) {
            return Double.NaN;
        }
        Arrays.sort(dArr);
        return dArr[(dArr.length - i6) - 1];
    }

    public static double kthSmallest(double[] dArr, int i5) {
        int i6 = i5 - 1;
        if (dArr == null || dArr.length <= i6 || i6 < 0) {
            return Double.NaN;
        }
        Arrays.sort(dArr);
        return dArr[i6];
    }

    public static double median(double[] dArr) {
        if (dArr == null || dArr.length < 1) {
            return Double.NaN;
        }
        int length = dArr.length;
        Arrays.sort(dArr);
        int i5 = length % 2;
        int i6 = length / 2;
        return i5 == 0 ? (dArr[i6] + dArr[i6 - 1]) / 2.0d : dArr[i6];
    }

    public static double stdev(double[] dArr) {
        if (dArr == null || dArr.length <= 1) {
            return Double.NaN;
        }
        return Math.sqrt(devsq(dArr) / ((double) (dArr.length - 1)));
    }

    public static double stdevp(double[] dArr) {
        if (dArr == null || dArr.length <= 1) {
            return Double.NaN;
        }
        return Math.sqrt(devsq(dArr) / ((double) dArr.length));
    }

    public static double var(double[] dArr) {
        if (dArr == null || dArr.length <= 1) {
            return Double.NaN;
        }
        return devsq(dArr) / ((double) (dArr.length - 1));
    }

    public static double varp(double[] dArr) {
        if (dArr == null || dArr.length <= 1) {
            return Double.NaN;
        }
        return devsq(dArr) / ((double) dArr.length);
    }
}
