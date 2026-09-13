package com.google.zxing.common;

import java.util.Arrays;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    private void ensureCapacity(int i5) {
        if (i5 > (this.bits.length << 5)) {
            int[] iArrMakeArray = makeArray(i5);
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, iArrMakeArray, 0, iArr.length);
            this.bits = iArrMakeArray;
        }
    }

    private static int[] makeArray(int i5) {
        return new int[(i5 + 31) / 32];
    }

    public void appendBit(boolean z6) {
        ensureCapacity(this.size + 1);
        if (z6) {
            int[] iArr = this.bits;
            int i5 = this.size;
            int i6 = i5 / 32;
            iArr[i6] = (1 << (i5 & 31)) | iArr[i6];
        }
        this.size++;
    }

    public void appendBitArray(BitArray bitArray) {
        int i5 = bitArray.size;
        ensureCapacity(this.size + i5);
        for (int i6 = 0; i6 < i5; i6++) {
            appendBit(bitArray.get(i6));
        }
    }

    public void appendBits(int i5, int i6) {
        if (i6 < 0 || i6 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i6);
        while (i6 > 0) {
            boolean z6 = true;
            if (((i5 >> (i6 - 1)) & 1) != 1) {
                z6 = false;
            }
            appendBit(z6);
            i6--;
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int i5 = 0; i5 < length; i5++) {
            this.bits[i5] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits);
    }

    public void flip(int i5) {
        int[] iArr = this.bits;
        int i6 = i5 / 32;
        iArr[i6] = (1 << (i5 & 31)) ^ iArr[i6];
    }

    public boolean get(int i5) {
        return ((1 << (i5 & 31)) & this.bits[i5 / 32]) != 0;
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public int getNextSet(int i5) {
        int i6 = this.size;
        if (i5 >= i6) {
            return i6;
        }
        int i7 = i5 / 32;
        int i8 = (~((1 << (i5 & 31)) - 1)) & this.bits[i7];
        while (i8 == 0) {
            i7++;
            int[] iArr = this.bits;
            if (i7 == iArr.length) {
                return this.size;
            }
            i8 = iArr[i7];
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i8) + (i7 << 5);
        int i9 = this.size;
        return iNumberOfTrailingZeros > i9 ? i9 : iNumberOfTrailingZeros;
    }

    public int getNextUnset(int i5) {
        int i6 = this.size;
        if (i5 >= i6) {
            return i6;
        }
        int i7 = i5 / 32;
        int i8 = (~((1 << (i5 & 31)) - 1)) & (~this.bits[i7]);
        while (i8 == 0) {
            i7++;
            int[] iArr = this.bits;
            if (i7 == iArr.length) {
                return this.size;
            }
            i8 = ~iArr[i7];
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i8) + (i7 << 5);
        int i9 = this.size;
        return iNumberOfTrailingZeros > i9 ? i9 : iNumberOfTrailingZeros;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    public int hashCode() {
        return Arrays.hashCode(this.bits) + (this.size * 31);
    }

    public boolean isRange(int i5, int i6, boolean z6) {
        if (i6 < i5 || i5 < 0 || i6 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i6 == i5) {
            return true;
        }
        int i7 = i6 - 1;
        int i8 = i5 / 32;
        int i9 = i7 / 32;
        int i10 = i8;
        while (i10 <= i9) {
            int i11 = (2 << (i10 >= i9 ? 31 & i7 : 31)) - (1 << (i10 > i8 ? 0 : i5 & 31));
            int i12 = this.bits[i10] & i11;
            if (!z6) {
                i11 = 0;
            }
            if (i12 != i11) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public void reverse() {
        int[] iArr = new int[this.bits.length];
        int i5 = (this.size - 1) / 32;
        int i6 = i5 + 1;
        for (int i7 = 0; i7 < i6; i7++) {
            long j6 = this.bits[i7];
            long j7 = ((j6 & 1431655765) << 1) | ((j6 >> 1) & 1431655765);
            long j8 = ((j7 & 858993459) << 2) | ((j7 >> 2) & 858993459);
            long j9 = ((j8 & 252645135) << 4) | ((j8 >> 4) & 252645135);
            long j10 = ((j9 & 16711935) << 8) | ((j9 >> 8) & 16711935);
            iArr[i5 - i7] = (int) (((j10 & 65535) << 16) | ((j10 >> 16) & 65535));
        }
        int i8 = this.size;
        int i9 = i6 << 5;
        if (i8 != i9) {
            int i10 = i9 - i8;
            int i11 = iArr[0] >>> i10;
            for (int i12 = 1; i12 < i6; i12++) {
                int i13 = iArr[i12];
                iArr[i12 - 1] = i11 | (i13 << (32 - i10));
                i11 = i13 >>> i10;
            }
            iArr[i5] = i11;
        }
        this.bits = iArr;
    }

    public void set(int i5) {
        int[] iArr = this.bits;
        int i6 = i5 / 32;
        iArr[i6] = (1 << (i5 & 31)) | iArr[i6];
    }

    public void setBulk(int i5, int i6) {
        this.bits[i5 / 32] = i6;
    }

    public void setRange(int i5, int i6) {
        if (i6 < i5 || i5 < 0 || i6 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i6 == i5) {
            return;
        }
        int i7 = i6 - 1;
        int i8 = i5 / 32;
        int i9 = i7 / 32;
        int i10 = i8;
        while (i10 <= i9) {
            int i11 = 31;
            int i12 = i10 > i8 ? 0 : i5 & 31;
            if (i10 >= i9) {
                i11 = 31 & i7;
            }
            int i13 = (2 << i11) - (1 << i12);
            int[] iArr = this.bits;
            iArr[i10] = i13 | iArr[i10];
            i10++;
        }
    }

    public void toBytes(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < 8; i10++) {
                if (get(i5)) {
                    i9 |= 1 << (7 - i10);
                }
                i5++;
            }
            bArr[i6 + i8] = (byte) i9;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.size);
        for (int i5 = 0; i5 < this.size; i5++) {
            if ((i5 & 7) == 0) {
                sb.append(Chars.SPACE);
            }
            sb.append(get(i5) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void xor(BitArray bitArray) {
        if (this.size != bitArray.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i5 = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i5 >= iArr.length) {
                return;
            }
            iArr[i5] = iArr[i5] ^ bitArray.bits[i5];
            i5++;
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitArray m1020clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }

    public BitArray(int i5) {
        this.size = i5;
        this.bits = makeArray(i5);
    }

    public BitArray(int[] iArr, int i5) {
        this.bits = iArr;
        this.size = i5;
    }
}
