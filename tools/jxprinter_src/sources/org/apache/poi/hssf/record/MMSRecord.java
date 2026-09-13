package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class MMSRecord extends StandardRecord {
    public static final short sid = 193;
    private byte field_1_addMenuCount;
    private byte field_2_delMenuCount;

    public MMSRecord() {
    }

    public byte getAddMenuCount() {
        return this.field_1_addMenuCount;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    public byte getDelMenuCount() {
        return this.field_2_delMenuCount;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("addMenuCount", new Supplier(this) { // from class: org.apache.poi.hssf.record.h0
            public final /* synthetic */ MMSRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                byte addMenuCount;
                switch (i5) {
                    case 0:
                        addMenuCount = this.b.getAddMenuCount();
                        break;
                    default:
                        addMenuCount = this.b.getDelMenuCount();
                        break;
                }
                return Byte.valueOf(addMenuCount);
            }
        }, "delMenuCount", new Supplier(this) { // from class: org.apache.poi.hssf.record.h0
            public final /* synthetic */ MMSRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                byte addMenuCount;
                switch (i6) {
                    case 0:
                        addMenuCount = this.b.getAddMenuCount();
                        break;
                    default:
                        addMenuCount = this.b.getDelMenuCount();
                        break;
                }
                return Byte.valueOf(addMenuCount);
            }
        });
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 193;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getAddMenuCount());
        littleEndianOutput.writeByte(getDelMenuCount());
    }

    public void setAddMenuCount(byte b) {
        this.field_1_addMenuCount = b;
    }

    public void setDelMenuCount(byte b) {
        this.field_2_delMenuCount = b;
    }

    public MMSRecord(MMSRecord mMSRecord) {
        this.field_1_addMenuCount = mMSRecord.field_1_addMenuCount;
        this.field_2_delMenuCount = mMSRecord.field_2_delMenuCount;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.MMS;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public MMSRecord copy() {
        return new MMSRecord(this);
    }

    public MMSRecord(RecordInputStream recordInputStream) {
        if (recordInputStream.remaining() == 0) {
            return;
        }
        this.field_1_addMenuCount = recordInputStream.readByte();
        this.field_2_delMenuCount = recordInputStream.readByte();
    }
}
