package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.hssf.record.common.FeatFormulaErr2;
import org.apache.poi.hssf.record.common.FeatProtection;
import org.apache.poi.hssf.record.common.FeatSmartTag;
import org.apache.poi.hssf.record.common.FtrHeader;
import org.apache.poi.hssf.record.common.SharedFeature;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FeatRecord extends StandardRecord {
    private static final Logger LOG = LogManager.getLogger((Class<?>) FeatRecord.class);
    public static final short sid = 2152;
    public static final short v11_sid = 2162;
    public static final short v12_sid = 2168;
    private long cbFeatData;
    private CellRangeAddress[] cellRefs;
    private final FtrHeader futureHeader;
    private int isf_sharedFeatureType;
    private byte reserved1;
    private long reserved2;
    private int reserved3;
    private SharedFeature sharedFeature;

    public FeatRecord() {
        FtrHeader ftrHeader = new FtrHeader();
        this.futureHeader = ftrHeader;
        ftrHeader.setRecordType(sid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return this.futureHeader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Byte.valueOf(this.reserved1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return Long.valueOf(this.reserved2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$4() {
        return Integer.valueOf(this.reserved3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CellRangeAddress[] lambda$new$0(int i5) {
        return new CellRangeAddress[i5];
    }

    public long getCbFeatData() {
        return this.cbFeatData;
    }

    public CellRangeAddress[] getCellRefs() {
        return this.cellRefs;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this.sharedFeature.getDataSize() + (this.cellRefs.length * 8) + 27;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.M
            public final /* synthetic */ FeatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Integer.valueOf(this.b.getIsf_sharedFeatureType());
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return Long.valueOf(this.b.getCbFeatData());
                    case 5:
                        return this.b.lambda$getGenericProperties$4();
                    case 6:
                        return this.b.getCellRefs();
                    default:
                        return this.b.getSharedFeature();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.M
            public final /* synthetic */ FeatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Integer.valueOf(this.b.getIsf_sharedFeatureType());
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return Long.valueOf(this.b.getCbFeatData());
                    case 5:
                        return this.b.lambda$getGenericProperties$4();
                    case 6:
                        return this.b.getCellRefs();
                    default:
                        return this.b.getSharedFeature();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.M
            public final /* synthetic */ FeatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Integer.valueOf(this.b.getIsf_sharedFeatureType());
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return Long.valueOf(this.b.getCbFeatData());
                    case 5:
                        return this.b.lambda$getGenericProperties$4();
                    case 6:
                        return this.b.getCellRefs();
                    default:
                        return this.b.getSharedFeature();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.M
            public final /* synthetic */ FeatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Integer.valueOf(this.b.getIsf_sharedFeatureType());
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return Long.valueOf(this.b.getCbFeatData());
                    case 5:
                        return this.b.lambda$getGenericProperties$4();
                    case 6:
                        return this.b.getCellRefs();
                    default:
                        return this.b.getSharedFeature();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.M
            public final /* synthetic */ FeatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Integer.valueOf(this.b.getIsf_sharedFeatureType());
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return Long.valueOf(this.b.getCbFeatData());
                    case 5:
                        return this.b.lambda$getGenericProperties$4();
                    case 6:
                        return this.b.getCellRefs();
                    default:
                        return this.b.getSharedFeature();
                }
            }
        };
        final int i10 = 5;
        Supplier supplier6 = new Supplier(this) { // from class: org.apache.poi.hssf.record.M
            public final /* synthetic */ FeatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Integer.valueOf(this.b.getIsf_sharedFeatureType());
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return Long.valueOf(this.b.getCbFeatData());
                    case 5:
                        return this.b.lambda$getGenericProperties$4();
                    case 6:
                        return this.b.getCellRefs();
                    default:
                        return this.b.getSharedFeature();
                }
            }
        };
        final int i11 = 6;
        final int i12 = 7;
        return GenericRecordUtil.getGenericProperties("futureHeader", supplier, "isf_sharedFeatureType", supplier2, "reserved1", supplier3, "reserved2", supplier4, "cbFeatData", supplier5, "reserved3", supplier6, "cellRefs", new Supplier(this) { // from class: org.apache.poi.hssf.record.M
            public final /* synthetic */ FeatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Integer.valueOf(this.b.getIsf_sharedFeatureType());
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return Long.valueOf(this.b.getCbFeatData());
                    case 5:
                        return this.b.lambda$getGenericProperties$4();
                    case 6:
                        return this.b.getCellRefs();
                    default:
                        return this.b.getSharedFeature();
                }
            }
        }, "sharedFeature", new Supplier(this) { // from class: org.apache.poi.hssf.record.M
            public final /* synthetic */ FeatRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return Integer.valueOf(this.b.getIsf_sharedFeatureType());
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return this.b.lambda$getGenericProperties$3();
                    case 4:
                        return Long.valueOf(this.b.getCbFeatData());
                    case 5:
                        return this.b.lambda$getGenericProperties$4();
                    case 6:
                        return this.b.getCellRefs();
                    default:
                        return this.b.getSharedFeature();
                }
            }
        });
    }

    public int getIsf_sharedFeatureType() {
        return this.isf_sharedFeatureType;
    }

    public SharedFeature getSharedFeature() {
        return this.sharedFeature;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this.futureHeader.serialize(littleEndianOutput);
        littleEndianOutput.writeShort(this.isf_sharedFeatureType);
        littleEndianOutput.writeByte(this.reserved1);
        littleEndianOutput.writeInt((int) this.reserved2);
        littleEndianOutput.writeShort(this.cellRefs.length);
        littleEndianOutput.writeInt((int) this.cbFeatData);
        littleEndianOutput.writeShort(this.reserved3);
        for (CellRangeAddress cellRangeAddress : this.cellRefs) {
            cellRangeAddress.serialize(littleEndianOutput);
        }
        this.sharedFeature.serialize(littleEndianOutput);
    }

    public void setCbFeatData(long j6) {
        this.cbFeatData = j6;
    }

    public void setCellRefs(CellRangeAddress[] cellRangeAddressArr) {
        this.cellRefs = cellRangeAddressArr;
    }

    public void setSharedFeature(SharedFeature sharedFeature) {
        this.sharedFeature = sharedFeature;
        if (sharedFeature instanceof FeatProtection) {
            this.isf_sharedFeatureType = 2;
        }
        if (sharedFeature instanceof FeatFormulaErr2) {
            this.isf_sharedFeatureType = 3;
        }
        if (sharedFeature instanceof FeatSmartTag) {
            this.isf_sharedFeatureType = 4;
        }
        if (this.isf_sharedFeatureType == 3) {
            this.cbFeatData = sharedFeature.getDataSize();
        } else {
            this.cbFeatData = 0L;
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FEAT;
    }

    public FeatRecord(FeatRecord featRecord) {
        super(featRecord);
        this.futureHeader = featRecord.futureHeader.copy();
        this.isf_sharedFeatureType = featRecord.isf_sharedFeatureType;
        this.reserved1 = featRecord.reserved1;
        this.reserved2 = featRecord.reserved2;
        this.cbFeatData = featRecord.cbFeatData;
        this.reserved3 = featRecord.reserved3;
        CellRangeAddress[] cellRangeAddressArr = featRecord.cellRefs;
        this.cellRefs = cellRangeAddressArr == null ? null : (CellRangeAddress[]) Stream.of((Object[]) cellRangeAddressArr).map(new G(3)).toArray(new C1434x0(2));
        SharedFeature sharedFeature = featRecord.sharedFeature;
        this.sharedFeature = sharedFeature != null ? sharedFeature.copy() : null;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public FeatRecord copy() {
        return new FeatRecord(this);
    }

    public FeatRecord(RecordInputStream recordInputStream) {
        this.futureHeader = new FtrHeader(recordInputStream);
        this.isf_sharedFeatureType = recordInputStream.readShort();
        this.reserved1 = recordInputStream.readByte();
        this.reserved2 = recordInputStream.readInt();
        int uShort = recordInputStream.readUShort();
        this.cbFeatData = recordInputStream.readInt();
        this.reserved3 = recordInputStream.readShort();
        this.cellRefs = new CellRangeAddress[uShort];
        int i5 = 0;
        while (true) {
            CellRangeAddress[] cellRangeAddressArr = this.cellRefs;
            if (i5 >= cellRangeAddressArr.length) {
                break;
            }
            cellRangeAddressArr[i5] = new CellRangeAddress(recordInputStream);
            i5++;
        }
        int i6 = this.isf_sharedFeatureType;
        if (i6 == 2) {
            this.sharedFeature = new FeatProtection(recordInputStream);
            return;
        }
        if (i6 == 3) {
            this.sharedFeature = new FeatFormulaErr2(recordInputStream);
        } else if (i6 != 4) {
            LOG.atError().log("Unknown Shared Feature {} found!", Unbox.box(this.isf_sharedFeatureType));
        } else {
            this.sharedFeature = new FeatSmartTag(recordInputStream);
        }
    }
}
