package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonObjectDataSubRecord extends SubRecord {
    public static final short OBJECT_TYPE_ARC = 4;
    public static final short OBJECT_TYPE_BUTTON = 7;
    public static final short OBJECT_TYPE_CHART = 5;
    public static final short OBJECT_TYPE_CHECKBOX = 11;
    public static final short OBJECT_TYPE_COMBO_BOX = 20;
    public static final short OBJECT_TYPE_COMMENT = 25;
    public static final short OBJECT_TYPE_DIALOG_BOX = 15;
    public static final short OBJECT_TYPE_EDIT_BOX = 13;
    public static final short OBJECT_TYPE_GROUP = 0;
    public static final short OBJECT_TYPE_GROUP_BOX = 19;
    public static final short OBJECT_TYPE_LABEL = 14;
    public static final short OBJECT_TYPE_LINE = 1;
    public static final short OBJECT_TYPE_LIST_BOX = 18;
    public static final short OBJECT_TYPE_MICROSOFT_OFFICE_DRAWING = 30;
    public static final short OBJECT_TYPE_OPTION_BUTTON = 12;
    public static final short OBJECT_TYPE_OVAL = 3;
    public static final short OBJECT_TYPE_PICTURE = 8;
    public static final short OBJECT_TYPE_POLYGON = 9;
    public static final short OBJECT_TYPE_RECTANGLE = 2;
    public static final short OBJECT_TYPE_RESERVED1 = 10;
    public static final short OBJECT_TYPE_RESERVED2 = 21;
    public static final short OBJECT_TYPE_RESERVED3 = 22;
    public static final short OBJECT_TYPE_RESERVED4 = 23;
    public static final short OBJECT_TYPE_RESERVED5 = 24;
    public static final short OBJECT_TYPE_RESERVED6 = 26;
    public static final short OBJECT_TYPE_RESERVED7 = 27;
    public static final short OBJECT_TYPE_RESERVED8 = 28;
    public static final short OBJECT_TYPE_RESERVED9 = 29;
    public static final short OBJECT_TYPE_SCROLL_BAR = 17;
    public static final short OBJECT_TYPE_SPINNER = 16;
    public static final short OBJECT_TYPE_TEXT = 6;
    public static final short sid = 21;
    private short field_1_objectType;
    private int field_2_objectId;
    private short field_3_option;
    private int field_4_reserved1;
    private int field_5_reserved2;
    private int field_6_reserved3;
    private static final BitField locked = BitFieldFactory.getInstance(1);
    private static final BitField printable = BitFieldFactory.getInstance(16);
    private static final BitField autofill = BitFieldFactory.getInstance(8192);
    private static final BitField autoline = BitFieldFactory.getInstance(16384);

    public CommonObjectDataSubRecord() {
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.p
            public final /* synthetic */ CommonObjectDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getObjectType());
                    case 1:
                        return Integer.valueOf(this.b.getObjectId());
                    case 2:
                        return Short.valueOf(this.b.getOption());
                    case 3:
                        return Integer.valueOf(this.b.getReserved1());
                    case 4:
                        return Integer.valueOf(this.b.getReserved2());
                    default:
                        return Integer.valueOf(this.b.getReserved3());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.p
            public final /* synthetic */ CommonObjectDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getObjectType());
                    case 1:
                        return Integer.valueOf(this.b.getObjectId());
                    case 2:
                        return Short.valueOf(this.b.getOption());
                    case 3:
                        return Integer.valueOf(this.b.getReserved1());
                    case 4:
                        return Integer.valueOf(this.b.getReserved2());
                    default:
                        return Integer.valueOf(this.b.getReserved3());
                }
            }
        };
        final int i7 = 2;
        Supplier<GenericRecordUtil.AnnotatedFlag> bitsAsString = GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.p
            public final /* synthetic */ CommonObjectDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getObjectType());
                    case 1:
                        return Integer.valueOf(this.b.getObjectId());
                    case 2:
                        return Short.valueOf(this.b.getOption());
                    case 3:
                        return Integer.valueOf(this.b.getReserved1());
                    case 4:
                        return Integer.valueOf(this.b.getReserved2());
                    default:
                        return Integer.valueOf(this.b.getReserved3());
                }
            }
        }, new BitField[]{locked, printable, autofill, autoline}, new String[]{"LOCKED", "PRINTABLE", "AUTOFILL", "AUTOLINE"});
        final int i8 = 3;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.p
            public final /* synthetic */ CommonObjectDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.b.getObjectType());
                    case 1:
                        return Integer.valueOf(this.b.getObjectId());
                    case 2:
                        return Short.valueOf(this.b.getOption());
                    case 3:
                        return Integer.valueOf(this.b.getReserved1());
                    case 4:
                        return Integer.valueOf(this.b.getReserved2());
                    default:
                        return Integer.valueOf(this.b.getReserved3());
                }
            }
        };
        final int i9 = 4;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.p
            public final /* synthetic */ CommonObjectDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.b.getObjectType());
                    case 1:
                        return Integer.valueOf(this.b.getObjectId());
                    case 2:
                        return Short.valueOf(this.b.getOption());
                    case 3:
                        return Integer.valueOf(this.b.getReserved1());
                    case 4:
                        return Integer.valueOf(this.b.getReserved2());
                    default:
                        return Integer.valueOf(this.b.getReserved3());
                }
            }
        };
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("objectType", supplier, "objectId", supplier2, "option", bitsAsString, "reserved1", supplier3, "reserved2", supplier4, "reserved3", new Supplier(this) { // from class: org.apache.poi.hssf.record.p
            public final /* synthetic */ CommonObjectDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Short.valueOf(this.b.getObjectType());
                    case 1:
                        return Integer.valueOf(this.b.getObjectId());
                    case 2:
                        return Short.valueOf(this.b.getOption());
                    case 3:
                        return Integer.valueOf(this.b.getReserved1());
                    case 4:
                        return Integer.valueOf(this.b.getReserved2());
                    default:
                        return Integer.valueOf(this.b.getReserved3());
                }
            }
        });
    }

    public int getObjectId() {
        return this.field_2_objectId;
    }

    public short getObjectType() {
        return this.field_1_objectType;
    }

    public short getOption() {
        return this.field_3_option;
    }

    public int getReserved1() {
        return this.field_4_reserved1;
    }

    public int getReserved2() {
        return this.field_5_reserved2;
    }

    public int getReserved3() {
        return this.field_6_reserved3;
    }

    public short getSid() {
        return (short) 21;
    }

    public boolean isAutofill() {
        return autofill.isSet(this.field_3_option);
    }

    public boolean isAutoline() {
        return autoline.isSet(this.field_3_option);
    }

    public boolean isLocked() {
        return locked.isSet(this.field_3_option);
    }

    public boolean isPrintable() {
        return printable.isSet(this.field_3_option);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(21);
        littleEndianOutput.writeShort(getDataSize());
        littleEndianOutput.writeShort(this.field_1_objectType);
        littleEndianOutput.writeShort(this.field_2_objectId);
        littleEndianOutput.writeShort(this.field_3_option);
        littleEndianOutput.writeInt(this.field_4_reserved1);
        littleEndianOutput.writeInt(this.field_5_reserved2);
        littleEndianOutput.writeInt(this.field_6_reserved3);
    }

    public void setAutofill(boolean z6) {
        this.field_3_option = autofill.setShortBoolean(this.field_3_option, z6);
    }

    public void setAutoline(boolean z6) {
        this.field_3_option = autoline.setShortBoolean(this.field_3_option, z6);
    }

    public void setLocked(boolean z6) {
        this.field_3_option = locked.setShortBoolean(this.field_3_option, z6);
    }

    public void setObjectId(int i5) {
        this.field_2_objectId = i5;
    }

    public void setObjectType(short s6) {
        this.field_1_objectType = s6;
    }

    public void setOption(short s6) {
        this.field_3_option = s6;
    }

    public void setPrintable(boolean z6) {
        this.field_3_option = printable.setShortBoolean(this.field_3_option, z6);
    }

    public void setReserved1(int i5) {
        this.field_4_reserved1 = i5;
    }

    public void setReserved2(int i5) {
        this.field_5_reserved2 = i5;
    }

    public void setReserved3(int i5) {
        this.field_6_reserved3 = i5;
    }

    public CommonObjectDataSubRecord(CommonObjectDataSubRecord commonObjectDataSubRecord) {
        super(commonObjectDataSubRecord);
        this.field_1_objectType = commonObjectDataSubRecord.field_1_objectType;
        this.field_2_objectId = commonObjectDataSubRecord.field_2_objectId;
        this.field_3_option = commonObjectDataSubRecord.field_3_option;
        this.field_4_reserved1 = commonObjectDataSubRecord.field_4_reserved1;
        this.field_5_reserved2 = commonObjectDataSubRecord.field_5_reserved2;
        this.field_6_reserved3 = commonObjectDataSubRecord.field_6_reserved3;
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.COMMON_OBJECT_DATA;
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.Duplicatable
    public CommonObjectDataSubRecord copy() {
        return new CommonObjectDataSubRecord(this);
    }

    public CommonObjectDataSubRecord(LittleEndianInput littleEndianInput, int i5) {
        this(littleEndianInput, i5, -1);
    }

    public CommonObjectDataSubRecord(LittleEndianInput littleEndianInput, int i5, int i6) {
        if (i5 == 18) {
            this.field_1_objectType = littleEndianInput.readShort();
            this.field_2_objectId = littleEndianInput.readUShort();
            this.field_3_option = littleEndianInput.readShort();
            this.field_4_reserved1 = littleEndianInput.readInt();
            this.field_5_reserved2 = littleEndianInput.readInt();
            this.field_6_reserved3 = littleEndianInput.readInt();
            return;
        }
        throw new RecordFormatException(androidx.collection.a.i(i5, "Expected size 18 but got (", ")"));
    }
}
