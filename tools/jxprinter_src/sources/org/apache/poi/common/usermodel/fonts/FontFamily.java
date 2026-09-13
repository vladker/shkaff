package org.apache.poi.common.usermodel.fonts;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum FontFamily {
    FF_DONTCARE(0),
    FF_ROMAN(1),
    FF_SWISS(2),
    FF_MODERN(3),
    FF_SCRIPT(4),
    FF_DECORATIVE(5);

    private int nativeId;

    FontFamily(int i5) {
        this.nativeId = i5;
    }

    public static FontFamily valueOfPitchFamily(byte b) {
        return valueOf(b >>> 4);
    }

    public int getFlag() {
        return this.nativeId;
    }

    public static FontFamily valueOf(int i5) {
        for (FontFamily fontFamily : values()) {
            if (fontFamily.nativeId == i5) {
                return fontFamily;
            }
        }
        return null;
    }
}
