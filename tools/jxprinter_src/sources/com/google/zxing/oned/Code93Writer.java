package com.google.zxing.oned;

import A3.AbstractC0157z;
import androidx.collection.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Code93Writer extends OneDimensionalCodeWriter {
    public static int appendPattern(boolean[] zArr, int i5, int[] iArr, boolean z6) {
        int length = iArr.length;
        int i6 = 0;
        while (i6 < length) {
            int i7 = i5 + 1;
            zArr[i5] = iArr[i6] != 0;
            i6++;
            i5 = i7;
        }
        return 9;
    }

    private static int computeChecksumIndex(String str, int i5) {
        int iIndexOf = 0;
        int i6 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i6;
            i6++;
            if (i6 > i5) {
                i6 = 1;
            }
        }
        return iIndexOf % 47;
    }

    private static void toIntArray(int i5, int[] iArr) {
        for (int i6 = 0; i6 < 9; i6++) {
            int i7 = 1;
            if (((1 << (8 - i6)) & i5) == 0) {
                i7 = 0;
            }
            iArr[i6] = i7;
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.encode(str, barcodeFormat, i5, i6, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[((str.length() + 4) * 9) + 1];
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
            int iAppendPattern = appendPattern(zArr, 0, iArr, true);
            for (int i5 = 0; i5 < length; i5++) {
                toIntArray(Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i5))], iArr);
                iAppendPattern += appendPattern(zArr, iAppendPattern, iArr, true);
            }
            int iComputeChecksumIndex = computeChecksumIndex(str, 20);
            int[] iArr2 = Code93Reader.CHARACTER_ENCODINGS;
            toIntArray(iArr2[iComputeChecksumIndex], iArr);
            int iAppendPattern2 = appendPattern(zArr, iAppendPattern, iArr, true) + iAppendPattern;
            StringBuilder sbR = a.r(str);
            sbR.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(iComputeChecksumIndex));
            toIntArray(iArr2[computeChecksumIndex(sbR.toString(), 15)], iArr);
            int iAppendPattern3 = appendPattern(zArr, iAppendPattern2, iArr, true) + iAppendPattern2;
            toIntArray(iArr2[47], iArr);
            zArr[appendPattern(zArr, iAppendPattern3, iArr, true) + iAppendPattern3] = true;
            return zArr;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(length, "Requested contents should be less than 80 digits long, but got "));
    }
}
