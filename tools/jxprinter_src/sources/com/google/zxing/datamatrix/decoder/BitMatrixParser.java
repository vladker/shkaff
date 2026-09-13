package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class BitMatrixParser {
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;

    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.version = readVersion(bitMatrix);
        BitMatrix bitMatrixExtractDataRegion = extractDataRegion(bitMatrix);
        this.mappingBitMatrix = bitMatrixExtractDataRegion;
        this.readMappingMatrix = new BitMatrix(bitMatrixExtractDataRegion.getWidth(), bitMatrixExtractDataRegion.getHeight());
    }

    private BitMatrix extractDataRegion(BitMatrix bitMatrix) {
        int symbolSizeRows = this.version.getSymbolSizeRows();
        int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() != symbolSizeRows) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int dataRegionSizeRows = this.version.getDataRegionSizeRows();
        int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
        int i5 = symbolSizeRows / dataRegionSizeRows;
        int i6 = symbolSizeColumns / dataRegionSizeColumns;
        BitMatrix bitMatrix2 = new BitMatrix(i6 * dataRegionSizeColumns, i5 * dataRegionSizeRows);
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i7 * dataRegionSizeRows;
            for (int i9 = 0; i9 < i6; i9++) {
                int i10 = i9 * dataRegionSizeColumns;
                for (int i11 = 0; i11 < dataRegionSizeRows; i11++) {
                    int i12 = ((dataRegionSizeRows + 2) * i7) + 1 + i11;
                    int i13 = i8 + i11;
                    for (int i14 = 0; i14 < dataRegionSizeColumns; i14++) {
                        if (bitMatrix.get(((dataRegionSizeColumns + 2) * i9) + 1 + i14, i12)) {
                            bitMatrix2.set(i10 + i14, i13);
                        }
                    }
                }
            }
        }
        return bitMatrix2;
    }

    private int readCorner1(int i5, int i6) {
        int i7 = i5 - 1;
        int i8 = (readModule(i7, 0, i5, i6) ? 1 : 0) << 1;
        if (readModule(i7, 1, i5, i6)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (readModule(i7, 2, i5, i6)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (readModule(0, i6 - 2, i5, i6)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        int i12 = i6 - 1;
        if (readModule(0, i12, i5, i6)) {
            i11 |= 1;
        }
        int i13 = i11 << 1;
        if (readModule(1, i12, i5, i6)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (readModule(2, i12, i5, i6)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return readModule(3, i12, i5, i6) ? i15 | 1 : i15;
    }

    private int readCorner2(int i5, int i6) {
        int i7 = (readModule(i5 + (-3), 0, i5, i6) ? 1 : 0) << 1;
        if (readModule(i5 - 2, 0, i5, i6)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(i5 - 1, 0, i5, i6)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (readModule(0, i6 - 4, i5, i6)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (readModule(0, i6 - 3, i5, i6)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (readModule(0, i6 - 2, i5, i6)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        int i13 = i6 - 1;
        if (readModule(0, i13, i5, i6)) {
            i12 |= 1;
        }
        int i14 = i12 << 1;
        return readModule(1, i13, i5, i6) ? i14 | 1 : i14;
    }

    private int readCorner3(int i5, int i6) {
        int i7 = i5 - 1;
        int i8 = (readModule(i7, 0, i5, i6) ? 1 : 0) << 1;
        int i9 = i6 - 1;
        if (readModule(i7, i9, i5, i6)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        int i11 = i6 - 3;
        if (readModule(0, i11, i5, i6)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        int i13 = i6 - 2;
        if (readModule(0, i13, i5, i6)) {
            i12 |= 1;
        }
        int i14 = i12 << 1;
        if (readModule(0, i9, i5, i6)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (readModule(1, i11, i5, i6)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (readModule(1, i13, i5, i6)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        return readModule(1, i9, i5, i6) ? i17 | 1 : i17;
    }

    private int readCorner4(int i5, int i6) {
        int i7 = (readModule(i5 + (-3), 0, i5, i6) ? 1 : 0) << 1;
        if (readModule(i5 - 2, 0, i5, i6)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (readModule(i5 - 1, 0, i5, i6)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (readModule(0, i6 - 2, i5, i6)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        int i11 = i6 - 1;
        if (readModule(0, i11, i5, i6)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (readModule(1, i11, i5, i6)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (readModule(2, i11, i5, i6)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return readModule(3, i11, i5, i6) ? i14 | 1 : i14;
    }

    private boolean readModule(int i5, int i6, int i7, int i8) {
        if (i5 < 0) {
            i5 += i7;
            i6 += 4 - ((i7 + 4) & 7);
        }
        if (i6 < 0) {
            i6 += i8;
            i5 += 4 - ((i8 + 4) & 7);
        }
        this.readMappingMatrix.set(i6, i5);
        return this.mappingBitMatrix.get(i6, i5);
    }

    private int readUtah(int i5, int i6, int i7, int i8) {
        int i9 = i5 - 2;
        int i10 = i6 - 2;
        int i11 = (readModule(i9, i10, i7, i8) ? 1 : 0) << 1;
        int i12 = i6 - 1;
        if (readModule(i9, i12, i7, i8)) {
            i11 |= 1;
        }
        int i13 = i11 << 1;
        int i14 = i5 - 1;
        if (readModule(i14, i10, i7, i8)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        if (readModule(i14, i12, i7, i8)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (readModule(i14, i6, i7, i8)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        if (readModule(i5, i10, i7, i8)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (readModule(i5, i12, i7, i8)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        return readModule(i5, i6, i7, i8) ? i19 | 1 : i19;
    }

    private static Version readVersion(BitMatrix bitMatrix) {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    public Version getVersion() {
        return this.version;
    }

    public byte[] readCodewords() throws FormatException {
        byte[] bArr = new byte[this.version.getTotalCodewords()];
        int height = this.mappingBitMatrix.getHeight();
        int width = this.mappingBitMatrix.getWidth();
        int i5 = 0;
        boolean z6 = false;
        int i6 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        int i7 = 4;
        while (true) {
            if (i7 == height && i5 == 0 && !z6) {
                bArr[i6] = (byte) readCorner1(height, width);
                i7 -= 2;
                i5 += 2;
                i6++;
                z6 = true;
            } else {
                int i8 = height - 2;
                if (i7 == i8 && i5 == 0 && (width & 3) != 0 && !z7) {
                    bArr[i6] = (byte) readCorner2(height, width);
                    i7 -= 2;
                    i5 += 2;
                    i6++;
                    z7 = true;
                } else if (i7 == height + 4 && i5 == 2 && (width & 7) == 0 && !z8) {
                    bArr[i6] = (byte) readCorner3(height, width);
                    i7 -= 2;
                    i5 += 2;
                    i6++;
                    z8 = true;
                } else if (i7 == i8 && i5 == 0 && (width & 7) == 4 && !z9) {
                    bArr[i6] = (byte) readCorner4(height, width);
                    i7 -= 2;
                    i5 += 2;
                    i6++;
                    z9 = true;
                } else {
                    while (true) {
                        if (i7 < height && i5 >= 0 && !this.readMappingMatrix.get(i5, i7)) {
                            bArr[i6] = (byte) readUtah(i7, i5, height, width);
                            i6++;
                        }
                        int i9 = i7 - 2;
                        int i10 = i5 + 2;
                        if (i9 < 0 || i10 >= width) {
                            break;
                        }
                        i7 = i9;
                        i5 = i10;
                    }
                    int i11 = i7 - 1;
                    int i12 = i5 + 5;
                    while (true) {
                        if (i11 >= 0 && i12 < width && !this.readMappingMatrix.get(i12, i11)) {
                            bArr[i6] = (byte) readUtah(i11, i12, height, width);
                            i6++;
                        }
                        int i13 = i11 + 2;
                        int i14 = i12 - 2;
                        if (i13 >= height || i14 < 0) {
                            break;
                        }
                        i11 = i13;
                        i12 = i14;
                    }
                    i7 = i11 + 5;
                    i5 = i12 - 1;
                }
            }
            if (i7 >= height && i5 >= width) {
                break;
            }
        }
        if (i6 == this.version.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }
}
