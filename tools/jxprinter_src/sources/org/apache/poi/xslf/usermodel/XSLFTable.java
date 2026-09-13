package org.apache.poi.xslf.usermodel;

import A3.AbstractC0157z;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.usermodel.TableShape;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFTable extends XSLFGraphicFrame implements Iterable<XSLFTableRow>, TableShape<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSLFTable.class);
    static final String TABLE_URI = "http://schemas.openxmlformats.org/drawingml/2006/table";
    private final List<XSLFTableRow> _rows;
    private final CTTable _table;

    public XSLFTable(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        super(cTGraphicalObjectFrame, xSLFSheet);
        CTGraphicalObjectData graphicData = cTGraphicalObjectFrame.getGraphic().getGraphicData();
        XmlCursor xmlCursorNewCursor = graphicData.newCursor();
        try {
            if (!xmlCursorNewCursor.toChild(XSSFRelation.NS_DRAWINGML, "tbl")) {
                throw new IllegalStateException("a:tbl element was not found in\n " + graphicData);
            }
            XmlObject object = xmlCursorNewCursor.getObject();
            if (object instanceof XmlAnyTypeImpl) {
                throw new IllegalStateException("Schemas (*.xsb) for CTTable can't be loaded - usually this happens when OSGI loading is used and the thread context classloader has no reference to the xmlbeans classes");
            }
            CTTable cTTable = (CTTable) object;
            this._table = cTTable;
            xmlCursorNewCursor.close();
            this._rows = new ArrayList(cTTable.sizeOfTrArray());
            Iterator<CTTableRow> it = cTTable.getTrList().iterator();
            while (it.hasNext()) {
                this._rows.add(new XSLFTableRow(it.next(), this));
            }
            updateRowColIndexes();
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

    private XSLFTableRow initializeRow(CTTableRow cTTableRow) {
        XSLFTableRow xSLFTableRow = new XSLFTableRow(cTTableRow, this);
        xSLFTableRow.setHeight(20.0d);
        return xSLFTableRow;
    }

    public static CTGraphicalObjectFrame prototype(int i5) {
        CTGraphicalObjectFrame cTGraphicalObjectFrameNewInstance = CTGraphicalObjectFrame.Factory.newInstance();
        CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr = cTGraphicalObjectFrameNewInstance.addNewNvGraphicFramePr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Table " + i5);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) i5);
        cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvGraphicFramePr().addNewGraphicFrameLocks().setNoGrp(true);
        cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewNvPr();
        cTGraphicalObjectFrameNewInstance.addNewXfrm();
        CTGraphicalObjectData cTGraphicalObjectDataAddNewGraphicData = cTGraphicalObjectFrameNewInstance.addNewGraphic().addNewGraphicData();
        XmlCursor xmlCursorNewCursor = cTGraphicalObjectDataAddNewGraphicData.newCursor();
        try {
            xmlCursorNewCursor.toNextToken();
            xmlCursorNewCursor.beginElement(new QName(XSSFRelation.NS_DRAWINGML, "tbl"));
            CTTable cTTableNewInstance = CTTable.Factory.newInstance();
            cTTableNewInstance.addNewTblPr();
            cTTableNewInstance.addNewTblGrid();
            XmlCursor xmlCursorNewCursor2 = cTTableNewInstance.newCursor();
            try {
                xmlCursorNewCursor2.moveXmlContents(xmlCursorNewCursor);
                xmlCursorNewCursor2.close();
                xmlCursorNewCursor.close();
                cTGraphicalObjectDataAddNewGraphicData.setUri(TABLE_URI);
                return cTGraphicalObjectFrameNewInstance;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor2 != null) {
                        try {
                            xmlCursorNewCursor2.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    public void addColumn() {
        this._table.getTblGrid().addNewGridCol().setW(Long.valueOf(POIXMLUnits.parseLength(this._table.getTblGrid().getGridColArray(getNumberOfColumns() - 1).xgetW())));
        Iterator<XSLFTableRow> it = this._rows.iterator();
        while (it.hasNext()) {
            XSLFTableCell xSLFTableCellAddCell = it.next().addCell();
            new XDDFTextBody(xSLFTableCellAddCell, xSLFTableCellAddCell.getTextBody(true)).initialize();
        }
    }

    public XSLFTableRow addRow() {
        XSLFTableRow xSLFTableRowInitializeRow = initializeRow(this._table.addNewTr());
        this._rows.add(xSLFTableRowInitializeRow);
        updateRowColIndexes();
        return xSLFTableRowInitializeRow;
    }

    @Internal
    public CTTable getCTTable() {
        return this._table;
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public double getColumnWidth(int i5) {
        return Units.toPoints(POIXMLUnits.parseLength(this._table.getTblGrid().getGridColArray(i5).xgetW()));
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public int getNumberOfColumns() {
        return this._table.getTblGrid().sizeOfGridColArray();
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public int getNumberOfRows() {
        return this._table.sizeOfTrArray();
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public double getRowHeight(int i5) {
        return Units.toPoints(POIXMLUnits.parseLength(this._table.getTrArray(i5).xgetH()));
    }

    public List<XSLFTableRow> getRows() {
        return Collections.unmodifiableList(this._rows);
    }

    public XSLFTableStyle getTableStyle() {
        CTTable cTTable = getCTTable();
        if (cTTable.isSetTblPr() && cTTable.getTblPr().isSetTableStyleId()) {
            String tableStyleId = cTTable.getTblPr().getTableStyleId();
            for (XSLFTableStyle xSLFTableStyle : getSheet().getSlideShow().getTableStyles().getStyles()) {
                if (xSLFTableStyle.getStyleId().equals(tableStyleId)) {
                    return xSLFTableStyle;
                }
            }
        }
        return null;
    }

    public void insertColumn(int i5) {
        if (getNumberOfColumns() < i5) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Cannot insert column at ", "; table has only ");
            sbT.append(getNumberOfColumns());
            sbT.append("columns.");
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        this._table.getTblGrid().insertNewGridCol(i5).setW(Long.valueOf(POIXMLUnits.parseLength(this._table.getTblGrid().getGridColArray(i5).xgetW())));
        Iterator<XSLFTableRow> it = this._rows.iterator();
        while (it.hasNext()) {
            XSLFTableCell xSLFTableCellInsertCell = it.next().insertCell(i5);
            new XDDFTextBody(xSLFTableCellInsertCell, xSLFTableCellInsertCell.getTextBody(true)).initialize();
        }
    }

    public XSLFTableRow insertRow(int i5) {
        if (getNumberOfRows() < i5) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Cannot insert row at ", "; table has only ");
            sbT.append(getNumberOfRows());
            sbT.append("rows.");
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        XSLFTableRow xSLFTableRowInitializeRow = initializeRow(this._table.insertNewTr(i5));
        for (int i6 = 0; i6 < getNumberOfColumns(); i6++) {
            xSLFTableRowInitializeRow.addCell();
        }
        this._rows.add(i5, xSLFTableRowInitializeRow);
        return xSLFTableRowInitializeRow;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableRow> iterator() {
        return this._rows.iterator();
    }

    public void mergeCells(int i5, int i6, int i7, int i8) {
        if (i5 > i6) {
            throw new IllegalArgumentException(androidx.collection.a.h(i5, i6, "Cannot merge, first row > last row : ", " > "));
        }
        if (i7 > i8) {
            throw new IllegalArgumentException(androidx.collection.a.h(i7, i8, "Cannot merge, first column > last column : ", " > "));
        }
        int i9 = (i6 - i5) + 1;
        boolean z6 = i9 > 1;
        int i10 = (i8 - i7) + 1;
        boolean z7 = i10 > 1;
        for (int i11 = i5; i11 <= i6; i11++) {
            XSLFTableRow xSLFTableRow = this._rows.get(i11);
            for (int i12 = i7; i12 <= i8; i12++) {
                XSLFTableCell xSLFTableCell = xSLFTableRow.getCells().get(i12);
                if (z6) {
                    if (i11 == i5) {
                        xSLFTableCell.setRowSpan(i9);
                    } else {
                        xSLFTableCell.setVMerge();
                    }
                }
                if (z7) {
                    if (i12 == i7) {
                        xSLFTableCell.setGridSpan(i10);
                    } else {
                        xSLFTableCell.setHMerge();
                    }
                }
            }
        }
    }

    public void removeColumn(int i5) {
        if (getNumberOfColumns() < i5) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Cannot remove column at ", "; table has only ");
            sbT.append(getNumberOfColumns());
            sbT.append("columns.");
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        this._table.getTblGrid().removeGridCol(i5);
        Iterator<XSLFTableRow> it = this._rows.iterator();
        while (it.hasNext()) {
            it.next().removeCell(i5);
        }
    }

    public void removeRow(int i5) {
        if (getNumberOfRows() >= i5) {
            this._table.removeTr(i5);
            this._rows.remove(i5);
            updateRowColIndexes();
        } else {
            StringBuilder sbT = AbstractC0157z.t(i5, "Cannot remove row at ", "; table has only ");
            sbT.append(getNumberOfRows());
            sbT.append("rows.");
            throw new IndexOutOfBoundsException(sbT.toString());
        }
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public void setColumnWidth(int i5, double d) {
        this._table.getTblGrid().getGridColArray(i5).setW(Integer.valueOf(Units.toEMU(d)));
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public void setRowHeight(int i5, double d) {
        this._table.getTrArray(i5).setH(Integer.valueOf(Units.toEMU(d)));
    }

    public void updateCellAnchor() {
        double[] dArr;
        int numberOfRows = getNumberOfRows();
        int numberOfColumns = getNumberOfColumns();
        double[] dArr2 = new double[numberOfColumns];
        double[] dArr3 = new double[numberOfRows];
        for (int i5 = 0; i5 < numberOfRows; i5++) {
            dArr3[i5] = getRowHeight(i5);
        }
        for (int i6 = 0; i6 < numberOfColumns; i6++) {
            dArr2[i6] = getColumnWidth(i6);
        }
        Rectangle2D anchor = getAnchor();
        DrawFactory drawFactory = DrawFactory.getInstance(null);
        double y6 = anchor.getY();
        double x6 = anchor.getX();
        int i7 = 0;
        while (i7 < numberOfRows) {
            double dMax = 0.0d;
            int i8 = 0;
            while (i8 < numberOfColumns) {
                XSLFTableCell cell = getCell(i7, i8);
                double[] dArr4 = dArr2;
                if (cell != null) {
                    dArr = dArr3;
                    if (cell.getGridSpan() == 1 && cell.getRowSpan() == 1) {
                        cell.setAnchor(new Rectangle2D.Double(0.0d, 0.0d, dArr4[i8], 0.0d));
                        dMax = Math.max(dMax, drawFactory.getDrawable((TextShape<?, ?>) cell).getTextHeight());
                    }
                } else {
                    dArr = dArr3;
                }
                i8++;
                dArr2 = dArr4;
                dArr3 = dArr;
            }
            double[] dArr5 = dArr3;
            dArr5[i7] = Math.max(dArr5[i7], dMax);
            i7++;
            dArr2 = dArr2;
            dArr3 = dArr5;
        }
        double[] dArr6 = dArr2;
        double[] dArr7 = dArr3;
        double d = y6;
        int i9 = 0;
        while (i9 < numberOfRows) {
            double x7 = anchor.getX();
            for (int i10 = 0; i10 < numberOfColumns; i10++) {
                Rectangle2D.Double r18 = new Rectangle2D.Double(x7, d, dArr6[i10], dArr7[i9]);
                XSLFTableCell cell2 = getCell(i9, i10);
                if (cell2 != null) {
                    cell2.setAnchor(r18);
                    x7 = dArr6[i10] + 2.0d + x7;
                }
            }
            d = dArr7[i9] + 2.0d + d;
            i9++;
            x6 = x7;
        }
        for (int i11 = 0; i11 < numberOfRows; i11++) {
            for (int i12 = 0; i12 < numberOfColumns; i12++) {
                XSLFTableCell cell3 = getCell(i11, i12);
                if (cell3 != null) {
                    Rectangle2D anchor2 = cell3.getAnchor();
                    for (int i13 = i12 + 1; i13 < cell3.getGridSpan() + i12; i13++) {
                        XSLFTableCell cell4 = getCell(i11, i13);
                        if (cell4.getGridSpan() != 1 || cell4.getRowSpan() != 1) {
                            LOG.warn("invalid table span - rendering result is probably wrong");
                        }
                        anchor2.add(cell4.getAnchor());
                    }
                    for (int i14 = i11 + 1; i14 < cell3.getRowSpan() + i11; i14++) {
                        XSLFTableCell cell5 = getCell(i14, i12);
                        if (cell5.getGridSpan() != 1 || cell5.getRowSpan() != 1) {
                            LOG.warn("invalid table span - rendering result is probably wrong");
                        }
                        anchor2.add(cell5.getAnchor());
                    }
                    cell3.setAnchor(anchor2);
                }
            }
        }
        setAnchor(new Rectangle2D.Double(anchor.getX(), anchor.getY(), x6 - anchor.getX(), d - anchor.getY()));
    }

    public void updateRowColIndexes() {
        Iterator<XSLFTableRow> it = iterator();
        int i5 = 0;
        while (it.hasNext()) {
            Iterator<XSLFTableCell> it2 = it.next().iterator();
            int i6 = 0;
            while (it2.hasNext()) {
                it2.next().setRowColIndex(i5, i6);
                i6++;
            }
            i5++;
        }
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public XSLFTableCell getCell(int i5, int i6) {
        XSLFTableRow xSLFTableRow;
        if (i5 < 0 || this._rows.size() <= i5 || (xSLFTableRow = this._rows.get(i5)) == null) {
            return null;
        }
        List<XSLFTableCell> cells = xSLFTableRow.getCells();
        if (i6 >= 0 && cells.size() > i6) {
            return cells.get(i6);
        }
        return null;
    }
}
