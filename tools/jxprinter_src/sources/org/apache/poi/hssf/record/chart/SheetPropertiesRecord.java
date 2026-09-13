package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SheetPropertiesRecord extends StandardRecord {
    public static final byte EMPTY_INTERPOLATED = 2;
    public static final byte EMPTY_NOT_PLOTTED = 0;
    public static final byte EMPTY_ZERO = 1;
    public static final short sid = 4164;
    private int field_1_flags;
    private int field_2_empty;
    private static final BitField chartTypeManuallyFormatted = BitFieldFactory.getInstance(1);
    private static final BitField plotVisibleOnly = BitFieldFactory.getInstance(2);
    private static final BitField doNotSizeWithWindow = BitFieldFactory.getInstance(4);
    private static final BitField defaultPlotDimensions = BitFieldFactory.getInstance(8);
    private static final BitField autoPlotArea = BitFieldFactory.getInstance(16);

    public SheetPropertiesRecord() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    public int getEmpty() {
        return this.field_2_empty;
    }

    public int getFlags() {
        return this.field_1_flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("flags", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.F
            public final /* synthetic */ SheetPropertiesRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int flags;
                switch (i5) {
                    case 0:
                        flags = this.b.getFlags();
                        break;
                    default:
                        flags = this.b.getEmpty();
                        break;
                }
                return Integer.valueOf(flags);
            }
        }, new BitField[]{chartTypeManuallyFormatted, plotVisibleOnly, doNotSizeWithWindow, defaultPlotDimensions, autoPlotArea}, new String[]{"CHART_TYPE_MANUALLY_FORMATTED", "PLOT_VISIBLE_ONLY", "DO_NOT_SIZE_WITH_WINDOW", "DEFAULT_PLOT_DIMENSIONS", "AUTO_PLOT_AREA"}), "empty", GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.F
            public final /* synthetic */ SheetPropertiesRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int flags;
                switch (i6) {
                    case 0:
                        flags = this.b.getFlags();
                        break;
                    default:
                        flags = this.b.getEmpty();
                        break;
                }
                return Integer.valueOf(flags);
            }
        }, new int[]{0, 1, 2}, new String[]{"EMPTY_NOT_PLOTTED", "EMPTY_ZERO", "EMPTY_INTERPOLATED"}));
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean isAutoPlotArea() {
        return autoPlotArea.isSet(this.field_1_flags);
    }

    public boolean isChartTypeManuallyFormatted() {
        return chartTypeManuallyFormatted.isSet(this.field_1_flags);
    }

    public boolean isDefaultPlotDimensions() {
        return defaultPlotDimensions.isSet(this.field_1_flags);
    }

    public boolean isDoNotSizeWithWindow() {
        return doNotSizeWithWindow.isSet(this.field_1_flags);
    }

    public boolean isPlotVisibleOnly() {
        return plotVisibleOnly.isSet(this.field_1_flags);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_flags);
        littleEndianOutput.writeShort(this.field_2_empty);
    }

    public void setAutoPlotArea(boolean z6) {
        this.field_1_flags = autoPlotArea.setBoolean(this.field_1_flags, z6);
    }

    public void setChartTypeManuallyFormatted(boolean z6) {
        this.field_1_flags = chartTypeManuallyFormatted.setBoolean(this.field_1_flags, z6);
    }

    public void setDefaultPlotDimensions(boolean z6) {
        this.field_1_flags = defaultPlotDimensions.setBoolean(this.field_1_flags, z6);
    }

    public void setDoNotSizeWithWindow(boolean z6) {
        this.field_1_flags = doNotSizeWithWindow.setBoolean(this.field_1_flags, z6);
    }

    public void setEmpty(byte b) {
        this.field_2_empty = b;
    }

    public void setPlotVisibleOnly(boolean z6) {
        this.field_1_flags = plotVisibleOnly.setBoolean(this.field_1_flags, z6);
    }

    public SheetPropertiesRecord(SheetPropertiesRecord sheetPropertiesRecord) {
        super(sheetPropertiesRecord);
        this.field_1_flags = sheetPropertiesRecord.field_1_flags;
        this.field_2_empty = sheetPropertiesRecord.field_2_empty;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SHEET_PROPERTIES;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public SheetPropertiesRecord copy() {
        return new SheetPropertiesRecord(this);
    }

    public SheetPropertiesRecord(RecordInputStream recordInputStream) {
        this.field_1_flags = recordInputStream.readUShort();
        this.field_2_empty = recordInputStream.readUShort();
    }
}
