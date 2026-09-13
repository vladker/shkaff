package org.apache.poi.xssf.usermodel.helpers;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.model.SingleXmlCells;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFSingleXmlCell {
    private SingleXmlCells parent;
    private CTSingleXmlCell singleXmlCell;

    public XSSFSingleXmlCell(CTSingleXmlCell cTSingleXmlCell, SingleXmlCells singleXmlCells) {
        this.singleXmlCell = cTSingleXmlCell;
        this.parent = singleXmlCells;
    }

    public long getMapId() {
        return this.singleXmlCell.getXmlCellPr().getXmlPr().getMapId();
    }

    public XSSFCell getReferencedCell() {
        CellReference cellReference = new CellReference(this.singleXmlCell.getR());
        XSSFRow row = this.parent.getXSSFSheet().getRow(cellReference.getRow());
        if (row == null) {
            row = this.parent.getXSSFSheet().createRow(cellReference.getRow());
        }
        XSSFCell cell = row.getCell((int) cellReference.getCol());
        return cell == null ? row.createCell((int) cellReference.getCol()) : cell;
    }

    public String getXmlDataType() {
        return this.singleXmlCell.getXmlCellPr().getXmlPr().getXmlDataType();
    }

    public String getXpath() {
        return this.singleXmlCell.getXmlCellPr().getXmlPr().getXpath();
    }
}
