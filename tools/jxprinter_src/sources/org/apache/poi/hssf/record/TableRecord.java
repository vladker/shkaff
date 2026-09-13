package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class TableRecord extends SharedValueRecordBase {
    public static final short sid = 566;
    private int field_10_colInputCol;
    private int field_5_flags;
    private int field_6_res;
    private int field_7_rowInputRow;
    private int field_8_colInputRow;
    private int field_9_rowInputCol;
    private static final BitField alwaysCalc = BitFieldFactory.getInstance(1);
    private static final BitField calcOnOpen = BitFieldFactory.getInstance(2);
    private static final BitField rowOrColInpCell = BitFieldFactory.getInstance(4);
    private static final BitField oneOrTwoVar = BitFieldFactory.getInstance(8);
    private static final BitField rowDeleted = BitFieldFactory.getInstance(16);
    private static final BitField colDeleted = BitFieldFactory.getInstance(32);

    public TableRecord(TableRecord tableRecord) {
        super(tableRecord);
        this.field_5_flags = tableRecord.field_5_flags;
        this.field_6_res = tableRecord.field_6_res;
        this.field_7_rowInputRow = tableRecord.field_7_rowInputRow;
        this.field_8_colInputRow = tableRecord.field_8_colInputRow;
        this.field_9_rowInputCol = tableRecord.field_9_rowInputCol;
        this.field_10_colInputCol = tableRecord.field_10_colInputCol;
    }

    private static CellReference cr(int i5, int i6) {
        return new CellReference(i5, i6 & 255, (32768 & i6) == 0, (i6 & 16384) == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.field_6_res);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return cr(this.field_7_rowInputRow, this.field_8_colInputRow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return cr(this.field_9_rowInputCol, this.field_10_colInputCol);
    }

    public int getColInputCol() {
        return this.field_10_colInputCol;
    }

    public int getColInputRow() {
        return this.field_8_colInputRow;
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    public int getExtraDataSize() {
        return 10;
    }

    public int getFlags() {
        return this.field_5_flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.S0
            public final /* synthetic */ TableRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.getRange();
                    case 1:
                        return Integer.valueOf(this.b.getFlags());
                    case 2:
                        return this.b.lambda$getGenericProperties$0();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i6 = 1;
        Supplier<GenericRecordUtil.AnnotatedFlag> bitsAsString = GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.S0
            public final /* synthetic */ TableRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.getRange();
                    case 1:
                        return Integer.valueOf(this.b.getFlags());
                    case 2:
                        return this.b.lambda$getGenericProperties$0();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        }, new BitField[]{alwaysCalc, calcOnOpen, rowOrColInpCell, oneOrTwoVar, rowDeleted, colDeleted}, new String[]{"ALWAYS_CALC", "CALC_ON_OPEN", "ROW_OR_COL_INP_CELL", "ONE_OR_TWO_VAR", "ROW_DELETED", "COL_DELETED"});
        final int i7 = 2;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.S0
            public final /* synthetic */ TableRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.getRange();
                    case 1:
                        return Integer.valueOf(this.b.getFlags());
                    case 2:
                        return this.b.lambda$getGenericProperties$0();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.S0
            public final /* synthetic */ TableRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.getRange();
                    case 1:
                        return Integer.valueOf(this.b.getFlags());
                    case 2:
                        return this.b.lambda$getGenericProperties$0();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("range", supplier, "flags", bitsAsString, "reserved", supplier2, "rowInput", supplier3, "colInput", new Supplier(this) { // from class: org.apache.poi.hssf.record.S0
            public final /* synthetic */ TableRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.getRange();
                    case 1:
                        return Integer.valueOf(this.b.getFlags());
                    case 2:
                        return this.b.lambda$getGenericProperties$0();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.lambda$getGenericProperties$2();
                }
            }
        });
    }

    public int getRowInputCol() {
        return this.field_9_rowInputCol;
    }

    public int getRowInputRow() {
        return this.field_7_rowInputRow;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean isAlwaysCalc() {
        return alwaysCalc.isSet(this.field_5_flags);
    }

    public boolean isColDeleted() {
        return colDeleted.isSet(this.field_5_flags);
    }

    public boolean isOneNotTwoVar() {
        return oneOrTwoVar.isSet(this.field_5_flags);
    }

    public boolean isRowDeleted() {
        return rowDeleted.isSet(this.field_5_flags);
    }

    public boolean isRowOrColInpCell() {
        return rowOrColInpCell.isSet(this.field_5_flags);
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    public void serializeExtraData(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this.field_5_flags);
        littleEndianOutput.writeByte(this.field_6_res);
        littleEndianOutput.writeShort(this.field_7_rowInputRow);
        littleEndianOutput.writeShort(this.field_8_colInputRow);
        littleEndianOutput.writeShort(this.field_9_rowInputCol);
        littleEndianOutput.writeShort(this.field_10_colInputCol);
    }

    public void setAlwaysCalc(boolean z6) {
        this.field_5_flags = alwaysCalc.setBoolean(this.field_5_flags, z6);
    }

    public void setColDeleted(boolean z6) {
        this.field_5_flags = colDeleted.setBoolean(this.field_5_flags, z6);
    }

    public void setColInputCol(int i5) {
        this.field_10_colInputCol = i5;
    }

    public void setColInputRow(int i5) {
        this.field_8_colInputRow = i5;
    }

    public void setFlags(int i5) {
        this.field_5_flags = i5;
    }

    public void setOneNotTwoVar(boolean z6) {
        this.field_5_flags = oneOrTwoVar.setBoolean(this.field_5_flags, z6);
    }

    public void setRowDeleted(boolean z6) {
        this.field_5_flags = rowDeleted.setBoolean(this.field_5_flags, z6);
    }

    public void setRowInputCol(int i5) {
        this.field_9_rowInputCol = i5;
    }

    public void setRowInputRow(int i5) {
        this.field_7_rowInputRow = i5;
    }

    public void setRowOrColInpCell(boolean z6) {
        this.field_5_flags = rowOrColInpCell.setBoolean(this.field_5_flags, z6);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.TABLE;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public TableRecord copy() {
        return new TableRecord(this);
    }

    public TableRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        this.field_5_flags = recordInputStream.readByte();
        this.field_6_res = recordInputStream.readByte();
        this.field_7_rowInputRow = recordInputStream.readShort();
        this.field_8_colInputRow = recordInputStream.readShort();
        this.field_9_rowInputCol = recordInputStream.readShort();
        this.field_10_colInputCol = recordInputStream.readShort();
    }

    public TableRecord(CellRangeAddress8Bit cellRangeAddress8Bit) {
        super(cellRangeAddress8Bit);
        this.field_6_res = 0;
    }
}
