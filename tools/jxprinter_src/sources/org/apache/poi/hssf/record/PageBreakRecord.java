package org.apache.poi.hssf.record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class PageBreakRecord extends StandardRecord {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private final Map<Integer, Break> _breakMap;
    private final ArrayList<Break> _breaks;

    public PageBreakRecord() {
        this._breaks = new ArrayList<>();
        this._breakMap = new HashMap();
    }

    private void initMap() {
        this._breaks.forEach(new H(this, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return this._breaks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMap$0(Break r6) {
        this._breakMap.put(Integer.valueOf(r6.main), r6);
    }

    public void addBreak(int i5, int i6, int i7) {
        Integer numValueOf = Integer.valueOf(i5);
        Break r6 = this._breakMap.get(numValueOf);
        if (r6 == null) {
            Break r7 = new Break(i5, i6, i7);
            this._breakMap.put(numValueOf, r7);
            this._breaks.add(r7);
        } else {
            r6.main = i5;
            r6.subFrom = i6;
            r6.subTo = i7;
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public abstract PageBreakRecord copy();

    public final Break getBreak(int i5) {
        return this._breakMap.get(Integer.valueOf(i5));
    }

    public final int[] getBreaks() {
        int numBreaks = getNumBreaks();
        if (numBreaks < 1) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numBreaks];
        for (int i5 = 0; i5 < numBreaks; i5++) {
            iArr[i5] = this._breaks.get(i5).main;
        }
        return iArr;
    }

    public final Iterator<Break> getBreaksIterator() {
        return this._breaks.iterator();
    }

    public final Spliterator<Break> getBreaksSpliterator() {
        return this._breaks.spliterator();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._breaks.size() * 6) + 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("numBreaks", new Supplier(this) { // from class: org.apache.poi.hssf.record.v0
            public final /* synthetic */ PageBreakRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getNumBreaks());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        }, "breaks", new Supplier(this) { // from class: org.apache.poi.hssf.record.v0
            public final /* synthetic */ PageBreakRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getNumBreaks());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    public int getNumBreaks() {
        return this._breaks.size();
    }

    public boolean isEmpty() {
        return this._breaks.isEmpty();
    }

    public final void removeBreak(int i5) {
        Integer numValueOf = Integer.valueOf(i5);
        this._breaks.remove(this._breakMap.get(numValueOf));
        this._breakMap.remove(numValueOf);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._breaks.size());
        ArrayList<Break> arrayList = this._breaks;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Break r6 = arrayList.get(i5);
            i5++;
            r6.serialize(littleEndianOutput);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Break implements GenericRecord {
        public static final int ENCODED_SIZE = 6;
        private int main;
        private int subFrom;
        private int subTo;

        public Break(Break r6) {
            this.main = r6.main;
            this.subFrom = r6.subFrom;
            this.subTo = r6.subTo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$0() {
            return Integer.valueOf(this.main);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$1() {
            return Integer.valueOf(this.subFrom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$2() {
            return Integer.valueOf(this.subTo);
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final int i5 = 0;
            Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.w0
                public final /* synthetic */ PageBreakRecord.Break b;

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
            Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.w0
                public final /* synthetic */ PageBreakRecord.Break b;

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
            return GenericRecordUtil.getGenericProperties("main", supplier, "subFrom", supplier2, "subTo", new Supplier(this) { // from class: org.apache.poi.hssf.record.w0
                public final /* synthetic */ PageBreakRecord.Break b;

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

        public int getMain() {
            return this.main;
        }

        public int getSubFrom() {
            return this.subFrom;
        }

        public int getSubTo() {
            return this.subTo;
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this.main + 1);
            littleEndianOutput.writeShort(this.subFrom);
            littleEndianOutput.writeShort(this.subTo);
        }

        public Break(int i5, int i6, int i7) {
            this.main = i5;
            this.subFrom = i6;
            this.subTo = i7;
        }

        public Break(RecordInputStream recordInputStream) {
            this.main = recordInputStream.readUShort() - 1;
            this.subFrom = recordInputStream.readUShort();
            this.subTo = recordInputStream.readUShort();
        }
    }

    public PageBreakRecord(PageBreakRecord pageBreakRecord) {
        ArrayList<Break> arrayList = new ArrayList<>();
        this._breaks = arrayList;
        this._breakMap = new HashMap();
        arrayList.addAll(pageBreakRecord._breaks);
        initMap();
    }

    public PageBreakRecord(RecordInputStream recordInputStream) {
        ArrayList<Break> arrayList = new ArrayList<>();
        this._breaks = arrayList;
        this._breakMap = new HashMap();
        short s6 = recordInputStream.readShort();
        arrayList.ensureCapacity(s6 + 2);
        for (int i5 = 0; i5 < s6; i5++) {
            this._breaks.add(new Break(recordInputStream));
        }
        initMap();
    }
}
