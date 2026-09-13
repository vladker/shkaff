package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFGroupFillProperties implements XDDFFillProperties {
    private CTGroupFillProperties props;

    public XDDFGroupFillProperties() {
        this(CTGroupFillProperties.Factory.newInstance());
    }

    @Internal
    public CTGroupFillProperties getXmlObject() {
        return this.props;
    }

    public XDDFGroupFillProperties(CTGroupFillProperties cTGroupFillProperties) {
        this.props = cTGroupFillProperties;
    }
}
