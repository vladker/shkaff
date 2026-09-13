package org.apache.poi.xdgf.usermodel.section.geometry;

import A3.AbstractC0157z;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ArcTo implements GeometryRow {
    ArcTo _master;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Double f7279a;
    Boolean deleted;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Double f7280x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Double f7281y;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0066  */
    /* JADX WARN: Code duplicated, block: B:27:0x006d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0051 A[SYNTHETIC] */
    public ArcTo(RowType rowType) {
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
                            this.f7279a = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 1:
                            this.f7280x = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 2:
                            this.f7281y = XDGFCell.parseDoubleValue(cellType);
                            break;
                        default:
                            throw new POIXMLException(AbstractC0157z.o("Invalid cell '", n6, "' in ArcTo row"));
                    }
            }
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r20, XDGFShape xDGFShape) {
        if (getDel()) {
            return;
        }
        Point2D currentPoint = r20.getCurrentPoint();
        double dDoubleValue = getX().doubleValue();
        double dDoubleValue2 = getY().doubleValue();
        double dDoubleValue3 = getA().doubleValue();
        if (dDoubleValue3 == 0.0d) {
            r20.lineTo(dDoubleValue, dDoubleValue2);
            return;
        }
        double x6 = currentPoint.getX();
        double y6 = currentPoint.getY();
        double d = dDoubleValue2 - y6;
        double d6 = x6 - dDoubleValue;
        double dSqrt = Math.sqrt((d6 * d6) + (d * d));
        EllipticalArcTo.createEllipticalArc(dDoubleValue, dDoubleValue2, ((d * dDoubleValue3) / dSqrt) + ((x6 + dDoubleValue) / 2.0d), ((dDoubleValue3 * d6) / dSqrt) + ((y6 + dDoubleValue2) / 2.0d), 0.0d, 1.0d, r20);
    }

    public Double getA() {
        Double d = this.f7279a;
        return d == null ? this._master.f7279a : d;
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        ArcTo arcTo = this._master;
        return arcTo != null && arcTo.getDel();
    }

    public Double getX() {
        Double d = this.f7280x;
        return d == null ? this._master.f7280x : d;
    }

    public Double getY() {
        Double d = this.f7281y;
        return d == null ? this._master.f7281y : d;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (ArcTo) geometryRow;
    }

    public String toString() {
        return String.format(LocaleUtil.getUserLocale(), "ArcTo: x=%f; y=%f; a=%f", this.f7280x, this.f7281y, this.f7279a);
    }
}
