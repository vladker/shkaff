package org.apache.poi.hssf.model;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.util.Supplier;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.CalcCountRecord;
import org.apache.poi.hssf.record.CalcModeRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.ColumnInfoRecord;
import org.apache.poi.hssf.record.DefaultColWidthRecord;
import org.apache.poi.hssf.record.DefaultRowHeightRecord;
import org.apache.poi.hssf.record.DeltaRecord;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.DrawingRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.GridsetRecord;
import org.apache.poi.hssf.record.GutsRecord;
import org.apache.poi.hssf.record.IterationRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.PaneRecord;
import org.apache.poi.hssf.record.PrintGridlinesRecord;
import org.apache.poi.hssf.record.PrintHeadersRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.RefModeRecord;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SCLRecord;
import org.apache.poi.hssf.record.SaveRecalcRecord;
import org.apache.poi.hssf.record.SelectionRecord;
import org.apache.poi.hssf.record.UncalcedRecord;
import org.apache.poi.hssf.record.WSBoolRecord;
import org.apache.poi.hssf.record.WindowTwoRecord;
import org.apache.poi.hssf.record.aggregates.ChartSubstreamRecordAggregate;
import org.apache.poi.hssf.record.aggregates.ColumnInfoRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
import org.apache.poi.hssf.record.aggregates.CustomViewSettingsRecordAggregate;
import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.apache.poi.hssf.record.aggregates.MergedCellsTable;
import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.hssf.record.aggregates.RowRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.poi.util.Internal;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class InternalSheet {
    public static final short BottomMargin = 3;
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) InternalSheet.class);
    public static final short LeftMargin = 0;
    public static final byte PANE_LOWER_LEFT = 2;
    public static final byte PANE_LOWER_RIGHT = 0;
    public static final byte PANE_UPPER_LEFT = 3;
    public static final byte PANE_UPPER_RIGHT = 1;
    public static final short RightMargin = 1;
    public static final short TopMargin = 2;
    ColumnInfoRecordsAggregate _columnInfos;
    private DataValidityTable _dataValidityTable;
    private DimensionsRecord _dimensions;
    private GutsRecord _gutsRecord;
    protected boolean _isUncalced;
    private final MergedCellsTable _mergedCellsTable;
    private final WorksheetProtectionBlock _protectionBlock;
    private PageSettingsBlock _psBlock;
    private final List<RecordBase> _records;
    protected final RowRecordsAggregate _rowsAggregate;
    protected SelectionRecord _selection;
    private ConditionalFormattingTable condFormatting;
    protected DefaultColWidthRecord defaultcolwidth;
    protected DefaultRowHeightRecord defaultrowheight;
    protected GridsetRecord gridset;
    protected PrintGridlinesRecord printGridlines;
    protected PrintHeadersRecord printHeaders;
    private Iterator<RowRecord> rowRecIterator;
    protected WindowTwoRecord windowTwo;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class RecordCloner implements RecordAggregate.RecordVisitor {
        private final List<Record> _destList;

        public RecordCloner(List<Record> list) {
            this._destList = list;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record record) {
            this._destList.add(record.copy());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class UnsupportedBOFType extends RecordFormatException {
        private final int type;

        public UnsupportedBOFType(int i5) {
            super(AbstractC0157z.k(i5, "BOF not of a supported type, found "));
            this.type = i5;
        }

        public int getType() {
            return this.type;
        }
    }

    private InternalSheet(RecordStream recordStream) {
        this.defaultcolwidth = new DefaultColWidthRecord();
        this.defaultrowheight = new DefaultRowHeightRecord();
        this._protectionBlock = new WorksheetProtectionBlock();
        this._mergedCellsTable = new MergedCellsTable();
        ArrayList arrayList = new ArrayList(128);
        this._records = arrayList;
        if (recordStream.peekNextSid() != 2057) {
            throw new RecordFormatException("BOF record expected");
        }
        BOFRecord bOFRecord = (BOFRecord) recordStream.getNext();
        if (bOFRecord.getType() != 16 && bOFRecord.getType() != 32 && bOFRecord.getType() != 64) {
            while (recordStream.hasNext() && !(recordStream.getNext() instanceof EOFRecord)) {
            }
            throw new UnsupportedBOFType(bOFRecord.getType());
        }
        arrayList.add(bOFRecord);
        RowRecordsAggregate rowRecordsAggregate = null;
        int iFindFirstRecordLocBySid = -1;
        while (recordStream.hasNext()) {
            int iPeekNextSid = recordStream.peekNextSid();
            if (iPeekNextSid == 432 || iPeekNextSid == 2169) {
                ConditionalFormattingTable conditionalFormattingTable = new ConditionalFormattingTable(recordStream);
                this.condFormatting = conditionalFormattingTable;
                arrayList.add(conditionalFormattingTable);
            } else if (iPeekNextSid == 125) {
                ColumnInfoRecordsAggregate columnInfoRecordsAggregate = new ColumnInfoRecordsAggregate(recordStream);
                this._columnInfos = columnInfoRecordsAggregate;
                arrayList.add(columnInfoRecordsAggregate);
            } else if (iPeekNextSid == 434) {
                DataValidityTable dataValidityTable = new DataValidityTable(recordStream);
                this._dataValidityTable = dataValidityTable;
                arrayList.add(dataValidityTable);
            } else if (RecordOrderer.isRowBlockRecord(iPeekNextSid)) {
                if (rowRecordsAggregate != null) {
                    throw new RecordFormatException("row/cell records found in the wrong place");
                }
                RowBlocksReader rowBlocksReader = new RowBlocksReader(recordStream);
                this._mergedCellsTable.addRecords(rowBlocksReader.getLooseMergedCells());
                RowRecordsAggregate rowRecordsAggregate2 = new RowRecordsAggregate(rowBlocksReader.getPlainRecordStream(), rowBlocksReader.getSharedFormulaManager());
                arrayList.add(rowRecordsAggregate2);
                rowRecordsAggregate = rowRecordsAggregate2;
            } else if (CustomViewSettingsRecordAggregate.isBeginRecord(iPeekNextSid)) {
                arrayList.add(new CustomViewSettingsRecordAggregate(recordStream));
            } else if (PageSettingsBlock.isComponentRecord(iPeekNextSid)) {
                PageSettingsBlock pageSettingsBlock = this._psBlock;
                if (pageSettingsBlock == null) {
                    PageSettingsBlock pageSettingsBlock2 = new PageSettingsBlock(recordStream);
                    this._psBlock = pageSettingsBlock2;
                    arrayList.add(pageSettingsBlock2);
                } else {
                    pageSettingsBlock.addLateRecords(recordStream);
                }
                this._psBlock.positionRecords(arrayList);
            } else if (WorksheetProtectionBlock.isComponentRecord(iPeekNextSid)) {
                this._protectionBlock.addRecords(recordStream);
            } else if (iPeekNextSid == 229) {
                this._mergedCellsTable.read(recordStream);
            } else if (iPeekNextSid == 2057) {
                spillAggregate(new ChartSubstreamRecordAggregate(recordStream), arrayList);
            } else {
                Record next = recordStream.getNext();
                if (iPeekNextSid == 523) {
                    continue;
                } else if (iPeekNextSid == 94) {
                    this._isUncalced = true;
                } else if (iPeekNextSid == 2152 || iPeekNextSid == 2151) {
                    arrayList.add(next);
                } else {
                    if (iPeekNextSid == 10) {
                        arrayList.add(next);
                        break;
                    }
                    if (iPeekNextSid == 512) {
                        if (this._columnInfos == null) {
                            ColumnInfoRecordsAggregate columnInfoRecordsAggregate2 = new ColumnInfoRecordsAggregate();
                            this._columnInfos = columnInfoRecordsAggregate2;
                            arrayList.add(columnInfoRecordsAggregate2);
                        }
                        this._dimensions = (DimensionsRecord) next;
                        iFindFirstRecordLocBySid = arrayList.size();
                    } else if (iPeekNextSid == 85) {
                        this.defaultcolwidth = (DefaultColWidthRecord) next;
                    } else if (iPeekNextSid == 549) {
                        this.defaultrowheight = (DefaultRowHeightRecord) next;
                    } else if (iPeekNextSid == 43) {
                        this.printGridlines = (PrintGridlinesRecord) next;
                    } else if (iPeekNextSid == 42) {
                        this.printHeaders = (PrintHeadersRecord) next;
                    } else if (iPeekNextSid == 130) {
                        this.gridset = (GridsetRecord) next;
                    } else if (iPeekNextSid == 29) {
                        this._selection = (SelectionRecord) next;
                    } else if (iPeekNextSid == 574) {
                        this.windowTwo = (WindowTwoRecord) next;
                    } else if (iPeekNextSid == 128) {
                        this._gutsRecord = (GutsRecord) next;
                    }
                    arrayList.add(next);
                }
            }
        }
        if (this.windowTwo == null) {
            throw new RecordFormatException("WINDOW2 was not found");
        }
        if (this._dimensions == null) {
            if (rowRecordsAggregate == null) {
                rowRecordsAggregate = new RowRecordsAggregate();
            } else {
                LOGGER.atWarn().log("DIMENSION record not found even though row/cells present");
            }
            iFindFirstRecordLocBySid = findFirstRecordLocBySid(WindowTwoRecord.sid);
            DimensionsRecord dimensionsRecordCreateDimensions = rowRecordsAggregate.createDimensions();
            this._dimensions = dimensionsRecordCreateDimensions;
            arrayList.add(iFindFirstRecordLocBySid, dimensionsRecordCreateDimensions);
        }
        if (rowRecordsAggregate == null) {
            rowRecordsAggregate = new RowRecordsAggregate();
            arrayList.add(iFindFirstRecordLocBySid + 1, rowRecordsAggregate);
        }
        this._rowsAggregate = rowRecordsAggregate;
        RecordOrderer.addNewSheetRecord(arrayList, this._mergedCellsTable);
        RecordOrderer.addNewSheetRecord(arrayList, this._protectionBlock);
        LOGGER.atDebug().log("sheet createSheet (existing file) exited");
    }

    public static BOFRecord createBOF() {
        BOFRecord bOFRecord = new BOFRecord();
        bOFRecord.setVersion(BOFRecord.VERSION);
        bOFRecord.setType(16);
        bOFRecord.setBuild(3515);
        bOFRecord.setBuildYear(BOFRecord.BUILD_YEAR);
        bOFRecord.setHistoryBitMask(193);
        bOFRecord.setRequiredVersion(6);
        return bOFRecord;
    }

    private static CalcCountRecord createCalcCount() {
        CalcCountRecord calcCountRecord = new CalcCountRecord();
        calcCountRecord.setIterations((short) 100);
        return calcCountRecord;
    }

    private static CalcModeRecord createCalcMode() {
        CalcModeRecord calcModeRecord = new CalcModeRecord();
        calcModeRecord.setCalcMode((short) 1);
        return calcModeRecord;
    }

    private static DefaultColWidthRecord createDefaultColWidth() {
        DefaultColWidthRecord defaultColWidthRecord = new DefaultColWidthRecord();
        defaultColWidthRecord.setColWidth(8);
        return defaultColWidthRecord;
    }

    private static DefaultRowHeightRecord createDefaultRowHeight() {
        DefaultRowHeightRecord defaultRowHeightRecord = new DefaultRowHeightRecord();
        defaultRowHeightRecord.setOptionFlags((short) 0);
        defaultRowHeightRecord.setRowHeight((short) 255);
        return defaultRowHeightRecord;
    }

    private static DeltaRecord createDelta() {
        return new DeltaRecord(0.001d);
    }

    private static DimensionsRecord createDimensions() {
        DimensionsRecord dimensionsRecord = new DimensionsRecord();
        dimensionsRecord.setFirstCol((short) 0);
        dimensionsRecord.setLastRow(1);
        dimensionsRecord.setFirstRow(0);
        dimensionsRecord.setLastCol((short) 1);
        return dimensionsRecord;
    }

    private static GridsetRecord createGridset() {
        GridsetRecord gridsetRecord = new GridsetRecord();
        gridsetRecord.setGridset(true);
        return gridsetRecord;
    }

    private static GutsRecord createGuts() {
        GutsRecord gutsRecord = new GutsRecord();
        gutsRecord.setLeftRowGutter((short) 0);
        gutsRecord.setTopColGutter((short) 0);
        gutsRecord.setRowLevelMax((short) 0);
        gutsRecord.setColLevelMax((short) 0);
        return gutsRecord;
    }

    private static IterationRecord createIteration() {
        return new IterationRecord(false);
    }

    private static PrintGridlinesRecord createPrintGridlines() {
        PrintGridlinesRecord printGridlinesRecord = new PrintGridlinesRecord();
        printGridlinesRecord.setPrintGridlines(false);
        return printGridlinesRecord;
    }

    private static PrintHeadersRecord createPrintHeaders() {
        PrintHeadersRecord printHeadersRecord = new PrintHeadersRecord();
        printHeadersRecord.setPrintHeaders(false);
        return printHeadersRecord;
    }

    private static RefModeRecord createRefMode() {
        RefModeRecord refModeRecord = new RefModeRecord();
        refModeRecord.setMode((short) 1);
        return refModeRecord;
    }

    private static SaveRecalcRecord createSaveRecalc() {
        SaveRecalcRecord saveRecalcRecord = new SaveRecalcRecord();
        saveRecalcRecord.setRecalc(true);
        return saveRecalcRecord;
    }

    private static SelectionRecord createSelection() {
        return new SelectionRecord(0, 0);
    }

    public static InternalSheet createSheet(RecordStream recordStream) {
        return new InternalSheet(recordStream);
    }

    private static WSBoolRecord createWSBool() {
        WSBoolRecord wSBoolRecord = new WSBoolRecord();
        wSBoolRecord.setWSBool1((byte) 4);
        wSBoolRecord.setWSBool2((byte) -63);
        return wSBoolRecord;
    }

    private static WindowTwoRecord createWindowTwo() {
        WindowTwoRecord windowTwoRecord = new WindowTwoRecord();
        windowTwoRecord.setOptions((short) 1718);
        windowTwoRecord.setTopRow((short) 0);
        windowTwoRecord.setLeftCol((short) 0);
        windowTwoRecord.setHeaderColor(64);
        windowTwoRecord.setPageBreakZoom((short) 0);
        windowTwoRecord.setNormalZoom((short) 0);
        return windowTwoRecord;
    }

    private GutsRecord getGutsRecord() {
        if (this._gutsRecord == null) {
            GutsRecord gutsRecordCreateGuts = createGuts();
            RecordOrderer.addNewSheetRecord(this._records, gutsRecordCreateGuts);
            this._gutsRecord = gutsRecordCreateGuts;
        }
        return this._gutsRecord;
    }

    private MergedCellsTable getMergedRecords() {
        return this._mergedCellsTable;
    }

    private int getSizeOfInitialSheetRecords(int i5) {
        int recordSize = 0;
        for (int i6 = i5 + 1; i6 < this._records.size(); i6++) {
            RecordBase recordBase = this._records.get(i6);
            if (recordBase instanceof RowRecordsAggregate) {
                break;
            }
            recordSize += recordBase.getRecordSize();
        }
        return this._isUncalced ? UncalcedRecord.getStaticRecordSize() + recordSize : recordSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Message lambda$setDimensions$0(int i5, short s6, int i6, short s7) {
        return new SimpleMessage(androidx.exifinterface.media.a.i("lastcol", i6, s7, androidx.collection.a.s("firstrow", i5, s6, "firstcol", "lastrow")));
    }

    private void recalcRowGutter() {
        Iterator<RowRecord> iterator = this._rowsAggregate.getIterator();
        int iMax = 0;
        while (iterator.hasNext()) {
            iMax = Math.max((int) iterator.next().getOutlineLevel(), iMax);
        }
        GutsRecord gutsRecord = getGutsRecord();
        gutsRecord.setRowLevelMax((short) (iMax + 1));
        gutsRecord.setLeftRowGutter((short) ((iMax * 12) + 29));
    }

    private void setColumn(int i5, Short sh, Integer num, Integer num2, Boolean bool, Boolean bool2) {
        this._columnInfos.setColumn(i5, sh, num, num2, bool, bool2);
    }

    private static void spillAggregate(RecordAggregate recordAggregate, List<RecordBase> list) {
        list.getClass();
        recordAggregate.visitContainedRecords(new Y2.a(list, 28));
    }

    public int addMergedRegion(int i5, int i6, int i7, int i8) {
        if (i7 < i5) {
            throw new IllegalArgumentException(androidx.collection.a.m("The 'to' row (", i7, i5, ") must not be less than the 'from' row (", ")"));
        }
        if (i8 < i6) {
            throw new IllegalArgumentException(androidx.collection.a.m("The 'to' col (", i8, i6, ") must not be less than the 'from' col (", ")"));
        }
        MergedCellsTable mergedRecords = getMergedRecords();
        mergedRecords.addArea(i5, i6, i7, i8);
        return mergedRecords.getNumberOfMergedRegions() - 1;
    }

    public void addRow(RowRecord rowRecord) {
        Logger logger = LOGGER;
        logger.atDebug().log("addRow ");
        DimensionsRecord dimensionsRecord = this._dimensions;
        if (rowRecord.getRowNumber() >= dimensionsRecord.getLastRow()) {
            dimensionsRecord.setLastRow(rowRecord.getRowNumber() + 1);
        }
        if (rowRecord.getRowNumber() < dimensionsRecord.getFirstRow()) {
            dimensionsRecord.setFirstRow(rowRecord.getRowNumber());
        }
        RowRecord row = this._rowsAggregate.getRow(rowRecord.getRowNumber());
        if (row != null) {
            this._rowsAggregate.removeRow(row);
        }
        this._rowsAggregate.insertRow(rowRecord);
        logger.atDebug().log("exit addRow");
    }

    public void addValueRecord(int i5, CellValueRecordInterface cellValueRecordInterface) {
        LOGGER.atDebug().log("add value record row{}", Unbox.box(i5));
        DimensionsRecord dimensionsRecord = this._dimensions;
        if (cellValueRecordInterface.getColumn() >= dimensionsRecord.getLastCol()) {
            dimensionsRecord.setLastCol((short) (cellValueRecordInterface.getColumn() + 1));
        }
        if (cellValueRecordInterface.getColumn() < dimensionsRecord.getFirstCol()) {
            dimensionsRecord.setFirstCol(cellValueRecordInterface.getColumn());
        }
        this._rowsAggregate.insertCell(cellValueRecordInterface);
    }

    public int aggregateDrawingRecords(DrawingManager2 drawingManager2, boolean z6) {
        int iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 236);
        if (iFindFirstRecordLocBySid != -1) {
            EscherAggregate.createAggregate(getRecords(), iFindFirstRecordLocBySid);
            return iFindFirstRecordLocBySid;
        }
        if (!z6) {
            return -1;
        }
        EscherAggregate escherAggregate = new EscherAggregate(true);
        int iFindFirstRecordLocBySid2 = findFirstRecordLocBySid(EscherAggregate.sid);
        if (iFindFirstRecordLocBySid2 == -1) {
            iFindFirstRecordLocBySid2 = findFirstRecordLocBySid(WindowTwoRecord.sid);
        } else {
            getRecords().remove(iFindFirstRecordLocBySid2);
        }
        getRecords().add(iFindFirstRecordLocBySid2, escherAggregate);
        return iFindFirstRecordLocBySid2;
    }

    public InternalSheet cloneSheet() {
        ArrayList arrayList = new ArrayList(this._records.size());
        for (Object drawingRecord : this._records) {
            if (drawingRecord instanceof RecordAggregate) {
                ((RecordAggregate) drawingRecord).visitContainedRecords(new RecordCloner(arrayList));
            } else {
                if (drawingRecord instanceof EscherAggregate) {
                    drawingRecord = new DrawingRecord();
                }
                arrayList.add(((Record) drawingRecord).copy());
            }
        }
        return createSheet(new RecordStream(arrayList, 0));
    }

    public void createFreezePane(int i5, int i6, int i7, int i8) {
        int iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 65);
        if (iFindFirstRecordLocBySid != -1) {
            this._records.remove(iFindFirstRecordLocBySid);
        }
        if (i5 == 0 && i6 == 0) {
            this.windowTwo.setFreezePanes(false);
            this.windowTwo.setFreezePanesNoSplit(false);
            SelectionRecord selectionRecord = (SelectionRecord) findFirstRecordBySid((short) 29);
            if (selectionRecord != null) {
                selectionRecord.setPane((byte) 3);
                return;
            }
            return;
        }
        int iFindFirstRecordLocBySid2 = findFirstRecordLocBySid(WindowTwoRecord.sid);
        PaneRecord paneRecord = new PaneRecord();
        paneRecord.setX((short) i5);
        paneRecord.setY((short) i6);
        paneRecord.setTopRow((short) i7);
        paneRecord.setLeftColumn((short) i8);
        if (i6 == 0) {
            paneRecord.setTopRow((short) 0);
            paneRecord.setActivePane((short) 1);
        } else if (i5 == 0) {
            paneRecord.setLeftColumn((short) 0);
            paneRecord.setActivePane((short) 2);
        } else {
            paneRecord.setActivePane((short) 0);
        }
        this._records.add(iFindFirstRecordLocBySid2 + 1, paneRecord);
        this.windowTwo.setFreezePanes(true);
        this.windowTwo.setFreezePanesNoSplit(true);
        SelectionRecord selectionRecord2 = (SelectionRecord) findFirstRecordBySid((short) 29);
        if (selectionRecord2 != null) {
            selectionRecord2.setPane((byte) paneRecord.getActivePane());
        }
    }

    public void createSplitPane(int i5, int i6, int i7, int i8, int i9) {
        int iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 65);
        if (iFindFirstRecordLocBySid != -1) {
            this._records.remove(iFindFirstRecordLocBySid);
        }
        int iFindFirstRecordLocBySid2 = findFirstRecordLocBySid(WindowTwoRecord.sid);
        PaneRecord paneRecord = new PaneRecord();
        paneRecord.setX((short) i5);
        paneRecord.setY((short) i6);
        paneRecord.setTopRow((short) i7);
        paneRecord.setLeftColumn((short) i8);
        paneRecord.setActivePane((short) i9);
        this._records.add(iFindFirstRecordLocBySid2 + 1, paneRecord);
        this.windowTwo.setFreezePanes(false);
        this.windowTwo.setFreezePanesNoSplit(false);
        SelectionRecord selectionRecord = (SelectionRecord) findFirstRecordBySid((short) 29);
        if (selectionRecord != null) {
            selectionRecord.setPane((byte) 0);
        }
    }

    public Record findFirstRecordBySid(short s6) {
        int iFindFirstRecordLocBySid = findFirstRecordLocBySid(s6);
        if (iFindFirstRecordLocBySid < 0) {
            return null;
        }
        return (Record) this._records.get(iFindFirstRecordLocBySid);
    }

    public int findFirstRecordLocBySid(short s6) {
        int size = this._records.size();
        for (int i5 = 0; i5 < size; i5++) {
            RecordBase recordBase = this._records.get(i5);
            if ((recordBase instanceof Record) && ((Record) recordBase).getSid() == s6) {
                return i5;
            }
        }
        return -1;
    }

    public short getActiveCellCol() {
        SelectionRecord selectionRecord = this._selection;
        if (selectionRecord == null) {
            return (short) 0;
        }
        return (short) selectionRecord.getActiveCellCol();
    }

    public int getActiveCellRow() {
        SelectionRecord selectionRecord = this._selection;
        if (selectionRecord == null) {
            return 0;
        }
        return selectionRecord.getActiveCellRow();
    }

    public Iterator<CellValueRecordInterface> getCellValueIterator() {
        return this._rowsAggregate.getCellValueIterator();
    }

    public int getColumnOutlineLevel(int i5) {
        return this._columnInfos.getOutlineLevel(i5);
    }

    public int getColumnWidth(int i5) {
        ColumnInfoRecord columnInfoRecordFindColumnInfo = this._columnInfos.findColumnInfo(i5);
        return columnInfoRecordFindColumnInfo != null ? columnInfoRecordFindColumnInfo.getColumnWidth() : this.defaultcolwidth.getColWidth() * 256;
    }

    public ConditionalFormattingTable getConditionalFormattingTable() {
        if (this.condFormatting == null) {
            ConditionalFormattingTable conditionalFormattingTable = new ConditionalFormattingTable();
            this.condFormatting = conditionalFormattingTable;
            RecordOrderer.addNewSheetRecord(this._records, conditionalFormattingTable);
        }
        return this.condFormatting;
    }

    public int getDefaultColumnWidth() {
        return this.defaultcolwidth.getColWidth();
    }

    public short getDefaultRowHeight() {
        return this.defaultrowheight.getRowHeight();
    }

    public GridsetRecord getGridsetRecord() {
        return this.gridset;
    }

    public short getLeftCol() {
        WindowTwoRecord windowTwoRecord = this.windowTwo;
        if (windowTwoRecord == null) {
            return (short) 0;
        }
        return windowTwoRecord.getLeftCol();
    }

    public int getMaxColumnIndex() {
        return this._columnInfos.getMaxColumnIndex();
    }

    public CellRangeAddress getMergedRegionAt(int i5) {
        MergedCellsTable mergedRecords = getMergedRecords();
        if (i5 >= mergedRecords.getNumberOfMergedRegions()) {
            return null;
        }
        return mergedRecords.get(i5);
    }

    public int getMinColumnIndex() {
        return this._columnInfos.getMinColumnIndex();
    }

    public RowRecord getNextRow() {
        if (this.rowRecIterator == null) {
            this.rowRecIterator = this._rowsAggregate.getIterator();
        }
        if (this.rowRecIterator.hasNext()) {
            return this.rowRecIterator.next();
        }
        return null;
    }

    public NoteRecord[] getNoteRecords() {
        ArrayList arrayList = new ArrayList();
        for (int size = this._records.size() - 1; size >= 0; size--) {
            RecordBase recordBase = this._records.get(size);
            if (recordBase instanceof NoteRecord) {
                arrayList.add((NoteRecord) recordBase);
            }
        }
        if (arrayList.size() < 1) {
            return NoteRecord.EMPTY_ARRAY;
        }
        NoteRecord[] noteRecordArr = new NoteRecord[arrayList.size()];
        arrayList.toArray(noteRecordArr);
        return noteRecordArr;
    }

    public int getNumMergedRegions() {
        return getMergedRecords().getNumberOfMergedRegions();
    }

    public DataValidityTable getOrCreateDataValidityTable() {
        if (this._dataValidityTable == null) {
            DataValidityTable dataValidityTable = new DataValidityTable();
            RecordOrderer.addNewSheetRecord(this._records, dataValidityTable);
            this._dataValidityTable = dataValidityTable;
        }
        return this._dataValidityTable;
    }

    public PageSettingsBlock getPageSettings() {
        if (this._psBlock == null) {
            PageSettingsBlock pageSettingsBlock = new PageSettingsBlock();
            this._psBlock = pageSettingsBlock;
            RecordOrderer.addNewSheetRecord(this._records, pageSettingsBlock);
        }
        return this._psBlock;
    }

    public PaneInformation getPaneInformation() {
        PaneRecord paneRecord = (PaneRecord) findFirstRecordBySid((short) 65);
        if (paneRecord == null) {
            return null;
        }
        return new PaneInformation(paneRecord.getX(), paneRecord.getY(), paneRecord.getTopRow(), paneRecord.getLeftColumn(), (byte) paneRecord.getActivePane(), this.windowTwo.getFreezePanes());
    }

    public PrintGridlinesRecord getPrintGridlines() {
        return this.printGridlines;
    }

    public PrintHeadersRecord getPrintHeaders() {
        return this.printHeaders;
    }

    public WorksheetProtectionBlock getProtectionBlock() {
        return this._protectionBlock;
    }

    public List<RecordBase> getRecords() {
        return this._records;
    }

    public RowRecord getRow(int i5) {
        return this._rowsAggregate.getRow(i5);
    }

    public RowRecordsAggregate getRowsAggregate() {
        return this._rowsAggregate;
    }

    public SelectionRecord getSelection() {
        return this._selection;
    }

    public short getTopRow() {
        WindowTwoRecord windowTwoRecord = this.windowTwo;
        if (windowTwoRecord == null) {
            return (short) 0;
        }
        return windowTwoRecord.getTopRow();
    }

    public boolean getUncalced() {
        return this._isUncalced;
    }

    public WindowTwoRecord getWindowTwo() {
        return this.windowTwo;
    }

    public short getXFIndexForColAt(short s6) {
        ColumnInfoRecord columnInfoRecordFindColumnInfo = this._columnInfos.findColumnInfo(s6);
        if (columnInfoRecordFindColumnInfo != null) {
            return (short) columnInfoRecordFindColumnInfo.getXFIndex();
        }
        return (short) 15;
    }

    public void groupColumnRange(int i5, int i6, boolean z6) {
        this._columnInfos.groupColumnRange(i5, i6, z6);
        int maxOutlineLevel = this._columnInfos.getMaxOutlineLevel();
        GutsRecord gutsRecord = getGutsRecord();
        gutsRecord.setColLevelMax((short) (maxOutlineLevel + 1));
        if (maxOutlineLevel == 0) {
            gutsRecord.setTopColGutter((short) 0);
        } else {
            gutsRecord.setTopColGutter((short) (((maxOutlineLevel - 1) * 12) + 29));
        }
    }

    public void groupRowRange(int i5, int i6, boolean z6) {
        while (i5 <= i6) {
            RowRecord row = getRow(i5);
            if (row == null) {
                row = RowRecordsAggregate.createRow(i5);
                addRow(row);
            }
            short outlineLevel = row.getOutlineLevel();
            row.setOutlineLevel((short) Math.min(7, Math.max(0, z6 ? outlineLevel + 1 : outlineLevel - 1)));
            i5++;
        }
        recalcRowGutter();
    }

    public boolean isColumnHidden(int i5) {
        ColumnInfoRecord columnInfoRecordFindColumnInfo = this._columnInfos.findColumnInfo(i5);
        if (columnInfoRecordFindColumnInfo == null) {
            return false;
        }
        return columnInfoRecordFindColumnInfo.getHidden();
    }

    public boolean isDisplayFormulas() {
        return this.windowTwo.getDisplayFormulas();
    }

    public boolean isDisplayGridlines() {
        return this.windowTwo.getDisplayGridlines();
    }

    public boolean isDisplayRowColHeadings() {
        return this.windowTwo.getDisplayRowColHeadings();
    }

    public boolean isGridsPrinted() {
        if (this.gridset == null) {
            this.gridset = createGridset();
            this._records.add(findFirstRecordLocBySid((short) 10), this.gridset);
        }
        return !this.gridset.getGridset();
    }

    public boolean isPrintRowColHeadings() {
        return this.windowTwo.getDisplayRowColHeadings();
    }

    public void preSerialize() {
        for (RecordBase recordBase : getRecords()) {
            if (recordBase instanceof EscherAggregate) {
                recordBase.getRecordSize();
            }
        }
    }

    public void removeMergedRegion(int i5) {
        MergedCellsTable mergedRecords = getMergedRecords();
        if (i5 >= mergedRecords.getNumberOfMergedRegions()) {
            return;
        }
        mergedRecords.remove(i5);
    }

    public void removeRow(RowRecord rowRecord) {
        this._rowsAggregate.removeRow(rowRecord);
    }

    public void removeValueRecord(int i5, CellValueRecordInterface cellValueRecordInterface) {
        LOGGER.atDebug().log("remove value record row {}", Unbox.box(i5));
        this._rowsAggregate.removeCell(cellValueRecordInterface);
    }

    public void replaceValueRecord(CellValueRecordInterface cellValueRecordInterface) {
        LOGGER.atDebug().log("replaceValueRecord ");
        this._rowsAggregate.removeCell(cellValueRecordInterface);
        this._rowsAggregate.insertCell(cellValueRecordInterface);
    }

    public void setActiveCellCol(short s6) {
        SelectionRecord selectionRecord = this._selection;
        if (selectionRecord != null) {
            selectionRecord.setActiveCellCol(s6);
        }
    }

    public void setActiveCellRow(int i5) {
        SelectionRecord selectionRecord = this._selection;
        if (selectionRecord != null) {
            selectionRecord.setActiveCellRow(i5);
        }
    }

    public void setColumnGroupCollapsed(int i5, boolean z6) {
        if (z6) {
            this._columnInfos.collapseColumn(i5);
        } else {
            this._columnInfos.expandColumn(i5);
        }
    }

    public void setColumnHidden(int i5, boolean z6) {
        setColumn(i5, null, null, null, Boolean.valueOf(z6), null);
    }

    public void setColumnWidth(int i5, int i6) {
        if (i6 > 65280) {
            throw new IllegalArgumentException("The maximum column width for an individual cell is 255 characters.");
        }
        setColumn(i5, null, Integer.valueOf(i6), null, null, null);
    }

    public void setDefaultColumnStyle(int i5, int i6) {
        setColumn(i5, Short.valueOf((short) i6), null, null, null, null);
    }

    public void setDefaultColumnWidth(int i5) {
        this.defaultcolwidth.setColWidth(i5);
    }

    public void setDefaultRowHeight(short s6) {
        this.defaultrowheight.setRowHeight(s6);
        this.defaultrowheight.setOptionFlags((short) 1);
    }

    public void setDimensions(final int i5, final short s6, final int i6, final short s7) {
        Logger logger = LOGGER;
        logger.atDebug().log("Sheet.setDimensions");
        logger.atDebug().log(new Supplier() { // from class: org.apache.poi.hssf.model.a
            @Override // org.apache.logging.log4j.util.Supplier
            public final Object get() {
                return InternalSheet.lambda$setDimensions$0(i5, s6, i6, s7);
            }
        });
        this._dimensions.setFirstCol(s6);
        this._dimensions.setFirstRow(i5);
        this._dimensions.setLastCol(s7);
        this._dimensions.setLastRow(i6);
        logger.atDebug().log("Sheet.setDimensions exiting");
    }

    public void setDisplayFormulas(boolean z6) {
        this.windowTwo.setDisplayFormulas(z6);
    }

    public void setDisplayGridlines(boolean z6) {
        this.windowTwo.setDisplayGridlines(z6);
    }

    public void setDisplayRowColHeadings(boolean z6) {
        this.windowTwo.setDisplayRowColHeadings(z6);
    }

    public void setGridsPrinted(boolean z6) {
        this.gridset.setGridset(!z6);
    }

    public void setLeftCol(short s6) {
        WindowTwoRecord windowTwoRecord = this.windowTwo;
        if (windowTwoRecord != null) {
            windowTwoRecord.setLeftCol(s6);
        }
    }

    public void setPrintGridlines(PrintGridlinesRecord printGridlinesRecord) {
        this.printGridlines = printGridlinesRecord;
    }

    public void setPrintHeaders(PrintHeadersRecord printHeadersRecord) {
        this.printHeaders = printHeadersRecord;
    }

    public void setPrintRowColHeadings(boolean z6) {
        this.windowTwo.setDisplayRowColHeadings(z6);
    }

    public void setSCLRecord(SCLRecord sCLRecord) {
        int iFindFirstRecordLocBySid = findFirstRecordLocBySid((short) 160);
        if (iFindFirstRecordLocBySid != -1) {
            this._records.set(iFindFirstRecordLocBySid, sCLRecord);
        } else {
            this._records.add(findFirstRecordLocBySid(WindowTwoRecord.sid) + 1, sCLRecord);
        }
    }

    public void setSelected(boolean z6) {
        this.windowTwo.setSelected(z6);
    }

    public void setSelection(SelectionRecord selectionRecord) {
        this._selection = selectionRecord;
    }

    public void setTopRow(short s6) {
        WindowTwoRecord windowTwoRecord = this.windowTwo;
        if (windowTwoRecord != null) {
            windowTwoRecord.setTopRow(s6);
        }
    }

    public void setUncalced(boolean z6) {
        this._isUncalced = z6;
    }

    public void updateFormulasAfterCellShift(FormulaShifter formulaShifter, int i5) {
        getRowsAggregate().updateFormulasAfterRowShift(formulaShifter, i5);
        if (this.condFormatting != null) {
            getConditionalFormattingTable().updateFormulasAfterCellShift(formulaShifter, i5);
        }
    }

    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor, int i5) {
        RecordAggregate.PositionTrackingVisitor positionTrackingVisitor = new RecordAggregate.PositionTrackingVisitor(recordVisitor, i5);
        boolean z6 = false;
        for (int i6 = 0; i6 < this._records.size(); i6++) {
            RecordBase recordBase = this._records.get(i6);
            if (recordBase instanceof RecordAggregate) {
                ((RecordAggregate) recordBase).visitContainedRecords(positionTrackingVisitor);
            } else if (recordBase instanceof Record) {
                positionTrackingVisitor.visitRecord((Record) recordBase);
            }
            if ((recordBase instanceof BOFRecord) && !z6) {
                if (this._isUncalced) {
                    positionTrackingVisitor.visitRecord(new UncalcedRecord());
                }
                if (this._rowsAggregate != null) {
                    positionTrackingVisitor.visitRecord(this._rowsAggregate.createIndexRecord(positionTrackingVisitor.getPosition(), getSizeOfInitialSheetRecords(i6)));
                }
                z6 = true;
            }
        }
    }

    public static InternalSheet createSheet() {
        return new InternalSheet();
    }

    private InternalSheet() {
        this.defaultcolwidth = new DefaultColWidthRecord();
        this.defaultrowheight = new DefaultRowHeightRecord();
        WorksheetProtectionBlock worksheetProtectionBlock = new WorksheetProtectionBlock();
        this._protectionBlock = worksheetProtectionBlock;
        MergedCellsTable mergedCellsTable = new MergedCellsTable();
        this._mergedCellsTable = mergedCellsTable;
        ArrayList arrayList = new ArrayList(32);
        Logger logger = LOGGER;
        logger.atDebug().log("Sheet createsheet from scratch called");
        arrayList.add(createBOF());
        arrayList.add(createCalcMode());
        arrayList.add(createCalcCount());
        arrayList.add(createRefMode());
        arrayList.add(createIteration());
        arrayList.add(createDelta());
        arrayList.add(createSaveRecalc());
        PrintHeadersRecord printHeadersRecordCreatePrintHeaders = createPrintHeaders();
        this.printHeaders = printHeadersRecordCreatePrintHeaders;
        arrayList.add(printHeadersRecordCreatePrintHeaders);
        PrintGridlinesRecord printGridlinesRecordCreatePrintGridlines = createPrintGridlines();
        this.printGridlines = printGridlinesRecordCreatePrintGridlines;
        arrayList.add(printGridlinesRecordCreatePrintGridlines);
        GridsetRecord gridsetRecordCreateGridset = createGridset();
        this.gridset = gridsetRecordCreateGridset;
        arrayList.add(gridsetRecordCreateGridset);
        GutsRecord gutsRecordCreateGuts = createGuts();
        this._gutsRecord = gutsRecordCreateGuts;
        arrayList.add(gutsRecordCreateGuts);
        DefaultRowHeightRecord defaultRowHeightRecordCreateDefaultRowHeight = createDefaultRowHeight();
        this.defaultrowheight = defaultRowHeightRecordCreateDefaultRowHeight;
        arrayList.add(defaultRowHeightRecordCreateDefaultRowHeight);
        arrayList.add(createWSBool());
        PageSettingsBlock pageSettingsBlock = new PageSettingsBlock();
        this._psBlock = pageSettingsBlock;
        arrayList.add(pageSettingsBlock);
        arrayList.add(worksheetProtectionBlock);
        DefaultColWidthRecord defaultColWidthRecordCreateDefaultColWidth = createDefaultColWidth();
        this.defaultcolwidth = defaultColWidthRecordCreateDefaultColWidth;
        arrayList.add(defaultColWidthRecordCreateDefaultColWidth);
        ColumnInfoRecordsAggregate columnInfoRecordsAggregate = new ColumnInfoRecordsAggregate();
        arrayList.add(columnInfoRecordsAggregate);
        this._columnInfos = columnInfoRecordsAggregate;
        DimensionsRecord dimensionsRecordCreateDimensions = createDimensions();
        this._dimensions = dimensionsRecordCreateDimensions;
        arrayList.add(dimensionsRecordCreateDimensions);
        RowRecordsAggregate rowRecordsAggregate = new RowRecordsAggregate();
        this._rowsAggregate = rowRecordsAggregate;
        arrayList.add(rowRecordsAggregate);
        WindowTwoRecord windowTwoRecordCreateWindowTwo = createWindowTwo();
        this.windowTwo = windowTwoRecordCreateWindowTwo;
        arrayList.add(windowTwoRecordCreateWindowTwo);
        SelectionRecord selectionRecordCreateSelection = createSelection();
        this._selection = selectionRecordCreateSelection;
        arrayList.add(selectionRecordCreateSelection);
        arrayList.add(mergedCellsTable);
        arrayList.add(EOFRecord.instance);
        this._records = arrayList;
        logger.atDebug().log("Sheet createsheet from scratch exit");
    }
}
