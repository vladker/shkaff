package com.google.zxing.aztec.encoder;

import A3.AbstractC0157z;
import androidx.collection.a;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    private static int[] bitsToWords(BitArray bitArray, int i5, int i6) {
        int[] iArr = new int[i6];
        int size = bitArray.getSize() / i5;
        for (int i7 = 0; i7 < size; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 |= bitArray.get((i7 * i5) + i9) ? 1 << ((i5 - i9) - 1) : 0;
            }
            iArr[i7] = i8;
        }
        return iArr;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7 += 2) {
            int i8 = i5 - i7;
            int i9 = i8;
            while (true) {
                int i10 = i5 + i7;
                if (i9 <= i10) {
                    bitMatrix.set(i9, i8);
                    bitMatrix.set(i9, i10);
                    bitMatrix.set(i8, i9);
                    bitMatrix.set(i10, i9);
                    i9++;
                }
            }
        }
        int i11 = i5 - i6;
        bitMatrix.set(i11, i11);
        int i12 = i11 + 1;
        bitMatrix.set(i12, i11);
        bitMatrix.set(i11, i12);
        int i13 = i5 + i6;
        bitMatrix.set(i13, i11);
        bitMatrix.set(i13, i12);
        bitMatrix.set(i13, i13 - 1);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z6, int i5, BitArray bitArray) {
        int i6 = i5 / 2;
        int i7 = 0;
        if (z6) {
            while (i7 < 7) {
                int i8 = (i6 - 3) + i7;
                if (bitArray.get(i7)) {
                    bitMatrix.set(i8, i6 - 5);
                }
                if (bitArray.get(i7 + 7)) {
                    bitMatrix.set(i6 + 5, i8);
                }
                if (bitArray.get(20 - i7)) {
                    bitMatrix.set(i8, i6 + 5);
                }
                if (bitArray.get(27 - i7)) {
                    bitMatrix.set(i6 - 5, i8);
                }
                i7++;
            }
            return;
        }
        while (i7 < 10) {
            int i9 = (i7 / 5) + (i6 - 5) + i7;
            if (bitArray.get(i7)) {
                bitMatrix.set(i9, i6 - 7);
            }
            if (bitArray.get(i7 + 10)) {
                bitMatrix.set(i6 + 7, i9);
            }
            if (bitArray.get(29 - i7)) {
                bitMatrix.set(i9, i6 + 7);
            }
            if (bitArray.get(39 - i7)) {
                bitMatrix.set(i6 - 7, i9);
            }
            i7++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i5, int i6) {
        int size = bitArray.getSize() / i6;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i6));
        int i7 = i5 / i6;
        int[] iArrBitsToWords = bitsToWords(bitArray, i6, i7);
        reedSolomonEncoder.encode(iArrBitsToWords, i7 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i5 % i6);
        for (int i8 : iArrBitsToWords) {
            bitArray2.appendBits(i8, i6);
        }
        return bitArray2;
    }

    public static BitArray generateModeMessage(boolean z6, int i5, int i6) {
        BitArray bitArray = new BitArray();
        if (z6) {
            bitArray.appendBits(i5 - 1, 2);
            bitArray.appendBits(i6 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i5 - 1, 5);
        bitArray.appendBits(i6 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static GenericGF getGF(int i5) {
        if (i5 == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i5 == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i5 == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i5 == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i5 == 12) {
            return GenericGF.AZTEC_DATA_12;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Unsupported word size "));
    }

    public static BitArray stuffBits(BitArray bitArray, int i5) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i6 = (1 << i5) - 2;
        int i7 = 0;
        while (i7 < size) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                int i10 = i7 + i9;
                if (i10 >= size || bitArray.get(i10)) {
                    i8 |= 1 << ((i5 - 1) - i9);
                }
            }
            int i11 = i8 & i6;
            if (i11 == i6) {
                bitArray2.appendBits(i11, i5);
            } else {
                if (i11 == 0) {
                    bitArray2.appendBits(i8 | 1, i5);
                } else {
                    bitArray2.appendBits(i8, i5);
                }
                i7 += i5;
            }
            i7--;
            i7 += i5;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i5, boolean z6) {
        return ((z6 ? 88 : 112) + (i5 << 4)) * i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static AztecCode encode(byte[] bArr, int i5, int i6) {
        BitArray bitArrayStuffBits;
        boolean z6;
        int iAbs;
        int i7;
        int i8;
        int i9;
        BitArray bitArrayEncode = new HighLevelEncoder(bArr).encode();
        int size = ((bitArrayEncode.getSize() * i5) / 100) + 11;
        int size2 = bitArrayEncode.getSize() + size;
        int i10 = 1;
        if (i6 != 0) {
            boolean z7 = i6 < 0;
            iAbs = Math.abs(i6);
            if (iAbs > (z7 ? 4 : 32)) {
                throw new IllegalArgumentException(a.i(i6, "Illegal value ", " for layers"));
            }
            i7 = totalBitsInLayer(iAbs, z7);
            i8 = WORD_SIZE[iAbs];
            int i11 = i7 - (i7 % i8);
            bitArrayStuffBits = stuffBits(bitArrayEncode, i8);
            if (bitArrayStuffBits.getSize() + size > i11) {
                z6 = z7;
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z7) {
                z6 = z7;
                if (bitArrayStuffBits.getSize() > (i8 << 6)) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            }
        } else {
            BitArray bitArrayStuffBits2 = null;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (i12 > 32) {
                    throw new IllegalArgumentException("Data too large for an Aztec code");
                }
                boolean z8 = i12 <= 3 ? i10 : 0;
                int i14 = z8 != 0 ? i12 + 1 : i12;
                int i15 = totalBitsInLayer(i14, z8);
                if (size2 <= i15) {
                    int i16 = WORD_SIZE[i14];
                    if (i13 != i16) {
                        bitArrayStuffBits2 = stuffBits(bitArrayEncode, i16);
                    } else {
                        i16 = i13;
                    }
                    int i17 = i15 - (i15 % i16);
                    if ((z8 == 0 || bitArrayStuffBits2.getSize() <= (i16 << 6)) && bitArrayStuffBits2.getSize() + size <= i17) {
                        bitArrayStuffBits = bitArrayStuffBits2;
                        z6 = z8;
                        iAbs = i14;
                        i7 = i15;
                        i8 = i16;
                        break;
                    }
                    i13 = i16;
                }
                i12++;
                i10 = i10;
            }
        }
        BitArray bitArrayGenerateCheckWords = generateCheckWords(bitArrayStuffBits, i7, i8);
        int size3 = bitArrayStuffBits.getSize() / i8;
        BitArray bitArrayGenerateModeMessage = generateModeMessage(z6, iAbs, size3);
        int i18 = (z6 ? 11 : 14) + (iAbs << 2);
        int[] iArr = new int[i18];
        int i19 = 2;
        if (z6) {
            for (int i20 = 0; i20 < i18; i20++) {
                iArr[i20] = i20;
            }
            i9 = i18;
        } else {
            int i21 = i18 / 2;
            i9 = (((i21 - 1) / 15) * 2) + i18 + 1;
            int i22 = i9 / 2;
            for (int i23 = 0; i23 < i21; i23++) {
                int i24 = (i23 / 15) + i23;
                iArr[(i21 - i23) - i10] = (i22 - i24) - 1;
                iArr[i21 + i23] = i24 + i22 + i10;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i9);
        int i25 = 0;
        for (int i26 = 0; i26 < iAbs; i26++) {
            int i27 = ((iAbs - i26) << i19) + (z6 ? 9 : 12);
            for (int i28 = 0; i28 < i27; i28++) {
                int i29 = i28 << 1;
                int i30 = 0;
                while (i30 < i19) {
                    int i31 = i10;
                    if (bitArrayGenerateCheckWords.get(i25 + i29 + i30)) {
                        int i32 = i26 << 1;
                        bitMatrix.set(iArr[i32 + i30], iArr[i32 + i28]);
                    }
                    if (bitArrayGenerateCheckWords.get((i27 << 1) + i25 + i29 + i30)) {
                        int i33 = i26 << 1;
                        bitMatrix.set(iArr[i33 + i28], iArr[((i18 - 1) - i33) - i30]);
                    }
                    if (bitArrayGenerateCheckWords.get((i27 << 2) + i25 + i29 + i30)) {
                        int i34 = (i18 - 1) - (i26 << 1);
                        bitMatrix.set(iArr[i34 - i30], iArr[i34 - i28]);
                    }
                    if (bitArrayGenerateCheckWords.get((i27 * 6) + i25 + i29 + i30)) {
                        int i35 = i26 << 1;
                        bitMatrix.set(iArr[((i18 - 1) - i35) - i28], iArr[i35 + i30]);
                    }
                    i30++;
                    i10 = i31;
                    i19 = i19;
                }
            }
            i25 += i27 << 3;
        }
        drawModeMessage(bitMatrix, z6, i9, bitArrayGenerateModeMessage);
        if (z6) {
            drawBullsEye(bitMatrix, i9 / 2, 5);
        } else {
            int i36 = i9 / 2;
            drawBullsEye(bitMatrix, i36, 7);
            int i37 = 0;
            int i38 = 0;
            while (i38 < (i18 / 2) - 1) {
                for (int i39 = i36 & 1; i39 < i9; i39 += 2) {
                    int i40 = i36 - i37;
                    bitMatrix.set(i40, i39);
                    int i41 = i36 + i37;
                    bitMatrix.set(i41, i39);
                    bitMatrix.set(i39, i40);
                    bitMatrix.set(i39, i41);
                }
                i38 += 15;
                i37 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z6);
        aztecCode.setSize(i9);
        aztecCode.setLayers(iAbs);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }
}
