package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFColorPreset extends XDDFColor {
    private CTPresetColor color;

    public XDDFColorPreset(PresetColor presetColor) {
        this(CTPresetColor.Factory.newInstance(), CTColor.Factory.newInstance());
        setValue(presetColor);
    }

    public PresetColor getValue() {
        if (this.color.xgetVal() != null) {
            return PresetColor.valueOf(this.color.getVal());
        }
        return null;
    }

    @Override // org.apache.poi.xddf.usermodel.XDDFColor
    @Internal
    public XmlObject getXmlObject() {
        return this.color;
    }

    public void setValue(PresetColor presetColor) {
        if (presetColor != null) {
            this.color.setVal(presetColor.underlying);
        } else if (this.color.xgetVal() != null) {
            this.color.setVal(PresetColor.WHITE.underlying);
        }
    }

    @Internal
    public XDDFColorPreset(CTPresetColor cTPresetColor) {
        this(cTPresetColor, null);
    }

    @Internal
    public XDDFColorPreset(CTPresetColor cTPresetColor, CTColor cTColor) {
        super(cTColor);
        this.color = cTPresetColor;
    }
}
