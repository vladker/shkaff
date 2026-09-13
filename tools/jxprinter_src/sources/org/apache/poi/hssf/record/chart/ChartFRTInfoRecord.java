package org.apache.poi.hssf.record.chart;

import A3.AbstractC0157z;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ChartFRTInfoRecord extends StandardRecord {
    public static final short sid = 2128;
    private final short grbitFrt;
    private CFRTID[] rgCFRTID;
    private final short rt;
    private final byte verOriginator;
    private final byte verWriter;

    public ChartFRTInfoRecord(ChartFRTInfoRecord chartFRTInfoRecord) {
        super(chartFRTInfoRecord);
        this.rt = chartFRTInfoRecord.rt;
        this.grbitFrt = chartFRTInfoRecord.grbitFrt;
        this.verOriginator = chartFRTInfoRecord.verOriginator;
        this.verWriter = chartFRTInfoRecord.verWriter;
        CFRTID[] cfrtidArr = chartFRTInfoRecord.rgCFRTID;
        if (cfrtidArr != null) {
            this.rgCFRTID = (CFRTID[]) Stream.of((Object[]) cfrtidArr).map(new l(0)).toArray(new m(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Short.valueOf(this.rt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Short.valueOf(this.grbitFrt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return Byte.valueOf(this.verOriginator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$4() {
        return Byte.valueOf(this.verWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$5() {
        return this.rgCFRTID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CFRTID[] lambda$new$0(int i5) {
        return new CFRTID[i5];
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this.rgCFRTID.length * 4) + 8;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.n
            public final /* synthetic */ ChartFRTInfoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return this.b.lambda$getGenericProperties$2();
                    case 2:
                        return this.b.lambda$getGenericProperties$3();
                    case 3:
                        return this.b.lambda$getGenericProperties$4();
                    default:
                        return this.b.lambda$getGenericProperties$5();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.n
            public final /* synthetic */ ChartFRTInfoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return this.b.lambda$getGenericProperties$2();
                    case 2:
                        return this.b.lambda$getGenericProperties$3();
                    case 3:
                        return this.b.lambda$getGenericProperties$4();
                    default:
                        return this.b.lambda$getGenericProperties$5();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.n
            public final /* synthetic */ ChartFRTInfoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return this.b.lambda$getGenericProperties$2();
                    case 2:
                        return this.b.lambda$getGenericProperties$3();
                    case 3:
                        return this.b.lambda$getGenericProperties$4();
                    default:
                        return this.b.lambda$getGenericProperties$5();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.n
            public final /* synthetic */ ChartFRTInfoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return this.b.lambda$getGenericProperties$2();
                    case 2:
                        return this.b.lambda$getGenericProperties$3();
                    case 3:
                        return this.b.lambda$getGenericProperties$4();
                    default:
                        return this.b.lambda$getGenericProperties$5();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("rt", supplier, "grbitFrt", supplier2, "verOriginator", supplier3, "verWriter", supplier4, "rgCFRTIDs", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.n
            public final /* synthetic */ ChartFRTInfoRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    case 1:
                        return this.b.lambda$getGenericProperties$2();
                    case 2:
                        return this.b.lambda$getGenericProperties$3();
                    case 3:
                        return this.b.lambda$getGenericProperties$4();
                    default:
                        return this.b.lambda$getGenericProperties$5();
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
        littleEndianOutput.writeShort(this.rt);
        littleEndianOutput.writeShort(this.grbitFrt);
        littleEndianOutput.writeByte(this.verOriginator);
        littleEndianOutput.writeByte(this.verWriter);
        littleEndianOutput.writeShort(this.rgCFRTID.length);
        for (CFRTID cfrtid : this.rgCFRTID) {
            cfrtid.serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART_FRT_INFO;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CFRTID {
        public static final int ENCODED_SIZE = 4;
        private final int rtFirst;
        private final int rtLast;

        public CFRTID(CFRTID cfrtid) {
            this.rtFirst = cfrtid.rtFirst;
            this.rtLast = cfrtid.rtLast;
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this.rtFirst);
            littleEndianOutput.writeShort(this.rtLast);
        }

        public CFRTID(LittleEndianInput littleEndianInput) {
            this.rtFirst = littleEndianInput.readShort();
            this.rtLast = littleEndianInput.readShort();
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ChartFRTInfoRecord copy() {
        return new ChartFRTInfoRecord(this);
    }

    public ChartFRTInfoRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        this.verOriginator = recordInputStream.readByte();
        this.verWriter = recordInputStream.readByte();
        int i5 = recordInputStream.readShort();
        if (i5 >= 0) {
            this.rgCFRTID = new CFRTID[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                this.rgCFRTID[i6] = new CFRTID(recordInputStream);
            }
            return;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Had negative CFRTID: "));
    }
}
