package org.apache.poi.hssf.usermodel;

import com.google.common.primitives.UnsignedBytes;
import java.util.Locale;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFPalette {
    private PaletteRecord _palette;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CustomColor extends HSSFColor {
        private byte _blue;
        private short _byteOffset;
        private byte _green;
        private byte _red;

        public CustomColor(short s6, byte[] bArr) {
            this(s6, bArr[0], bArr[1], bArr[2]);
        }

        private String getGnumericPart(byte b) {
            StringBuilder sb;
            if (b == 0) {
                sb = new StringBuilder("0");
            } else {
                int i5 = b & UnsignedBytes.MAX_VALUE;
                StringBuilder sb2 = new StringBuilder(Integer.toHexString(i5 | (i5 << 8)).toUpperCase(Locale.ROOT));
                int length = 4 - sb2.length();
                if (length > 0) {
                    sb2.insert(0, StringUtil.repeat('0', length));
                }
                sb = sb2;
            }
            return sb.toString();
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return getGnumericPart(this._red) + ParameterizedMessage.ERROR_MSG_SEPARATOR + getGnumericPart(this._green) + ParameterizedMessage.ERROR_MSG_SEPARATOR + getGnumericPart(this._blue);
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return this._byteOffset;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return new short[]{(short) (this._red & UnsignedBytes.MAX_VALUE), (short) (this._green & UnsignedBytes.MAX_VALUE), (short) (this._blue & UnsignedBytes.MAX_VALUE)};
        }

        private CustomColor(short s6, byte b, byte b6, byte b7) {
            this._byteOffset = s6;
            this._red = b;
            this._green = b6;
            this._blue = b7;
        }
    }

    public HSSFPalette(PaletteRecord paletteRecord) {
        this._palette = paletteRecord;
    }

    private int unsignedInt(byte b) {
        return b & UnsignedBytes.MAX_VALUE;
    }

    public HSSFColor addColor(byte b, byte b6, byte b7) {
        short s6 = 8;
        byte[] color = this._palette.getColor(8);
        while (s6 < 64) {
            if (color == null) {
                setColorAtIndex(s6, b, b6, b7);
                return getColor(s6);
            }
            s6 = (short) (s6 + 1);
            color = this._palette.getColor(s6);
        }
        throw new RuntimeException("Could not find free color index");
    }

    public HSSFColor findColor(byte b, byte b6, byte b7) {
        short s6 = 8;
        byte[] color = this._palette.getColor(8);
        while (color != null) {
            if (color[0] == b && color[1] == b6 && color[2] == b7) {
                return new CustomColor(s6, color);
            }
            s6 = (short) (s6 + 1);
            color = this._palette.getColor(s6);
        }
        return null;
    }

    public HSSFColor findSimilarColor(byte b, byte b6, byte b7) {
        return findSimilarColor(unsignedInt(b), unsignedInt(b6), unsignedInt(b7));
    }

    public HSSFColor getColor(short s6) {
        HSSFColor.HSSFColorPredefined hSSFColorPredefined = HSSFColor.HSSFColorPredefined.AUTOMATIC;
        if (s6 == hSSFColorPredefined.getIndex()) {
            return hSSFColorPredefined.getColor();
        }
        byte[] color = this._palette.getColor(s6);
        if (color == null) {
            return null;
        }
        return new CustomColor(s6, color);
    }

    public void setColorAtIndex(short s6, byte b, byte b6, byte b7) {
        this._palette.setColor(s6, b, b6, b7);
    }

    public HSSFColor findSimilarColor(int i5, int i6, int i7) {
        short s6 = 8;
        byte[] color = this._palette.getColor(8);
        HSSFColor color2 = null;
        int i8 = Integer.MAX_VALUE;
        while (color != null) {
            int iAbs = Math.abs(i7 - unsignedInt(color[2])) + Math.abs(i6 - unsignedInt(color[1])) + Math.abs(i5 - unsignedInt(color[0]));
            if (iAbs < i8) {
                color2 = getColor(s6);
                i8 = iAbs;
            }
            s6 = (short) (s6 + 1);
            color = this._palette.getColor(s6);
        }
        return color2;
    }

    public HSSFColor getColor(int i5) {
        return getColor((short) i5);
    }
}
