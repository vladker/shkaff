package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class GroupMarkerSubRecord extends SubRecord {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final short sid = 6;
    private byte[] reserved;

    public GroupMarkerSubRecord() {
        this.reserved = EMPTY_BYTE_ARRAY;
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
        return GenericRecordUtil.getGenericProperties("reserved", new C1381b(this, 18));
    }

    public short getSid() {
        return (short) 6;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(6);
        littleEndianOutput.writeShort(this.reserved.length);
        littleEndianOutput.write(this.reserved);
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.GROUP_MARKER;
    }

    public GroupMarkerSubRecord(GroupMarkerSubRecord groupMarkerSubRecord) {
        super(groupMarkerSubRecord);
        this.reserved = (byte[]) groupMarkerSubRecord.reserved.clone();
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.Duplicatable
    public GroupMarkerSubRecord copy() {
        return new GroupMarkerSubRecord(this);
    }

    public GroupMarkerSubRecord(LittleEndianInput littleEndianInput, int i5) {
        this(littleEndianInput, i5, -1);
    }

    public GroupMarkerSubRecord(LittleEndianInput littleEndianInput, int i5, int i6) {
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, HSSFWorkbook.getMaxRecordLength());
        littleEndianInput.readFully(bArrSafelyAllocate);
        this.reserved = bArrSafelyAllocate;
    }
}
