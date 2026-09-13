package org.apache.poi.hssf.record.chart;

import java.util.Collections;
import java.util.LinkedHashMap;
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
public final class TickRecord extends StandardRecord {
    public static final short sid = 4126;
    private short field_10_options;
    private short field_11_tickColor;
    private short field_12_zero5;
    private byte field_1_majorTickType;
    private byte field_2_minorTickType;
    private byte field_3_labelPosition;
    private byte field_4_background;
    private int field_5_labelColorRgb;
    private int field_6_zero1;
    private int field_7_zero2;
    private int field_8_zero3;
    private int field_9_zero4;
    private static final BitField autoTextColor = BitFieldFactory.getInstance(1);
    private static final BitField autoTextBackground = BitFieldFactory.getInstance(2);
    private static final BitField rotation = BitFieldFactory.getInstance(28);
    private static final BitField autorotate = BitFieldFactory.getInstance(32);

    public TickRecord() {
    }

    public byte getBackground() {
        return this.field_4_background;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 30;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("majorTickType", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.H
            public final /* synthetic */ TickRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Byte.valueOf(this.b.getMajorTickType());
                    case 1:
                        return Short.valueOf(this.b.getTickColor());
                    case 2:
                        return Short.valueOf(this.b.getZero3());
                    case 3:
                        return Byte.valueOf(this.b.getMinorTickType());
                    case 4:
                        return Byte.valueOf(this.b.getLabelPosition());
                    case 5:
                        return Byte.valueOf(this.b.getBackground());
                    case 6:
                        return Integer.valueOf(this.b.getLabelColorRgb());
                    case 7:
                        return Integer.valueOf(this.b.getZero1());
                    case 8:
                        return Integer.valueOf(this.b.getZero2());
                    case 9:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Short.valueOf(this.b.getRotation());
                }
            }
        });
        final int i6 = 3;
        linkedHashMap.put("minorTickType", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.H
            public final /* synthetic */ TickRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Byte.valueOf(this.b.getMajorTickType());
                    case 1:
                        return Short.valueOf(this.b.getTickColor());
                    case 2:
                        return Short.valueOf(this.b.getZero3());
                    case 3:
                        return Byte.valueOf(this.b.getMinorTickType());
                    case 4:
                        return Byte.valueOf(this.b.getLabelPosition());
                    case 5:
                        return Byte.valueOf(this.b.getBackground());
                    case 6:
                        return Integer.valueOf(this.b.getLabelColorRgb());
                    case 7:
                        return Integer.valueOf(this.b.getZero1());
                    case 8:
                        return Integer.valueOf(this.b.getZero2());
                    case 9:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Short.valueOf(this.b.getRotation());
                }
            }
        });
        final int i7 = 4;
        linkedHashMap.put("labelPosition", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.H
            public final /* synthetic */ TickRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Byte.valueOf(this.b.getMajorTickType());
                    case 1:
                        return Short.valueOf(this.b.getTickColor());
                    case 2:
                        return Short.valueOf(this.b.getZero3());
                    case 3:
                        return Byte.valueOf(this.b.getMinorTickType());
                    case 4:
                        return Byte.valueOf(this.b.getLabelPosition());
                    case 5:
                        return Byte.valueOf(this.b.getBackground());
                    case 6:
                        return Integer.valueOf(this.b.getLabelColorRgb());
                    case 7:
                        return Integer.valueOf(this.b.getZero1());
                    case 8:
                        return Integer.valueOf(this.b.getZero2());
                    case 9:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Short.valueOf(this.b.getRotation());
                }
            }
        });
        final int i8 = 5;
        linkedHashMap.put("background", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.H
            public final /* synthetic */ TickRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Byte.valueOf(this.b.getMajorTickType());
                    case 1:
                        return Short.valueOf(this.b.getTickColor());
                    case 2:
                        return Short.valueOf(this.b.getZero3());
                    case 3:
                        return Byte.valueOf(this.b.getMinorTickType());
                    case 4:
                        return Byte.valueOf(this.b.getLabelPosition());
                    case 5:
                        return Byte.valueOf(this.b.getBackground());
                    case 6:
                        return Integer.valueOf(this.b.getLabelColorRgb());
                    case 7:
                        return Integer.valueOf(this.b.getZero1());
                    case 8:
                        return Integer.valueOf(this.b.getZero2());
                    case 9:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Short.valueOf(this.b.getRotation());
                }
            }
        });
        final int i9 = 6;
        linkedHashMap.put("labelColorRgb", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.H
            public final /* synthetic */ TickRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Byte.valueOf(this.b.getMajorTickType());
                    case 1:
                        return Short.valueOf(this.b.getTickColor());
                    case 2:
                        return Short.valueOf(this.b.getZero3());
                    case 3:
                        return Byte.valueOf(this.b.getMinorTickType());
                    case 4:
                        return Byte.valueOf(this.b.getLabelPosition());
                    case 5:
                        return Byte.valueOf(this.b.getBackground());
                    case 6:
                        return Integer.valueOf(this.b.getLabelColorRgb());
                    case 7:
                        return Integer.valueOf(this.b.getZero1());
                    case 8:
                        return Integer.valueOf(this.b.getZero2());
                    case 9:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Short.valueOf(this.b.getRotation());
                }
            }
        });
        final int i10 = 7;
        linkedHashMap.put("zero1", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.H
            public final /* synthetic */ TickRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Byte.valueOf(this.b.getMajorTickType());
                    case 1:
                        return Short.valueOf(this.b.getTickColor());
                    case 2:
                        return Short.valueOf(this.b.getZero3());
                    case 3:
                        return Byte.valueOf(this.b.getMinorTickType());
                    case 4:
                        return Byte.valueOf(this.b.getLabelPosition());
                    case 5:
                        return Byte.valueOf(this.b.getBackground());
                    case 6:
                        return Integer.valueOf(this.b.getLabelColorRgb());
                    case 7:
                        return Integer.valueOf(this.b.getZero1());
                    case 8:
                        return Integer.valueOf(this.b.getZero2());
                    case 9:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Short.valueOf(this.b.getRotation());
                }
            }
        });
        final int i11 = 8;
        linkedHashMap.put("zero2", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.H
            public final /* synthetic */ TickRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Byte.valueOf(this.b.getMajorTickType());
                    case 1:
                        return Short.valueOf(this.b.getTickColor());
                    case 2:
                        return Short.valueOf(this.b.getZero3());
                    case 3:
                        return Byte.valueOf(this.b.getMinorTickType());
                    case 4:
                        return Byte.valueOf(this.b.getLabelPosition());
                    case 5:
                        return Byte.valueOf(this.b.getBackground());
                    case 6:
                        return Integer.valueOf(this.b.getLabelColorRgb());
                    case 7:
                        return Integer.valueOf(this.b.getZero1());
                    case 8:
                        return Integer.valueOf(this.b.getZero2());
                    case 9:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Short.valueOf(this.b.getRotation());
                }
            }
        });
        final int i12 = 9;
        linkedHashMap.put("options", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.H
            public final /* synthetic */ TickRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Byte.valueOf(this.b.getMajorTickType());
                    case 1:
                        return Short.valueOf(this.b.getTickColor());
                    case 2:
                        return Short.valueOf(this.b.getZero3());
                    case 3:
                        return Byte.valueOf(this.b.getMinorTickType());
                    case 4:
                        return Byte.valueOf(this.b.getLabelPosition());
                    case 5:
                        return Byte.valueOf(this.b.getBackground());
                    case 6:
                        return Integer.valueOf(this.b.getLabelColorRgb());
                    case 7:
                        return Integer.valueOf(this.b.getZero1());
                    case 8:
                        return Integer.valueOf(this.b.getZero2());
                    case 9:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Short.valueOf(this.b.getRotation());
                }
            }
        }, new BitField[]{autoTextColor, autoTextBackground, autorotate}, new String[]{"AUTO_TEXT_COLOR", "AUTO_TEXT_BACKGROUND", "AUTO_ROTATE"}));
        final int i13 = 10;
        linkedHashMap.put("rotation", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.H
            public final /* synthetic */ TickRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Byte.valueOf(this.b.getMajorTickType());
                    case 1:
                        return Short.valueOf(this.b.getTickColor());
                    case 2:
                        return Short.valueOf(this.b.getZero3());
                    case 3:
                        return Byte.valueOf(this.b.getMinorTickType());
                    case 4:
                        return Byte.valueOf(this.b.getLabelPosition());
                    case 5:
                        return Byte.valueOf(this.b.getBackground());
                    case 6:
                        return Integer.valueOf(this.b.getLabelColorRgb());
                    case 7:
                        return Integer.valueOf(this.b.getZero1());
                    case 8:
                        return Integer.valueOf(this.b.getZero2());
                    case 9:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Short.valueOf(this.b.getRotation());
                }
            }
        });
        final int i14 = 1;
        linkedHashMap.put("tickColor", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.H
            public final /* synthetic */ TickRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return Byte.valueOf(this.b.getMajorTickType());
                    case 1:
                        return Short.valueOf(this.b.getTickColor());
                    case 2:
                        return Short.valueOf(this.b.getZero3());
                    case 3:
                        return Byte.valueOf(this.b.getMinorTickType());
                    case 4:
                        return Byte.valueOf(this.b.getLabelPosition());
                    case 5:
                        return Byte.valueOf(this.b.getBackground());
                    case 6:
                        return Integer.valueOf(this.b.getLabelColorRgb());
                    case 7:
                        return Integer.valueOf(this.b.getZero1());
                    case 8:
                        return Integer.valueOf(this.b.getZero2());
                    case 9:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Short.valueOf(this.b.getRotation());
                }
            }
        });
        final int i15 = 2;
        linkedHashMap.put("zero3", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.H
            public final /* synthetic */ TickRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i15) {
                    case 0:
                        return Byte.valueOf(this.b.getMajorTickType());
                    case 1:
                        return Short.valueOf(this.b.getTickColor());
                    case 2:
                        return Short.valueOf(this.b.getZero3());
                    case 3:
                        return Byte.valueOf(this.b.getMinorTickType());
                    case 4:
                        return Byte.valueOf(this.b.getLabelPosition());
                    case 5:
                        return Byte.valueOf(this.b.getBackground());
                    case 6:
                        return Integer.valueOf(this.b.getLabelColorRgb());
                    case 7:
                        return Integer.valueOf(this.b.getZero1());
                    case 8:
                        return Integer.valueOf(this.b.getZero2());
                    case 9:
                        return Short.valueOf(this.b.getOptions());
                    default:
                        return Short.valueOf(this.b.getRotation());
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public int getLabelColorRgb() {
        return this.field_5_labelColorRgb;
    }

    public byte getLabelPosition() {
        return this.field_3_labelPosition;
    }

    public byte getMajorTickType() {
        return this.field_1_majorTickType;
    }

    public byte getMinorTickType() {
        return this.field_2_minorTickType;
    }

    public short getOptions() {
        return this.field_10_options;
    }

    public short getRotation() {
        return rotation.getShortValue(this.field_10_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public short getTickColor() {
        return this.field_11_tickColor;
    }

    public int getZero1() {
        return this.field_6_zero1;
    }

    public int getZero2() {
        return this.field_7_zero2;
    }

    public short getZero3() {
        return this.field_12_zero5;
    }

    public boolean isAutoTextBackground() {
        return autoTextBackground.isSet(this.field_10_options);
    }

    public boolean isAutoTextColor() {
        return autoTextColor.isSet(this.field_10_options);
    }

    public boolean isAutorotate() {
        return autorotate.isSet(this.field_10_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this.field_1_majorTickType);
        littleEndianOutput.writeByte(this.field_2_minorTickType);
        littleEndianOutput.writeByte(this.field_3_labelPosition);
        littleEndianOutput.writeByte(this.field_4_background);
        littleEndianOutput.writeInt(this.field_5_labelColorRgb);
        littleEndianOutput.writeInt(this.field_6_zero1);
        littleEndianOutput.writeInt(this.field_7_zero2);
        littleEndianOutput.writeInt(this.field_8_zero3);
        littleEndianOutput.writeInt(this.field_9_zero4);
        littleEndianOutput.writeShort(this.field_10_options);
        littleEndianOutput.writeShort(this.field_11_tickColor);
        littleEndianOutput.writeShort(this.field_12_zero5);
    }

    public void setAutoTextBackground(boolean z6) {
        this.field_10_options = autoTextBackground.setShortBoolean(this.field_10_options, z6);
    }

    public void setAutoTextColor(boolean z6) {
        this.field_10_options = autoTextColor.setShortBoolean(this.field_10_options, z6);
    }

    public void setAutorotate(boolean z6) {
        this.field_10_options = autorotate.setShortBoolean(this.field_10_options, z6);
    }

    public void setBackground(byte b) {
        this.field_4_background = b;
    }

    public void setLabelColorRgb(int i5) {
        this.field_5_labelColorRgb = i5;
    }

    public void setLabelPosition(byte b) {
        this.field_3_labelPosition = b;
    }

    public void setMajorTickType(byte b) {
        this.field_1_majorTickType = b;
    }

    public void setMinorTickType(byte b) {
        this.field_2_minorTickType = b;
    }

    public void setOptions(short s6) {
        this.field_10_options = s6;
    }

    public void setRotation(short s6) {
        this.field_10_options = rotation.setShortValue(this.field_10_options, s6);
    }

    public void setTickColor(short s6) {
        this.field_11_tickColor = s6;
    }

    public void setZero1(int i5) {
        this.field_6_zero1 = i5;
    }

    public void setZero2(int i5) {
        this.field_7_zero2 = i5;
    }

    public void setZero3(short s6) {
        this.field_12_zero5 = s6;
    }

    public TickRecord(TickRecord tickRecord) {
        super(tickRecord);
        this.field_1_majorTickType = tickRecord.field_1_majorTickType;
        this.field_2_minorTickType = tickRecord.field_2_minorTickType;
        this.field_3_labelPosition = tickRecord.field_3_labelPosition;
        this.field_4_background = tickRecord.field_4_background;
        this.field_5_labelColorRgb = tickRecord.field_5_labelColorRgb;
        this.field_6_zero1 = tickRecord.field_6_zero1;
        this.field_7_zero2 = tickRecord.field_7_zero2;
        this.field_8_zero3 = tickRecord.field_8_zero3;
        this.field_9_zero4 = tickRecord.field_9_zero4;
        this.field_10_options = tickRecord.field_10_options;
        this.field_11_tickColor = tickRecord.field_11_tickColor;
        this.field_12_zero5 = tickRecord.field_12_zero5;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.TICK;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public TickRecord copy() {
        return new TickRecord(this);
    }

    public TickRecord(RecordInputStream recordInputStream) {
        this.field_1_majorTickType = recordInputStream.readByte();
        this.field_2_minorTickType = recordInputStream.readByte();
        this.field_3_labelPosition = recordInputStream.readByte();
        this.field_4_background = recordInputStream.readByte();
        this.field_5_labelColorRgb = recordInputStream.readInt();
        this.field_6_zero1 = recordInputStream.readInt();
        this.field_7_zero2 = recordInputStream.readInt();
        this.field_8_zero3 = recordInputStream.readInt();
        this.field_9_zero4 = recordInputStream.readInt();
        this.field_10_options = recordInputStream.readShort();
        this.field_11_tickColor = recordInputStream.readShort();
        this.field_12_zero5 = recordInputStream.readShort();
    }
}
