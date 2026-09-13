package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Version {
    private static final Version[] VERSIONS = buildVersions();
    private final int dataRegionSizeColumns;
    private final int dataRegionSizeRows;
    private final ECBlocks ecBlocks;
    private final int symbolSizeColumns;
    private final int symbolSizeRows;
    private final int totalCodewords;
    private final int versionNumber;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ECB {
        private final int count;
        private final int dataCodewords;

        public int getCount() {
            return this.count;
        }

        public int getDataCodewords() {
            return this.dataCodewords;
        }

        private ECB(int i5, int i6) {
            this.count = i5;
            this.dataCodewords = i6;
        }
    }

    private Version(int i5, int i6, int i7, int i8, int i9, ECBlocks eCBlocks) {
        this.versionNumber = i5;
        this.symbolSizeRows = i6;
        this.symbolSizeColumns = i7;
        this.dataRegionSizeRows = i8;
        this.dataRegionSizeColumns = i9;
        this.ecBlocks = eCBlocks;
        int eCCodewords = eCBlocks.getECCodewords();
        int dataCodewords = 0;
        for (ECB ecb : eCBlocks.getECBlocks()) {
            dataCodewords += (ecb.getDataCodewords() + eCCodewords) * ecb.getCount();
        }
        this.totalCodewords = dataCodewords;
    }

    private static Version[] buildVersions() {
        int i5 = 1;
        int i6 = 5;
        Version version = new Version(1, 10, 10, 8, 8, new ECBlocks(i6, new ECB(i5, 3)));
        Version version2 = new Version(2, 12, 12, 10, 10, new ECBlocks(7, new ECB(i5, i6)));
        Version version3 = new Version(3, 14, 14, 12, 12, new ECBlocks(10, new ECB(i5, 8)));
        int i7 = 12;
        Version version4 = new Version(4, 16, 16, 14, 14, new ECBlocks(i7, new ECB(i5, i7)));
        int i8 = 18;
        Version version5 = new Version(5, 18, 18, 16, 16, new ECBlocks(14, new ECB(i5, i8)));
        Version version6 = new Version(6, 20, 20, 18, 18, new ECBlocks(i8, new ECB(i5, 22)));
        Version version7 = new Version(7, 22, 22, 20, 20, new ECBlocks(20, new ECB(i5, 30)));
        int i9 = 36;
        Version version8 = new Version(8, 24, 24, 22, 22, new ECBlocks(24, new ECB(i5, i9)));
        Version version9 = new Version(9, 26, 26, 24, 24, new ECBlocks(28, new ECB(i5, 44)));
        Version version10 = new Version(10, 32, 32, 14, 14, new ECBlocks(i9, new ECB(i5, 62)));
        int i10 = 42;
        Version version11 = new Version(11, 36, 36, 16, 16, new ECBlocks(i10, new ECB(i5, 86)));
        int i11 = 114;
        int i12 = 48;
        Version version12 = new Version(12, 40, 40, 18, 18, new ECBlocks(i12, new ECB(i5, i11)));
        int i13 = 144;
        int i14 = 56;
        Version version13 = new Version(13, 44, 44, 20, 20, new ECBlocks(i14, new ECB(i5, i13)));
        Version version14 = new Version(14, 48, 48, 22, 22, new ECBlocks(68, new ECB(i5, 174)));
        int i15 = 2;
        Version version15 = new Version(15, 52, 52, 24, 24, new ECBlocks(i10, new ECB(i15, 102)));
        Version version16 = new Version(16, 64, 64, 14, 14, new ECBlocks(i14, new ECB(i15, 140)));
        int i16 = 4;
        Version version17 = new Version(17, 72, 72, 16, 16, new ECBlocks(i9, new ECB(i16, 92)));
        Version version18 = new Version(18, 80, 80, 18, 18, new ECBlocks(i12, new ECB(i16, i11)));
        Version version19 = new Version(19, 88, 88, 20, 20, new ECBlocks(i14, new ECB(i16, i13)));
        Version version20 = new Version(20, 96, 96, 22, 22, new ECBlocks(68, new ECB(i16, 174)));
        Version version21 = new Version(21, 104, 104, 24, 24, new ECBlocks(i14, new ECB(6, 136)));
        Version version22 = new Version(22, 120, 120, 18, 18, new ECBlocks(68, new ECB(6, 175)));
        Version version23 = new Version(23, 132, 132, 20, 20, new ECBlocks(62, new ECB(8, 163)));
        Version version24 = new Version(24, 144, 144, 22, 22, new ECBlocks(62, new ECB(8, 156), new ECB(i15, 155)));
        int i17 = 1;
        Version version25 = new Version(25, 8, 18, 6, 16, new ECBlocks(7, new ECB(i17, 5)));
        Version version26 = new Version(26, 8, 32, 6, 14, new ECBlocks(11, new ECB(i17, 10)));
        int i18 = 1;
        return new Version[]{version, version2, version3, version4, version5, version6, version7, version8, version9, version10, version11, version12, version13, version14, version15, version16, version17, version18, version19, version20, version21, version22, version23, version24, version25, version26, new Version(27, 12, 26, 10, 24, new ECBlocks(14, new ECB(i18, 16))), new Version(28, 12, 36, 10, 16, new ECBlocks(18, new ECB(i18, 22))), new Version(29, 16, 36, 14, 16, new ECBlocks(24, new ECB(1, 32))), new Version(30, 16, 48, 14, 22, new ECBlocks(28, new ECB(1, 49)))};
    }

    public static Version getVersionForDimensions(int i5, int i6) throws FormatException {
        if ((i5 & 1) != 0 || (i6 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (Version version : VERSIONS) {
            if (version.symbolSizeRows == i5 && version.symbolSizeColumns == i6) {
                return version;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public int getDataRegionSizeColumns() {
        return this.dataRegionSizeColumns;
    }

    public int getDataRegionSizeRows() {
        return this.dataRegionSizeRows;
    }

    public ECBlocks getECBlocks() {
        return this.ecBlocks;
    }

    public int getSymbolSizeColumns() {
        return this.symbolSizeColumns;
    }

    public int getSymbolSizeRows() {
        return this.symbolSizeRows;
    }

    public int getTotalCodewords() {
        return this.totalCodewords;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public String toString() {
        return String.valueOf(this.versionNumber);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ECBlocks {
        private final ECB[] ecBlocks;
        private final int ecCodewords;

        public ECB[] getECBlocks() {
            return this.ecBlocks;
        }

        public int getECCodewords() {
            return this.ecCodewords;
        }

        private ECBlocks(int i5, ECB ecb) {
            this.ecCodewords = i5;
            this.ecBlocks = new ECB[]{ecb};
        }

        private ECBlocks(int i5, ECB ecb, ECB ecb2) {
            this.ecCodewords = i5;
            this.ecBlocks = new ECB[]{ecb, ecb2};
        }
    }
}
