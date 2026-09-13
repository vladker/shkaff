package org.apache.poi.xssf.usermodel;

import A3.AbstractC0157z;
import androidx.core.view.MotionEventCompat;
import com.alibaba.android.arouter.utils.Consts;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.TreeMap;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.PartAlreadyExistsException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.openxml4j.opc.g;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IgnoredErrorType;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PageMargin;
import org.apache.poi.ss.usermodel.PaneType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.poi.ss.util.SSCellRange;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.model.Comments;
import org.apache.poi.xssf.usermodel.helpers.ColumnHelper;
import org.apache.poi.xssf.usermodel.helpers.XSSFColumnShifter;
import org.apache.poi.xssf.usermodel.helpers.XSSFIgnoredErrorHelper;
import org.apache.poi.xssf.usermodel.helpers.XSSFPasswordHelper;
import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidations;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetDimension;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTablePart;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheetSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCalcMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPaneState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFSheet extends POIXMLDocumentPart implements Sheet, OoxmlSheetExtensions {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final double DEFAULT_MARGIN_BOTTOM = 0.75d;
    private static final double DEFAULT_MARGIN_FOOTER = 0.3d;
    private static final double DEFAULT_MARGIN_HEADER = 0.3d;
    private static final double DEFAULT_MARGIN_LEFT = 0.7d;
    private static final double DEFAULT_MARGIN_RIGHT = 0.7d;
    private static final double DEFAULT_MARGIN_TOP = 0.75d;
    private static final double DEFAULT_ROW_HEIGHT = 15.0d;
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSSFSheet.class);
    private final SortedMap<Integer, XSSFRow> _rows;
    private List<CellRangeAddress> arrayFormulas;
    private ColumnHelper columnHelper;
    private final XSSFDataValidationHelper dataValidationHelper;
    private CellRangeAddress dimensionOverride;
    private List<XSSFHyperlink> hyperlinks;
    private Map<Integer, CTCellFormula> sharedFormulas;
    protected CTSheet sheet;
    private Comments sheetComments;
    private SortedMap<String, XSSFTable> tables;
    protected CTWorksheet worksheet;
    private XSSFVMLDrawing xssfvmlDrawing;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFSheet$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$PageMargin;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$PaneType;

        static {
            int[] iArr = new int[PageMargin.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$PageMargin = iArr;
            try {
                iArr[PageMargin.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PageMargin[PageMargin.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PageMargin[PageMargin.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PageMargin[PageMargin.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PageMargin[PageMargin.HEADER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PageMargin[PageMargin.FOOTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[PaneType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$PaneType = iArr2;
            try {
                iArr2[PaneType.LOWER_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PaneType[PaneType.UPPER_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PaneType[PaneType.LOWER_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PaneType[PaneType.UPPER_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public XSSFSheet() {
        this._rows = new TreeMap();
        this.dataValidationHelper = new XSSFDataValidationHelper(this);
        onDocumentCreate();
    }

    private void checkForIntersectingMergedRegions() {
        List<CellRangeAddress> mergedRegions = getMergedRegions();
        int size = mergedRegions.size();
        int i5 = 0;
        while (i5 < size) {
            CellRangeAddress cellRangeAddress = mergedRegions.get(i5);
            i5++;
            for (CellRangeAddress cellRangeAddress2 : mergedRegions.subList(i5, mergedRegions.size())) {
                if (cellRangeAddress.intersects(cellRangeAddress2)) {
                    throw new IllegalStateException("The range " + cellRangeAddress.formatAsString() + " intersects with another merged region " + cellRangeAddress2.formatAsString() + " in this sheet");
                }
            }
        }
    }

    private void checkForMergedRegionsIntersectingArrayFormulas() {
        Iterator<CellRangeAddress> it = getMergedRegions().iterator();
        while (it.hasNext()) {
            validateArrayFormulas(it.next());
        }
    }

    public static void cloneTables(XSSFSheet xSSFSheet) {
        String subtotalFormulaStartFromTotalsRowFunction;
        for (XSSFTable xSSFTable : xSSFSheet.getTables()) {
            XSSFTable xSSFTableCreateTable = xSSFTable.supportsAreaReference(xSSFTable.getArea()) ? xSSFSheet.createTable(xSSFTable.getArea()) : null;
            if (xSSFTableCreateTable != null) {
                xSSFTableCreateTable.updateHeaders();
                xSSFTableCreateTable.setStyleName(xSSFTable.getStyleName());
                XSSFTableStyleInfo xSSFTableStyleInfo = (XSSFTableStyleInfo) xSSFTable.getStyle();
                XSSFTableStyleInfo xSSFTableStyleInfo2 = (XSSFTableStyleInfo) xSSFTableCreateTable.getStyle();
                if (xSSFTableStyleInfo != null && xSSFTableStyleInfo2 != null) {
                    xSSFTableStyleInfo2.setShowColumnStripes(xSSFTableStyleInfo.isShowColumnStripes());
                    xSSFTableStyleInfo2.setShowRowStripes(xSSFTableStyleInfo.isShowRowStripes());
                    xSSFTableStyleInfo2.setFirstColumn(xSSFTableStyleInfo.isShowFirstColumn());
                    xSSFTableStyleInfo2.setLastColumn(xSSFTableStyleInfo.isShowLastColumn());
                }
                xSSFTableCreateTable.getCTTable().setAutoFilter(xSSFTable.getCTTable().getAutoFilter());
                int totalsRowCount = xSSFTable.getTotalsRowCount();
                if (totalsRowCount == 1) {
                    XSSFRow row = xSSFSheet.getRow(xSSFTableCreateTable.getEndCellReference().getRow());
                    if (xSSFTableCreateTable.getCTTable().getTableColumns() != null && !xSSFTableCreateTable.getCTTable().getTableColumns().getTableColumnList().isEmpty()) {
                        xSSFTableCreateTable.getCTTable().setTotalsRowCount(totalsRowCount);
                        for (int i5 = 0; i5 < xSSFTableCreateTable.getCTTable().getTableColumns().getTableColumnList().size(); i5++) {
                            CTTableColumn cTTableColumn = xSSFTable.getCTTable().getTableColumns().getTableColumnList().get(i5);
                            CTTableColumn cTTableColumn2 = xSSFTableCreateTable.getCTTable().getTableColumns().getTableColumnList().get(i5);
                            cTTableColumn2.setTotalsRowFunction(cTTableColumn.getTotalsRowFunction());
                            int iIntValue = cTTableColumn2.getTotalsRowFunction().intValue();
                            xSSFSheet.getWorkbook().setCellFormulaValidation(false);
                            if (iIntValue == 10) {
                                CTTableFormula totalsRowFormula = cTTableColumn.getTotalsRowFormula();
                                cTTableColumn2.setTotalsRowFormula(totalsRowFormula);
                                row.getCell(xSSFTableCreateTable.getStartCellReference().getCol() + i5).setCellFormula(totalsRowFormula.getStringValue());
                            } else if (iIntValue != 1 && (subtotalFormulaStartFromTotalsRowFunction = getSubtotalFormulaStartFromTotalsRowFunction(iIntValue)) != null) {
                                XSSFCell cell = row.getCell(xSSFTableCreateTable.getStartCellReference().getCol() + i5);
                                StringBuilder sbX = AbstractC0157z.x(subtotalFormulaStartFromTotalsRowFunction, ",");
                                sbX.append(xSSFTableCreateTable.getName());
                                sbX.append("[");
                                sbX.append(cTTableColumn2.getName());
                                sbX.append("])");
                                cell.setCellFormula(sbX.toString());
                            }
                        }
                    }
                }
                if (xSSFTableCreateTable.getCTTable().getTableColumns() != null && !xSSFTableCreateTable.getCTTable().getTableColumns().getTableColumnList().isEmpty()) {
                    xSSFTableCreateTable.getCTTable().setTotalsRowCount(totalsRowCount);
                    for (int i6 = 0; i6 < xSSFTableCreateTable.getCTTable().getTableColumns().getTableColumnList().size(); i6++) {
                        CTTableColumn cTTableColumn3 = xSSFTable.getCTTable().getTableColumns().getTableColumnList().get(i6);
                        CTTableColumn cTTableColumn4 = xSSFTableCreateTable.getCTTable().getTableColumns().getTableColumnList().get(i6);
                        if (cTTableColumn3.getCalculatedColumnFormula() != null) {
                            cTTableColumn4.setCalculatedColumnFormula(cTTableColumn3.getCalculatedColumnFormula());
                            CTTableFormula calculatedColumnFormula = cTTableColumn4.getCalculatedColumnFormula();
                            String strReplace = cTTableColumn3.getCalculatedColumnFormula().getStringValue().replace(xSSFTable.getName(), xSSFTableCreateTable.getName());
                            calculatedColumnFormula.setStringValue(strReplace);
                            int row2 = xSSFTableCreateTable.getEndCellReference().getRow() - xSSFTableCreateTable.getTotalsRowCount();
                            int col = xSSFTableCreateTable.getStartCellReference().getCol() + i6;
                            xSSFSheet.getWorkbook().setCellFormulaValidation(false);
                            for (int headerRowCount = xSSFTableCreateTable.getHeaderRowCount() + xSSFTableCreateTable.getStartCellReference().getRow(); headerRowCount <= row2; headerRowCount++) {
                                XSSFRow row3 = xSSFSheet.getRow(headerRowCount);
                                if (row3 == null) {
                                    row3 = xSSFSheet.createRow(headerRowCount);
                                }
                                row3.getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellFormula(strReplace);
                            }
                        }
                    }
                }
            }
            xSSFSheet.removeTable(xSSFTable);
        }
    }

    private void collapseColumn(int i5) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        int indexOfColumn = this.columnHelper.getIndexOfColumn(colsArray, this.columnHelper.getColumn(i5, false));
        if (indexOfColumn == -1) {
            return;
        }
        int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(indexOfColumn);
        setColumn(setGroupHidden(iFindStartOfColumnOutlineGroup, colsArray.getColArray(iFindStartOfColumnOutlineGroup).getOutlineLevel(), true) + 1, 0, null, null, Boolean.TRUE);
    }

    private void collapseRow(int i5) {
        XSSFRow row = getRow(i5);
        if (row != null) {
            int iWriteHidden = writeHidden(row, findStartOfRowOutlineGroup(i5), true);
            if (getRow(iWriteHidden) != null) {
                getRow(iWriteHidden).getCTRow().setCollapsed(true);
            } else {
                createRow(iWriteHidden).getCTRow().setCollapsed(true);
            }
        }
    }

    private boolean containsColumn(CTCol cTCol, int i5) {
        long j6 = i5;
        return cTCol.getMin() <= j6 && j6 <= cTCol.getMax();
    }

    private XSSFPivotTable createPivotTable() {
        XSSFWorkbook workbook = getWorkbook();
        List<XSSFPivotTable> pivotTables = workbook.getPivotTables();
        int size = getWorkbook().getPivotTables().size() + 1;
        XSSFPivotTable xSSFPivotTable = (XSSFPivotTable) createRelationship(XSSFRelation.PIVOT_TABLE, getWorkbook().getXssfFactory(), size);
        xSSFPivotTable.setParentSheet(this);
        pivotTables.add(xSSFPivotTable);
        XSSFWorkbook workbook2 = getWorkbook();
        XSSFRelation xSSFRelation = XSSFRelation.PIVOT_CACHE_DEFINITION;
        XSSFPivotCacheDefinition xSSFPivotCacheDefinition = (XSSFPivotCacheDefinition) workbook2.createRelationship(xSSFRelation, getWorkbook().getXssfFactory(), size);
        String relationId = workbook2.getRelationId(xSSFPivotCacheDefinition);
        xSSFPivotTable.getPackagePart().addRelationship(xSSFPivotCacheDefinition.getPackagePart().getPartName(), TargetMode.INTERNAL, xSSFRelation.getRelation());
        xSSFPivotTable.setPivotCacheDefinition(xSSFPivotCacheDefinition);
        xSSFPivotTable.setPivotCache(new XSSFPivotCache(workbook2.addPivotCache(relationId)));
        xSSFPivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().setId(xSSFPivotCacheDefinition.getRelationId((XSSFPivotCacheRecords) xSSFPivotCacheDefinition.createRelationship(XSSFRelation.PIVOT_CACHE_RECORDS, getWorkbook().getXssfFactory(), size)));
        workbook.setPivotTables(pivotTables);
        return xSSFPivotTable;
    }

    private CTOutlinePr ensureOutlinePr() {
        CTSheetPr sheetPr = this.worksheet.isSetSheetPr() ? this.worksheet.getSheetPr() : this.worksheet.addNewSheetPr();
        return sheetPr.isSetOutlinePr() ? sheetPr.getOutlinePr() : sheetPr.addNewOutlinePr();
    }

    private void expandColumn(int i5) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        CTCol column = this.columnHelper.getColumn(i5, false);
        int iFindColInfoIdx = column == null ? -1 : findColInfoIdx(Math.toIntExact(column.getMax()), this.columnHelper.getIndexOfColumn(colsArray, column));
        if (iFindColInfoIdx != -1 && isColumnGroupCollapsed(iFindColInfoIdx)) {
            int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(iFindColInfoIdx);
            CTCol[] colArray = colsArray.getColArray();
            CTCol cTCol = colArray[iFindEndOfColumnOutlineGroup];
            if (!isColumnGroupHiddenByParent(iFindColInfoIdx)) {
                short outlineLevel = cTCol.getOutlineLevel();
                boolean z6 = false;
                for (int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(iFindColInfoIdx); iFindStartOfColumnOutlineGroup <= iFindEndOfColumnOutlineGroup; iFindStartOfColumnOutlineGroup++) {
                    CTCol cTCol2 = colArray[iFindStartOfColumnOutlineGroup];
                    if (outlineLevel == cTCol2.getOutlineLevel()) {
                        cTCol2.unsetHidden();
                        if (z6) {
                            cTCol2.setCollapsed(true);
                            z6 = false;
                        }
                    } else {
                        z6 = true;
                    }
                }
            }
            int intExact = Math.toIntExact(cTCol.getMax() + 1);
            Boolean bool = Boolean.FALSE;
            setColumn(intExact, null, null, bool, bool);
        }
    }

    private void expandRow(int i5) {
        if (i5 == -1) {
            return;
        }
        XSSFRow row = getRow(i5);
        if (row.getCTRow().isSetHidden()) {
            int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i5);
            short outlineLevel = row.getCTRow().getOutlineLevel();
            if (!isRowGroupHiddenByParent(i5)) {
                for (int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i5); iFindStartOfRowOutlineGroup < iFindEndOfRowOutlineGroup; iFindStartOfRowOutlineGroup++) {
                    if (outlineLevel == getRow(iFindStartOfRowOutlineGroup).getCTRow().getOutlineLevel()) {
                        getRow(iFindStartOfRowOutlineGroup).getCTRow().unsetHidden();
                    } else if (!isRowGroupCollapsed(iFindStartOfRowOutlineGroup)) {
                        getRow(iFindStartOfRowOutlineGroup).getCTRow().unsetHidden();
                    }
                }
            }
            CTRow cTRow = getRow(iFindEndOfRowOutlineGroup).getCTRow();
            if (cTRow.getCollapsed()) {
                cTRow.unsetCollapsed();
            }
        }
    }

    private int findColInfoIdx(int i5, int i6) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "column parameter out of range: "));
        }
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "fromIdx parameter out of range: "));
        }
        CTCol[] colArray = colsArray.getColArray();
        for (int i7 = i6; i7 < colArray.length; i7++) {
            CTCol cTCol = colArray[i7];
            if (containsColumn(cTCol, i5)) {
                return i7;
            }
            if (cTCol.getMin() > i6) {
                return -1;
            }
        }
        return -1;
    }

    private int findEndOfColumnOutlineGroup(int i5) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        CTCol cTCol = colArray[i5];
        short outlineLevel = cTCol.getOutlineLevel();
        int length = colArray.length - 1;
        while (i5 < length) {
            int i6 = i5 + 1;
            CTCol cTCol2 = colArray[i6];
            if (!isAdjacentBefore(cTCol, cTCol2) || cTCol2.getOutlineLevel() < outlineLevel) {
                break;
            }
            i5 = i6;
            cTCol = cTCol2;
        }
        return i5;
    }

    private int findStartOfColumnOutlineGroup(int i5) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        CTCol cTCol = colArray[i5];
        short outlineLevel = cTCol.getOutlineLevel();
        while (i5 != 0) {
            CTCol cTCol2 = colArray[i5 - 1];
            if (!isAdjacentBefore(cTCol2, cTCol) || cTCol2.getOutlineLevel() < outlineLevel) {
                break;
            }
            i5--;
            cTCol = cTCol2;
        }
        return i5;
    }

    private int findStartOfRowOutlineGroup(int i5) {
        short outlineLevel = getRow(i5).getCTRow().getOutlineLevel();
        while (getRow(i5) != null) {
            if (getRow(i5).getCTRow().getOutlineLevel() < outlineLevel) {
                return i5 + 1;
            }
            i5--;
        }
        return i5;
    }

    private int[] getBreaks(CTPageBreak cTPageBreak) {
        CTBreak[] brkArray = cTPageBreak.getBrkArray();
        int[] iArr = new int[brkArray.length];
        for (int i5 = 0; i5 < brkArray.length; i5++) {
            iArr[i5] = Math.toIntExact(brkArray[i5].getId() - 1);
        }
        return iArr;
    }

    private CellRange<XSSFCell> getCellRange(CellRangeAddress cellRangeAddress) {
        int firstRow = cellRangeAddress.getFirstRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        int i5 = (lastRow - firstRow) + 1;
        int i6 = (lastColumn - firstColumn) + 1;
        ArrayList arrayList = new ArrayList(i5 * i6);
        for (int i7 = firstRow; i7 <= lastRow; i7++) {
            for (int i8 = firstColumn; i8 <= lastColumn; i8++) {
                XSSFRow row = getRow(i7);
                if (row == null) {
                    row = createRow(i7);
                }
                XSSFCell cell = row.getCell(i8);
                if (cell == null) {
                    cell = row.createCell(i8);
                }
                arrayList.add(cell);
            }
        }
        return SSCellRange.create(firstRow, firstColumn, i5, i6, arrayList, XSSFCell.class);
    }

    private CTSheetView getDefaultSheetView(boolean z6) {
        int iSizeOfSheetViewArray;
        CTSheetViews sheetTypeSheetViews = getSheetTypeSheetViews(z6);
        if (sheetTypeSheetViews == null || (iSizeOfSheetViewArray = sheetTypeSheetViews.sizeOfSheetViewArray()) == 0) {
            return null;
        }
        return sheetTypeSheetViews.getSheetViewArray(iSizeOfSheetViewArray - 1);
    }

    private short getMaxOutlineLevelCols() {
        int iMax = 0;
        for (CTCol cTCol : this.worksheet.getColsArray(0).getColArray()) {
            iMax = Math.max(iMax, (int) cTCol.getOutlineLevel());
        }
        return (short) iMax;
    }

    private short getMaxOutlineLevelRows() {
        Iterator<XSSFRow> it = this._rows.values().iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, (int) it.next().getCTRow().getOutlineLevel());
        }
        return (short) iMax;
    }

    private CTPane getPane(boolean z6) {
        CTSheetView defaultSheetView = getDefaultSheetView(z6);
        if (defaultSheetView == null) {
            return null;
        }
        return (defaultSheetView.isSetPane() || !z6) ? defaultSheetView.getPane() : defaultSheetView.addNewPane();
    }

    private static String getReferenceBuiltInRecord(String str, int i5, int i6, int i7, int i8) {
        String str2;
        CellReference cellReference = new CellReference(str, 0, i5, true, true);
        CellReference cellReference2 = new CellReference(str, 0, i6, true, true);
        CellReference cellReference3 = new CellReference(str, i7, 0, true, true);
        CellReference cellReference4 = new CellReference(str, i8, 0, true, true);
        String str3 = SheetNameFormatter.format(str);
        String str4 = "";
        if (i5 == -1 && i6 == -1) {
            str2 = "";
        } else {
            str2 = str3 + "!$" + cellReference.getCellRefParts()[2] + ":$" + cellReference2.getCellRefParts()[2];
        }
        if (i7 != -1 || i8 != -1) {
            String str5 = cellReference3.getCellRefParts()[1];
            String str6 = cellReference4.getCellRefParts()[1];
            if (!str5.equals("0") && !str6.equals("0")) {
                str4 = str3 + "!$" + str5 + ":$" + str6;
            }
        }
        StringBuilder sbR = androidx.collection.a.r(str2);
        if (sbR.length() > 0 && str4.length() > 0) {
            sbR.append(',');
        }
        sbR.append(str4);
        return sbR.toString();
    }

    private CellRangeAddress getRepeatingRowsOrColumns(boolean z6) {
        String refersToFormula;
        XSSFName builtInName = getWorkbook().getBuiltInName(XSSFName.BUILTIN_PRINT_TITLE, getWorkbook().getSheetIndex(this));
        if (builtInName == null || (refersToFormula = builtInName.getRefersToFormula()) == null) {
            return null;
        }
        String[] strArrSplit = refersToFormula.split(",");
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL2007;
        int lastRowIndex = spreadsheetVersion.getLastRowIndex();
        int lastColumnIndex = spreadsheetVersion.getLastColumnIndex();
        for (String str : strArrSplit) {
            CellRangeAddress cellRangeAddressValueOf = CellRangeAddress.valueOf(str);
            if ((cellRangeAddressValueOf.getFirstColumn() == 0 && cellRangeAddressValueOf.getLastColumn() == lastColumnIndex) || (cellRangeAddressValueOf.getFirstColumn() == -1 && cellRangeAddressValueOf.getLastColumn() == -1)) {
                if (z6) {
                    return cellRangeAddressValueOf;
                }
            } else {
                if (((cellRangeAddressValueOf.getFirstRow() == 0 && cellRangeAddressValueOf.getLastRow() == lastRowIndex) || (cellRangeAddressValueOf.getFirstRow() == -1 && cellRangeAddressValueOf.getLastRow() == -1)) && !z6) {
                    return cellRangeAddressValueOf;
                }
            }
        }
        return null;
    }

    private List<XSSFRow> getRows(int i5, int i6, boolean z6) {
        if (i5 > i6) {
            throw new IllegalArgumentException("getRows: startRowNum must be less than or equal to endRowNum");
        }
        ArrayList arrayList = new ArrayList();
        if (!z6) {
            arrayList.addAll(this._rows.subMap(Integer.valueOf(i5), Integer.valueOf(i6 + 1)).values());
            return arrayList;
        }
        while (i5 <= i6) {
            XSSFRow row = getRow(i5);
            if (row == null) {
                row = createRow(i5);
            }
            arrayList.add(row);
            i5++;
        }
        return arrayList;
    }

    private CTHeaderFooter getSheetTypeHeaderFooter() {
        if (this.worksheet.getHeaderFooter() == null) {
            this.worksheet.setHeaderFooter(CTHeaderFooter.Factory.newInstance());
        }
        return this.worksheet.getHeaderFooter();
    }

    private CTPageSetUpPr getSheetTypePageSetUpPr() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return sheetTypeSheetPr.isSetPageSetUpPr() ? sheetTypeSheetPr.getPageSetUpPr() : sheetTypeSheetPr.addNewPageSetUpPr();
    }

    private CTSelection getSheetTypeSelection(boolean z6) {
        CTSheetView defaultSheetView = getDefaultSheetView(z6);
        if (defaultSheetView == null) {
            return null;
        }
        int iSizeOfSelectionArray = defaultSheetView.sizeOfSelectionArray();
        if (iSizeOfSelectionArray != 0) {
            return defaultSheetView.getSelectionArray(iSizeOfSelectionArray - 1);
        }
        if (z6) {
            return defaultSheetView.addNewSelection();
        }
        return null;
    }

    private CTSheetFormatPr getSheetTypeSheetFormatPr() {
        return this.worksheet.isSetSheetFormatPr() ? this.worksheet.getSheetFormatPr() : this.worksheet.addNewSheetFormatPr();
    }

    private CTSheetPr getSheetTypeSheetPr() {
        if (this.worksheet.getSheetPr() == null) {
            this.worksheet.setSheetPr(CTSheetPr.Factory.newInstance());
        }
        return this.worksheet.getSheetPr();
    }

    private static String getSubtotalFormulaStartFromTotalsRowFunction(int i5) {
        switch (i5) {
            case 1:
                return null;
            case 2:
                return "SUBTOTAL(109";
            case 3:
                return "SUBTOTAL(105";
            case 4:
                return "SUBTOTAL(104";
            case 5:
                return "SUBTOTAL(101";
            case 6:
                return "SUBTOTAL(103";
            case 7:
                return "SUBTOTAL(102";
            case 8:
                return "SUBTOTAL(107";
            case 9:
                return "SUBTOTAL(110";
            case 10:
            default:
                return null;
        }
    }

    private void groupColumn1Based(int i5, int i6) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        CTCol cTColNewInstance = CTCol.Factory.newInstance();
        long j6 = i6;
        CTCol column1Based = this.columnHelper.getColumn1Based(j6, false);
        if (column1Based != null) {
            column1Based = (CTCol) column1Based.copy();
        }
        cTColNewInstance.setMin(i5);
        cTColNewInstance.setMax(j6);
        this.columnHelper.addCleanColIntoCols(colsArray, cTColNewInstance);
        CTCol column1Based2 = this.columnHelper.getColumn1Based(j6, false);
        if (column1Based != null && column1Based2 != null) {
            this.columnHelper.setColumnAttributes(column1Based, column1Based2);
        }
        while (i5 <= i6) {
            CTCol column1Based3 = this.columnHelper.getColumn1Based(i5, false);
            column1Based3.setOutlineLevel((short) (column1Based3.getOutlineLevel() + 1));
            i5 = Math.toIntExact(column1Based3.getMax()) + 1;
        }
        this.worksheet.setColsArray(0, colsArray);
        setSheetFormatPrOutlineLevelCol();
    }

    private void initHyperlinks() {
        this.hyperlinks = new ArrayList();
        if (this.worksheet.isSetHyperlinks()) {
            try {
                PackageRelationshipCollection relationshipsByType = getPackagePart().getRelationshipsByType(XSSFRelation.SHEET_HYPERLINKS.getRelation());
                for (CTHyperlink cTHyperlink : this.worksheet.getHyperlinks().getHyperlinkArray()) {
                    this.hyperlinks.add(new XSSFHyperlink(cTHyperlink, cTHyperlink.getId() != null ? relationshipsByType.getRelationshipByID(cTHyperlink.getId()) : null));
                }
            } catch (InvalidFormatException e) {
                throw new POIXMLException(e);
            }
        }
    }

    private void initRows(CTWorksheet cTWorksheet) {
        if (cTWorksheet.getSheetData() == null || cTWorksheet.getSheetData().getRowArray() == null) {
            throw new IllegalArgumentException("Had empty sheet data when initializing the sheet");
        }
        this._rows.clear();
        this.tables = new TreeMap();
        this.sharedFormulas = new HashMap();
        this.arrayFormulas = new ArrayList();
        for (CTRow cTRow : cTWorksheet.getSheetData().getRowArray()) {
            XSSFRow xSSFRow = new XSSFRow(cTRow, this);
            this._rows.put(Integer.valueOf(xSSFRow.getRowNum()), xSSFRow);
        }
    }

    private boolean isAdjacentBefore(CTCol cTCol, CTCol cTCol2) {
        return cTCol.getMax() == cTCol2.getMin() - 1;
    }

    private boolean isColumnGroupCollapsed(int i5) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(i5);
        int i6 = iFindEndOfColumnOutlineGroup + 1;
        if (i6 >= colArray.length) {
            return false;
        }
        CTCol cTCol = colArray[i6];
        if (isAdjacentBefore(colArray[iFindEndOfColumnOutlineGroup], cTCol)) {
            return cTCol.getCollapsed();
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0046  */
    /* JADX WARN: Code duplicated, block: B:7:0x0029  */
    private boolean isColumnGroupHiddenByParent(int i5) {
        short outlineLevel;
        boolean hidden;
        boolean hidden2;
        short outlineLevel2 = 0;
        CTCols colsArray = this.worksheet.getColsArray(0);
        int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(i5);
        CTCol[] colArray = colsArray.getColArray();
        if (iFindEndOfColumnOutlineGroup < colArray.length - 1) {
            CTCol cTCol = colArray[iFindEndOfColumnOutlineGroup + 1];
            if (isAdjacentBefore(colArray[iFindEndOfColumnOutlineGroup], cTCol)) {
                outlineLevel = cTCol.getOutlineLevel();
                hidden = cTCol.getHidden();
            } else {
                outlineLevel = 0;
                hidden = false;
            }
        } else {
            outlineLevel = 0;
            hidden = false;
        }
        int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(i5);
        if (iFindStartOfColumnOutlineGroup > 0) {
            CTCol cTCol2 = colArray[iFindStartOfColumnOutlineGroup - 1];
            if (isAdjacentBefore(cTCol2, colArray[iFindStartOfColumnOutlineGroup])) {
                outlineLevel2 = cTCol2.getOutlineLevel();
                hidden2 = cTCol2.getHidden();
            } else {
                hidden2 = false;
            }
        } else {
            hidden2 = false;
        }
        return outlineLevel > outlineLevel2 ? hidden : hidden2;
    }

    private boolean isRowGroupCollapsed(int i5) {
        int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i5) + 1;
        if (getRow(iFindEndOfRowOutlineGroup) == null) {
            return false;
        }
        return getRow(iFindEndOfRowOutlineGroup).getCTRow().getCollapsed();
    }

    private boolean isRowGroupHiddenByParent(int i5) {
        short outlineLevel;
        boolean hidden;
        boolean hidden2;
        int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i5);
        short outlineLevel2 = 0;
        if (getRow(iFindEndOfRowOutlineGroup) == null) {
            hidden = false;
            outlineLevel = 0;
        } else {
            outlineLevel = getRow(iFindEndOfRowOutlineGroup).getCTRow().getOutlineLevel();
            hidden = getRow(iFindEndOfRowOutlineGroup).getCTRow().getHidden();
        }
        int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i5);
        if (iFindStartOfRowOutlineGroup < 0 || getRow(iFindStartOfRowOutlineGroup) == null) {
            hidden2 = false;
        } else {
            outlineLevel2 = getRow(iFindStartOfRowOutlineGroup).getCTRow().getOutlineLevel();
            hidden2 = getRow(iFindStartOfRowOutlineGroup).getCTRow().getHidden();
        }
        return outlineLevel > outlineLevel2 ? hidden : hidden2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createPivotTable$2(AreaReference areaReference, CTWorksheetSource cTWorksheetSource) {
        String[] cellRefParts = areaReference.getFirstCell().getCellRefParts();
        String str = cellRefParts[1];
        String str2 = cellRefParts[2];
        String[] cellRefParts2 = areaReference.getLastCell().getCellRefParts();
        String str3 = cellRefParts2[1];
        cTWorksheetSource.setRef(str2 + str + NameUtil.COLON + cellRefParts2[2] + str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createPivotTable$3(Name name, CTWorksheetSource cTWorksheetSource) {
        cTWorksheetSource.setName(name.getNameName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createPivotTable$4(Table table, CTWorksheetSource cTWorksheetSource) {
        cTWorksheetSource.setName(table.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$shiftCommentsAndRows$0(int i5, XSSFComment xSSFComment, XSSFComment xSSFComment2) {
        int row = xSSFComment.getRow();
        int row2 = xSSFComment2.getRow();
        if (row == row2) {
            return xSSFComment.hashCode() - xSSFComment2.hashCode();
        }
        if (i5 > 0) {
            return row < row2 ? 1 : -1;
        }
        return row > row2 ? 1 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$shiftCommentsForColumns$1(int i5, XSSFComment xSSFComment, XSSFComment xSSFComment2) {
        int column = xSSFComment.getColumn();
        int column2 = xSSFComment2.getColumn();
        if (column == column2) {
            return xSSFComment.hashCode() - xSSFComment2.hashCode();
        }
        if (i5 > 0) {
            return column < column2 ? 1 : -1;
        }
        return column > column2 ? 1 : -1;
    }

    private static CTWorksheet newSheet() {
        CTWorksheet cTWorksheetNewInstance = CTWorksheet.Factory.newInstance();
        cTWorksheetNewInstance.addNewSheetFormatPr().setDefaultRowHeight(DEFAULT_ROW_HEIGHT);
        cTWorksheetNewInstance.addNewSheetViews().addNewSheetView().setWorkbookViewId(0L);
        cTWorksheetNewInstance.addNewDimension().setRef("A1");
        cTWorksheetNewInstance.addNewSheetData();
        CTPageMargins cTPageMarginsAddNewPageMargins = cTWorksheetNewInstance.addNewPageMargins();
        cTPageMarginsAddNewPageMargins.setBottom(0.75d);
        cTPageMarginsAddNewPageMargins.setFooter(0.3d);
        cTPageMarginsAddNewPageMargins.setHeader(0.3d);
        cTPageMarginsAddNewPageMargins.setLeft(0.7d);
        cTPageMarginsAddNewPageMargins.setRight(0.7d);
        cTPageMarginsAddNewPageMargins.setTop(0.75d);
        return cTWorksheetNewInstance;
    }

    private void rebuildRows() {
        TreeMap treeMap = new TreeMap();
        CTSheetData sheetData = getCTWorksheet().getSheetData();
        for (CTRow cTRow : sheetData.getRowList()) {
            treeMap.put(Long.valueOf(cTRow.getR()), cTRow);
        }
        ArrayList arrayList = new ArrayList(treeMap.values());
        sheetData.setRowArray((CTRow[]) arrayList.toArray(new CTRow[arrayList.size()]));
        this._rows.clear();
        Iterator<CTRow> it = sheetData.getRowList().iterator();
        while (it.hasNext()) {
            XSSFRow xSSFRow = new XSSFRow(it.next(), this);
            this._rows.put(Integer.valueOf(Math.toIntExact(xSSFRow.getRowNum())), xSSFRow);
        }
    }

    private void rebuildTableFormulas(XSSFTable xSSFTable) {
        for (CTTableColumn cTTableColumn : xSSFTable.getCTTable().getTableColumns().getTableColumnList()) {
            if (cTTableColumn.getCalculatedColumnFormula() != null) {
                int intExact = Math.toIntExact(cTTableColumn.getId());
                String stringValue = cTTableColumn.getCalculatedColumnFormula().getStringValue();
                int row = xSSFTable.getEndCellReference().getRow() - xSSFTable.getTotalsRowCount();
                int col = (xSSFTable.getStartCellReference().getCol() + intExact) - 1;
                boolean cellFormulaValidation = getWorkbook().getCellFormulaValidation();
                try {
                    getWorkbook().setCellFormulaValidation(false);
                    for (int headerRowCount = xSSFTable.getHeaderRowCount() + xSSFTable.getStartCellReference().getRow(); headerRowCount <= row; headerRowCount++) {
                        XSSFRow row2 = getRow(headerRowCount);
                        if (row2 == null) {
                            row2 = createRow(headerRowCount);
                        }
                        row2.getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellFormula(stringValue);
                    }
                    getWorkbook().setCellFormulaValidation(cellFormulaValidation);
                } catch (Throwable th) {
                    getWorkbook().setCellFormulaValidation(cellFormulaValidation);
                    throw th;
                }
            }
        }
    }

    private void removeBreak(int i5, CTPageBreak cTPageBreak) {
        int i6 = i5 + 1;
        CTBreak[] brkArray = cTPageBreak.getBrkArray();
        for (int i7 = 0; i7 < brkArray.length; i7++) {
            if (brkArray[i7].getId() == i6) {
                cTPageBreak.removeBrk(i7);
            }
        }
    }

    private void removeOverwritten(int i5, int i6, int i7) {
        int i8 = 0;
        XSSFVMLDrawing vMLDrawing = getVMLDrawing(false);
        HashSet hashSet = new HashSet();
        Iterator<Row> itRowIterator = rowIterator();
        while (itRowIterator.hasNext()) {
            XSSFRow xSSFRow = (XSSFRow) itRowIterator.next();
            int rowNum = xSSFRow.getRowNum();
            if (shouldRemoveRow(i5, i6, i7, rowNum)) {
                hashSet.add(Integer.valueOf(rowNum));
                for (Cell cell : xSSFRow) {
                    if (!cell.isPartOfArrayFormulaGroup()) {
                        cell.setBlank();
                    }
                }
                this.worksheet.getSheetData().removeRow(this._rows.headMap(Integer.valueOf(xSSFRow.getRowNum())).size());
                itRowIterator.remove();
            }
        }
        if (this.sheetComments != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<CellAddress> cellAddresses = this.sheetComments.getCellAddresses();
            while (cellAddresses.hasNext()) {
                CellAddress next = cellAddresses.next();
                if (hashSet.contains(Integer.valueOf(next.getRow()))) {
                    arrayList.add(next);
                }
            }
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                CellAddress cellAddress = (CellAddress) obj;
                this.sheetComments.removeComment(cellAddress);
                if (vMLDrawing != null) {
                    vMLDrawing.removeCommentShape(cellAddress.getRow(), cellAddress.getColumn());
                }
            }
        }
        if (this.hyperlinks != null) {
            ArrayList arrayList2 = new ArrayList(this.hyperlinks);
            int size2 = arrayList2.size();
            while (i8 < size2) {
                Object obj2 = arrayList2.get(i8);
                i8++;
                XSSFHyperlink xSSFHyperlink = (XSSFHyperlink) obj2;
                CellRangeAddress cellRangeAddressValueOf = CellRangeAddress.valueOf(xSSFHyperlink.getCellRef());
                if (cellRangeAddressValueOf.getFirstRow() == cellRangeAddressValueOf.getLastRow() && hashSet.contains(Integer.valueOf(cellRangeAddressValueOf.getFirstRow()))) {
                    removeHyperlink(xSSFHyperlink);
                } else if (cellRangeAddressValueOf.getFirstRow() != cellRangeAddressValueOf.getLastRow()) {
                    boolean zContains = true;
                    for (int firstRow = cellRangeAddressValueOf.getFirstRow(); firstRow <= cellRangeAddressValueOf.getLastRow() && zContains; firstRow++) {
                        zContains = hashSet.contains(Integer.valueOf(firstRow));
                    }
                    if (zContains) {
                        removeHyperlink(xSSFHyperlink);
                    }
                }
            }
        }
    }

    private CTSheetProtection safeGetProtectionField() {
        return !isSheetProtectionEnabled() ? this.worksheet.addNewSheetProtection() : this.worksheet.getSheetProtection();
    }

    private void setBreak(int i5, CTPageBreak cTPageBreak, int i6) {
        CTBreak cTBreakAddNewBrk = cTPageBreak.addNewBrk();
        cTBreakAddNewBrk.setId(((long) i5) + 1);
        cTBreakAddNewBrk.setMan(true);
        cTBreakAddNewBrk.setMax(i6);
        long jSizeOfBrkArray = cTPageBreak.sizeOfBrkArray();
        cTPageBreak.setCount(jSizeOfBrkArray);
        cTPageBreak.setManualBreakCount(jSizeOfBrkArray);
    }

    private void setColWidthAttribute(CTCols cTCols) {
        for (CTCol cTCol : cTCols.getColArray()) {
            if (!cTCol.isSetWidth()) {
                cTCol.setWidth(getDefaultColumnWidth());
                cTCol.setCustomWidth(false);
            }
        }
    }

    private void setColumn(int i5, Integer num, Integer num2, Boolean bool, Boolean bool2) {
        CTCol cTCol;
        boolean z6 = false;
        CTCols colsArray = this.worksheet.getColsArray(0);
        CTCol[] colArray = colsArray.getColArray();
        int length = colArray.length;
        int i6 = 0;
        while (true) {
            if (i6 < length) {
                cTCol = colArray[i6];
                long min = cTCol.getMin();
                long max = cTCol.getMax();
                long j6 = i5;
                if (min >= j6 && max <= j6) {
                    break;
                } else if (min <= j6) {
                    i6++;
                }
            }
            cTCol = null;
            break;
        }
        if (cTCol == null) {
            CTCol cTColNewInstance = CTCol.Factory.newInstance();
            long j7 = i5;
            cTColNewInstance.setMin(j7);
            cTColNewInstance.setMax(j7);
            unsetCollapsed(bool2, cTColNewInstance);
            this.columnHelper.addCleanColIntoCols(colsArray, cTColNewInstance);
            return;
        }
        boolean z7 = (num == null || cTCol.getStyle() == ((long) num.intValue())) ? false : true;
        boolean z8 = (num2 == null || cTCol.getOutlineLevel() == num2.intValue()) ? false : true;
        boolean z9 = (bool == null || cTCol.getHidden() == bool.booleanValue()) ? false : true;
        if (bool2 != null && cTCol.getCollapsed() != bool2.booleanValue()) {
            z6 = true;
        }
        if (z8 || z9 || z6 || z7) {
            long min2 = cTCol.getMin();
            long max2 = cTCol.getMax();
            long j8 = i5;
            if (min2 == j8 && max2 == j8) {
                unsetCollapsed(bool2, cTCol);
                return;
            }
            if (min2 == j8 || max2 == j8) {
                if (min2 == j8) {
                    cTCol.setMin(1 + j8);
                } else {
                    cTCol.setMax(j8 - 1);
                }
                CTCol cTColCloneCol = this.columnHelper.cloneCol(colsArray, cTCol);
                cTColCloneCol.setMin(j8);
                unsetCollapsed(bool2, cTColCloneCol);
                this.columnHelper.addCleanColIntoCols(colsArray, cTColCloneCol);
                return;
            }
            CTCol cTColCloneCol2 = this.columnHelper.cloneCol(colsArray, cTCol);
            CTCol cTColCloneCol3 = this.columnHelper.cloneCol(colsArray, cTCol);
            int intExact = Math.toIntExact(max2);
            cTCol.setMax(j8 - 1);
            cTColCloneCol2.setMin(j8);
            cTColCloneCol2.setMax(j8);
            unsetCollapsed(bool2, cTColCloneCol2);
            this.columnHelper.addCleanColIntoCols(colsArray, cTColCloneCol2);
            cTColCloneCol3.setMin(j8 + 1);
            cTColCloneCol3.setMax(intExact);
            this.columnHelper.addCleanColIntoCols(colsArray, cTColCloneCol3);
        }
    }

    private int setGroupHidden(int i5, int i6, boolean z6) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        CTCol cTCol = colArray[i5];
        while (i5 < colArray.length) {
            cTCol.setHidden(z6);
            i5++;
            if (i5 < colArray.length) {
                CTCol cTCol2 = colArray[i5];
                if (!isAdjacentBefore(cTCol, cTCol2) || cTCol2.getOutlineLevel() < i6) {
                    break;
                }
                cTCol = cTCol2;
            }
        }
        return Math.toIntExact(cTCol.getMax());
    }

    private void setRepeatingRowsAndColumns(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        int firstRow;
        int lastRow;
        int lastColumn;
        int i5 = -1;
        if (cellRangeAddress != null) {
            firstRow = cellRangeAddress.getFirstRow();
            lastRow = cellRangeAddress.getLastRow();
            if ((firstRow == -1 && lastRow != -1) || firstRow < -1 || lastRow < -1 || firstRow > lastRow) {
                throw new IllegalArgumentException("Invalid row range specification");
            }
        } else {
            firstRow = -1;
            lastRow = -1;
        }
        if (cellRangeAddress2 != null) {
            int firstColumn = cellRangeAddress2.getFirstColumn();
            lastColumn = cellRangeAddress2.getLastColumn();
            if ((firstColumn == -1 && lastColumn != -1) || firstColumn < -1 || lastColumn < -1 || firstColumn > lastColumn) {
                throw new IllegalArgumentException("Invalid column range specification");
            }
            i5 = firstColumn;
        } else {
            lastColumn = -1;
        }
        int sheetIndex = getWorkbook().getSheetIndex(this);
        boolean z6 = cellRangeAddress == null && cellRangeAddress2 == null;
        XSSFName builtInName = getWorkbook().getBuiltInName(XSSFName.BUILTIN_PRINT_TITLE, sheetIndex);
        if (z6) {
            if (builtInName != null) {
                getWorkbook().removeName(builtInName);
                return;
            }
            return;
        }
        if (builtInName == null) {
            builtInName = getWorkbook().createBuiltInName(XSSFName.BUILTIN_PRINT_TITLE, sheetIndex);
        }
        builtInName.setRefersToFormula(getReferenceBuiltInRecord(builtInName.getSheetName(), i5, lastColumn, firstRow, lastRow));
        if (this.worksheet.isSetPageSetup() && this.worksheet.isSetPageMargins()) {
            return;
        }
        getPrintSetup().setValidSettings(false);
    }

    private void setSheetFormatPrOutlineLevelCol() {
        getSheetTypeSheetFormatPr().setOutlineLevelCol(getMaxOutlineLevelCols());
    }

    private void setSheetFormatPrOutlineLevelRow() {
        getSheetTypeSheetFormatPr().setOutlineLevelRow(getMaxOutlineLevelRows());
    }

    private void shiftCommentsAndRows(int i5, int i6, int i7) {
        int iShiftedRowNum;
        XSSFComment xSSFCommentFindCellComment;
        TreeMap treeMap = new TreeMap(new c(i7, 1));
        Iterator<Row> itRowIterator = rowIterator();
        while (itRowIterator.hasNext()) {
            XSSFRow xSSFRow = (XSSFRow) itRowIterator.next();
            int rowNum = xSSFRow.getRowNum();
            if (this.sheetComments != null && (iShiftedRowNum = shiftedRowNum(i5, i6, i7, rowNum)) != rowNum) {
                Iterator<CellAddress> cellAddresses = this.sheetComments.getCellAddresses();
                while (cellAddresses.hasNext()) {
                    CellAddress next = cellAddresses.next();
                    if (next.getRow() == rowNum && (xSSFCommentFindCellComment = this.sheetComments.findCellComment(next)) != null) {
                        treeMap.put(new XSSFComment(this.sheetComments, xSSFCommentFindCellComment.getCTComment(), xSSFCommentFindCellComment.getCTShape()), Integer.valueOf(iShiftedRowNum));
                    }
                }
            }
            if (rowNum >= i5 && rowNum <= i6) {
                xSSFRow.shift(i7);
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            ((XSSFComment) entry.getKey()).setRow(((Integer) entry.getValue()).intValue());
        }
        rebuildRows();
    }

    private void shiftCommentsForColumns(XSSFVMLDrawing xSSFVMLDrawing, int i5, int i6, int i7) {
        XSSFComment xSSFCommentFindCellComment;
        TreeMap treeMap = new TreeMap(new c(i7, 0));
        Comments comments = this.sheetComments;
        if (comments != null) {
            Iterator<CellAddress> cellAddresses = comments.getCellAddresses();
            while (cellAddresses.hasNext()) {
                CellAddress next = cellAddresses.next();
                int column = next.getColumn();
                int iShiftedRowNum = shiftedRowNum(i5, i6, i7, column);
                if (iShiftedRowNum != column && (xSSFCommentFindCellComment = this.sheetComments.findCellComment(next)) != null) {
                    treeMap.put(new XSSFComment(this.sheetComments, xSSFCommentFindCellComment.getCTComment(), xSSFCommentFindCellComment.getCTShape()), Integer.valueOf(iShiftedRowNum));
                }
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            ((XSSFComment) entry.getKey()).setColumn(((Integer) entry.getValue()).intValue());
        }
        rebuildRows();
    }

    private int shiftedRowNum(int i5, int i6, int i7, int i8) {
        if ((i8 < i5 && (i7 > 0 || i5 - i8 > i7)) || (i8 > i6 && (i7 < 0 || i8 - i6 > i7))) {
            return i8;
        }
        if (i8 < i5) {
            return (i6 - i5) + i8;
        }
        return i8 > i6 ? i8 - (i6 - i5) : i8 + i7;
    }

    private static boolean shouldRemoveRow(int i5, int i6, int i7, int i8) {
        if (i8 >= i5 + i7 && i8 <= i6 + i7) {
            if (i7 > 0 && i8 > i6) {
                return true;
            }
            if (i7 < 0 && i8 < i5) {
                return true;
            }
        }
        return false;
    }

    private void unsetCollapsed(Boolean bool, CTCol cTCol) {
        if (bool == null || !bool.booleanValue()) {
            cTCol.unsetCollapsed();
        } else {
            cTCol.setCollapsed(true);
        }
    }

    private void validateArrayFormulas(CellRangeAddress cellRangeAddress) {
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            XSSFRow row = getRow(firstRow);
            if (row != null) {
                for (int i5 = firstColumn; i5 <= lastColumn; i5++) {
                    XSSFCell cell = row.getCell(i5);
                    if (cell != null && cell.isPartOfArrayFormulaGroup()) {
                        CellRangeAddress arrayFormulaRange = cell.getArrayFormulaRange();
                        if (arrayFormulaRange.getNumberOfCells() > 1 && cellRangeAddress.intersects(arrayFormulaRange)) {
                            throw new IllegalStateException("The range " + cellRangeAddress.formatAsString() + " intersects with a multi-cell array formula. You cannot merge cells of an array.");
                        }
                    }
                }
            }
        }
    }

    private void validateMergedRegions(CellRangeAddress cellRangeAddress) {
        for (CellRangeAddress cellRangeAddress2 : getMergedRegions()) {
            if (cellRangeAddress2.intersects(cellRangeAddress)) {
                throw new IllegalStateException("Cannot add merged region " + cellRangeAddress.formatAsString() + " to sheet because it overlaps with an existing merged region (" + cellRangeAddress2.formatAsString() + ").");
            }
        }
    }

    private int writeHidden(XSSFRow xSSFRow, int i5, boolean z6) {
        short outlineLevel = xSSFRow.getCTRow().getOutlineLevel();
        Iterator<Row> itRowIterator = rowIterator();
        while (itRowIterator.hasNext()) {
            XSSFRow xSSFRow2 = (XSSFRow) itRowIterator.next();
            if (xSSFRow2.getRowNum() >= i5 && xSSFRow2.getCTRow().getOutlineLevel() >= outlineLevel) {
                xSSFRow2.getCTRow().setHidden(z6);
                i5++;
            }
        }
        return i5;
    }

    public void addHyperlink(XSSFHyperlink xSSFHyperlink) {
        this.hyperlinks.add(xSSFHyperlink);
    }

    public void addIgnoredErrors(CellReference cellReference, IgnoredErrorType... ignoredErrorTypeArr) {
        addIgnoredErrors(cellReference.formatAsString(false), ignoredErrorTypeArr);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int addMergedRegion(CellRangeAddress cellRangeAddress) {
        return addMergedRegion(cellRangeAddress, true);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int addMergedRegionUnsafe(CellRangeAddress cellRangeAddress) {
        return addMergedRegion(cellRangeAddress, false);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void addValidationData(DataValidation dataValidation) {
        XSSFDataValidation xSSFDataValidation = (XSSFDataValidation) dataValidation;
        CTDataValidations dataValidations = this.worksheet.getDataValidations();
        if (dataValidations == null) {
            dataValidations = this.worksheet.addNewDataValidations();
        }
        int iSizeOfDataValidationArray = dataValidations.sizeOfDataValidationArray();
        dataValidations.addNewDataValidation().set(xSSFDataValidation.getCtDataValidation());
        dataValidations.setCount(((long) iSizeOfDataValidationArray) + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void autoSizeColumn(int i5) {
        autoSizeColumn(i5, false);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            write(outputStream);
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

    public void copyRows(List<? extends Row> list, int i5, CellCopyPolicy cellCopyPolicy) {
        int i6;
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("No rows to copy");
        }
        Row row = list.get(0);
        Row row2 = (Row) AbstractC0157z.f(1, list);
        if (row == null) {
            throw new IllegalArgumentException("copyRows: First row cannot be null");
        }
        int rowNum = row.getRowNum();
        int rowNum2 = row2.getRowNum();
        int size = list.size();
        for (int i7 = 1; i7 < size; i7++) {
            Row row3 = list.get(i7);
            if (row3 == null) {
                throw new IllegalArgumentException(androidx.collection.a.i(i7, "srcRows may not contain null rows. Found null row at index ", Consts.DOT));
            }
            if (row.getSheet().getWorkbook() != row3.getSheet().getWorkbook()) {
                throw new IllegalArgumentException("All rows in srcRows must belong to the same sheet in the same workbook. Expected all rows from same workbook (" + row.getSheet().getWorkbook() + "). Got srcRows[" + i7 + "] from different workbook (" + row3.getSheet().getWorkbook() + ").");
            }
            if (row.getSheet() != row3.getSheet()) {
                throw new IllegalArgumentException("All rows in srcRows must belong to the same sheet. Expected all rows from " + row.getSheet().getSheetName() + ". Got srcRows[" + i7 + "] from " + row3.getSheet().getSheetName());
            }
        }
        CellCopyPolicy cellCopyPolicy2 = new CellCopyPolicy(cellCopyPolicy);
        cellCopyPolicy2.setCopyMergedRegions(false);
        int rowNum3 = i5;
        for (Row row4 : list) {
            if (cellCopyPolicy.isCondenseRows()) {
                i6 = rowNum3 + 1;
            } else {
                i6 = rowNum3;
                rowNum3 = (row4.getRowNum() - rowNum) + i5;
            }
            createRow(rowNum3).copyRowFrom(row4, cellCopyPolicy2);
            rowNum3 = i6;
        }
        if (cellCopyPolicy.isCopyMergedRegions()) {
            int i8 = i5 - rowNum;
            for (CellRangeAddress cellRangeAddress : row.getSheet().getMergedRegions()) {
                if (rowNum <= cellRangeAddress.getFirstRow() && cellRangeAddress.getLastRow() <= rowNum2) {
                    CellRangeAddress cellRangeAddressCopy = cellRangeAddress.copy();
                    cellRangeAddressCopy.setFirstRow(cellRangeAddressCopy.getFirstRow() + i8);
                    cellRangeAddressCopy.setLastRow(cellRangeAddressCopy.getLastRow() + i8);
                    addMergedRegion(cellRangeAddressCopy);
                }
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i5, int i6) {
        createFreezePane(i5, i6, i5, i6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @Removal(version = "7.0.0")
    @Deprecated
    public void createSplitPane(int i5, int i6, int i7, int i8, int i9) {
        createFreezePane(i5, i6, i7, i8);
        if (i5 > 0 || i6 > 0) {
            CTPane pane = getPane(true);
            pane.setState(STPaneState.SPLIT);
            pane.setActivePane(STPane.Enum.forInt(i9));
        }
    }

    public XSSFTable createTable(AreaReference areaReference) {
        if (!this.worksheet.isSetTableParts()) {
            this.worksheet.addNewTableParts();
        }
        CTTablePart cTTablePartAddNewTablePart = this.worksheet.getTableParts().addNewTablePart();
        int size = getPackagePart().getPackage().getPartsByContentType(XSSFRelation.TABLE.getContentType()).size() + 1;
        boolean z6 = true;
        while (true) {
            boolean z7 = false;
            if (!z6) {
                break;
            }
            ArrayList<PackagePart> partsByContentType = getPackagePart().getPackage().getPartsByContentType(XSSFRelation.TABLE.getContentType());
            int size2 = partsByContentType.size();
            int i5 = 0;
            while (i5 < size2) {
                PackagePart packagePart = partsByContentType.get(i5);
                i5++;
                if (XSSFRelation.TABLE.getFileName(size).equals(packagePart.getPartName().getName())) {
                    size++;
                    z7 = true;
                }
            }
            z6 = z7;
        }
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(XSSFRelation.TABLE, getWorkbook().getXssfFactory(), size, false);
        XSSFTable xSSFTable = (XSSFTable) relationPartCreateRelationship.getDocumentPart();
        cTTablePartAddNewTablePart.setId(relationPartCreateRelationship.getRelationship().getId());
        xSSFTable.getCTTable().setId(size);
        this.tables.put(cTTablePartAddNewTablePart.getId(), xSSFTable);
        if (areaReference != null && xSSFTable.supportsAreaReference(areaReference)) {
            xSSFTable.setArea(areaReference);
        }
        while (size < Integer.MAX_VALUE) {
            String strK = AbstractC0157z.k(size, "Table");
            if (getWorkbook().getTable(strK) == null && getWorkbook().getName(strK) == null) {
                xSSFTable.setDisplayName(strK);
                xSSFTable.setName(strK);
                return xSSFTable;
            }
            size++;
        }
        return xSSFTable;
    }

    public void disableLocking() {
        safeGetProtectionField().setSheet(false);
    }

    public void enableLocking() {
        safeGetProtectionField().setSheet(true);
    }

    public int findEndOfRowOutlineGroup(int i5) {
        short outlineLevel = getRow(i5).getCTRow().getOutlineLevel();
        int lastRowNum = getLastRowNum();
        while (i5 < lastRowNum && getRow(i5) != null && getRow(i5).getCTRow().getOutlineLevel() >= outlineLevel) {
            i5++;
        }
        return i5;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellAddress getActiveCell() {
        CTSelection sheetTypeSelection = getSheetTypeSelection(false);
        String activeCell = sheetTypeSelection != null ? sheetTypeSelection.getActiveCell() : null;
        if (activeCell != null) {
            return new CellAddress(activeCell);
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getAutobreaks() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return ((sheetTypeSheetPr == null || !sheetTypeSheetPr.isSetPageSetUpPr()) ? CTPageSetUpPr.Factory.newInstance() : sheetTypeSheetPr.getPageSetUpPr()).getAutoPageBreaks();
    }

    public CTDrawing getCTDrawing() {
        return this.worksheet.getDrawing();
    }

    public CTLegacyDrawing getCTLegacyDrawing() {
        return this.worksheet.getLegacyDrawing();
    }

    @Internal
    public CTWorksheet getCTWorksheet() {
        return this.worksheet;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Map<CellAddress, XSSFComment> getCellComments() {
        if (this.sheetComments == null) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap();
        Iterator<CellAddress> cellAddresses = this.sheetComments.getCellAddresses();
        while (cellAddresses.hasNext()) {
            CellAddress next = cellAddresses.next();
            map.put(next, getCellComment(next));
        }
        return map;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int[] getColumnBreaks() {
        return this.worksheet.isSetColBreaks() ? getBreaks(this.worksheet.getColBreaks()) : new int[0];
    }

    public ColumnHelper getColumnHelper() {
        return this.columnHelper;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnOutlineLevel(int i5) {
        CTCol column = this.columnHelper.getColumn(i5, false);
        if (column == null) {
            return 0;
        }
        return column.getOutlineLevel();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellStyle getColumnStyle(int i5) {
        int colDefaultStyle = this.columnHelper.getColDefaultStyle(i5);
        XSSFWorkbook workbook = getWorkbook();
        if (colDefaultStyle == -1) {
            colDefaultStyle = 0;
        }
        return workbook.getCellStyleAt((int) ((short) colDefaultStyle));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnWidth(int i5) {
        CTCol column = this.columnHelper.getColumn(i5, false);
        return Math.toIntExact(Math.round(((column == null || !column.isSetWidth()) ? getDefaultColumnWidth() : column.getWidth()) * 256.0d));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getColumnWidthInPixels(int i5) {
        return (float) ((((double) getColumnWidth(i5)) / 256.0d) * 7.001699924468994d);
    }

    public Comments getCommentsTable(boolean z6) {
        if (this.sheetComments == null && z6) {
            try {
                this.sheetComments = (Comments) createRelationship(XSSFRelation.SHEET_COMMENTS, getWorkbook().getXssfFactory(), Math.toIntExact(this.sheet.getSheetId()));
            } catch (PartAlreadyExistsException unused) {
                this.sheetComments = (Comments) createRelationship(XSSFRelation.SHEET_COMMENTS, getWorkbook().getXssfFactory(), -1);
            }
            Comments comments = this.sheetComments;
            if (comments != null) {
                comments.setSheet(this);
            }
        }
        return this.sheetComments;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public DataValidationHelper getDataValidationHelper() {
        return this.dataValidationHelper;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<XSSFDataValidation> getDataValidations() {
        ArrayList arrayList = new ArrayList();
        CTDataValidations dataValidations = this.worksheet.getDataValidations();
        if (dataValidations != null) {
            CTDataValidation[] dataValidationArray = dataValidations.getDataValidationArray();
            int length = dataValidationArray.length;
            int i5 = 0;
            int i6 = 0;
            while (i6 < length) {
                CTDataValidation cTDataValidation = dataValidationArray[i6];
                CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
                Iterator it = cTDataValidation.getSqref().iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = ((String) it.next()).split(" ");
                    int length2 = strArrSplit.length;
                    int i7 = i5;
                    while (i7 < length2) {
                        String[] strArrSplit2 = strArrSplit[i7].split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                        CellReference cellReference = new CellReference(strArrSplit2[i5]);
                        CellReference cellReference2 = strArrSplit2.length > 1 ? new CellReference(strArrSplit2[1]) : cellReference;
                        cellRangeAddressList.addCellRangeAddress(new CellRangeAddress(cellReference.getRow(), cellReference2.getRow(), cellReference.getCol(), cellReference2.getCol()));
                        i7++;
                        i5 = 0;
                    }
                }
                arrayList.add(new XSSFDataValidation(cellRangeAddressList, cTDataValidation));
                i6++;
                i5 = 0;
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getDefaultColumnWidth() {
        CTSheetFormatPr sheetFormatPr = this.worksheet.getSheetFormatPr();
        if (sheetFormatPr == null) {
            return 8;
        }
        return Math.toIntExact(sheetFormatPr.getBaseColWidth());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getDefaultRowHeight() {
        return (short) (getDefaultRowHeightInPoints() * 20.0f);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getDefaultRowHeightInPoints() {
        CTSheetFormatPr sheetFormatPr = this.worksheet.getSheetFormatPr();
        return (float) (sheetFormatPr == null ? 0.0d : sheetFormatPr.getDefaultRowHeight());
    }

    public CellRangeAddress getDimension() {
        CellRangeAddress cellRangeAddress = this.dimensionOverride;
        if (cellRangeAddress != null) {
            return cellRangeAddress;
        }
        CTSheetDimension dimension = this.worksheet.getDimension();
        String ref = dimension == null ? null : dimension.getRef();
        if (ref != null) {
            return CellRangeAddress.valueOf(ref);
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getDisplayGuts() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return (sheetTypeSheetPr.getOutlinePr() == null ? CTOutlinePr.Factory.newInstance() : sheetTypeSheetPr.getOutlinePr()).getShowOutlineSymbols();
    }

    public Footer getEvenFooter() {
        return new XSSFEvenFooter(getSheetTypeHeaderFooter());
    }

    public Header getEvenHeader() {
        return new XSSFEvenHeader(getSheetTypeHeaderFooter());
    }

    public XSSFCell getFirstCellInArrayFormula(XSSFCell xSSFCell) {
        for (CellRangeAddress cellRangeAddress : this.arrayFormulas) {
            if (cellRangeAddress.isInRange(xSSFCell.getRowIndex(), xSSFCell.getColumnIndex())) {
                return getRow(cellRangeAddress.getFirstRow()).getCell(cellRangeAddress.getFirstColumn());
            }
        }
        return null;
    }

    public Footer getFirstFooter() {
        return new XSSFFirstFooter(getSheetTypeHeaderFooter());
    }

    public Header getFirstHeader() {
        return new XSSFFirstHeader(getSheetTypeHeaderFooter());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getFirstRowNum() {
        if (this._rows.isEmpty()) {
            return -1;
        }
        return this._rows.firstKey().intValue();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getFitToPage() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return ((sheetTypeSheetPr == null || !sheetTypeSheetPr.isSetPageSetUpPr()) ? CTPageSetUpPr.Factory.newInstance() : sheetTypeSheetPr.getPageSetUpPr()).getFitToPage();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Footer getFooter() {
        return getOddFooter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getForceFormulaRecalculation() {
        if (this.worksheet.isSetSheetCalcPr()) {
            return this.worksheet.getSheetCalcPr().getFullCalcOnLoad();
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Header getHeader() {
        return getOddHeader();
    }

    public XSSFHeaderFooterProperties getHeaderFooterProperties() {
        return new XSSFHeaderFooterProperties(getSheetTypeHeaderFooter());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getHorizontallyCenter() {
        CTPrintOptions printOptions = this.worksheet.getPrintOptions();
        return printOptions != null && printOptions.getHorizontalCentered();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<XSSFHyperlink> getHyperlinkList() {
        return Collections.unmodifiableList(this.hyperlinks);
    }

    public Map<IgnoredErrorType, Set<CellRangeAddress>> getIgnoredErrors() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.worksheet.isSetIgnoredErrors()) {
            for (CTIgnoredError cTIgnoredError : this.worksheet.getIgnoredErrors().getIgnoredErrorList()) {
                for (IgnoredErrorType ignoredErrorType : XSSFIgnoredErrorHelper.getErrorTypes(cTIgnoredError)) {
                    if (!linkedHashMap.containsKey(ignoredErrorType)) {
                        linkedHashMap.put(ignoredErrorType, new LinkedHashSet());
                    }
                    Iterator it = cTIgnoredError.getSqref().iterator();
                    while (it.hasNext()) {
                        ((Set) linkedHashMap.get(ignoredErrorType)).add(CellRangeAddress.valueOf(it.next().toString()));
                    }
                }
            }
        }
        return linkedHashMap;
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
        String topLeftCell = this.worksheet.getSheetViews().getSheetViewArray(0).getTopLeftCell();
        if (topLeftCell == null) {
            return (short) 0;
        }
        return new CellReference(topLeftCell).getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @Removal(version = "7.0.0")
    @Deprecated
    public double getMargin(short s6) {
        return getMargin(PageMargin.getByShortValue(s6));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getMergedRegion(int i5) {
        CTMergeCells mergeCells = this.worksheet.getMergeCells();
        if (mergeCells != null) {
            return CellRangeAddress.valueOf(mergeCells.getMergeCellArray(i5).getRef());
        }
        throw new IllegalStateException("This worksheet does not contain merged regions");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<CellRangeAddress> getMergedRegions() {
        ArrayList arrayList = new ArrayList();
        CTMergeCells mergeCells = this.worksheet.getMergeCells();
        if (mergeCells != null) {
            for (CTMergeCell cTMergeCell : mergeCells.getMergeCellArray()) {
                arrayList.add(CellRangeAddress.valueOf(cTMergeCell.getRef()));
            }
        }
        return arrayList;
    }

    public int getNumHyperlinks() {
        return this.hyperlinks.size();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getNumMergedRegions() {
        CTMergeCells mergeCells = this.worksheet.getMergeCells();
        if (mergeCells == null) {
            return 0;
        }
        return mergeCells.sizeOfMergeCellArray();
    }

    public int getNumberOfComments() {
        Comments comments = this.sheetComments;
        if (comments == null) {
            return 0;
        }
        return comments.getNumberOfComments();
    }

    public Footer getOddFooter() {
        return new XSSFOddFooter(getSheetTypeHeaderFooter());
    }

    public Header getOddHeader() {
        return new XSSFOddHeader(getSheetTypeHeaderFooter());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public PaneInformation getPaneInformation() {
        short s6;
        short col;
        CTPane pane = getPane(false);
        if (pane == null) {
            return null;
        }
        if (pane.isSetTopLeftCell()) {
            CellReference cellReference = new CellReference(pane.getTopLeftCell());
            short row = (short) cellReference.getRow();
            col = cellReference.getCol();
            s6 = row;
        } else {
            s6 = 0;
            col = 0;
        }
        return new PaneInformation((short) pane.getXSplit(), (short) pane.getYSplit(), s6, col, (byte) (pane.getActivePane().intValue() - 1), pane.getState() == STPaneState.FROZEN);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getPhysicalNumberOfRows() {
        return this._rows.size();
    }

    public List<XSSFPivotTable> getPivotTables() {
        ArrayList arrayList = new ArrayList();
        for (XSSFPivotTable xSSFPivotTable : getWorkbook().getPivotTables()) {
            if (xSSFPivotTable.getParent() == this) {
                arrayList.add(xSSFPivotTable);
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getProtect() {
        return isSheetLocked();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getRepeatingColumns() {
        return getRepeatingRowsOrColumns(false);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getRepeatingRows() {
        return getRepeatingRowsOrColumns(true);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int[] getRowBreaks() {
        return this.worksheet.isSetRowBreaks() ? getBreaks(this.worksheet.getRowBreaks()) : new int[0];
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsBelow() {
        CTSheetPr sheetPr = this.worksheet.getSheetPr();
        CTOutlinePr outlinePr = (sheetPr == null || !sheetPr.isSetOutlinePr()) ? null : sheetPr.getOutlinePr();
        return outlinePr == null || outlinePr.getSummaryBelow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsRight() {
        CTSheetPr sheetPr = this.worksheet.getSheetPr();
        return ((sheetPr == null || !sheetPr.isSetOutlinePr()) ? CTOutlinePr.Factory.newInstance() : sheetPr.getOutlinePr()).getSummaryRight();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getScenarioProtect() {
        return this.worksheet.isSetSheetProtection() && this.worksheet.getSheetProtection().getScenarios();
    }

    @Internal
    public CTCellFormula getSharedFormula(int i5) {
        return this.sharedFormulas.get(Integer.valueOf(i5));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public String getSheetName() {
        return this.sheet.getName();
    }

    public CTSheetViews getSheetTypeSheetViews(boolean z6) {
        CTSheetViews sheetViews = (this.worksheet.isSetSheetViews() || !z6) ? this.worksheet.getSheetViews() : this.worksheet.addNewSheetViews();
        if (sheetViews == null) {
            return null;
        }
        if (sheetViews.sizeOfSheetViewArray() == 0 && z6) {
            sheetViews.addNewSheetView();
        }
        return sheetViews;
    }

    public XSSFColor getTabColor() {
        CTSheetPr sheetPr = this.worksheet.getSheetPr();
        if (sheetPr == null) {
            sheetPr = this.worksheet.addNewSheetPr();
        }
        if (sheetPr.isSetTabColor()) {
            return XSSFColor.from(sheetPr.getTabColor(), getWorkbook().getStylesSource().getIndexedColors());
        }
        return null;
    }

    public List<XSSFTable> getTables() {
        return new ArrayList(this.tables.values());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getTopRow() {
        CTSheetView defaultSheetView = getDefaultSheetView(false);
        String topLeftCell = defaultSheetView == null ? null : defaultSheetView.getTopLeftCell();
        if (topLeftCell == null) {
            return (short) 0;
        }
        return (short) new CellReference(topLeftCell).getRow();
    }

    @Override // org.apache.poi.xssf.usermodel.OoxmlSheetExtensions
    public XSSFVMLDrawing getVMLDrawing(boolean z6) {
        if (this.xssfvmlDrawing == null) {
            CTLegacyDrawing cTLegacyDrawing = getCTLegacyDrawing();
            XSSFVMLDrawing xSSFVMLDrawing = null;
            if (cTLegacyDrawing != null) {
                String id = cTLegacyDrawing.getId();
                for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                    POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
                    if (documentPart instanceof XSSFVMLDrawing) {
                        XSSFVMLDrawing xSSFVMLDrawing2 = (XSSFVMLDrawing) documentPart;
                        if (relationPart.getRelationship().getId().equals(id)) {
                            xSSFVMLDrawing = xSSFVMLDrawing2;
                            break;
                        }
                    }
                }
                if (xSSFVMLDrawing == null) {
                    LOG.atError().log("Can't find VML drawing with id={} in the list of the sheet's relationships", id);
                }
            } else if (z6) {
                XSSFRelation xSSFRelation = XSSFRelation.VML_DRAWINGS;
                POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(xSSFRelation, getWorkbook().getXssfFactory(), getNextPartNumber(xSSFRelation, getPackagePart().getPackage().getPartsByContentType(xSSFRelation.getContentType()).size()), false);
                xSSFVMLDrawing = (XSSFVMLDrawing) relationPartCreateRelationship.getDocumentPart();
                this.worksheet.addNewLegacyDrawing().setId(relationPartCreateRelationship.getRelationship().getId());
            }
            this.xssfvmlDrawing = xSSFVMLDrawing;
        }
        return this.xssfvmlDrawing;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getVerticallyCenter() {
        CTPrintOptions printOptions = this.worksheet.getPrintOptions();
        return printOptions != null && printOptions.getVerticalCentered();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupColumn(int i5, int i6) {
        groupColumn1Based(i5 + 1, i6 + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupRow(int i5, int i6) {
        while (i5 <= i6) {
            XSSFRow row = getRow(i5);
            if (row == null) {
                row = createRow(i5);
            }
            CTRow cTRow = row.getCTRow();
            cTRow.setOutlineLevel((short) (cTRow.getOutlineLevel() + 1));
            i5++;
        }
        setSheetFormatPrOutlineLevelRow();
    }

    public boolean hasComments() {
        Comments comments = this.sheetComments;
        return comments != null && comments.getNumberOfComments() > 0;
    }

    public boolean isAutoFilterLocked() {
        return isSheetLocked() && safeGetProtectionField().getAutoFilter();
    }

    public boolean isCellInArrayFormulaContext(XSSFCell xSSFCell) {
        Iterator<CellRangeAddress> it = this.arrayFormulas.iterator();
        while (it.hasNext()) {
            if (it.next().isInRange(xSSFCell.getRowIndex(), xSSFCell.getColumnIndex())) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnBroken(int i5) {
        for (int i6 : getColumnBreaks()) {
            if (i6 == i5) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnHidden(int i5) {
        CTCol column = this.columnHelper.getColumn(i5, false);
        return column != null && column.getHidden();
    }

    public boolean isDeleteColumnsLocked() {
        return isSheetLocked() && safeGetProtectionField().getDeleteColumns();
    }

    public boolean isDeleteRowsLocked() {
        return isSheetLocked() && safeGetProtectionField().getDeleteRows();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayFormulas() {
        CTSheetView defaultSheetView = getDefaultSheetView(false);
        return defaultSheetView != null && defaultSheetView.getShowFormulas();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayGridlines() {
        CTSheetView defaultSheetView = getDefaultSheetView(false);
        return defaultSheetView == null || defaultSheetView.getShowGridLines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayRowColHeadings() {
        CTSheetView defaultSheetView = getDefaultSheetView(false);
        return defaultSheetView == null || defaultSheetView.getShowRowColHeaders();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayZeros() {
        CTSheetView defaultSheetView = getDefaultSheetView(false);
        return defaultSheetView == null || defaultSheetView.getShowZeros();
    }

    public boolean isFormatCellsLocked() {
        return isSheetLocked() && safeGetProtectionField().getFormatCells();
    }

    public boolean isFormatColumnsLocked() {
        return isSheetLocked() && safeGetProtectionField().getFormatColumns();
    }

    public boolean isFormatRowsLocked() {
        return isSheetLocked() && safeGetProtectionField().getFormatRows();
    }

    public boolean isInsertColumnsLocked() {
        return isSheetLocked() && safeGetProtectionField().getInsertColumns();
    }

    public boolean isInsertHyperlinksLocked() {
        return isSheetLocked() && safeGetProtectionField().getInsertHyperlinks();
    }

    public boolean isInsertRowsLocked() {
        return isSheetLocked() && safeGetProtectionField().getInsertRows();
    }

    public boolean isObjectsLocked() {
        return isSheetLocked() && safeGetProtectionField().getObjects();
    }

    public boolean isPivotTablesLocked() {
        return isSheetLocked() && safeGetProtectionField().getPivotTables();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isPrintGridlines() {
        CTPrintOptions printOptions = this.worksheet.getPrintOptions();
        return printOptions != null && printOptions.getGridLines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isPrintRowAndColumnHeadings() {
        CTPrintOptions printOptions = this.worksheet.getPrintOptions();
        return printOptions != null && printOptions.getHeadings();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRightToLeft() {
        CTSheetView defaultSheetView = getDefaultSheetView(false);
        return defaultSheetView != null && defaultSheetView.getRightToLeft();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRowBroken(int i5) {
        for (int i6 : getRowBreaks()) {
            if (i6 == i5) {
                return true;
            }
        }
        return false;
    }

    public boolean isScenariosLocked() {
        return isSheetLocked() && safeGetProtectionField().getScenarios();
    }

    public boolean isSelectLockedCellsLocked() {
        return isSheetLocked() && safeGetProtectionField().getSelectLockedCells();
    }

    public boolean isSelectUnlockedCellsLocked() {
        return isSheetLocked() && safeGetProtectionField().getSelectUnlockedCells();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isSelected() {
        CTSheetView defaultSheetView = getDefaultSheetView(false);
        return defaultSheetView != null && defaultSheetView.getTabSelected();
    }

    public boolean isSheetLocked() {
        return this.worksheet.isSetSheetProtection() && safeGetProtectionField().getSheet();
    }

    public boolean isSheetProtectionEnabled() {
        return this.worksheet.isSetSheetProtection();
    }

    public boolean isSortLocked() {
        return isSheetLocked() && safeGetProtectionField().getSort();
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

    public void onDeleteFormula(XSSFCell xSSFCell, BaseXSSFEvaluationWorkbook baseXSSFEvaluationWorkbook) {
        CTCellFormula f6 = xSSFCell.getCTCell().getF();
        if (f6 == null || f6.getT() != STCellFormulaType.SHARED || !f6.isSetRef() || f6.getStringValue() == null) {
            return;
        }
        CellRangeAddress cellRangeAddressValueOf = CellRangeAddress.valueOf(f6.getRef());
        if (cellRangeAddressValueOf.getNumberOfCells() > 1) {
            for (int rowIndex = xSSFCell.getRowIndex(); rowIndex <= cellRangeAddressValueOf.getLastRow(); rowIndex++) {
                XSSFRow row = getRow(rowIndex);
                if (row != null) {
                    for (int columnIndex = xSSFCell.getColumnIndex(); columnIndex <= cellRangeAddressValueOf.getLastColumn(); columnIndex++) {
                        XSSFCell cell = row.getCell(columnIndex);
                        if (cell != null && cell != xSSFCell && cell.getCellType() == CellType.FORMULA) {
                            CTCellFormula f7 = cell.getCTCell().getF();
                            if (f7.getT() == STCellFormulaType.SHARED && f7.getSi() == f6.getSi()) {
                                f7.setStringValue(cell.getCellFormula(baseXSSFEvaluationWorkbook));
                                f7.setRef(new CellRangeAddress(cell.getRowIndex(), cellRangeAddressValueOf.getLastRow(), cell.getColumnIndex(), cellRangeAddressValueOf.getLastColumn()).formatAsString());
                                this.sharedFormulas.put(Integer.valueOf(Math.toIntExact(f7.getSi())), f7);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentCreate() {
        CTWorksheet cTWorksheetNewSheet = newSheet();
        this.worksheet = cTWorksheetNewSheet;
        initRows(cTWorksheetNewSheet);
        this.columnHelper = new ColumnHelper(this.worksheet);
        this.hyperlinks = new ArrayList();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        try {
            InputStream inputStream = getPackagePart().getInputStream();
            try {
                read(inputStream);
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
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public void onReadCell(XSSFCell xSSFCell) {
        CTCellFormula f6 = xSSFCell.getCTCell().getF();
        if (f6 != null && f6.getT() == STCellFormulaType.SHARED && f6.isSetRef() && f6.getStringValue() != null) {
            CTCellFormula cTCellFormula = (CTCellFormula) f6.copy();
            CellRangeAddress cellRangeAddressValueOf = CellRangeAddress.valueOf(cTCellFormula.getRef());
            CellReference cellReference = new CellReference(xSSFCell);
            if (cellReference.getCol() > cellRangeAddressValueOf.getFirstColumn() || cellReference.getRow() > cellRangeAddressValueOf.getFirstRow()) {
                cTCellFormula.setRef(new CellRangeAddress(Math.max(cellReference.getRow(), cellRangeAddressValueOf.getFirstRow()), Math.max(cellReference.getRow(), cellRangeAddressValueOf.getLastRow()), Math.max((int) cellReference.getCol(), cellRangeAddressValueOf.getFirstColumn()), Math.max((int) cellReference.getCol(), cellRangeAddressValueOf.getLastColumn())).formatAsString());
            }
            this.sharedFormulas.put(Integer.valueOf(Math.toIntExact(f6.getSi())), cTCellFormula);
        }
        if (f6 == null || f6.getT() != STCellFormulaType.ARRAY || f6.getRef() == null) {
            return;
        }
        this.arrayFormulas.add(CellRangeAddress.valueOf(f6.getRef()));
    }

    public void onSheetDelete() {
        for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
            if (relationPart.getDocumentPart() instanceof XSSFTable) {
                removeTable((XSSFTable) relationPart.getDocumentPart());
            } else {
                removeRelation(relationPart.getDocumentPart(), true);
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void protectSheet(String str) {
        if (str == null) {
            this.worksheet.unsetSheetProtection();
            return;
        }
        CTSheetProtection cTSheetProtectionSafeGetProtectionField = safeGetProtectionField();
        setSheetPassword(str, null);
        cTSheetProtectionSafeGetProtectionField.setSheet(true);
        cTSheetProtectionSafeGetProtectionField.setScenarios(true);
        cTSheetProtectionSafeGetProtectionField.setObjects(true);
    }

    public void read(InputStream inputStream) {
        try {
            CTWorksheet worksheet = WorksheetDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getWorksheet();
            this.worksheet = worksheet;
            initRows(worksheet);
            this.columnHelper = new ColumnHelper(this.worksheet);
            for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                Object documentPart = relationPart.getDocumentPart();
                if (documentPart instanceof Comments) {
                    Comments comments = (Comments) documentPart;
                    this.sheetComments = comments;
                    comments.setSheet(this);
                }
                if (documentPart instanceof XSSFTable) {
                    this.tables.put(relationPart.getRelationship().getId(), (XSSFTable) documentPart);
                }
                if (documentPart instanceof XSSFPivotTable) {
                    getWorkbook().getPivotTables().add((XSSFPivotTable) documentPart);
                }
            }
            initHyperlinks();
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    public CTOleObject readOleObject(long j6) {
        LogBuilder logBuilderAtInfo;
        if (!getCTWorksheet().isSetOleObjects()) {
            return null;
        }
        XmlCursor xmlCursorNewCursor = getCTWorksheet().getOleObjects().newCursor();
        try {
            xmlCursorNewCursor.selectPath("declare namespace p='http://schemas.openxmlformats.org/spreadsheetml/2006/main' .//p:oleObject");
            CTOleObject oleObjectArray = null;
            while (xmlCursorNewCursor.toNextSelection()) {
                String attributeText = xmlCursorNewCursor.getAttributeText(new QName(null, "shapeId"));
                if (attributeText != null && Long.parseLong(attributeText) == j6) {
                    XmlObject object = xmlCursorNewCursor.getObject();
                    if (!(object instanceof CTOleObject)) {
                        XMLStreamReader xMLStreamReaderNewXMLStreamReader = xmlCursorNewCursor.newXMLStreamReader();
                        try {
                            try {
                                CTOleObjects cTOleObjects = CTOleObjects.Factory.parse(xMLStreamReaderNewXMLStreamReader);
                                if (cTOleObjects.sizeOfOleObjectArray() == 0) {
                                    try {
                                        xMLStreamReaderNewXMLStreamReader.close();
                                    } catch (XMLStreamException e) {
                                        LOG.atInfo().withThrowable(e).log("can't close reader");
                                    }
                                } else {
                                    oleObjectArray = cTOleObjects.getOleObjectArray(0);
                                    try {
                                        xMLStreamReaderNewXMLStreamReader.close();
                                    } catch (XMLStreamException e6) {
                                        e = e6;
                                        logBuilderAtInfo = LOG.atInfo();
                                        logBuilderAtInfo.withThrowable(e).log("can't close reader");
                                    }
                                }
                            } catch (XmlException e7) {
                                LOG.atInfo().withThrowable(e7).log("can't parse CTOleObjects");
                                try {
                                    xMLStreamReaderNewXMLStreamReader.close();
                                } catch (XMLStreamException e8) {
                                    e = e8;
                                    logBuilderAtInfo = LOG.atInfo();
                                    logBuilderAtInfo.withThrowable(e).log("can't close reader");
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                xMLStreamReaderNewXMLStreamReader.close();
                            } catch (XMLStreamException e9) {
                                LOG.atInfo().withThrowable(e9).log("can't close reader");
                            }
                            throw th;
                        }
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
                    oleObjectArray = (CTOleObject) object;
                    if (xmlCursorNewCursor.toChild(XSSFRelation.NS_SPREADSHEETML, "objectPr")) {
                        break;
                    }
                }
            }
            xmlCursorNewCursor.close();
            return oleObjectArray;
        } catch (Throwable th4) {
            throw th4;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<XSSFCell> removeArrayFormula(Cell cell) {
        if (cell.getSheet() != this) {
            throw new IllegalArgumentException("Specified cell does not belong to this sheet.");
        }
        for (CellRangeAddress cellRangeAddress : this.arrayFormulas) {
            if (cellRangeAddress.isInRange(cell)) {
                this.arrayFormulas.remove(cellRangeAddress);
                CellRange<XSSFCell> cellRange = getCellRange(cellRangeAddress);
                Iterator<C> it = cellRange.iterator();
                while (it.hasNext()) {
                    ((XSSFCell) it.next()).setBlank();
                }
                return cellRange;
            }
        }
        throw new IllegalArgumentException(AbstractC0157z.o("Cell ", new CellReference(cell).formatAsString(), " is not part of an array formula."));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeColumnBreak(int i5) {
        if (this.worksheet.isSetColBreaks()) {
            removeBreak(i5, this.worksheet.getColBreaks());
        }
    }

    public void removeHyperlink(XSSFHyperlink xSSFHyperlink) {
        this.hyperlinks.remove(xSSFHyperlink);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeMergedRegion(int i5) {
        if (this.worksheet.isSetMergeCells()) {
            CTMergeCells mergeCells = this.worksheet.getMergeCells();
            if (mergeCells.sizeOfMergeCellArray() > 1) {
                mergeCells.removeMergeCell(i5);
            } else {
                this.worksheet.unsetMergeCells();
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeMergedRegions(Collection<Integer> collection) {
        if (this.worksheet.isSetMergeCells()) {
            CTMergeCells mergeCells = this.worksheet.getMergeCells();
            ArrayList arrayList = new ArrayList(mergeCells.sizeOfMergeCellArray());
            CTMergeCell[] mergeCellArray = mergeCells.getMergeCellArray();
            int length = mergeCellArray.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                CTMergeCell cTMergeCell = mergeCellArray[i5];
                int i7 = i6 + 1;
                if (!collection.contains(Integer.valueOf(i6))) {
                    arrayList.add(cTMergeCell);
                }
                i5++;
                i6 = i7;
            }
            if (arrayList.isEmpty()) {
                this.worksheet.unsetMergeCells();
            } else {
                mergeCells.setMergeCellArray((CTMergeCell[]) arrayList.toArray(new CTMergeCell[arrayList.size()]));
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRow(Row row) {
        if (row.getSheet() != this) {
            throw new IllegalArgumentException("Specified row does not belong to this sheet");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Cell> it = row.iterator();
        while (it.hasNext()) {
            arrayList.add((XSSFCell) it.next());
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            row.removeCell((XSSFCell) obj);
        }
        int rowNum = row.getRowNum();
        Integer numValueOf = Integer.valueOf(rowNum);
        int size2 = this._rows.headMap(numValueOf).size();
        this._rows.remove(numValueOf);
        this.worksheet.getSheetData().removeRow(size2);
        if (this.sheetComments != null) {
            for (CellAddress cellAddress : getCellComments().keySet()) {
                if (cellAddress.getRow() == rowNum) {
                    this.sheetComments.removeComment(cellAddress);
                }
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRowBreak(int i5) {
        if (this.worksheet.isSetRowBreaks()) {
            removeBreak(i5, this.worksheet.getRowBreaks());
        }
    }

    public void removeTable(XSSFTable xSSFTable) {
        int i5;
        String relationId = getRelationId(xSSFTable);
        long id = xSSFTable.getCTTable().getId();
        Map.Entry<String, XSSFTable> entry = null;
        for (Map.Entry<String, XSSFTable> entry2 : this.tables.entrySet()) {
            if (entry2.getValue().getCTTable().getId() == id) {
                entry = entry2;
            }
        }
        if (entry != null) {
            removeRelation(getRelationById(entry.getKey()), true);
            this.tables.remove(entry.getKey());
            entry.getValue().onTableDelete();
            CTTableParts tableParts = this.worksheet.getTableParts();
            if (relationId == null) {
                i5 = -1;
                break;
            }
            i5 = 0;
            while (true) {
                if (i5 >= tableParts.sizeOfTablePartArray()) {
                    i5 = -1;
                    break;
                } else if (relationId.equals(tableParts.getTablePartArray(i5).getId())) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 != -1) {
                tableParts.removeTablePart(i5);
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Iterator<Row> rowIterator() {
        return this._rows.values().iterator();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setActiveCell(CellAddress cellAddress) {
        CTSelection sheetTypeSelection = getSheetTypeSelection(true);
        String asString = cellAddress.formatAsString();
        sheetTypeSelection.setActiveCell(asString);
        sheetTypeSelection.setSqref(Collections.singletonList(asString));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<XSSFCell> setArrayFormula(String str, CellRangeAddress cellRangeAddress) {
        CellRange<XSSFCell> cellRange = getCellRange(cellRangeAddress);
        ((XSSFCell) cellRange.getTopLeftCell()).setCellArrayFormula(str, cellRangeAddress);
        this.arrayFormulas.add(cellRangeAddress);
        return cellRange;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setAutobreaks(boolean z6) {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        (sheetTypeSheetPr.isSetPageSetUpPr() ? sheetTypeSheetPr.getPageSetUpPr() : sheetTypeSheetPr.addNewPageSetUpPr()).setAutoPageBreaks(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnBreak(int i5) {
        if (isColumnBroken(i5)) {
            return;
        }
        setBreak(i5, this.worksheet.isSetColBreaks() ? this.worksheet.getColBreaks() : this.worksheet.addNewColBreaks(), SpreadsheetVersion.EXCEL2007.getLastRowIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnGroupCollapsed(int i5, boolean z6) {
        if (z6) {
            collapseColumn(i5);
        } else {
            expandColumn(i5);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnHidden(int i5, boolean z6) {
        this.columnHelper.setColHidden(i5, z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnWidth(int i5, int i6) {
        if (i6 > 65280) {
            throw new IllegalArgumentException("The maximum column width for an individual cell is 255 characters.");
        }
        long j6 = i5;
        this.columnHelper.setColWidth(j6, ((double) i6) / 256.0d);
        this.columnHelper.setCustomWidth(j6, true);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnStyle(int i5, CellStyle cellStyle) {
        this.columnHelper.setColDefaultStyle(i5, cellStyle);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnWidth(int i5) {
        getSheetTypeSheetFormatPr().setBaseColWidth(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeight(short s6) {
        setDefaultRowHeightInPoints(s6 / 20.0f);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeightInPoints(float f6) {
        CTSheetFormatPr sheetTypeSheetFormatPr = getSheetTypeSheetFormatPr();
        sheetTypeSheetFormatPr.setDefaultRowHeight(f6);
        sheetTypeSheetFormatPr.setCustomHeight(true);
    }

    public void setDimensionOverride(CellRangeAddress cellRangeAddress) {
        this.dimensionOverride = cellRangeAddress;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayFormulas(boolean z6) {
        getDefaultSheetView(true).setShowFormulas(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGridlines(boolean z6) {
        getDefaultSheetView(true).setShowGridLines(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGuts(boolean z6) {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        (sheetTypeSheetPr.getOutlinePr() == null ? sheetTypeSheetPr.addNewOutlinePr() : sheetTypeSheetPr.getOutlinePr()).setShowOutlineSymbols(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayRowColHeadings(boolean z6) {
        getDefaultSheetView(true).setShowRowColHeaders(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayZeros(boolean z6) {
        getDefaultSheetView(true).setShowZeros(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setFitToPage(boolean z6) {
        getSheetTypePageSetUpPr().setFitToPage(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setForceFormulaRecalculation(boolean z6) {
        CTCalcPr calcPr = getWorkbook().getCTWorkbook().getCalcPr();
        if (this.worksheet.isSetSheetCalcPr()) {
            this.worksheet.getSheetCalcPr().setFullCalcOnLoad(z6);
        } else if (z6) {
            this.worksheet.addNewSheetCalcPr().setFullCalcOnLoad(z6);
        }
        if (z6 && calcPr != null && calcPr.getCalcMode() == STCalcMode.MANUAL) {
            calcPr.setCalcMode(STCalcMode.AUTO);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setHorizontallyCenter(boolean z6) {
        (this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions()).setHorizontalCentered(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @Removal(version = "7.0.0")
    @Deprecated
    public void setMargin(short s6, double d) {
        PageMargin byShortValue = PageMargin.getByShortValue(s6);
        if (byShortValue == null) {
            throw new IllegalArgumentException(AbstractC0157z.k(s6, "Unknown margin constant:  "));
        }
        setMargin(byShortValue, d);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setPrintGridlines(boolean z6) {
        (this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions()).setGridLines(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setPrintRowAndColumnHeadings(boolean z6) {
        (this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions()).setHeadings(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRepeatingColumns(CellRangeAddress cellRangeAddress) {
        setRepeatingRowsAndColumns(getRepeatingRows(), cellRangeAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRepeatingRows(CellRangeAddress cellRangeAddress) {
        setRepeatingRowsAndColumns(cellRangeAddress, getRepeatingColumns());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRightToLeft(boolean z6) {
        getDefaultSheetView(true).setRightToLeft(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowBreak(int i5) {
        if (isRowBroken(i5)) {
            return;
        }
        setBreak(i5, this.worksheet.isSetRowBreaks() ? this.worksheet.getRowBreaks() : this.worksheet.addNewRowBreaks(), SpreadsheetVersion.EXCEL2007.getLastColumnIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowGroupCollapsed(int i5, boolean z6) {
        if (z6) {
            collapseRow(i5);
        } else {
            expandRow(i5);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsBelow(boolean z6) {
        ensureOutlinePr().setSummaryBelow(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsRight(boolean z6) {
        ensureOutlinePr().setSummaryRight(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setSelected(boolean z6) {
        for (CTSheetView cTSheetView : getSheetTypeSheetViews(true).getSheetViewArray()) {
            cTSheetView.setTabSelected(z6);
        }
    }

    public void setSheetPassword(String str, HashAlgorithm hashAlgorithm) {
        if (str != null || isSheetProtectionEnabled()) {
            XSSFPasswordHelper.setPassword(safeGetProtectionField(), str, hashAlgorithm, null);
        }
    }

    public void setTabColor(XSSFColor xSSFColor) {
        CTSheetPr sheetPr = this.worksheet.getSheetPr();
        if (sheetPr == null) {
            sheetPr = this.worksheet.addNewSheetPr();
        }
        sheetPr.setTabColor(xSSFColor.getCTColor());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setVerticallyCenter(boolean z6) {
        (this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions()).setVerticalCentered(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setZoom(int i5) {
        if (i5 < 10 || i5 > 400) {
            throw new IllegalArgumentException("Valid scale values range from 10 to 400");
        }
        getDefaultSheetView(true).setZoomScale(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftColumns(int i5, int i6, int i7) {
        ArrayList arrayList = new ArrayList();
        for (XSSFTable xSSFTable : getTables()) {
            if (xSSFTable.getStartColIndex() >= i5 || xSSFTable.getEndColIndex() >= i5) {
                if (xSSFTable.getStartColIndex() <= i6 || xSSFTable.getEndColIndex() <= i6) {
                    arrayList.add(xSSFTable);
                }
            }
        }
        int i8 = 0;
        shiftCommentsForColumns(getVMLDrawing(false), i5, i6, i7);
        FormulaShifter formulaShifterCreateForColumnShift = FormulaShifter.createForColumnShift(getWorkbook().getSheetIndex(this), getSheetName(), i5, i6, i7, SpreadsheetVersion.EXCEL2007);
        XSSFColumnShifter xSSFColumnShifter = new XSSFColumnShifter(this);
        xSSFColumnShifter.shiftColumns(i5, i6, i7);
        xSSFColumnShifter.shiftMergedRegions(i5, i6, i7);
        xSSFColumnShifter.updateFormulas(formulaShifterCreateForColumnShift);
        xSSFColumnShifter.updateConditionalFormatting(formulaShifterCreateForColumnShift);
        xSSFColumnShifter.updateHyperlinks(formulaShifterCreateForColumnShift);
        xSSFColumnShifter.updateNamedRanges(formulaShifterCreateForColumnShift);
        rebuildRows();
        int size = arrayList.size();
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            rebuildTableFormulas((XSSFTable) obj);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftRows(int i5, int i6, int i7) {
        shiftRows(i5, i6, i7, false, false);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void showInPane(int i5, int i6) {
        getPane(true).setTopLeftCell(new CellReference(i5, i6).formatAsString());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet, java.lang.Iterable
    public Spliterator<Row> spliterator() {
        return this._rows.values().spliterator();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupColumn(int i5, int i6) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        while (i5 <= i6) {
            CTCol column = this.columnHelper.getColumn(i5, false);
            if (column != null) {
                column.setOutlineLevel((short) (column.getOutlineLevel() - 1));
                i5 = Math.toIntExact(column.getMax());
                if (column.getOutlineLevel() <= 0) {
                    this.worksheet.getColsArray(0).removeCol(this.columnHelper.getIndexOfColumn(colsArray, column));
                }
            }
            i5++;
        }
        this.worksheet.setColsArray(0, colsArray);
        setSheetFormatPrOutlineLevelCol();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupRow(int i5, int i6) {
        while (i5 <= i6) {
            XSSFRow row = getRow(i5);
            if (row != null) {
                CTRow cTRow = row.getCTRow();
                short outlineLevel = cTRow.getOutlineLevel();
                cTRow.setOutlineLevel((short) (outlineLevel - 1));
                if (outlineLevel == 1 && row.getFirstCellNum() == -1) {
                    removeRow(row);
                }
            }
            i5++;
        }
        setSheetFormatPrOutlineLevelRow();
    }

    public boolean validateSheetPassword(String str) {
        if (isSheetProtectionEnabled()) {
            return XSSFPasswordHelper.validatePassword(safeGetProtectionField(), str, null);
        }
        return str == null;
    }

    public void write(OutputStream outputStream) {
        boolean z6;
        if (this.worksheet.sizeOfColsArray() == 1) {
            CTCols colsArray = this.worksheet.getColsArray(0);
            if (colsArray.sizeOfColArray() == 0) {
                this.worksheet.setColsArray(null);
                z6 = true;
            } else {
                setColWidthAttribute(colsArray);
                z6 = false;
            }
        } else {
            z6 = false;
        }
        if (!this.hyperlinks.isEmpty()) {
            if (this.worksheet.getHyperlinks() == null) {
                this.worksheet.addNewHyperlinks();
            }
            int size = this.hyperlinks.size();
            CTHyperlink[] cTHyperlinkArr = new CTHyperlink[size];
            for (int i5 = 0; i5 < size; i5++) {
                XSSFHyperlink xSSFHyperlink = this.hyperlinks.get(i5);
                xSSFHyperlink.generateRelationIfNeeded(getPackagePart());
                cTHyperlinkArr[i5] = xSSFHyperlink.getCTHyperlink();
            }
            this.worksheet.getHyperlinks().setHyperlinkArray(cTHyperlinkArr);
        } else if (this.worksheet.getHyperlinks() != null) {
            for (int iSizeOfHyperlinkArray = this.worksheet.getHyperlinks().sizeOfHyperlinkArray() - 1; iSizeOfHyperlinkArray >= 0; iSizeOfHyperlinkArray--) {
                this.worksheet.getHyperlinks().removeHyperlink(iSizeOfHyperlinkArray);
            }
            this.worksheet.unsetHyperlinks();
        }
        CellRangeAddress cellRangeAddress = this.dimensionOverride;
        if (cellRangeAddress == null) {
            Iterator<Map.Entry<Integer, XSSFRow>> it = this._rows.entrySet().iterator();
            int iMax = Integer.MIN_VALUE;
            int iMin = Integer.MAX_VALUE;
            while (it.hasNext()) {
                XSSFRow value = it.next().getValue();
                value.onDocumentWrite();
                if (value.getFirstCellNum() != -1) {
                    iMin = Math.min(iMin, (int) value.getFirstCellNum());
                }
                if (value.getLastCellNum() != -1) {
                    iMax = Math.max(iMax, value.getLastCellNum() - 1);
                }
            }
            if (iMin != Integer.MAX_VALUE) {
                cellRangeAddress = new CellRangeAddress(getFirstRowNum(), getLastRowNum(), iMin, iMax);
            }
        }
        if (cellRangeAddress != null) {
            if (this.worksheet.isSetDimension()) {
                this.worksheet.getDimension().setRef(cellRangeAddress.formatAsString());
            } else {
                this.worksheet.addNewDimension().setRef(cellRangeAddress.formatAsString());
            }
        }
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTWorksheet.type.getName().getNamespaceURI(), "worksheet"));
        this.worksheet.save(outputStream, xmlOptions);
        if (z6) {
            this.worksheet.addNewCols();
        }
    }

    private int addMergedRegion(CellRangeAddress cellRangeAddress, boolean z6) {
        if (cellRangeAddress.getNumberOfCells() < 2) {
            throw new IllegalArgumentException("Merged region " + cellRangeAddress.formatAsString() + " must contain 2 or more cells");
        }
        cellRangeAddress.validate(SpreadsheetVersion.EXCEL2007);
        if (z6) {
            validateArrayFormulas(cellRangeAddress);
            validateMergedRegions(cellRangeAddress);
        }
        CTMergeCells mergeCells = this.worksheet.isSetMergeCells() ? this.worksheet.getMergeCells() : this.worksheet.addNewMergeCells();
        mergeCells.addNewMergeCell().setRef(cellRangeAddress.formatAsString());
        long count = mergeCells.getCount();
        long jSizeOfMergeCellArray = count == 0 ? mergeCells.sizeOfMergeCellArray() : count + 1;
        mergeCells.setCount(jSizeOfMergeCellArray);
        return Math.toIntExact(jSizeOfMergeCellArray - 1);
    }

    public void addIgnoredErrors(CellRangeAddress cellRangeAddress, IgnoredErrorType... ignoredErrorTypeArr) {
        cellRangeAddress.validate(SpreadsheetVersion.EXCEL2007);
        addIgnoredErrors(cellRangeAddress.formatAsString(), ignoredErrorTypeArr);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void autoSizeColumn(int i5, boolean z6) {
        double columnWidth = SheetUtil.getColumnWidth(this, i5, z6);
        if (columnWidth != -1.0d) {
            double d = columnWidth * 256.0d;
            double d6 = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
            if (d > d6) {
                d = d6;
            }
            setColumnWidth(i5, Math.toIntExact(Math.round(d)));
            this.columnHelper.setColBestFit(i5, true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFDrawing createDrawingPatriarch() {
        XSSFDrawing drawingPatriarch = getDrawingPatriarch();
        if (drawingPatriarch != null) {
            return drawingPatriarch;
        }
        OPCPackage oPCPackage = getPackagePart().getPackage();
        XSSFRelation xSSFRelation = XSSFRelation.DRAWINGS;
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(xSSFRelation, getWorkbook().getXssfFactory(), getNextPartNumber(xSSFRelation, oPCPackage.getPartsByContentType(xSSFRelation.getContentType()).size() + 1), false);
        XSSFDrawing xSSFDrawing = (XSSFDrawing) relationPartCreateRelationship.getDocumentPart();
        this.worksheet.addNewDrawing().setId(relationPartCreateRelationship.getRelationship().getId());
        return xSSFDrawing;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i5, int i6, int i7, int i8) {
        boolean z6 = i5 == 0 && i6 == 0;
        CTSheetView defaultSheetView = getDefaultSheetView(!z6);
        if (defaultSheetView != null) {
            defaultSheetView.setSelectionArray(null);
        }
        if (z6) {
            if (defaultSheetView == null || !defaultSheetView.isSetPane()) {
                return;
            }
            defaultSheetView.unsetPane();
            return;
        }
        CTPane pane = defaultSheetView.isSetPane() ? defaultSheetView.getPane() : defaultSheetView.addNewPane();
        if (i5 > 0) {
            pane.setXSplit(i5);
        } else if (pane.isSetXSplit()) {
            pane.unsetXSplit();
        }
        if (i6 > 0) {
            pane.setYSplit(i6);
        } else if (pane.isSetYSplit()) {
            pane.unsetYSplit();
        }
        STPane.Enum r6 = STPane.BOTTOM_RIGHT;
        if (i6 == 0) {
            r6 = STPane.TOP_RIGHT;
            i8 = 0;
        } else if (i5 == 0) {
            r6 = STPane.BOTTOM_LEFT;
            i7 = 0;
        }
        pane.setState(STPaneState.FROZEN);
        pane.setTopLeftCell(new CellReference(i8, i7).formatAsString());
        pane.setActivePane(r6);
        defaultSheetView.addNewSelection().setPane(r6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFRow createRow(int i5) {
        CTRow cTRowAddNewRow;
        Integer numValueOf = Integer.valueOf(i5);
        XSSFRow xSSFRow = this._rows.get(numValueOf);
        if (xSSFRow != null) {
            while (xSSFRow.getFirstCellNum() != -1) {
                xSSFRow.removeCell(xSSFRow.getCell((int) xSSFRow.getFirstCellNum()));
            }
            cTRowAddNewRow = xSSFRow.getCTRow();
            cTRowAddNewRow.set(CTRow.Factory.newInstance());
        } else if (this._rows.isEmpty() || i5 > this._rows.lastKey().intValue()) {
            cTRowAddNewRow = this.worksheet.getSheetData().addNewRow();
        } else {
            cTRowAddNewRow = this.worksheet.getSheetData().insertNewRow(this._rows.headMap(numValueOf).size());
        }
        XSSFRow xSSFRow2 = new XSSFRow(cTRowAddNewRow, this);
        xSSFRow2.setRowNum(i5);
        this._rows.put(numValueOf, xSSFRow2);
        return xSSFRow2;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFComment getCellComment(CellAddress cellAddress) {
        Comments comments = this.sheetComments;
        if (comments == null) {
            return null;
        }
        return comments.findCellComment(cellAddress);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFDrawing getDrawingPatriarch() {
        CTDrawing cTDrawing = getCTDrawing();
        if (cTDrawing == null) {
            return null;
        }
        for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
            POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
            if (documentPart instanceof XSSFDrawing) {
                XSSFDrawing xSSFDrawing = (XSSFDrawing) documentPart;
                if (relationPart.getRelationship().getId().equals(cTDrawing.getId())) {
                    return xSSFDrawing;
                }
            }
        }
        LOG.atError().log("Can't find drawing with id={} in the list of the sheet's relationships", cTDrawing.getId());
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public double getMargin(PageMargin pageMargin) {
        if (!this.worksheet.isSetPageMargins()) {
            return 0.0d;
        }
        CTPageMargins pageMargins = this.worksheet.getPageMargins();
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$PageMargin[pageMargin.ordinal()]) {
            case 1:
                return pageMargins.getLeft();
            case 2:
                return pageMargins.getRight();
            case 3:
                return pageMargins.getTop();
            case 4:
                return pageMargins.getBottom();
            case 5:
                return pageMargins.getHeader();
            case 6:
                return pageMargins.getFooter();
            default:
                throw new IllegalArgumentException("Unknown margin constant:  " + pageMargin);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFPrintSetup getPrintSetup() {
        return new XSSFPrintSetup(this.worksheet);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFRow getRow(int i5) {
        return this._rows.get(Integer.valueOf(i5));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFSheetConditionalFormatting getSheetConditionalFormatting() {
        return new XSSFSheetConditionalFormatting(this);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFWorkbook getWorkbook() {
        return (XSSFWorkbook) getParent();
    }

    @Internal
    public void removeHyperlink(int i5, int i6) {
        boolean z6;
        XSSFHyperlink hyperlink = getHyperlink(i5, i6);
        if (hyperlink != null) {
            if (hyperlink.getFirstRow() == i5 && hyperlink.getLastRow() == i5 && hyperlink.getFirstColumn() == i6 && hyperlink.getLastColumn() == i6) {
                removeHyperlink(hyperlink);
                return;
            }
            boolean z7 = false;
            if (hyperlink.getFirstColumn() < i6) {
                XSSFHyperlink xSSFHyperlink = new XSSFHyperlink(hyperlink);
                xSSFHyperlink.setFirstColumn(hyperlink.getFirstColumn());
                xSSFHyperlink.setLastColumn(i6 - 1);
                xSSFHyperlink.setFirstRow(hyperlink.getFirstRow());
                xSSFHyperlink.setLastRow(hyperlink.getLastRow());
                addHyperlink(xSSFHyperlink);
                z6 = true;
            } else {
                z6 = false;
            }
            if (hyperlink.getLastColumn() > i6) {
                XSSFHyperlink xSSFHyperlink2 = new XSSFHyperlink(hyperlink);
                xSSFHyperlink2.setFirstColumn(i6 + 1);
                xSSFHyperlink2.setLastColumn(hyperlink.getLastColumn());
                xSSFHyperlink2.setFirstRow(hyperlink.getFirstRow());
                xSSFHyperlink2.setLastRow(hyperlink.getLastRow());
                addHyperlink(xSSFHyperlink2);
                z7 = true;
            }
            if (hyperlink.getFirstRow() < i5) {
                XSSFHyperlink xSSFHyperlink3 = new XSSFHyperlink(hyperlink);
                int firstColumn = z6 ? i5 : hyperlink.getFirstColumn();
                int lastColumn = z7 ? i5 : hyperlink.getLastColumn();
                xSSFHyperlink3.setFirstColumn(firstColumn);
                xSSFHyperlink3.setLastColumn(lastColumn);
                xSSFHyperlink3.setFirstRow(hyperlink.getFirstRow());
                xSSFHyperlink3.setLastRow(i5 - 1);
                addHyperlink(xSSFHyperlink3);
            }
            if (hyperlink.getLastRow() > i5) {
                XSSFHyperlink xSSFHyperlink4 = new XSSFHyperlink(hyperlink);
                int firstColumn2 = z6 ? i5 : hyperlink.getFirstColumn();
                int lastColumn2 = z7 ? i5 : hyperlink.getLastColumn();
                xSSFHyperlink4.setFirstColumn(firstColumn2);
                xSSFHyperlink4.setLastColumn(lastColumn2);
                xSSFHyperlink4.setFirstRow(i5 + 1);
                xSSFHyperlink4.setLastRow(hyperlink.getLastRow());
                addHyperlink(xSSFHyperlink4);
            }
            removeHyperlink(hyperlink);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFAutoFilter setAutoFilter(CellRangeAddress cellRangeAddress) {
        CTAutoFilter autoFilter = this.worksheet.getAutoFilter();
        if (autoFilter == null) {
            autoFilter = this.worksheet.addNewAutoFilter();
        }
        autoFilter.setRef(new CellRangeAddress(cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn()).formatAsString());
        XSSFWorkbook workbook = getWorkbook();
        int sheetIndex = getWorkbook().getSheetIndex(this);
        XSSFName builtInName = workbook.getBuiltInName(XSSFName.BUILTIN_FILTER_DB, sheetIndex);
        if (builtInName == null) {
            builtInName = workbook.createBuiltInName(XSSFName.BUILTIN_FILTER_DB, sheetIndex);
        }
        builtInName.getCTName().setHidden(true);
        builtInName.setRefersToFormula(new CellReference(getSheetName(), cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn(), true, true).formatAsString() + ParameterizedMessage.ERROR_MSG_SEPARATOR + new CellReference(null, cellRangeAddress.getLastRow(), cellRangeAddress.getLastColumn(), true, true).formatAsString());
        return new XSSFAutoFilter(this);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftRows(int i5, int i6, int i7, boolean z6, boolean z7) {
        ArrayList arrayList = new ArrayList();
        for (XSSFTable xSSFTable : getTables()) {
            if (xSSFTable.getStartRowIndex() >= i5 || xSSFTable.getEndRowIndex() >= i5) {
                if (xSSFTable.getStartRowIndex() <= i6 || xSSFTable.getEndRowIndex() <= i6) {
                    arrayList.add(xSSFTable);
                }
            }
        }
        int sheetIndex = getWorkbook().getSheetIndex(this);
        FormulaShifter formulaShifterCreateForRowShift = FormulaShifter.createForRowShift(sheetIndex, getWorkbook().getSheetName(sheetIndex), i5, i6, i7, SpreadsheetVersion.EXCEL2007);
        removeOverwritten(i5, i6, i7);
        shiftCommentsAndRows(i5, i6, i7);
        XSSFRowShifter xSSFRowShifter = new XSSFRowShifter(this);
        xSSFRowShifter.shiftMergedRegions(i5, i6, i7);
        xSSFRowShifter.updateNamedRanges(formulaShifterCreateForRowShift);
        xSSFRowShifter.updateFormulas(formulaShifterCreateForRowShift);
        xSSFRowShifter.updateConditionalFormatting(formulaShifterCreateForRowShift);
        xSSFRowShifter.updateHyperlinks(formulaShifterCreateForRowShift);
        rebuildRows();
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            rebuildTableFormulas((XSSFTable) obj);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFHyperlink getHyperlink(int i5, int i6) {
        return getHyperlink(new CellAddress(i5, i6));
    }

    private void addIgnoredErrors(String str, IgnoredErrorType... ignoredErrorTypeArr) {
        XSSFIgnoredErrorHelper.addIgnoredErrors((this.worksheet.isSetIgnoredErrors() ? this.worksheet.getIgnoredErrors() : this.worksheet.addNewIgnoredErrors()).addNewIgnoredError(), str, ignoredErrorTypeArr);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFHyperlink getHyperlink(CellAddress cellAddress) {
        for (XSSFHyperlink xSSFHyperlink : getHyperlinkList()) {
            if (cellAddress.getRow() >= xSSFHyperlink.getFirstRow() && cellAddress.getRow() <= xSSFHyperlink.getLastRow() && cellAddress.getColumn() >= xSSFHyperlink.getFirstColumn() && cellAddress.getColumn() <= xSSFHyperlink.getLastColumn()) {
                return xSSFHyperlink;
            }
        }
        return null;
    }

    public XSSFSheet(PackagePart packagePart) {
        super(packagePart);
        this._rows = new TreeMap();
        this.dataValidationHelper = new XSSFDataValidationHelper(this);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createSplitPane(int i5, int i6, int i7, int i8, PaneType paneType) {
        STPane.Enum r6;
        createFreezePane(i5, i6, i7, i8);
        if (i5 > 0 || i6 > 0) {
            CTPane pane = getPane(true);
            pane.setState(STPaneState.SPLIT);
            int i9 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$PaneType[paneType.ordinal()];
            if (i9 == 1) {
                r6 = STPane.BOTTOM_RIGHT;
            } else if (i9 == 2) {
                r6 = STPane.TOP_RIGHT;
            } else if (i9 != 3) {
                r6 = STPane.TOP_LEFT;
            } else {
                r6 = STPane.BOTTOM_LEFT;
            }
            pane.setActivePane(r6);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void validateMergedRegions() {
        checkForMergedRegionsIntersectingArrayFormulas();
        checkForIntersectingMergedRegions();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setMargin(PageMargin pageMargin, double d) {
        CTPageMargins pageMargins = this.worksheet.isSetPageMargins() ? this.worksheet.getPageMargins() : this.worksheet.addNewPageMargins();
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$PageMargin[pageMargin.ordinal()]) {
            case 1:
                pageMargins.setLeft(d);
                return;
            case 2:
                pageMargins.setRight(d);
                return;
            case 3:
                pageMargins.setTop(d);
                return;
            case 4:
                pageMargins.setBottom(d);
                return;
            case 5:
                pageMargins.setHeader(d);
                return;
            case 6:
                pageMargins.setFooter(d);
                return;
            default:
                throw new IllegalArgumentException("Unknown margin constant:  " + pageMargin);
        }
    }

    public XSSFPivotTable createPivotTable(AreaReference areaReference, CellReference cellReference, Sheet sheet) {
        String sheetName = areaReference.getFirstCell().getSheetName();
        if (sheetName != null && !sheetName.equalsIgnoreCase(sheet.getSheetName())) {
            throw new IllegalArgumentException("The area is referenced in another sheet than the defined source sheet " + sheet.getSheetName() + Consts.DOT);
        }
        return createPivotTable(cellReference, sheet, new g(areaReference, 7));
    }

    private XSSFPivotTable createPivotTable(CellReference cellReference, Sheet sheet, XSSFPivotTable.PivotTableReferenceConfigurator pivotTableReferenceConfigurator) {
        XSSFPivotTable xSSFPivotTableCreatePivotTable = createPivotTable();
        xSSFPivotTableCreatePivotTable.setDefaultPivotTableDefinition();
        xSSFPivotTableCreatePivotTable.createSourceReferences(cellReference, sheet, pivotTableReferenceConfigurator);
        xSSFPivotTableCreatePivotTable.getPivotCacheDefinition().createCacheFields(sheet);
        xSSFPivotTableCreatePivotTable.createDefaultDataColumns();
        return xSSFPivotTableCreatePivotTable;
    }

    public XSSFPivotTable createPivotTable(AreaReference areaReference, CellReference cellReference) {
        String sheetName = areaReference.getFirstCell().getSheetName();
        if (sheetName != null && !sheetName.equalsIgnoreCase(getSheetName())) {
            return createPivotTable(areaReference, cellReference, getWorkbook().getSheet(sheetName));
        }
        return createPivotTable(areaReference, cellReference, this);
    }

    public XSSFPivotTable createPivotTable(Name name, CellReference cellReference, Sheet sheet) {
        if (name.getSheetName() != null && !name.getSheetName().equals(sheet.getSheetName())) {
            throw new IllegalArgumentException("The named range references another sheet than the defined source sheet " + sheet.getSheetName() + Consts.DOT);
        }
        return createPivotTable(cellReference, sheet, new g(name, 5));
    }

    public XSSFPivotTable createPivotTable(Name name, CellReference cellReference) {
        return createPivotTable(name, cellReference, getWorkbook().getSheet(name.getSheetName()));
    }

    public void copyRows(int i5, int i6, int i7, CellCopyPolicy cellCopyPolicy) {
        copyRows(getRows(i5, i6, false), i7, cellCopyPolicy);
    }

    public XSSFPivotTable createPivotTable(Table table, CellReference cellReference) {
        return createPivotTable(cellReference, getWorkbook().getSheet(table.getSheetName()), new g(table, 6));
    }
}
