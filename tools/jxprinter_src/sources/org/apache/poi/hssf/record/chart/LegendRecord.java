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
public final class LegendRecord extends StandardRecord {
    public static final byte SPACING_CLOSE = 0;
    public static final byte SPACING_MEDIUM = 1;
    public static final byte SPACING_OPEN = 2;
    public static final byte TYPE_BOTTOM = 0;
    public static final byte TYPE_CORNER = 1;
    public static final byte TYPE_LEFT = 4;
    public static final byte TYPE_RIGHT = 3;
    public static final byte TYPE_TOP = 2;
    public static final byte TYPE_UNDOCKED = 7;
    public static final short sid = 4117;
    private int field_1_xAxisUpperLeft;
    private int field_2_yAxisUpperLeft;
    private int field_3_xSize;
    private int field_4_ySize;
    private byte field_5_type;
    private byte field_6_spacing;
    private short field_7_options;
    private static final BitField autoPosition = BitFieldFactory.getInstance(1);
    private static final BitField autoSeries = BitFieldFactory.getInstance(2);
    private static final BitField autoXPositioning = BitFieldFactory.getInstance(4);
    private static final BitField autoYPositioning = BitFieldFactory.getInstance(8);
    private static final BitField vertical = BitFieldFactory.getInstance(16);
    private static final BitField dataTable = BitFieldFactory.getInstance(32);

