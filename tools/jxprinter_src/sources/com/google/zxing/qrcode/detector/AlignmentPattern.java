package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class AlignmentPattern extends ResultPoint {
    private final float estimatedModuleSize;

    public AlignmentPattern(float f6, float f7, float f8) {
        super(f6, f7);
        this.estimatedModuleSize = f8;
    }

    public boolean aboutEquals(float f6, float f7, float f8) {
        if (Math.abs(f7 - getY()) > f6 || Math.abs(f8 - getX()) > f6) {
            return false;
        }
        float fAbs = Math.abs(f6 - this.estimatedModuleSize);
        return fAbs <= 1.0f || fAbs <= this.estimatedModuleSize;
    }

    public AlignmentPattern combineEstimate(float f6, float f7, float f8) {
        return new AlignmentPattern((getX() + f7) / 2.0f, (getY() + f6) / 2.0f, (this.estimatedModuleSize + f8) / 2.0f);
    }
}
