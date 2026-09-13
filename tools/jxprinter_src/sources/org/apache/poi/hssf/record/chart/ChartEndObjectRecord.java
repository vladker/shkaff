package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ChartEndObjectRecord extends StandardRecord {
    public static final short sid = 2133;
    private short grbitFrt;
    private short iObjectKind;
    private byte[] reserved;
    private short rt;

    public ChartEndObjectRecord(ChartEndObjectRecord chartEndObjectRecord) {
        super(chartEndObjectRecord);
        this.rt = chartEndObjectRecord.rt;
        this.grbitFrt = chartEndObjectRecord.grbitFrt;
        this.iObjectKind = chartEndObjectRecord.iObjectKind;
        byte[] bArr = chartEndObjectRecord.reserved;
        this.reserved = bArr == null ? null : (byte[]) bArr.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Short.valueOf(this.rt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Short.valueOf(this.grbitFrt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Short.valueOf(this.iObjectKind);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return this.reserved;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.k
            public final /* synthetic */ ChartEndObjectRecord b;

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
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.k
            public final /* synthetic */ ChartEndObjectRecord b;

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
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.k
            public final /* synthetic */ ChartEndObjectRecord b;

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
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("rt", supplier, "grbitFrt", supplier2, "iObjectKind", supplier3, "reserved", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.k
            public final /* synthetic */ ChartEndObjectRecord b;

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
                    default:
                        return this.b.lambda$getGenericProperties$3();
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
        littleEndianOutput.writeShort(this.iObjectKind);
        littleEndianOutput.write(this.reserved);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART_END_OBJECT;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ChartEndObjectRecord copy() {
        return new ChartEndObjectRecord(this);
    }

    public ChartEndObjectRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        this.iObjectKind = recordInputStream.readShort();
        this.reserved = new byte[6];
        if (recordInputStream.available() == 0) {
            return;
        }
        recordInputStream.readFully(this.reserved);
    }
}
