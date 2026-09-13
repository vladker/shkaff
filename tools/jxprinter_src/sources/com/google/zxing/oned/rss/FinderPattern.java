package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class FinderPattern {
    private final ResultPoint[] resultPoints;
    private final int[] startEnd;
    private final int value;

    public FinderPattern(int i5, int[] iArr, int i6, int i7, int i8) {
        this.value = i5;
        this.startEnd = iArr;
        float f6 = i6;
        float f7 = i8;
        this.resultPoints = new ResultPoint[]{new ResultPoint(f6, f7), new ResultPoint(i7, f7)};
    }

    public boolean equals(Object obj) {
        return (obj instanceof FinderPattern) && this.value == ((FinderPattern) obj).value;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public int[] getStartEnd() {
        return this.startEnd;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}
