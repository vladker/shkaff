package org.apache.poi.xdgf.usermodel.section.geometry;

import A3.AbstractC0157z;
import androidx.collection.a;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EllipticalArcTo implements GeometryRow {
    EllipticalArcTo _master;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Double f7285a;
    Double b;
    Double c;
    Double d;
    Boolean deleted;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Double f7286x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Double f7287y;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:37:0x0080  */
    /* JADX WARN: Code duplicated, block: B:38:0x0087  */
    /* JADX WARN: Code duplicated, block: B:39:0x008e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0095  */
    /* JADX WARN: Code duplicated, block: B:41:0x009c  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:46:0x0072 A[SYNTHETIC] */
    public EllipticalArcTo(RowType rowType) {
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
                case "C":
                    b = 2;
                case "D":
                    b = 3;
                case "X":
                    b = 4;
                case "Y":
                    b = 5;
                default:
                    switch (b) {
                        case 0:
                            this.f7285a = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 1:
                            this.b = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 2:
                            this.c = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 3:
                            this.d = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 4:
                            this.f7286x = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 5:
                            this.f7287y = XDGFCell.parseDoubleValue(cellType);
                            break;
                        default:
                            throw new POIXMLException(AbstractC0157z.o("Invalid cell '", n6, "' in EllipticalArcTo row"));
                    }
            }
        }
    }

    public static double computeSweep(double d, double d6, double d7) {
        double d8 = (d + 360.0d) % 360.0d;
        double d9 = (d6 + 360.0d) % 360.0d;
        double d10 = (d7 + 360.0d) % 360.0d;
        if (d8 < d9) {
            return (d8 >= d10 || d10 >= d9) ? (d8 - d9) + 360.0d : d8 - d9;
        }
        return (d9 >= d10 || d10 >= d8) ? -(360.0d - (d8 - d9)) : d8 - d9;
    }

    public static void createEllipticalArc(double d, double d6, double d7, double d8, double d9, double d10, Path2D.Double r54) {
        Point2D currentPoint = r54.getCurrentPoint();
        double x6 = currentPoint.getX();
        double y6 = currentPoint.getY();
        AffineTransform rotateInstance = AffineTransform.getRotateInstance(-d9);
        double[] dArr = {x6, y6, d, d6, d7, d8};
        rotateInstance.transform(dArr, 0, dArr, 0, 3);
        double d11 = dArr[0];
        double d12 = dArr[1];
        double d13 = dArr[2];
        double d14 = dArr[3];
        double d15 = dArr[4];
        double d16 = dArr[5];
        double d17 = d10 * d10;
        double d18 = d11 - d13;
        double d19 = d14 - d16;
        double d20 = d13 - d15;
        double d21 = d12 - d14;
        double dA = a.a(d12, d16, d17 * d21 * d19, (((d11 + d13) * d18) * d19) - (((d13 + d15) * d20) * d21));
        double d22 = d19 * d18;
        double d23 = d21 * d20;
        double d24 = dA / ((d22 - d23) * 2.0d);
        double d25 = ((((d12 + d14) * d23) + (((d11 - d15) * (d18 * d20)) / d17)) - ((d14 + d16) * d22)) / ((d23 - d22) * 2.0d);
        double d26 = d11 - d24;
        double d27 = d12 - d25;
        double dSqrt = Math.sqrt((Math.pow(d27, 2.0d) * d17) + Math.pow(d26, 2.0d));
        double d28 = dSqrt / d10;
        double degrees = Math.toDegrees(Math.atan2((d16 - d25) / d28, (d15 - d24) / dSqrt));
        double degrees2 = Math.toDegrees(Math.atan2(d27 / d28, d26 / dSqrt));
        Arc2D.Double r28 = new Arc2D.Double(d24 - dSqrt, d25 - d28, dSqrt * 2.0d, d28 * 2.0d, -degrees2, computeSweep(degrees2, Math.toDegrees(Math.atan2((d14 - d25) / d28, (d13 - d24) / dSqrt)), degrees), 0);
        rotateInstance.setToRotation(d9);
        r54.append(rotateInstance.createTransformedShape(r28), false);
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r14, XDGFShape xDGFShape) {
        if (getDel()) {
            return;
        }
        createEllipticalArc(getX().doubleValue(), getY().doubleValue(), getA().doubleValue(), getB().doubleValue(), getC().doubleValue(), getD().doubleValue(), r14);
    }

    public Double getA() {
        Double d = this.f7285a;
        return d == null ? this._master.f7285a : d;
    }

    public Double getB() {
        Double d = this.b;
        return d == null ? this._master.b : d;
    }

    public Double getC() {
        Double d = this.c;
        return d == null ? this._master.c : d;
    }

    public Double getD() {
        Double d = this.d;
        return d == null ? this._master.d : d;
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        EllipticalArcTo ellipticalArcTo = this._master;
        return ellipticalArcTo != null && ellipticalArcTo.getDel();
    }

    public Double getX() {
        Double d = this.f7286x;
        return d == null ? this._master.f7286x : d;
    }

    public Double getY() {
        Double d = this.f7287y;
        return d == null ? this._master.f7287y : d;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (EllipticalArcTo) geometryRow;
    }
}
