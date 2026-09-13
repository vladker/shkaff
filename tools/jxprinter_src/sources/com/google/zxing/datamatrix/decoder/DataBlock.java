package com.google.zxing.datamatrix.decoder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i5, byte[] bArr) {
        this.numDataCodewords = i5;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        Version.ECBlocks eCBlocks = version.getECBlocks();
        Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int count = 0;
        for (Version.ECB ecb : eCBlocks2) {
            count += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[count];
        int i5 = 0;
        for (Version.ECB ecb2 : eCBlocks2) {
            int i6 = 0;
            while (i6 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i5] = new DataBlock(dataCodewords, new byte[eCBlocks.getECCodewords() + dataCodewords]);
                i6++;
                i5++;
            }
        }
        int length = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i7 = length - 1;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = 0;
            while (i10 < i5) {
                dataBlockArr[i10].codewords[i9] = bArr[i8];
                i10++;
                i8++;
            }
        }
        boolean z6 = version.getVersionNumber() == 24;
        int i11 = z6 ? 8 : i5;
        int i12 = 0;
        while (i12 < i11) {
            dataBlockArr[i12].codewords[i7] = bArr[i8];
            i12++;
            i8++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (length < length2) {
            int i13 = 0;
            while (i13 < i5) {
                int i14 = z6 ? (i13 + 8) % i5 : i13;
                dataBlockArr[i14].codewords[(!z6 || i14 <= 7) ? length : length - 1] = bArr[i8];
                i13++;
                i8++;
            }
            length++;
        }
        if (i8 == bArr.length) {
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] getCodewords() {
        return this.codewords;
    }

    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
