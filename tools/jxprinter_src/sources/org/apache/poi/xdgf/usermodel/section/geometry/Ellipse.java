package org.apache.poi.xdgf.usermodel.section.geometry;

import A3.AbstractC0157z;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Ellipse implements GeometryRow {
    Ellipse _master;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Double f7282a;
    Double b;
    Double c;
    Double d;
    Boolean deleted;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Double f7283x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Double f7284y;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:37:0x0080  */
    /* JADX WARN: Code duplicated, block: B:38:0x0087  */
    /* JADX WARN: Code duplicated, block: B:39:0x008e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0095  */
    /* JADX WARN: Code duplicated, block: B:41:0x009c  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:46:0x0072 A[SYNTHETIC] */
    public Ellipse(RowType rowType) {
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
                            this.f7282a = XDGFCell.parseDoubleValue(cellType);
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
                            this.f7283x = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 5:
                            this.f7284y = XDGFCell.parseDoubleValue(cellType);
                            break;
                        default:
                            throw new POIXMLException(AbstractC0157z.o("Invalid cell '", n6, "' in Ellipse row"));
                    }
            }
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r6, XDGFShape xDGFShape) {
        throw new POIXMLException("Ellipse elements cannot be part of a path");
    }

    public Double getA() {
        Double d = this.f7282a;
        return d == null ? this._master.f7282a : d;
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
        Ellipse ellipse = this._master;
        return ellipse != null && ellipse.getDel();
    }

    public Path2D.Double getPath() {
        if (getDel()) {
            return null;
        }
        double dDoubleValue = getX().doubleValue();
        double dDoubleValue2 = getY().doubleValue();
        double dDoubleValue3 = getA().doubleValue();
        double dDoubleValue4 = getB().doubleValue();
        double dDoubleValue5 = getC().doubleValue();
        double dDoubleValue6 = getD().doubleValue();
        double dHypot = Math.hypot(dDoubleValue3 - dDoubleValue, dDoubleValue4 - dDoubleValue2);
        double dHypot2 = Math.hypot(dDoubleValue5 - dDoubleValue, dDoubleValue6 - dDoubleValue2);
        double dAcos = ((Math.acos((dDoubleValue - dDoubleValue3) / dHypot) * (dDoubleValue2 > dDoubleValue4 ? 1.0d : -1.0d)) + 6.283185307179586d) % 6.283185307179586d;
        Path2D.Double r6 = new Path2D.Double(new Ellipse2D.Double(dDoubleValue - dHypot, dDoubleValue2 - dHypot2, dHypot * 2.0d, dHypot2 * 2.0d));
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(dAcos, dDoubleValue, dDoubleValue2);
        r6.transform(affineTransform);
        return r6;
    }

    public Double getX() {
        Double d = this.f7283x;
        return d == null ? this._master.f7283x : d;
    }

    public Double getY() {
        Double d = this.f7284y;
        return d == null ? this._master.f7284y : d;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (Ellipse) geometryRow;
    }
}
