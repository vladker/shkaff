package org.apache.poi.ddf;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherChildAnchorRecord extends EscherRecord {
    public static final short RECORD_ID = EscherRecordTypes.CHILD_ANCHOR.typeID;
    private int field_1_dx1;
    private int field_2_dy1;
    private int field_3_dx2;
    private int field_4_dy2;

    public EscherChildAnchorRecord() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int i6;
        int header = readHeader(bArr, i5);
        int i7 = i5 + 8;
        if (header != 8) {
            i6 = 16;
            if (header != 16) {
                throw new RuntimeException("Invalid EscherChildAnchorRecord - neither 8 nor 16 bytes.");
            }
            this.field_1_dx1 = LittleEndian.getInt(bArr, i7);
            this.field_2_dy1 = LittleEndian.getInt(bArr, i5 + 12);
            this.field_3_dx2 = LittleEndian.getInt(bArr, i5 + 16);
            this.field_4_dy2 = LittleEndian.getInt(bArr, i5 + 20);
        } else {
            this.field_1_dx1 = LittleEndian.getShort(bArr, i7);
            this.field_2_dy1 = LittleEndian.getShort(bArr, i5 + 10);
            this.field_3_dx2 = LittleEndian.getShort(bArr, i5 + 12);
            this.field_4_dy2 = LittleEndian.getShort(bArr, i5 + 14);
            i6 = 8;
        }
        return i6 + 8;
    }

    public int getDx1() {
        return this.field_1_dx1;
    }

    public int getDx2() {
        return this.field_3_dx2;
    }

    public int getDy1() {
        return this.field_2_dy1;
    }

    public int getDy2() {
        return this.field_4_dy2;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ddf.g
            public final /* synthetic */ EscherChildAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getDx1());
                    case 2:
                        return Integer.valueOf(this.b.getDy1());
                    case 3:
                        return Integer.valueOf(this.b.getDx2());
                    default:
                        return Integer.valueOf(this.b.getDy2());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ddf.g
            public final /* synthetic */ EscherChildAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getDx1());
                    case 2:
                        return Integer.valueOf(this.b.getDy1());
                    case 3:
                        return Integer.valueOf(this.b.getDx2());
                    default:
                        return Integer.valueOf(this.b.getDy2());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ddf.g
            public final /* synthetic */ EscherChildAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getDx1());
                    case 2:
                        return Integer.valueOf(this.b.getDy1());
                    case 3:
                        return Integer.valueOf(this.b.getDx2());
                    default:
                        return Integer.valueOf(this.b.getDy2());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.ddf.g
            public final /* synthetic */ EscherChildAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getDx1());
                    case 2:
                        return Integer.valueOf(this.b.getDy1());
                    case 3:
                        return Integer.valueOf(this.b.getDx2());
                    default:
                        return Integer.valueOf(this.b.getDy2());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("base", supplier, "x1", supplier2, "y1", supplier3, "x2", supplier4, "y2", new Supplier(this) { // from class: org.apache.poi.ddf.g
            public final /* synthetic */ EscherChildAnchorRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getDx1());
                    case 2:
                        return Integer.valueOf(this.b.getDy1());
                    case 3:
                        return Integer.valueOf(this.b.getDx2());
                    default:
                        return Integer.valueOf(this.b.getDy2());
                }
            }
        });
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.CHILD_ANCHOR;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return EscherRecordTypes.CHILD_ANCHOR.recordName;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 24;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        LittleEndian.putInt(bArr, i5 + 4, getRecordSize() - 8);
        LittleEndian.putInt(bArr, i5 + 8, this.field_1_dx1);
        LittleEndian.putInt(bArr, i5 + 12, this.field_2_dy1);
        LittleEndian.putInt(bArr, i5 + 16, this.field_3_dx2);
        LittleEndian.putInt(bArr, i5 + 20, this.field_4_dy2);
        int i6 = i5 + 24;
        int i7 = i6 - i5;
        escherSerializationListener.afterRecordSerialize(i6, getRecordId(), i7, this);
        return i7;
    }

    public void setDx1(int i5) {
        this.field_1_dx1 = i5;
    }

    public void setDx2(int i5) {
        this.field_3_dx2 = i5;
    }

    public void setDy1(int i5) {
        this.field_2_dy1 = i5;
    }

    public void setDy2(int i5) {
        this.field_4_dy2 = i5;
    }

    public EscherChildAnchorRecord(EscherChildAnchorRecord escherChildAnchorRecord) {
        super(escherChildAnchorRecord);
        this.field_1_dx1 = escherChildAnchorRecord.field_1_dx1;
        this.field_2_dy1 = escherChildAnchorRecord.field_2_dy1;
        this.field_3_dx2 = escherChildAnchorRecord.field_3_dx2;
        this.field_4_dy2 = escherChildAnchorRecord.field_4_dy2;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherChildAnchorRecord copy() {
        return new EscherChildAnchorRecord(this);
    }
}
