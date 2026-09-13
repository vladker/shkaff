package com.google.zxing.oned;

import A3.AbstractC0157z;
import androidx.exifinterface.media.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int chooseCode(CharSequence charSequence, int i5, int i6) {
        CType cType;
        CType cTypeFindCType;
        CType cTypeFindCType2;
        CType cTypeFindCType3 = findCType(charSequence, i5);
        CType cType2 = CType.UNCODABLE;
        if (cTypeFindCType3 != cType2 && cTypeFindCType3 != (cType = CType.ONE_DIGIT)) {
            if (i6 != 99) {
                if (i6 == 100) {
                    CType cType3 = CType.FNC_1;
                    if (cTypeFindCType3 != cType3 && (cTypeFindCType = findCType(charSequence, i5 + 2)) != cType2 && cTypeFindCType != cType) {
                        if (cTypeFindCType == cType3) {
                            return findCType(charSequence, i5 + 3) == CType.TWO_DIGITS ? 99 : 100;
                        }
                        int i7 = i5 + 4;
                        while (true) {
                            cTypeFindCType2 = findCType(charSequence, i7);
                            if (cTypeFindCType2 != CType.TWO_DIGITS) {
                                break;
                            }
                            i7 += 2;
                        }
                        return cTypeFindCType2 == CType.ONE_DIGIT ? 100 : 99;
                    }
                } else {
                    if (cTypeFindCType3 == CType.FNC_1) {
                        cTypeFindCType3 = findCType(charSequence, i5 + 1);
                    }
                    if (cTypeFindCType3 == CType.TWO_DIGITS) {
                        return 99;
                    }
                }
            }
            return i6;
        }
        return 100;
    }

    private static CType findCType(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        if (i5 >= length) {
            return CType.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i5);
        if (cCharAt == 241) {
            return CType.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return CType.UNCODABLE;
        }
        int i6 = i5 + 1;
        if (i6 >= length) {
            return CType.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i6);
        return (cCharAt2 < '0' || cCharAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i5, i6, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length > 0 && length <= 80) {
            int iAppendPattern = 0;
            for (int i5 = 0; i5 < length; i5++) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < ' ' || cCharAt > '~') {
                    switch (cCharAt) {
                        case 241:
                        case 242:
                        case 243:
                        case 244:
                            break;
                        default:
                            throw new IllegalArgumentException(a.h("Bad character in input: ", cCharAt));
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 1;
            while (i6 < length) {
                int iChooseCode = chooseCode(str, i6, i8);
                int iCharAt = 100;
                if (iChooseCode == i8) {
                    switch (str.charAt(i6)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case 244:
                            break;
                        default:
                            if (i8 == 100) {
                                iCharAt = str.charAt(i6) - ' ';
                            } else {
                                iCharAt = Integer.parseInt(str.substring(i6, i6 + 2));
                                i6++;
                            }
                            break;
                    }
                    i6++;
                } else {
                    iCharAt = i8 == 0 ? iChooseCode == 100 ? 104 : 105 : iChooseCode;
                    i8 = iChooseCode;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[iCharAt]);
                i7 += iCharAt * i9;
                if (i6 != 0) {
                    i9++;
                }
            }
            int[][] iArr = Code128Reader.CODE_PATTERNS;
            arrayList.add(iArr[i7 % 103]);
            arrayList.add(iArr[106]);
            int size = arrayList.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                for (int i12 : (int[]) obj) {
                    i10 += i12;
                }
            }
            boolean[] zArr = new boolean[i10];
            int size2 = arrayList.size();
            int i13 = 0;
            while (i13 < size2) {
                Object obj2 = arrayList.get(i13);
                i13++;
                iAppendPattern += OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, (int[]) obj2, true);
            }
            return zArr;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(length, "Contents length should be between 1 and 80 characters, but got "));
    }
}
