package com.google.zxing.common;

import androidx.exifinterface.media.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i5) {
        this(i5, i5);
    }

    private String buildToString(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder((this.width + 1) * this.height);
        for (int i5 = 0; i5 < this.height; i5++) {
            for (int i6 = 0; i6 < this.width; i6++) {
                sb.append(get(i6, i5) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i5 = -1;
        int length = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (length < str.length()) {
            if (str.charAt(length) == '\n' || str.charAt(length) == '\r') {
                if (i6 > i7) {
                    if (i5 == -1) {
                        i5 = i6 - i7;
                    } else if (i6 - i7 != i5) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i8++;
                    i7 = i6;
                }
                length++;
            } else {
                if (str.substring(length, str2.length() + length).equals(str2)) {
                    length += str2.length();
                    zArr[i6] = true;
                } else {
                    if (!str.substring(length, str3.length() + length).equals(str3)) {
                        throw new IllegalArgumentException(a.j(str, length, new StringBuilder("illegal character encountered: ")));
                    }
                    length += str3.length();
                    zArr[i6] = false;
                }
                i6++;
            }
        }
        if (i6 > i7) {
            if (i5 == -1) {
                i5 = i6 - i7;
            } else if (i6 - i7 != i5) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i8++;
        }
        BitMatrix bitMatrix = new BitMatrix(i5, i8);
        for (int i9 = 0; i9 < i6; i9++) {
            if (zArr[i9]) {
                bitMatrix.set(i9 % i5, i9 / i5);
            }
        }
        return bitMatrix;
    }

    public void clear() {
        int length = this.bits.length;
        for (int i5 = 0; i5 < length; i5++) {
            this.bits[i5] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
    }

    public void flip(int i5, int i6) {
        int i7 = (i5 / 32) + (i6 * this.rowSize);
        int[] iArr = this.bits;
        iArr[i7] = (1 << (i5 & 31)) ^ iArr[i7];
    }

    public boolean get(int i5, int i6) {
        return ((this.bits[(i5 / 32) + (i6 * this.rowSize)] >>> (i5 & 31)) & 1) != 0;
    }

    public int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i5 = this.rowSize;
        int i6 = length / i5;
        int i7 = (length % i5) << 5;
        int i8 = 31;
        while ((this.bits[length] >>> i8) == 0) {
            i8--;
        }
        return new int[]{i7 + i8, i6};
    }

    public int[] getEnclosingRectangle() {
        int i5 = this.width;
        int i6 = this.height;
        int i7 = -1;
        int i8 = -1;
        for (int i9 = 0; i9 < this.height; i9++) {
            int i10 = 0;
            while (true) {
                int i11 = this.rowSize;
                if (i10 < i11) {
                    int i12 = this.bits[(i11 * i9) + i10];
                    if (i12 != 0) {
                        if (i9 < i6) {
                            i6 = i9;
                        }
                        if (i9 > i8) {
                            i8 = i9;
                        }
                        int i13 = i10 << 5;
                        if (i13 < i5) {
                            int i14 = 0;
                            while ((i12 << (31 - i14)) == 0) {
                                i14++;
                            }
                            int i15 = i14 + i13;
                            if (i15 < i5) {
                                i5 = i15;
                            }
                        }
                        if (i13 + 31 > i7) {
                            int i16 = 31;
                            while ((i12 >>> i16) == 0) {
                                i16--;
                            }
                            int i17 = i13 + i16;
                            if (i17 > i7) {
                                i7 = i17;
                            }
                        }
                    }
                    i10++;
                }
            }
        }
        if (i7 < i5 || i8 < i6) {
            return null;
        }
        return new int[]{i5, i6, (i7 - i5) + 1, (i8 - i6) + 1};
    }

    public int getHeight() {
        return this.height;
    }

    public BitArray getRow(int i5, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new BitArray(this.width);
        } else {
            bitArray.clear();
        }
        int i6 = i5 * this.rowSize;
        for (int i7 = 0; i7 < this.rowSize; i7++) {
            bitArray.setBulk(i7 << 5, this.bits[i6 + i7]);
        }
        return bitArray;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public int[] getTopLeftOnBit() {
        int[] iArr;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            iArr = this.bits;
            if (i6 >= iArr.length || iArr[i6] != 0) {
                break;
            }
            i6++;
        }
        if (i6 == iArr.length) {
            return null;
        }
        int i7 = this.rowSize;
        int i8 = i6 / i7;
        int i9 = (i6 % i7) << 5;
        while ((iArr[i6] << (31 - i5)) == 0) {
            i5++;
        }
        return new int[]{i9 + i5, i8};
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i5 = this.width;
        return Arrays.hashCode(this.bits) + (((((((i5 * 31) + i5) * 31) + this.height) * 31) + this.rowSize) * 31);
    }

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        BitArray bitArray = new BitArray(width);
        BitArray bitArray2 = new BitArray(width);
        for (int i5 = 0; i5 < (height + 1) / 2; i5++) {
            bitArray = getRow(i5, bitArray);
            int i6 = (height - 1) - i5;
            bitArray2 = getRow(i6, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(i5, bitArray2);
            setRow(i6, bitArray);
        }
    }

    public void set(int i5, int i6) {
        int i7 = (i5 / 32) + (i6 * this.rowSize);
        int[] iArr = this.bits;
        iArr[i7] = (1 << (i5 & 31)) | iArr[i7];
    }

    public void setRegion(int i5, int i6, int i7, int i8) {
        if (i6 < 0 || i5 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i8 <= 0 || i7 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i9 = i7 + i5;
        int i10 = i8 + i6;
        if (i10 > this.height || i9 > this.width) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i6 < i10) {
            int i11 = this.rowSize * i6;
            for (int i12 = i5; i12 < i9; i12++) {
                int[] iArr = this.bits;
                int i13 = (i12 / 32) + i11;
                iArr[i13] = iArr[i13] | (1 << (i12 & 31));
            }
            i6++;
        }
    }

    public void setRow(int i5, BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.bits;
        int i6 = this.rowSize;
        System.arraycopy(bitArray2, 0, iArr, i5 * i6, i6);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public void unset(int i5, int i6) {
        int i7 = (i5 / 32) + (i6 * this.rowSize);
        int[] iArr = this.bits;
        iArr[i7] = (~(1 << (i5 & 31))) & iArr[i7];
    }

    public void xor(BitMatrix bitMatrix) {
        if (this.width != bitMatrix.getWidth() || this.height != bitMatrix.getHeight() || this.rowSize != bitMatrix.getRowSize()) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        BitArray bitArray = new BitArray((this.width / 32) + 1);
        for (int i5 = 0; i5 < this.height; i5++) {
            int i6 = this.rowSize * i5;
            int[] bitArray2 = bitMatrix.getRow(i5, bitArray).getBitArray();
            for (int i7 = 0; i7 < this.rowSize; i7++) {
                int[] iArr = this.bits;
                int i8 = i6 + i7;
                iArr[i8] = iArr[i8] ^ bitArray2[i7];
            }
        }
    }

    public BitMatrix(int i5, int i6) {
        if (i5 <= 0 || i6 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = i5;
        this.height = i6;
        int i7 = (i5 + 31) / 32;
        this.rowSize = i7;
        this.bits = new int[i7 * i6];
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitMatrix m1021clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }

    public String toString(String str, String str2) {
        return buildToString(str, str2, "\n");
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        return buildToString(str, str2, str3);
    }

    private BitMatrix(int i5, int i6, int i7, int[] iArr) {
        this.width = i5;
        this.height = i6;
        this.rowSize = i7;
        this.bits = iArr;
    }
}
