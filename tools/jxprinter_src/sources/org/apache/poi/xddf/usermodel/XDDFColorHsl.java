package org.apache.poi.xddf.usermodel;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFColorHsl extends XDDFColor {
    private CTHslColor color;

    public XDDFColorHsl(int i5, int i6, int i7) {
        this(CTHslColor.Factory.newInstance(), CTColor.Factory.newInstance());
        setHue(i5);
        setSaturation(i6);
        setLuminance(i7);
    }

    public int getHue() {
        return this.color.getHue2();
    }

    public int getLuminance() {
        return POIXMLUnits.parsePercent(this.color.xgetLum2()) / 1000;
    }

    public int getSaturation() {
        return POIXMLUnits.parsePercent(this.color.xgetSat2()) / 1000;
    }

    @Override // org.apache.poi.xddf.usermodel.XDDFColor
    @Internal
    public XmlObject getXmlObject() {
        return this.color;
    }

    public void setHue(int i5) {
        this.color.setHue2(i5);
    }

    public void setLuminance(int i5) {
        this.color.setLum2(Integer.valueOf(i5));
    }

    public void setSaturation(int i5) {
        this.color.setSat2(Integer.valueOf(i5));
    }

    @Internal
    public XDDFColorHsl(CTHslColor cTHslColor) {
        this(cTHslColor, null);
    }

    @Internal
    public XDDFColorHsl(CTHslColor cTHslColor, CTColor cTColor) {
        super(cTColor);
        this.color = cTHslColor;
    }
}
