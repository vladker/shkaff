package org.apache.poi.hssf.record;

import A3.AbstractC0157z;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IntList;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class IndexRecord extends StandardRecord {
    public static final short sid = 523;
    private int field_2_first_row;
    private int field_3_last_row_add1;
    private int field_4_zero;
    private IntList field_5_dbcells;

    public IndexRecord() {
    }

    public static int getRecordSizeForBlockCount(int i5) {
        return (i5 * 4) + 20;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getGenericProperties$0() {
        return null;
    }

    public void addDbcell(int i5) {
        if (this.field_5_dbcells == null) {
            this.field_5_dbcells = new IntList();
        }
        this.field_5_dbcells.add(i5);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (getNumDbcells() * 4) + 16;
    }

    public int getDbcellAt(int i5) {
        return this.field_5_dbcells.get(i5);
    }

    public int getFirstRow() {
        return this.field_2_first_row;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.b0
            public final /* synthetic */ IndexRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int firstRow;
                switch (i5) {
                    case 0:
                        firstRow = this.b.getFirstRow();
                        break;
                    default:
                        firstRow = this.b.getLastRowAdd1();
                        break;
                }
                return Integer.valueOf(firstRow);
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.b0
            public final /* synthetic */ IndexRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int firstRow;
                switch (i6) {
                    case 0:
                        firstRow = this.b.getFirstRow();
                        break;
                    default:
                        firstRow = this.b.getLastRowAdd1();
                        break;
                }
                return Integer.valueOf(firstRow);
            }
        };
        IntList intList = this.field_5_dbcells;
        return GenericRecordUtil.getGenericProperties("firstRow", supplier, "lastRowAdd1", supplier2, "dbcell_", intList == null ? new K(1) : new C1381b(intList, 23));
    }

    public int getLastRowAdd1() {
        return this.field_3_last_row_add1;
    }

    public int getNumDbcells() {
        IntList intList = this.field_5_dbcells;
        if (intList == null) {
            return 0;
        }
        return intList.size();
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(0);
        littleEndianOutput.writeInt(getFirstRow());
        littleEndianOutput.writeInt(getLastRowAdd1());
        littleEndianOutput.writeInt(this.field_4_zero);
        for (int i5 = 0; i5 < getNumDbcells(); i5++) {
            littleEndianOutput.writeInt(getDbcellAt(i5));
        }
    }

    public void setDbcell(int i5, int i6) {
        this.field_5_dbcells.set(i5, i6);
    }

    public void setFirstRow(int i5) {
        this.field_2_first_row = i5;
    }

    public void setLastRowAdd1(int i5) {
        this.field_3_last_row_add1 = i5;
    }

    public IndexRecord(IndexRecord indexRecord) {
        super(indexRecord);
        this.field_2_first_row = indexRecord.field_2_first_row;
        this.field_3_last_row_add1 = indexRecord.field_3_last_row_add1;
        this.field_4_zero = indexRecord.field_4_zero;
        IntList intList = indexRecord.field_5_dbcells;
        this.field_5_dbcells = intList == null ? null : new IntList(intList);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.INDEX;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public IndexRecord copy() {
        return new IndexRecord(this);
    }

    public IndexRecord(RecordInputStream recordInputStream) {
        int i5 = recordInputStream.readInt();
        if (i5 == 0) {
            this.field_2_first_row = recordInputStream.readInt();
            this.field_3_last_row_add1 = recordInputStream.readInt();
            this.field_4_zero = recordInputStream.readInt();
            int iRemaining = recordInputStream.remaining() / 4;
            this.field_5_dbcells = new IntList(iRemaining);
            for (int i6 = 0; i6 < iRemaining; i6++) {
                this.field_5_dbcells.add(recordInputStream.readInt());
            }
            return;
        }
        throw new RecordFormatException(AbstractC0157z.k(i5, "Expected zero for field 1 but got "));
    }
}
