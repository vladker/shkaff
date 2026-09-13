package org.apache.poi.xddf.usermodel;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFGradientStop {
    private CTGradientStop stop;

    @Internal
    public XDDFGradientStop(CTGradientStop cTGradientStop) {
        this.stop = cTGradientStop;
    }

    public XDDFColor getColor() {
        if (this.stop.isSetHslClr()) {
            return new XDDFColorHsl(this.stop.getHslClr());
        }
        if (this.stop.isSetPrstClr()) {
            return new XDDFColorPreset(this.stop.getPrstClr());
        }
        if (this.stop.isSetSchemeClr()) {
            return new XDDFColorSchemeBased(this.stop.getSchemeClr());
        }
        if (this.stop.isSetScrgbClr()) {
            return new XDDFColorRgbPercent(this.stop.getScrgbClr());
        }
        if (this.stop.isSetSrgbClr()) {
            return new XDDFColorRgbBinary(this.stop.getSrgbClr());
        }
        if (this.stop.isSetSysClr()) {
            return new XDDFColorSystemDefined(this.stop.getSysClr());
        }
        return null;
    }

    public int getPosition() {
        return POIXMLUnits.parsePercent(this.stop.xgetPos());
    }

    @Internal
    public CTGradientStop getXmlObject() {
        return this.stop;
    }

    public void setColor(XDDFColor xDDFColor) {
        if (this.stop.isSetHslClr()) {
            this.stop.unsetHslClr();
        }
        if (this.stop.isSetPrstClr()) {
            this.stop.unsetPrstClr();
        }
        if (this.stop.isSetSchemeClr()) {
            this.stop.unsetSchemeClr();
        }
        if (this.stop.isSetScrgbClr()) {
            this.stop.unsetScrgbClr();
        }
        if (this.stop.isSetSrgbClr()) {
            this.stop.unsetSrgbClr();
        }
        if (this.stop.isSetSysClr()) {
            this.stop.unsetSysClr();
        }
        if (xDDFColor == null) {
            return;
        }
        if (xDDFColor instanceof XDDFColorHsl) {
            this.stop.setHslClr((CTHslColor) xDDFColor.getXmlObject());
            return;
        }
        if (xDDFColor instanceof XDDFColorPreset) {
            this.stop.setPrstClr((CTPresetColor) xDDFColor.getXmlObject());
            return;
        }
        if (xDDFColor instanceof XDDFColorSchemeBased) {
            this.stop.setSchemeClr((CTSchemeColor) xDDFColor.getXmlObject());
            return;
        }
        if (xDDFColor instanceof XDDFColorRgbPercent) {
            this.stop.setScrgbClr((CTScRgbColor) xDDFColor.getXmlObject());
        } else if (xDDFColor instanceof XDDFColorRgbBinary) {
            this.stop.setSrgbClr((CTSRgbColor) xDDFColor.getXmlObject());
        } else if (xDDFColor instanceof XDDFColorSystemDefined) {
            this.stop.setSysClr((CTSystemColor) xDDFColor.getXmlObject());
        }
    }

    public void setPosition(int i5) {
        this.stop.setPos(Integer.valueOf(i5));
    }
}
