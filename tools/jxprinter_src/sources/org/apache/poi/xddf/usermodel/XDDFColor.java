package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XDDFColor {
    protected CTColor container;

    @Internal
    public XDDFColor(CTColor cTColor) {
        this.container = cTColor;
    }

    @Internal
    public static XDDFColor forColorContainer(CTColor cTColor) {
        if (cTColor.isSetHslClr()) {
            return new XDDFColorHsl(cTColor.getHslClr(), cTColor);
        }
        if (cTColor.isSetPrstClr()) {
            return new XDDFColorPreset(cTColor.getPrstClr(), cTColor);
        }
        if (cTColor.isSetSchemeClr()) {
            return new XDDFColorSchemeBased(cTColor.getSchemeClr(), cTColor);
        }
        if (cTColor.isSetScrgbClr()) {
            return new XDDFColorRgbPercent(cTColor.getScrgbClr(), cTColor);
        }
        if (cTColor.isSetSrgbClr()) {
            return new XDDFColorRgbBinary(cTColor.getSrgbClr(), cTColor);
        }
        if (cTColor.isSetSysClr()) {
            return new XDDFColorSystemDefined(cTColor.getSysClr(), cTColor);
        }
        return null;
    }

    public static XDDFColor from(byte[] bArr) {
        return new XDDFColorRgbBinary(bArr);
    }

    @Internal
    public CTColor getColorContainer() {
        return this.container;
    }

    @Internal
    public abstract XmlObject getXmlObject();

    public static XDDFColor from(int i5, int i6, int i7) {
        return new XDDFColorRgbPercent(i5, i6, i7);
    }

    public static XDDFColor from(PresetColor presetColor) {
        return new XDDFColorPreset(presetColor);
    }

    public static XDDFColor from(SchemeColor schemeColor) {
        return new XDDFColorSchemeBased(schemeColor);
    }

    public static XDDFColor from(SystemColor systemColor) {
        return new XDDFColorSystemDefined(systemColor);
    }
}
