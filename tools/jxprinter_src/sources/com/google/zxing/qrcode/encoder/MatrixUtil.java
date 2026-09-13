package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class MatrixUtil {
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;
    private static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private MatrixUtil() {
    }

    public static void buildMatrix(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i5, ByteMatrix byteMatrix) throws WriterException {
        clearMatrix(byteMatrix);
        embedBasicPatterns(version, byteMatrix);
        embedTypeInfo(errorCorrectionLevel, i5, byteMatrix);
        maybeEmbedVersionInfo(version, byteMatrix);
        embedDataBits(bitArray, i5, byteMatrix);
    }

    public static int calculateBCHCode(int i5, int i6) {
        if (i6 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iFindMSBSet = findMSBSet(i6);
        int iFindMSBSet2 = i5 << (iFindMSBSet - 1);
        while (findMSBSet(iFindMSBSet2) >= iFindMSBSet) {
            iFindMSBSet2 ^= i6 << (findMSBSet(iFindMSBSet2) - iFindMSBSet);
        }
        return iFindMSBSet2;
    }

    public static void clearMatrix(ByteMatrix byteMatrix) {
        byteMatrix.clear((byte) -1);
    }

    public static void embedBasicPatterns(Version version, ByteMatrix byteMatrix) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(byteMatrix);
        embedDarkDotAtLeftBottomCorner(byteMatrix);
        maybeEmbedPositionAdjustmentPatterns(version, byteMatrix);
        embedTimingPatterns(byteMatrix);
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) == 0) {
            throw new WriterException();
        }
        byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
    }

    public static void embedDataBits(BitArray bitArray, int i5, ByteMatrix byteMatrix) throws WriterException {
        boolean z6;
        int width = byteMatrix.getWidth() - 1;
        int height = byteMatrix.getHeight() - 1;
        int i6 = 0;
        int i7 = -1;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < byteMatrix.getHeight()) {
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = width - i8;
                    if (isEmpty(byteMatrix.get(i9, height))) {
                        if (i6 < bitArray.getSize()) {
                            z6 = bitArray.get(i6);
                            i6++;
                        } else {
                            z6 = false;
                        }
                        if (i5 != -1 && MaskUtil.getDataMaskBit(i5, i9, height)) {
                            z6 = !z6;
                        }
                        byteMatrix.set(i9, height, z6);
                    }
                }
                height += i7;
            }
            i7 = -i7;
            height += i7;
            width -= 2;
        }
        if (i6 == bitArray.getSize()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i6 + '/' + bitArray.getSize());
    }

    private static void embedHorizontalSeparationPattern(int i5, int i6, ByteMatrix byteMatrix) throws WriterException {
        for (int i7 = 0; i7 < 8; i7++) {
            int i8 = i5 + i7;
            if (!isEmpty(byteMatrix.get(i8, i6))) {
                throw new WriterException();
            }
            byteMatrix.set(i8, i6, 0);
        }
    }

    private static void embedPositionAdjustmentPattern(int i5, int i6, ByteMatrix byteMatrix) {
        for (int i7 = 0; i7 < 5; i7++) {
            for (int i8 = 0; i8 < 5; i8++) {
                byteMatrix.set(i5 + i8, i6 + i7, POSITION_ADJUSTMENT_PATTERN[i7][i8]);
            }
        }
    }

    private static void embedPositionDetectionPattern(int i5, int i6, ByteMatrix byteMatrix) {
        for (int i7 = 0; i7 < 7; i7++) {
            for (int i8 = 0; i8 < 7; i8++) {
                byteMatrix.set(i5 + i8, i6 + i7, POSITION_DETECTION_PATTERN[i7][i8]);
            }
        }
    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix byteMatrix) throws WriterException {
        int length = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, byteMatrix);
        embedPositionDetectionPattern(byteMatrix.getWidth() - length, 0, byteMatrix);
        embedPositionDetectionPattern(0, byteMatrix.getWidth() - length, byteMatrix);
        embedHorizontalSeparationPattern(0, 7, byteMatrix);
        embedHorizontalSeparationPattern(byteMatrix.getWidth() - 8, 7, byteMatrix);
        embedHorizontalSeparationPattern(0, byteMatrix.getWidth() - 8, byteMatrix);
        embedVerticalSeparationPattern(7, 0, byteMatrix);
        embedVerticalSeparationPattern(byteMatrix.getHeight() - 8, 0, byteMatrix);
        embedVerticalSeparationPattern(7, byteMatrix.getHeight() - 7, byteMatrix);
    }

    private static void embedTimingPatterns(ByteMatrix byteMatrix) {
        int i5 = 8;
        while (i5 < byteMatrix.getWidth() - 8) {
            int i6 = i5 + 1;
            int i7 = i6 % 2;
            if (isEmpty(byteMatrix.get(i5, 6))) {
                byteMatrix.set(i5, 6, i7);
            }
            if (isEmpty(byteMatrix.get(6, i5))) {
                byteMatrix.set(6, i5, i7);
            }
            i5 = i6;
        }
    }

    public static void embedTypeInfo(ErrorCorrectionLevel errorCorrectionLevel, int i5, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        makeTypeInfoBits(errorCorrectionLevel, i5, bitArray);
        for (int i6 = 0; i6 < bitArray.getSize(); i6++) {
            boolean z6 = bitArray.get((bitArray.getSize() - 1) - i6);
            int[] iArr = TYPE_INFO_COORDINATES[i6];
            byteMatrix.set(iArr[0], iArr[1], z6);
            if (i6 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i6) - 1, 8, z6);
            } else {
                byteMatrix.set(8, (i6 - 8) + (byteMatrix.getHeight() - 7), z6);
            }
        }
    }

    private static void embedVerticalSeparationPattern(int i5, int i6, ByteMatrix byteMatrix) throws WriterException {
        for (int i7 = 0; i7 < 7; i7++) {
            int i8 = i6 + i7;
            if (!isEmpty(byteMatrix.get(i5, i8))) {
                throw new WriterException();
            }
            byteMatrix.set(i5, i8, 0);
        }
    }

    public static int findMSBSet(int i5) {
        return 32 - Integer.numberOfLeadingZeros(i5);
    }

    private static boolean isEmpty(int i5) {
        return i5 == -1;
    }

    public static void makeTypeInfoBits(ErrorCorrectionLevel errorCorrectionLevel, int i5, BitArray bitArray) throws WriterException {
        if (!QRCode.isValidMaskPattern(i5)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i5;
        bitArray.appendBits(bits, 5);
        bitArray.appendBits(calculateBCHCode(bits, TYPE_INFO_POLY), 10);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(TYPE_INFO_MASK_PATTERN, 15);
        bitArray.xor(bitArray2);
        if (bitArray.getSize() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    public static void makeVersionInfoBits(Version version, BitArray bitArray) throws WriterException {
        bitArray.appendBits(version.getVersionNumber(), 6);
        bitArray.appendBits(calculateBCHCode(version.getVersionNumber(), VERSION_INFO_POLY), 12);
        if (bitArray.getSize() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    private static void maybeEmbedPositionAdjustmentPatterns(Version version, ByteMatrix byteMatrix) {
        if (version.getVersionNumber() < 2) {
            return;
        }
        int[] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[version.getVersionNumber() - 1];
        for (int i5 : iArr) {
            for (int i6 : iArr) {
                if (i6 != -1 && i5 != -1 && isEmpty(byteMatrix.get(i6, i5))) {
                    embedPositionAdjustmentPattern(i6 - 2, i5 - 2, byteMatrix);
                }
            }
        }
    }

    public static void maybeEmbedVersionInfo(Version version, ByteMatrix byteMatrix) throws WriterException {
        if (version.getVersionNumber() < 7) {
            return;
        }
        BitArray bitArray = new BitArray();
        makeVersionInfoBits(version, bitArray);
        int i5 = 17;
        for (int i6 = 0; i6 < 6; i6++) {
            for (int i7 = 0; i7 < 3; i7++) {
                boolean z6 = bitArray.get(i5);
                i5--;
                byteMatrix.set(i6, (byteMatrix.getHeight() - 11) + i7, z6);
                byteMatrix.set((byteMatrix.getHeight() - 11) + i7, i6, z6);
            }
        }
    }
}
