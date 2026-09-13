package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFNoFillProperties implements XDDFFillProperties {
    private CTNoFillProperties props;

    public XDDFNoFillProperties() {
        this(CTNoFillProperties.Factory.newInstance());
    }

    @Internal
    public CTNoFillProperties getXmlObject() {
        return this.props;
    }

    public XDDFNoFillProperties(CTNoFillProperties cTNoFillProperties) {
        this.props = cTNoFillProperties;
    }
}