    public LegendRecord() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 20;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.y
            public final /* synthetic */ LegendRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getXAxisUpperLeft());
                    case 1:
                        return Integer.valueOf(this.b.getYAxisUpperLeft());
                    case 2:
                        return Integer.valueOf(this.b.getXSize());
                    case 3:
                        return Integer.valueOf(this.b.getYSize());
                    case 4:
                        return Byte.valueOf(this.b.getType());
                    case 5:
                        return Byte.valueOf(this.b.getSpacing());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.y
            public final /* synthetic */ LegendRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getXAxisUpperLeft());
                    case 1:
                        return Integer.valueOf(this.b.getYAxisUpperLeft());
                    case 2:
                        return Integer.valueOf(this.b.getXSize());
                    case 3:
                        return Integer.valueOf(this.b.getYSize());
                    case 4:
                        return Byte.valueOf(this.b.getType());
                    case 5:
                        return Byte.valueOf(this.b.getSpacing());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.y
            public final /* synthetic */ LegendRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getXAxisUpperLeft());
                    case 1:
                        return Integer.valueOf(this.b.getYAxisUpperLeft());
                    case 2:
                        return Integer.valueOf(this.b.getXSize());
                    case 3:
                        return Integer.valueOf(this.b.getYSize());
                    case 4:
                        return Byte.valueOf(this.b.getType());
                    case 5:
                        return Byte.valueOf(this.b.getSpacing());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.y
            public final /* synthetic */ LegendRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getXAxisUpperLeft());
                    case 1:
                        return Integer.valueOf(this.b.getYAxisUpperLeft());
                    case 2:
                        return Integer.valueOf(this.b.getXSize());
                    case 3:
                        return Integer.valueOf(this.b.getYSize());
                    case 4:
                        return Byte.valueOf(this.b.getType());
                    case 5:
                        return Byte.valueOf(this.b.getSpacing());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.y
            public final /* synthetic */ LegendRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getXAxisUpperLeft());
                    case 1:
                        return Integer.valueOf(this.b.getYAxisUpperLeft());
                    case 2:
                        return Integer.valueOf(this.b.getXSize());
                    case 3:
                        return Integer.valueOf(this.b.getYSize());
                    case 4:
                        return Byte.valueOf(this.b.getType());
                    case 5:
                        return Byte.valueOf(this.b.getSpacing());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        };
        final int i10 = 6;
        final int i11 = 5;
        return GenericRecordUtil.getGenericProperties("xAxisUpperLeft", supplier, "yAxisUpperLeft", supplier2, "xSize", supplier3, "ySize", supplier4, "type", GenericRecordUtil.getEnumBitsAsString(supplier5, new int[]{0, 1, 2, 3, 4, 7}, new String[]{"BOTTOM", "CORNER", "TOP", "RIGHT", "LEFT", "UNDOCKED"}), "spacing", GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.y
            public final /* synthetic */ LegendRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getXAxisUpperLeft());
                    case 1:
                        return Integer.valueOf(this.b.getYAxisUpperLeft());
                    case 2:
                        return Integer.valueOf(this.b.getXSize());
                    case 3:
                        return Integer.valueOf(this.b.getYSize());
                    case 4:
                        return Byte.valueOf(this.b.getType());
                    case 5:
                        return Byte.valueOf(this.b.getSpacing());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        }, new int[]{0, 1, 2}, new String[]{"CLOSE", "MEDIUM", "OPEN"}), "options", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.y
            public final /* synthetic */ LegendRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getXAxisUpperLeft());
                    case 1:
                        return Integer.valueOf(this.b.getYAxisUpperLeft());
                    case 2:
                        return Integer.valueOf(this.b.getXSize());
                    case 3:
                        return Integer.valueOf(this.b.getYSize());
                    case 4:
                        return Byte.valueOf(this.b.getType());
                    case 5:
                        return Byte.valueOf(this.b.getSpacing());
                    default:
                        return Short.valueOf(this.b.getOptions());
                }
            }
        }, new BitField[]{autoPosition, autoSeries, autoXPositioning, autoYPositioning, vertical, dataTable}, new String[]{"AUTO_POSITION", "AUTO_SERIES", "AUTO_X_POSITIONING", "AUTO_Y_POSITIONING", "VERTICAL", "DATA_TABLE"}));
    }

    public short getOptions() {
        return this.field_7_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public byte getSpacing() {
        return this.field_6_spacing;
    }

    public byte getType() {
        return this.field_5_type;
    }

    public int getXAxisUpperLeft() {
        return this.field_1_xAxisUpperLeft;
    }

    public int getXSize() {
        return this.field_3_xSize;
    }

    public int getYAxisUpperLeft() {
        return this.field_2_yAxisUpperLeft;
    }

    public int getYSize() {
        return this.field_4_ySize;
    }

    public boolean isAutoPosition() {
        return autoPosition.isSet(this.field_7_options);
    }

    public boolean isAutoSeries() {
        return autoSeries.isSet(this.field_7_options);
    }

    public boolean isAutoXPositioning() {
        return autoXPositioning.isSet(this.field_7_options);
    }

    public boolean isAutoYPositioning() {
        return autoYPositioning.isSet(this.field_7_options);
    }

    public boolean isDataTable() {
        return dataTable.isSet(this.field_7_options);
    }

    public boolean isVertical() {
        return vertical.isSet(this.field_7_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_1_xAxisUpperLeft);
        littleEndianOutput.writeInt(this.field_2_yAxisUpperLeft);
        littleEndianOutput.writeInt(this.field_3_xSize);
        littleEndianOutput.writeInt(this.field_4_ySize);
        littleEndianOutput.writeByte(this.field_5_type);
        littleEndianOutput.writeByte(this.field_6_spacing);
        littleEndianOutput.writeShort(this.field_7_options);
    }

    public void setAutoPosition(boolean z6) {
        this.field_7_options = autoPosition.setShortBoolean(this.field_7_options, z6);
    }

    public void setAutoSeries(boolean z6) {
        this.field_7_options = autoSeries.setShortBoolean(this.field_7_options, z6);
    }

    public void setAutoXPositioning(boolean z6) {
        this.field_7_options = autoXPositioning.setShortBoolean(this.field_7_options, z6);
    }

    public void setAutoYPositioning(boolean z6) {
        this.field_7_options = autoYPositioning.setShortBoolean(this.field_7_options, z6);
    }

    public void setDataTable(boolean z6) {
        this.field_7_options = dataTable.setShortBoolean(this.field_7_options, z6);
    }

    public void setOptions(short s6) {
        this.field_7_options = s6;
    }

    public void setSpacing(byte b) {
        this.field_6_spacing = b;
    }

    public void setType(byte b) {
        this.field_5_type = b;
    }

    public void setVertical(boolean z6) {
        this.field_7_options = vertical.setShortBoolean(this.field_7_options, z6);
    }

    public void setXAxisUpperLeft(int i5) {
        this.field_1_xAxisUpperLeft = i5;
    }

    public void setXSize(int i5) {
        this.field_3_xSize = i5;
    }

    public void setYAxisUpperLeft(int i5) {
        this.field_2_yAxisUpperLeft = i5;
    }

    public void setYSize(int i5) {
        this.field_4_ySize = i5;
    }

    public LegendRecord(LegendRecord legendRecord) {
        super(legendRecord);
        this.field_1_xAxisUpperLeft = legendRecord.field_1_xAxisUpperLeft;
        this.field_2_yAxisUpperLeft = legendRecord.field_2_yAxisUpperLeft;
        this.field_3_xSize = legendRecord.field_3_xSize;
        this.field_4_ySize = legendRecord.field_4_ySize;
        this.field_5_type = legendRecord.field_5_type;
        this.field_6_spacing = legendRecord.field_6_spacing;
        this.field_7_options = legendRecord.field_7_options;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.LEGEND;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public LegendRecord copy() {
        return new LegendRecord(this);
    }

    public LegendRecord(RecordInputStream recordInputStream) {
        this.field_1_xAxisUpperLeft = recordInputStream.readInt();
        this.field_2_yAxisUpperLeft = recordInputStream.readInt();
        this.field_3_xSize = recordInputStream.readInt();
        this.field_4_ySize = recordInputStream.readInt();
        this.field_5_type = recordInputStream.readByte();
        this.field_6_spacing = recordInputStream.readByte();
        this.field_7_options = recordInputStream.readShort();
    }
}
