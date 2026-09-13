package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class EAN13Reader extends UPCEANReader {
    static final int[] FIRST_DIGIT_ENCODINGS = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] decodeMiddleCounters = new int[4];

    private static void determineFirstDigit(StringBuilder sb, int i5) throws NotFoundException {
        for (int i6 = 0; i6 < 10; i6++) {
            if (i5 == FIRST_DIGIT_ENCODINGS[i6]) {
                sb.insert(0, (char) (i6 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i5 = iArr[1];
        int i6 = 0;
        for (int i7 = 0; i7 < 6 && i5 < size; i7++) {
            int iDecodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i5, UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((iDecodeDigit % 10) + 48));
            for (int i8 : iArr2) {
                i5 += i8;
            }
            if (iDecodeDigit >= 10) {
                i6 |= 1 << (5 - i7);
            }
        }
        determineFirstDigit(sb, i6);
        int i9 = UPCEANReader.findGuardPattern(bitArray, i5, true, UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i10 = 0; i10 < 6 && i9 < size; i10++) {
            sb.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i9, UPCEANReader.L_PATTERNS) + 48));
            for (int i11 : iArr2) {
                i9 += i11;
            }
        }
        return i9;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_13;
    }
}
