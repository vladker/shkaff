package org.apache.poi.xdgf.usermodel.section.geometry;

import A3.AbstractC0157z;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.Path2D;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SplineKnot implements GeometryRow {
    SplineKnot _master;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Double f7314a;
    Boolean deleted;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Double f7315x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Double f7316y;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0066  */
    /* JADX WARN: Code duplicated, block: B:27:0x006d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0051 A[SYNTHETIC] */
    public SplineKnot(RowType rowType) {
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
                case "X":
                    b = 1;
                case "Y":
                    b = 2;
                default:
                    switch (b) {
                        case 0:
                            this.f7314a = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 1:
                            this.f7315x = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 2:
                            this.f7316y = XDGFCell.parseDoubleValue(cellType);
                            break;
                        default:
                            throw new POIXMLException(AbstractC0157z.o("Invalid cell '", n6, "' in SplineKnot row"));
                    }
            }
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r6, XDGFShape xDGFShape) {
        throw new POIXMLException("Error: Use SplineRenderer!");
    }

    public Double getA() {
        Double d = this.f7314a;
        return d == null ? this._master.f7314a : d;
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        SplineKnot splineKnot = this._master;
        return splineKnot != null && splineKnot.getDel();
    }

    public Double getX() {
        Double d = this.f7315x;
        return d == null ? this._master.f7315x : d;
    }

    public Double getY() {
        Double d = this.f7316y;
        return d == null ? this._master.f7316y : d;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (SplineKnot) geometryRow;
    }

    public String toString() {
        return "{SplineKnot x=" + getX() + " y=" + getY() + " a=" + getA() + VectorFormat.DEFAULT_SUFFIX;
    }
}
