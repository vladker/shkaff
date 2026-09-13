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
public final class NoteStructureSubRecord extends SubRecord {
    private static final int ENCODED_SIZE = 22;
    public static final short sid = 13;
    private final byte[] reserved;

    public NoteStructureSubRecord() {
        this.reserved = new byte[22];
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
        return GenericRecordUtil.getGenericProperties("reserved", new C1381b(this, 26));
    }

    public short getSid() {
        return (short) 13;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(13);
        littleEndianOutput.writeShort(this.reserved.length);
        littleEndianOutput.write(this.reserved);
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.NOTE_STRUCTURE;
    }

    public NoteStructureSubRecord(NoteStructureSubRecord noteStructureSubRecord) {
        super(noteStructureSubRecord);
        this.reserved = (byte[]) noteStructureSubRecord.reserved.clone();
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.Duplicatable
    public NoteStructureSubRecord copy() {
        return new NoteStructureSubRecord(this);
    }

    public NoteStructureSubRecord(LittleEndianInput littleEndianInput, int i5) {
        this(littleEndianInput, i5, -1);
    }

    public NoteStructureSubRecord(LittleEndianInput littleEndianInput, int i5, int i6) {
        if (i5 == 22) {
            byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, 22);
            littleEndianInput.readFully(bArrSafelyAllocate);
            this.reserved = bArrSafelyAllocate;
            return;
        }
        throw new RecordFormatException(androidx.collection.a.i(i5, "Unexpected size (", ")"));
    }
}
