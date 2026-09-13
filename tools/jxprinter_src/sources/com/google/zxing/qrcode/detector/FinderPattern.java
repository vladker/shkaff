package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class FinderPattern extends ResultPoint {
    private final int count;
    private final float estimatedModuleSize;

    public FinderPattern(float f6, float f7, float f8) {
        this(f6, f7, f8, 1);
    }

    public boolean aboutEquals(float f6, float f7, float f8) {
        if (Math.abs(f7 - getY()) > f6 || Math.abs(f8 - getX()) > f6) {
            return false;
        }
        float fAbs = Math.abs(f6 - this.estimatedModuleSize);
        return fAbs <= 1.0f || fAbs <= this.estimatedModuleSize;
    }

    public FinderPattern combineEstimate(float f6, float f7, float f8) {
        int i5 = this.count;
        int i6 = i5 + 1;
        float x6 = (getX() * i5) + f7;
        float f9 = i6;
        return new FinderPattern(x6 / f9, ((getY() * this.count) + f6) / f9, ((this.count * this.estimatedModuleSize) + f8) / f9, i6);
    }

    public int getCount() {
        return this.count;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    private FinderPattern(float f6, float f7, float f8, int i5) {
        super(f6, f7);
        this.estimatedModuleSize = f8;
        this.count = i5;
    }
}
