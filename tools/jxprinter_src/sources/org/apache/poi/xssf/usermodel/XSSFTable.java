package org.apache.poi.xssf.usermodel;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.usermodel.TableStyleInfo;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFTable extends POIXMLDocumentPart implements Table {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSSFTable.class);
    private transient ConcurrentSkipListMap<String, Integer> columnMap;
    private transient String commonXPath;
    private CTTable ctTable;
    private transient CellReference endCellReference;
    private transient String name;
    private transient CellReference startCellReference;
    private transient String styleName;
    private transient List<XSSFTableColumn> tableColumns;
    private transient List<XSSFXmlColumnPr> xmlColumnPrs;

    public XSSFTable() {
        this.ctTable = CTTable.Factory.newInstance();
    }

    private List<XSSFXmlColumnPr> getXmlColumnPrs() {
        if (this.xmlColumnPrs == null) {
            this.xmlColumnPrs = new ArrayList();
            Iterator<XSSFTableColumn> it = getColumns().iterator();
            while (it.hasNext()) {
                XSSFXmlColumnPr xmlColumnPr = it.next().getXmlColumnPr();
                if (xmlColumnPr != null) {
                    this.xmlColumnPrs.add(xmlColumnPr);
                }
            }
        }
        return this.xmlColumnPrs;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            writeTo(outputStream);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public boolean contains(CellReference cellReference) {
        return cellReference != null && getSheetName().equals(cellReference.getSheetName()) && cellReference.getRow() >= getStartRowIndex() && cellReference.getRow() <= getEndRowIndex() && cellReference.getCol() >= getStartColIndex() && cellReference.getCol() <= getEndColIndex();
    }

    public XSSFTableColumn createColumn(String str) {
        return createColumn(str, getColumnCount());
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int findColumnIndex(String str) {
        if (str == null) {
            return -1;
        }
        if (this.columnMap == null) {
            this.columnMap = new ConcurrentSkipListMap<>(String.CASE_INSENSITIVE_ORDER);
            Iterator<XSSFTableColumn> it = getColumns().iterator();
            int i5 = 0;
            while (it.hasNext()) {
                this.columnMap.put(it.next().getName(), Integer.valueOf(i5));
                i5++;
            }
        }
        Integer num = this.columnMap.get(str.replace("''", "'").replace("'#", "#"));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public AreaReference getArea() {
        if (this.ctTable.getRef() == null) {
            return null;
        }
        return new AreaReference(this.ctTable.getRef(), getXSSFSheet().getWorkbook().getSpreadsheetVersion());
    }

    @Internal(since = "POI 3.15 beta 3")
    public CTTable getCTTable() {
        return this.ctTable;
    }

    public AreaReference getCellReferences() {
        return new AreaReference(getStartCellReference(), getEndCellReference(), SpreadsheetVersion.EXCEL2007);
    }

    public int getColumnCount() {
        CTTableColumns tableColumns = this.ctTable.getTableColumns();
        if (tableColumns == null) {
            return 0;
        }
        return (int) tableColumns.getCount();
    }

    public List<XSSFTableColumn> getColumns() {
        if (this.tableColumns == null) {
            ArrayList arrayList = new ArrayList();
            CTTableColumns tableColumns = this.ctTable.getTableColumns();
            if (tableColumns != null) {
                Iterator<CTTableColumn> it = tableColumns.getTableColumnList().iterator();
                while (it.hasNext()) {
                    arrayList.add(new XSSFTableColumn(this, it.next()));
                }
            }
            this.tableColumns = Collections.unmodifiableList(arrayList);
        }
        return this.tableColumns;
    }

    public String getCommonXpath() {
        if (this.commonXPath == null) {
            String[] strArr = new String[0];
            for (XSSFTableColumn xSSFTableColumn : getColumns()) {
                if (xSSFTableColumn.getXmlColumnPr() != null) {
                    String[] strArrSplit = xSSFTableColumn.getXmlColumnPr().getXPath().split(PackagingURIHelper.FORWARD_SLASH_STRING);
                    if (strArr.length == 0) {
                        strArr = strArrSplit;
                    } else {
                        int iMin = Math.min(strArr.length, strArrSplit.length);
                        for (int i5 = 0; i5 < iMin; i5++) {
                            if (!strArr[i5].equals(strArrSplit[i5])) {
                                strArr = (String[]) Arrays.asList(strArr).subList(0, i5).toArray(new String[0]);
                                break;
                            }
                        }
                    }
                }
            }
            strArr[0] = "";
            this.commonXPath = StringUtil.join(strArr, PackagingURIHelper.FORWARD_SLASH_STRING);
        }
        return this.commonXPath;
    }

    public int getDataRowCount() {
        CellReference startCellReference = getStartCellReference();
        CellReference endCellReference = getEndCellReference();
        if (startCellReference == null || endCellReference == null) {
            return 0;
        }
        return (((endCellReference.getRow() - startCellReference.getRow()) + 1) - getHeaderRowCount()) - getTotalsRowCount();
    }

    public String getDisplayName() {
        return this.ctTable.getDisplayName();
    }

    public CellReference getEndCellReference() {
        if (this.endCellReference == null) {
            setCellReferences();
        }
        return this.endCellReference;
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getEndColIndex() {
        return getEndCellReference().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getEndRowIndex() {
        return getEndCellReference().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getHeaderRowCount() {
        return (int) this.ctTable.getHeaderRowCount();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public String getName() {
        if (this.name == null && this.ctTable.getName() != null) {
            setName(this.ctTable.getName());
        }
        return this.name;
    }

    public int getRowCount() {
        CellReference startCellReference = getStartCellReference();
        CellReference endCellReference = getEndCellReference();
        if (startCellReference == null || endCellReference == null) {
            return 0;
        }
        return (endCellReference.getRow() - startCellReference.getRow()) + 1;
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public String getSheetName() {
        return getXSSFSheet().getSheetName();
    }

    public CellReference getStartCellReference() {
        if (this.startCellReference == null) {
            setCellReferences();
        }
        return this.startCellReference;
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getStartColIndex() {
        return getStartCellReference().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getStartRowIndex() {
        return getStartCellReference().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public TableStyleInfo getStyle() {
        if (this.ctTable.isSetTableStyleInfo()) {
            return new XSSFTableStyleInfo(((XSSFSheet) getParent()).getWorkbook().getStylesSource(), this.ctTable.getTableStyleInfo());
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public String getStyleName() {
        if (this.styleName == null && this.ctTable.isSetTableStyleInfo()) {
            setStyleName(this.ctTable.getTableStyleInfo().getName());
        }
        return this.styleName;
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getTotalsRowCount() {
        return (int) this.ctTable.getTotalsRowCount();
    }

    public XSSFSheet getXSSFSheet() {
        return (XSSFSheet) getParent();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public boolean isHasTotalsRow() {
        return this.ctTable.getTotalsRowShown();
    }

    public boolean mapsTo(long j6) {
        Iterator<XSSFXmlColumnPr> it = getXmlColumnPrs().iterator();
        while (it.hasNext()) {
            if (it.next().getMapId() == j6) {
                return true;
            }
        }
        return false;
    }

    public void onTableDelete() {
        Iterator<POIXMLDocumentPart.RelationPart> it = getRelationParts().iterator();
        while (it.hasNext()) {
            removeRelation(it.next().getDocumentPart(), true);
        }
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.ctTable = TableDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getTable();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void removeColumn(XSSFTableColumn xSSFTableColumn) {
        int iIndexOf = getColumns().indexOf(xSSFTableColumn);
        if (iIndexOf >= 0) {
            this.ctTable.getTableColumns().removeTableColumn(iIndexOf);
            updateReferences();
            updateHeaders();
        }
    }

    public void setArea(AreaReference areaReference) {
        if (areaReference == null) {
            throw new IllegalArgumentException("AreaReference must not be null");
        }
        String sheetName = areaReference.getFirstCell().getSheetName();
        if (sheetName != null && !sheetName.equals(getXSSFSheet().getSheetName())) {
            throw new IllegalArgumentException("The AreaReference must not reference a different sheet");
        }
        if (!supportsAreaReference(areaReference)) {
            throw new IllegalArgumentException(androidx.collection.a.i(getTotalsRowCount() + getHeaderRowCount() + 1, "AreaReference needs at least ", " rows, to cover at least one data row and all header rows and totals rows"));
        }
        String asString = areaReference.formatAsString();
        if (asString.indexOf(33) != -1) {
            asString = asString.substring(asString.indexOf(33) + 1);
        }
        this.ctTable.setRef(asString);
        if (this.ctTable.isSetAutoFilter()) {
            this.ctTable.getAutoFilter().setRef(asString);
        }
        updateReferences();
        int columnCount = getColumnCount();
        int col = (areaReference.getLastCell().getCol() - areaReference.getFirstCell().getCol()) + 1;
        if (col > columnCount) {
            while (columnCount < col) {
                createColumn(null, columnCount);
                columnCount++;
            }
        } else if (col < columnCount) {
            while (columnCount > col) {
                removeColumn(columnCount - 1);
                columnCount--;
            }
        }
        updateHeaders();
    }

    @Internal
    public void setCellRef(AreaReference areaReference) {
        String asString = areaReference.formatAsString();
        if (asString.indexOf(33) != -1) {
            asString = asString.substring(asString.indexOf(33) + 1);
        }
        this.ctTable.setRef(asString);
        if (this.ctTable.isSetAutoFilter()) {
            int totalsRowCount = getTotalsRowCount();
            if (totalsRowCount != 0) {
                asString = new AreaReference(new CellReference(areaReference.getFirstCell().getRow(), areaReference.getFirstCell().getCol()), new CellReference(areaReference.getLastCell().getRow() - totalsRowCount, areaReference.getLastCell().getCol()), SpreadsheetVersion.EXCEL2007).formatAsString();
            }
            this.ctTable.getAutoFilter().setRef(asString);
        }
        updateReferences();
        updateHeaders();
    }

    public void setCellReferences(AreaReference areaReference) {
        setCellRef(areaReference);
    }

    public void setDataRowCount(int i5) {
        CellReference cellReference;
        XSSFCell cell;
        if (i5 < 1) {
            throw new IllegalArgumentException("Table must have at least one data row");
        }
        updateReferences();
        int dataRowCount = getDataRowCount();
        if (dataRowCount == i5) {
            return;
        }
        CellReference startCellReference = getStartCellReference();
        CellReference endCellReference = getEndCellReference();
        SpreadsheetVersion spreadsheetVersion = getXSSFSheet().getWorkbook().getSpreadsheetVersion();
        CellReference cellReference2 = new CellReference((startCellReference.getRow() + (getTotalsRowCount() + (getHeaderRowCount() + i5))) - 1, endCellReference.getCol());
        AreaReference areaReference = new AreaReference(startCellReference, cellReference2, spreadsheetVersion);
        if (i5 < dataRowCount) {
            cellReference = new CellReference(areaReference.getLastCell().getRow() + 1, areaReference.getFirstCell().getCol());
        } else {
            cellReference = new CellReference(endCellReference.getRow() + 1, areaReference.getFirstCell().getCol());
            endCellReference = cellReference2;
        }
        for (CellReference cellReference3 : new AreaReference(cellReference, endCellReference, spreadsheetVersion).getAllReferencedCells()) {
            XSSFRow row = getXSSFSheet().getRow(cellReference3.getRow());
            if (row != null && (cell = row.getCell((int) cellReference3.getCol())) != null) {
                cell.setBlank();
                cell.setCellStyle(null);
            }
        }
        setCellRef(areaReference);
    }

    public void setDisplayName(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Display name must not be null or empty");
        }
        this.ctTable.setDisplayName(str);
    }

    public void setName(String str) {
        if (str == null) {
            this.ctTable.unsetName();
            this.name = null;
        } else {
            this.ctTable.setName(str);
            this.name = str;
        }
    }

    public void setStyleName(String str) {
        if (str != null) {
            if (!this.ctTable.isSetTableStyleInfo()) {
                this.ctTable.addNewTableStyleInfo();
            }
            this.ctTable.getTableStyleInfo().setName(str);
            this.styleName = str;
            return;
        }
        if (this.ctTable.isSetTableStyleInfo()) {
            try {
                this.ctTable.getTableStyleInfo().unsetName();
            } catch (Exception e) {
                LOG.atDebug().log("Failed to unset style name", e);
            }
        }
        this.styleName = null;
    }

    public boolean supportsAreaReference(AreaReference areaReference) {
        return (areaReference.getLastCell().getRow() - areaReference.getFirstCell().getRow()) + 1 >= getTotalsRowCount() + (Math.max(1, getHeaderRowCount()) + 1);
    }

    public void updateHeaders() {
        CTTableColumns tableColumns;
        XSSFSheet xSSFSheet = (XSSFSheet) getParent();
        CellReference startCellReference = getStartCellReference();
        if (startCellReference == null) {
            return;
        }
        int row = startCellReference.getRow();
        int col = startCellReference.getCol();
        XSSFRow row2 = xSSFSheet.getRow(row);
        DataFormatter dataFormatter = new DataFormatter();
        if (row2 != null && (tableColumns = getCTTable().getTableColumns()) != null) {
            for (CTTableColumn cTTableColumn : tableColumns.getTableColumnList()) {
                XSSFCell cell = row2.getCell(col);
                if (cell != null) {
                    cTTableColumn.setName(dataFormatter.formatCellValue(cell).replace("\n", "_x000a_").replace("\r", "_x000d_"));
                }
                col++;
            }
        }
        this.tableColumns = null;
        this.columnMap = null;
        this.xmlColumnPrs = null;
        this.commonXPath = null;
    }

    public void updateReferences() {
        this.startCellReference = null;
        this.endCellReference = null;
    }

    public void writeTo(OutputStream outputStream) {
        updateHeaders();
        TableDocument tableDocumentNewInstance = TableDocument.Factory.newInstance();
        tableDocumentNewInstance.setTable(this.ctTable);
        tableDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    private void setCellReferences() {
        String ref = this.ctTable.getRef();
        if (ref != null) {
            String[] strArrSplit = ref.split(ParameterizedMessage.ERROR_MSG_SEPARATOR, 2);
            String str = strArrSplit[0];
            String str2 = strArrSplit.length == 2 ? strArrSplit[1] : str;
            this.startCellReference = new CellReference(str);
            this.endCellReference = new CellReference(str2);
        }
    }

    public XSSFTableColumn createColumn(String str, int i5) {
        int columnCount = getColumnCount();
        if (i5 < 0 || i5 > columnCount) {
            throw new IllegalArgumentException("Column index out of bounds");
        }
        CTTableColumns tableColumns = this.ctTable.getTableColumns();
        if (tableColumns == null) {
            tableColumns = this.ctTable.addNewTableColumns();
        }
        long jMax = 0;
        for (XSSFTableColumn xSSFTableColumn : getColumns()) {
            if (str != null && str.equalsIgnoreCase(xSSFTableColumn.getName())) {
                throw new IllegalArgumentException(AbstractC0157z.o("Column '", str, "' already exists. Column names must be unique per table."));
            }
            jMax = Math.max(jMax, xSSFTableColumn.getId());
        }
        long j6 = jMax + 1;
        CTTableColumn cTTableColumnInsertNewTableColumn = tableColumns.insertNewTableColumn(i5);
        tableColumns.setCount(tableColumns.sizeOfTableColumnArray());
        cTTableColumnInsertNewTableColumn.setId(j6);
        if (str != null) {
            cTTableColumnInsertNewTableColumn.setName(str);
        } else {
            cTTableColumnInsertNewTableColumn.setName("Column " + j6);
        }
        if (this.ctTable.getRef() != null) {
            CellReference startCellReference = getStartCellReference();
            setCellRef(new AreaReference(startCellReference, new CellReference(getEndCellReference().getRow(), (startCellReference.getCol() + (columnCount + 1)) - 1), getXSSFSheet().getWorkbook().getSpreadsheetVersion()));
        }
        updateHeaders();
        return getColumns().get(i5);
    }

    public XSSFTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        InputStream inputStream = packagePart.getInputStream();
        try {
            readFrom(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void removeColumn(int i5) {
        if (i5 >= 0 && i5 <= getColumnCount() - 1) {
            if (getColumnCount() != 1) {
                CTTableColumns tableColumns = this.ctTable.getTableColumns();
                tableColumns.removeTableColumn(i5);
                tableColumns.setCount(tableColumns.getTableColumnList().size());
                updateReferences();
                updateHeaders();
                return;
            }
            throw new IllegalArgumentException("Table must have at least one column");
        }
        throw new IllegalArgumentException("Column index out of bounds");
    }
}
