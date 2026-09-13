package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultPlacement {
    private final byte[] bits;
    private final CharSequence codewords;
    private final int numcols;
    private final int numrows;

    public DefaultPlacement(CharSequence charSequence, int i5, int i6) {
        this.codewords = charSequence;
        this.numcols = i5;
        this.numrows = i6;
        byte[] bArr = new byte[i5 * i6];
        this.bits = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    private void corner1(int i5) {
        module(this.numrows - 1, 0, i5, 1);
        module(this.numrows - 1, 1, i5, 2);
        module(this.numrows - 1, 2, i5, 3);
        module(0, this.numcols - 2, i5, 4);
        module(0, this.numcols - 1, i5, 5);
        module(1, this.numcols - 1, i5, 6);
        module(2, this.numcols - 1, i5, 7);
        module(3, this.numcols - 1, i5, 8);
    }

    private void corner2(int i5) {
        module(this.numrows - 3, 0, i5, 1);
        module(this.numrows - 2, 0, i5, 2);
        module(this.numrows - 1, 0, i5, 3);
        module(0, this.numcols - 4, i5, 4);
        module(0, this.numcols - 3, i5, 5);
        module(0, this.numcols - 2, i5, 6);
        module(0, this.numcols - 1, i5, 7);
        module(1, this.numcols - 1, i5, 8);
    }

    private void corner3(int i5) {
        module(this.numrows - 3, 0, i5, 1);
        module(this.numrows - 2, 0, i5, 2);
        module(this.numrows - 1, 0, i5, 3);
        module(0, this.numcols - 2, i5, 4);
        module(0, this.numcols - 1, i5, 5);
        module(1, this.numcols - 1, i5, 6);
        module(2, this.numcols - 1, i5, 7);
        module(3, this.numcols - 1, i5, 8);
    }

    private void corner4(int i5) {
        module(this.numrows - 1, 0, i5, 1);
        module(this.numrows - 1, this.numcols - 1, i5, 2);
        module(0, this.numcols - 3, i5, 3);
        module(0, this.numcols - 2, i5, 4);
        module(0, this.numcols - 1, i5, 5);
        module(1, this.numcols - 3, i5, 6);
        module(1, this.numcols - 2, i5, 7);
        module(1, this.numcols - 1, i5, 8);
    }

    private boolean hasBit(int i5, int i6) {
        return this.bits[(i6 * this.numcols) + i5] >= 0;
    }

    private void module(int i5, int i6, int i7, int i8) {
        if (i5 < 0) {
            int i9 = this.numrows;
            i5 += i9;
            i6 += 4 - ((i9 + 4) % 8);
        }
        if (i6 < 0) {
            int i10 = this.numcols;
            i6 += i10;
            i5 += 4 - ((i10 + 4) % 8);
        }
        setBit(i6, i5, (this.codewords.charAt(i7) & (1 << (8 - i8))) != 0);
    }

    private void setBit(int i5, int i6, boolean z6) {
        this.bits[(i6 * this.numcols) + i5] = z6 ? (byte) 1 : (byte) 0;
    }

    private void utah(int i5, int i6, int i7) {
        int i8 = i5 - 2;
        int i9 = i6 - 2;
        module(i8, i9, i7, 1);
        int i10 = i6 - 1;
        module(i8, i10, i7, 2);
        int i11 = i5 - 1;
        module(i11, i9, i7, 3);
        module(i11, i10, i7, 4);
        module(i11, i6, i7, 5);
        module(i5, i9, i7, 6);
        module(i5, i10, i7, 7);
        module(i5, i6, i7, 8);
    }

    public final boolean getBit(int i5, int i6) {
        return this.bits[(i6 * this.numcols) + i5] == 1;
    }

    public final byte[] getBits() {
        return this.bits;
    }

    public final int getNumcols() {
        return this.numcols;
    }

    public final int getNumrows() {
        return this.numrows;
    }

    public final void place() {
        int i5;
        int i6;
        int i7 = 0;
        int i8 = 0;
        int i9 = 4;
        while (true) {
            if (i9 == this.numrows && i7 == 0) {
                corner1(i8);
                i8++;
            }
            if (i9 == this.numrows - 2 && i7 == 0 && this.numcols % 4 != 0) {
                corner2(i8);
                i8++;
            }
            if (i9 == this.numrows - 2 && i7 == 0 && this.numcols % 8 == 4) {
                corner3(i8);
                i8++;
            }
            if (i9 == this.numrows + 4 && i7 == 2 && this.numcols % 8 == 0) {
                corner4(i8);
                i8++;
            }
            while (true) {
                if (i9 < this.numrows && i7 >= 0 && !hasBit(i7, i9)) {
                    utah(i9, i7, i8);
                    i8++;
                }
                int i10 = i9 - 2;
                int i11 = i7 + 2;
                if (i10 < 0 || i11 >= this.numcols) {
                    break;
                }
                i9 = i10;
                i7 = i11;
            }
            int i12 = i9 - 1;
            int i13 = i7 + 5;
            while (true) {
                if (i12 >= 0 && i13 < this.numcols && !hasBit(i13, i12)) {
                    utah(i12, i13, i8);
                    i8++;
                }
                int i14 = i12 + 2;
                int i15 = i13 - 2;
                i5 = this.numrows;
                if (i14 >= i5 || i15 < 0) {
                    break;
                }
                i12 = i14;
                i13 = i15;
            }
            i9 = i12 + 5;
            i7 = i13 - 1;
            if (i9 >= i5 && i7 >= (i6 = this.numcols)) {
                break;
            }
        }
        if (hasBit(i6 - 1, i5 - 1)) {
            return;
        }
        setBit(this.numcols - 1, this.numrows - 1, true);
        setBit(this.numcols - 2, this.numrows - 2, true);
    }
}
