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
public class InfiniteLine implements GeometryRow {
    InfiniteLine _master;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Double f7288a;
    Double b;
    Boolean deleted;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Double f7289x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Double f7290y;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0071  */
    /* JADX WARN: Code duplicated, block: B:31:0x0078  */
    /* JADX WARN: Code duplicated, block: B:32:0x007f  */
    /* JADX WARN: Code duplicated, block: B:36:0x005c A[SYNTHETIC] */
    public InfiniteLine(RowType rowType) {
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
                            this.f7288a = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 1:
                            this.b = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 2:
                            this.f7289x = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 3:
                            this.f7290y = XDGFCell.parseDoubleValue(cellType);
                            break;
                        default:
                            throw new POIXMLException(AbstractC0157z.o("Invalid cell '", n6, "' in InfiniteLine row"));
                    }
            }
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r6, XDGFShape xDGFShape) {
        if (!getDel()) {
            throw new POIXMLException("InfiniteLine elements cannot be part of a path");
        }
    }

    public Double getA() {
        Double d = this.f7288a;
        return d == null ? this._master.f7288a : d;
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
        InfiniteLine infiniteLine = this._master;
        return infiniteLine != null && infiniteLine.getDel();
    }

    public Path2D.Double getPath() {
        Path2D.Double r6 = new Path2D.Double();
        double dDoubleValue = getX().doubleValue();
        double dDoubleValue2 = getY().doubleValue();
        double dDoubleValue3 = getA().doubleValue();
        double dDoubleValue4 = getB().doubleValue();
        if (dDoubleValue == dDoubleValue3) {
            r6.moveTo(dDoubleValue, -100000.0d);
            r6.lineTo(dDoubleValue, 100000.0d);
            return r6;
        }
        if (dDoubleValue2 == dDoubleValue4) {
            r6.moveTo(-100000.0d, dDoubleValue2);
            r6.lineTo(100000.0d, dDoubleValue2);
            return r6;
        }
        double d = (dDoubleValue4 - dDoubleValue2) / (dDoubleValue3 - dDoubleValue);
        double d6 = dDoubleValue2 - (dDoubleValue * d);
        r6.moveTo(100000.0d, (d * 100000.0d) + d6);
        r6.lineTo(100000.0d, (100000.0d - d6) / d);
        return r6;
    }

    public Double getX() {
        Double d = this.f7289x;
        return d == null ? this._master.f7289x : d;
    }

    public Double getY() {
        Double d = this.f7290y;
        return d == null ? this._master.f7290y : d;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (InfiniteLine) geometryRow;
    }
}
