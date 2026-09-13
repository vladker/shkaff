package org.apache.poi.ddf;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherSplitMenuColorsRecord extends EscherRecord {
    public static final short RECORD_ID = EscherRecordTypes.SPLIT_MENU_COLORS.typeID;
    private int field_1_color1;
    private int field_2_color2;
    private int field_3_color3;
    private int field_4_color4;

    public EscherSplitMenuColorsRecord() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i5);
        this.field_1_color1 = LittleEndian.getInt(bArr, i5 + 8);
        this.field_2_color2 = LittleEndian.getInt(bArr, i5 + 12);
        this.field_3_color3 = LittleEndian.getInt(bArr, i5 + 16);
        this.field_4_color4 = LittleEndian.getInt(bArr, i5 + 20);
        int i6 = header - 16;
        if (i6 == 0) {
            return header + 8;
        }
        throw new RecordFormatException(androidx.collection.a.i(i6, "Expecting no remaining data but got ", " byte(s)."));
    }

    public int getColor1() {
        return this.field_1_color1;
    }

    public int getColor2() {
        return this.field_2_color2;
    }

    public int getColor3() {
        return this.field_3_color3;
    }

    public int getColor4() {
        return this.field_4_color4;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ddf.x
            public final /* synthetic */ EscherSplitMenuColorsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getColor1());
                    case 2:
                        return Integer.valueOf(this.b.getColor2());
                    case 3:
                        return Integer.valueOf(this.b.getColor3());
                    default:
                        return Integer.valueOf(this.b.getColor4());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ddf.x
            public final /* synthetic */ EscherSplitMenuColorsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getColor1());
                    case 2:
                        return Integer.valueOf(this.b.getColor2());
                    case 3:
                        return Integer.valueOf(this.b.getColor3());
                    default:
                        return Integer.valueOf(this.b.getColor4());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ddf.x
            public final /* synthetic */ EscherSplitMenuColorsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getColor1());
                    case 2:
                        return Integer.valueOf(this.b.getColor2());
                    case 3:
                        return Integer.valueOf(this.b.getColor3());
                    default:
                        return Integer.valueOf(this.b.getColor4());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.ddf.x
            public final /* synthetic */ EscherSplitMenuColorsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getColor1());
                    case 2:
                        return Integer.valueOf(this.b.getColor2());
                    case 3:
                        return Integer.valueOf(this.b.getColor3());
                    default:
                        return Integer.valueOf(this.b.getColor4());
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("base", supplier, "color1", supplier2, "color2", supplier3, "color3", supplier4, "color4", new Supplier(this) { // from class: org.apache.poi.ddf.x
            public final /* synthetic */ EscherSplitMenuColorsRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getColor1());
                    case 2:
                        return Integer.valueOf(this.b.getColor2());
                    case 3:
                        return Integer.valueOf(this.b.getColor3());
                    default:
                        return Integer.valueOf(this.b.getColor4());
                }
            }
        });
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.SPLIT_MENU_COLORS;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return EscherRecordTypes.SPLIT_MENU_COLORS.recordName;
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
        LittleEndian.putInt(bArr, i5 + 8, this.field_1_color1);
        LittleEndian.putInt(bArr, i5 + 12, this.field_2_color2);
        LittleEndian.putInt(bArr, i5 + 16, this.field_3_color3);
        LittleEndian.putInt(bArr, i5 + 20, this.field_4_color4);
        int i6 = i5 + 24;
        escherSerializationListener.afterRecordSerialize(i6, getRecordId(), i6 - i5, this);
        return getRecordSize();
    }

    public void setColor1(int i5) {
        this.field_1_color1 = i5;
    }

    public void setColor2(int i5) {
        this.field_2_color2 = i5;
    }

    public void setColor3(int i5) {
        this.field_3_color3 = i5;
    }

    public void setColor4(int i5) {
        this.field_4_color4 = i5;
    }

    public EscherSplitMenuColorsRecord(EscherSplitMenuColorsRecord escherSplitMenuColorsRecord) {
        super(escherSplitMenuColorsRecord);
        this.field_1_color1 = escherSplitMenuColorsRecord.field_1_color1;
        this.field_2_color2 = escherSplitMenuColorsRecord.field_2_color2;
        this.field_3_color3 = escherSplitMenuColorsRecord.field_3_color3;
        this.field_4_color4 = escherSplitMenuColorsRecord.field_4_color4;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherSplitMenuColorsRecord copy() {
        return new EscherSplitMenuColorsRecord(this);
    }
}
