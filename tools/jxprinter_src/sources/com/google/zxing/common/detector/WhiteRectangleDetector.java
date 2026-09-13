package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x6 = resultPoint.getX();
        float y6 = resultPoint.getY();
        float x7 = resultPoint2.getX();
        float y7 = resultPoint2.getY();
        float x8 = resultPoint3.getX();
        float y8 = resultPoint3.getY();
        float x9 = resultPoint4.getX();
        float y9 = resultPoint4.getY();
        return x6 < ((float) this.width) / 2.0f ? new ResultPoint[]{new ResultPoint(x9 - 1.0f, y9 + 1.0f), new ResultPoint(x7 + 1.0f, y7 + 1.0f), new ResultPoint(x8 - 1.0f, y8 - 1.0f), new ResultPoint(x6 + 1.0f, y6 - 1.0f)} : new ResultPoint[]{new ResultPoint(x9 + 1.0f, y9 + 1.0f), new ResultPoint(x7 + 1.0f, y7 - 1.0f), new ResultPoint(x8 - 1.0f, y8 + 1.0f), new ResultPoint(x6 - 1.0f, y6 - 1.0f)};
    }

    private boolean containsBlackPoint(int i5, int i6, int i7, boolean z6) {
        if (z6) {
            while (i5 <= i6) {
                if (this.image.get(i5, i7)) {
                    return true;
                }
                i5++;
            }
            return false;
        }
        while (i5 <= i6) {
            if (this.image.get(i7, i5)) {
                return true;
            }
            i5++;
        }
        return false;
    }

    private ResultPoint getBlackPointOnSegment(float f6, float f7, float f8, float f9) {
        int iRound = MathUtils.round(MathUtils.distance(f6, f7, f8, f9));
        float f10 = iRound;
        float f11 = (f8 - f6) / f10;
        float f12 = (f9 - f7) / f10;
        for (int i5 = 0; i5 < iRound; i5++) {
            float f13 = i5;
            int iRound2 = MathUtils.round((f13 * f11) + f6);
            int iRound3 = MathUtils.round((f13 * f12) + f7);
            if (this.image.get(iRound2, iRound3)) {
                return new ResultPoint(iRound2, iRound3);
            }
        }
        return null;
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i5 = this.leftInit;
        int i6 = this.rightInit;
        int i7 = this.upInit;
        int i8 = this.downInit;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = true;
        while (z12) {
            boolean z13 = false;
            boolean zContainsBlackPoint = true;
            while (true) {
                if ((!zContainsBlackPoint && z7) || i6 >= this.width) {
                    break;
                }
                zContainsBlackPoint = containsBlackPoint(i7, i8, i6, false);
                if (zContainsBlackPoint) {
                    i6++;
                    z7 = true;
                    z13 = true;
                } else if (!z7) {
                    i6++;
                }
            }
            if (i6 < this.width) {
                boolean zContainsBlackPoint2 = true;
                while (true) {
                    if ((!zContainsBlackPoint2 && z8) || i8 >= this.height) {
                        break;
                    }
                    zContainsBlackPoint2 = containsBlackPoint(i5, i6, i8, true);
                    if (zContainsBlackPoint2) {
                        i8++;
                        z8 = true;
                        z13 = true;
                    } else if (!z8) {
                        i8++;
                    }
                }
                if (i8 < this.height) {
                    boolean zContainsBlackPoint3 = true;
                    while (true) {
                        if ((!zContainsBlackPoint3 && z9) || i5 < 0) {
                            break;
                        }
                        zContainsBlackPoint3 = containsBlackPoint(i7, i8, i5, false);
                        if (zContainsBlackPoint3) {
                            i5--;
                            z9 = true;
                            z13 = true;
                        } else if (!z9) {
                            i5--;
                        }
                    }
                    if (i5 >= 0) {
                        z12 = z13;
                        boolean zContainsBlackPoint4 = true;
                        while (true) {
                            if ((!zContainsBlackPoint4 && z11) || i7 < 0) {
                                break;
                            }
                            zContainsBlackPoint4 = containsBlackPoint(i5, i6, i7, true);
                            if (zContainsBlackPoint4) {
                                i7--;
                                z12 = true;
                                z11 = true;
                            } else if (!z11) {
                                i7--;
                            }
                        }
                        if (i7 >= 0) {
                            if (z12) {
                                z10 = true;
                            }
                        }
                    }
                }
            }
            z6 = true;
            break;
        }
        if (z6 || !z10) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i9 = i6 - i5;
        ResultPoint blackPointOnSegment = null;
        ResultPoint blackPointOnSegment2 = null;
        for (int i10 = 1; blackPointOnSegment2 == null && i10 < i9; i10++) {
            blackPointOnSegment2 = getBlackPointOnSegment(i5, i8 - i10, i5 + i10, i8);
        }
        if (blackPointOnSegment2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint blackPointOnSegment3 = null;
        for (int i11 = 1; blackPointOnSegment3 == null && i11 < i9; i11++) {
            blackPointOnSegment3 = getBlackPointOnSegment(i5, i7 + i11, i5 + i11, i7);
        }
        if (blackPointOnSegment3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint blackPointOnSegment4 = null;
        for (int i12 = 1; blackPointOnSegment4 == null && i12 < i9; i12++) {
            blackPointOnSegment4 = getBlackPointOnSegment(i6, i7 + i12, i6 - i12, i7);
        }
        if (blackPointOnSegment4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i13 = 1; blackPointOnSegment == null && i13 < i9; i13++) {
            blackPointOnSegment = getBlackPointOnSegment(i6, i8 - i13, i6 - i13, i8);
        }
        if (blackPointOnSegment != null) {
            return centerEdges(blackPointOnSegment, blackPointOnSegment2, blackPointOnSegment4, blackPointOnSegment3);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i5, int i6, int i7) throws NotFoundException {
        this.image = bitMatrix;
        int height = bitMatrix.getHeight();
        this.height = height;
        int width = bitMatrix.getWidth();
        this.width = width;
        int i8 = i5 / 2;
        int i9 = i6 - i8;
        this.leftInit = i9;
        int i10 = i6 + i8;
        this.rightInit = i10;
        int i11 = i7 - i8;
        this.upInit = i11;
        int i12 = i7 + i8;
        this.downInit = i12;
        if (i11 < 0 || i9 < 0 || i12 >= height || i10 >= width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
