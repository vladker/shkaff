package org.apache.poi.hssf.record;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ExternSheetRecord extends StandardRecord {
    public static final short sid = 23;
    private final List<RefSubRecord> _list;

    public ExternSheetRecord() {
        this._list = new ArrayList();
    }

    public static ExternSheetRecord combine(ExternSheetRecord[] externSheetRecordArr) {
        ExternSheetRecord externSheetRecord = new ExternSheetRecord();
        for (ExternSheetRecord externSheetRecord2 : externSheetRecordArr) {
            int numOfREFRecords = externSheetRecord2.getNumOfREFRecords();
            for (int i5 = 0; i5 < numOfREFRecords; i5++) {
                externSheetRecord.addREFRecord(externSheetRecord2.getRef(i5));
            }
        }
        return externSheetRecord;
    }

    private RefSubRecord getRef(int i5) {
        return this._list.get(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this._list;
    }

    public void addREFRecord(RefSubRecord refSubRecord) {
        this._list.add(refSubRecord);
    }

    public int addRef(int i5, int i6, int i7) {
        this._list.add(new RefSubRecord(i5, i6, i7));
        return this._list.size() - 1;
    }

    public int findRefIndexFromExtBookIndex(int i5) {
        int size = this._list.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (getRef(i6).getExtBookIndex() == i5) {
                return i6;
            }
        }
        return -1;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._list.size() * 6) + 2;
    }

    public int getExtbookIndexFromRefIndex(int i5) {
        return getRef(i5).getExtBookIndex();
    }

    public int getFirstSheetIndexFromRefIndex(int i5) {
        return getRef(i5).getFirstSheetIndex();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("refrec", new C1381b(this, 11));
    }

    public int getLastSheetIndexFromRefIndex(int i5) {
        return getRef(i5).getLastSheetIndex();
    }

    public int getNumOfREFRecords() {
        return this._list.size();
    }

    public int getNumOfRefs() {
        return this._list.size();
    }

    public int getRefIxForSheet(int i5, int i6, int i7) {
        int size = this._list.size();
        for (int i8 = 0; i8 < size; i8++) {
            RefSubRecord ref = getRef(i8);
            if (ref.getExtBookIndex() == i5 && ref.getFirstSheetIndex() == i6 && ref.getLastSheetIndex() == i7) {
                return i8;
            }
        }
        return -1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 23;
    }

    public void removeSheet(int i5) {
        int size = this._list.size();
        for (int i6 = 0; i6 < size; i6++) {
            RefSubRecord refSubRecord = this._list.get(i6);
            if (refSubRecord.getFirstSheetIndex() == i5 && refSubRecord.getLastSheetIndex() == i5) {
                this._list.set(i6, new RefSubRecord(refSubRecord.getExtBookIndex(), -1, -1));
            } else if (refSubRecord.getFirstSheetIndex() > i5 && refSubRecord.getLastSheetIndex() > i5) {
                this._list.set(i6, new RefSubRecord(refSubRecord.getExtBookIndex(), refSubRecord.getFirstSheetIndex() - 1, refSubRecord.getLastSheetIndex() - 1));
            }
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        int size = this._list.size();
        littleEndianOutput.writeShort(size);
        for (int i5 = 0; i5 < size; i5++) {
            getRef(i5).serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.EXTERN_SHEET;
    }

    public ExternSheetRecord(ExternSheetRecord externSheetRecord) {
        ArrayList arrayList = new ArrayList();
        this._list = arrayList;
        externSheetRecord._list.stream().map(new G(0)).forEach(new H(arrayList, 0));
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class RefSubRecord implements GenericRecord {
        public static final int ENCODED_SIZE = 6;
        private final int _extBookIndex;
        private int _firstSheetIndex;
        private int _lastSheetIndex;

        public RefSubRecord(int i5, int i6, int i7) {
            this._extBookIndex = i5;
            this._firstSheetIndex = i6;
            this._lastSheetIndex = i7;
        }

        public int getExtBookIndex() {
            return this._extBookIndex;
        }

        public int getFirstSheetIndex() {
            return this._firstSheetIndex;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final int i5 = 0;
            Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.I
                public final /* synthetic */ ExternSheetRecord.RefSubRecord b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    int extBookIndex;
                    switch (i5) {
                        case 0:
                            extBookIndex = this.b.getExtBookIndex();
                            break;
                        case 1:
                            extBookIndex = this.b.getFirstSheetIndex();
                            break;
                        default:
                            extBookIndex = this.b.getLastSheetIndex();
                            break;
                    }
                    return Integer.valueOf(extBookIndex);
                }
            };
            final int i6 = 1;
            Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.I
                public final /* synthetic */ ExternSheetRecord.RefSubRecord b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    int extBookIndex;
                    switch (i6) {
                        case 0:
                            extBookIndex = this.b.getExtBookIndex();
                            break;
                        case 1:
                            extBookIndex = this.b.getFirstSheetIndex();
                            break;
                        default:
                            extBookIndex = this.b.getLastSheetIndex();
                            break;
                    }
                    return Integer.valueOf(extBookIndex);
                }
            };
            final int i7 = 2;
            return GenericRecordUtil.getGenericProperties("extBookIndex", supplier, "firstSheetIndex", supplier2, "lastSheetIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.I
                public final /* synthetic */ ExternSheetRecord.RefSubRecord b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    int extBookIndex;
                    switch (i7) {
                        case 0:
                            extBookIndex = this.b.getExtBookIndex();
                            break;
                        case 1:
                            extBookIndex = this.b.getFirstSheetIndex();
                            break;
                        default:
                            extBookIndex = this.b.getLastSheetIndex();
                            break;
                    }
                    return Integer.valueOf(extBookIndex);
                }
            });
        }

        public int getLastSheetIndex() {
            return this._lastSheetIndex;
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._extBookIndex);
            littleEndianOutput.writeShort(this._firstSheetIndex);
            littleEndianOutput.writeShort(this._lastSheetIndex);
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }

        public RefSubRecord(RefSubRecord refSubRecord) {
            this._extBookIndex = refSubRecord._extBookIndex;
            this._firstSheetIndex = refSubRecord._firstSheetIndex;
            this._lastSheetIndex = refSubRecord._lastSheetIndex;
        }

        public RefSubRecord(RecordInputStream recordInputStream) {
            this(recordInputStream.readShort(), recordInputStream.readShort(), recordInputStream.readShort());
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ExternSheetRecord copy() {
        return new ExternSheetRecord(this);
    }

    public ExternSheetRecord(RecordInputStream recordInputStream) {
        this._list = new ArrayList();
        short s6 = recordInputStream.readShort();
        for (int i5 = 0; i5 < s6; i5++) {
            this._list.add(new RefSubRecord(recordInputStream));
        }
    }
}
