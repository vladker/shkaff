package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.common.FtrHeader;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FeatHdrRecord extends StandardRecord {
    public static final int SHAREDFEATURES_ISFFACTOID = 4;
    public static final int SHAREDFEATURES_ISFFEC2 = 3;
    public static final int SHAREDFEATURES_ISFLIST = 5;
    public static final int SHAREDFEATURES_ISFPROTECTION = 2;
    public static final short sid = 2151;
    private long cbHdrData;
    private final FtrHeader futureHeader;
    private int isf_sharedFeatureType;
    private byte reserved;
    private byte[] rgbHdrData;

    public FeatHdrRecord() {
        FtrHeader ftrHeader = new FtrHeader();
        this.futureHeader = ftrHeader;
        ftrHeader.setRecordType(sid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this.futureHeader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this.isf_sharedFeatureType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Byte.valueOf(this.reserved);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return Long.valueOf(this.cbHdrData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$4() {
        return this.rgbHdrData;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this.rgbHdrData.length + 19;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.L
            public final /* synthetic */ FeatHdrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.L
            public final /* synthetic */ FeatHdrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.L
            public final /* synthetic */ FeatHdrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.L
            public final /* synthetic */ FeatHdrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("futureHeader", supplier, "isf_sharedFeatureType", supplier2, "reserved", supplier3, "cbHdrData", supplier4, "rgbHdrData", new Supplier(this) { // from class: org.apache.poi.hssf.record.L
            public final /* synthetic */ FeatHdrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    default:
                        return this.b.lambda$getGenericProperties$4();
                }
            }
        });
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this.futureHeader.serialize(littleEndianOutput);
        littleEndianOutput.writeShort(this.isf_sharedFeatureType);
        littleEndianOutput.writeByte(this.reserved);
        littleEndianOutput.writeInt((int) this.cbHdrData);
        littleEndianOutput.write(this.rgbHdrData);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FEAT_HDR;
    }

    public FeatHdrRecord(FeatHdrRecord featHdrRecord) {
        super(featHdrRecord);
        this.futureHeader = featHdrRecord.futureHeader.copy();
        this.isf_sharedFeatureType = featHdrRecord.isf_sharedFeatureType;
        this.reserved = featHdrRecord.reserved;
        this.cbHdrData = featHdrRecord.cbHdrData;
        byte[] bArr = featHdrRecord.rgbHdrData;
        this.rgbHdrData = bArr == null ? null : (byte[]) bArr.clone();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public FeatHdrRecord copy() {
        return new FeatHdrRecord(this);
    }

    public FeatHdrRecord(RecordInputStream recordInputStream) {
        this.futureHeader = new FtrHeader(recordInputStream);
        this.isf_sharedFeatureType = recordInputStream.readShort();
        this.reserved = recordInputStream.readByte();
        this.cbHdrData = recordInputStream.readInt();
        this.rgbHdrData = recordInputStream.readRemainder();
    }
}
