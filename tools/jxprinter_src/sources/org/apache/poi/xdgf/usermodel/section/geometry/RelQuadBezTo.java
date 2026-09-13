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
public class RelQuadBezTo implements GeometryRow {
    RelQuadBezTo _master;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Double f7311a;
    Double b;
    Boolean deleted;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Double f7312x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Double f7313y;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0071  */
    /* JADX WARN: Code duplicated, block: B:31:0x0078  */
    /* JADX WARN: Code duplicated, block: B:32:0x007f  */
    /* JADX WARN: Code duplicated, block: B:36:0x005c A[SYNTHETIC] */
    public RelQuadBezTo(RowType rowType) {
        if (rowType.isSetDel()) {
            this.deleted = Boolean.valueOf(rowType.getDel());
        }
        CellType[] cellArray = rowType.getCellArray();
        int length = cellArray.length;
        int i5 = 0;
        while (i5 < length) {
            CellType cellType = cellArray[i5];
            String n6 = cellType.getN();
            n6.getClass();
            byte b = -1;
            switch (n6) {
                case "A":
                    b = 0;
                case "B":
                    b = 1;
                case "X":
                    b = 2;
                case "Y":
                    b = 3;
                default:
                    switch (b) {
                        case 0:
                            this.f7311a = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 1:
                            this.b = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 2:
                            this.f7312x = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 3:
                            this.f7313y = XDGFCell.parseDoubleValue(cellType);
                            break;
                        default:
                            throw new POIXMLException(AbstractC0157z.o("Invalid cell '", n6, "' in RelQuadBezTo row"));
                    }
            }
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r16, XDGFShape xDGFShape) {
        if (getDel()) {
            return;
        }
        double dDoubleValue = xDGFShape.getWidth().doubleValue();
        double dDoubleValue2 = xDGFShape.getHeight().doubleValue();
        r16.quadTo(getA().doubleValue() * dDoubleValue, getB().doubleValue() * dDoubleValue2, getX().doubleValue() * dDoubleValue, getY().doubleValue() * dDoubleValue2);
    }

    public Double getA() {
        Double d = this.f7311a;
        return d == null ? this._master.f7311a : d;
    }

    public Double getB() {
        Double d = this.b;
        return d == null ? this._master.b : d;
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        RelQuadBezTo relQuadBezTo = this._master;
        return relQuadBezTo != null && relQuadBezTo.getDel();
    }

    public Double getX() {
        Double d = this.f7312x;
        return d == null ? this._master.f7312x : d;
    }

    public Double getY() {
        Double d = this.f7313y;
        return d == null ? this._master.f7313y : d;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (RelQuadBezTo) geometryRow;
    }
}
