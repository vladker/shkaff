package org.apache.poi.hssf.usermodel;

import A3.AbstractC0157z;
import androidx.core.view.MotionEventCompat;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.util.Supplier;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hssf.model.DrawingManager2;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.AutoFilterInfoRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.DVRecord;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.DrawingRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SCLRecord;
import org.apache.poi.hssf.record.WSBoolRecord;
import org.apache.poi.hssf.record.WindowTwoRecord;
import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.apache.poi.hssf.record.aggregates.FormulaRecordAggregate;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
import org.apache.poi.hssf.usermodel.helpers.HSSFColumnShifter;
import org.apache.poi.hssf.usermodel.helpers.HSSFRowShifter;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.PageMargin;
import org.apache.poi.ss.usermodel.PaneType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Shape;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.poi.ss.util.SSCellRange;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.util.Configurator;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFSheet implements Sheet {
    private static final float PX_DEFAULT = 32.0f;
    private static final float PX_MODIFIED = 36.56f;
    protected final InternalWorkbook _book;
    private int _firstrow;
    private int _lastrow;
    private HSSFPatriarch _patriarch;
    private final TreeMap<Integer, HSSFRow> _rows;
    private final InternalSheet _sheet;
    protected final HSSFWorkbook _workbook;
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) HSSFSheet.class);
    public static final int INITIAL_CAPACITY = Configurator.getIntValue("HSSFSheet.RowInitialCapacity", 20);

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFSheet$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$PageMargin;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$PaneType;

        static {
            int[] iArr = new int[PaneType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$PaneType = iArr;
            try {
                iArr[PaneType.LOWER_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PaneType[PaneType.UPPER_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PaneType[PaneType.LOWER_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PaneType[PaneType.UPPER_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[PageMargin.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$PageMargin = iArr2;
            try {
                iArr2[PageMargin.FOOTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$PageMargin[PageMargin.HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public HSSFSheet(HSSFWorkbook hSSFWorkbook) {
        this._firstrow = -1;
        this._lastrow = -1;
        this._sheet = InternalSheet.createSheet();
        this._rows = new TreeMap<>();
        this._workbook = hSSFWorkbook;
        this._book = hSSFWorkbook.getWorkbook();
    }

    private void addRow(HSSFRow hSSFRow, boolean z6) {
        this._rows.put(Integer.valueOf(hSSFRow.getRowNum()), hSSFRow);
        if (z6) {
            this._sheet.addRow(hSSFRow.getRowRecord());
        }
        boolean z7 = this._rows.size() == 1;
        if (hSSFRow.getRowNum() > getLastRowNum() || z7) {
            this._lastrow = hSSFRow.getRowNum();
        }
        if (hSSFRow.getRowNum() < getFirstRowNum() || z7) {
            this._firstrow = hSSFRow.getRowNum();
        }
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

    private static int clip(int i5) {
        return Math.min(Math.max(0, i5), SpreadsheetVersion.EXCEL97.getLastRowIndex());
    }

    private HSSFRow createRowFromRecord(RowRecord rowRecord) {
        HSSFRow hSSFRow = new HSSFRow(this._workbook, this, rowRecord);
        addRow(hSSFRow, false);
        return hSSFRow;
    }

    private void deleteOverwrittenHyperlinksForRowShift(int i5, int i6, int i7) {
        int i8 = i5 + i7;
        int i9 = i6 + i7;
        for (HSSFHyperlink hSSFHyperlink : getHyperlinkList()) {
            int firstRow = hSSFHyperlink.getFirstRow();
            int lastRow = hSSFHyperlink.getLastRow();
            if (i8 <= firstRow && firstRow <= i9 && i9 <= lastRow && lastRow <= i9) {
                removeHyperlink(hSSFHyperlink);
            }
        }
    }

    private void findCellCommentLocations(HSSFShapeContainer hSSFShapeContainer, Map<CellAddress, HSSFComment> map) {
        for (HSSFShape hSSFShape : hSSFShapeContainer.getChildren()) {
            if (hSSFShape instanceof HSSFShapeGroup) {
                findCellCommentLocations((HSSFShapeGroup) hSSFShape, map);
            } else if (hSSFShape instanceof HSSFComment) {
                HSSFComment hSSFComment = (HSSFComment) hSSFShape;
                if (hSSFComment.hasPosition()) {
                    map.put(new CellAddress(hSSFComment.getRow(), hSSFComment.getColumn()), hSSFComment);
                }
            }
        }
    }

    private int findFirstRow(int i5) {
        int i6 = i5 + 1;
        HSSFRow row = getRow(i6);
        while (row == null && i6 <= getLastRowNum()) {
            i6++;
            row = getRow(i6);
        }
        if (i6 > getLastRowNum()) {
            return 0;
        }
        return i6;
    }

    private int findLastRow(int i5) {
        if (i5 < 1) {
            return 0;
        }
        int i6 = i5 - 1;
        HSSFRow row = getRow(i6);
        while (row == null && i6 > 0) {
            i6--;
            row = getRow(i6);
        }
        if (row == null) {
            return 0;
        }
        return i6;
    }

    private NameRecord getBuiltinNameRecord(byte b) {
        int iFindExistingBuiltinNameRecordIdx = this._workbook.findExistingBuiltinNameRecordIdx(this._workbook.getSheetIndex(this), b);
        if (iFindExistingBuiltinNameRecordIdx == -1) {
            return null;
        }
        return this._workbook.getNameRecord(iFindExistingBuiltinNameRecordIdx);
    }

    private CellRange<HSSFCell> getCellRange(CellRangeAddress cellRangeAddress) {
        int firstRow = cellRangeAddress.getFirstRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        int i5 = (lastRow - firstRow) + 1;
        int i6 = (lastColumn - firstColumn) + 1;
        ArrayList arrayList = new ArrayList(i5 * i6);
        for (int i7 = firstRow; i7 <= lastRow; i7++) {
            for (int i8 = firstColumn; i8 <= lastColumn; i8++) {
                HSSFRow row = getRow(i7);
                if (row == null) {
                    row = createRow(i7);
                }
                HSSFCell cell = row.getCell(i8);
                if (cell == null) {
                    cell = row.createCell(i8);
                }
                arrayList.add(cell);
            }
        }
        return SSCellRange.create(firstRow, firstColumn, i5, i6, arrayList, HSSFCell.class);
    }

    private HSSFPatriarch getPatriarch(boolean z6) {
        HSSFPatriarch hSSFPatriarch = this._patriarch;
        if (hSSFPatriarch != null) {
            return hSSFPatriarch;
        }
        DrawingManager2 drawingManager2FindDrawingGroup = this._book.findDrawingGroup();
        if (drawingManager2FindDrawingGroup == null) {
            if (!z6) {
                return null;
            }
            this._book.createDrawingGroup();
            drawingManager2FindDrawingGroup = this._book.getDrawingManager();
        }
        EscherAggregate escherAggregate = (EscherAggregate) this._sheet.findFirstRecordBySid(EscherAggregate.sid);
        if (escherAggregate == null) {
            int iAggregateDrawingRecords = this._sheet.aggregateDrawingRecords(drawingManager2FindDrawingGroup, false);
            if (-1 == iAggregateDrawingRecords) {
                if (!z6) {
                    return null;
                }
                HSSFPatriarch hSSFPatriarch2 = new HSSFPatriarch(this, (EscherAggregate) this._sheet.getRecords().get(this._sheet.aggregateDrawingRecords(drawingManager2FindDrawingGroup, true)));
                hSSFPatriarch2.afterCreate();
                return hSSFPatriarch2;
            }
            escherAggregate = (EscherAggregate) this._sheet.getRecords().get(iAggregateDrawingRecords);
        }
        return new HSSFPatriarch(this, escherAggregate);
    }

    private WorksheetProtectionBlock getProtectionBlock() {
        return this._sheet.getProtectionBlock();
    }

    private CellRangeAddress getRepeatingRowsOrColumns(boolean z6) {
        Ptg[] nameDefinition;
        NameRecord builtinNameRecord = getBuiltinNameRecord((byte) 7);
        if (builtinNameRecord == null || (nameDefinition = builtinNameRecord.getNameDefinition()) == null) {
            return null;
        }
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL97;
        int lastRowIndex = spreadsheetVersion.getLastRowIndex();
        int lastColumnIndex = spreadsheetVersion.getLastColumnIndex();
        for (Ptg ptg : nameDefinition) {
            if (ptg instanceof Area3DPtg) {
                Area3DPtg area3DPtg = (Area3DPtg) ptg;
                if (area3DPtg.getFirstColumn() == 0 && area3DPtg.getLastColumn() == lastColumnIndex) {
                    if (z6) {
                        return new CellRangeAddress(area3DPtg.getFirstRow(), area3DPtg.getLastRow(), -1, -1);
                    }
                } else if (area3DPtg.getFirstRow() == 0 && area3DPtg.getLastRow() == lastRowIndex && !z6) {
                    return new CellRangeAddress(-1, -1, area3DPtg.getFirstColumn(), area3DPtg.getLastColumn());
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Message lambda$setPropertiesFromSheet$0(CellValueRecordInterface cellValueRecordInterface) {
        if (cellValueRecordInterface instanceof Record) {
            return new SimpleMessage("record id = " + Integer.toHexString(((Record) cellValueRecordInterface).getSid()));
        }
        return new SimpleMessage("record = " + cellValueRecordInterface);
    }

    private HSSFComment lookForComment(HSSFShapeContainer hSSFShapeContainer, int i5, int i6) {
        for (Shape shape : hSSFShapeContainer.getChildren()) {
            if (shape instanceof HSSFShapeGroup) {
                HSSFComment hSSFCommentLookForComment = lookForComment((HSSFShapeContainer) shape, i5, i6);
                if (hSSFCommentLookForComment != null) {
                    return hSSFCommentLookForComment;
                }
            } else if (shape instanceof HSSFComment) {
                HSSFComment hSSFComment = (HSSFComment) shape;
                if (hSSFComment.hasPosition() && hSSFComment.getColumn() == i6 && hSSFComment.getRow() == i5) {
                    return hSSFComment;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    private void moveCommentsForRowShift(int i5, int i6, int i7) {
        HSSFComment hSSFComment;
        int row;
        for (HSSFShape hSSFShape : createDrawingPatriarch().getChildren()) {
            if ((hSSFShape instanceof HSSFComment) && i5 <= (row = (hSSFComment = (HSSFComment) hSSFShape).getRow()) && row <= i6) {
                hSSFComment.setRow(clip(row + i7));
            }
        }
    }

    private void notifyRowShifting(HSSFRow hSSFRow) {
        String str = "Row[rownum=" + hSSFRow.getRowNum() + "] contains cell(s) included in a multi-cell array formula. You cannot change part of an array.";
        Iterator<Cell> it = hSSFRow.iterator();
        while (it.hasNext()) {
            HSSFCell hSSFCell = (HSSFCell) it.next();
            if (hSSFCell.isPartOfArrayFormulaGroup()) {
                hSSFCell.tryToDeleteArrayFormula(str);
            }
        }
    }

    private void recomputeFirstAndLastRowsForRowShift(int i5, int i6, int i7) {
        if (i7 > 0) {
            if (i5 == this._firstrow) {
                int i8 = i5 + i7;
                this._firstrow = Math.max(i8, 0);
                while (true) {
                    i5++;
                    if (i5 < i8) {
                        if (getRow(i5) != null) {
                            this._firstrow = i5;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            int i9 = i6 + i7;
            if (i9 > this._lastrow) {
                this._lastrow = Math.min(i9, SpreadsheetVersion.EXCEL97.getLastRowIndex());
                return;
            }
            return;
        }
        int i10 = i5 + i7;
        if (i10 < this._firstrow) {
            this._firstrow = Math.max(i10, 0);
        }
        if (i6 == this._lastrow) {
            int i11 = i7 + i6;
            this._lastrow = Math.min(i11, SpreadsheetVersion.EXCEL97.getLastRowIndex());
            for (int i12 = i6 - 1; i12 > i11; i12--) {
                if (getRow(i12) != null) {
                    this._lastrow = i12;
                    return;
                }
            }
        }
    }

    private void setPropertiesFromSheet(InternalSheet internalSheet) {
        HSSFRow hSSFRow;
        RowRecord nextRow = internalSheet.getNextRow();
        while (nextRow != null) {
            createRowFromRecord(nextRow);
            nextRow = internalSheet.getNextRow();
        }
        Iterator<CellValueRecordInterface> cellValueIterator = internalSheet.getCellValueIterator();
        long jCurrentTimeMillis = System.currentTimeMillis();
        LOGGER.atDebug().log("Time at start of cell creating in HSSF sheet = {}", Unbox.box(jCurrentTimeMillis));
        HSSFRow row = null;
        while (cellValueIterator.hasNext()) {
            CellValueRecordInterface next = cellValueIterator.next();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if ((row == null || row.getRowNum() != next.getRow()) && (row = getRow(next.getRow())) == null) {
                RowRecord rowRecord = new RowRecord(next.getRow());
                internalSheet.addRow(rowRecord);
                HSSFRow hSSFRowCreateRowFromRecord = createRowFromRecord(rowRecord);
                hSSFRow = row;
                row = hSSFRowCreateRowFromRecord;
            } else {
                hSSFRow = row;
            }
            Logger logger = LOGGER;
            logger.atTrace().log((Supplier<Message>) new Y2.a(next, 29));
            row.createCellFromRecord(next);
            logger.atTrace().log("record took {}ms", Unbox.box(System.currentTimeMillis() - jCurrentTimeMillis2));
            row = hSSFRow;
        }
        LOGGER.atDebug().log("total sheet cell creation took {}ms", Unbox.box(System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void setRepeatingRowsAndColumns(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        int i5;
        int i6;
        int i7;
        int i8;
        short s6;
        ArrayList arrayList;
        ArrayList arrayList2;
        int sheetIndex = this._workbook.getSheetIndex(this);
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL97;
        int lastRowIndex = spreadsheetVersion.getLastRowIndex();
        int lastColumnIndex = spreadsheetVersion.getLastColumnIndex();
        if (cellRangeAddress != null) {
            int firstRow = cellRangeAddress.getFirstRow();
            int lastRow = cellRangeAddress.getLastRow();
            if ((firstRow == -1 && lastRow != -1) || firstRow > lastRow || firstRow < 0 || firstRow > lastRowIndex || lastRow < 0 || lastRow > lastRowIndex) {
                throw new IllegalArgumentException("Invalid row range specification");
            }
            i5 = firstRow;
            i6 = lastRow;
        } else {
            i5 = -1;
            i6 = -1;
        }
        if (cellRangeAddress2 != null) {
            int firstColumn = cellRangeAddress2.getFirstColumn();
            int lastColumn = cellRangeAddress2.getLastColumn();
            if ((firstColumn == -1 && lastColumn != -1) || firstColumn > lastColumn || firstColumn < 0 || firstColumn > lastColumnIndex || lastColumn < 0 || lastColumn > lastColumnIndex) {
                throw new IllegalArgumentException("Invalid column range specification");
            }
            i8 = lastColumn;
            i7 = firstColumn;
        } else {
            i7 = -1;
            i8 = -1;
        }
        short sCheckExternSheet = this._workbook.getWorkbook().checkExternSheet(sheetIndex);
        boolean z6 = (cellRangeAddress == null || cellRangeAddress2 == null) ? false : true;
        boolean z7 = cellRangeAddress == null && cellRangeAddress2 == null;
        HSSFName builtInName = this._workbook.getBuiltInName((byte) 7, sheetIndex);
        if (z7) {
            if (builtInName != null) {
                this._workbook.removeName(builtInName);
                return;
            }
            return;
        }
        if (builtInName == null) {
            builtInName = this._workbook.createBuiltInName((byte) 7, sheetIndex);
        }
        HSSFName hSSFName = builtInName;
        ArrayList arrayList3 = new ArrayList();
        if (z6) {
            arrayList3.add(new MemFuncPtg(23));
        }
        if (cellRangeAddress2 != null) {
            s6 = sCheckExternSheet;
            arrayList = arrayList3;
            arrayList.add(new Area3DPtg(0, lastRowIndex, i7, i8, false, false, false, false, s6));
        } else {
            s6 = sCheckExternSheet;
            arrayList = arrayList3;
        }
        if (cellRangeAddress != null) {
            arrayList2 = arrayList;
            arrayList2.add(new Area3DPtg(i5, i6, 0, lastColumnIndex, false, false, false, false, s6));
        } else {
            arrayList2 = arrayList;
        }
        if (z6) {
            arrayList2.add(UnionPtg.instance);
        }
        Ptg[] ptgArr = new Ptg[arrayList2.size()];
        arrayList2.toArray(ptgArr);
        hSSFName.setNameDefinition(ptgArr);
        getPrintSetup().setValidSettings(false);
        setActive(true);
    }

    private void updateFormulasForShift(FormulaShifter formulaShifter) {
        this._sheet.updateFormulasAfterCellShift(formulaShifter, this._book.checkExternSheet(this._workbook.getSheetIndex(this)));
        int numberOfSheets = this._workbook.getNumberOfSheets();
        for (int i5 = 0; i5 < numberOfSheets; i5++) {
            InternalSheet sheet = this._workbook.getSheetAt(i5).getSheet();
            if (sheet != this._sheet) {
                sheet.updateFormulasAfterCellShift(formulaShifter, this._book.checkExternSheet(i5));
            }
        }
        this._workbook.getWorkbook().updateNamesAfterCellShift(formulaShifter);
    }

    private void validateArrayFormulas(CellRangeAddress cellRangeAddress) {
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            HSSFRow row = getRow(firstRow);
            if (row != null) {
                for (int i5 = firstColumn; i5 <= lastColumn; i5++) {
                    HSSFCell cell = row.getCell(i5);
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
        if (dataValidation == null) {
            throw new IllegalArgumentException("objValidation must not be null");
        }
        this._sheet.getOrCreateDataValidityTable().addDataValidation(((HSSFDataValidation) dataValidation).createDVRecord(this));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void autoSizeColumn(int i5) {
        autoSizeColumn(i5, false);
    }

    public HSSFSheet cloneSheet(HSSFWorkbook hSSFWorkbook) {
        getDrawingPatriarch();
        HSSFSheet hSSFSheet = new HSSFSheet(hSSFWorkbook, this._sheet.cloneSheet());
        int iFindFirstRecordLocBySid = hSSFSheet._sheet.findFirstRecordLocBySid((short) 236);
        DrawingRecord drawingRecord = (DrawingRecord) hSSFSheet._sheet.findFirstRecordBySid((short) 236);
        if (drawingRecord != null) {
            hSSFSheet._sheet.getRecords().remove(drawingRecord);
        }
        if (getDrawingPatriarch() != null) {
            HSSFPatriarch hSSFPatriarchCreatePatriarch = HSSFPatriarch.createPatriarch(getDrawingPatriarch(), hSSFSheet);
            hSSFSheet._sheet.getRecords().add(iFindFirstRecordLocBySid, hSSFPatriarchCreatePatriarch.getBoundAggregate());
            hSSFSheet._patriarch = hSSFPatriarchCreatePatriarch;
        }
        return hSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i5, int i6, int i7, int i8) {
        validateColumn(i5);
        validateRow(i6);
        if (i7 < i5) {
            throw new IllegalArgumentException("leftmostColumn parameter must not be less than colSplit parameter");
        }
        if (i8 < i6) {
            throw new IllegalArgumentException("topRow parameter must not be less than leftmostColumn parameter");
        }
        getSheet().createFreezePane(i5, i6, i8, i7);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @Removal(version = "7.0.0")
    @Deprecated
    public void createSplitPane(int i5, int i6, int i7, int i8, int i9) {
        getSheet().createSplitPane(i5, i6, i8, i7, i9);
    }

    public void dumpDrawingRecords(boolean z6, PrintWriter printWriter) {
        this._sheet.aggregateDrawingRecords(this._book.getDrawingManager(), false);
        for (EscherRecord escherRecord : ((EscherAggregate) getSheet().findFirstRecordBySid(EscherAggregate.sid)).getEscherRecords()) {
            if (z6) {
                printWriter.println(escherRecord);
            } else {
                escherRecord.display(printWriter, 0);
            }
        }
        printWriter.flush();
    }

    public HSSFComment findCellComment(int i5, int i6) {
        HSSFPatriarch drawingPatriarch = getDrawingPatriarch();
        if (drawingPatriarch == null) {
            drawingPatriarch = createDrawingPatriarch();
        }
        return lookForComment(drawingPatriarch, i5, i6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellAddress getActiveCell() {
        return new CellAddress(this._sheet.getActiveCellRow(), this._sheet.getActiveCellCol());
    }

    public boolean getAlternateExpression() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getAlternateExpression();
    }

    public boolean getAlternateFormula() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getAlternateFormula();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getAutobreaks() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getAutobreaks();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Map<CellAddress, HSSFComment> getCellComments() {
        HSSFPatriarch drawingPatriarch = getDrawingPatriarch();
        if (drawingPatriarch == null) {
            drawingPatriarch = createDrawingPatriarch();
        }
        TreeMap treeMap = new TreeMap();
        findCellCommentLocations(drawingPatriarch, treeMap);
        return treeMap;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int[] getColumnBreaks() {
        return this._sheet.getPageSettings().getColumnBreaks();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnOutlineLevel(int i5) {
        return this._sheet.getColumnOutlineLevel(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getColumnWidth(int i5) {
        return this._sheet.getColumnWidth(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getColumnWidthInPixels(int i5) {
        int columnWidth = getColumnWidth(i5);
        return columnWidth / (columnWidth == getDefaultColumnWidth() * 256 ? PX_DEFAULT : PX_MODIFIED);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public DataValidationHelper getDataValidationHelper() {
        return new HSSFDataValidationHelper(this);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<HSSFDataValidation> getDataValidations() {
        DataValidityTable orCreateDataValidityTable = this._sheet.getOrCreateDataValidityTable();
        final ArrayList arrayList = new ArrayList();
        orCreateDataValidityTable.visitContainedRecords(new RecordAggregate.RecordVisitor() { // from class: org.apache.poi.hssf.usermodel.HSSFSheet.1
            private HSSFEvaluationWorkbook book;

            {
                this.book = HSSFEvaluationWorkbook.create(HSSFSheet.this.getWorkbook());
            }

            @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
            public void visitRecord(Record record) {
                if (record instanceof DVRecord) {
                    DVRecord dVRecord = (DVRecord) record;
                    HSSFDataValidation hSSFDataValidation = new HSSFDataValidation(dVRecord.getCellRangeAddress().copy(), DVConstraint.createDVConstraint(dVRecord, this.book));
                    hSSFDataValidation.setErrorStyle(dVRecord.getErrorStyle());
                    hSSFDataValidation.setEmptyCellAllowed(dVRecord.getEmptyCellAllowed());
                    hSSFDataValidation.setSuppressDropDownArrow(dVRecord.getSuppressDropdownArrow());
                    hSSFDataValidation.createPromptBox(dVRecord.getPromptTitle(), dVRecord.getPromptText());
                    hSSFDataValidation.setShowPromptBox(dVRecord.getShowPromptOnCellSelected());
                    hSSFDataValidation.createErrorBox(dVRecord.getErrorTitle(), dVRecord.getErrorText());
                    hSSFDataValidation.setShowErrorBox(dVRecord.getShowErrorOnInvalidValue());
                    arrayList.add(hSSFDataValidation);
                }
            }
        });
        return arrayList;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getDefaultColumnWidth() {
        return this._sheet.getDefaultColumnWidth();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getDefaultRowHeight() {
        return this._sheet.getDefaultRowHeight();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public float getDefaultRowHeightInPoints() {
        return this._sheet.getDefaultRowHeight() / 20.0f;
    }

    public boolean getDialog() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getDialog();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getDisplayGuts() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getDisplayGuts();
    }

    public EscherAggregate getDrawingEscherAggregate() {
        this._book.findDrawingGroup();
        if (this._book.getDrawingManager() == null || this._sheet.aggregateDrawingRecords(this._book.getDrawingManager(), false) == -1) {
            return null;
        }
        return (EscherAggregate) this._sheet.findFirstRecordBySid(EscherAggregate.sid);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getFirstRowNum() {
        return this._firstrow;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getFitToPage() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getFitToPage();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getForceFormulaRecalculation() {
        return this._sheet.getUncalced();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getHorizontallyCenter() {
        return this._sheet.getPageSettings().getHCenter().getHCenter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<HSSFHyperlink> getHyperlinkList() {
        ArrayList arrayList = new ArrayList();
        for (RecordBase recordBase : this._sheet.getRecords()) {
            if (recordBase instanceof HyperlinkRecord) {
                arrayList.add(new HSSFHyperlink((HyperlinkRecord) recordBase));
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getLastRowNum() {
        return this._lastrow;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getLeftCol() {
        return this._sheet.getLeftCol();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    @Removal(version = "7.0.0")
    @Deprecated
    public double getMargin(short s6) {
        return getMargin(PageMargin.getByShortValue(s6));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRangeAddress getMergedRegion(int i5) {
        return this._sheet.getMergedRegionAt(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<CellRangeAddress> getMergedRegions() {
        ArrayList arrayList = new ArrayList();
        int numMergedRegions = this._sheet.getNumMergedRegions();
        for (int i5 = 0; i5 < numMergedRegions; i5++) {
            arrayList.add(this._sheet.getMergedRegionAt(i5));
        }
        return arrayList;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getNumMergedRegions() {
        return this._sheet.getNumMergedRegions();
    }

    public boolean getObjectProtect() {
        return getProtectionBlock().isObjectProtected();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public PaneInformation getPaneInformation() {
        return getSheet().getPaneInformation();
    }

    public short getPassword() {
        return (short) getProtectionBlock().getPasswordHash();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getPhysicalNumberOfRows() {
        return this._rows.size();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getProtect() {
        return getProtectionBlock().isSheetProtected();
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
        return this._sheet.getPageSettings().getRowBreaks();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsBelow() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getRowSumsBelow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getRowSumsRight() {
        return ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).getRowSumsRight();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getScenarioProtect() {
        return getProtectionBlock().isScenarioProtected();
    }

    @Internal
    public InternalSheet getSheet() {
        return this._sheet;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public String getSheetName() {
        HSSFWorkbook workbook = getWorkbook();
        return workbook.getSheetName(workbook.getSheetIndex(this));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public short getTopRow() {
        return this._sheet.getTopRow();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean getVerticallyCenter() {
        return this._sheet.getPageSettings().getVCenter().getVCenter();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupColumn(int i5, int i6) {
        this._sheet.groupColumnRange(i5, i6, true);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void groupRow(int i5, int i6) {
        this._sheet.groupRowRange(i5, i6, true);
    }

    public void insertChartRecords(List<Record> list) {
        this._sheet.getRecords().addAll(this._sheet.findFirstRecordLocBySid(WindowTwoRecord.sid), list);
    }

    public boolean isActive() {
        return getSheet().getWindowTwo().isActive();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnBroken(int i5) {
        return this._sheet.getPageSettings().isColumnBroken(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isColumnHidden(int i5) {
        return this._sheet.isColumnHidden(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayFormulas() {
        return this._sheet.isDisplayFormulas();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayGridlines() {
        return this._sheet.isDisplayGridlines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayRowColHeadings() {
        return this._sheet.isDisplayRowColHeadings();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isDisplayZeros() {
        return this._sheet.getWindowTwo().getDisplayZeros();
    }

    public boolean isGridsPrinted() {
        return this._sheet.isGridsPrinted();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isPrintGridlines() {
        return getSheet().getPrintGridlines().getPrintGridlines();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isPrintRowAndColumnHeadings() {
        return getSheet().getPrintHeaders().getPrintHeaders();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRightToLeft() {
        return this._sheet.getWindowTwo().getArabic();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isRowBroken(int i5) {
        return this._sheet.getPageSettings().isRowBroken(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public boolean isSelected() {
        return getSheet().getWindowTwo().getSelected();
    }

    public void preSerialize() {
        HSSFPatriarch hSSFPatriarch = this._patriarch;
        if (hSSFPatriarch != null) {
            hSSFPatriarch.preSerialize();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void protectSheet(String str) {
        getProtectionBlock().protectSheet(str, true, true);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<HSSFCell> removeArrayFormula(Cell cell) {
        if (cell.getSheet() != this) {
            throw new IllegalArgumentException("Specified cell does not belong to this sheet.");
        }
        CellValueRecordInterface cellValueRecord = ((HSSFCell) cell).getCellValueRecord();
        if (!(cellValueRecord instanceof FormulaRecordAggregate)) {
            throw new IllegalArgumentException(AbstractC0157z.o("Cell ", new CellReference(cell).formatAsString(), " is not part of an array formula."));
        }
        CellRange<HSSFCell> cellRange = getCellRange(((FormulaRecordAggregate) cellValueRecord).removeArrayFormula(cell.getRowIndex(), cell.getColumnIndex()));
        Iterator<C> it = cellRange.iterator();
        while (it.hasNext()) {
            ((Cell) it.next()).setBlank();
        }
        return cellRange;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeColumnBreak(int i5) {
        this._sheet.getPageSettings().removeColumnBreak(i5);
    }

    public void removeHyperlink(HSSFHyperlink hSSFHyperlink) {
        removeHyperlink(hSSFHyperlink.record);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeMergedRegion(int i5) {
        this._sheet.removeMergedRegion(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeMergedRegions(Collection<Integer> collection) {
        Iterator it = new TreeSet(collection).descendingSet().iterator();
        while (it.hasNext()) {
            this._sheet.removeMergedRegion(((Integer) it.next()).intValue());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRow(Row row) {
        HSSFRow hSSFRow = (HSSFRow) row;
        if (row.getSheet() != this) {
            throw new IllegalArgumentException("Specified row does not belong to this sheet");
        }
        Iterator<Cell> it = row.iterator();
        while (it.hasNext()) {
            HSSFCell hSSFCell = (HSSFCell) it.next();
            if (hSSFCell.isPartOfArrayFormulaGroup()) {
                hSSFCell.tryToDeleteArrayFormula("Row[rownum=" + row.getRowNum() + "] contains cell(s) included in a multi-cell array formula. You cannot change part of an array.");
            }
        }
        if (this._rows.isEmpty()) {
            return;
        }
        if (this._rows.remove(Integer.valueOf(row.getRowNum())) != row) {
            throw new IllegalArgumentException("Specified row does not belong to this sheet");
        }
        if (hSSFRow.getRowNum() == getLastRowNum()) {
            this._lastrow = findLastRow(this._lastrow);
        }
        if (hSSFRow.getRowNum() == getFirstRowNum()) {
            this._firstrow = findFirstRow(this._firstrow);
        }
        this._sheet.removeRow(hSSFRow.getRowRecord());
        if (this._rows.isEmpty()) {
            this._firstrow = -1;
            this._lastrow = -1;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void removeRowBreak(int i5) {
        this._sheet.getPageSettings().removeRowBreak(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Iterator<Row> rowIterator() {
        return this._rows.values().iterator();
    }

    public void setActive(boolean z6) {
        getSheet().getWindowTwo().setActive(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setActiveCell(CellAddress cellAddress) {
        int row = cellAddress.getRow();
        short column = (short) cellAddress.getColumn();
        this._sheet.setActiveCellRow(row);
        this._sheet.setActiveCellCol(column);
    }

    public void setAlternativeExpression(boolean z6) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setAlternateExpression(z6);
    }

    public void setAlternativeFormula(boolean z6) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setAlternateFormula(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<HSSFCell> setArrayFormula(String str, CellRangeAddress cellRangeAddress) {
        Ptg[] ptgArr = HSSFFormulaParser.parse(str, this._workbook, FormulaType.ARRAY, this._workbook.getSheetIndex(this));
        CellRange<HSSFCell> cellRange = getCellRange(cellRangeAddress);
        Iterator<C> it = cellRange.iterator();
        while (it.hasNext()) {
            ((HSSFCell) it.next()).setCellArrayFormula(cellRangeAddress);
        }
        ((FormulaRecordAggregate) ((HSSFCell) cellRange.getTopLeftCell()).getCellValueRecord()).setArrayFormula(cellRangeAddress, ptgArr);
        return cellRange;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setAutobreaks(boolean z6) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setAutobreaks(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnBreak(int i5) {
        short s6 = (short) i5;
        validateColumn(s6);
        this._sheet.getPageSettings().setColumnBreak(s6, (short) 0, (short) SpreadsheetVersion.EXCEL97.getLastRowIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnGroupCollapsed(int i5, boolean z6) {
        this._sheet.setColumnGroupCollapsed(i5, z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnHidden(int i5, boolean z6) {
        this._sheet.setColumnHidden(i5, z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setColumnWidth(int i5, int i6) {
        this._sheet.setColumnWidth(i5, i6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnStyle(int i5, CellStyle cellStyle) {
        this._sheet.setDefaultColumnStyle(i5, cellStyle.getIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultColumnWidth(int i5) {
        this._sheet.setDefaultColumnWidth(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeight(short s6) {
        this._sheet.setDefaultRowHeight(s6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDefaultRowHeightInPoints(float f6) {
        this._sheet.setDefaultRowHeight((short) (f6 * 20.0f));
    }

    public void setDialog(boolean z6) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setDialog(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayFormulas(boolean z6) {
        this._sheet.setDisplayFormulas(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGridlines(boolean z6) {
        this._sheet.setDisplayGridlines(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayGuts(boolean z6) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setDisplayGuts(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayRowColHeadings(boolean z6) {
        this._sheet.setDisplayRowColHeadings(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setDisplayZeros(boolean z6) {
        this._sheet.getWindowTwo().setDisplayZeros(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setFitToPage(boolean z6) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setFitToPage(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setForceFormulaRecalculation(boolean z6) {
        this._sheet.setUncalced(z6);
    }

    public void setGridsPrinted(boolean z6) {
        this._sheet.setGridsPrinted(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setHorizontallyCenter(boolean z6) {
        this._sheet.getPageSettings().getHCenter().setHCenter(z6);
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
        getSheet().getPrintGridlines().setPrintGridlines(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setPrintRowAndColumnHeadings(boolean z6) {
        getSheet().getPrintHeaders().setPrintHeaders(z6);
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
        this._sheet.getWindowTwo().setArabic(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowBreak(int i5) {
        validateRow(i5);
        this._sheet.getPageSettings().setRowBreak(i5, (short) 0, (short) 255);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowGroupCollapsed(int i5, boolean z6) {
        if (z6) {
            this._sheet.getRowsAggregate().collapseRow(i5);
        } else {
            this._sheet.getRowsAggregate().expandRow(i5);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsBelow(boolean z6) {
        WSBoolRecord wSBoolRecord = (WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129);
        wSBoolRecord.setRowSumsBelow(z6);
        wSBoolRecord.setAlternateExpression(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setRowSumsRight(boolean z6) {
        ((WSBoolRecord) this._sheet.findFirstRecordBySid((short) 129)).setRowSumsRight(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setSelected(boolean z6) {
        getSheet().getWindowTwo().setSelected(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setVerticallyCenter(boolean z6) {
        this._sheet.getPageSettings().getVCenter().setVCenter(z6);
    }

    public void setZoom(int i5, int i6) {
        if (i5 < 1 || i5 > 65535) {
            throw new IllegalArgumentException("Numerator must be greater than 0 and less than 65536");
        }
        if (i6 < 1 || i6 > 65535) {
            throw new IllegalArgumentException("Denominator must be greater than 0 and less than 65536");
        }
        SCLRecord sCLRecord = new SCLRecord();
        sCLRecord.setNumerator((short) i5);
        sCLRecord.setDenominator((short) i6);
        getSheet().setSCLRecord(sCLRecord);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftColumns(int i5, int i6, int i7) {
        new HSSFColumnShifter(this).shiftColumns(i5, i6, i7);
        int sheetIndex = this._workbook.getSheetIndex(this);
        updateFormulasForShift(FormulaShifter.createForColumnShift(this._book.checkExternSheet(sheetIndex), this._workbook.getSheetName(sheetIndex), i5, i6, i7, SpreadsheetVersion.EXCEL97));
    }

    @Deprecated
    public void shiftMerged(int i5, int i6, int i7, boolean z6) {
        new HSSFRowShifter(this).shiftMergedRegions(i5, i6, i7);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftRows(int i5, int i6, int i7) {
        shiftRows(i5, i6, i7, false, false);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void showInPane(int i5, int i6) {
        int lastRowIndex = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        if (i5 > lastRowIndex) {
            throw new IllegalArgumentException(AbstractC0157z.k(lastRowIndex, "Maximum row number is "));
        }
        showInPane((short) i5, (short) i6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet, java.lang.Iterable
    public Spliterator<Row> spliterator() {
        return this._rows.values().spliterator();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupColumn(int i5, int i6) {
        this._sheet.groupColumnRange(i5, i6, false);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void ungroupRow(int i5, int i6) {
        this._sheet.groupRowRange(i5, i6, false);
    }

    public void validateColumn(int i5) {
        int lastColumnIndex = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
        if (i5 > lastColumnIndex) {
            throw new IllegalArgumentException(AbstractC0157z.k(lastColumnIndex, "Maximum column number is "));
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Minimum column number is 0");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void validateMergedRegions() {
        checkForMergedRegionsIntersectingArrayFormulas();
        checkForIntersectingMergedRegions();
    }

    public void validateRow(int i5) {
        int lastRowIndex = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        if (i5 > lastRowIndex) {
            throw new IllegalArgumentException(AbstractC0157z.k(lastRowIndex, "Maximum row number is "));
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Minumum row number is 0");
        }
    }

    private int addMergedRegion(CellRangeAddress cellRangeAddress, boolean z6) {
        if (cellRangeAddress.getNumberOfCells() < 2) {
            throw new IllegalArgumentException("Merged region " + cellRangeAddress.formatAsString() + " must contain 2 or more cells");
        }
        cellRangeAddress.validate(SpreadsheetVersion.EXCEL97);
        if (z6) {
            validateArrayFormulas(cellRangeAddress);
            validateMergedRegions(cellRangeAddress);
        }
        return this._sheet.addMergedRegion(cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastRow(), cellRangeAddress.getLastColumn());
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
            setColumnWidth(i5, (int) d);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFPatriarch createDrawingPatriarch() {
        HSSFPatriarch patriarch = getPatriarch(true);
        this._patriarch = patriarch;
        return patriarch;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFRow createRow(int i5) {
        HSSFRow hSSFRow = new HSSFRow(this._workbook, this, i5);
        hSSFRow.setHeight(getDefaultRowHeight());
        hSSFRow.getRowRecord().setBadFontHeight(false);
        addRow(hSSFRow, true);
        return hSSFRow;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createSplitPane(int i5, int i6, int i7, int i8, PaneType paneType) {
        int i9;
        int i10 = AnonymousClass2.$SwitchMap$org$apache$poi$ss$usermodel$PaneType[paneType.ordinal()];
        int i11 = 1;
        if (i10 != 1) {
            if (i10 != 2) {
                i11 = 3;
                if (i10 == 3) {
                    i9 = 2;
                }
            }
            getSheet().createSplitPane(i5, i6, i8, i7, i9);
        }
        i11 = 0;
        i9 = i11;
        getSheet().createSplitPane(i5, i6, i8, i7, i9);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFComment getCellComment(CellAddress cellAddress) {
        return findCellComment(cellAddress.getRow(), cellAddress.getColumn());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFCellStyle getColumnStyle(int i5) {
        short xFIndexForColAt = this._sheet.getXFIndexForColAt((short) i5);
        if (xFIndexForColAt == 15) {
            return null;
        }
        return new HSSFCellStyle(xFIndexForColAt, this._book.getExFormatAt(xFIndexForColAt), this._book);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFPatriarch getDrawingPatriarch() {
        HSSFPatriarch patriarch = getPatriarch(false);
        this._patriarch = patriarch;
        return patriarch;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFFooter getFooter() {
        return new HSSFFooter(this._sheet.getPageSettings());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFHeader getHeader() {
        return new HSSFHeader(this._sheet.getPageSettings());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public double getMargin(PageMargin pageMargin) {
        int i5 = AnonymousClass2.$SwitchMap$org$apache$poi$ss$usermodel$PageMargin[pageMargin.ordinal()];
        if (i5 != 1) {
            return i5 != 2 ? this._sheet.getPageSettings().getMargin(pageMargin.getLegacyApiValue()) : this._sheet.getPageSettings().getPrintSetup().getHeaderMargin();
        }
        return this._sheet.getPageSettings().getPrintSetup().getFooterMargin();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFPrintSetup getPrintSetup() {
        return new HSSFPrintSetup(this._sheet.getPageSettings().getPrintSetup());
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFRow getRow(int i5) {
        return this._rows.get(Integer.valueOf(i5));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFSheetConditionalFormatting getSheetConditionalFormatting() {
        return new HSSFSheetConditionalFormatting(this);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFWorkbook getWorkbook() {
        return this._workbook;
    }

    public void removeHyperlink(HyperlinkRecord hyperlinkRecord) {
        Iterator<RecordBase> it = this._sheet.getRecords().iterator();
        while (it.hasNext()) {
            RecordBase next = it.next();
            if ((next instanceof HyperlinkRecord) && hyperlinkRecord == ((HyperlinkRecord) next)) {
                it.remove();
                return;
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFAutoFilter setAutoFilter(CellRangeAddress cellRangeAddress) {
        InternalWorkbook workbook = this._workbook.getWorkbook();
        int sheetIndex = this._workbook.getSheetIndex(this);
        int i5 = sheetIndex + 1;
        NameRecord specificBuiltinRecord = workbook.getSpecificBuiltinRecord((byte) 13, i5);
        if (specificBuiltinRecord == null) {
            specificBuiltinRecord = workbook.createBuiltInName((byte) 13, i5);
        }
        NameRecord nameRecord = specificBuiltinRecord;
        int firstRow = cellRangeAddress.getFirstRow();
        int i6 = firstRow == -1 ? 0 : firstRow;
        nameRecord.setNameDefinition(new Ptg[]{new Area3DPtg(i6, cellRangeAddress.getLastRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn(), false, false, false, false, sheetIndex)});
        AutoFilterInfoRecord autoFilterInfoRecord = new AutoFilterInfoRecord();
        autoFilterInfoRecord.setNumEntries((short) ((cellRangeAddress.getLastColumn() + 1) - cellRangeAddress.getFirstColumn()));
        this._sheet.getRecords().add(this._sheet.findFirstRecordLocBySid(DimensionsRecord.sid), autoFilterInfoRecord);
        HSSFPatriarch hSSFPatriarchCreateDrawingPatriarch = createDrawingPatriarch();
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastColumn = cellRangeAddress.getLastColumn();
        while (firstColumn <= lastColumn) {
            short s6 = (short) firstColumn;
            firstColumn++;
            hSSFPatriarchCreateDrawingPatriarch.createComboBox(new HSSFClientAnchor(0, 0, 0, 0, s6, i6, (short) firstColumn, i6 + 1));
        }
        return new HSSFAutoFilter(this);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void shiftRows(int i5, int i6, int i7, boolean z6, boolean z7) {
        shiftRows(i5, i6, i7, z6, z7, true);
    }

    private void validateMergedRegions(CellRangeAddress cellRangeAddress) {
        for (CellRangeAddress cellRangeAddress2 : getMergedRegions()) {
            if (cellRangeAddress2.intersects(cellRangeAddress)) {
                throw new IllegalStateException("Cannot add merged region " + cellRangeAddress.formatAsString() + " to sheet because it overlaps with an existing merged region (" + cellRangeAddress2.formatAsString() + ").");
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFHyperlink getHyperlink(int i5, int i6) {
        for (RecordBase recordBase : this._sheet.getRecords()) {
            if (recordBase instanceof HyperlinkRecord) {
                HyperlinkRecord hyperlinkRecord = (HyperlinkRecord) recordBase;
                if (hyperlinkRecord.getFirstColumn() == i6 && hyperlinkRecord.getFirstRow() == i5) {
                    return new HSSFHyperlink(hyperlinkRecord);
                }
            }
        }
        return null;
    }

    public void shiftRows(int i5, int i6, int i7, boolean z6, boolean z7, boolean z8) {
        int i8;
        int i9;
        if (i6 >= i5) {
            if (i7 < 0) {
                i8 = 1;
                i9 = i5;
            } else {
                if (i7 <= 0) {
                    return;
                }
                i8 = -1;
                i9 = i6;
            }
            HSSFRowShifter hSSFRowShifter = new HSSFRowShifter(this);
            if (z8) {
                moveCommentsForRowShift(i5, i6, i7);
            }
            hSSFRowShifter.shiftMergedRegions(i5, i6, i7);
            this._sheet.getPageSettings().shiftRowBreaks(i5, i6, i7);
            deleteOverwrittenHyperlinksForRowShift(i5, i6, i7);
            while (i9 >= i5 && i9 <= i6 && i9 >= 0 && i9 < 65536) {
                HSSFRow row = getRow(i9);
                if (row != null) {
                    notifyRowShifting(row);
                }
                int i10 = i9 + i7;
                HSSFRow row2 = getRow(i10);
                if (row2 == null) {
                    row2 = createRow(i10);
                }
                row2.removeAllCells();
                if (row != null) {
                    if (z6) {
                        row2.setHeight(row.getHeight());
                    }
                    if (z7) {
                        row.setHeight((short) 255);
                    }
                    Iterator<Cell> itCellIterator = row.cellIterator();
                    while (itCellIterator.hasNext()) {
                        HSSFCell hSSFCell = (HSSFCell) itCellIterator.next();
                        HSSFHyperlink hyperlink = hSSFCell.getHyperlink();
                        row.removeCell(hSSFCell);
                        CellValueRecordInterface cellValueRecord = hSSFCell.getCellValueRecord();
                        cellValueRecord.setRow(i10);
                        row2.createCellFromRecord(cellValueRecord);
                        this._sheet.addValueRecord(i10, cellValueRecord);
                        if (hyperlink != null) {
                            hyperlink.setFirstRow(hyperlink.getFirstRow() + i7);
                            hyperlink.setLastRow(hyperlink.getLastRow() + i7);
                        }
                    }
                    row.removeAllCells();
                }
                i9 += i8;
            }
            recomputeFirstAndLastRowsForRowShift(i5, i6, i7);
            int sheetIndex = this._workbook.getSheetIndex(this);
            updateFormulasForShift(FormulaShifter.createForRowShift(this._book.checkExternSheet(sheetIndex), this._workbook.getSheetName(sheetIndex), i5, i6, i7, SpreadsheetVersion.EXCEL97));
            return;
        }
        throw new IllegalArgumentException("startRow must be less than or equal to endRow. To shift rows up, use n<0.");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void createFreezePane(int i5, int i6) {
        createFreezePane(i5, i6, i5, i6);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setZoom(int i5) {
        setZoom(i5, 100);
    }

    public HSSFSheet(HSSFWorkbook hSSFWorkbook, InternalSheet internalSheet) {
        this._firstrow = -1;
        this._lastrow = -1;
        this._sheet = internalSheet;
        this._rows = new TreeMap<>();
        this._workbook = hSSFWorkbook;
        this._book = hSSFWorkbook.getWorkbook();
        setPropertiesFromSheet(internalSheet);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFHyperlink getHyperlink(CellAddress cellAddress) {
        return getHyperlink(cellAddress.getRow(), cellAddress.getColumn());
    }

    private void showInPane(short s6, short s7) {
        this._sheet.setTopRow(s6);
        this._sheet.setLeftCol(s7);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public void setMargin(PageMargin pageMargin, double d) {
        int i5 = AnonymousClass2.$SwitchMap$org$apache$poi$ss$usermodel$PageMargin[pageMargin.ordinal()];
        if (i5 == 1) {
            this._sheet.getPageSettings().getPrintSetup().setFooterMargin(d);
        } else if (i5 != 2) {
            this._sheet.getPageSettings().setMargin(pageMargin.getLegacyApiValue(), d);
        } else {
            this._sheet.getPageSettings().getPrintSetup().setHeaderMargin(d);
        }
    }
}
