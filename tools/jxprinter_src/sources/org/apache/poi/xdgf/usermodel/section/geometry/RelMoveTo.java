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
public class RelMoveTo implements GeometryRow {
    RelMoveTo _master;
    Boolean deleted;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Double f7309x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Double f7310y;

    public RelMoveTo(RowType rowType) {
        if (rowType.isSetDel()) {
            this.deleted = Boolean.valueOf(rowType.getDel());
        }
        for (CellType cellType : rowType.getCellArray()) {
            String n6 = cellType.getN();
            if (n6.equals("X")) {
                this.f7309x = XDGFCell.parseDoubleValue(cellType);
            } else {
                if (!n6.equals("Y")) {
                    throw new POIXMLException(AbstractC0157z.o("Invalid cell '", n6, "' in RelMoveTo row"));
                }
                this.f7310y = XDGFCell.parseDoubleValue(cellType);
            }
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r7, XDGFShape xDGFShape) {
        if (getDel()) {
            return;
        }
        r7.moveTo(xDGFShape.getWidth().doubleValue() * getX().doubleValue(), xDGFShape.getHeight().doubleValue() * getY().doubleValue());
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        RelMoveTo relMoveTo = this._master;
        return relMoveTo != null && relMoveTo.getDel();
    }

    public Double getX() {
        Double d = this.f7309x;
        return d == null ? this._master.f7309x : d;
    }

    public Double getY() {
        Double d = this.f7310y;
        return d == null ? this._master.f7310y : d;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (RelMoveTo) geometryRow;
    }
}
