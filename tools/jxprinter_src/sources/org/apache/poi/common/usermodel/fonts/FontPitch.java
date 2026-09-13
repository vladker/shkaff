package org.apache.poi.common.usermodel.fonts;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum FontPitch {
    DEFAULT(0),
    FIXED(1),
    VARIABLE(2);

    private int nativeId;

    FontPitch(int i5) {
        this.nativeId = i5;
    }

    public static FontPitch valueOfPitchFamily(byte b) {
        return valueOf(b & 3);
    }

    public int getNativeId() {
        return this.nativeId;
    }

    public static byte getNativeId(FontPitch fontPitch, FontFamily fontFamily) {
        return (byte) (fontPitch.getNativeId() | (fontFamily.getFlag() << 4));
    }

    public static FontPitch valueOf(int i5) {
        for (FontPitch fontPitch : values()) {
            if (fontPitch.nativeId == i5) {
                return fontPitch;
            }
        }
        return null;
    }
}
