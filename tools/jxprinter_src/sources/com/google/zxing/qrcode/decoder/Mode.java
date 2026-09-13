package com.google.zxing.qrcode.decoder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public enum Mode {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);

    private final int bits;
    private final int[] characterCountBitsForVersions;

    Mode(int[] iArr, int i5) {
        this.characterCountBitsForVersions = iArr;
        this.bits = i5;
    }

    public static Mode forBits(int i5) {
        if (i5 == 0) {
            return TERMINATOR;
        }
        if (i5 == 1) {
            return NUMERIC;
        }
        if (i5 == 2) {
            return ALPHANUMERIC;
        }
        if (i5 == 3) {
            return STRUCTURED_APPEND;
        }
        if (i5 == 4) {
            return BYTE;
        }
        if (i5 == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i5 == 7) {
            return ECI;
        }
        if (i5 == 8) {
            return KANJI;
        }
        if (i5 == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i5 == 13) {
            return HANZI;
        }
        throw new IllegalArgumentException();
    }

    public int getBits() {
        return this.bits;
    }

    public int getCharacterCountBits(Version version) {
        char c;
        int versionNumber = version.getVersionNumber();
        if (versionNumber <= 9) {
            c = 0;
        } else {
            c = versionNumber <= 26 ? (char) 1 : (char) 2;
        }
        return this.characterCountBitsForVersions[c];
    }
}
