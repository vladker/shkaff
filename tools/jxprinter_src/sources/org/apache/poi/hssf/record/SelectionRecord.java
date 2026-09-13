package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SelectionRecord extends StandardRecord {
    public static final short sid = 29;
    private byte field_1_pane;
    private int field_2_row_active_cell;
    private int field_3_col_active_cell;
    private int field_4_active_cell_ref_index;
    private CellRangeAddress8Bit[] field_6_refs;

    public SelectionRecord(SelectionRecord selectionRecord) {
        super(selectionRecord);
        this.field_1_pane = selectionRecord.field_1_pane;
        this.field_2_row_active_cell = selectionRecord.field_2_row_active_cell;
        this.field_3_col_active_cell = selectionRecord.field_3_col_active_cell;
        this.field_4_active_cell_ref_index = selectionRecord.field_4_active_cell_ref_index;
        CellRangeAddress8Bit[] cellRangeAddress8BitArr = selectionRecord.field_6_refs;
        this.field_6_refs = cellRangeAddress8BitArr == null ? null : (CellRangeAddress8Bit[]) Stream.of((Object[]) cellRangeAddress8BitArr).map(new G(6)).toArray(new C1434x0(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return this.field_6_refs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CellRangeAddress8Bit[] lambda$new$0(int i5) {
        return new CellRangeAddress8Bit[i5];
    }

    private void resetField6() {
        int i5 = this.field_2_row_active_cell;
        int i6 = this.field_3_col_active_cell;
        this.field_6_refs = new CellRangeAddress8Bit[]{new CellRangeAddress8Bit(i5, i5, i6, i6)};
    }

    public int getActiveCellCol() {
        return this.field_3_col_active_cell;
    }

    public int getActiveCellRef() {
        return this.field_4_active_cell_ref_index;
    }

    public int getActiveCellRow() {
        return this.field_2_row_active_cell;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return CellRangeAddress8Bit.getEncodedSize(this.field_6_refs.length) + 9;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.L0
            public final /* synthetic */ SelectionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Byte.valueOf(this.b.getPane());
                    case 1:
                        return Integer.valueOf(this.b.getActiveCellRow());
                    case 2:
                        return Integer.valueOf(this.b.getActiveCellCol());
                    case 3:
                        return Integer.valueOf(this.b.getActiveCellRef());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.L0
            public final /* synthetic */ SelectionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Byte.valueOf(this.b.getPane());
                    case 1:
                        return Integer.valueOf(this.b.getActiveCellRow());
                    case 2:
                        return Integer.valueOf(this.b.getActiveCellCol());
                    case 3:
                        return Integer.valueOf(this.b.getActiveCellRef());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.L0
            public final /* synthetic */ SelectionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Byte.valueOf(this.b.getPane());
                    case 1:
                        return Integer.valueOf(this.b.getActiveCellRow());
                    case 2:
                        return Integer.valueOf(this.b.getActiveCellCol());
                    case 3:
                        return Integer.valueOf(this.b.getActiveCellRef());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.L0
            public final /* synthetic */ SelectionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Byte.valueOf(this.b.getPane());
                    case 1:
                        return Integer.valueOf(this.b.getActiveCellRow());
                    case 2:
                        return Integer.valueOf(this.b.getActiveCellCol());
                    case 3:
                        return Integer.valueOf(this.b.getActiveCellRef());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("pane", supplier, "activeCellRow", supplier2, "activeCellCol", supplier3, "activeCellRef", supplier4, "refs", new Supplier(this) { // from class: org.apache.poi.hssf.record.L0
            public final /* synthetic */ SelectionRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Byte.valueOf(this.b.getPane());
                    case 1:
                        return Integer.valueOf(this.b.getActiveCellRow());
                    case 2:
                        return Integer.valueOf(this.b.getActiveCellCol());
                    case 3:
                        return Integer.valueOf(this.b.getActiveCellRef());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    public byte getPane() {
        return this.field_1_pane;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 29;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPane());
        littleEndianOutput.writeShort(getActiveCellRow());
        littleEndianOutput.writeShort(getActiveCellCol());
        littleEndianOutput.writeShort(getActiveCellRef());
        littleEndianOutput.writeShort(this.field_6_refs.length);
        for (CellRangeAddress8Bit cellRangeAddress8Bit : this.field_6_refs) {
            cellRangeAddress8Bit.serialize(littleEndianOutput);
        }
    }

    public void setActiveCellCol(short s6) {
        this.field_3_col_active_cell = s6;
        resetField6();
    }

    public void setActiveCellRef(short s6) {
        this.field_4_active_cell_ref_index = s6;
    }

    public void setActiveCellRow(int i5) {
        this.field_2_row_active_cell = i5;
        resetField6();
    }

    public void setPane(byte b) {
        this.field_1_pane = b;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SELECTION;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public SelectionRecord copy() {
        return new SelectionRecord(this);
    }

    public SelectionRecord(int i5, int i6) {
        this.field_1_pane = (byte) 3;
        this.field_2_row_active_cell = i5;
        this.field_3_col_active_cell = i6;
        this.field_4_active_cell_ref_index = 0;
        this.field_6_refs = new CellRangeAddress8Bit[]{new CellRangeAddress8Bit(i5, i5, i6, i6)};
    }

    public SelectionRecord(RecordInputStream recordInputStream) {
        this.field_1_pane = recordInputStream.readByte();
        this.field_2_row_active_cell = recordInputStream.readUShort();
        this.field_3_col_active_cell = recordInputStream.readShort();
        this.field_4_active_cell_ref_index = recordInputStream.readShort();
        this.field_6_refs = new CellRangeAddress8Bit[recordInputStream.readUShort()];
        int i5 = 0;
        while (true) {
            CellRangeAddress8Bit[] cellRangeAddress8BitArr = this.field_6_refs;
            if (i5 >= cellRangeAddress8BitArr.length) {
                return;
            }
            cellRangeAddress8BitArr[i5] = new CellRangeAddress8Bit(recordInputStream);
            i5++;
        }
    }
}
