package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
abstract class AI01decoder extends AbstractExpandedDecoder {
    static final int GTIN_SIZE = 40;

    public AI01decoder(BitArray bitArray) {
        super(bitArray);
    }

    private static void appendCheckDigit(StringBuilder sb, int i5) {
        int i6 = 0;
        for (int i7 = 0; i7 < 13; i7++) {
            int iCharAt = sb.charAt(i7 + i5) - '0';
            if ((i7 & 1) == 0) {
                iCharAt *= 3;
            }
            i6 += iCharAt;
        }
        int i8 = 10 - (i6 % 10);
        sb.append(i8 != 10 ? i8 : 0);
    }

    public final void encodeCompressedGtin(StringBuilder sb, int i5) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        encodeCompressedGtinWithoutAI(sb, i5, length);
    }

    public final void encodeCompressedGtinWithoutAI(StringBuilder sb, int i5, int i6) {
        for (int i7 = 0; i7 < 4; i7++) {
            int iExtractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray((i7 * 10) + i5, 10);
            if (iExtractNumericValueFromBitArray / 100 == 0) {
                sb.append('0');
            }
            if (iExtractNumericValueFromBitArray / 10 == 0) {
                sb.append('0');
            }
            sb.append(iExtractNumericValueFromBitArray);
        }
        appendCheckDigit(sb, i6);
    }
}
