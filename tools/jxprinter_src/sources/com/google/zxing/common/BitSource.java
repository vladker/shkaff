package com.google.zxing.common;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i5) {
        if (i5 <= 0 || i5 > 32 || i5 > available()) {
            throw new IllegalArgumentException(String.valueOf(i5));
        }
        int i6 = this.bitOffset;
        int i7 = 0;
        if (i6 > 0) {
            int i8 = 8 - i6;
            int i9 = i5 < i8 ? i5 : i8;
            int i10 = i8 - i9;
            byte[] bArr = this.bytes;
            int i11 = this.byteOffset;
            int i12 = (((255 >> (8 - i9)) << i10) & bArr[i11]) >> i10;
            i5 -= i9;
            int i13 = i6 + i9;
            this.bitOffset = i13;
            if (i13 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i11 + 1;
            }
            i7 = i12;
        }
        if (i5 > 0) {
            while (i5 >= 8) {
                int i14 = i7 << 8;
                byte[] bArr2 = this.bytes;
                int i15 = this.byteOffset;
                i7 = (bArr2[i15] & UnsignedBytes.MAX_VALUE) | i14;
                this.byteOffset = i15 + 1;
                i5 -= 8;
            }
            if (i5 > 0) {
                int i16 = 8 - i5;
                int i17 = ((((255 >> i16) << i16) & this.bytes[this.byteOffset]) >> i16) | (i7 << i5);
                this.bitOffset += i5;
                return i17;
            }
        }
        return i7;
    }
}
