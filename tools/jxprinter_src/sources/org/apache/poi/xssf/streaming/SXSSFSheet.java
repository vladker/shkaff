package org.apache.poi.xssf.streaming;

import A3.AbstractC0157z;
import androidx.collection.a;
import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.AutoFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.PageMargin;
import org.apache.poi.ss.usermodel.PaneType;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.usermodel.OoxmlSheetExtensions;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFVMLDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SXSSFSheet implements Sheet, OoxmlSheetExtensions {
    private static final Logger LOG = LogManager.getLogger((Class<?>) SXSSFSheet.class);
    protected AutoSizeColumnTracker _autoSizeColumnTracker;
    final XSSFSheet _sh;
    protected final SXSSFWorkbook _workbook;
    protected SheetDataWriter _writer;
    private boolean allFlushed;
    private int outlineLevelRow;
    private int rightMostColumn;
    private final TreeMap<Integer, SXSSFRow> _rows = new TreeMap<>();
    private int _randomAccessWindowSize = 100;
    private int lastFlushedRowNumber = -1;
    private int leftMostColumn = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();

    public SXSSFSheet(SXSSFWorkbook sXSSFWorkbook, XSSFSheet xSSFSheet, int i5) {
        this._workbook = sXSSFWorkbook;
        this._sh = xSSFSheet;
        calculateLeftAndRightMostColumns(xSSFSheet);
        setRandomAccessWindowSize(i5);
        this._autoSizeColumnTracker = new AutoSizeColumnTracker(this);
    }

    private void calculateLeftAndRightMostColumns(XSSFSheet xSSFSheet) {
        if (this._workbook.shouldCalculateSheetDimensions()) {
            int i5 = 0;
            int iMin = Integer.MAX_VALUE;
            int iMax = 0;
            for (Row row : xSSFSheet) {
                i5++;
                if (row.getFirstCellNum() < iMin) {
                    short firstCellNum = row.getFirstCellNum();
                    int lastCellNum = row.getLastCellNum() - 1;
                    iMin = Math.min((int) firstCellNum, iMin);
                    iMax = Math.max(lastCellNum, iMax);
                }
            }
            if (i5 > 0) {
                this.leftMostColumn = iMin;
                this.rightMostColumn = iMax;
            }
        }
    }

    private void collapseRow(int i5) {
        SXSSFRow row = getRow(i5);
        if (row == null) {
            throw new IllegalArgumentException(a.i(i5, "Invalid row number(", "). Row does not exist."));
        }
        int iWriteHidden = writeHidden(row, findStartOfRowOutlineGroup(i5));
        SXSSFRow row2 = getRow(iWriteHidden);
        if (row2 != null) {
            row2.setCollapsed(Boolean.TRUE);
        } else {
            createRow(iWriteHidden).setCollapsed(Boolean.TRUE);
        }
    }

    private int findStartOfRowOutlineGroup(int i5) {
        int outlineLevel = getRow(i5).getOutlineLevel();
        if (outlineLevel == 0) {
            throw new IllegalArgumentException(a.i(i5, "Outline level is zero for the row (", ")."));
        }
        while (getRow(i5) != null) {
            if (getRow(i5).getOutlineLevel() < outlineLevel) {
                return i5 + 1;
            }
            i5--;
        }
        return i5 + 1;
    }

    private void flushOneRow() throws IOException {
        Integer numFirstKey = this._rows.firstKey();
        if (numFirstKey != null) {
            int iIntValue = numFirstKey.intValue();
            SXSSFRow sXSSFRow = this._rows.get(numFirstKey);
            AutoSizeColumnTracker autoSizeColumnTracker = this._autoSizeColumnTracker;
            if (autoSizeColumnTracker != null) {
                autoSizeColumnTracker.updateColumnWidths(sXSSFRow);
            }
            SheetDataWriter sheetDataWriter = this._writer;
            if (sheetDataWriter != null) {
                sheetDataWriter.writeRow(iIntValue, sXSSFRow);
            }
            this._rows.remove(numFirstKey);
            this.lastFlushedRowNumber = iIntValue;
        }
    }

    private CTSheetProtection safeGetProtectionField() {
        CTWorksheet cTWorksheet = this._sh.getCTWorksheet();
        return !isSheetProtectionEnabled() ? cTWorksheet.addNewSheetProtection() : cTWorksheet.getSheetProtection();
    }

    private void setWorksheetOutlineLevelRow() {
        CTWorksheet cTWorksheet = this._sh.getCTWorksheet();
        CTSheetFormatPr sheetFormatPr = cTWorksheet.isSetSheetFormatPr() ? cTWorksheet.getSheetFormatPr() : cTWorksheet.addNewSheetFormatPr();
        int i5 = this.outlineLevelRow;
        if (i5 > 0) {
            sheetFormatPr.setOutlineLevelRow((short) i5);
        }
    }

    private int writeHidden(SXSSFRow sXSSFRow, int i5) {
        int outlineLevel = sXSSFRow.getOutlineLevel();
        SXSSFRow row = getRow(i5);
        while (row != null && row.getOutlineLevel() >= outlineLevel) {
            row.setHidden(Boolean.TRUE);
            i5++;
            row = getRow(i5);
        }
        return i5;
    }

    public void addHyperlink(XSSFHyperlink xSSFHyperlink) {
        this._sh.addHyperlink(xSSFHyperlink);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int addMergedRegion(CellRangeAddress cellRangeAddress) {
        return this._sh.addMergedRegion(cellRangeAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int addMergedRegionUnsafe(CellRangeAddress cellRangeAddress) {
        return this._sh.addMergedRegionUnsafe(cellRangeAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void addValidationData(DataValidation dataValidation) {
        this._sh.addValidationData(dataValidation);
    }

    public boolean areAllRowsFlushed() {
        return this.allFlushed;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void autoSizeColumn(int i5) {
        autoSizeColumn(i5, false);
    }

    public void changeRowNum(SXSSFRow sXSSFRow, int i5) {
        removeRow(sXSSFRow);
        sXSSFRow.setRowNumWithoutUpdatingSheet(i5);
        this._rows.put(Integer.valueOf(i5), sXSSFRow);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i5, int i6, int i7, int i8) {
        this._sh.createFreezePane(i5, i6, i7, i8);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @Removal(version = "7.0.0")
    @Deprecated
    public void createSplitPane(int i5, int i6, int i7, int i8, int i9) {
        this._sh.createSplitPane(i5, i6, i7, i8, i9);
    }

    public void deriveDimension() {
        if (this._workbook.shouldCalculateSheetDimensions()) {
            try {
                this._sh.setDimensionOverride(new CellRangeAddress(getFirstRowNum(), getLastRowNum(), this.leftMostColumn, this.rightMostColumn));
            } catch (Exception e) {
                LOG.atDebug().log("Failed to set dimension details on sheet", e);
            }
        }
    }

    public void disableLocking() {
        safeGetProtectionField().setSheet(false);
    }

    public boolean dispose() {
        try {
            if (!this.allFlushed) {
                flushRows();
            }
            SheetDataWriter sheetDataWriter = this._writer;
            return sheetDataWriter == null || sheetDataWriter.dispose();
        } catch (Throwable th) {
            SheetDataWriter sheetDataWriter2 = this._writer;
            if (sheetDataWriter2 != null) {
                sheetDataWriter2.dispose();
            }
            throw th;
        }
    }

    public void enableLocking() {
        safeGetProtectionField().setSheet(true);
    }

    public void flushBufferedData() throws IOException {
        this._writer.flush();
    }

    public void flushRows(int i5) throws IOException {
        while (this._rows.size() > i5) {
            flushOneRow();
        }
        if (i5 == 0) {
            this.allFlushed = true;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellAddress getActiveCell() {
        return this._sh.getActiveCell();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getAutobreaks() {
        return this._sh.getAutobreaks();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Map<CellAddress, XSSFComment> getCellComments() {
        return this._sh.getCellComments();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int[] getColumnBreaks() {
        return this._sh.getColumnBreaks();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnOutlineLevel(int i5) {
        return this._sh.getColumnOutlineLevel(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellStyle getColumnStyle(int i5) {
        return this._sh.getColumnStyle(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnWidth(int i5) {
        return this._sh.getColumnWidth(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getColumnWidthInPixels(int i5) {
        return this._sh.getColumnWidthInPixels(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public DataValidationHelper getDataValidationHelper() {
        return this._sh.getDataValidationHelper();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<XSSFDataValidation> getDataValidations() {
        return this._sh.getDataValidations();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getDefaultColumnWidth() {
        return this._sh.getDefaultColumnWidth();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getDefaultRowHeight() {
        return this._sh.getDefaultRowHeight();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getDefaultRowHeightInPoints() {
        return this._sh.getDefaultRowHeightInPoints();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getDisplayGuts() {
        return this._sh.getDisplayGuts();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getFirstRowNum() {
        if (this._writer.getNumberOfFlushedRows() > 0) {
            return this._writer.getLowestIndexOfFlushedRows();
        }
        if (this._rows.isEmpty()) {
            return -1;
        }
        return this._rows.firstKey().intValue();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getFitToPage() {
        return this._sh.getFitToPage();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Footer getFooter() {
        return this._sh.getFooter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getForceFormulaRecalculation() {
        return this._sh.getForceFormulaRecalculation();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Header getHeader() {
        return this._sh.getHeader();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getHorizontallyCenter() {
        return this._sh.getHorizontallyCenter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<XSSFHyperlink> getHyperlinkList() {
        return this._sh.getHyperlinkList();
    }

    public int getLastFlushedRowNum() {
        return this.lastFlushedRowNumber;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getLastRowNum() {
        if (this._rows.isEmpty()) {
            return -1;
        }
        return this._rows.lastKey().intValue();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getLeftCol() {
        return this._sh.getLeftCol();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @Removal(version = "7.0.0")
    @Deprecated
    public double getMargin(short s6) {
        return this._sh.getMargin(s6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getMergedRegion(int i5) {
        return this._sh.getMergedRegion(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<CellRangeAddress> getMergedRegions() {
        return this._sh.getMergedRegions();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getNumMergedRegions() {
        return this._sh.getNumMergedRegions();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public PaneInformation getPaneInformation() {
        return this._sh.getPaneInformation();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getPhysicalNumberOfRows() {
        return this._writer.getNumberOfFlushedRows() + this._rows.size();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public PrintSetup getPrintSetup() {
        return this._sh.getPrintSetup();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getProtect() {
        return this._sh.getProtect();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getRepeatingColumns() {
        return this._sh.getRepeatingColumns();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getRepeatingRows() {
        return this._sh.getRepeatingRows();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int[] getRowBreaks() {
        return this._sh.getRowBreaks();
    }

    public int getRowNum(SXSSFRow sXSSFRow) {
        return sXSSFRow.getRowNum();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsBelow() {
        return this._sh.getRowSumsBelow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsRight() {
        return this._sh.getRowSumsRight();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getScenarioProtect() {
        return this._sh.getScenarioProtect();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public SheetConditionalFormatting getSheetConditionalFormatting() {
        return this._sh.getSheetConditionalFormatting();
    }

    @Internal
    public SheetDataWriter getSheetDataWriter() {
        return this._writer;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public String getSheetName() {
        return this._sh.getSheetName();
    }

    public XSSFColor getTabColor() {
        return this._sh.getTabColor();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getTopRow() {
        return this._sh.getTopRow();
    }

    public Set<Integer> getTrackedColumnsForAutoSizing() {
        AutoSizeColumnTracker autoSizeColumnTracker = this._autoSizeColumnTracker;
        return autoSizeColumnTracker == null ? Collections.EMPTY_SET : autoSizeColumnTracker.getTrackedColumns();
    }

    @Override // org.apache.poi.xssf.usermodel.OoxmlSheetExtensions
    public XSSFVMLDrawing getVMLDrawing(boolean z6) {
        XSSFSheet xSSFSheet = getWorkbook().getXSSFSheet(this);
        if (xSSFSheet == null) {
            return null;
        }
        return xSSFSheet.getVMLDrawing(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getVerticallyCenter() {
        return this._sh.getVerticallyCenter();
    }

    public InputStream getWorksheetXMLInputStream() {
        flushRows(0);
        this._writer.close();
        return this._writer.getWorksheetXMLInputStream();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupColumn(int i5, int i6) {
        this._sh.groupColumn(i5, i6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupRow(int i5, int i6) {
        for (SXSSFRow sXSSFRow : this._rows.subMap(Integer.valueOf(i5), Integer.valueOf(i6 + 1)).values()) {
            int outlineLevel = sXSSFRow.getOutlineLevel() + 1;
            sXSSFRow.setOutlineLevel(outlineLevel);
            if (outlineLevel > this.outlineLevelRow) {
                this.outlineLevelRow = outlineLevel;
            }
        }
        setWorksheetOutlineLevelRow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnBroken(int i5) {
        return this._sh.isColumnBroken(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnHidden(int i5) {
        return this._sh.isColumnHidden(i5);
    }

    public boolean isColumnTrackedForAutoSizing(int i5) {
        AutoSizeColumnTracker autoSizeColumnTracker = this._autoSizeColumnTracker;
        return autoSizeColumnTracker != null && autoSizeColumnTracker.isColumnTracked(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayFormulas() {
        return this._sh.isDisplayFormulas();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayGridlines() {
        return this._sh.isDisplayGridlines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayRowColHeadings() {
        return this._sh.isDisplayRowColHeadings();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayZeros() {
        return this._sh.isDisplayZeros();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isPrintGridlines() {
        return this._sh.isPrintGridlines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isPrintRowAndColumnHeadings() {
        return this._sh.isPrintRowAndColumnHeadings();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRightToLeft() {
        return this._sh.isRightToLeft();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRowBroken(int i5) {
        return this._sh.isRowBroken(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isSelected() {
        return this._sh.isSelected();
    }

    public boolean isSheetProtectionEnabled() {
        return this._sh.getCTWorksheet().isSetSheetProtection();
    }

    public void lockAutoFilter(boolean z6) {
        safeGetProtectionField().setAutoFilter(z6);
    }

    public void lockDeleteColumns(boolean z6) {
        safeGetProtectionField().setDeleteColumns(z6);
    }

    public void lockDeleteRows(boolean z6) {
        safeGetProtectionField().setDeleteRows(z6);
    }

    public void lockFormatCells(boolean z6) {
        safeGetProtectionField().setFormatCells(z6);
    }

    public void lockFormatColumns(boolean z6) {
        safeGetProtectionField().setFormatColumns(z6);
    }

    public void lockFormatRows(boolean z6) {
        safeGetProtectionField().setFormatRows(z6);
    }

    public void lockInsertColumns(boolean z6) {
        safeGetProtectionField().setInsertColumns(z6);
    }

    public void lockInsertHyperlinks(boolean z6) {
        safeGetProtectionField().setInsertHyperlinks(z6);
    }

    public void lockInsertRows(boolean z6) {
        safeGetProtectionField().setInsertRows(z6);
    }

    public void lockObjects(boolean z6) {
        safeGetProtectionField().setObjects(z6);
    }

    public void lockPivotTables(boolean z6) {
        safeGetProtectionField().setPivotTables(z6);
    }

    public void lockScenarios(boolean z6) {
        safeGetProtectionField().setScenarios(z6);
    }

    public void lockSelectLockedCells(boolean z6) {
        safeGetProtectionField().setSelectLockedCells(z6);
    }

    public void lockSelectUnlockedCells(boolean z6) {
        safeGetProtectionField().setSelectUnlockedCells(z6);
    }

    public void lockSort(boolean z6) {
        safeGetProtectionField().setSort(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void protectSheet(String str) {
        this._sh.protectSheet(str);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<? extends Cell> removeArrayFormula(Cell cell) {
        throw new RuntimeException("Not Implemented");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeColumnBreak(int i5) {
        this._sh.removeColumnBreak(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeMergedRegion(int i5) {
        this._sh.removeMergedRegion(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeMergedRegions(Collection<Integer> collection) {
        this._sh.removeMergedRegions(collection);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRow(Row row) {
        if (row.getSheet() != this) {
            throw new IllegalArgumentException("Specified row does not belong to this sheet");
        }
        Iterator<Map.Entry<Integer, SXSSFRow>> it = this._rows.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == row) {
                it.remove();
                return;
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRowBreak(int i5) {
        this._sh.removeRowBreak(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Iterator<Row> rowIterator() {
        return this._rows.values().iterator();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setActiveCell(CellAddress cellAddress) {
        this._sh.setActiveCell(cellAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<? extends Cell> setArrayFormula(String str, CellRangeAddress cellRangeAddress) {
        throw new RuntimeException("Not Implemented");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public AutoFilter setAutoFilter(CellRangeAddress cellRangeAddress) {
        return this._sh.setAutoFilter(cellRangeAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setAutobreaks(boolean z6) {
        this._sh.setAutobreaks(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnBreak(int i5) {
        this._sh.setColumnBreak(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnGroupCollapsed(int i5, boolean z6) {
        this._sh.setColumnGroupCollapsed(i5, z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnHidden(int i5, boolean z6) {
        this._sh.setColumnHidden(i5, z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnWidth(int i5, int i6) {
        this._sh.setColumnWidth(i5, i6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnStyle(int i5, CellStyle cellStyle) {
        this._sh.setDefaultColumnStyle(i5, cellStyle);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnWidth(int i5) {
        this._sh.setDefaultColumnWidth(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeight(short s6) {
        this._sh.setDefaultRowHeight(s6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeightInPoints(float f6) {
        this._sh.setDefaultRowHeightInPoints(f6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayFormulas(boolean z6) {
        this._sh.setDisplayFormulas(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGridlines(boolean z6) {
        this._sh.setDisplayGridlines(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGuts(boolean z6) {
        this._sh.setDisplayGuts(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayRowColHeadings(boolean z6) {
        this._sh.setDisplayRowColHeadings(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayZeros(boolean z6) {
        this._sh.setDisplayZeros(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setFitToPage(boolean z6) {
        this._sh.setFitToPage(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setForceFormulaRecalculation(boolean z6) {
        this._sh.setForceFormulaRecalculation(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setHorizontallyCenter(boolean z6) {
        this._sh.setHorizontallyCenter(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @Removal(version = "7.0.0")
    @Deprecated
    public void setMargin(short s6, double d) {
        this._sh.setMargin(s6, d);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setPrintGridlines(boolean z6) {
        this._sh.setPrintGridlines(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setPrintRowAndColumnHeadings(boolean z6) {
        this._sh.setPrintRowAndColumnHeadings(z6);
    }

    public void setRandomAccessWindowSize(int i5) {
        if (i5 == 0 || i5 < -1) {
            throw new IllegalArgumentException("RandomAccessWindowSize must be either -1 or a positive integer");
        }
        this._randomAccessWindowSize = i5;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRepeatingColumns(CellRangeAddress cellRangeAddress) {
        this._sh.setRepeatingColumns(cellRangeAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRepeatingRows(CellRangeAddress cellRangeAddress) {
        this._sh.setRepeatingRows(cellRangeAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRightToLeft(boolean z6) {
        this._sh.setRightToLeft(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowBreak(int i5) {
        this._sh.setRowBreak(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowGroupCollapsed(int i5, boolean z6) {
        if (!z6) {
            throw new RuntimeException("Unable to expand row: Not Implemented");
        }
        collapseRow(i5);
    }

    public void setRowOutlineLevel(int i5, int i6) {
        this._rows.get(Integer.valueOf(i5)).setOutlineLevel(i6);
        if (i6 <= 0 || i6 <= this.outlineLevelRow) {
            return;
        }
        this.outlineLevelRow = i6;
        setWorksheetOutlineLevelRow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsBelow(boolean z6) {
        this._sh.setRowSumsBelow(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsRight(boolean z6) {
        this._sh.setRowSumsRight(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setSelected(boolean z6) {
        this._sh.setSelected(z6);
    }

    public void setTabColor(XSSFColor xSSFColor) {
        this._sh.setTabColor(xSSFColor);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setVerticallyCenter(boolean z6) {
        this._sh.setVerticallyCenter(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setZoom(int i5) {
        this._sh.setZoom(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @NotImplemented
    public void shiftColumns(int i5, int i6, int i7) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @NotImplemented
    public void shiftRows(int i5, int i6, int i7) {
        throw new RuntimeException("Not Implemented");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void showInPane(int i5, int i6) {
        this._sh.showInPane(i5, i6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet, java.lang.Iterable
    public Spliterator<Row> spliterator() {
        return this._rows.values().spliterator();
    }

    public void trackAllColumnsForAutoSizing() {
        AutoSizeColumnTracker autoSizeColumnTracker = this._autoSizeColumnTracker;
        if (autoSizeColumnTracker == null) {
            throw new IllegalStateException("Cannot trackColumnForAutoSizing because autoSizeColumnTracker failed to initialize (possibly due to fonts not being installed in your OS)");
        }
        autoSizeColumnTracker.trackAllColumns();
    }

    public void trackColumnForAutoSizing(int i5) {
        AutoSizeColumnTracker autoSizeColumnTracker = this._autoSizeColumnTracker;
        if (autoSizeColumnTracker == null) {
            throw new IllegalStateException("Cannot trackColumnForAutoSizing because autoSizeColumnTracker failed to initialize (possibly due to fonts not being installed in your OS)");
        }
        autoSizeColumnTracker.trackColumn(i5);
    }

    public void trackColumnsForAutoSizing(Collection<Integer> collection) {
        AutoSizeColumnTracker autoSizeColumnTracker = this._autoSizeColumnTracker;
        if (autoSizeColumnTracker == null) {
            throw new IllegalStateException("Cannot trackColumnForAutoSizing because autoSizeColumnTracker failed to initialize (possibly due to fonts not being installed in your OS)");
        }
        autoSizeColumnTracker.trackColumns(collection);
    }

    public void trackNewCell(SXSSFCell sXSSFCell) {
        this.leftMostColumn = Math.min(sXSSFCell.getColumnIndex(), this.leftMostColumn);
        this.rightMostColumn = Math.max(sXSSFCell.getColumnIndex(), this.rightMostColumn);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupColumn(int i5, int i6) {
        this._sh.ungroupColumn(i5, i6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupRow(int i5, int i6) {
        this._sh.ungroupRow(i5, i6);
    }

    public void untrackAllColumnsForAutoSizing() {
        AutoSizeColumnTracker autoSizeColumnTracker = this._autoSizeColumnTracker;
        if (autoSizeColumnTracker != null) {
            autoSizeColumnTracker.untrackAllColumns();
        }
    }

    public boolean untrackColumnForAutoSizing(int i5) {
        AutoSizeColumnTracker autoSizeColumnTracker = this._autoSizeColumnTracker;
        return autoSizeColumnTracker != null && autoSizeColumnTracker.untrackColumn(i5);
    }

    public boolean untrackColumnsForAutoSizing(Collection<Integer> collection) {
        AutoSizeColumnTracker autoSizeColumnTracker = this._autoSizeColumnTracker;
        return autoSizeColumnTracker != null && autoSizeColumnTracker.untrackColumns(collection);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void validateMergedRegions() {
        this._sh.validateMergedRegions();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void autoSizeColumn(int i5, boolean z6) {
        AutoSizeColumnTracker autoSizeColumnTracker = this._autoSizeColumnTracker;
        if (autoSizeColumnTracker == null) {
            throw new IllegalStateException("Cannot trackColumnForAutoSizing because autoSizeColumnTracker failed to initialize (possibly due to fonts not being installed in your OS)");
        }
        try {
            int iMax = Math.max(autoSizeColumnTracker.getBestFitColumnWidth(i5, z6), (int) (SheetUtil.getColumnWidth(this, i5, z6) * 256.0d));
            if (iMax > 0) {
                setColumnWidth(i5, Math.min(iMax, MotionEventCompat.ACTION_POINTER_INDEX_MASK));
            }
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Could not auto-size column. Make sure the column was tracked prior to auto-sizing the column.", e);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public SXSSFDrawing createDrawingPatriarch() {
        return new SXSSFDrawing(getWorkbook(), this._sh.createDrawingPatriarch());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i5, int i6) {
        this._sh.createFreezePane(i5, i6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public SXSSFRow createRow(int i5) {
        int lastRowIndex = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
        if (i5 < 0 || i5 > lastRowIndex) {
            throw new IllegalArgumentException(a.m("Invalid row number (", i5, lastRowIndex, ") outside allowable range (0..", ")"));
        }
        SheetDataWriter sheetDataWriter = this._writer;
        if (sheetDataWriter != null && i5 <= sheetDataWriter.getLastFlushedRow()) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Attempting to write a row[", "] in the range [0,");
            sbT.append(this._writer.getLastFlushedRow());
            sbT.append("] that is already written to disk.");
            throw new IllegalArgumentException(sbT.toString());
        }
        if (this._sh.getPhysicalNumberOfRows() > 0 && i5 <= this._sh.getLastRowNum()) {
            StringBuilder sbT2 = AbstractC0157z.t(i5, "Attempting to write a row[", "] in the range [0,");
            sbT2.append(this._sh.getLastRowNum());
            sbT2.append("] that is already written to disk.");
            throw new IllegalArgumentException(sbT2.toString());
        }
        SXSSFRow sXSSFRow = new SXSSFRow(this);
        sXSSFRow.setRowNumWithoutUpdatingSheet(i5);
        this._rows.put(Integer.valueOf(i5), sXSSFRow);
        this.allFlushed = false;
        if (this._randomAccessWindowSize >= 0) {
            int size = this._rows.size();
            int i6 = this._randomAccessWindowSize;
            if (size > i6) {
                try {
                    flushRows(i6);
                    return sXSSFRow;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return sXSSFRow;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createSplitPane(int i5, int i6, int i7, int i8, PaneType paneType) {
        this._sh.createSplitPane(i5, i6, i7, i8, paneType);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFComment getCellComment(CellAddress cellAddress) {
        return this._sh.getCellComment(cellAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFDrawing getDrawingPatriarch() {
        return this._sh.getDrawingPatriarch();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public double getMargin(PageMargin pageMargin) {
        return this._sh.getMargin(pageMargin);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public SXSSFRow getRow(int i5) {
        return this._rows.get(Integer.valueOf(i5));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public SXSSFWorkbook getWorkbook() {
        return this._workbook;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setMargin(PageMargin pageMargin, double d) {
        this._sh.setMargin(pageMargin, d);
    }

    public void setTabColor(int i5) {
        CTWorksheet cTWorksheet = this._sh.getCTWorksheet();
        CTSheetPr sheetPr = cTWorksheet.getSheetPr();
        if (sheetPr == null) {
            sheetPr = cTWorksheet.addNewSheetPr();
        }
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(i5);
        sheetPr.setTabColor(cTColorNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @NotImplemented
    public void shiftRows(int i5, int i6, int i7, boolean z6, boolean z7) {
        throw new RuntimeException("Not Implemented");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFHyperlink getHyperlink(int i5, int i6) {
        return this._sh.getHyperlink(i5, i6);
    }

    public void flushRows() {
        flushRows(0);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFHyperlink getHyperlink(CellAddress cellAddress) {
        return this._sh.getHyperlink(cellAddress);
    }

    public SXSSFSheet(SXSSFWorkbook sXSSFWorkbook, XSSFSheet xSSFSheet) {
        this._workbook = sXSSFWorkbook;
        this._sh = xSSFSheet;
        this._writer = sXSSFWorkbook.createSheetDataWriter();
        setRandomAccessWindowSize(sXSSFWorkbook.getRandomAccessWindowSize());
        try {
            this._autoSizeColumnTracker = new AutoSizeColumnTracker(this);
        } catch (Exception e) {
            LOG.atWarn().log("Failed to create AutoSizeColumnTracker, possibly due to fonts not being installed in your OS", e);
        }
    }
}
