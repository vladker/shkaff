package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRSSReader extends OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.2f;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.45f;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    private final int[] dataCharacterCounters;
    private final int[] evenCounts;
    private final int[] oddCounts;
    private final int[] decodeFinderCounters = new int[4];
    private final float[] oddRoundingErrors = new float[4];
    private final float[] evenRoundingErrors = new float[4];

    public AbstractRSSReader() {
        int[] iArr = new int[8];
        this.dataCharacterCounters = iArr;
        this.oddCounts = new int[iArr.length / 2];
        this.evenCounts = new int[iArr.length / 2];
    }

    @Deprecated
    public static int count(int[] iArr) {
        return MathUtils.sum(iArr);
    }

    public static void decrement(int[] iArr, float[] fArr) {
        int i5 = 0;
        float f6 = fArr[0];
        for (int i6 = 1; i6 < iArr.length; i6++) {
            float f7 = fArr[i6];
            if (f7 < f6) {
                i5 = i6;
                f6 = f7;
            }
        }
        iArr[i5] = iArr[i5] - 1;
    }

    public static void increment(int[] iArr, float[] fArr) {
        int i5 = 0;
        float f6 = fArr[0];
        for (int i6 = 1; i6 < iArr.length; i6++) {
            float f7 = fArr[i6];
            if (f7 > f6) {
                i5 = i6;
                f6 = f7;
            }
        }
        iArr[i5] = iArr[i5] + 1;
    }

    public static boolean isFinderPattern(int[] iArr) {
        int i5 = iArr[0] + iArr[1];
        float f6 = i5 / ((iArr[2] + i5) + iArr[3]);
        if (f6 >= MIN_FINDER_PATTERN_RATIO && f6 <= MAX_FINDER_PATTERN_RATIO) {
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 : iArr) {
                if (i8 > i7) {
                    i7 = i8;
                }
                if (i8 < i6) {
                    i6 = i8;
                }
            }
            if (i7 < i6 * 10) {
                return true;
            }
        }
        return false;
    }

    public static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            if (OneDReader.patternMatchVariance(iArr, iArr2[i5], MAX_INDIVIDUAL_VARIANCE) < 0.2f) {
                return i5;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }

    public final int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }

    public final int[] getEvenCounts() {
        return this.evenCounts;
    }

    public final float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }

    public final int[] getOddCounts() {
        return this.oddCounts;
    }

    public final float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }
}
