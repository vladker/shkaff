package org.apache.poi.xssf.usermodel;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFClientAnchor extends XSSFAnchor implements ClientAnchor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final CTMarker EMPTY_MARKER = CTMarker.Factory.newInstance();
    private ClientAnchor.AnchorType anchorType;
    private CTMarker cell1;
    private CTMarker cell2;
    private CTPoint2D position;
    private XSSFSheet sheet;
    private CTPositiveSize2D size;

    public XSSFClientAnchor() {
        this(0, 0, 0, 0, 0, 0, 0, 0);
    }

    private CTMarker calcCell(CTMarker cTMarker, long j6, long j7) {
        CTMarker cTMarkerNewInstance = CTMarker.Factory.newInstance();
        int row = cTMarker.getRow();
        int col = cTMarker.getCol();
        int iColumnWidthToEMU = Units.columnWidthToEMU(this.sheet.getColumnWidth(col));
        long length = ((long) iColumnWidthToEMU) - POIXMLUnits.parseLength(cTMarker.xgetColOff());
        while (length < j6) {
            col++;
            iColumnWidthToEMU = Units.columnWidthToEMU(this.sheet.getColumnWidth(col));
            length += (long) iColumnWidthToEMU;
        }
        cTMarkerNewInstance.setCol(col);
        cTMarkerNewInstance.setColOff(Long.valueOf(((long) iColumnWidthToEMU) - (length - j6)));
        int emu = Units.toEMU(getRowHeight(this.sheet, row));
        long length2 = ((long) emu) - POIXMLUnits.parseLength(cTMarker.xgetRowOff());
        while (length2 < j7) {
            row++;
            emu = Units.toEMU(getRowHeight(this.sheet, row));
            length2 += (long) emu;
        }
        cTMarkerNewInstance.setRow(row);
        cTMarkerNewInstance.setRowOff(Long.valueOf(((long) emu) - (length2 - j7)));
        return cTMarkerNewInstance;
    }

    private CTMarker getCell1() {
        CTMarker cTMarker = this.cell1;
        return cTMarker != null ? cTMarker : calcCell(EMPTY_MARKER, POIXMLUnits.parseLength(this.position.xgetX()), POIXMLUnits.parseLength(this.position.xgetY()));
    }

    private CTMarker getCell2() {
        CTMarker cTMarker = this.cell2;
        return cTMarker != null ? cTMarker : calcCell(getCell1(), this.size.getCx(), this.size.getCy());
    }

    private static float getRowHeight(XSSFSheet xSSFSheet, int i5) {
        XSSFRow row = xSSFSheet.getRow(i5);
        return row == null ? xSSFSheet.getDefaultRowHeightInPoints() : row.getHeightInPoints();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XSSFClientAnchor)) {
            return false;
        }
        XSSFClientAnchor xSSFClientAnchor = (XSSFClientAnchor) obj;
        return getDx1() == xSSFClientAnchor.getDx1() && getDx2() == xSSFClientAnchor.getDx2() && getDy1() == xSSFClientAnchor.getDy1() && getDy2() == xSSFClientAnchor.getDy2() && getCol1() == xSSFClientAnchor.getCol1() && getCol2() == xSSFClientAnchor.getCol2() && getRow1() == xSSFClientAnchor.getRow1() && getRow2() == xSSFClientAnchor.getRow2();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public ClientAnchor.AnchorType getAnchorType() {
        return this.anchorType;
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public short getCol1() {
        return (short) getCell1().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public short getCol2() {
        return (short) getCell2().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDx1() {
        return Math.toIntExact(POIXMLUnits.parseLength(getCell1().xgetColOff()));
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDx2() {
        return Math.toIntExact(POIXMLUnits.parseLength(getCell2().xgetColOff()));
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDy1() {
        return Math.toIntExact(POIXMLUnits.parseLength(getCell1().xgetRowOff()));
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDy2() {
        return Math.toIntExact(POIXMLUnits.parseLength(getCell2().xgetRowOff()));
    }

    @Internal
    public CTMarker getFrom() {
        return getCell1();
    }

    public CTPoint2D getPosition() {
        return this.position;
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getRow1() {
        return getCell1().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getRow2() {
        return getCell2().getRow();
    }

    public CTPositiveSize2D getSize() {
        return this.size;
    }

    @Internal
    public CTMarker getTo() {
        return getCell2();
    }

    public int hashCode() {
        return 42;
    }

    public boolean isSet() {
        CTMarker cell1 = getCell1();
        CTMarker cell2 = getCell2();
        return (cell1.getCol() == 0 && cell2.getCol() == 0 && cell1.getRow() == 0 && cell2.getRow() == 0) ? false : true;
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setAnchorType(ClientAnchor.AnchorType anchorType) {
        this.anchorType = anchorType;
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setCol1(int i5) {
        this.cell1.setCol(i5);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setCol2(int i5) {
        this.cell2.setCol(i5);
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDx1(int i5) {
        this.cell1.setColOff(Integer.valueOf(i5));
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDx2(int i5) {
        this.cell2.setColOff(Integer.valueOf(i5));
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDy1(int i5) {
        this.cell1.setRowOff(Integer.valueOf(i5));
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDy2(int i5) {
        this.cell2.setRowOff(Integer.valueOf(i5));
    }

    public void setFrom(CTMarker cTMarker) {
        this.cell1 = cTMarker;
    }

    public void setPosition(CTPoint2D cTPoint2D) {
        this.position = cTPoint2D;
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setRow1(int i5) {
        this.cell1.setRow(i5);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setRow2(int i5) {
        this.cell2.setRow(i5);
    }

    public void setSize(CTPositiveSize2D cTPositiveSize2D) {
        this.size = cTPositiveSize2D;
    }

    public void setTo(CTMarker cTMarker) {
        this.cell2 = cTMarker;
    }

    public String toString() {
        return "from : " + getCell1() + "; to: " + getCell2();
    }

    public XSSFClientAnchor(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.anchorType = ClientAnchor.AnchorType.MOVE_AND_RESIZE;
        DocumentFactory<CTMarker> documentFactory = CTMarker.Factory;
        CTMarker cTMarkerNewInstance = documentFactory.newInstance();
        this.cell1 = cTMarkerNewInstance;
        cTMarkerNewInstance.setCol(i9);
        this.cell1.setColOff(Integer.valueOf(i5));
        this.cell1.setRow(i10);
        this.cell1.setRowOff(Integer.valueOf(i6));
        CTMarker cTMarkerNewInstance2 = documentFactory.newInstance();
        this.cell2 = cTMarkerNewInstance2;
        cTMarkerNewInstance2.setCol(i11);
        this.cell2.setColOff(Integer.valueOf(i7));
        this.cell2.setRow(i12);
        this.cell2.setRowOff(Integer.valueOf(i8));
    }

    public XSSFClientAnchor(CTMarker cTMarker, CTMarker cTMarker2) {
        this.anchorType = ClientAnchor.AnchorType.MOVE_AND_RESIZE;
        this.cell1 = cTMarker;
        this.cell2 = cTMarker2;
    }

    public XSSFClientAnchor(XSSFSheet xSSFSheet, CTMarker cTMarker, CTPositiveSize2D cTPositiveSize2D) {
        this.anchorType = ClientAnchor.AnchorType.MOVE_DONT_RESIZE;
        this.sheet = xSSFSheet;
        this.size = cTPositiveSize2D;
        this.cell1 = cTMarker;
    }

    public XSSFClientAnchor(XSSFSheet xSSFSheet, CTPoint2D cTPoint2D, CTPositiveSize2D cTPositiveSize2D) {
        this.anchorType = ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE;
        this.sheet = xSSFSheet;
        this.position = cTPoint2D;
        this.size = cTPositiveSize2D;
    }
}
