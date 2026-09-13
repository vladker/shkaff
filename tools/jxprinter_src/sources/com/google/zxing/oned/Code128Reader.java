package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int decodeCode(BitArray bitArray, int[] iArr, int i5) throws NotFoundException {
        OneDReader.recordPattern(bitArray, i5, iArr);
        float f6 = MAX_AVG_VARIANCE;
        int i6 = -1;
        int i7 = 0;
        while (true) {
            int[][] iArr2 = CODE_PATTERNS;
            if (i7 >= iArr2.length) {
                break;
            }
            float fPatternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i7], MAX_INDIVIDUAL_VARIANCE);
            if (fPatternMatchVariance < f6) {
                i6 = i7;
                f6 = fPatternMatchVariance;
            }
            i7++;
        }
        if (i6 >= 0) {
            return i6;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        boolean z6 = false;
        int i5 = 0;
        int i6 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z6) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 == 5) {
                    int i7 = -1;
                    float f6 = MAX_AVG_VARIANCE;
                    for (int i8 = 103; i8 <= 105; i8++) {
                        float fPatternMatchVariance = OneDReader.patternMatchVariance(iArr, CODE_PATTERNS[i8], MAX_INDIVIDUAL_VARIANCE);
                        if (fPatternMatchVariance < f6) {
                            i7 = i8;
                            f6 = fPatternMatchVariance;
                        }
                    }
                    if (i7 >= 0 && bitArray.isRange(Math.max(0, i6 - ((nextSet - i6) / 2)), i6, false)) {
                        return new int[]{i6, nextSet, i7};
                    }
                    i6 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 4);
                    iArr[4] = 0;
                    iArr[5] = 0;
                    i5--;
                } else {
                    i5++;
                }
                iArr[i5] = 1;
                z6 = !z6;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:101:0x0168  */
    /* JADX WARN: Code duplicated, block: B:102:0x016d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0174  */
    /* JADX WARN: Code duplicated, block: B:104:0x0177  */
    /* JADX WARN: Code duplicated, block: B:107:0x017f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x0181  */
    /* JADX WARN: Code duplicated, block: B:109:0x0183  */
    /* JADX WARN: Code duplicated, block: B:137:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x005e  */
    /* JADX WARN: Code duplicated, block: B:19:0x006e  */
    /* JADX WARN: Code duplicated, block: B:21:0x0072  */
    /* JADX WARN: Code duplicated, block: B:24:0x007f A[LOOP:1: B:23:0x007d->B:24:0x007f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0089  */
    /* JADX WARN: Code duplicated, block: B:29:0x0091  */
    /* JADX WARN: Code duplicated, block: B:31:0x0095 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0097  */
    /* JADX WARN: Code duplicated, block: B:33:0x009e  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a5 A[PHI: r3 r9 r17 r21
  0x00a5: PHI (r3v6 boolean) = 
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v11 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
 binds: [B:27:0x008d, B:70:0x0116, B:72:0x011a, B:76:0x0127, B:75:0x0122, B:62:0x00fb, B:57:0x00e5, B:34:0x00a4, B:44:0x00c2, B:46:0x00c6, B:50:0x00d2, B:49:0x00ce] A[DONT_GENERATE, DONT_INLINE]
  0x00a5: PHI (r9v4 boolean) = 
  (r9v3 boolean)
  (r9v3 boolean)
  (r9v3 boolean)
  (r9v3 boolean)
  (r9v3 boolean)
  (r9v3 boolean)
  (r9v11 boolean)
  (r9v12 boolean)
  (r9v3 boolean)
  (r9v3 boolean)
  (r9v3 boolean)
  (r9v3 boolean)
 binds: [B:27:0x008d, B:70:0x0116, B:72:0x011a, B:76:0x0127, B:75:0x0122, B:62:0x00fb, B:57:0x00e5, B:34:0x00a4, B:44:0x00c2, B:46:0x00c6, B:50:0x00d2, B:49:0x00ce] A[DONT_GENERATE, DONT_INLINE]
  0x00a5: PHI (r17v2 boolean) = 
  (r17v1 boolean)
  (r17v1 boolean)
  (r17v1 boolean)
  (r17v1 boolean)
  (r17v1 boolean)
  (r17v5 boolean)
  (r17v1 boolean)
  (r17v1 boolean)
  (r17v1 boolean)
  (r17v1 boolean)
  (r17v1 boolean)
  (r17v1 boolean)
 binds: [B:27:0x008d, B:70:0x0116, B:72:0x011a, B:76:0x0127, B:75:0x0122, B:62:0x00fb, B:57:0x00e5, B:34:0x00a4, B:44:0x00c2, B:46:0x00c6, B:50:0x00d2, B:49:0x00ce] A[DONT_GENERATE, DONT_INLINE]
  0x00a5: PHI (r21v3 boolean) = 
  (r21v2 boolean)
  (r21v9 boolean)
  (r21v9 boolean)
  (r21v9 boolean)
  (r21v9 boolean)
  (r21v11 boolean)
  (r21v14 boolean)
  (r21v17 boolean)
  (r21v18 boolean)
  (r21v18 boolean)
  (r21v18 boolean)
  (r21v18 boolean)
 binds: [B:27:0x008d, B:70:0x0116, B:72:0x011a, B:76:0x0127, B:75:0x0122, B:62:0x00fb, B:57:0x00e5, B:34:0x00a4, B:44:0x00c2, B:46:0x00c6, B:50:0x00d2, B:49:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00be  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00da A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:53:0x00dc A[PHI: r21
  0x00dc: PHI (r21v16 boolean) = (r21v9 boolean), (r21v18 boolean) binds: [B:81:0x0136, B:52:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:55:0x00e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x00e3 A[PHI: r21
  0x00e3: PHI (r21v15 boolean) = (r21v9 boolean), (r21v18 boolean) binds: [B:84:0x013b, B:55:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x00e5 A[PHI: r21
  0x00e5: PHI (r21v14 boolean) = (r21v9 boolean), (r21v9 boolean), (r21v18 boolean), (r21v18 boolean) binds: [B:83:0x0139, B:84:0x013b, B:54:0x00df, B:55:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ef A[PHI: r21
  0x00ef: PHI (r21v12 boolean) = (r21v9 boolean), (r21v18 boolean) binds: [B:70:0x0116, B:44:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:61:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fb A[PHI: r21
  0x00fb: PHI (r21v11 boolean) = (r21v9 boolean), (r21v18 boolean) binds: [B:69:0x0114, B:43:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:63:0x00fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0100 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x0102  */
    /* JADX WARN: Code duplicated, block: B:66:0x0109  */
    /* JADX WARN: Code duplicated, block: B:67:0x0110 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x0112  */
    /* JADX WARN: Code duplicated, block: B:70:0x0116  */
    /* JADX WARN: Code duplicated, block: B:72:0x011a  */
    /* JADX WARN: Code duplicated, block: B:73:0x011c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0122  */
    /* JADX WARN: Code duplicated, block: B:76:0x0127  */
    /* JADX WARN: Code duplicated, block: B:77:0x012e  */
    /* JADX WARN: Code duplicated, block: B:78:0x0130 A[PHI: r10 r21
  0x0130: PHI (r10v7 char) = (r10v5 char), (r10v9 char) binds: [B:96:0x015b, B:77:0x012e] A[DONT_GENERATE, DONT_INLINE]
  0x0130: PHI (r21v8 boolean) = (r21v5 boolean), (r21v9 boolean) binds: [B:96:0x015b, B:77:0x012e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:80:0x0134  */
    /* JADX WARN: Code duplicated, block: B:81:0x0136 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:84:0x013b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:86:0x013e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0143  */
    /* JADX WARN: Code duplicated, block: B:89:0x0147  */
    /* JADX WARN: Code duplicated, block: B:91:0x014b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0155 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0157  */
    /* JADX WARN: Code duplicated, block: B:96:0x015b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0160  */
    /* JADX WARN: Code duplicated, block: B:99:0x0162  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:40:0x00b5
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.google.zxing.oned.OneDReader
    public com.google.zxing.Result decodeRow(int r27, com.google.zxing.common.BitArray r28, java.util.Map<com.google.zxing.DecodeHintType, ?> r29) {
        /*
            Method dump skipped, instruction units count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
