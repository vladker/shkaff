package com.google.zxing.oned;

import A3.AbstractC0157z;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ITFWriter extends OneDimensionalCodeWriter {
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[] END_PATTERN = {3, 1, 1};

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.encode(str, barcodeFormat, i5, i6, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length <= 80) {
            boolean[] zArr = new boolean[(length * 9) + 9];
            int iAppendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, START_PATTERN, true);
            for (int i5 = 0; i5 < length; i5 += 2) {
                int iDigit = Character.digit(str.charAt(i5), 10);
                int iDigit2 = Character.digit(str.charAt(i5 + 1), 10);
                int[] iArr = new int[18];
                for (int i6 = 0; i6 < 5; i6++) {
                    int i7 = i6 * 2;
                    int[][] iArr2 = ITFReader.PATTERNS;
                    iArr[i7] = iArr2[iDigit][i6];
                    iArr[i7 + 1] = iArr2[iDigit2][i6];
                }
                iAppendPattern += OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, iArr, true);
            }
            OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, END_PATTERN, true);
            return zArr;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(length, "Requested contents should be less than 80 digits long, but got "));
    }
}
