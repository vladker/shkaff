package org.apache.poi.hssf.record.common;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FtrHeader implements Duplicatable, GenericRecord {
    private CellRangeAddress associatedRange;
    private short grbitFrt;
    private short recordType;

    public FtrHeader() {
        this.associatedRange = new CellRangeAddress(0, 0, 0, 0);
    }

    public static int getDataSize() {
        return 12;
    }

    public CellRangeAddress getAssociatedRange() {
        return this.associatedRange;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.e
            public final /* synthetic */ FtrHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.b.getRecordType());
                    case 1:
                        return Short.valueOf(this.b.getGrbitFrt());
                    default:
                        return this.b.getAssociatedRange();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.common.e
            public final /* synthetic */ FtrHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.b.getRecordType());
                    case 1:
                        return Short.valueOf(this.b.getGrbitFrt());
                    default:
                        return this.b.getAssociatedRange();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("recordType", supplier, "grbitFrt", supplier2, "associatedRange", new Supplier(this) { // from class: org.apache.poi.hssf.record.common.e
            public final /* synthetic */ FtrHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.b.getRecordType());
                    case 1:
                        return Short.valueOf(this.b.getGrbitFrt());
                    default:
                        return this.b.getAssociatedRange();
                }
            }
        });
    }

    public short getGrbitFrt() {
        return this.grbitFrt;
    }

    public short getRecordType() {
        return this.recordType;
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.recordType);
        littleEndianOutput.writeShort(this.grbitFrt);
        this.associatedRange.serialize(littleEndianOutput);
    }

    public void setAssociatedRange(CellRangeAddress cellRangeAddress) {
        this.associatedRange = cellRangeAddress;
    }

    public void setGrbitFrt(short s6) {
        this.grbitFrt = s6;
    }

    public void setRecordType(short s6) {
        this.recordType = s6;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.common.Duplicatable
    public FtrHeader copy() {
        return new FtrHeader(this);
    }

    public FtrHeader(FtrHeader ftrHeader) {
        this.recordType = ftrHeader.recordType;
        this.grbitFrt = ftrHeader.grbitFrt;
        this.associatedRange = ftrHeader.associatedRange.copy();
    }

    public FtrHeader(RecordInputStream recordInputStream) {
        this.recordType = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        this.associatedRange = new CellRangeAddress(recordInputStream);
    }
}
