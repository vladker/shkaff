package com.google.zxing.oned;

import A3.AbstractC0157z;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Code39Writer extends OneDimensionalCodeWriter {
    private static void toIntArray(int i5, int[] iArr) {
        for (int i6 = 0; i6 < 9; i6++) {
            int i7 = 1;
            if (((1 << (8 - i6)) & i5) != 0) {
                i7 = 2;
            }
            iArr[i6] = i7;
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.encode(str, barcodeFormat, i5, i6, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i5 = length + 25;
            for (int i6 = 0; i6 < length; i6++) {
                int iIndexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i6));
                if (iIndexOf >= 0) {
                    toIntArray(Code39Reader.CHARACTER_ENCODINGS[iIndexOf], iArr);
                    for (int i7 = 0; i7 < 9; i7++) {
                        i5 += iArr[i7];
                    }
                } else {
                    throw new IllegalArgumentException("Bad contents: ".concat(str));
                }
            }
            boolean[] zArr = new boolean[i5];
            toIntArray(Code39Reader.ASTERISK_ENCODING, iArr);
            int iAppendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int iAppendPattern2 = OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, iArr2, false) + iAppendPattern;
            for (int i8 = 0; i8 < length; i8++) {
                toIntArray(Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i8))], iArr);
                int iAppendPattern3 = OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, iArr, true) + iAppendPattern2;
                iAppendPattern2 = OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern3, iArr2, false) + iAppendPattern3;
            }
            toIntArray(Code39Reader.ASTERISK_ENCODING, iArr);
            OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(length, "Requested contents should be less than 80 digits long, but got "));
    }
}
