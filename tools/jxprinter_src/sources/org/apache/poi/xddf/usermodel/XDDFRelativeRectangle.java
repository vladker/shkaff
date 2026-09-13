package org.apache.poi.xddf.usermodel;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFRelativeRectangle {
    private final CTRelativeRect rect;

    public XDDFRelativeRectangle() {
        this(CTRelativeRect.Factory.newInstance());
    }

    public Integer getBottom() {
        if (this.rect.isSetB()) {
            return Integer.valueOf(POIXMLUnits.parsePercent(this.rect.xgetB()));
        }
        return null;
    }

    public Integer getLeft() {
        if (this.rect.isSetL()) {
            return Integer.valueOf(POIXMLUnits.parsePercent(this.rect.xgetL()));
        }
        return null;
    }

    public Integer getRight() {
        if (this.rect.isSetR()) {
            return Integer.valueOf(POIXMLUnits.parsePercent(this.rect.xgetR()));
        }
        return null;
    }

    public Integer getTop() {
        if (this.rect.isSetT()) {
            return Integer.valueOf(POIXMLUnits.parsePercent(this.rect.xgetT()));
        }
        return null;
    }

    @Internal
    public CTRelativeRect getXmlObject() {
        return this.rect;
    }

    public void setBottom(Integer num) {
        if (num != null) {
            this.rect.setB(num);
        } else if (this.rect.isSetB()) {
            this.rect.unsetB();
        }
    }

    public void setLeft(Integer num) {
        if (num != null) {
            this.rect.setL(num);
        } else if (this.rect.isSetL()) {
            this.rect.unsetL();
        }
    }

    public void setRight(Integer num) {
        if (num != null) {
            this.rect.setR(num);
        } else if (this.rect.isSetR()) {
            this.rect.unsetR();
        }
    }

    public void setTop(Integer num) {
        if (num != null) {
            this.rect.setT(num);
        } else if (this.rect.isSetT()) {
            this.rect.unsetT();
        }
    }

    public XDDFRelativeRectangle(CTRelativeRect cTRelativeRect) {
        this.rect = cTRelativeRect;
    }
}
