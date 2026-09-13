package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FtCblsSubRecord extends SubRecord {
    private static final int ENCODED_SIZE = 20;
    public static final short sid = 12;
    private final byte[] reserved;

    public FtCblsSubRecord() {
        this.reserved = new byte[20];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this.reserved;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        return this.reserved.length;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("reserved", new C1381b(this, 14));
    }

    public short getSid() {
        return (short) 12;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(12);
        littleEndianOutput.writeShort(this.reserved.length);
        littleEndianOutput.write(this.reserved);
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.FT_CBLS;
    }

    public FtCblsSubRecord(FtCblsSubRecord ftCblsSubRecord) {
        super(ftCblsSubRecord);
        this.reserved = (byte[]) ftCblsSubRecord.reserved.clone();
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.Duplicatable
    public FtCblsSubRecord copy() {
        return new FtCblsSubRecord(this);
    }

    public FtCblsSubRecord(LittleEndianInput littleEndianInput, int i5) {
        this(littleEndianInput, i5, -1);
    }

    public FtCblsSubRecord(LittleEndianInput littleEndianInput, int i5, int i6) {
        if (i5 == 20) {
            byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, 20);
            littleEndianInput.readFully(bArrSafelyAllocate);
            this.reserved = bArrSafelyAllocate;
            return;
        }
        throw new RecordFormatException(androidx.collection.a.i(i5, "Unexpected size (", ")"));
    }
}
