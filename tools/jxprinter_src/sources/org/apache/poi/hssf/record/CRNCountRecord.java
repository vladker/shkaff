package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CRNCountRecord extends StandardRecord {
    private static final short DATA_SIZE = 4;
    public static final short sid = 89;
    private int field_1_number_crn_records;
    private int field_2_sheet_table_index;

    public CRNCountRecord(CRNCountRecord cRNCountRecord) {
        super(cRNCountRecord);
        this.field_1_number_crn_records = cRNCountRecord.field_1_number_crn_records;
        this.field_2_sheet_table_index = cRNCountRecord.field_2_sheet_table_index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.field_2_sheet_table_index);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("numberOfCRNs", new Supplier(this) { // from class: org.apache.poi.hssf.record.l
            public final /* synthetic */ CRNCountRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getNumberOfCRNs());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        }, "sheetTableIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.l
            public final /* synthetic */ CRNCountRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getNumberOfCRNs());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        });
    }

    public int getNumberOfCRNs() {
        return this.field_1_number_crn_records;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 89;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort((short) this.field_1_number_crn_records);
        littleEndianOutput.writeShort((short) this.field_2_sheet_table_index);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CRN_COUNT;
    }

    public CRNCountRecord(RecordInputStream recordInputStream) {
        short s6 = recordInputStream.readShort();
        this.field_1_number_crn_records = s6;
        if (s6 < 0) {
            this.field_1_number_crn_records = (short) (-s6);
        }
        this.field_2_sheet_table_index = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public CRNCountRecord copy() {
        return new CRNCountRecord(this);
    }
}
