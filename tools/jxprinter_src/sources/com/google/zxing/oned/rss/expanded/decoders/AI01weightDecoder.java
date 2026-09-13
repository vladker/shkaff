package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
abstract class AI01weightDecoder extends AI01decoder {
    public AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public abstract void addWeightCode(StringBuilder sb, int i5);

    public abstract int checkWeight(int i5);

    public final void encodeCompressedWeight(StringBuilder sb, int i5, int i6) {
        int iExtractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i5, i6);
        addWeightCode(sb, iExtractNumericValueFromBitArray);
        int iCheckWeight = checkWeight(iExtractNumericValueFromBitArray);
        int i7 = BZip2Constants.BASEBLOCKSIZE;
        for (int i8 = 0; i8 < 5; i8++) {
            if (iCheckWeight / i7 == 0) {
                sb.append('0');
            }
            i7 /= 10;
        }
        sb.append(iCheckWeight);
    }
}
