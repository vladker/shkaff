package org.apache.poi.xddf.usermodel;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineJoinMiterProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFLineJoinMiterProperties implements XDDFLineJoinProperties {
    private CTLineJoinMiterProperties join;

    public XDDFLineJoinMiterProperties() {
        this(CTLineJoinMiterProperties.Factory.newInstance());
    }

    public Integer getLimit() {
        if (this.join.isSetLim()) {
            return Integer.valueOf(POIXMLUnits.parsePercent(this.join.xgetLim()));
        }
        return null;
    }

    @Internal
    public CTLineJoinMiterProperties getXmlObject() {
        return this.join;
    }

    public void setLimit(Integer num) {
        if (num != null) {
            this.join.setLim(num);
        } else if (this.join.isSetLim()) {
            this.join.unsetLim();
        }
    }

    public XDDFLineJoinMiterProperties(CTLineJoinMiterProperties cTLineJoinMiterProperties) {
        this.join = cTLineJoinMiterProperties;
    }
}
