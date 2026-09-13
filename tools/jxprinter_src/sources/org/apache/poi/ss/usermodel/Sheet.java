package org.apache.poi.ss.usermodel;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Sheet extends Iterable<Row> {
    public static final short BottomMargin = 3;
    public static final short FooterMargin = 5;
    public static final short HeaderMargin = 4;
    public static final short LeftMargin = 0;
    public static final byte PANE_LOWER_LEFT = 2;
    public static final byte PANE_LOWER_RIGHT = 0;
    public static final byte PANE_UPPER_LEFT = 3;
    public static final byte PANE_UPPER_RIGHT = 1;
    public static final short RightMargin = 1;
    public static final short TopMargin = 2;

    int addMergedRegion(CellRangeAddress cellRangeAddress);

    int addMergedRegionUnsafe(CellRangeAddress cellRangeAddress);

    void addValidationData(DataValidation dataValidation);

    void autoSizeColumn(int i5);

    void autoSizeColumn(int i5, boolean z6);

    Drawing<?> createDrawingPatriarch();

    void createFreezePane(int i5, int i6);

    void createFreezePane(int i5, int i6, int i7, int i8);

    Row createRow(int i5);

    @Removal(version = "7.0.0")
    @Deprecated
    void createSplitPane(int i5, int i6, int i7, int i8, int i9);

    void createSplitPane(int i5, int i6, int i7, int i8, PaneType paneType);

    CellAddress getActiveCell();

    boolean getAutobreaks();

    Comment getCellComment(CellAddress cellAddress);

    Map<CellAddress, ? extends Comment> getCellComments();

    int[] getColumnBreaks();

    int getColumnOutlineLevel(int i5);

    CellStyle getColumnStyle(int i5);

    int getColumnWidth(int i5);

    float getColumnWidthInPixels(int i5);

    DataValidationHelper getDataValidationHelper();

    List<? extends DataValidation> getDataValidations();

    int getDefaultColumnWidth();

    short getDefaultRowHeight();

    float getDefaultRowHeightInPoints();

    boolean getDisplayGuts();

    Drawing<?> getDrawingPatriarch();

    int getFirstRowNum();

    boolean getFitToPage();

    Footer getFooter();

    boolean getForceFormulaRecalculation();

    Header getHeader();

    boolean getHorizontallyCenter();

    Hyperlink getHyperlink(int i5, int i6);

    Hyperlink getHyperlink(CellAddress cellAddress);

    List<? extends Hyperlink> getHyperlinkList();

    int getLastRowNum();

    short getLeftCol();

    double getMargin(PageMargin pageMargin);

    @Removal(version = "7.0.0")
    @Deprecated
    double getMargin(short s6);

    CellRangeAddress getMergedRegion(int i5);

    List<CellRangeAddress> getMergedRegions();

    int getNumMergedRegions();

    PaneInformation getPaneInformation();

    int getPhysicalNumberOfRows();

    PrintSetup getPrintSetup();

    boolean getProtect();

    CellRangeAddress getRepeatingColumns();

    CellRangeAddress getRepeatingRows();

    Row getRow(int i5);

    int[] getRowBreaks();

    boolean getRowSumsBelow();

    boolean getRowSumsRight();

    boolean getScenarioProtect();

    SheetConditionalFormatting getSheetConditionalFormatting();

    String getSheetName();

    short getTopRow();

    boolean getVerticallyCenter();

    Workbook getWorkbook();

    void groupColumn(int i5, int i6);

    void groupRow(int i5, int i6);

    boolean isColumnBroken(int i5);

    boolean isColumnHidden(int i5);

    boolean isDisplayFormulas();

    boolean isDisplayGridlines();

    boolean isDisplayRowColHeadings();

    boolean isDisplayZeros();

    boolean isPrintGridlines();

    boolean isPrintRowAndColumnHeadings();

    boolean isRightToLeft();

    boolean isRowBroken(int i5);

    boolean isSelected();

    @Override // java.lang.Iterable
    default Iterator<Row> iterator() {
        return rowIterator();
    }

    void protectSheet(String str);

    CellRange<? extends Cell> removeArrayFormula(Cell cell);

    void removeColumnBreak(int i5);

    void removeMergedRegion(int i5);

    void removeMergedRegions(Collection<Integer> collection);

    void removeRow(Row row);

    void removeRowBreak(int i5);

    Iterator<Row> rowIterator();

    void setActiveCell(CellAddress cellAddress);

    CellRange<? extends Cell> setArrayFormula(String str, CellRangeAddress cellRangeAddress);

    AutoFilter setAutoFilter(CellRangeAddress cellRangeAddress);

    void setAutobreaks(boolean z6);

    void setColumnBreak(int i5);

    void setColumnGroupCollapsed(int i5, boolean z6);

    void setColumnHidden(int i5, boolean z6);

    void setColumnWidth(int i5, int i6);

    void setDefaultColumnStyle(int i5, CellStyle cellStyle);

    void setDefaultColumnWidth(int i5);

    void setDefaultRowHeight(short s6);

    void setDefaultRowHeightInPoints(float f6);

    void setDisplayFormulas(boolean z6);

    void setDisplayGridlines(boolean z6);

    void setDisplayGuts(boolean z6);

    void setDisplayRowColHeadings(boolean z6);

    void setDisplayZeros(boolean z6);

    void setFitToPage(boolean z6);

    void setForceFormulaRecalculation(boolean z6);

    void setHorizontallyCenter(boolean z6);

    void setMargin(PageMargin pageMargin, double d);

    @Removal(version = "7.0.0")
    @Deprecated
    void setMargin(short s6, double d);

    void setPrintGridlines(boolean z6);

    void setPrintRowAndColumnHeadings(boolean z6);

    void setRepeatingColumns(CellRangeAddress cellRangeAddress);

    void setRepeatingRows(CellRangeAddress cellRangeAddress);

    void setRightToLeft(boolean z6);

    void setRowBreak(int i5);

    void setRowGroupCollapsed(int i5, boolean z6);

    void setRowSumsBelow(boolean z6);

    void setRowSumsRight(boolean z6);

    void setSelected(boolean z6);

    void setVerticallyCenter(boolean z6);

    void setZoom(int i5);

    void shiftColumns(int i5, int i6, int i7);

    void shiftRows(int i5, int i6, int i7);

    void shiftRows(int i5, int i6, int i7, boolean z6, boolean z7);

    void showInPane(int i5, int i6);

    @Override // java.lang.Iterable
    default Spliterator<Row> spliterator() {
        return Spliterators.spliterator(rowIterator(), getPhysicalNumberOfRows(), 0);
    }

    void ungroupColumn(int i5, int i6);

    void ungroupRow(int i5, int i6);

    void validateMergedRegions();
}
