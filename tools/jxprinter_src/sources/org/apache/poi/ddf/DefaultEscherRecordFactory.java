package org.apache.poi.ddf;

import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultEscherRecordFactory implements EscherRecordFactory {
    private static final BitField IS_CONTAINER = BitFieldFactory.getInstance(15);

    @Override // org.apache.poi.ddf.EscherRecordFactory
    public EscherRecord createRecord(byte[] bArr, int i5) {
        short s6 = LittleEndian.getShort(bArr, i5);
        short s7 = LittleEndian.getShort(bArr, i5 + 2);
        EscherRecord escherRecord = getConstructor(s6, s7).get();
        escherRecord.setRecordId(s7);
        escherRecord.setOptions(s6);
        return escherRecord;
    }

    public Supplier<? extends EscherRecord> getConstructor(short s6, short s7) {
        EscherRecordTypes escherRecordTypesForTypeID = EscherRecordTypes.forTypeID(s7);
        EscherRecordTypes escherRecordTypes = EscherRecordTypes.UNKNOWN;
        if (escherRecordTypesForTypeID == escherRecordTypes && IS_CONTAINER.isAllSet(s6)) {
            return new androidx.emoji2.text.flatbuffer.a(4);
        }
        Supplier<? extends EscherRecord> supplier = escherRecordTypesForTypeID.constructor;
        if (supplier == null || escherRecordTypesForTypeID == escherRecordTypes) {
            return (EscherBlipRecord.RECORD_ID_START > s7 || s7 > EscherBlipRecord.RECORD_ID_END) ? new androidx.emoji2.text.flatbuffer.a(6) : new androidx.emoji2.text.flatbuffer.a(5);
        }
        return supplier;
    }
}
