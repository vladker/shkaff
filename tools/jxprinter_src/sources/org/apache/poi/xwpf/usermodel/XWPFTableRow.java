package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFTableRow {
    private final CTRow ctRow;
    private final XWPFTable table;
    private List<XWPFTableCell> tableCells;

    public XWPFTableRow(CTRow cTRow, XWPFTable xWPFTable) {
        this.table = xWPFTable;
        this.ctRow = cTRow;
        getTableCells();
    }

    private void ensureBlockLevelElement(XWPFTableCell xWPFTableCell) {
        if (xWPFTableCell.getParagraphs().isEmpty()) {
            xWPFTableCell.addParagraph();
        }
    }

    private boolean getRepeat() {
        if (this.ctRow.isSetTrPr()) {
            CTTrPr trPr = getTrPr();
            if (trPr.sizeOfTblHeaderArray() > 0) {
                CTOnOff tblHeaderArray = trPr.getTblHeaderArray(0);
                return !tblHeaderArray.isSetVal() || POIXMLUnits.parseOnOff(tblHeaderArray.xgetVal());
            }
        }
        return false;
    }

    private CTTrPr getTrPr() {
        return this.ctRow.isSetTrPr() ? this.ctRow.getTrPr() : this.ctRow.addNewTrPr();
    }

    public XWPFTableCell addNewTableCell() {
        XWPFTableCell xWPFTableCell = new XWPFTableCell(this.ctRow.addNewTc(), this, this.table.getBody());
        ensureBlockLevelElement(xWPFTableCell);
        this.tableCells.add(xWPFTableCell);
        return xWPFTableCell;
    }

    public XWPFTableCell createCell() {
        XWPFTableCell xWPFTableCell = new XWPFTableCell(this.ctRow.addNewTc(), this, this.table.getBody());
        ensureBlockLevelElement(xWPFTableCell);
        this.tableCells.add(xWPFTableCell);
        return xWPFTableCell;
    }

    public XWPFTableCell getCell(int i5) {
        if (i5 < 0 || i5 >= this.ctRow.sizeOfTcArray()) {
            return null;
        }
        return getTableCells().get(i5);
    }

    @Internal
    public CTRow getCtRow() {
        return this.ctRow;
    }

    public int getHeight() {
        CTTrPr trPr = getTrPr();
        if (trPr.sizeOfTrHeightArray() == 0) {
            return 0;
        }
        return (int) Units.toDXA(POIXMLUnits.parseLength(trPr.getTrHeightArray(0).xgetVal()));
    }

    public TableRowHeightRule getHeightRule() {
        CTTrPr trPr = getTrPr();
        return trPr.sizeOfTrHeightArray() == 0 ? TableRowHeightRule.AUTO : TableRowHeightRule.valueOf(trPr.getTrHeightArray(0).getHRule().intValue());
    }

    public XWPFTable getTable() {
        return this.table;
    }

    public XWPFTableCell getTableCell(CTTc cTTc) {
        for (XWPFTableCell xWPFTableCell : this.tableCells) {
            if (xWPFTableCell.getCTTc() == cTTc) {
                return xWPFTableCell;
            }
        }
        return null;
    }

    public List<XWPFTableCell> getTableCells() {
        if (this.tableCells == null) {
            ArrayList arrayList = new ArrayList();
            for (CTTc cTTc : this.ctRow.getTcArray()) {
                arrayList.add(new XWPFTableCell(cTTc, this, this.table.getBody()));
            }
            this.tableCells = arrayList;
        }
        return this.tableCells;
    }

    public List<ICell> getTableICells() {
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = this.ctRow.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTTc) {
                    arrayList.add(new XWPFTableCell((CTTc) object, this, this.table.getBody()));
                } else if (object instanceof CTSdtCell) {
                    arrayList.add(new XWPFSDTCell((CTSdtCell) object, this, this.table.getBody()));
                }
            }
            xmlCursorNewCursor.close();
            return arrayList;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public boolean isCantSplitRow() {
        if (this.ctRow.isSetTrPr()) {
            CTTrPr trPr = getTrPr();
            if (trPr.sizeOfCantSplitArray() > 0) {
                CTOnOff cantSplitArray = trPr.getCantSplitArray(0);
                return !cantSplitArray.isSetVal() || POIXMLUnits.parseOnOff(cantSplitArray.xgetVal());
            }
        }
        return false;
    }

    public boolean isRepeatHeader() {
        boolean z6 = false;
        for (XWPFTableRow xWPFTableRow : this.table.getRows()) {
            boolean repeat = xWPFTableRow.getRepeat();
            if (xWPFTableRow == this || !repeat) {
                return repeat;
            }
            z6 = repeat;
        }
        return z6;
    }

    public void removeCell(int i5) {
        if (i5 < 0 || i5 >= this.ctRow.sizeOfTcArray()) {
            return;
        }
        this.tableCells.remove(i5);
        this.ctRow.removeTc(i5);
    }

    public void setCantSplitRow(boolean z6) {
        CTTrPr trPr = getTrPr();
        (trPr.sizeOfCantSplitArray() > 0 ? trPr.getCantSplitArray(0) : trPr.addNewCantSplit()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    public void setHeight(int i5) {
        CTTrPr trPr = getTrPr();
        (trPr.sizeOfTrHeightArray() == 0 ? trPr.addNewTrHeight() : trPr.getTrHeightArray(0)).setVal(new BigInteger(Integer.toString(i5)));
    }

    public void setHeightRule(TableRowHeightRule tableRowHeightRule) {
        CTTrPr trPr = getTrPr();
        (trPr.sizeOfTrHeightArray() == 0 ? trPr.addNewTrHeight() : trPr.getTrHeightArray(0)).setHRule(STHeightRule.Enum.forInt(tableRowHeightRule.getValue()));
    }

    public void setRepeatHeader(boolean z6) {
        CTTrPr trPr = getTrPr();
        (trPr.sizeOfTblHeaderArray() > 0 ? trPr.getTblHeaderArray(0) : trPr.addNewTblHeader()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }
}
