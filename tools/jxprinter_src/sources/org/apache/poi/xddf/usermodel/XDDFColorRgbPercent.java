package org.apache.poi.xddf.usermodel;

import java.util.Locale;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFColorRgbPercent extends XDDFColor {
    private final CTScRgbColor color;

    public XDDFColorRgbPercent(int i5, int i6, int i7) {
        this(CTScRgbColor.Factory.newInstance(), CTColor.Factory.newInstance());
        setRed(i5);
        setGreen(i6);
        setBlue(i7);
    }

    private int normalize(int i5) {
        if (i5 < 0) {
            return 0;
        }
        return Math.min(BZip2Constants.BASEBLOCKSIZE, i5);
    }

    public int getBlue() {
        return POIXMLUnits.parsePercent(this.color.xgetB());
    }

    public int getGreen() {
        return POIXMLUnits.parsePercent(this.color.xgetG());
    }

    public int getRed() {
        return POIXMLUnits.parsePercent(this.color.xgetR());
    }

    @Override // org.apache.poi.xddf.usermodel.XDDFColor
    @Internal
    public XmlObject getXmlObject() {
        return this.color;
    }

    public void setBlue(int i5) {
        this.color.setB(Integer.valueOf(normalize(i5)));
    }

    public void setGreen(int i5) {
        this.color.setG(Integer.valueOf(normalize(i5)));
    }

    public void setRed(int i5) {
        this.color.setR(Integer.valueOf(normalize(i5)));
    }

    public String toRGBHex() {
        STPercentage[] sTPercentageArr = {this.color.xgetR(), this.color.xgetG(), this.color.xgetB()};
        int percent = 0;
        for (int i5 = 0; i5 < 3; i5++) {
            percent = (percent << 8) | (((POIXMLUnits.parsePercent(sTPercentageArr[i5]) * 255) / BZip2Constants.BASEBLOCKSIZE) & 255);
        }
        return String.format(Locale.ROOT, "%06X", Integer.valueOf(percent));
    }

    @Internal
    public XDDFColorRgbPercent(CTScRgbColor cTScRgbColor) {
        this(cTScRgbColor, null);
    }

    @Internal
    public XDDFColorRgbPercent(CTScRgbColor cTScRgbColor, CTColor cTColor) {
        super(cTColor);
        this.color = cTScRgbColor;
    }
}
