package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class EAN8Reader extends UPCEANReader {
    private final int[] decodeMiddleCounters = new int[4];

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i5 = iArr[1];
        for (int i6 = 0; i6 < 4 && i5 < size; i6++) {
            sb.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i5, UPCEANReader.L_PATTERNS) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        int i8 = UPCEANReader.findGuardPattern(bitArray, i5, true, UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i9 = 0; i9 < 4 && i8 < size; i9++) {
            sb.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i8, UPCEANReader.L_PATTERNS) + 48));
            for (int i10 : iArr2) {
                i8 += i10;
            }
        }
        return i8;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_8;
    }
}
