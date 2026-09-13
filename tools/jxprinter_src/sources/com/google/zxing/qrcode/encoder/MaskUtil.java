package com.google.zxing.qrcode.encoder;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class MaskUtil {

    /* JADX INFO: renamed from: N1, reason: collision with root package name */
    private static final int f3524N1 = 3;

    /* JADX INFO: renamed from: N2, reason: collision with root package name */
    private static final int f3525N2 = 3;

    /* JADX INFO: renamed from: N3, reason: collision with root package name */
    private static final int f3526N3 = 40;

    /* JADX INFO: renamed from: N4, reason: collision with root package name */
    private static final int f3527N4 = 10;

    private MaskUtil() {
    }

    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z6) {
        int height = z6 ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z6 ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i5 = 0;
        for (int i6 = 0; i6 < height; i6++) {
            byte b = -1;
            int i7 = 0;
            for (int i8 = 0; i8 < width; i8++) {
                byte b6 = z6 ? array[i6][i8] : array[i8][i6];
                if (b6 == b) {
                    i7++;
                } else {
                    if (i7 >= 5) {
                        i5 += i7 - 2;
                    }
                    i7 = 1;
                    b = b6;
                }
            }
            if (i7 >= 5) {
                i5 = (i7 - 2) + i5;
            }
        }
        return i5;
    }

    public static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i5 = 0;
        for (int i6 = 0; i6 < height - 1; i6++) {
            int i7 = 0;
            while (i7 < width - 1) {
                byte[] bArr = array[i6];
                byte b = bArr[i7];
                int i8 = i7 + 1;
                if (b == bArr[i8]) {
                    byte[] bArr2 = array[i6 + 1];
                    if (b == bArr2[i7] && b == bArr2[i8]) {
                        i5++;
                    }
                }
                i7 = i8;
            }
        }
        return i5 * 3;
    }

    public static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i5 = 0;
        for (int i6 = 0; i6 < height; i6++) {
            for (int i7 = 0; i7 < width; i7++) {
                byte[] bArr = array[i6];
                int i8 = i7 + 6;
                if (i8 < width && bArr[i7] == 1 && bArr[i7 + 1] == 0 && bArr[i7 + 2] == 1 && bArr[i7 + 3] == 1 && bArr[i7 + 4] == 1 && bArr[i7 + 5] == 0 && bArr[i8] == 1 && (isWhiteHorizontal(bArr, i7 - 4, i7) || isWhiteHorizontal(bArr, i7 + 7, i7 + 11))) {
                    i5++;
                }
                int i9 = i6 + 6;
                if (i9 < height && array[i6][i7] == 1 && array[i6 + 1][i7] == 0 && array[i6 + 2][i7] == 1 && array[i6 + 3][i7] == 1 && array[i6 + 4][i7] == 1 && array[i6 + 5][i7] == 0 && array[i9][i7] == 1 && (isWhiteVertical(array, i7, i6 - 4, i6) || isWhiteVertical(array, i7, i6 + 7, i6 + 11))) {
                    i5++;
                }
            }
        }
        return i5 * 40;
    }

    public static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i5 = 0;
        for (int i6 = 0; i6 < height; i6++) {
            byte[] bArr = array[i6];
            for (int i7 = 0; i7 < width; i7++) {
                if (bArr[i7] == 1) {
                    i5++;
                }
            }
        }
        int width2 = byteMatrix.getWidth() * byteMatrix.getHeight();
        return ((Math.abs((i5 << 1) - width2) * 10) / width2) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:16:0x003e A[RETURN] */
    public static boolean getDataMaskBit(int i5, int i6, int i7) {
        int i8;
        switch (i5) {
            case 0:
                i7 += i6;
                i8 = i7 & 1;
                if (i8 == 0) {
                    return true;
                }
                return false;
            case 1:
                i8 = i7 & 1;
                if (i8 == 0) {
                    return true;
                }
                return false;
            case 2:
                i8 = i6 % 3;
                if (i8 == 0) {
                    return true;
                }
                return false;
            case 3:
                i8 = (i7 + i6) % 3;
                if (i8 == 0) {
                    return true;
                }
                return false;
            case 4:
                i8 = ((i6 / 3) + (i7 / 2)) & 1;
                if (i8 == 0) {
                    return true;
                }
                return false;
            case 5:
                int i9 = i7 * i6;
                i8 = (i9 & 1) + (i9 % 3);
                if (i8 == 0) {
                    return true;
                }
                return false;
            case 6:
                int i10 = i7 * i6;
                i7 = (i10 % 3) + (i10 & 1);
                i8 = i7 & 1;
                if (i8 == 0) {
                    return true;
                }
                return false;
            case 7:
                i8 = (((i7 * i6) % 3) + ((i7 + i6) & 1)) & 1;
                if (i8 == 0) {
                    return true;
                }
                return false;
            default:
                throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid mask pattern: "));
        }
    }

    private static boolean isWhiteHorizontal(byte[] bArr, int i5, int i6) {
        int iMin = Math.min(i6, bArr.length);
        for (int iMax = Math.max(i5, 0); iMax < iMin; iMax++) {
            if (bArr[iMax] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWhiteVertical(byte[][] bArr, int i5, int i6, int i7) {
        int iMin = Math.min(i7, bArr.length);
        for (int iMax = Math.max(i6, 0); iMax < iMin; iMax++) {
            if (bArr[iMax][i5] == 1) {
                return false;
            }
        }
        return true;
    }
}
