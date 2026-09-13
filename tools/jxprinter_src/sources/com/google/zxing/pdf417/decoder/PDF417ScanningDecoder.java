package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private PDF417ScanningDecoder() {
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) {
        int[] rowHeights;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i5 = 0;
        int i6 = 0;
        for (int i7 : rowHeights) {
            i6 += max - i7;
            if (i7 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        for (int i8 = 0; i6 > 0 && codewords[i8] == null; i8++) {
            i6--;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            int i9 = rowHeights[length];
            i5 += max - i9;
            if (i9 > 0) {
                break;
            }
        }
        for (int length2 = codewords.length - 1; i5 > 0 && codewords[length2] == null; length2--) {
            i5--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i6, i5, detectionResultRowIndicatorColumn.isLeft());
    }

    private static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        int[] value = barcodeValueArr[0][1].getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length != 0) {
            if (value[0] != barcodeColumnCount) {
                barcodeValueArr[0][1].setValue(barcodeColumnCount);
            }
        } else {
            if (barcodeColumnCount <= 0 || barcodeColumnCount > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            barcodeValueArr[0][1].setValue(barcodeColumnCount);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0011  */
    /* JADX WARN: Code duplicated, block: B:14:0x0017  */
    /* JADX WARN: Code duplicated, block: B:17:0x0020 A[LOOP:1: B:8:0x000a->B:17:0x0020, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x001f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0022 A[EDGE_INSN: B:24:0x0022->B:18:0x0022 BREAK  A[LOOP:1: B:8:0x000a->B:17:0x0020], SYNTHETIC] */
    private static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i5, int i6, boolean z6, int i7, int i8) {
        int i9 = z6 ? -1 : 1;
        int i10 = i7;
        for (int i11 = 0; i11 < 2; i11++) {
            while (true) {
                if (!z6) {
                    if (i10 >= i6) {
                        break;
                    }
                    if (z6 == bitMatrix.get(i10, i8)) {
                        break;
                        break;
                    }
                    if (Math.abs(i7 - i10) > 2) {
                        return i7;
                    }
                    i10 += i9;
                } else {
                    if (i10 < i5) {
                        break;
                    }
                    if (z6 == bitMatrix.get(i10, i8)) {
                        break;
                    }
                    if (Math.abs(i7 - i10) > 2) {
                        return i7;
                    }
                    i10 += i9;
                }
            }
            i9 = -i9;
            z6 = !z6;
        }
        return i10;
    }

    private static boolean checkCodewordSkew(int i5, int i6, int i7) {
        return i6 + (-2) <= i5 && i5 <= i7 + 2;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i5) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i5 / 2) + 3) && i5 >= 0 && i5 <= 512) {
            return errorCorrection.decode(iArr, i5, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        int rowNumber;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance((Class<?>) BarcodeValue.class, detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2);
        for (BarcodeValue[] barcodeValueArr2 : barcodeValueArr) {
            int i5 = 0;
            while (true) {
                if (i5 < barcodeValueArr2.length) {
                    barcodeValueArr2[i5] = new BarcodeValue();
                    i5++;
                }
            }
        }
        int i6 = 0;
        for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                        barcodeValueArr[rowNumber][i6].setValue(codeword.getValue());
                    }
                }
            }
            i6++;
        }
        return barcodeValueArr;
    }

    private static DecoderResult createDecoderResult(DetectionResult detectionResult) throws NotFoundException {
        BarcodeValue[][] barcodeValueArrCreateBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, barcodeValueArrCreateBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i5 = 0; i5 < detectionResult.getBarcodeRowCount(); i5++) {
            int i6 = 0;
            while (i6 < detectionResult.getBarcodeColumnCount()) {
                int i7 = i6 + 1;
                int[] value = barcodeValueArrCreateBarcodeMatrix[i5][i7].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i5) + i6;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i6 = i7;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i8 = 0; i8 < size; i8++) {
            iArr2[i8] = (int[]) arrayList2.get(i8);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int i5, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i6 = 100;
        while (true) {
            int i7 = i6 - 1;
            if (i6 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            for (int i8 = 0; i8 < length; i8++) {
                iArr[iArr3[i8]] = iArr4[i8][iArr5[i8]];
            }
            try {
                return decodeCodewords(iArr, i5, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                for (int i9 = 0; i9 < length; i9++) {
                    int i10 = iArr5[i9];
                    if (i10 < iArr4[i9].length - 1) {
                        iArr5[i9] = i10 + 1;
                        break;
                    }
                    iArr5[i9] = 0;
                    if (i9 == length - 1) {
                        throw ChecksumException.getChecksumInstance();
                    }
                }
                i6 = i7;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:77:0x010a A[SYNTHETIC] */
    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i5, int i6) throws NotFoundException {
        BoundingBox boundingBox;
        DetectionResultColumn detectionResultRowIndicatorColumn;
        DetectionResultColumn detectionResultColumn;
        int i7;
        int i8;
        Codeword codewordDetectCodeword;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2 = null;
        boolean z6 = false;
        BoundingBox boundingBox2 = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        DetectionResultRowIndicatorColumn rowIndicatorColumn = null;
        DetectionResult detectionResultMerge = null;
        int i9 = 0;
        while (true) {
            if (i9 >= 2) {
                boundingBox = boundingBox2;
                break;
            }
            DetectionResultRowIndicatorColumn rowIndicatorColumn2 = resultPoint != null ? getRowIndicatorColumn(bitMatrix, boundingBox2, resultPoint, true, i5, i6) : detectionResultRowIndicatorColumn2;
            if (resultPoint3 != null) {
                rowIndicatorColumn = getRowIndicatorColumn(bitMatrix, boundingBox2, resultPoint3, false, i5, i6);
            }
            boundingBox = boundingBox2;
            detectionResultMerge = merge(rowIndicatorColumn2, rowIndicatorColumn);
            if (detectionResultMerge == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i9 != 0 || detectionResultMerge.getBoundingBox() == null || (detectionResultMerge.getBoundingBox().getMinY() >= boundingBox.getMinY() && detectionResultMerge.getBoundingBox().getMaxY() <= boundingBox.getMaxY())) {
                detectionResultMerge.setBoundingBox(boundingBox);
                detectionResultRowIndicatorColumn2 = rowIndicatorColumn2;
                break;
            }
            boundingBox2 = detectionResultMerge.getBoundingBox();
            i9++;
            detectionResultRowIndicatorColumn2 = rowIndicatorColumn2;
        }
        DetectionResult detectionResult = detectionResultMerge;
        int barcodeColumnCount = detectionResult.getBarcodeColumnCount() + 1;
        detectionResult.setDetectionResultColumn(0, detectionResultRowIndicatorColumn2);
        detectionResult.setDetectionResultColumn(barcodeColumnCount, rowIndicatorColumn);
        boolean z7 = detectionResultRowIndicatorColumn2 != null;
        int i10 = i5;
        int i11 = i6;
        int i12 = 1;
        while (i12 <= barcodeColumnCount) {
            int i13 = z7 ? i12 : barcodeColumnCount - i12;
            if (detectionResult.getDetectionResultColumn(i13) == null) {
                if (i13 == 0 || i13 == barcodeColumnCount) {
                    detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, i13 == 0 ? true : z6);
                } else {
                    detectionResultRowIndicatorColumn = new DetectionResultColumn(boundingBox);
                }
                detectionResult.setDetectionResultColumn(i13, detectionResultRowIndicatorColumn);
                int i14 = -1;
                int iMin = i10;
                int iMax = i11;
                int minY = boundingBox.getMinY();
                int i15 = -1;
                while (minY <= boundingBox.getMaxY()) {
                    int startColumn = getStartColumn(detectionResult, i13, minY, z7);
                    if (startColumn >= 0 && startColumn <= boundingBox.getMaxX()) {
                        detectionResultColumn = detectionResultRowIndicatorColumn;
                        i7 = i14;
                        i8 = startColumn;
                        codewordDetectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z7, i8, minY, iMin, iMax);
                        if (codewordDetectCodeword != null) {
                            detectionResultColumn.setCodeword(minY, codewordDetectCodeword);
                            iMin = Math.min(iMin, codewordDetectCodeword.getWidth());
                            iMax = Math.max(iMax, codewordDetectCodeword.getWidth());
                            i15 = i8;
                        }
                    } else if (i15 != i14) {
                        startColumn = i15;
                        detectionResultColumn = detectionResultRowIndicatorColumn;
                        i7 = i14;
                        i8 = startColumn;
                        codewordDetectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z7, i8, minY, iMin, iMax);
                        if (codewordDetectCodeword != null) {
                            detectionResultColumn.setCodeword(minY, codewordDetectCodeword);
                            iMin = Math.min(iMin, codewordDetectCodeword.getWidth());
                            iMax = Math.max(iMax, codewordDetectCodeword.getWidth());
                            i15 = i8;
                        }
                    } else {
                        detectionResultColumn = detectionResultRowIndicatorColumn;
                        i7 = i14;
                    }
                    minY++;
                    detectionResultRowIndicatorColumn = detectionResultColumn;
                    i14 = i7;
                }
                i10 = iMin;
                i11 = iMax;
            }
            i12++;
            z6 = false;
        }
        return createDecoderResult(detectionResult);
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i5, int[] iArr2) throws ChecksumException, FormatException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i6 = 1 << (i5 + 1);
        int iCorrectErrors = correctErrors(iArr, iArr2, i6);
        verifyCodewordCount(iArr, i6);
        DecoderResult decoderResultDecode = DecodedBitStreamParser.decode(iArr, String.valueOf(i5));
        decoderResultDecode.setErrorsCorrected(Integer.valueOf(iCorrectErrors));
        decoderResultDecode.setErasures(Integer.valueOf(iArr2.length));
        return decoderResultDecode;
    }

    private static Codeword detectCodeword(BitMatrix bitMatrix, int i5, int i6, boolean z6, int i7, int i8, int i9, int i10) {
        int i11;
        int decodedValue;
        int codeword;
        int iAdjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i5, i6, z6, i7, i8);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i5, i6, z6, iAdjustCodewordStartColumn, i8);
        if (moduleBitCount == null) {
            return null;
        }
        int iSum = MathUtils.sum(moduleBitCount);
        if (z6) {
            i11 = iAdjustCodewordStartColumn + iSum;
        } else {
            for (int i12 = 0; i12 < moduleBitCount.length / 2; i12++) {
                int i13 = moduleBitCount[i12];
                moduleBitCount[i12] = moduleBitCount[(moduleBitCount.length - 1) - i12];
                moduleBitCount[(moduleBitCount.length - 1) - i12] = i13;
            }
            iAdjustCodewordStartColumn -= iSum;
            i11 = iAdjustCodewordStartColumn;
        }
        if (checkCodewordSkew(iSum, i9, i10) && (codeword = PDF417Common.getCodeword((decodedValue = PDF417CodewordDecoder.getDecodedValue(moduleBitCount)))) != -1) {
            return new Codeword(iAdjustCodewordStartColumn, i11, getCodewordBucketNumber(decodedValue), codeword);
        }
        return null;
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        BarcodeMetadata barcodeMetadata2;
        if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        }
        if (detectionResultRowIndicatorColumn2 == null || (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) == null || barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
            return barcodeMetadata;
        }
        return null;
    }

    private static int[] getBitCountForCodeword(int i5) {
        int[] iArr = new int[8];
        int i6 = 0;
        int i7 = 7;
        while (true) {
            int i8 = i5 & 1;
            if (i8 != i6) {
                i7--;
                if (i7 < 0) {
                    return iArr;
                }
                i6 = i8;
            }
            iArr[i7] = iArr[i7] + 1;
            i5 >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i5) {
        return getCodewordBucketNumber(getBitCountForCodeword(i5));
    }

    private static int getMax(int[] iArr) {
        int iMax = -1;
        for (int i5 : iArr) {
            iMax = Math.max(iMax, i5);
        }
        return iMax;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0013 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    /* JADX WARN: Code duplicated, block: B:28:0x0027 A[EDGE_INSN: B:28:0x0027->B:16:0x0027 BREAK  A[LOOP:0: B:7:0x000c->B:31:0x000c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x001b A[SYNTHETIC] */
    private static int[] getModuleBitCount(BitMatrix bitMatrix, int i5, int i6, boolean z6, int i7, int i8) {
        int[] iArr = new int[8];
        int i9 = z6 ? 1 : -1;
        int i10 = 0;
        boolean z7 = z6;
        while (true) {
            if (!z6) {
                if (i7 < i5) {
                    break;
                }
                if (i10 < 8) {
                    break;
                    break;
                }
                if (bitMatrix.get(i7, i8) == z7) {
                    iArr[i10] = iArr[i10] + 1;
                    i7 += i9;
                } else {
                    i10++;
                    z7 = !z7;
                }
            } else {
                if (i7 >= i6) {
                    break;
                }
                if (i10 < 8) {
                    break;
                }
                if (bitMatrix.get(i7, i8) == z7) {
                    iArr[i10] = iArr[i10] + 1;
                    i7 += i9;
                } else {
                    i10++;
                    z7 = !z7;
                }
            }
        }
        if (i10 != 8) {
            if (z6) {
                i5 = i6;
            }
            if (i7 != i5 || i10 != 7) {
                return null;
            }
        }
        return iArr;
    }

    private static int getNumberOfECCodeWords(int i5) {
        return 2 << i5;
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z6, int i5, int i6) {
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z6);
        int i7 = 0;
        while (i7 < 2) {
            int i8 = i7 == 0 ? 1 : -1;
            int x6 = (int) resultPoint.getX();
            for (int y6 = (int) resultPoint.getY(); y6 <= boundingBox.getMaxY() && y6 >= boundingBox.getMinY(); y6 += i8) {
                Codeword codewordDetectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z6, x6, y6, i5, i6);
                if (codewordDetectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y6, codewordDetectCodeword);
                    x6 = z6 ? codewordDetectCodeword.getStartX() : codewordDetectCodeword.getEndX();
                }
            }
            i7++;
        }
        return detectionResultRowIndicatorColumn;
    }

    private static int getStartColumn(DetectionResult detectionResult, int i5, int i6, boolean z6) {
        int i7 = z6 ? 1 : -1;
        int i8 = i5 - i7;
        Codeword codeword = isValidBarcodeColumn(detectionResult, i8) ? detectionResult.getDetectionResultColumn(i8).getCodeword(i6) : null;
        if (codeword != null) {
            return z6 ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i5).getCodewordNearby(i6);
        if (codewordNearby != null) {
            return z6 ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i8)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i8).getCodewordNearby(i6);
        }
        if (codewordNearby != null) {
            return z6 ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i9 = 0;
        while (true) {
            i5 -= i7;
            if (!isValidBarcodeColumn(detectionResult, i5)) {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                return z6 ? boundingBox.getMinX() : boundingBox.getMaxX();
            }
            for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i5).getCodewords()) {
                if (codeword2 != null) {
                    return ((codeword2.getEndX() - codeword2.getStartX()) * i7 * i9) + (z6 ? codeword2.getEndX() : codeword2.getStartX());
                }
            }
            i9++;
        }
    }

    private static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i5) {
        return i5 >= 0 && i5 <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    public static String toString(BarcodeValue[][] barcodeValueArr) {
        Formatter formatter = new Formatter();
        for (int i5 = 0; i5 < barcodeValueArr.length; i5++) {
            formatter.format("Row %2d: ", Integer.valueOf(i5));
            int i6 = 0;
            while (true) {
                BarcodeValue[] barcodeValueArr2 = barcodeValueArr[i5];
                if (i6 < barcodeValueArr2.length) {
                    BarcodeValue barcodeValue = barcodeValueArr2[i6];
                    if (barcodeValue.getValue().length == 0) {
                        formatter.format("        ", null);
                    } else {
                        formatter.format("%4d(%2d)", Integer.valueOf(barcodeValue.getValue()[0]), barcodeValue.getConfidence(barcodeValue.getValue()[0]));
                    }
                    i6++;
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }

    private static void verifyCodewordCount(int[] iArr, int i5) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i6 = iArr[0];
        if (i6 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i6 == 0) {
            if (i5 >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i5;
        }
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
