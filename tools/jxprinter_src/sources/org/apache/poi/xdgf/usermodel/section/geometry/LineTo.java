package org.apache.poi.xdgf.usermodel.section.geometry;

import A3.AbstractC0157z;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.Path2D;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LineTo implements GeometryRow {
    LineTo _master;
    Boolean deleted;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Double f7291x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Double f7292y;

    public LineTo(RowType rowType) {
        if (rowType.isSetDel()) {
            this.deleted = Boolean.valueOf(rowType.getDel());
        }
        for (CellType cellType : rowType.getCellArray()) {
            String n6 = cellType.getN();
            if (n6.equals("X")) {
                this.f7291x = XDGFCell.parseDoubleValue(cellType);
            } else {
                if (!n6.equals("Y")) {
                    throw new POIXMLException(AbstractC0157z.o("Invalid cell '", n6, "' in LineTo row"));
                }
                this.f7292y = XDGFCell.parseDoubleValue(cellType);
            }
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r6, XDGFShape xDGFShape) {
        if (getDel()) {
            return;
        }
        r6.lineTo(getX().doubleValue(), getY().doubleValue());
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        LineTo lineTo = this._master;
        return lineTo != null && lineTo.getDel();
    }

    public Double getX() {
        Double d = this.f7291x;
        return d == null ? this._master.f7291x : d;
    }

    public Double getY() {
        Double d = this.f7292y;
        return d == null ? this._master.f7292y : d;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (LineTo) geometryRow;
    }

    public String toString() {
        return "LineTo: x=" + getX() + "; y=" + getY();
    }
}
