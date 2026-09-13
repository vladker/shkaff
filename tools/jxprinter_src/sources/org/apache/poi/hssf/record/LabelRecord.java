package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class LabelRecord extends Record implements CellValueRecordInterface {
    private static final Logger LOG = LogManager.getLogger((Class<?>) LabelRecord.class);
    public static final short sid = 516;
    private int field_1_row;
    private short field_2_column;
    private short field_3_xf_index;
    private short field_4_string_len;
    private byte field_5_unicode_flag;
    private String field_6_value;

    public LabelRecord() {
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getColumn() {
        return this.field_2_column;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.d0
            public final /* synthetic */ LabelRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    case 2:
                        return Short.valueOf(this.b.getXFIndex());
                    case 3:
                        return Short.valueOf(this.b.getStringLength());
                    case 4:
                        return Boolean.valueOf(this.b.isUnCompressedUnicode());
                    default:
                        return this.b.getValue();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.d0
            public final /* synthetic */ LabelRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    case 2:
                        return Short.valueOf(this.b.getXFIndex());
                    case 3:
                        return Short.valueOf(this.b.getStringLength());
                    case 4:
                        return Boolean.valueOf(this.b.isUnCompressedUnicode());
                    default:
                        return this.b.getValue();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.d0
            public final /* synthetic */ LabelRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    case 2:
                        return Short.valueOf(this.b.getXFIndex());
                    case 3:
                        return Short.valueOf(this.b.getStringLength());
                    case 4:
                        return Boolean.valueOf(this.b.isUnCompressedUnicode());
                    default:
                        return this.b.getValue();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.d0
            public final /* synthetic */ LabelRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    case 2:
                        return Short.valueOf(this.b.getXFIndex());
                    case 3:
                        return Short.valueOf(this.b.getStringLength());
                    case 4:
                        return Boolean.valueOf(this.b.isUnCompressedUnicode());
                    default:
                        return this.b.getValue();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.d0
            public final /* synthetic */ LabelRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    case 2:
                        return Short.valueOf(this.b.getXFIndex());
                    case 3:
                        return Short.valueOf(this.b.getStringLength());
                    case 4:
                        return Boolean.valueOf(this.b.isUnCompressedUnicode());
                    default:
                        return this.b.getValue();
                }
            }
        };
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("row", supplier, "column", supplier2, "xfIndex", supplier3, "stringLen", supplier4, "unCompressedUnicode", supplier5, "value", new Supplier(this) { // from class: org.apache.poi.hssf.record.d0
            public final /* synthetic */ LabelRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getColumn());
                    case 2:
                        return Short.valueOf(this.b.getXFIndex());
                    case 3:
                        return Short.valueOf(this.b.getStringLength());
                    case 4:
                        return Boolean.valueOf(this.b.isUnCompressedUnicode());
                    default:
                        return this.b.getValue();
                }
            }
        });
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        throw new RecordFormatException("Label Records are supported READ ONLY...convert to LabelSST");
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public int getRow() {
        return this.field_1_row;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 516;
    }

    public short getStringLength() {
        return this.field_4_string_len;
    }

    public String getValue() {
        return this.field_6_value;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getXFIndex() {
        return this.field_3_xf_index;
    }

    public boolean isUnCompressedUnicode() {
        return (this.field_5_unicode_flag & 1) != 0;
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int serialize(int i5, byte[] bArr) {
        throw new RecordFormatException("Label Records are supported READ ONLY...convert to LabelSST");
    }

    public LabelRecord(LabelRecord labelRecord) {
        super(labelRecord);
        this.field_1_row = labelRecord.field_1_row;
        this.field_2_column = labelRecord.field_2_column;
        this.field_3_xf_index = labelRecord.field_3_xf_index;
        this.field_4_string_len = labelRecord.field_4_string_len;
        this.field_5_unicode_flag = labelRecord.field_5_unicode_flag;
        this.field_6_value = labelRecord.field_6_value;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.LABEL;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public LabelRecord copy() {
        return new LabelRecord(this);
    }

    public LabelRecord(RecordInputStream recordInputStream) {
        this.field_1_row = recordInputStream.readUShort();
        this.field_2_column = recordInputStream.readShort();
        this.field_3_xf_index = recordInputStream.readShort();
        this.field_4_string_len = recordInputStream.readShort();
        this.field_5_unicode_flag = recordInputStream.readByte();
        if (this.field_4_string_len > 0) {
            if (isUnCompressedUnicode()) {
                this.field_6_value = recordInputStream.readUnicodeLEString(this.field_4_string_len);
            } else {
                this.field_6_value = recordInputStream.readCompressedUnicode(this.field_4_string_len);
            }
        } else {
            this.field_6_value = "";
        }
        if (recordInputStream.remaining() > 0) {
            LOG.atInfo().log("LabelRecord data remains: {} : {}", Unbox.box(recordInputStream.remaining()), HexDump.toHex(recordInputStream.readRemainder()));
        }
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setColumn(short s6) {
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setRow(int i5) {
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setXFIndex(short s6) {
    }
}
