package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.util.RKUtil;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class MulRKRecord extends StandardRecord {
    public static final short sid = 189;
    private final int field_1_row;
    private final short field_2_first_col;
    private final RkRec[] field_3_rks;
    private final short field_4_last_col;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class RkRec implements GenericRecord {
        public static final int ENCODED_SIZE = 6;
        public final int rk;
        public final short xf;

        private RkRec(RecordInputStream recordInputStream) {
            this.xf = recordInputStream.readShort();
            this.rk = recordInputStream.readInt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$0() {
            return Short.valueOf(this.xf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$1() {
            return Integer.valueOf(this.rk);
        }

        public static RkRec[] parseRKs(RecordInputStream recordInputStream) {
            int iRemaining = (recordInputStream.remaining() - 2) / 6;
            RkRec[] rkRecArr = new RkRec[iRemaining];
            for (int i5 = 0; i5 < iRemaining; i5++) {
                rkRecArr[i5] = new RkRec(recordInputStream);
            }
            return rkRecArr;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final int i5 = 0;
            final int i6 = 1;
            return GenericRecordUtil.getGenericProperties("xf", new Supplier(this) { // from class: org.apache.poi.hssf.record.l0
                public final /* synthetic */ MulRKRecord.RkRec b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i5) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        default:
                            return this.b.lambda$getGenericProperties$1();
                    }
                }
            }, "rk", new Supplier(this) { // from class: org.apache.poi.hssf.record.l0
                public final /* synthetic */ MulRKRecord.RkRec b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i6) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        default:
                            return this.b.lambda$getGenericProperties$1();
                    }
                }
            });
        }
    }

    public MulRKRecord(RecordInputStream recordInputStream) {
        this.field_1_row = recordInputStream.readUShort();
        this.field_2_first_col = recordInputStream.readShort();
        this.field_3_rks = RkRec.parseRKs(recordInputStream);
        this.field_4_last_col = recordInputStream.readShort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this.field_3_rks;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public MulRKRecord copy() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        throw new RecordFormatException("Sorry, you can't serialize MulRK in this release");
    }

    public short getFirstColumn() {
        return this.field_2_first_col;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.k0
            public final /* synthetic */ MulRKRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getFirstColumn());
                    case 2:
                        return Short.valueOf(this.b.getLastColumn());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.k0
            public final /* synthetic */ MulRKRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getFirstColumn());
                    case 2:
                        return Short.valueOf(this.b.getLastColumn());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.k0
            public final /* synthetic */ MulRKRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getFirstColumn());
                    case 2:
                        return Short.valueOf(this.b.getLastColumn());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("row", supplier, "firstColumn", supplier2, "lastColumn", supplier3, "rk", new Supplier(this) { // from class: org.apache.poi.hssf.record.k0
            public final /* synthetic */ MulRKRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getRow());
                    case 1:
                        return Short.valueOf(this.b.getFirstColumn());
                    case 2:
                        return Short.valueOf(this.b.getLastColumn());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        });
    }

    public short getLastColumn() {
        return this.field_4_last_col;
    }

    public int getNumColumns() {
        return (this.field_4_last_col - this.field_2_first_col) + 1;
    }

    public double getRKNumberAt(int i5) {
        return RKUtil.decodeNumber(this.field_3_rks[i5].rk);
    }

    public int getRow() {
        return this.field_1_row;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 189;
    }

    public short getXFAt(int i5) {
        return this.field_3_rks[i5].xf;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        throw new RecordFormatException("Sorry, you can't serialize MulRK in this release");
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.MUL_RK;
    }
}
