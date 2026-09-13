package org.apache.poi.xddf.usermodel.text;

import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFFont {
    private CTTextFont font;
    private FontGroup group;

    public XDDFFont(FontGroup fontGroup, String str, Byte b, Byte b6, byte[] bArr) {
        this(fontGroup, CTTextFont.Factory.newInstance());
        if (str != null) {
            this.font.setTypeface(str);
        } else if (this.font.getTypeface() != null && !this.font.getTypeface().equals("")) {
            this.font.setTypeface("");
        }
        if (b != null) {
            this.font.setCharset(b.byteValue());
        } else if (this.font.isSetCharset()) {
            this.font.unsetCharset();
        }
        if (b6 != null) {
            this.font.setPitchFamily(b6.byteValue());
        } else if (this.font.isSetPitchFamily()) {
            this.font.unsetPitchFamily();
        }
        if (bArr != null && bArr.length != 0) {
            this.font.setPanose(bArr);
        } else if (this.font.isSetPanose()) {
            this.font.unsetPanose();
        }
    }

    public static XDDFFont unsetFontForGroup(FontGroup fontGroup) {
        return new XDDFFont(fontGroup, null);
    }

    public Byte getCharset() {
        if (this.font.isSetCharset()) {
            return Byte.valueOf(this.font.getCharset());
        }
        return null;
    }

    public FontGroup getGroup() {
        return this.group;
    }

    public byte[] getPanose() {
        if (this.font.isSetPanose()) {
            return this.font.getPanose();
        }
        return null;
    }

    public Byte getPitchFamily() {
        if (this.font.isSetPitchFamily()) {
            return Byte.valueOf(this.font.getPitchFamily());
        }
        return null;
    }

    public String getTypeface() {
        return this.font.getTypeface();
    }

    @Internal
    public CTTextFont getXmlObject() {
        return this.font;
    }

    @Internal
    public XDDFFont(FontGroup fontGroup, CTTextFont cTTextFont) {
        this.group = fontGroup;
        this.font = cTTextFont;
    }
}
