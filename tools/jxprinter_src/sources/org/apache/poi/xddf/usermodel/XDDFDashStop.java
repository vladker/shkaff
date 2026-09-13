package org.apache.poi.xddf.usermodel;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDashStop;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFDashStop {
    private CTDashStop stop;

    @Internal
    public XDDFDashStop(CTDashStop cTDashStop) {
        this.stop = cTDashStop;
    }

    public int getDashLength() {
        return POIXMLUnits.parsePercent(this.stop.xgetD());
    }

    public int getSpaceLength() {
        return POIXMLUnits.parsePercent(this.stop.xgetSp());
    }

    @Internal
    public CTDashStop getXmlObject() {
        return this.stop;
    }

    public void setDashLength(int i5) {
        this.stop.setD(Integer.valueOf(i5));
    }

    public void setSpaceLength(int i5) {
        this.stop.setSp(Integer.valueOf(i5));
    }
}
