package org.apache.commons.compress.harmony.pack200;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Codec {
    public static final BHSDCodec BCI5 = new BHSDCodec(5, 4);
    public static final BHSDCodec BRANCH5 = new BHSDCodec(5, 4, 2);
    public static final BHSDCodec BYTE1 = new BHSDCodec(1, 256);
    public static final BHSDCodec CHAR3 = new BHSDCodec(3, 128);
    public static final BHSDCodec DELTA5 = new BHSDCodec(5, 64, 1, 1);
    public static final BHSDCodec MDELTA5 = new BHSDCodec(5, 64, 2, 1);
    public static final BHSDCodec SIGNED5 = new BHSDCodec(5, 64, 1);
    public static final BHSDCodec UDELTA5 = new BHSDCodec(5, 64, 0, 1);
    public static final BHSDCodec UNSIGNED5 = new BHSDCodec(5, 64);
    public int lastBandLength;

    public abstract int decode(InputStream inputStream);

    public abstract int decode(InputStream inputStream, long j6);

    public int[] decodeInts(int i5, InputStream inputStream) {
        this.lastBandLength = 0;
        int[] iArr = new int[i5];
        int iDecode = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            iDecode = decode(inputStream, iDecode);
            iArr[i6] = iDecode;
        }
        return iArr;
    }

    public abstract byte[] encode(int i5);

    public abstract byte[] encode(int i5, int i6);

    public byte[] encode(int[] iArr) {
        int length = iArr.length;
        byte[][] bArr = new byte[length][];
        int i5 = 0;
        int length2 = 0;
        while (i5 < iArr.length) {
            byte[] bArrEncode = encode(iArr[i5], i5 > 0 ? iArr[i5 - 1] : 0);
            bArr[i5] = bArrEncode;
            length2 += bArrEncode.length;
            i5++;
        }
        byte[] bArr2 = new byte[length2];
        int length3 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            byte[] bArr3 = bArr[i6];
            System.arraycopy(bArr3, 0, bArr2, length3, bArr3.length);
            length3 += bArr[i6].length;
        }
        return bArr2;
    }

    public int[] decodeInts(int i5, InputStream inputStream, int i6) {
        int i7 = i5 + 1;
        int[] iArr = new int[i7];
        iArr[0] = i6;
        for (int i8 = 1; i8 < i7; i8++) {
            i6 = decode(inputStream, i6);
            iArr[i8] = i6;
        }
        return iArr;
    }
}
