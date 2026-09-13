package com.google.zxing.maxicode.decoder;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Decoder {
    private static final int ALL = 0;
    private static final int EVEN = 1;
    private static final int ODD = 2;
    private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);

    private void correctErrors(byte[] bArr, int i5, int i6, int i7, int i8) throws ChecksumException {
        int i9 = i6 + i7;
        int i10 = i8 == 0 ? 1 : 2;
        int[] iArr = new int[i9 / i10];
        for (int i11 = 0; i11 < i9; i11++) {
            if (i8 == 0 || i11 % 2 == i8 - 1) {
                iArr[i11 / i10] = bArr[i11 + i5] & UnsignedBytes.MAX_VALUE;
            }
        }
        try {
            this.rsDecoder.decode(iArr, i7 / i10);
            for (int i12 = 0; i12 < i6; i12++) {
                if (i8 == 0 || i12 % 2 == i8 - 1) {
                    bArr[i12 + i5] = (byte) iArr[i12 / i10];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public DecoderResult decode(BitMatrix bitMatrix) {
        return decode(bitMatrix, null);
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        byte[] bArr;
        byte[] codewords = new BitMatrixParser(bitMatrix).readCodewords();
        correctErrors(codewords, 0, 10, 10, 0);
        int i5 = codewords[0] & 15;
        if (i5 == 2 || i5 == 3 || i5 == 4) {
            correctErrors(codewords, 20, 84, 40, 1);
            correctErrors(codewords, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i5 != 5) {
                throw FormatException.getFormatInstance();
            }
            correctErrors(codewords, 20, 68, 56, 1);
            correctErrors(codewords, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(codewords, 0, bArr, 0, 10);
        System.arraycopy(codewords, 20, bArr, 10, bArr.length - 10);
        return DecodedBitStreamParser.decode(bArr, i5);
    }
}
