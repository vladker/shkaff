package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SCLRecord extends StandardRecord {
    public static final short sid = 160;
    private short field_1_numerator;
    private short field_2_denominator;

    public SCLRecord() {
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    public short getDenominator() {
        return this.field_2_denominator;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("numerator", new Supplier(this) { // from class: org.apache.poi.hssf.record.J0
            public final /* synthetic */ SCLRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short numerator;
                switch (i5) {
                    case 0:
                        numerator = this.b.getNumerator();
                        break;
                    default:
                        numerator = this.b.getDenominator();
                        break;
                }
                return Short.valueOf(numerator);
            }
        }, "denominator", new Supplier(this) { // from class: org.apache.poi.hssf.record.J0
            public final /* synthetic */ SCLRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                short numerator;
                switch (i6) {
                    case 0:
                        numerator = this.b.getNumerator();
                        break;
                    default:
                        numerator = this.b.getDenominator();
                        break;
                }
                return Short.valueOf(numerator);
            }
        });
    }

    public short getNumerator() {
        return this.field_1_numerator;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 160;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_numerator);
        littleEndianOutput.writeShort(this.field_2_denominator);
    }

    public void setDenominator(short s6) {
        this.field_2_denominator = s6;
    }

    public void setNumerator(short s6) {
        this.field_1_numerator = s6;
    }

    public SCLRecord(SCLRecord sCLRecord) {
        super(sCLRecord);
        this.field_1_numerator = sCLRecord.field_1_numerator;
        this.field_2_denominator = sCLRecord.field_2_denominator;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SCL;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public SCLRecord copy() {
        return new SCLRecord(this);
    }

    public SCLRecord(RecordInputStream recordInputStream) {
        this.field_1_numerator = recordInputStream.readShort();
        this.field_2_denominator = recordInputStream.readShort();
    }
}
