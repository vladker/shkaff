package org.apache.poi.hssf.record;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ExtSSTRecord extends ContinuableRecord {
    public static final int DEFAULT_BUCKET_SIZE = 8;
    public static final int MAX_BUCKETS = 128;
    public static final short sid = 255;
    private InfoSubRecord[] _sstInfos;
    private short _stringsPerBucket;

    public ExtSSTRecord() {
        this._stringsPerBucket = (short) 8;
        this._sstInfos = new InfoSubRecord[0];
    }

    public static int getNumberOfInfoRecsForStrings(int i5) {
        int i6 = i5 / 8;
        if (i5 % 8 != 0) {
            i6++;
        }
        if (i6 > 128) {
            return 128;
        }
        return i6;
    }

    public static int getRecordSizeForStrings(int i5) {
        return (getNumberOfInfoRecsForStrings(i5) * 8) + 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InfoSubRecord[] lambda$new$0(int i5) {
        return new InfoSubRecord[i5];
    }

    public int getDataSize() {
        return (this._sstInfos.length * 8) + 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("dataSize", new Supplier(this) { // from class: org.apache.poi.hssf.record.D
            public final /* synthetic */ ExtSSTRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    default:
                        return this.b.getInfoSubRecords();
                }
            }
        }, "infoSubRecords", new Supplier(this) { // from class: org.apache.poi.hssf.record.D
            public final /* synthetic */ ExtSSTRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    default:
                        return this.b.getInfoSubRecords();
                }
            }
        });
    }

    public InfoSubRecord[] getInfoSubRecords() {
        return this._sstInfos;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 255;
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    public void serialize(ContinuableRecordOutput continuableRecordOutput) {
        continuableRecordOutput.writeShort(this._stringsPerBucket);
        for (InfoSubRecord infoSubRecord : this._sstInfos) {
            infoSubRecord.serialize(continuableRecordOutput);
        }
    }

    public void setBucketOffsets(int[] iArr, int[] iArr2) {
        this._sstInfos = new InfoSubRecord[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            this._sstInfos[i5] = new InfoSubRecord(iArr[i5], iArr2[i5]);
        }
    }

    public void setNumStringsPerBucket(short s6) {
        this._stringsPerBucket = s6;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.EXT_SST;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class InfoSubRecord implements GenericRecord {
        public static final int ENCODED_SIZE = 8;
        private int field_1_stream_pos;
        private int field_2_bucket_sst_offset;
        private short field_3_zero;

        public InfoSubRecord(int i5, int i6) {
            this.field_1_stream_pos = i5;
            this.field_2_bucket_sst_offset = i6;
        }

        public int getBucketSSTOffset() {
            return this.field_2_bucket_sst_offset;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final int i5 = 0;
            final int i6 = 1;
            return GenericRecordUtil.getGenericProperties("streamPos", new Supplier(this) { // from class: org.apache.poi.hssf.record.E
                public final /* synthetic */ ExtSSTRecord.InfoSubRecord b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    int streamPos;
                    switch (i5) {
                        case 0:
                            streamPos = this.b.getStreamPos();
                            break;
                        default:
                            streamPos = this.b.getBucketSSTOffset();
                            break;
                    }
                    return Integer.valueOf(streamPos);
                }
            }, "bucketSSTOffset", new Supplier(this) { // from class: org.apache.poi.hssf.record.E
                public final /* synthetic */ ExtSSTRecord.InfoSubRecord b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    int streamPos;
                    switch (i6) {
                        case 0:
                            streamPos = this.b.getStreamPos();
                            break;
                        default:
                            streamPos = this.b.getBucketSSTOffset();
                            break;
                    }
                    return Integer.valueOf(streamPos);
                }
            });
        }

        public int getStreamPos() {
            return this.field_1_stream_pos;
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeInt(this.field_1_stream_pos);
            littleEndianOutput.writeShort(this.field_2_bucket_sst_offset);
            littleEndianOutput.writeShort(this.field_3_zero);
        }

        public InfoSubRecord(InfoSubRecord infoSubRecord) {
            this.field_1_stream_pos = infoSubRecord.field_1_stream_pos;
            this.field_2_bucket_sst_offset = infoSubRecord.field_2_bucket_sst_offset;
            this.field_3_zero = infoSubRecord.field_3_zero;
        }

        public InfoSubRecord(RecordInputStream recordInputStream) {
            this.field_1_stream_pos = recordInputStream.readInt();
            this.field_2_bucket_sst_offset = recordInputStream.readShort();
            this.field_3_zero = recordInputStream.readShort();
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ExtSSTRecord copy() {
        return new ExtSSTRecord(this);
    }

    public ExtSSTRecord(ExtSSTRecord extSSTRecord) {
        this._stringsPerBucket = extSSTRecord._stringsPerBucket;
        InfoSubRecord[] infoSubRecordArr = extSSTRecord._sstInfos;
        this._sstInfos = infoSubRecordArr == null ? null : (InfoSubRecord[]) Stream.of((Object[]) infoSubRecordArr).map(new G(2)).toArray(new C1434x0(1));
    }

    public ExtSSTRecord(RecordInputStream recordInputStream) {
        this._stringsPerBucket = recordInputStream.readShort();
        ArrayList arrayList = new ArrayList(recordInputStream.remaining() / 8);
        while (recordInputStream.available() > 0) {
            arrayList.add(new InfoSubRecord(recordInputStream));
            if (recordInputStream.available() == 0 && recordInputStream.hasNextRecord() && recordInputStream.getNextSid() == 60) {
                recordInputStream.nextRecord();
            }
        }
        this._sstInfos = (InfoSubRecord[]) arrayList.toArray(new InfoSubRecord[0]);
    }
}
