package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFLineEndProperties {
    private CTLineEndProperties props;

    public XDDFLineEndProperties(CTLineEndProperties cTLineEndProperties) {
        this.props = cTLineEndProperties;
    }

    public LineEndLength getLength() {
        return LineEndLength.valueOf(this.props.getLen());
    }

    public LineEndType getType() {
        return LineEndType.valueOf(this.props.getType());
    }

    public LineEndWidth getWidth() {
        return LineEndWidth.valueOf(this.props.getW());
    }

    @Internal
    public CTLineEndProperties getXmlObject() {
        return this.props;
    }

    public void setLength(LineEndLength lineEndLength) {
        this.props.setLen(lineEndLength.underlying);
    }

    public void setType(LineEndType lineEndType) {
        this.props.setType(lineEndType.underlying);
    }

    public void setWidth(LineEndWidth lineEndWidth) {
        this.props.setW(lineEndWidth.underlying);
    }
}
