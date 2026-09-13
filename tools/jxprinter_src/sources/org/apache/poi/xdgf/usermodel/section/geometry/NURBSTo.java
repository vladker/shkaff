package org.apache.poi.xdgf.usermodel.section.geometry;

import A3.AbstractC0157z;
import S1.d;
import S1.l;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.geom.SplineRenderer;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;
import p035f5.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NURBSTo implements GeometryRow {
    NURBSTo _master;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Double f7295a;
    Double b;
    Double c;
    Double d;
    Boolean deleted;
    String e;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Double f7296x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Double f7297y;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x008b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0092  */
    /* JADX WARN: Code duplicated, block: B:43:0x0099  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:51:0x007d A[SYNTHETIC] */
    public NURBSTo(RowType rowType) {
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
                case "E":
                    b = 4;
                case "X":
                    b = 5;
                case "Y":
                    b = 6;
                default:
                    switch (b) {
                        case 0:
                            this.f7295a = XDGFCell.parseDoubleValue(cellType);
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
                            this.e = cellType.getV();
                            break;
                        case 5:
                            this.f7296x = XDGFCell.parseDoubleValue(cellType);
                            break;
                        case 6:
                            this.f7297y = XDGFCell.parseDoubleValue(cellType);
                            break;
                        default:
                            throw new POIXMLException(AbstractC0157z.o("Invalid cell '", n6, "' in NURBS row"));
                    }
            }
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r32, XDGFShape xDGFShape) {
        if (getDel()) {
            return;
        }
        Point2D currentPoint = r32.getCurrentPoint();
        String strTrim = getE().trim();
        if (!strTrim.startsWith("NURBS(") || !strTrim.endsWith(")")) {
            throw new POIXMLException("Invalid NURBS formula: ".concat(strTrim));
        }
        String[] strArrSplit = strTrim.substring(6, strTrim.length() - 1).split(",");
        if (strArrSplit.length < 8) {
            throw new POIXMLException("Invalid NURBS formula (not enough arguments)");
        }
        if ((strArrSplit.length - 4) % 4 != 0) {
            throw new POIXMLException("Invalid NURBS formula -- need 4 + n*4 arguments, got " + strArrSplit.length);
        }
        double dDoubleValue = getX().doubleValue();
        double dDoubleValue2 = getY().doubleValue();
        double dDoubleValue3 = getA().doubleValue();
        double dDoubleValue4 = getB().doubleValue();
        double dDoubleValue5 = getC().doubleValue();
        double dDoubleValue6 = getD().doubleValue();
        double d = Double.parseDouble(strArrSplit[0].trim());
        int i5 = Integer.parseInt(strArrSplit[1].trim());
        int i6 = Integer.parseInt(strArrSplit[2].trim());
        int i7 = Integer.parseInt(strArrSplit[3].trim());
        double dDoubleValue7 = i6 == 0 ? xDGFShape.getWidth().doubleValue() : 1.0d;
        double dDoubleValue8 = i7 == 0 ? xDGFShape.getHeight().doubleValue() : 1.0d;
        d dVar = new d();
        l lVar = new l();
        l lVar2 = new l();
        lVar.a(dDoubleValue5);
        lVar2.a(dDoubleValue6);
        dVar.a(b.c(currentPoint.getX(), currentPoint.getY()));
        int length = (strArrSplit.length - 4) / 4;
        int i8 = 0;
        while (i8 < length) {
            int i9 = i8 * 4;
            double d6 = Double.parseDouble(strArrSplit[i9 + 4].trim());
            double d7 = Double.parseDouble(strArrSplit[i9 + 5].trim());
            int i10 = length;
            double d8 = Double.parseDouble(strArrSplit[i9 + 6].trim());
            double d9 = Double.parseDouble(strArrSplit[i9 + 7].trim());
            dVar.a(b.c(d6 * dDoubleValue7, d7 * dDoubleValue8));
            lVar.a(d8);
            lVar2.a(d9);
            i8++;
            length = i10;
            dDoubleValue4 = dDoubleValue4;
            dDoubleValue2 = dDoubleValue2;
        }
        lVar.a(dDoubleValue3);
        lVar.a(d);
        lVar2.a(dDoubleValue4);
        dVar.a(b.c(dDoubleValue, dDoubleValue2));
        r32.append(SplineRenderer.createNurbsSpline(dVar, lVar, lVar2, i5), true);
    }

    public Double getA() {
        Double d = this.f7295a;
        return d == null ? this._master.f7295a : d;
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
        NURBSTo nURBSTo = this._master;
        return nURBSTo != null && nURBSTo.getDel();
    }

    public String getE() {
        String str = this.e;
        return str == null ? this._master.e : str;
    }

    public Double getX() {
        Double d = this.f7296x;
        return d == null ? this._master.f7296x : d;
    }

    public Double getY() {
        Double d = this.f7297y;
        return d == null ? this._master.f7297y : d;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (NURBSTo) geometryRow;
    }
}
