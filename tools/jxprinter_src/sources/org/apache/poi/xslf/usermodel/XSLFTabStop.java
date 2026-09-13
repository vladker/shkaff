package org.apache.poi.xslf.usermodel;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.sl.usermodel.TabStop;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextTabAlignType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFTabStop implements TabStop {
    final CTTextTabStop tabStop;

    public XSLFTabStop(CTTextTabStop cTTextTabStop) {
        this.tabStop = cTTextTabStop;
    }

    public int getPosition() {
        return (int) POIXMLUnits.parseLength(this.tabStop.xgetPos());
    }

    @Override // org.apache.poi.sl.usermodel.TabStop
    public double getPositionInPoints() {
        return Units.toPoints(getPosition());
    }

    @Override // org.apache.poi.sl.usermodel.TabStop
    public TabStop.TabStopType getType() {
        return TabStop.TabStopType.fromOoxmlId(this.tabStop.getAlgn().intValue());
    }

    public void setPosition(int i5) {
        this.tabStop.setPos(Integer.valueOf(i5));
    }

    @Override // org.apache.poi.sl.usermodel.TabStop
    public void setPositionInPoints(double d) {
        setPosition(Units.toEMU(d));
    }

    @Override // org.apache.poi.sl.usermodel.TabStop
    public void setType(TabStop.TabStopType tabStopType) {
        this.tabStop.setAlgn(STTextTabAlignType.Enum.forInt(tabStopType.ooxmlId));
    }
}
