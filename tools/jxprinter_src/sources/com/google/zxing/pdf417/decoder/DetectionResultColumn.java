package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final BoundingBox boundingBox;
    private final Codeword[] codewords;

    public DetectionResultColumn(BoundingBox boundingBox) {
        this.boundingBox = new BoundingBox(boundingBox);
        this.codewords = new Codeword[(boundingBox.getMaxY() - boundingBox.getMinY()) + 1];
    }

    public final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public final Codeword getCodeword(int i5) {
        return this.codewords[imageRowToCodewordIndex(i5)];
    }

    public final Codeword getCodewordNearby(int i5) {
        Codeword codeword;
        Codeword codeword2;
        Codeword codeword3 = getCodeword(i5);
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i6 = 1; i6 < 5; i6++) {
            int iImageRowToCodewordIndex = imageRowToCodewordIndex(i5) - i6;
            if (iImageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[iImageRowToCodewordIndex]) != null) {
                return codeword2;
            }
            int iImageRowToCodewordIndex2 = imageRowToCodewordIndex(i5) + i6;
            Codeword[] codewordArr = this.codewords;
            if (iImageRowToCodewordIndex2 < codewordArr.length && (codeword = codewordArr[iImageRowToCodewordIndex2]) != null) {
                return codeword;
            }
        }
        return null;
    }

    public final Codeword[] getCodewords() {
        return this.codewords;
    }

    public final int imageRowToCodewordIndex(int i5) {
        return i5 - this.boundingBox.getMinY();
    }

    public final void setCodeword(int i5, Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(i5)] = codeword;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        int i5 = 0;
        for (Codeword codeword : this.codewords) {
            if (codeword == null) {
                formatter.format("%3d:    |   %n", Integer.valueOf(i5));
                i5++;
            } else {
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i5), Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                i5++;
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
