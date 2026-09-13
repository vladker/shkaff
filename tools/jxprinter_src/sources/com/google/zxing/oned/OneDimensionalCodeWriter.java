package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OneDimensionalCodeWriter implements Writer {
    public static int appendPattern(boolean[] zArr, int i5, int[] iArr, boolean z6) {
        int i6 = 0;
        for (int i7 : iArr) {
            int i8 = 0;
            while (i8 < i7) {
                zArr[i5] = z6;
                i8++;
                i5++;
            }
            i6 += i7;
            z6 = !z6;
        }
        return i6;
    }

    private static BitMatrix renderResult(boolean[] zArr, int i5, int i6, int i7) {
        int length = zArr.length;
        int i8 = i7 + length;
        int iMax = Math.max(i5, i8);
        int iMax2 = Math.max(1, i6);
        int i9 = iMax / i8;
        int i10 = (iMax - (length * i9)) / 2;
        BitMatrix bitMatrix = new BitMatrix(iMax, iMax2);
        int i11 = 0;
        while (i11 < length) {
            if (zArr[i11]) {
                bitMatrix.setRegion(i10, 0, i9, iMax2);
            }
            i11++;
            i10 += i9;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6) {
        return encode(str, barcodeFormat, i5, i6, null);
    }

    public abstract boolean[] encode(String str);

    public int getDefaultMargin() {
        return 10;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i5 < 0 || i6 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i5 + 'x' + i6);
        }
        int defaultMargin = getDefaultMargin();
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType)) {
                defaultMargin = Integer.parseInt(map.get(encodeHintType).toString());
            }
        }
        return renderResult(encode(str), i5, i6, defaultMargin);
    }
}
