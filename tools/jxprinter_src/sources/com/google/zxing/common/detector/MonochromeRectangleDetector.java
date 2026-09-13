package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0020  */
    /* JADX WARN: Code duplicated, block: B:40:0x0057  */
    /* JADX WARN: Code duplicated, block: B:68:0x002b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0031 A[EDGE_INSN: B:69:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:73:0x001c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0031 A[EDGE_INSN: B:70:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:73:0x001c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0024 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0031 A[EDGE_INSN: B:72:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:73:0x001c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x001c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x001c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0068 A[EDGE_INSN: B:86:0x0068->B:47:0x0068 BREAK  A[LOOP:3: B:38:0x0053->B:91:0x0053], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0068 A[EDGE_INSN: B:88:0x0068->B:47:0x0068 BREAK  A[LOOP:3: B:38:0x0053->B:91:0x0053], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x005b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0068 A[EDGE_INSN: B:90:0x0068->B:47:0x0068 BREAK  A[LOOP:3: B:38:0x0053->B:91:0x0053], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0053 A[SYNTHETIC] */
    private int[] blackWhiteRange(int i5, int i6, int i7, int i8, boolean z6) {
        int i9;
        BitMatrix bitMatrix;
        int i10;
        BitMatrix bitMatrix2;
        int i11 = (i7 + i8) / 2;
        int i12 = i11;
        while (i12 >= i7) {
            BitMatrix bitMatrix3 = this.image;
            if (!z6) {
                if (!bitMatrix3.get(i5, i12)) {
                    i10 = i12;
                    while (true) {
                        i10--;
                        if (i10 >= i7) {
                            break;
                            break;
                        }
                        bitMatrix2 = this.image;
                        if (z6) {
                            if (bitMatrix2.get(i10, i5)) {
                                break;
                                break;
                            }
                        } else if (bitMatrix2.get(i5, i10)) {
                            break;
                            break;
                        }
                    }
                    int i13 = i12 - i10;
                    if (i10 < i7) {
                        break;
                    }
                    break;
                    break;
                }
                i12--;
            } else if (bitMatrix3.get(i12, i5)) {
                i12--;
            } else {
                i10 = i12;
                while (true) {
                    i10--;
                    if (i10 >= i7) {
                        break;
                    }
                    bitMatrix2 = this.image;
                    if (z6) {
                        if (bitMatrix2.get(i10, i5)) {
                            break;
                        }
                    } else if (bitMatrix2.get(i5, i10)) {
                        break;
                    }
                }
                int i14 = i12 - i10;
                if (i10 < i7 || i14 > i6) {
                    break;
                }
                i12 = i10;
            }
        }
        int i15 = i12 + 1;
        while (i11 < i8) {
            BitMatrix bitMatrix4 = this.image;
            if (!z6) {
                if (!bitMatrix4.get(i5, i11)) {
                    i9 = i11;
                    while (true) {
                        i9++;
                        if (i9 < i8) {
                            break;
                            break;
                        }
                        bitMatrix = this.image;
                        if (z6) {
                            if (bitMatrix.get(i9, i5)) {
                                break;
                                break;
                            }
                        } else if (bitMatrix.get(i5, i9)) {
                            break;
                            break;
                        }
                    }
                    int i16 = i9 - i11;
                    if (i9 >= i8) {
                        break;
                    }
                    break;
                    break;
                }
                i11++;
            } else if (bitMatrix4.get(i11, i5)) {
                i11++;
            } else {
                i9 = i11;
                while (true) {
                    i9++;
                    if (i9 < i8) {
                        break;
                    }
                    bitMatrix = this.image;
                    if (z6) {
                        if (bitMatrix.get(i9, i5)) {
                            break;
                        }
                    } else if (bitMatrix.get(i5, i9)) {
                        break;
                    }
                }
                int i17 = i9 - i11;
                if (i9 >= i8 || i17 > i6) {
                    break;
                }
                i11 = i9;
            }
        }
        int i18 = i11 - 1;
        if (i18 > i15) {
            return new int[]{i15, i18};
        }
        return null;
    }

    private ResultPoint findCornerFromCenter(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) throws NotFoundException {
        int[] iArr = null;
        int i14 = i5;
        int i15 = i9;
        while (i15 < i12 && i15 >= i11 && i14 < i8 && i14 >= i7) {
            int[] iArrBlackWhiteRange = i6 == 0 ? blackWhiteRange(i15, i13, i7, i8, true) : blackWhiteRange(i14, i13, i11, i12, false);
            if (iArrBlackWhiteRange == null) {
                if (iArr == null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (i6 == 0) {
                    int i16 = i15 - i10;
                    int i17 = iArr[0];
                    if (i17 >= i5) {
                        return new ResultPoint(iArr[1], i16);
                    }
                    if (iArr[1] > i5) {
                        return new ResultPoint(iArr[i10 <= 0 ? (char) 1 : (char) 0], i16);
                    }
                    return new ResultPoint(i17, i16);
                }
                int i18 = i14 - i6;
                int i19 = iArr[0];
                if (i19 >= i9) {
                    return new ResultPoint(i18, iArr[1]);
                }
                if (iArr[1] > i9) {
                    return new ResultPoint(i18, iArr[i6 >= 0 ? (char) 1 : (char) 0]);
                }
                return new ResultPoint(i18, i19);
            }
            i15 += i10;
            i14 += i6;
            iArr = iArrBlackWhiteRange;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ResultPoint[] detect() throws NotFoundException {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i5 = height / 2;
        int i6 = width / 2;
        int iMax = Math.max(1, height / 256);
        int iMax2 = Math.max(1, width / 256);
        int i7 = -iMax;
        int i8 = i6 / 2;
        int y6 = ((int) findCornerFromCenter(i6, 0, 0, width, i5, i7, 0, height, i8).getY()) - 1;
        int i9 = i5 / 2;
        ResultPoint resultPointFindCornerFromCenter = findCornerFromCenter(i6, -iMax2, 0, width, i5, 0, y6, height, i9);
        int x6 = ((int) resultPointFindCornerFromCenter.getX()) - 1;
        ResultPoint resultPointFindCornerFromCenter2 = findCornerFromCenter(i6, iMax2, x6, width, i5, 0, y6, height, i9);
        int x7 = ((int) resultPointFindCornerFromCenter2.getX()) + 1;
        ResultPoint resultPointFindCornerFromCenter3 = findCornerFromCenter(i6, 0, x6, x7, i5, iMax, y6, height, i8);
        return new ResultPoint[]{findCornerFromCenter(i6, 0, x6, x7, i5, i7, y6, ((int) resultPointFindCornerFromCenter3.getY()) + 1, i6 / 4), resultPointFindCornerFromCenter, resultPointFindCornerFromCenter2, resultPointFindCornerFromCenter3};
    }
}
