package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.Formatter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class DetectionResult {
    private static final int ADJUST_ROW_NUMBER_SKIP = 2;
    private final int barcodeColumnCount;
    private final BarcodeMetadata barcodeMetadata;
    private BoundingBox boundingBox;
    private final DetectionResultColumn[] detectionResultColumns;

    public DetectionResult(BarcodeMetadata barcodeMetadata, BoundingBox boundingBox) {
        this.barcodeMetadata = barcodeMetadata;
        int columnCount = barcodeMetadata.getColumnCount();
        this.barcodeColumnCount = columnCount;
        this.boundingBox = boundingBox;
        this.detectionResultColumns = new DetectionResultColumn[columnCount + 2];
    }

    private void adjustIndicatorColumnRowNumbers(DetectionResultColumn detectionResultColumn) {
        if (detectionResultColumn != null) {
            ((DetectionResultRowIndicatorColumn) detectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
        }
    }

    private static boolean adjustRowNumber(Codeword codeword, Codeword codeword2) {
        if (codeword2 == null || !codeword2.hasValidRowNumber() || codeword2.getBucket() != codeword.getBucket()) {
            return false;
        }
        codeword.setRowNumber(codeword2.getRowNumber());
        return true;
    }

    private static int adjustRowNumberIfValid(int i5, int i6, Codeword codeword) {
        if (codeword == null || codeword.hasValidRowNumber()) {
            return i6;
        }
        if (!codeword.isValidRowNumber(i5)) {
            return i6 + 1;
        }
        codeword.setRowNumber(i5);
        return 0;
    }

    private int adjustRowNumbers() {
        int iAdjustRowNumbersByRow = adjustRowNumbersByRow();
        if (iAdjustRowNumbersByRow == 0) {
            return 0;
        }
        for (int i5 = 1; i5 < this.barcodeColumnCount + 1; i5++) {
            Codeword[] codewords = this.detectionResultColumns[i5].getCodewords();
            for (int i6 = 0; i6 < codewords.length; i6++) {
                Codeword codeword = codewords[i6];
                if (codeword != null && !codeword.hasValidRowNumber()) {
                    adjustRowNumbers(i5, i6, codewords);
                }
            }
        }
        return iAdjustRowNumbersByRow;
    }

    private int adjustRowNumbersByRow() {
        adjustRowNumbersFromBothRI();
        return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
    }

    private void adjustRowNumbersFromBothRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null || detectionResultColumnArr[this.barcodeColumnCount + 1] == null) {
            return;
        }
        Codeword[] codewords = detectionResultColumn.getCodewords();
        Codeword[] codewords2 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
        for (int i5 = 0; i5 < codewords.length; i5++) {
            Codeword codeword = codewords[i5];
            if (codeword != null && codewords2[i5] != null && codeword.getRowNumber() == codewords2[i5].getRowNumber()) {
                for (int i6 = 1; i6 <= this.barcodeColumnCount; i6++) {
                    Codeword codeword2 = this.detectionResultColumns[i6].getCodewords()[i5];
                    if (codeword2 != null) {
                        codeword2.setRowNumber(codewords[i5].getRowNumber());
                        if (!codeword2.hasValidRowNumber()) {
                            this.detectionResultColumns[i6].getCodewords()[i5] = null;
                        }
                    }
                }
            }
        }
    }

    private int adjustRowNumbersFromLRI() {
        DetectionResultColumn detectionResultColumn = this.detectionResultColumns[0];
        if (detectionResultColumn == null) {
            return 0;
        }
        Codeword[] codewords = detectionResultColumn.getCodewords();
        int i5 = 0;
        for (int i6 = 0; i6 < codewords.length; i6++) {
            Codeword codeword = codewords[i6];
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber();
                int iAdjustRowNumberIfValid = 0;
                for (int i7 = 1; i7 < this.barcodeColumnCount + 1 && iAdjustRowNumberIfValid < 2; i7++) {
                    Codeword codeword2 = this.detectionResultColumns[i7].getCodewords()[i6];
                    if (codeword2 != null) {
                        iAdjustRowNumberIfValid = adjustRowNumberIfValid(rowNumber, iAdjustRowNumberIfValid, codeword2);
                        if (!codeword2.hasValidRowNumber()) {
                            i5++;
                        }
                    }
                }
            }
        }
        return i5;
    }

    private int adjustRowNumbersFromRRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        int i5 = this.barcodeColumnCount;
        if (detectionResultColumnArr[i5 + 1] == null) {
            return 0;
        }
        Codeword[] codewords = detectionResultColumnArr[i5 + 1].getCodewords();
        int i6 = 0;
        for (int i7 = 0; i7 < codewords.length; i7++) {
            Codeword codeword = codewords[i7];
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber();
                int iAdjustRowNumberIfValid = 0;
                for (int i8 = this.barcodeColumnCount + 1; i8 > 0 && iAdjustRowNumberIfValid < 2; i8--) {
                    Codeword codeword2 = this.detectionResultColumns[i8].getCodewords()[i7];
                    if (codeword2 != null) {
                        iAdjustRowNumberIfValid = adjustRowNumberIfValid(rowNumber, iAdjustRowNumberIfValid, codeword2);
                        if (!codeword2.hasValidRowNumber()) {
                            i6++;
                        }
                    }
                }
            }
        }
        return i6;
    }

    public int getBarcodeColumnCount() {
        return this.barcodeColumnCount;
    }

    public int getBarcodeECLevel() {
        return this.barcodeMetadata.getErrorCorrectionLevel();
    }

    public int getBarcodeRowCount() {
        return this.barcodeMetadata.getRowCount();
    }

    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public DetectionResultColumn getDetectionResultColumn(int i5) {
        return this.detectionResultColumns[i5];
    }

    public DetectionResultColumn[] getDetectionResultColumns() {
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
        int i5 = PDF417Common.MAX_CODEWORDS_IN_BARCODE;
        while (true) {
            int iAdjustRowNumbers = adjustRowNumbers();
            if (iAdjustRowNumbers <= 0 || iAdjustRowNumbers >= i5) {
                break;
            }
            i5 = iAdjustRowNumbers;
        }
        return this.detectionResultColumns;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public void setDetectionResultColumn(int i5, DetectionResultColumn detectionResultColumn) {
        this.detectionResultColumns[i5] = detectionResultColumn;
    }

    public String toString() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null) {
            detectionResultColumn = detectionResultColumnArr[this.barcodeColumnCount + 1];
        }
        Formatter formatter = new Formatter();
        for (int i5 = 0; i5 < detectionResultColumn.getCodewords().length; i5++) {
            formatter.format("CW %3d:", Integer.valueOf(i5));
            for (int i6 = 0; i6 < this.barcodeColumnCount + 2; i6++) {
                DetectionResultColumn detectionResultColumn2 = this.detectionResultColumns[i6];
                if (detectionResultColumn2 == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    Codeword codeword = detectionResultColumn2.getCodewords()[i5];
                    if (codeword == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                    }
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }

    private void adjustRowNumbers(int i5, int i6, Codeword[] codewordArr) {
        Codeword codeword = codewordArr[i6];
        Codeword[] codewords = this.detectionResultColumns[i5 - 1].getCodewords();
        DetectionResultColumn detectionResultColumn = this.detectionResultColumns[i5 + 1];
        Codeword[] codewords2 = detectionResultColumn != null ? detectionResultColumn.getCodewords() : codewords;
        Codeword[] codewordArr2 = new Codeword[14];
        codewordArr2[2] = codewords[i6];
        codewordArr2[3] = codewords2[i6];
        if (i6 > 0) {
            int i7 = i6 - 1;
            codewordArr2[0] = codewordArr[i7];
            codewordArr2[4] = codewords[i7];
            codewordArr2[5] = codewords2[i7];
        }
        if (i6 > 1) {
            int i8 = i6 - 2;
            codewordArr2[8] = codewordArr[i8];
            codewordArr2[10] = codewords[i8];
            codewordArr2[11] = codewords2[i8];
        }
        if (i6 < codewordArr.length - 1) {
            int i9 = i6 + 1;
            codewordArr2[1] = codewordArr[i9];
            codewordArr2[6] = codewords[i9];
            codewordArr2[7] = codewords2[i9];
        }
        if (i6 < codewordArr.length - 2) {
            int i10 = i6 + 2;
            codewordArr2[9] = codewordArr[i10];
            codewordArr2[12] = codewords[i10];
            codewordArr2[13] = codewords2[i10];
        }
        for (int i11 = 0; i11 < 14 && !adjustRowNumber(codeword, codewordArr2[i11]); i11++) {
        }
    }
}
