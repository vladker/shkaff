package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.pdf417.PDF417Common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ModulusGF {
    public static final ModulusGF PDF417_GF = new ModulusGF(PDF417Common.NUMBER_OF_CODEWORDS, 3);
    private final int[] expTable;
    private final int[] logTable;
    private final int modulus;
    private final ModulusPoly one;
    private final ModulusPoly zero;

    private ModulusGF(int i5, int i6) {
        this.modulus = i5;
        this.expTable = new int[i5];
        this.logTable = new int[i5];
        int i7 = 1;
        for (int i8 = 0; i8 < i5; i8++) {
            this.expTable[i8] = i7;
            i7 = (i7 * i6) % i5;
        }
        for (int i9 = 0; i9 < i5 - 1; i9++) {
            this.logTable[this.expTable[i9]] = i9;
        }
        this.zero = new ModulusPoly(this, new int[]{0});
        this.one = new ModulusPoly(this, new int[]{1});
    }

    public int add(int i5, int i6) {
        return (i5 + i6) % this.modulus;
    }

    public ModulusPoly buildMonomial(int i5, int i6) {
        if (i5 < 0) {
            throw new IllegalArgumentException();
        }
        if (i6 == 0) {
            return this.zero;
        }
        int[] iArr = new int[i5 + 1];
        iArr[0] = i6;
        return new ModulusPoly(this, iArr);
    }

    public int exp(int i5) {
        return this.expTable[i5];
    }

    public ModulusPoly getOne() {
        return this.one;
    }

    public int getSize() {
        return this.modulus;
    }

    public ModulusPoly getZero() {
        return this.zero;
    }

    public int inverse(int i5) {
        if (i5 != 0) {
            return this.expTable[(this.modulus - this.logTable[i5]) - 1];
        }
        throw new ArithmeticException();
    }

    public int log(int i5) {
        if (i5 != 0) {
            return this.logTable[i5];
        }
        throw new IllegalArgumentException();
    }

    public int multiply(int i5, int i6) {
        if (i5 == 0 || i6 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[i5] + iArr2[i6]) % (this.modulus - 1)];
    }

    public int subtract(int i5, int i6) {
        int i7 = this.modulus;
        return ((i5 + i7) - i6) % i7;
    }
}
