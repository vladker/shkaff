package org.apache.poi.hssf.eventusermodel.dummyrecord;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class LastCellOfRowDummyRecord extends DummyRecordBase {
    private final int lastColumnNumber;
    private final int row;

    public LastCellOfRowDummyRecord(int i5, int i6) {
        this.row = i5;
        this.lastColumnNumber = i6;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public LastCellOfRowDummyRecord copy() {
        return this;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("row", new Supplier(this) { // from class: org.apache.poi.hssf.eventusermodel.dummyrecord.a
            public final /* synthetic */ LastCellOfRowDummyRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int row;
                switch (i5) {
                    case 0:
                        row = this.b.getRow();
                        break;
                    default:
                        row = this.b.getLastColumnNumber();
                        break;
                }
                return Integer.valueOf(row);
            }
        }, "lastColumnNumber", new Supplier(this) { // from class: org.apache.poi.hssf.eventusermodel.dummyrecord.a
            public final /* synthetic */ LastCellOfRowDummyRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int row;
                switch (i6) {
                    case 0:
                        row = this.b.getRow();
                        break;
                    default:
                        row = this.b.getLastColumnNumber();
                        break;
                }
                return Integer.valueOf(row);
            }
        });
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return null;
    }

    public int getLastColumnNumber() {
        return this.lastColumnNumber;
    }

    public int getRow() {
        return this.row;
    }

    @Override // org.apache.poi.hssf.eventusermodel.dummyrecord.DummyRecordBase, org.apache.poi.hssf.record.RecordBase
    public /* bridge */ /* synthetic */ int serialize(int i5, byte[] bArr) {
        return super.serialize(i5, bArr);
    }
}
