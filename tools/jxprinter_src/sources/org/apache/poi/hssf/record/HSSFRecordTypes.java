package org.apache.poi.hssf.record;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.poi.hssf.record.chart.AreaFormatRecord;
import org.apache.poi.hssf.record.chart.AreaRecord;
import org.apache.poi.hssf.record.chart.AxisLineFormatRecord;
import org.apache.poi.hssf.record.chart.AxisOptionsRecord;
import org.apache.poi.hssf.record.chart.AxisParentRecord;
import org.apache.poi.hssf.record.chart.AxisRecord;
import org.apache.poi.hssf.record.chart.AxisUsedRecord;
import org.apache.poi.hssf.record.chart.BarRecord;
import org.apache.poi.hssf.record.chart.BeginRecord;
import org.apache.poi.hssf.record.chart.CatLabRecord;
import org.apache.poi.hssf.record.chart.CategorySeriesAxisRecord;
import org.apache.poi.hssf.record.chart.ChartEndBlockRecord;
import org.apache.poi.hssf.record.chart.ChartEndObjectRecord;
import org.apache.poi.hssf.record.chart.ChartFRTInfoRecord;
import org.apache.poi.hssf.record.chart.ChartFormatRecord;
import org.apache.poi.hssf.record.chart.ChartRecord;
import org.apache.poi.hssf.record.chart.ChartStartBlockRecord;
import org.apache.poi.hssf.record.chart.ChartStartObjectRecord;
import org.apache.poi.hssf.record.chart.ChartTitleFormatRecord;
import org.apache.poi.hssf.record.chart.DatRecord;
import org.apache.poi.hssf.record.chart.DataFormatRecord;
import org.apache.poi.hssf.record.chart.DataLabelExtensionRecord;
import org.apache.poi.hssf.record.chart.DefaultDataLabelTextPropertiesRecord;
import org.apache.poi.hssf.record.chart.EndRecord;
import org.apache.poi.hssf.record.chart.FontBasisRecord;
import org.apache.poi.hssf.record.chart.FontIndexRecord;
import org.apache.poi.hssf.record.chart.FrameRecord;
import org.apache.poi.hssf.record.chart.LegendRecord;
import org.apache.poi.hssf.record.chart.LineFormatRecord;
import org.apache.poi.hssf.record.chart.LinkedDataRecord;
import org.apache.poi.hssf.record.chart.NumberFormatIndexRecord;
import org.apache.poi.hssf.record.chart.ObjectLinkRecord;
import org.apache.poi.hssf.record.chart.PlotAreaRecord;
import org.apache.poi.hssf.record.chart.PlotGrowthRecord;
import org.apache.poi.hssf.record.chart.SeriesChartGroupIndexRecord;
import org.apache.poi.hssf.record.chart.SeriesIndexRecord;
import org.apache.poi.hssf.record.chart.SeriesLabelsRecord;
import org.apache.poi.hssf.record.chart.SeriesListRecord;
import org.apache.poi.hssf.record.chart.SeriesRecord;
import org.apache.poi.hssf.record.chart.SeriesTextRecord;
import org.apache.poi.hssf.record.chart.SheetPropertiesRecord;
import org.apache.poi.hssf.record.chart.TextRecord;
import org.apache.poi.hssf.record.chart.TickRecord;
import org.apache.poi.hssf.record.chart.UnitsRecord;
import org.apache.poi.hssf.record.chart.ValueRangeRecord;
import org.apache.poi.hssf.record.pivottable.DataItemRecord;
import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;
import org.apache.poi.hssf.record.pivottable.PageItemRecord;
import org.apache.poi.hssf.record.pivottable.StreamIDRecord;
import org.apache.poi.hssf.record.pivottable.ViewDefinitionRecord;
import org.apache.poi.hssf.record.pivottable.ViewFieldsRecord;
import org.apache.poi.hssf.record.pivottable.ViewSourceRecord;
import org.opencv.videoio.Videoio;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'FORMULA' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFRecordTypes {
    private static final /* synthetic */ HSSFRecordTypes[] $VALUES;
    public static final HSSFRecordTypes AREA;
    public static final HSSFRecordTypes AREA_FORMAT;
    public static final HSSFRecordTypes ARRAY;
    public static final HSSFRecordTypes AUTO_FILTER_INFO;
    public static final HSSFRecordTypes AXIS;
    public static final HSSFRecordTypes AXIS_LINE_FORMAT;
    public static final HSSFRecordTypes AXIS_OPTIONS;
    public static final HSSFRecordTypes AXIS_PARENT;
    public static final HSSFRecordTypes AXIS_USED;
    public static final HSSFRecordTypes BACKUP;
    public static final HSSFRecordTypes BAR;
    public static final HSSFRecordTypes BEGIN;
    public static final HSSFRecordTypes BLANK;
    public static final HSSFRecordTypes BOF;
    public static final HSSFRecordTypes BOOK_BOOL;
    public static final HSSFRecordTypes BOOL_ERR;
    public static final HSSFRecordTypes BOTTOM_MARGIN;
    public static final HSSFRecordTypes BOUND_SHEET;
    public static final HSSFRecordTypes CALC_COUNT;
    public static final HSSFRecordTypes CALC_MODE;
    public static final HSSFRecordTypes CATEGORY_SERIES_AXIS;
    public static final HSSFRecordTypes CAT_LAB;
    public static final HSSFRecordTypes CF_HEADER;
    public static final HSSFRecordTypes CF_HEADER_12;
    public static final HSSFRecordTypes CF_RULE;
    public static final HSSFRecordTypes CF_RULE_12;
    public static final HSSFRecordTypes CHART;
    public static final HSSFRecordTypes CHART_END_BLOCK;
    public static final HSSFRecordTypes CHART_END_OBJECT;
    public static final HSSFRecordTypes CHART_FORMAT;
    public static final HSSFRecordTypes CHART_FRT_INFO;
    public static final HSSFRecordTypes CHART_START_BLOCK;
    public static final HSSFRecordTypes CHART_START_OBJECT;
    public static final HSSFRecordTypes CHART_TITLE_FORMAT;
    public static final HSSFRecordTypes CODEPAGE;
    public static final HSSFRecordTypes COLUMN_INFO;
    public static final HSSFRecordTypes CONTINUE;
    public static final HSSFRecordTypes COUNTRY;
    public static final HSSFRecordTypes CRN;
    public static final HSSFRecordTypes CRN_COUNT;
    public static final HSSFRecordTypes DAT;
    public static final HSSFRecordTypes DATA_FORMAT;
    public static final HSSFRecordTypes DATA_ITEM;
    public static final HSSFRecordTypes DATA_LABEL_EXTENSION;
    public static final HSSFRecordTypes DATE_WINDOW_1904;
    public static final HSSFRecordTypes DB_CELL;
    public static final HSSFRecordTypes DCON_REF;
    public static final HSSFRecordTypes DEFAULT_COL_WIDTH;
    public static final HSSFRecordTypes DEFAULT_DATA_LABEL_TEXT_PROPERTIES;
    public static final HSSFRecordTypes DEFAULT_ROW_HEIGHT;
    public static final HSSFRecordTypes DELTA;
    public static final HSSFRecordTypes DIMENSIONS;
    public static final HSSFRecordTypes DRAWING;
    public static final HSSFRecordTypes DRAWING_GROUP;
    public static final HSSFRecordTypes DRAWING_SELECTION;
    public static final HSSFRecordTypes DSF;
    public static final HSSFRecordTypes DV;
    public static final HSSFRecordTypes DVAL;
    public static final HSSFRecordTypes END;
    public static final HSSFRecordTypes EOF;
    public static final HSSFRecordTypes ESCHER_AGGREGATE;
    public static final HSSFRecordTypes EXTENDED_FORMAT;
    public static final HSSFRecordTypes EXTENDED_PIVOT_TABLE_VIEW_FIELDS;
    public static final HSSFRecordTypes EXTERNAL_NAME;
    public static final HSSFRecordTypes EXTERN_SHEET;
    public static final HSSFRecordTypes EXT_SST;
    public static final HSSFRecordTypes FEAT;
    public static final HSSFRecordTypes FEAT_HDR;
    public static final HSSFRecordTypes FILE_PASS;
    public static final HSSFRecordTypes FILE_SHARING;
    public static final HSSFRecordTypes FN_GROUP_COUNT;
    public static final HSSFRecordTypes FONT;
    public static final HSSFRecordTypes FONT_BASIS;
    public static final HSSFRecordTypes FONT_INDEX;
    public static final HSSFRecordTypes FOOTER;
    public static final HSSFRecordTypes FORMAT;
    public static final HSSFRecordTypes FORMULA;
    public static final HSSFRecordTypes FRAME;
    public static final HSSFRecordTypes GRIDSET;
    public static final HSSFRecordTypes GUTS;
    public static final HSSFRecordTypes HEADER;
    public static final HSSFRecordTypes HEADER_FOOTER;
    public static final HSSFRecordTypes HIDE_OBJ;
    public static final HSSFRecordTypes HORIZONTAL_PAGE_BREAK;
    public static final HSSFRecordTypes HYPERLINK;
    public static final HSSFRecordTypes H_CENTER;
    public static final HSSFRecordTypes INDEX;
    public static final HSSFRecordTypes INTERFACE_END;
    public static final HSSFRecordTypes INTERFACE_HDR;
    public static final HSSFRecordTypes ITERATION;
    public static final HSSFRecordTypes LABEL;
    public static final HSSFRecordTypes LABEL_SST;
    public static final HSSFRecordTypes LEFT_MARGIN;
    public static final HSSFRecordTypes LEGEND;
    public static final HSSFRecordTypes LINE_FORMAT;
    public static final HSSFRecordTypes LINKED_DATA;
    private static final Map<Short, HSSFRecordTypes> LOOKUP;
    public static final HSSFRecordTypes MERGE_CELLS;
    public static final HSSFRecordTypes MMS;
    public static final HSSFRecordTypes MUL_BLANK;
    public static final HSSFRecordTypes MUL_RK;
    public static final HSSFRecordTypes NAME;
    public static final HSSFRecordTypes NAME_COMMENT;
    public static final HSSFRecordTypes NOTE;
    public static final HSSFRecordTypes NUMBER;
    public static final HSSFRecordTypes NUMBER_FORMAT_INDEX;
    public static final HSSFRecordTypes OBJ;
    public static final HSSFRecordTypes OBJECT_LINK;
    public static final HSSFRecordTypes OBJECT_PROTECT;
    public static final HSSFRecordTypes PAGE_ITEM;
    public static final HSSFRecordTypes PALETTE;
    public static final HSSFRecordTypes PANE;
    public static final HSSFRecordTypes PASSWORD;
    public static final HSSFRecordTypes PASSWORD_REV_4;
    public static final HSSFRecordTypes PLOT_AREA;
    public static final HSSFRecordTypes PLOT_GROWTH;
    public static final HSSFRecordTypes PRECISION;
    public static final HSSFRecordTypes PRINT_GRIDLINES;
    public static final HSSFRecordTypes PRINT_HEADERS;
    public static final HSSFRecordTypes PRINT_SETUP;
    public static final HSSFRecordTypes PROTECT;
    public static final HSSFRecordTypes PROTECTION_REV_4;
    public static final HSSFRecordTypes RECALC_ID;
    public static final HSSFRecordTypes REFRESH_ALL;
    public static final HSSFRecordTypes REF_MODE;
    public static final HSSFRecordTypes RIGHT_MARGIN;
    public static final HSSFRecordTypes RK;
    public static final HSSFRecordTypes ROW;
    public static final HSSFRecordTypes SAVE_RECALC;
    public static final HSSFRecordTypes SCENARIO_PROTECT;
    public static final HSSFRecordTypes SCL;
    public static final HSSFRecordTypes SELECTION;
    public static final HSSFRecordTypes SERIES;
    public static final HSSFRecordTypes SERIES_CHART_GROUP_INDEX;
    public static final HSSFRecordTypes SERIES_INDEX;
    public static final HSSFRecordTypes SERIES_LABELS;
    public static final HSSFRecordTypes SERIES_LIST;
    public static final HSSFRecordTypes SERIES_TEXT;
    public static final HSSFRecordTypes SHARED_FORMULA;
    public static final HSSFRecordTypes SHEET_PROPERTIES;
    public static final HSSFRecordTypes SST;
    public static final HSSFRecordTypes STREAM_ID;
    public static final HSSFRecordTypes STRING;
    public static final HSSFRecordTypes STYLE;
    public static final HSSFRecordTypes SUP_BOOK;
    public static final HSSFRecordTypes TABLE;
    public static final HSSFRecordTypes TABLE_STYLES;
    public static final HSSFRecordTypes TAB_ID;
    public static final HSSFRecordTypes TEXT;
    public static final HSSFRecordTypes TEXT_OBJECT;
    public static final HSSFRecordTypes TICK;
    public static final HSSFRecordTypes TOP_MARGIN;
    public static final HSSFRecordTypes UNCALCED;
    public static final HSSFRecordTypes UNITS;
    public static final HSSFRecordTypes UNKNOWN;
    public static final HSSFRecordTypes USER_SVIEW_BEGIN;
    public static final HSSFRecordTypes USER_SVIEW_END;
    public static final HSSFRecordTypes USE_SEL_FS;
    public static final HSSFRecordTypes VALUE_RANGE;
    public static final HSSFRecordTypes VERTICAL_PAGE_BREAK;
    public static final HSSFRecordTypes VIEW_DEFINITION;
    public static final HSSFRecordTypes VIEW_FIELDS;
    public static final HSSFRecordTypes VIEW_SOURCE;
    public static final HSSFRecordTypes V_CENTER;
    public static final HSSFRecordTypes WINDOW_ONE;
    public static final HSSFRecordTypes WINDOW_PROTECT;
    public static final HSSFRecordTypes WINDOW_TWO;
    public static final HSSFRecordTypes WRITE_ACCESS;
    public static final HSSFRecordTypes WRITE_PROTECT;
    public static final HSSFRecordTypes WS_BOOL;
    public final Class<? extends Record> clazz;
    public final boolean parse;
    public final RecordConstructor<? extends Record> recordConstructor;
    public final short sid;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @FunctionalInterface
    public interface RecordConstructor<T extends Record> {
        T apply(RecordInputStream recordInputStream);
    }

    static {
        HSSFRecordTypes hSSFRecordTypes = new HSSFRecordTypes("UNKNOWN", 0, -1, UnknownRecord.class, new P0(1), false);
        UNKNOWN = hSSFRecordTypes;
        final int i5 = 29;
        HSSFRecordTypes hSSFRecordTypes2 = new HSSFRecordTypes("FORMULA", 1, 6, FormulaRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i5) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        FORMULA = hSSFRecordTypes2;
        HSSFRecordTypes hSSFRecordTypes3 = new HSSFRecordTypes("EOF", 2, 10, EOFRecord.class, new Z(11));
        EOF = hSSFRecordTypes3;
        HSSFRecordTypes hSSFRecordTypes4 = new HSSFRecordTypes("CALC_COUNT", 3, 12, CalcCountRecord.class, new P0(5));
        CALC_COUNT = hSSFRecordTypes4;
        HSSFRecordTypes hSSFRecordTypes5 = new HSSFRecordTypes("CALC_MODE", 4, 13, CalcModeRecord.class, new P0(17));
        CALC_MODE = hSSFRecordTypes5;
        HSSFRecordTypes hSSFRecordTypes6 = new HSSFRecordTypes("PRECISION", 5, 14, PrecisionRecord.class, new P0(29));
        PRECISION = hSSFRecordTypes6;
        final int i6 = 11;
        HSSFRecordTypes hSSFRecordTypes7 = new HSSFRecordTypes("REF_MODE", 6, 15, RefModeRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i6) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        REF_MODE = hSSFRecordTypes7;
        final int i7 = 23;
        HSSFRecordTypes hSSFRecordTypes8 = new HSSFRecordTypes("DELTA", 7, 16, DeltaRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i7) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        DELTA = hSSFRecordTypes8;
        final int i8 = 5;
        HSSFRecordTypes hSSFRecordTypes9 = new HSSFRecordTypes("ITERATION", 8, 17, IterationRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i8) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        ITERATION = hSSFRecordTypes9;
        final int i9 = 17;
        HSSFRecordTypes hSSFRecordTypes10 = new HSSFRecordTypes("PROTECT", 9, 18, ProtectRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i9) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        PROTECT = hSSFRecordTypes10;
        HSSFRecordTypes hSSFRecordTypes11 = new HSSFRecordTypes("PASSWORD", 10, 19, PasswordRecord.class, new P0(23));
        PASSWORD = hSSFRecordTypes11;
        final int i10 = 25;
        HSSFRecordTypes hSSFRecordTypes12 = new HSSFRecordTypes("HEADER", 11, 20, HeaderRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i10) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        HEADER = hSSFRecordTypes12;
        final int i11 = 7;
        HSSFRecordTypes hSSFRecordTypes13 = new HSSFRecordTypes("FOOTER", 12, 21, FooterRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i11) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        FOOTER = hSSFRecordTypes13;
        final int i12 = 19;
        HSSFRecordTypes hSSFRecordTypes14 = new HSSFRecordTypes("EXTERN_SHEET", 13, 23, ExternSheetRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i12) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        EXTERN_SHEET = hSSFRecordTypes14;
        final int i13 = 1;
        HSSFRecordTypes hSSFRecordTypes15 = new HSSFRecordTypes("NAME", 14, 24, NameRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i13) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        NAME = hSSFRecordTypes15;
        final int i14 = 13;
        HSSFRecordTypes hSSFRecordTypes16 = new HSSFRecordTypes("WINDOW_PROTECT", 15, 25, WindowProtectRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i14) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        WINDOW_PROTECT = hSSFRecordTypes16;
        final int i15 = 24;
        HSSFRecordTypes hSSFRecordTypes17 = new HSSFRecordTypes("VERTICAL_PAGE_BREAK", 16, 26, VerticalPageBreakRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i15) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        VERTICAL_PAGE_BREAK = hSSFRecordTypes17;
        final int i16 = 25;
        HSSFRecordTypes hSSFRecordTypes18 = new HSSFRecordTypes("HORIZONTAL_PAGE_BREAK", 17, 27, HorizontalPageBreakRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i16) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        HORIZONTAL_PAGE_BREAK = hSSFRecordTypes18;
        final int i17 = 26;
        HSSFRecordTypes hSSFRecordTypes19 = new HSSFRecordTypes("NOTE", 18, 28, NoteRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i17) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        NOTE = hSSFRecordTypes19;
        final int i18 = 28;
        HSSFRecordTypes hSSFRecordTypes20 = new HSSFRecordTypes("SELECTION", 19, 29, SelectionRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i18) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        SELECTION = hSSFRecordTypes20;
        HSSFRecordTypes hSSFRecordTypes21 = new HSSFRecordTypes("DATE_WINDOW_1904", 20, 34, DateWindow1904Record.class, new Z(0));
        DATE_WINDOW_1904 = hSSFRecordTypes21;
        HSSFRecordTypes hSSFRecordTypes22 = new HSSFRecordTypes("EXTERNAL_NAME", 21, 35, ExternalNameRecord.class, new Z(1));
        EXTERNAL_NAME = hSSFRecordTypes22;
        HSSFRecordTypes hSSFRecordTypes23 = new HSSFRecordTypes("LEFT_MARGIN", 22, 38, LeftMarginRecord.class, new Z(2));
        LEFT_MARGIN = hSSFRecordTypes23;
        HSSFRecordTypes hSSFRecordTypes24 = new HSSFRecordTypes("RIGHT_MARGIN", 23, 39, RightMarginRecord.class, new Z(3));
        RIGHT_MARGIN = hSSFRecordTypes24;
        HSSFRecordTypes hSSFRecordTypes25 = new HSSFRecordTypes("TOP_MARGIN", 24, 40, TopMarginRecord.class, new Z(4));
        TOP_MARGIN = hSSFRecordTypes25;
        HSSFRecordTypes hSSFRecordTypes26 = new HSSFRecordTypes("BOTTOM_MARGIN", 25, 41, BottomMarginRecord.class, new Z(5));
        BOTTOM_MARGIN = hSSFRecordTypes26;
        HSSFRecordTypes hSSFRecordTypes27 = new HSSFRecordTypes("PRINT_HEADERS", 26, 42, PrintHeadersRecord.class, new Z(6));
        PRINT_HEADERS = hSSFRecordTypes27;
        HSSFRecordTypes hSSFRecordTypes28 = new HSSFRecordTypes("PRINT_GRIDLINES", 27, 43, PrintGridlinesRecord.class, new Z(7));
        PRINT_GRIDLINES = hSSFRecordTypes28;
        HSSFRecordTypes hSSFRecordTypes29 = new HSSFRecordTypes("FILE_PASS", 28, 47, FilePassRecord.class, new Z(9));
        FILE_PASS = hSSFRecordTypes29;
        HSSFRecordTypes hSSFRecordTypes30 = new HSSFRecordTypes("FONT", 29, 49, FontRecord.class, new Z(10));
        FONT = hSSFRecordTypes30;
        HSSFRecordTypes hSSFRecordTypes31 = new HSSFRecordTypes("CONTINUE", 30, 60, ContinueRecord.class, new Z(12));
        CONTINUE = hSSFRecordTypes31;
        HSSFRecordTypes hSSFRecordTypes32 = new HSSFRecordTypes("WINDOW_ONE", 31, 61, WindowOneRecord.class, new Z(13));
        WINDOW_ONE = hSSFRecordTypes32;
        HSSFRecordTypes hSSFRecordTypes33 = new HSSFRecordTypes("BACKUP", 32, 64, BackupRecord.class, new Z(14));
        BACKUP = hSSFRecordTypes33;
        HSSFRecordTypes hSSFRecordTypes34 = new HSSFRecordTypes("PANE", 33, 65, PaneRecord.class, new Z(15));
        PANE = hSSFRecordTypes34;
        HSSFRecordTypes hSSFRecordTypes35 = new HSSFRecordTypes("CODEPAGE", 34, 66, CodepageRecord.class, new Z(16));
        CODEPAGE = hSSFRecordTypes35;
        HSSFRecordTypes hSSFRecordTypes36 = new HSSFRecordTypes("DCON_REF", 35, 81, DConRefRecord.class, new Z(17));
        DCON_REF = hSSFRecordTypes36;
        HSSFRecordTypes hSSFRecordTypes37 = new HSSFRecordTypes("DEFAULT_COL_WIDTH", 36, 85, DefaultColWidthRecord.class, new Z(18));
        DEFAULT_COL_WIDTH = hSSFRecordTypes37;
        HSSFRecordTypes hSSFRecordTypes38 = new HSSFRecordTypes("CRN_COUNT", 37, 89, CRNCountRecord.class, new P0(2));
        CRN_COUNT = hSSFRecordTypes38;
        HSSFRecordTypes hSSFRecordTypes39 = new HSSFRecordTypes("CRN", 38, 90, CRNRecord.class, new P0(3));
        CRN = hSSFRecordTypes39;
        HSSFRecordTypes hSSFRecordTypes40 = new HSSFRecordTypes("WRITE_ACCESS", 39, 92, WriteAccessRecord.class, new P0(4));
        WRITE_ACCESS = hSSFRecordTypes40;
        HSSFRecordTypes hSSFRecordTypes41 = new HSSFRecordTypes("FILE_SHARING", 40, 91, FileSharingRecord.class, new P0(6));
        FILE_SHARING = hSSFRecordTypes41;
        HSSFRecordTypes hSSFRecordTypes42 = new HSSFRecordTypes("OBJ", 41, 93, ObjRecord.class, new P0(7));
        OBJ = hSSFRecordTypes42;
        HSSFRecordTypes hSSFRecordTypes43 = new HSSFRecordTypes("UNCALCED", 42, 94, UncalcedRecord.class, new P0(8));
        UNCALCED = hSSFRecordTypes43;
        HSSFRecordTypes hSSFRecordTypes44 = new HSSFRecordTypes("SAVE_RECALC", 43, 95, SaveRecalcRecord.class, new P0(9));
        SAVE_RECALC = hSSFRecordTypes44;
        HSSFRecordTypes hSSFRecordTypes45 = new HSSFRecordTypes("OBJECT_PROTECT", 44, 99, ObjectProtectRecord.class, new P0(10));
        OBJECT_PROTECT = hSSFRecordTypes45;
        HSSFRecordTypes hSSFRecordTypes46 = new HSSFRecordTypes("COLUMN_INFO", 45, 125, ColumnInfoRecord.class, new P0(11));
        COLUMN_INFO = hSSFRecordTypes46;
        HSSFRecordTypes hSSFRecordTypes47 = new HSSFRecordTypes("GUTS", 46, 128, GutsRecord.class, new P0(13));
        GUTS = hSSFRecordTypes47;
        HSSFRecordTypes hSSFRecordTypes48 = new HSSFRecordTypes("WS_BOOL", 47, 129, WSBoolRecord.class, new P0(14));
        WS_BOOL = hSSFRecordTypes48;
        HSSFRecordTypes hSSFRecordTypes49 = new HSSFRecordTypes("GRIDSET", 48, 130, GridsetRecord.class, new P0(15));
        GRIDSET = hSSFRecordTypes49;
        HSSFRecordTypes hSSFRecordTypes50 = new HSSFRecordTypes("H_CENTER", 49, 131, HCenterRecord.class, new P0(16));
        H_CENTER = hSSFRecordTypes50;
        HSSFRecordTypes hSSFRecordTypes51 = new HSSFRecordTypes("V_CENTER", 50, 132, VCenterRecord.class, new P0(18));
        V_CENTER = hSSFRecordTypes51;
        HSSFRecordTypes hSSFRecordTypes52 = new HSSFRecordTypes("BOUND_SHEET", 51, 133, BoundSheetRecord.class, new P0(19));
        BOUND_SHEET = hSSFRecordTypes52;
        HSSFRecordTypes hSSFRecordTypes53 = new HSSFRecordTypes("WRITE_PROTECT", 52, 134, WriteProtectRecord.class, new P0(20));
        WRITE_PROTECT = hSSFRecordTypes53;
        HSSFRecordTypes hSSFRecordTypes54 = new HSSFRecordTypes("COUNTRY", 53, 140, CountryRecord.class, new P0(21));
        COUNTRY = hSSFRecordTypes54;
        HSSFRecordTypes hSSFRecordTypes55 = new HSSFRecordTypes("HIDE_OBJ", 54, 141, HideObjRecord.class, new P0(22));
        HIDE_OBJ = hSSFRecordTypes55;
        HSSFRecordTypes hSSFRecordTypes56 = new HSSFRecordTypes("PALETTE", 55, 146, PaletteRecord.class, new P0(24));
        PALETTE = hSSFRecordTypes56;
        HSSFRecordTypes hSSFRecordTypes57 = new HSSFRecordTypes("FN_GROUP_COUNT", 56, 156, FnGroupCountRecord.class, new P0(25));
        FN_GROUP_COUNT = hSSFRecordTypes57;
        HSSFRecordTypes hSSFRecordTypes58 = new HSSFRecordTypes("AUTO_FILTER_INFO", 57, 157, AutoFilterInfoRecord.class, new P0(26));
        AUTO_FILTER_INFO = hSSFRecordTypes58;
        HSSFRecordTypes hSSFRecordTypes59 = new HSSFRecordTypes("SCL", 58, 160, SCLRecord.class, new P0(27), false);
        SCL = hSSFRecordTypes59;
        HSSFRecordTypes hSSFRecordTypes60 = new HSSFRecordTypes("PRINT_SETUP", 59, 161, PrintSetupRecord.class, new P0(28));
        PRINT_SETUP = hSSFRecordTypes60;
        final int i19 = 0;
        HSSFRecordTypes hSSFRecordTypes61 = new HSSFRecordTypes("VIEW_DEFINITION", 60, 176, ViewDefinitionRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i19) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        VIEW_DEFINITION = hSSFRecordTypes61;
        final int i20 = 1;
        HSSFRecordTypes hSSFRecordTypes62 = new HSSFRecordTypes("VIEW_FIELDS", 61, 177, ViewFieldsRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i20) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        VIEW_FIELDS = hSSFRecordTypes62;
        final int i21 = 2;
        HSSFRecordTypes hSSFRecordTypes63 = new HSSFRecordTypes("PAGE_ITEM", 62, 182, PageItemRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i21) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        PAGE_ITEM = hSSFRecordTypes63;
        final int i22 = 3;
        HSSFRecordTypes hSSFRecordTypes64 = new HSSFRecordTypes("MUL_BLANK", 63, 190, MulBlankRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i22) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        MUL_BLANK = hSSFRecordTypes64;
        final int i23 = 5;
        HSSFRecordTypes hSSFRecordTypes65 = new HSSFRecordTypes("MUL_RK", 64, 189, MulRKRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i23) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        MUL_RK = hSSFRecordTypes65;
        final int i24 = 6;
        HSSFRecordTypes hSSFRecordTypes66 = new HSSFRecordTypes("MMS", 65, 193, MMSRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i24) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        MMS = hSSFRecordTypes66;
        final int i25 = 7;
        HSSFRecordTypes hSSFRecordTypes67 = new HSSFRecordTypes("DATA_ITEM", 66, 197, DataItemRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i25) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        DATA_ITEM = hSSFRecordTypes67;
        final int i26 = 8;
        HSSFRecordTypes hSSFRecordTypes68 = new HSSFRecordTypes("STREAM_ID", 67, 213, StreamIDRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i26) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        STREAM_ID = hSSFRecordTypes68;
        final int i27 = 9;
        HSSFRecordTypes hSSFRecordTypes69 = new HSSFRecordTypes("DB_CELL", 68, 215, DBCellRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i27) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        DB_CELL = hSSFRecordTypes69;
        final int i28 = 10;
        HSSFRecordTypes hSSFRecordTypes70 = new HSSFRecordTypes("BOOK_BOOL", 69, 218, BookBoolRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i28) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        BOOK_BOOL = hSSFRecordTypes70;
        final int i29 = 12;
        HSSFRecordTypes hSSFRecordTypes71 = new HSSFRecordTypes("SCENARIO_PROTECT", 70, 221, ScenarioProtectRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i29) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        SCENARIO_PROTECT = hSSFRecordTypes71;
        final int i30 = 13;
        HSSFRecordTypes hSSFRecordTypes72 = new HSSFRecordTypes("EXTENDED_FORMAT", 71, 224, ExtendedFormatRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i30) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        EXTENDED_FORMAT = hSSFRecordTypes72;
        final int i31 = 14;
        HSSFRecordTypes hSSFRecordTypes73 = new HSSFRecordTypes("INTERFACE_HDR", 72, 225, InterfaceHdrRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i31) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        INTERFACE_HDR = hSSFRecordTypes73;
        final int i32 = 16;
        HSSFRecordTypes hSSFRecordTypes74 = new HSSFRecordTypes("INTERFACE_END", 73, 226, InterfaceEndRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i32) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        INTERFACE_END = hSSFRecordTypes74;
        final int i33 = 17;
        HSSFRecordTypes hSSFRecordTypes75 = new HSSFRecordTypes("VIEW_SOURCE", 74, 227, ViewSourceRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i33) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        VIEW_SOURCE = hSSFRecordTypes75;
        final int i34 = 18;
        HSSFRecordTypes hSSFRecordTypes76 = new HSSFRecordTypes("MERGE_CELLS", 75, 229, MergeCellsRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i34) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        MERGE_CELLS = hSSFRecordTypes76;
        final int i35 = 19;
        HSSFRecordTypes hSSFRecordTypes77 = new HSSFRecordTypes("DRAWING_GROUP", 76, 235, DrawingGroupRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i35) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        DRAWING_GROUP = hSSFRecordTypes77;
        final int i36 = 20;
        HSSFRecordTypes hSSFRecordTypes78 = new HSSFRecordTypes("DRAWING", 77, 236, DrawingRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i36) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        DRAWING = hSSFRecordTypes78;
        final int i37 = 21;
        HSSFRecordTypes hSSFRecordTypes79 = new HSSFRecordTypes("DRAWING_SELECTION", 78, 237, DrawingSelectionRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i37) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        DRAWING_SELECTION = hSSFRecordTypes79;
        final int i38 = 22;
        HSSFRecordTypes hSSFRecordTypes80 = new HSSFRecordTypes("SST", 79, 252, SSTRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i38) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        SST = hSSFRecordTypes80;
        final int i39 = 24;
        HSSFRecordTypes hSSFRecordTypes81 = new HSSFRecordTypes("LABEL_SST", 80, 253, LabelSSTRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i39) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        LABEL_SST = hSSFRecordTypes81;
        final int i40 = 25;
        HSSFRecordTypes hSSFRecordTypes82 = new HSSFRecordTypes("EXT_SST", 81, 255, ExtSSTRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i40) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        EXT_SST = hSSFRecordTypes82;
        final int i41 = 27;
        HSSFRecordTypes hSSFRecordTypes83 = new HSSFRecordTypes("EXTENDED_PIVOT_TABLE_VIEW_FIELDS", 82, 256, ExtendedPivotTableViewFieldsRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i41) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        EXTENDED_PIVOT_TABLE_VIEW_FIELDS = hSSFRecordTypes83;
        final int i42 = 28;
        HSSFRecordTypes hSSFRecordTypes84 = new HSSFRecordTypes("TAB_ID", 83, 317, TabIdRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i42) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        TAB_ID = hSSFRecordTypes84;
        final int i43 = 29;
        HSSFRecordTypes hSSFRecordTypes85 = new HSSFRecordTypes("USE_SEL_FS", 84, 352, UseSelFSRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i43) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        USE_SEL_FS = hSSFRecordTypes85;
        final int i44 = 0;
        HSSFRecordTypes hSSFRecordTypes86 = new HSSFRecordTypes("DSF", 85, 353, DSFRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i44) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        DSF = hSSFRecordTypes86;
        final int i45 = 1;
        HSSFRecordTypes hSSFRecordTypes87 = new HSSFRecordTypes("USER_SVIEW_BEGIN", 86, Videoio.CAP_PROP_XI_DOWNSAMPLING_TYPE, UserSViewBegin.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i45) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        USER_SVIEW_BEGIN = hSSFRecordTypes87;
        final int i46 = 2;
        HSSFRecordTypes hSSFRecordTypes88 = new HSSFRecordTypes("USER_SVIEW_END", 87, Videoio.CAP_PROP_XI_BINNING_SELECTOR, UserSViewEnd.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i46) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        USER_SVIEW_END = hSSFRecordTypes88;
        final int i47 = 3;
        HSSFRecordTypes hSSFRecordTypes89 = new HSSFRecordTypes("SUP_BOOK", 88, Videoio.CAP_PROP_XI_BINNING_PATTERN, SupBookRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i47) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        SUP_BOOK = hSSFRecordTypes89;
        final int i48 = 4;
        HSSFRecordTypes hSSFRecordTypes90 = new HSSFRecordTypes("PROTECTION_REV_4", 89, Videoio.CAP_PROP_XI_DECIMATION_SELECTOR, ProtectionRev4Record.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i48) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        PROTECTION_REV_4 = hSSFRecordTypes90;
        final int i49 = 6;
        HSSFRecordTypes hSSFRecordTypes91 = new HSSFRecordTypes("CF_HEADER", 90, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, CFHeaderRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i49) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        CF_HEADER = hSSFRecordTypes91;
        final int i50 = 8;
        HSSFRecordTypes hSSFRecordTypes92 = new HSSFRecordTypes("CF_RULE", 91, Videoio.CAP_PROP_XI_DECIMATION_HORIZONTAL, CFRuleRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i50) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        CF_RULE = hSSFRecordTypes92;
        final int i51 = 9;
        HSSFRecordTypes hSSFRecordTypes93 = new HSSFRecordTypes("DVAL", 92, Videoio.CAP_PROP_XI_DECIMATION_PATTERN, DVALRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i51) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        DVAL = hSSFRecordTypes93;
        final int i52 = 10;
        HSSFRecordTypes hSSFRecordTypes94 = new HSSFRecordTypes("TEXT_OBJECT", 93, 438, TextObjectRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i52) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        TEXT_OBJECT = hSSFRecordTypes94;
        final int i53 = 11;
        HSSFRecordTypes hSSFRecordTypes95 = new HSSFRecordTypes("REFRESH_ALL", 94, Videoio.CAP_PROP_XI_AEAG_ROI_OFFSET_X, RefreshAllRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i53) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        REFRESH_ALL = hSSFRecordTypes95;
        final int i54 = 12;
        HSSFRecordTypes hSSFRecordTypes96 = new HSSFRecordTypes("HYPERLINK", 95, Videoio.CAP_PROP_XI_AEAG_ROI_OFFSET_Y, HyperlinkRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i54) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        HYPERLINK = hSSFRecordTypes96;
        final int i55 = 13;
        HSSFRecordTypes hSSFRecordTypes97 = new HSSFRecordTypes("PASSWORD_REV_4", 96, 444, PasswordRev4Record.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i55) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        PASSWORD_REV_4 = hSSFRecordTypes97;
        final int i56 = 14;
        HSSFRecordTypes hSSFRecordTypes98 = new HSSFRecordTypes("DV", 97, 446, DVRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i56) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        DV = hSSFRecordTypes98;
        final int i57 = 15;
        HSSFRecordTypes hSSFRecordTypes99 = new HSSFRecordTypes("RECALC_ID", 98, Videoio.CAP_PROP_XI_WB_KG, RecalcIdRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i57) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        RECALC_ID = hSSFRecordTypes99;
        final int i58 = 16;
        HSSFRecordTypes hSSFRecordTypes100 = new HSSFRecordTypes("DIMENSIONS", 99, 512, DimensionsRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i58) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        DIMENSIONS = hSSFRecordTypes100;
        final int i59 = 22;
        HSSFRecordTypes hSSFRecordTypes101 = new HSSFRecordTypes("BLANK", 100, 513, BlankRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i59) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        BLANK = hSSFRecordTypes101;
        final int i60 = 3;
        HSSFRecordTypes hSSFRecordTypes102 = new HSSFRecordTypes("NUMBER", 101, Videoio.CAP_PROP_XI_LENS_FOCUS_DISTANCE, NumberRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i60) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        NUMBER = hSSFRecordTypes102;
        final int i61 = 14;
        HSSFRecordTypes hSSFRecordTypes103 = new HSSFRecordTypes("LABEL", 102, Videoio.CAP_PROP_XI_LENS_FOCAL_LENGTH, LabelRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i61) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        LABEL = hSSFRecordTypes103;
        final int i62 = 25;
        HSSFRecordTypes hSSFRecordTypes104 = new HSSFRecordTypes("BOOL_ERR", 103, Videoio.CAP_PROP_XI_LENS_FEATURE_SELECTOR, BoolErrRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i62) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        BOOL_ERR = hSSFRecordTypes104;
        final int i63 = 6;
        HSSFRecordTypes hSSFRecordTypes105 = new HSSFRecordTypes("STRING", 104, 519, StringRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i63) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        STRING = hSSFRecordTypes105;
        final int i64 = 17;
        HSSFRecordTypes hSSFRecordTypes106 = new HSSFRecordTypes("ROW", 105, 520, RowRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i64) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        ROW = hSSFRecordTypes106;
        final int i65 = 27;
        HSSFRecordTypes hSSFRecordTypes107 = new HSSFRecordTypes("INDEX", 106, 523, IndexRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i65) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        INDEX = hSSFRecordTypes107;
        HSSFRecordTypes hSSFRecordTypes108 = new HSSFRecordTypes("ARRAY", 107, Videoio.CAP_PROP_XI_TS_RST_MODE, ArrayRecord.class, new Z(8));
        ARRAY = hSSFRecordTypes108;
        HSSFRecordTypes hSSFRecordTypes109 = new HSSFRecordTypes("DEFAULT_ROW_HEIGHT", 108, Videoio.CAP_PROP_XI_ACQ_BUFFER_SIZE_UNIT, DefaultRowHeightRecord.class, new Z(19));
        DEFAULT_ROW_HEIGHT = hSSFRecordTypes109;
        HSSFRecordTypes hSSFRecordTypes110 = new HSSFRecordTypes("TABLE", 109, 566, TableRecord.class, new P0(12));
        TABLE = hSSFRecordTypes110;
        final int i66 = 4;
        HSSFRecordTypes hSSFRecordTypes111 = new HSSFRecordTypes("WINDOW_TWO", 110, 574, WindowTwoRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i66) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        WINDOW_TWO = hSSFRecordTypes111;
        final int i67 = 15;
        HSSFRecordTypes hSSFRecordTypes112 = new HSSFRecordTypes("RK", 111, 638, RKRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i67) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        RK = hSSFRecordTypes112;
        final int i68 = 26;
        HSSFRecordTypes hSSFRecordTypes113 = new HSSFRecordTypes("STYLE", 112, 659, StyleRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.V
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i68) {
                    case 0:
                        return new ViewDefinitionRecord(recordInputStream);
                    case 1:
                        return new ViewFieldsRecord(recordInputStream);
                    case 2:
                        return new PageItemRecord(recordInputStream);
                    case 3:
                        return new MulBlankRecord(recordInputStream);
                    case 4:
                        return new WindowTwoRecord(recordInputStream);
                    case 5:
                        return new MulRKRecord(recordInputStream);
                    case 6:
                        return new MMSRecord(recordInputStream);
                    case 7:
                        return new DataItemRecord(recordInputStream);
                    case 8:
                        return new StreamIDRecord(recordInputStream);
                    case 9:
                        return new DBCellRecord(recordInputStream);
                    case 10:
                        return new BookBoolRecord(recordInputStream);
                    case 11:
                        return new RefModeRecord(recordInputStream);
                    case 12:
                        return new ScenarioProtectRecord(recordInputStream);
                    case 13:
                        return new ExtendedFormatRecord(recordInputStream);
                    case 14:
                        return new InterfaceHdrRecord(recordInputStream);
                    case 15:
                        return new RKRecord(recordInputStream);
                    case 16:
                        return InterfaceEndRecord.create(recordInputStream);
                    case 17:
                        return new ViewSourceRecord(recordInputStream);
                    case 18:
                        return new MergeCellsRecord(recordInputStream);
                    case 19:
                        return new DrawingGroupRecord(recordInputStream);
                    case 20:
                        return new DrawingRecord(recordInputStream);
                    case 21:
                        return new DrawingSelectionRecord(recordInputStream);
                    case 22:
                        return new SSTRecord(recordInputStream);
                    case 23:
                        return new DeltaRecord(recordInputStream);
                    case 24:
                        return new LabelSSTRecord(recordInputStream);
                    case 25:
                        return new ExtSSTRecord(recordInputStream);
                    case 26:
                        return new StyleRecord(recordInputStream);
                    case 27:
                        return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
                    case 28:
                        return new TabIdRecord(recordInputStream);
                    default:
                        return new UseSelFSRecord(recordInputStream);
                }
            }
        });
        STYLE = hSSFRecordTypes113;
        final int i69 = 7;
        HSSFRecordTypes hSSFRecordTypes114 = new HSSFRecordTypes("FORMAT", 113, 1054, FormatRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i69) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        FORMAT = hSSFRecordTypes114;
        final int i70 = 18;
        HSSFRecordTypes hSSFRecordTypes115 = new HSSFRecordTypes("SHARED_FORMULA", 114, 1212, SharedFormulaRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i70) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        SHARED_FORMULA = hSSFRecordTypes115;
        final int i71 = 19;
        HSSFRecordTypes hSSFRecordTypes116 = new HSSFRecordTypes("BOF", 115, 2057, BOFRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i71) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        BOF = hSSFRecordTypes116;
        final int i72 = 20;
        HSSFRecordTypes hSSFRecordTypes117 = new HSSFRecordTypes("CHART_FRT_INFO", 116, 2128, ChartFRTInfoRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i72) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        CHART_FRT_INFO = hSSFRecordTypes117;
        final int i73 = 21;
        HSSFRecordTypes hSSFRecordTypes118 = new HSSFRecordTypes("CHART_START_BLOCK", 117, 2130, ChartStartBlockRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i73) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        CHART_START_BLOCK = hSSFRecordTypes118;
        final int i74 = 23;
        HSSFRecordTypes hSSFRecordTypes119 = new HSSFRecordTypes("CHART_END_BLOCK", 118, 2131, ChartEndBlockRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i74) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        CHART_END_BLOCK = hSSFRecordTypes119;
        final int i75 = 24;
        HSSFRecordTypes hSSFRecordTypes120 = new HSSFRecordTypes("CHART_START_OBJECT", 119, 2132, ChartStartObjectRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i75) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        CHART_START_OBJECT = hSSFRecordTypes120;
        final int i76 = 26;
        HSSFRecordTypes hSSFRecordTypes121 = new HSSFRecordTypes("CHART_END_OBJECT", 120, 2133, ChartEndObjectRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i76) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        CHART_END_OBJECT = hSSFRecordTypes121;
        final int i77 = 27;
        HSSFRecordTypes hSSFRecordTypes122 = new HSSFRecordTypes("CAT_LAB", 121, 2134, CatLabRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i77) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        CAT_LAB = hSSFRecordTypes122;
        final int i78 = 28;
        HSSFRecordTypes hSSFRecordTypes123 = new HSSFRecordTypes("FEAT_HDR", 122, UnknownRecord.SHEETPROTECTION_0867, FeatHdrRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i78) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        FEAT_HDR = hSSFRecordTypes123;
        final int i79 = 29;
        HSSFRecordTypes hSSFRecordTypes124 = new HSSFRecordTypes("FEAT", 123, 2152, FeatRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.W
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i79) {
                    case 0:
                        return new DSFRecord(recordInputStream);
                    case 1:
                        return new UserSViewBegin(recordInputStream);
                    case 2:
                        return new UserSViewEnd(recordInputStream);
                    case 3:
                        return new SupBookRecord(recordInputStream);
                    case 4:
                        return new ProtectionRev4Record(recordInputStream);
                    case 5:
                        return new IterationRecord(recordInputStream);
                    case 6:
                        return new CFHeaderRecord(recordInputStream);
                    case 7:
                        return new FormatRecord(recordInputStream);
                    case 8:
                        return new CFRuleRecord(recordInputStream);
                    case 9:
                        return new DVALRecord(recordInputStream);
                    case 10:
                        return new TextObjectRecord(recordInputStream);
                    case 11:
                        return new RefreshAllRecord(recordInputStream);
                    case 12:
                        return new HyperlinkRecord(recordInputStream);
                    case 13:
                        return new PasswordRev4Record(recordInputStream);
                    case 14:
                        return new DVRecord(recordInputStream);
                    case 15:
                        return new RecalcIdRecord(recordInputStream);
                    case 16:
                        return new DimensionsRecord(recordInputStream);
                    case 17:
                        return new ProtectRecord(recordInputStream);
                    case 18:
                        return new SharedFormulaRecord(recordInputStream);
                    case 19:
                        return new BOFRecord(recordInputStream);
                    case 20:
                        return new ChartFRTInfoRecord(recordInputStream);
                    case 21:
                        return new ChartStartBlockRecord(recordInputStream);
                    case 22:
                        return new BlankRecord(recordInputStream);
                    case 23:
                        return new ChartEndBlockRecord(recordInputStream);
                    case 24:
                        return new ChartStartObjectRecord(recordInputStream);
                    case 25:
                        return new HeaderRecord(recordInputStream);
                    case 26:
                        return new ChartEndObjectRecord(recordInputStream);
                    case 27:
                        return new CatLabRecord(recordInputStream);
                    case 28:
                        return new FeatHdrRecord(recordInputStream);
                    default:
                        return new FeatRecord(recordInputStream);
                }
            }
        });
        FEAT = hSSFRecordTypes124;
        final int i80 = 0;
        HSSFRecordTypes hSSFRecordTypes125 = new HSSFRecordTypes("DATA_LABEL_EXTENSION", 124, 2154, DataLabelExtensionRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i80) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        DATA_LABEL_EXTENSION = hSSFRecordTypes125;
        final int i81 = 1;
        HSSFRecordTypes hSSFRecordTypes126 = new HSSFRecordTypes("CF_HEADER_12", 125, 2169, CFHeader12Record.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i81) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        CF_HEADER_12 = hSSFRecordTypes126;
        final int i82 = 2;
        HSSFRecordTypes hSSFRecordTypes127 = new HSSFRecordTypes("CF_RULE_12", 126, 2170, CFRule12Record.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i82) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        CF_RULE_12 = hSSFRecordTypes127;
        final int i83 = 4;
        HSSFRecordTypes hSSFRecordTypes128 = new HSSFRecordTypes("TABLE_STYLES", 127, 2190, TableStylesRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i83) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        TABLE_STYLES = hSSFRecordTypes128;
        final int i84 = 5;
        HSSFRecordTypes hSSFRecordTypes129 = new HSSFRecordTypes("NAME_COMMENT", 128, 2196, NameCommentRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i84) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        NAME_COMMENT = hSSFRecordTypes129;
        final int i85 = 6;
        HSSFRecordTypes hSSFRecordTypes130 = new HSSFRecordTypes("HEADER_FOOTER", 129, UnknownRecord.HEADER_FOOTER_089C, HeaderFooterRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i85) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        HEADER_FOOTER = hSSFRecordTypes130;
        final int i86 = 8;
        HSSFRecordTypes hSSFRecordTypes131 = new HSSFRecordTypes("UNITS", 130, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, UnitsRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i86) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        UNITS = hSSFRecordTypes131;
        final int i87 = 9;
        HSSFRecordTypes hSSFRecordTypes132 = new HSSFRecordTypes("CHART", 131, InputDeviceCompat.SOURCE_TOUCHSCREEN, ChartRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i87) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        CHART = hSSFRecordTypes132;
        final int i88 = 10;
        HSSFRecordTypes hSSFRecordTypes133 = new HSSFRecordTypes("SERIES", 132, FragmentTransaction.TRANSIT_FRAGMENT_FADE, SeriesRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i88) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        SERIES = hSSFRecordTypes133;
        final int i89 = 11;
        HSSFRecordTypes hSSFRecordTypes134 = new HSSFRecordTypes("DATA_FORMAT", 133, 4102, DataFormatRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i89) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        DATA_FORMAT = hSSFRecordTypes134;
        final int i90 = 12;
        HSSFRecordTypes hSSFRecordTypes135 = new HSSFRecordTypes("LINE_FORMAT", 134, 4103, LineFormatRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i90) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        LINE_FORMAT = hSSFRecordTypes135;
        final int i91 = 13;
        HSSFRecordTypes hSSFRecordTypes136 = new HSSFRecordTypes("AREA_FORMAT", 135, 4106, AreaFormatRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i91) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        AREA_FORMAT = hSSFRecordTypes136;
        final int i92 = 15;
        HSSFRecordTypes hSSFRecordTypes137 = new HSSFRecordTypes("SERIES_LABELS", 136, 4108, SeriesLabelsRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i92) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        SERIES_LABELS = hSSFRecordTypes137;
        final int i93 = 16;
        HSSFRecordTypes hSSFRecordTypes138 = new HSSFRecordTypes("SERIES_TEXT", 137, 4109, SeriesTextRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i93) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        SERIES_TEXT = hSSFRecordTypes138;
        final int i94 = 17;
        HSSFRecordTypes hSSFRecordTypes139 = new HSSFRecordTypes("CHART_FORMAT", 138, 4116, ChartFormatRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i94) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        CHART_FORMAT = hSSFRecordTypes139;
        final int i95 = 18;
        HSSFRecordTypes hSSFRecordTypes140 = new HSSFRecordTypes("LEGEND", 139, 4117, LegendRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i95) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        LEGEND = hSSFRecordTypes140;
        final int i96 = 20;
        HSSFRecordTypes hSSFRecordTypes141 = new HSSFRecordTypes("SERIES_LIST", 140, 4118, SeriesListRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i96) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        SERIES_LIST = hSSFRecordTypes141;
        final int i97 = 21;
        HSSFRecordTypes hSSFRecordTypes142 = new HSSFRecordTypes("BAR", 141, 4119, BarRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i97) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        BAR = hSSFRecordTypes142;
        final int i98 = 22;
        HSSFRecordTypes hSSFRecordTypes143 = new HSSFRecordTypes("AREA", 142, 4122, AreaRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i98) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        AREA = hSSFRecordTypes143;
        final int i99 = 23;
        HSSFRecordTypes hSSFRecordTypes144 = new HSSFRecordTypes("AXIS", 143, 4125, AxisRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i99) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        AXIS = hSSFRecordTypes144;
        final int i100 = 24;
        HSSFRecordTypes hSSFRecordTypes145 = new HSSFRecordTypes("TICK", 144, 4126, TickRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i100) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        TICK = hSSFRecordTypes145;
        final int i101 = 26;
        HSSFRecordTypes hSSFRecordTypes146 = new HSSFRecordTypes("VALUE_RANGE", 145, 4127, ValueRangeRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i101) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        });
        VALUE_RANGE = hSSFRecordTypes146;
        final int i102 = 27;
        HSSFRecordTypes hSSFRecordTypes147 = new HSSFRecordTypes("CATEGORY_SERIES_AXIS", 146, 4128, CategorySeriesAxisRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i102) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        CATEGORY_SERIES_AXIS = hSSFRecordTypes147;
        final int i103 = 28;
        HSSFRecordTypes hSSFRecordTypes148 = new HSSFRecordTypes("AXIS_LINE_FORMAT", 147, 4129, AxisLineFormatRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i103) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        AXIS_LINE_FORMAT = hSSFRecordTypes148;
        final int i104 = 29;
        HSSFRecordTypes hSSFRecordTypes149 = new HSSFRecordTypes("DEFAULT_DATA_LABEL_TEXT_PROPERTIES", 148, 4132, DefaultDataLabelTextPropertiesRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.X
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i104) {
                    case 0:
                        return new DataLabelExtensionRecord(recordInputStream);
                    case 1:
                        return new CFHeader12Record(recordInputStream);
                    case 2:
                        return new CFRule12Record(recordInputStream);
                    case 3:
                        return new NumberRecord(recordInputStream);
                    case 4:
                        return new TableStylesRecord(recordInputStream);
                    case 5:
                        return new NameCommentRecord(recordInputStream);
                    case 6:
                        return new HeaderFooterRecord(recordInputStream);
                    case 7:
                        return new FooterRecord(recordInputStream);
                    case 8:
                        return new UnitsRecord(recordInputStream);
                    case 9:
                        return new ChartRecord(recordInputStream);
                    case 10:
                        return new SeriesRecord(recordInputStream);
                    case 11:
                        return new DataFormatRecord(recordInputStream);
                    case 12:
                        return new LineFormatRecord(recordInputStream);
                    case 13:
                        return new AreaFormatRecord(recordInputStream);
                    case 14:
                        return new LabelRecord(recordInputStream);
                    case 15:
                        return new SeriesLabelsRecord(recordInputStream);
                    case 16:
                        return new SeriesTextRecord(recordInputStream);
                    case 17:
                        return new ChartFormatRecord(recordInputStream);
                    case 18:
                        return new LegendRecord(recordInputStream);
                    case 19:
                        return new ExternSheetRecord(recordInputStream);
                    case 20:
                        return new SeriesListRecord(recordInputStream);
                    case 21:
                        return new BarRecord(recordInputStream);
                    case 22:
                        return new AreaRecord(recordInputStream);
                    case 23:
                        return new AxisRecord(recordInputStream);
                    case 24:
                        return new TickRecord(recordInputStream);
                    case 25:
                        return new BoolErrRecord(recordInputStream);
                    case 26:
                        return new ValueRangeRecord(recordInputStream);
                    case 27:
                        return new CategorySeriesAxisRecord(recordInputStream);
                    case 28:
                        return new AxisLineFormatRecord(recordInputStream);
                    default:
                        return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
                }
            }
        }, false);
        DEFAULT_DATA_LABEL_TEXT_PROPERTIES = hSSFRecordTypes149;
        final int i105 = 0;
        HSSFRecordTypes hSSFRecordTypes150 = new HSSFRecordTypes("TEXT", 149, 4133, TextRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i105) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        TEXT = hSSFRecordTypes150;
        final int i106 = 2;
        HSSFRecordTypes hSSFRecordTypes151 = new HSSFRecordTypes("FONT_INDEX", 150, 4134, FontIndexRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i106) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        FONT_INDEX = hSSFRecordTypes151;
        final int i107 = 3;
        HSSFRecordTypes hSSFRecordTypes152 = new HSSFRecordTypes("OBJECT_LINK", 151, 4135, ObjectLinkRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i107) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        OBJECT_LINK = hSSFRecordTypes152;
        final int i108 = 4;
        HSSFRecordTypes hSSFRecordTypes153 = new HSSFRecordTypes("FRAME", 152, 4146, FrameRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i108) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        FRAME = hSSFRecordTypes153;
        final int i109 = 5;
        HSSFRecordTypes hSSFRecordTypes154 = new HSSFRecordTypes("BEGIN", 153, 4147, BeginRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i109) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        BEGIN = hSSFRecordTypes154;
        final int i110 = 7;
        HSSFRecordTypes hSSFRecordTypes155 = new HSSFRecordTypes("END", 154, 4148, EndRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i110) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        END = hSSFRecordTypes155;
        final int i111 = 8;
        HSSFRecordTypes hSSFRecordTypes156 = new HSSFRecordTypes("PLOT_AREA", 155, 4149, PlotAreaRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i111) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        PLOT_AREA = hSSFRecordTypes156;
        final int i112 = 9;
        HSSFRecordTypes hSSFRecordTypes157 = new HSSFRecordTypes("AXIS_PARENT", 156, 4161, AxisParentRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i112) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        AXIS_PARENT = hSSFRecordTypes157;
        final int i113 = 10;
        HSSFRecordTypes hSSFRecordTypes158 = new HSSFRecordTypes("SHEET_PROPERTIES", 157, 4164, SheetPropertiesRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i113) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        SHEET_PROPERTIES = hSSFRecordTypes158;
        final int i114 = 11;
        HSSFRecordTypes hSSFRecordTypes159 = new HSSFRecordTypes("SERIES_CHART_GROUP_INDEX", 158, 4165, SeriesChartGroupIndexRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i114) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        SERIES_CHART_GROUP_INDEX = hSSFRecordTypes159;
        final int i115 = 12;
        HSSFRecordTypes hSSFRecordTypes160 = new HSSFRecordTypes("AXIS_USED", 159, 4166, AxisUsedRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i115) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        AXIS_USED = hSSFRecordTypes160;
        final int i116 = 14;
        HSSFRecordTypes hSSFRecordTypes161 = new HSSFRecordTypes("NUMBER_FORMAT_INDEX", 160, 4174, NumberFormatIndexRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i116) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        NUMBER_FORMAT_INDEX = hSSFRecordTypes161;
        final int i117 = 15;
        HSSFRecordTypes hSSFRecordTypes162 = new HSSFRecordTypes("CHART_TITLE_FORMAT", 161, 4176, ChartTitleFormatRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i117) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        CHART_TITLE_FORMAT = hSSFRecordTypes162;
        final int i118 = 16;
        HSSFRecordTypes hSSFRecordTypes163 = new HSSFRecordTypes("LINKED_DATA", 162, 4177, LinkedDataRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i118) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        LINKED_DATA = hSSFRecordTypes163;
        final int i119 = 18;
        HSSFRecordTypes hSSFRecordTypes164 = new HSSFRecordTypes("FONT_BASIS", 163, 4192, FontBasisRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i119) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        FONT_BASIS = hSSFRecordTypes164;
        final int i120 = 19;
        HSSFRecordTypes hSSFRecordTypes165 = new HSSFRecordTypes("AXIS_OPTIONS", 164, 4194, AxisOptionsRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i120) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        AXIS_OPTIONS = hSSFRecordTypes165;
        final int i121 = 20;
        HSSFRecordTypes hSSFRecordTypes166 = new HSSFRecordTypes("DAT", 165, 4195, DatRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i121) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        DAT = hSSFRecordTypes166;
        final int i122 = 21;
        HSSFRecordTypes hSSFRecordTypes167 = new HSSFRecordTypes("PLOT_GROWTH", 166, 4196, PlotGrowthRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i122) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        PLOT_GROWTH = hSSFRecordTypes167;
        final int i123 = 22;
        HSSFRecordTypes hSSFRecordTypes168 = new HSSFRecordTypes("SERIES_INDEX", 167, 4197, SeriesIndexRecord.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i123) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        }, false);
        SERIES_INDEX = hSSFRecordTypes168;
        final int i124 = 23;
        HSSFRecordTypes hSSFRecordTypes169 = new HSSFRecordTypes("ESCHER_AGGREGATE", 168, 9876, EscherAggregate.class, new RecordConstructor() { // from class: org.apache.poi.hssf.record.Y
            @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
            public final Record apply(RecordInputStream recordInputStream) {
                switch (i124) {
                    case 0:
                        return new TextRecord(recordInputStream);
                    case 1:
                        return new NameRecord(recordInputStream);
                    case 2:
                        return new FontIndexRecord(recordInputStream);
                    case 3:
                        return new ObjectLinkRecord(recordInputStream);
                    case 4:
                        return new FrameRecord(recordInputStream);
                    case 5:
                        return new BeginRecord(recordInputStream);
                    case 6:
                        return new StringRecord(recordInputStream);
                    case 7:
                        return new EndRecord(recordInputStream);
                    case 8:
                        return new PlotAreaRecord(recordInputStream);
                    case 9:
                        return new AxisParentRecord(recordInputStream);
                    case 10:
                        return new SheetPropertiesRecord(recordInputStream);
                    case 11:
                        return new SeriesChartGroupIndexRecord(recordInputStream);
                    case 12:
                        return new AxisUsedRecord(recordInputStream);
                    case 13:
                        return new WindowProtectRecord(recordInputStream);
                    case 14:
                        return new NumberFormatIndexRecord(recordInputStream);
                    case 15:
                        return new ChartTitleFormatRecord(recordInputStream);
                    case 16:
                        return new LinkedDataRecord(recordInputStream);
                    case 17:
                        return new RowRecord(recordInputStream);
                    case 18:
                        return new FontBasisRecord(recordInputStream);
                    case 19:
                        return new AxisOptionsRecord(recordInputStream);
                    case 20:
                        return new DatRecord(recordInputStream);
                    case 21:
                        return new PlotGrowthRecord(recordInputStream);
                    case 22:
                        return new SeriesIndexRecord(recordInputStream);
                    case 23:
                        return HSSFRecordTypes.lambda$static$0(recordInputStream);
                    case 24:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 25:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 26:
                        return new NoteRecord(recordInputStream);
                    case 27:
                        return new IndexRecord(recordInputStream);
                    case 28:
                        return new SelectionRecord(recordInputStream);
                    default:
                        return new FormulaRecord(recordInputStream);
                }
            }
        });
        ESCHER_AGGREGATE = hSSFRecordTypes169;
        $VALUES = new HSSFRecordTypes[]{hSSFRecordTypes, hSSFRecordTypes2, hSSFRecordTypes3, hSSFRecordTypes4, hSSFRecordTypes5, hSSFRecordTypes6, hSSFRecordTypes7, hSSFRecordTypes8, hSSFRecordTypes9, hSSFRecordTypes10, hSSFRecordTypes11, hSSFRecordTypes12, hSSFRecordTypes13, hSSFRecordTypes14, hSSFRecordTypes15, hSSFRecordTypes16, hSSFRecordTypes17, hSSFRecordTypes18, hSSFRecordTypes19, hSSFRecordTypes20, hSSFRecordTypes21, hSSFRecordTypes22, hSSFRecordTypes23, hSSFRecordTypes24, hSSFRecordTypes25, hSSFRecordTypes26, hSSFRecordTypes27, hSSFRecordTypes28, hSSFRecordTypes29, hSSFRecordTypes30, hSSFRecordTypes31, hSSFRecordTypes32, hSSFRecordTypes33, hSSFRecordTypes34, hSSFRecordTypes35, hSSFRecordTypes36, hSSFRecordTypes37, hSSFRecordTypes38, hSSFRecordTypes39, hSSFRecordTypes40, hSSFRecordTypes41, hSSFRecordTypes42, hSSFRecordTypes43, hSSFRecordTypes44, hSSFRecordTypes45, hSSFRecordTypes46, hSSFRecordTypes47, hSSFRecordTypes48, hSSFRecordTypes49, hSSFRecordTypes50, hSSFRecordTypes51, hSSFRecordTypes52, hSSFRecordTypes53, hSSFRecordTypes54, hSSFRecordTypes55, hSSFRecordTypes56, hSSFRecordTypes57, hSSFRecordTypes58, hSSFRecordTypes59, hSSFRecordTypes60, hSSFRecordTypes61, hSSFRecordTypes62, hSSFRecordTypes63, hSSFRecordTypes64, hSSFRecordTypes65, hSSFRecordTypes66, hSSFRecordTypes67, hSSFRecordTypes68, hSSFRecordTypes69, hSSFRecordTypes70, hSSFRecordTypes71, hSSFRecordTypes72, hSSFRecordTypes73, hSSFRecordTypes74, hSSFRecordTypes75, hSSFRecordTypes76, hSSFRecordTypes77, hSSFRecordTypes78, hSSFRecordTypes79, hSSFRecordTypes80, hSSFRecordTypes81, hSSFRecordTypes82, hSSFRecordTypes83, hSSFRecordTypes84, hSSFRecordTypes85, hSSFRecordTypes86, hSSFRecordTypes87, hSSFRecordTypes88, hSSFRecordTypes89, hSSFRecordTypes90, hSSFRecordTypes91, hSSFRecordTypes92, hSSFRecordTypes93, hSSFRecordTypes94, hSSFRecordTypes95, hSSFRecordTypes96, hSSFRecordTypes97, hSSFRecordTypes98, hSSFRecordTypes99, hSSFRecordTypes100, hSSFRecordTypes101, hSSFRecordTypes102, hSSFRecordTypes103, hSSFRecordTypes104, hSSFRecordTypes105, hSSFRecordTypes106, hSSFRecordTypes107, hSSFRecordTypes108, hSSFRecordTypes109, hSSFRecordTypes110, hSSFRecordTypes111, hSSFRecordTypes112, hSSFRecordTypes113, hSSFRecordTypes114, hSSFRecordTypes115, hSSFRecordTypes116, hSSFRecordTypes117, hSSFRecordTypes118, hSSFRecordTypes119, hSSFRecordTypes120, hSSFRecordTypes121, hSSFRecordTypes122, hSSFRecordTypes123, hSSFRecordTypes124, hSSFRecordTypes125, hSSFRecordTypes126, hSSFRecordTypes127, hSSFRecordTypes128, hSSFRecordTypes129, hSSFRecordTypes130, hSSFRecordTypes131, hSSFRecordTypes132, hSSFRecordTypes133, hSSFRecordTypes134, hSSFRecordTypes135, hSSFRecordTypes136, hSSFRecordTypes137, hSSFRecordTypes138, hSSFRecordTypes139, hSSFRecordTypes140, hSSFRecordTypes141, hSSFRecordTypes142, hSSFRecordTypes143, hSSFRecordTypes144, hSSFRecordTypes145, hSSFRecordTypes146, hSSFRecordTypes147, hSSFRecordTypes148, hSSFRecordTypes149, hSSFRecordTypes150, hSSFRecordTypes151, hSSFRecordTypes152, hSSFRecordTypes153, hSSFRecordTypes154, hSSFRecordTypes155, hSSFRecordTypes156, hSSFRecordTypes157, hSSFRecordTypes158, hSSFRecordTypes159, hSSFRecordTypes160, hSSFRecordTypes161, hSSFRecordTypes162, hSSFRecordTypes163, hSSFRecordTypes164, hSSFRecordTypes165, hSSFRecordTypes166, hSSFRecordTypes167, hSSFRecordTypes168, hSSFRecordTypes169};
        LOOKUP = (Map) Arrays.stream(values()).collect(Collectors.toMap(new G(4), Function.identity()));
    }

    private HSSFRecordTypes(String str, int i5, int i6, Class cls, RecordConstructor recordConstructor) {
        this(str, i5, i6, cls, recordConstructor, true);
    }

    public static HSSFRecordTypes forSID(int i5) {
        return LOOKUP.getOrDefault(Short.valueOf((short) i5), UNKNOWN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Record lambda$static$0(RecordInputStream recordInputStream) {
        return new EscherAggregate(true);
    }

    public static HSSFRecordTypes valueOf(String str) {
        return (HSSFRecordTypes) Enum.valueOf(HSSFRecordTypes.class, str);
    }

    public static HSSFRecordTypes[] values() {
        return (HSSFRecordTypes[]) $VALUES.clone();
    }

    public Class<? extends Record> getClazz() {
        return this.clazz;
    }

    public RecordConstructor<? extends Record> getRecordConstructor() {
        return this.recordConstructor;
    }

    public short getSid() {
        return this.sid;
    }

    public boolean isParseable() {
        return this.parse;
    }

    private HSSFRecordTypes(String str, int i5, int i6, Class cls, RecordConstructor recordConstructor, boolean z6) {
        super(str, i5);
        this.sid = (short) i6;
        this.clazz = cls;
        this.recordConstructor = recordConstructor;
        this.parse = z6;
    }
}
