package org.apache.poi.ddf;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherSpRecord extends EscherRecord {
    public static final int FLAG_BACKGROUND = 1024;
    public static final int FLAG_CHILD = 2;
    public static final int FLAG_CONNECTOR = 256;
    public static final int FLAG_DELETED = 8;
    public static final int FLAG_FLIPHORIZ = 64;
    public static final int FLAG_FLIPVERT = 128;
    public static final int FLAG_GROUP = 1;
    public static final int FLAG_HASSHAPETYPE = 2048;
    public static final int FLAG_HAVEANCHOR = 512;
    public static final int FLAG_HAVEMASTER = 32;
    public static final int FLAG_OLESHAPE = 16;
    public static final int FLAG_PATRIARCH = 4;
    private int field_1_shapeId;
    private int field_2_flags;
    public static final short RECORD_ID = EscherRecordTypes.SP.typeID;
    private static final int[] FLAGS_MASKS = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};
    private static final String[] FLAGS_NAMES = {"GROUP", "CHILD", "PATRIARCH", "DELETED", "OLESHAPE", "HAVEMASTER", "FLIPHORIZ", "FLIPVERT", "CONNECTOR", "HAVEANCHOR", "BACKGROUND", "HASSHAPETYPE"};

    public EscherSpRecord() {
    }

    private String decodeFlags(int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append((i5 & 1) != 0 ? "|GROUP" : "");
        sb.append((i5 & 2) != 0 ? "|CHILD" : "");
        sb.append((i5 & 4) != 0 ? "|PATRIARCH" : "");
        sb.append((i5 & 8) != 0 ? "|DELETED" : "");
        sb.append((i5 & 16) != 0 ? "|OLESHAPE" : "");
        sb.append((i5 & 32) != 0 ? "|HAVEMASTER" : "");
        sb.append((i5 & 64) != 0 ? "|FLIPHORIZ" : "");
        sb.append((i5 & 128) != 0 ? "|FLIPVERT" : "");
        sb.append((i5 & 256) != 0 ? "|CONNECTOR" : "");
        sb.append((i5 & 512) != 0 ? "|HAVEANCHOR" : "");
        sb.append((i5 & 1024) != 0 ? "|BACKGROUND" : "");
        sb.append((i5 & 2048) != 0 ? "|HASSHAPETYPE" : "");
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        readHeader(bArr, i5);
        this.field_1_shapeId = LittleEndian.getInt(bArr, i5 + 8);
        this.field_2_flags = LittleEndian.getInt(bArr, i5 + 12);
        return getRecordSize();
    }

    public int getFlags() {
        return this.field_2_flags;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ddf.v
            public final /* synthetic */ EscherSpRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getShapeType());
                    case 2:
                        return Integer.valueOf(this.b.getShapeId());
                    default:
                        return Integer.valueOf(this.b.getFlags());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ddf.v
            public final /* synthetic */ EscherSpRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getShapeType());
                    case 2:
                        return Integer.valueOf(this.b.getShapeId());
                    default:
                        return Integer.valueOf(this.b.getFlags());
                }
            }
        };
        final int i7 = 2;
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("base", supplier, "shapeType", supplier2, "shapeId", new Supplier(this) { // from class: org.apache.poi.ddf.v
            public final /* synthetic */ EscherSpRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getShapeType());
                    case 2:
                        return Integer.valueOf(this.b.getShapeId());
                    default:
                        return Integer.valueOf(this.b.getFlags());
                }
            }
        }, "flags", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.ddf.v
            public final /* synthetic */ EscherSpRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getShapeType());
                    case 2:
                        return Integer.valueOf(this.b.getShapeId());
                    default:
                        return Integer.valueOf(this.b.getFlags());
                }
            }
        }, FLAGS_MASKS, FLAGS_NAMES));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.SP;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return EscherRecordTypes.SP.recordName;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 16;
    }

    public int getShapeId() {
        return this.field_1_shapeId;
    }

    public short getShapeType() {
        return getInstance();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        LittleEndian.putInt(bArr, i5 + 4, 8);
        LittleEndian.putInt(bArr, i5 + 8, this.field_1_shapeId);
        LittleEndian.putInt(bArr, i5 + 12, this.field_2_flags);
        escherSerializationListener.afterRecordSerialize(getRecordSize() + i5, getRecordId(), getRecordSize(), this);
        return 16;
    }

    public void setFlags(int i5) {
        this.field_2_flags = i5;
    }

    public void setShapeId(int i5) {
        this.field_1_shapeId = i5;
    }

    public void setShapeType(short s6) {
        setInstance(s6);
    }

    public EscherSpRecord(EscherSpRecord escherSpRecord) {
        super(escherSpRecord);
        this.field_1_shapeId = escherSpRecord.field_1_shapeId;
        this.field_2_flags = escherSpRecord.field_2_flags;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherSpRecord copy() {
        return new EscherSpRecord(this);
    }
}
