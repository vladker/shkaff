package org.apache.poi.ddf;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherDgRecord extends EscherRecord {
    public static final short RECORD_ID = EscherRecordTypes.DG.typeID;
    private int field_1_numShapes;
    private int field_2_lastMSOSPID;

    public EscherDgRecord() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        readHeader(bArr, i5);
        this.field_1_numShapes = LittleEndian.getInt(bArr, i5 + 8);
        this.field_2_lastMSOSPID = LittleEndian.getInt(bArr, i5 + 12);
        return getRecordSize();
    }

    public short getDrawingGroupId() {
        return (short) (getOptions() >> 4);
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ddf.n
            public final /* synthetic */ EscherDgRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getNumShapes());
                    case 2:
                        return Integer.valueOf(this.b.getLastMSOSPID());
                    default:
                        return Short.valueOf(this.b.getDrawingGroupId());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ddf.n
            public final /* synthetic */ EscherDgRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getNumShapes());
                    case 2:
                        return Integer.valueOf(this.b.getLastMSOSPID());
                    default:
                        return Short.valueOf(this.b.getDrawingGroupId());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ddf.n
            public final /* synthetic */ EscherDgRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getNumShapes());
                    case 2:
                        return Integer.valueOf(this.b.getLastMSOSPID());
                    default:
                        return Short.valueOf(this.b.getDrawingGroupId());
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("base", supplier, "numShapes", supplier2, "lastMSOSPID", supplier3, "drawingGroupId", new Supplier(this) { // from class: org.apache.poi.ddf.n
            public final /* synthetic */ EscherDgRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getNumShapes());
                    case 2:
                        return Integer.valueOf(this.b.getLastMSOSPID());
                    default:
                        return Short.valueOf(this.b.getDrawingGroupId());
                }
            }
        });
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.DG;
    }

    public int getLastMSOSPID() {
        return this.field_2_lastMSOSPID;
    }

    public int getNumShapes() {
        return this.field_1_numShapes;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return EscherRecordTypes.DG.recordName;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 16;
    }

    public void incrementShapeCount() {
        this.field_1_numShapes++;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        LittleEndian.putInt(bArr, i5 + 4, 8);
        LittleEndian.putInt(bArr, i5 + 8, this.field_1_numShapes);
        LittleEndian.putInt(bArr, i5 + 12, this.field_2_lastMSOSPID);
        escherSerializationListener.afterRecordSerialize(i5 + 16, getRecordId(), getRecordSize(), this);
        return getRecordSize();
    }

    public void setLastMSOSPID(int i5) {
        this.field_2_lastMSOSPID = i5;
    }

    public void setNumShapes(int i5) {
        this.field_1_numShapes = i5;
    }

    public EscherDgRecord(EscherDgRecord escherDgRecord) {
        super(escherDgRecord);
        this.field_1_numShapes = escherDgRecord.field_1_numShapes;
        this.field_2_lastMSOSPID = escherDgRecord.field_2_lastMSOSPID;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherDgRecord copy() {
        return new EscherDgRecord(this);
    }
}
