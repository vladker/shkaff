package org.apache.poi.xddf.usermodel;

import java.util.Locale;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFColorRgbBinary extends XDDFColor {
    private CTSRgbColor color;

    public XDDFColorRgbBinary(byte[] bArr) {
        this(CTSRgbColor.Factory.newInstance(), CTColor.Factory.newInstance());
        setValue(bArr);
    }

    public byte[] getValue() {
        return this.color.getVal();
    }

    @Override // org.apache.poi.xddf.usermodel.XDDFColor
    @Internal
    public XmlObject getXmlObject() {
        return this.color;
    }

    public void setValue(byte[] bArr) {
        this.color.setVal(bArr);
    }

    public String toRGBHex() {
        StringBuilder sb = new StringBuilder(6);
        for (byte b : this.color.getVal()) {
            sb.append(String.format(Locale.ROOT, "%02X", Byte.valueOf(b)));
        }
        return sb.toString().toUpperCase(Locale.ROOT);
    }

    @Internal
    public XDDFColorRgbBinary(CTSRgbColor cTSRgbColor) {
        this(cTSRgbColor, null);
    }

    @Internal
    public XDDFColorRgbBinary(CTSRgbColor cTSRgbColor, CTColor cTColor) {
        super(cTColor);
        this.color = cTSRgbColor;
    }
}
