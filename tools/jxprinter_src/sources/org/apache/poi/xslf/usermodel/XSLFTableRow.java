package org.apache.poi.xslf.usermodel;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFTableRow implements Iterable<XSLFTableCell> {
    private final List<XSLFTableCell> _cells;
    private final CTTableRow _row;
    private final XSLFTable _table;

    public XSLFTableRow(CTTableRow cTTableRow, XSLFTable xSLFTable) {
        this._row = cTTableRow;
        this._table = xSLFTable;
        CTTableCell[] tcArray = cTTableRow.getTcArray();
        this._cells = new ArrayList(tcArray.length);
        for (CTTableCell cTTableCell : tcArray) {
            this._cells.add(new XSLFTableCell(cTTableCell, xSLFTable));
        }
    }

    public XSLFTableCell addCell() {
        CTTableCell cTTableCellAddNewTc = this._row.addNewTc();
        cTTableCellAddNewTc.set(XSLFTableCell.prototype());
        XSLFTableCell xSLFTableCell = new XSLFTableCell(cTTableCellAddNewTc, this._table);
        this._cells.add(xSLFTableCell);
        if (this._table.getNumberOfColumns() < this._row.sizeOfTcArray()) {
            this._table.getCTTable().getTblGrid().addNewGridCol().setW(Integer.valueOf(Units.toEMU(100.0d)));
        }
        this._table.updateRowColIndexes();
        return xSLFTableCell;
    }

    public List<XSLFTableCell> getCells() {
        return Collections.unmodifiableList(this._cells);
    }

    public double getHeight() {
        return Units.toPoints(POIXMLUnits.parseLength(this._row.xgetH()));
    }

    public CTTableRow getXmlObject() {
        return this._row;
    }

    public XSLFTableCell insertCell(int i5) {
        CTTableCell cTTableCellInsertNewTc = this._row.insertNewTc(i5);
        cTTableCellInsertNewTc.set(XSLFTableCell.prototype());
        XSLFTableCell xSLFTableCell = new XSLFTableCell(cTTableCellInsertNewTc, this._table);
        this._cells.add(i5, xSLFTableCell);
        if (this._table.getNumberOfColumns() < this._row.sizeOfTcArray()) {
            this._table.getCTTable().getTblGrid().insertNewGridCol(i5).setW(Integer.valueOf(Units.toEMU(100.0d)));
        }
        this._table.updateRowColIndexes();
        return xSLFTableCell;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableCell> iterator() {
        return this._cells.iterator();
    }

    public void mergeCells(int i5, int i6) {
        if (i5 >= i6) {
            throw new IllegalArgumentException(androidx.collection.a.h(i5, i6, "Cannot merge, first column >= last column : ", " >= "));
        }
        this._cells.get(i5).setGridSpan((i6 - i5) + 1);
        Iterator<XSLFTableCell> it = this._cells.subList(i5 + 1, i6 + 1).iterator();
        while (it.hasNext()) {
            it.next().setHMerge();
        }
    }

    public void removeCell(int i5) {
        if (this._row.sizeOfTcArray() >= i5) {
            this._row.removeTc(i5);
            this._cells.remove(i5);
            this._table.updateRowColIndexes();
        } else {
            StringBuilder sbT = AbstractC0157z.t(i5, "Cannot remove cell at ", "; row has only ");
            sbT.append(this._row.sizeOfTcArray());
            sbT.append("columns.");
            throw new IndexOutOfBoundsException(sbT.toString());
        }
    }

    public void setHeight(double d) {
        this._row.setH(Integer.valueOf(Units.toEMU(d)));
    }
}
