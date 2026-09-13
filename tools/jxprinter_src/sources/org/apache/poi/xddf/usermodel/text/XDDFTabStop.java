package org.apache.poi.xddf.usermodel.text;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFTabStop {
    private CTTextTabStop stop;

    @Internal
    public XDDFTabStop(CTTextTabStop cTTextTabStop) {
        this.stop = cTTextTabStop;
    }

    public TabAlignment getAlignment() {
        if (this.stop.isSetAlgn()) {
            return TabAlignment.valueOf(this.stop.getAlgn());
        }
        return null;
    }

    public Double getPosition() {
        if (this.stop.isSetPos()) {
            return Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(this.stop.xgetPos())));
        }
        return null;
    }

    @Internal
    public CTTextTabStop getXmlObject() {
        return this.stop;
    }

    public void setAlignment(TabAlignment tabAlignment) {
        if (tabAlignment != null) {
            this.stop.setAlgn(tabAlignment.underlying);
        } else if (this.stop.isSetAlgn()) {
            this.stop.unsetAlgn();
        }
    }

    public void setPosition(Double d) {
        if (d != null) {
            this.stop.setPos(Integer.valueOf(Units.toEMU(d.doubleValue())));
        } else if (this.stop.isSetPos()) {
            this.stop.unsetPos();
        }
    }
}
