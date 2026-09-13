package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DrawingSelectionRecord extends StandardRecord {
    public static final short sid = 237;
    private int _cpsp;
    private int _dgslk;
    private OfficeArtRecordHeader _header;
    private int[] _shapeIds;
    private int _spidFocus;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class OfficeArtRecordHeader implements GenericRecord {
        public static final int ENCODED_SIZE = 8;
        private final int _length;
        private final int _type;
        private final int _verAndInstance;

        public OfficeArtRecordHeader(LittleEndianInput littleEndianInput) {
            this._verAndInstance = littleEndianInput.readUShort();
            this._type = littleEndianInput.readUShort();
            this._length = littleEndianInput.readInt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$0() {
            return Integer.valueOf(this._verAndInstance);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$1() {
            return Integer.valueOf(this._type);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$2() {
            return Integer.valueOf(this._length);
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final int i5 = 0;
            Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.A
                public final /* synthetic */ DrawingSelectionRecord.OfficeArtRecordHeader b;

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
            Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.A
                public final /* synthetic */ DrawingSelectionRecord.OfficeArtRecordHeader b;

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
            return GenericRecordUtil.getGenericProperties("verAndInstance", supplier, "type", supplier2, "length", new Supplier(this) { // from class: org.apache.poi.hssf.record.A
                public final /* synthetic */ DrawingSelectionRecord.OfficeArtRecordHeader b;

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

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._verAndInstance);
            littleEndianOutput.writeShort(this._type);
            littleEndianOutput.writeInt(this._length);
        }
    }

    public DrawingSelectionRecord(RecordInputStream recordInputStream) {
        this._header = new OfficeArtRecordHeader(recordInputStream);
        this._cpsp = recordInputStream.readInt();
        this._dgslk = recordInputStream.readInt();
        this._spidFocus = recordInputStream.readInt();
        int iAvailable = recordInputStream.available() / 4;
        int[] iArr = new int[iAvailable];
        for (int i5 = 0; i5 < iAvailable; i5++) {
            iArr[i5] = recordInputStream.readInt();
        }
        this._shapeIds = iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this._header;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this._cpsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Integer.valueOf(this._dgslk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return Integer.valueOf(this._spidFocus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$4() {
        return this._shapeIds;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public DrawingSelectionRecord copy() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._shapeIds.length * 4) + 20;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.z
            public final /* synthetic */ DrawingSelectionRecord b;

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
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.z
            public final /* synthetic */ DrawingSelectionRecord b;

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
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.z
            public final /* synthetic */ DrawingSelectionRecord b;

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
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.z
            public final /* synthetic */ DrawingSelectionRecord b;

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
        return GenericRecordUtil.getGenericProperties("rh", supplier, "cpsp", supplier2, "dgslk", supplier3, "spidFocus", supplier4, "shapeIds", new Supplier(this) { // from class: org.apache.poi.hssf.record.z
            public final /* synthetic */ DrawingSelectionRecord b;

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
        this._header.serialize(littleEndianOutput);
        littleEndianOutput.writeInt(this._cpsp);
        littleEndianOutput.writeInt(this._dgslk);
        littleEndianOutput.writeInt(this._spidFocus);
        for (int i5 : this._shapeIds) {
            littleEndianOutput.writeInt(i5);
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DRAWING_SELECTION;
    }
}
