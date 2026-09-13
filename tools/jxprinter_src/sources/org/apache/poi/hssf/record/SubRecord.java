package org.apache.poi.hssf.record;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.LittleEndianOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SubRecord implements Duplicatable, GenericRecord {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 1000000;
    private static int MAX_RECORD_LENGTH = 1000000;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum SubRecordTypes {
        UNKNOWN(-1, new P0(0)),
        END(0, new Z(21)),
        GROUP_MARKER(6, new Z(22)),
        FT_CF(7, new Z(23)),
        FT_PIO_GRBIT(8, new Z(24)),
        EMBEDDED_OBJECT_REF(9, new Z(25)),
        FT_CBLS(12, new Z(26)),
        NOTE_STRUCTURE(13, new Z(27)),
        LBS_DATA(19, new Z(28)),
        COMMON_OBJECT_DATA(21, new Z(20));

        private static final Map<Short, SubRecordTypes> LOOKUP = (Map) Arrays.stream(values()).collect(Collectors.toMap(new G(7), Function.identity()));
        public final RecordConstructor<?> recordConstructor;
        public final short sid;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        @FunctionalInterface
        public interface RecordConstructor<T extends SubRecord> {
            T apply(LittleEndianInput littleEndianInput, int i5, int i6);
        }

        SubRecordTypes(int i5, RecordConstructor recordConstructor) {
            this.sid = (short) i5;
            this.recordConstructor = recordConstructor;
        }

        public static SubRecordTypes forSID(int i5) {
            return LOOKUP.getOrDefault(Short.valueOf((short) i5), UNKNOWN);
        }

        public short getSid() {
            return this.sid;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class UnknownSubRecord extends SubRecord {
        private final byte[] _data;
        private final int _sid;

        public UnknownSubRecord(LittleEndianInput littleEndianInput, int i5, int i6) {
            this._sid = i6;
            byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, SubRecord.MAX_RECORD_LENGTH);
            littleEndianInput.readFully(bArrSafelyAllocate);
            this._data = bArrSafelyAllocate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$0() {
            return Integer.valueOf(this._sid);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$1() {
            return this._data;
        }

        @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.Duplicatable
        public UnknownSubRecord copy() {
            return this;
        }

        @Override // org.apache.poi.hssf.record.SubRecord
        public int getDataSize() {
            return this._data.length;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final int i5 = 0;
            final int i6 = 1;
            return GenericRecordUtil.getGenericProperties("sid", new Supplier(this) { // from class: org.apache.poi.hssf.record.Q0
                public final /* synthetic */ SubRecord.UnknownSubRecord b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i5) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        default:
                            return this.b.lambda$getGenericProperties$1();
                    }
                }
            }, "data", new Supplier(this) { // from class: org.apache.poi.hssf.record.Q0
                public final /* synthetic */ SubRecord.UnknownSubRecord b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i6) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        default:
                            return this.b.lambda$getGenericProperties$1();
                    }
                }
            });
        }

        @Override // org.apache.poi.hssf.record.SubRecord
        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._sid);
            littleEndianOutput.writeShort(this._data.length);
            littleEndianOutput.write(this._data);
        }

        @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
        public SubRecordTypes getGenericRecordType() {
            return SubRecordTypes.UNKNOWN;
        }
    }

    public SubRecord() {
    }

    public static SubRecord createSubRecord(LittleEndianInput littleEndianInput, int i5) {
        int uShort = littleEndianInput.readUShort();
        int uShort2 = littleEndianInput.readUShort();
        SubRecordTypes subRecordTypesForSID = SubRecordTypes.forSID(uShort);
        SubRecordTypes.RecordConstructor<?> recordConstructor = subRecordTypesForSID.recordConstructor;
        if (subRecordTypesForSID == SubRecordTypes.UNKNOWN) {
            i5 = uShort;
        }
        return recordConstructor.apply(littleEndianInput, uShort2, i5);
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    @Override // org.apache.poi.common.Duplicatable
    public abstract SubRecord copy();

    public abstract int getDataSize();

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public abstract SubRecordTypes getGenericRecordType();

    public boolean isTerminating() {
        return false;
    }

    public abstract void serialize(LittleEndianOutput littleEndianOutput);

    public byte[] serialize() {
        int dataSize = getDataSize() + 4;
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream(dataSize);
        serialize(new LittleEndianOutputStream(unsynchronizedByteArrayOutputStream));
        if (unsynchronizedByteArrayOutputStream.size() == dataSize) {
            return unsynchronizedByteArrayOutputStream.toByteArray();
        }
        throw new RuntimeException("write size mismatch");
    }

    public final String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    public SubRecord(SubRecord subRecord) {
    }
}
