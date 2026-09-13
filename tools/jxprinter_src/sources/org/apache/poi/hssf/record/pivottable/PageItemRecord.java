package org.apache.poi.hssf.record.pivottable;

import A3.AbstractC0157z;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PageItemRecord extends StandardRecord {
    public static final short sid = 182;
    private final FieldInfo[] _fieldInfos;

    public PageItemRecord(PageItemRecord pageItemRecord) {
        super(pageItemRecord);
        this._fieldInfos = (FieldInfo[]) Stream.of((Object[]) pageItemRecord._fieldInfos).map(new d()).toArray(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return this._fieldInfos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FieldInfo[] lambda$new$0(int i5) {
        return new FieldInfo[i5];
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this._fieldInfos.length * 6;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("fieldInfos", new c(this, 0));
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 182;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        for (FieldInfo fieldInfo : this._fieldInfos) {
            fieldInfo.serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PAGE_ITEM;
    }

    public PageItemRecord(RecordInputStream recordInputStream) {
        int iRemaining = recordInputStream.remaining();
        if (iRemaining % 6 == 0) {
            int i5 = iRemaining / 6;
            FieldInfo[] fieldInfoArr = new FieldInfo[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                fieldInfoArr[i6] = new FieldInfo(recordInputStream);
            }
            this._fieldInfos = fieldInfoArr;
            return;
        }
        throw new RecordFormatException(AbstractC0157z.k(iRemaining, "Bad data size "));
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class FieldInfo implements GenericRecord {
        public static final int ENCODED_SIZE = 6;
        private int _idObj;
        private int _isxvd;
        private int _isxvi;

        public FieldInfo(FieldInfo fieldInfo) {
            this._isxvi = fieldInfo._isxvi;
            this._isxvd = fieldInfo._isxvd;
            this._idObj = fieldInfo._idObj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$0() {
            return Integer.valueOf(this._isxvi);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$1() {
            return Integer.valueOf(this._isxvd);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$2() {
            return Integer.valueOf(this._idObj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._isxvi);
            littleEndianOutput.writeShort(this._isxvd);
            littleEndianOutput.writeShort(this._idObj);
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final int i5 = 0;
            Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.f
                public final /* synthetic */ PageItemRecord.FieldInfo b;

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
                        default:
                            return this.b.lambda$getGenericProperties$2();
                    }
                }
            };
            final int i6 = 1;
            Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.f
                public final /* synthetic */ PageItemRecord.FieldInfo b;

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
                        default:
                            return this.b.lambda$getGenericProperties$2();
                    }
                }
            };
            final int i7 = 2;
            return GenericRecordUtil.getGenericProperties("isxvi", supplier, "isxvd", supplier2, "idObj", new Supplier(this) { // from class: org.apache.poi.hssf.record.pivottable.f
                public final /* synthetic */ PageItemRecord.FieldInfo b;

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
                        default:
                            return this.b.lambda$getGenericProperties$2();
                    }
                }
            });
        }

        public FieldInfo(RecordInputStream recordInputStream) {
            this._isxvi = recordInputStream.readShort();
            this._isxvd = recordInputStream.readShort();
            this._idObj = recordInputStream.readShort();
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public PageItemRecord copy() {
        return new PageItemRecord(this);
    }
}
