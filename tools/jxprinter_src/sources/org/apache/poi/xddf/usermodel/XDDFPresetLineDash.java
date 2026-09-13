package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFPresetLineDash {
    private CTPresetLineDashProperties props;

    public XDDFPresetLineDash(PresetLineDash presetLineDash) {
        this(CTPresetLineDashProperties.Factory.newInstance());
        setValue(presetLineDash);
    }

    public PresetLineDash getValue() {
        if (this.props.isSetVal()) {
            return PresetLineDash.valueOf(this.props.getVal());
        }
        return null;
    }

    @Internal
    public CTPresetLineDashProperties getXmlObject() {
        return this.props;
    }

    public void setValue(PresetLineDash presetLineDash) {
        if (presetLineDash != null) {
            this.props.setVal(presetLineDash.underlying);
        } else if (this.props.isSetVal()) {
            this.props.unsetVal();
        }
    }

    public XDDFPresetLineDash(CTPresetLineDashProperties cTPresetLineDashProperties) {
        this.props = cTPresetLineDashProperties;
    }
}
