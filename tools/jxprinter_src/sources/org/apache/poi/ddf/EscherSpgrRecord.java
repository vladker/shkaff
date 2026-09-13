package org.apache.poi.ddf;

import A3.AbstractC0157z;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherSpgrRecord extends EscherRecord {
    public static final short RECORD_ID = EscherRecordTypes.SPGR.typeID;
    private int field_1_rectX1;
    private int field_2_rectY1;
    private int field_3_rectX2;
    private int field_4_rectY2;

    public EscherSpgrRecord() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i5);
        this.field_1_rectX1 = LittleEndian.getInt(bArr, i5 + 8);
        this.field_2_rectY1 = LittleEndian.getInt(bArr, i5 + 12);
        this.field_3_rectX2 = LittleEndian.getInt(bArr, i5 + 16);
        this.field_4_rectY2 = LittleEndian.getInt(bArr, i5 + 20);
        int i6 = header - 16;
        if (i6 == 0) {
            return header + 8;
        }
        throw new RecordFormatException(AbstractC0157z.k(i6, "Expected no remaining bytes but got "));
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ddf.w
            public final /* synthetic */ EscherSpgrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getRectX1());
                    case 2:
                        return Integer.valueOf(this.b.getRectY1());
                    case 3:
                        return Integer.valueOf(this.b.getRectX2());
                    default:
                        return Integer.valueOf(this.b.getRectY2());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ddf.w
            public final /* synthetic */ EscherSpgrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getRectX1());
                    case 2:
                        return Integer.valueOf(this.b.getRectY1());
                    case 3:
                        return Integer.valueOf(this.b.getRectX2());
                    default:
                        return Integer.valueOf(this.b.getRectY2());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ddf.w
            public final /* synthetic */ EscherSpgrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getRectX1());
                    case 2:
                        return Integer.valueOf(this.b.getRectY1());
                    case 3:
                        return Integer.valueOf(this.b.getRectX2());
                    default:
                        return Integer.valueOf(this.b.getRectY2());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.ddf.w
            public final /* synthetic */ EscherSpgrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getRectX1());
                    case 2:
                        return Integer.valueOf(this.b.getRectY1());
                    case 3:
                        return Integer.valueOf(this.b.getRectX2());
                    default:
                        return Integer.valueOf(this.b.getRectY2());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("base", supplier, "rectX1", supplier2, "rectY1", supplier3, "rectX2", supplier4, "rectY2", new Supplier(this) { // from class: org.apache.poi.ddf.w
            public final /* synthetic */ EscherSpgrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getRectX1());
                    case 2:
                        return Integer.valueOf(this.b.getRectY1());
                    case 3:
                        return Integer.valueOf(this.b.getRectX2());
                    default:
                        return Integer.valueOf(this.b.getRectY2());
                }
            }
        });
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.SPGR;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return EscherRecordTypes.SPGR.recordName;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 24;
    }

    public int getRectX1() {
        return this.field_1_rectX1;
    }

    public int getRectX2() {
        return this.field_3_rectX2;
    }

    public int getRectY1() {
        return this.field_2_rectY1;
    }

    public int getRectY2() {
        return this.field_4_rectY2;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        LittleEndian.putInt(bArr, i5 + 4, 16);
        LittleEndian.putInt(bArr, i5 + 8, this.field_1_rectX1);
        LittleEndian.putInt(bArr, i5 + 12, this.field_2_rectY1);
        LittleEndian.putInt(bArr, i5 + 16, this.field_3_rectX2);
        LittleEndian.putInt(bArr, i5 + 20, this.field_4_rectY2);
        escherSerializationListener.afterRecordSerialize(getRecordSize() + i5, getRecordId(), getRecordSize() + i5, this);
        return 24;
    }

    public void setRectX1(int i5) {
        this.field_1_rectX1 = i5;
    }

    public void setRectX2(int i5) {
        this.field_3_rectX2 = i5;
    }

    public void setRectY1(int i5) {
        this.field_2_rectY1 = i5;
    }

    public void setRectY2(int i5) {
        this.field_4_rectY2 = i5;
    }

    public EscherSpgrRecord(EscherSpgrRecord escherSpgrRecord) {
        super(escherSpgrRecord);
        this.field_1_rectX1 = escherSpgrRecord.field_1_rectX1;
        this.field_2_rectY1 = escherSpgrRecord.field_2_rectY1;
        this.field_3_rectX2 = escherSpgrRecord.field_3_rectX2;
        this.field_4_rectY2 = escherSpgrRecord.field_4_rectY2;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherSpgrRecord copy() {
        return new EscherSpgrRecord(this);
    }
}
