package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class NoteRecord extends StandardRecord {
    public static final short NOTE_HIDDEN = 0;
    public static final short NOTE_VISIBLE = 2;
    public static final short sid = 28;
    private int field_1_row;
    private int field_2_col;
    private short field_3_flags;
    private int field_4_shapeid;
    private boolean field_5_hasMultibyte;
    private String field_6_author;
    private Byte field_7_padding;
    public static final NoteRecord[] EMPTY_ARRAY = new NoteRecord[0];
    private static final Byte DEFAULT_PADDING = (byte) 0;

    public NoteRecord() {
        this.field_6_author = "";
        this.field_3_flags = (short) 0;
        this.field_7_padding = DEFAULT_PADDING;
    }

    public boolean authorIsMultibyte() {
        return this.field_5_hasMultibyte;
    }

    public String getAuthor() {
        return this.field_6_author;
    }

    public int getColumn() {
        return this.field_2_col;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this.field_6_author.length() * (this.field_5_hasMultibyte ? 2 : 1)) + 11 + (this.field_7_padding == null ? 0 : 1);
    }

    public short getFlags() {
        return this.field_3_flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.o0
            public final /* synthetic */ NoteRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Integer.valueOf(this.b.getColumn());
                    case 2:
                        return Short.valueOf(this.b.getFlags());
                    case 3:
                        return Integer.valueOf(this.b.getShapeId());
                    default:
                        return this.b.getAuthor();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.o0
            public final /* synthetic */ NoteRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Integer.valueOf(this.b.getColumn());
                    case 2:
                        return Short.valueOf(this.b.getFlags());
                    case 3:
                        return Integer.valueOf(this.b.getShapeId());
                    default:
                        return this.b.getAuthor();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.o0
            public final /* synthetic */ NoteRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Integer.valueOf(this.b.getColumn());
                    case 2:
                        return Short.valueOf(this.b.getFlags());
                    case 3:
                        return Integer.valueOf(this.b.getShapeId());
                    default:
                        return this.b.getAuthor();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.o0
            public final /* synthetic */ NoteRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Integer.valueOf(this.b.getColumn());
                    case 2:
                        return Short.valueOf(this.b.getFlags());
                    case 3:
                        return Integer.valueOf(this.b.getShapeId());
                    default:
                        return this.b.getAuthor();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("row", supplier, "column", supplier2, "flags", supplier3, "shapeId", supplier4, "author", new Supplier(this) { // from class: org.apache.poi.hssf.record.o0
            public final /* synthetic */ NoteRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Integer.valueOf(this.b.getColumn());
                    case 2:
                        return Short.valueOf(this.b.getFlags());
                    case 3:
                        return Integer.valueOf(this.b.getShapeId());
                    default:
                        return this.b.getAuthor();
                }
            }
        });
    }

    public int getRow() {
        return this.field_1_row;
    }

    public int getShapeId() {
        return this.field_4_shapeid;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 28;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_row);
        littleEndianOutput.writeShort(this.field_2_col);
        littleEndianOutput.writeShort(this.field_3_flags);
        littleEndianOutput.writeShort(this.field_4_shapeid);
        littleEndianOutput.writeShort(this.field_6_author.length());
        littleEndianOutput.writeByte(this.field_5_hasMultibyte ? 1 : 0);
        if (this.field_5_hasMultibyte) {
            StringUtil.putUnicodeLE(this.field_6_author, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(this.field_6_author, littleEndianOutput);
        }
        Byte b = this.field_7_padding;
        if (b != null) {
            littleEndianOutput.writeByte(b.intValue());
        }
    }

    public void setAuthor(String str) {
        this.field_6_author = str;
        this.field_5_hasMultibyte = StringUtil.hasMultibyte(str);
    }

    public void setColumn(int i5) {
        this.field_2_col = i5;
    }

    public void setFlags(short s6) {
        this.field_3_flags = s6;
    }

    public void setRow(int i5) {
        this.field_1_row = i5;
    }

    public void setShapeId(int i5) {
        this.field_4_shapeid = i5;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.NOTE;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public NoteRecord copy() {
        return new NoteRecord(this);
    }

    public NoteRecord(NoteRecord noteRecord) {
        super(noteRecord);
        this.field_1_row = noteRecord.field_1_row;
        this.field_2_col = noteRecord.field_2_col;
        this.field_3_flags = noteRecord.field_3_flags;
        this.field_4_shapeid = noteRecord.field_4_shapeid;
        this.field_5_hasMultibyte = noteRecord.field_5_hasMultibyte;
        this.field_6_author = noteRecord.field_6_author;
        this.field_7_padding = noteRecord.field_7_padding;
    }

    public NoteRecord(RecordInputStream recordInputStream) {
        this.field_1_row = recordInputStream.readUShort();
        this.field_2_col = recordInputStream.readShort();
        this.field_3_flags = recordInputStream.readShort();
        this.field_4_shapeid = recordInputStream.readUShort();
        short s6 = recordInputStream.readShort();
        boolean z6 = recordInputStream.readByte() != 0;
        this.field_5_hasMultibyte = z6;
        if (z6) {
            this.field_6_author = StringUtil.readUnicodeLE(recordInputStream, s6);
        } else {
            this.field_6_author = StringUtil.readCompressedUnicode(recordInputStream, s6);
        }
        if (recordInputStream.available() == 1) {
            this.field_7_padding = Byte.valueOf(recordInputStream.readByte());
        } else if (recordInputStream.available() == 2 && s6 == 0) {
            this.field_7_padding = Byte.valueOf(recordInputStream.readByte());
            recordInputStream.readByte();
        }
    }
}
