package org.apache.poi.ddf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class UnknownEscherRecord extends EscherRecord {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000000;
    private static int MAX_RECORD_LENGTH = 100000000;
    private static final byte[] NO_BYTES = new byte[0];
    private final List<EscherRecord> _childRecords;
    private byte[] thedata;

    public UnknownEscherRecord() {
        this.thedata = NO_BYTES;
        this._childRecords = new ArrayList();
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    public void addChildRecord(EscherRecord escherRecord) {
        getChildRecords().add(escherRecord);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i5);
        int i6 = 8;
        int i7 = i5 + 8;
        int length = bArr.length - i7;
        if (header > length) {
            header = length;
        }
        if (!isContainerRecord()) {
            if (header < 0) {
                header = 0;
            }
            this.thedata = IOUtils.safelyClone(bArr, i7, header, MAX_RECORD_LENGTH);
            return header + 8;
        }
        this.thedata = new byte[0];
        while (header > 0) {
            EscherRecord escherRecordCreateRecord = escherRecordFactory.createRecord(bArr, i7);
            int iFillFields = escherRecordCreateRecord.fillFields(bArr, i7, escherRecordFactory);
            i6 += iFillFields;
            i7 += iFillFields;
            header -= iFillFields;
            getChildRecords().add(escherRecordCreateRecord);
        }
        return i6;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public List<EscherRecord> getChildRecords() {
        return this._childRecords;
    }

    public byte[] getData() {
        return this.thedata;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("base", new Supplier(this) { // from class: org.apache.poi.ddf.z
            public final /* synthetic */ UnknownEscherRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getData();
                }
            }
        }, "data", new Supplier(this) { // from class: org.apache.poi.ddf.z
            public final /* synthetic */ UnknownEscherRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getData();
                }
            }
        });
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.UNKNOWN;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Unknown 0x" + HexDump.toHex(getRecordId());
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.thedata.length + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        int length = this.thedata.length;
        Iterator<EscherRecord> it = this._childRecords.iterator();
        while (it.hasNext()) {
            length += it.next().getRecordSize();
        }
        LittleEndian.putInt(bArr, i5 + 4, length);
        byte[] bArr2 = this.thedata;
        int i6 = i5 + 8;
        System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
        int length2 = i6 + this.thedata.length;
        Iterator<EscherRecord> it2 = this._childRecords.iterator();
        while (it2.hasNext()) {
            length2 += it2.next().serialize(length2, bArr, escherSerializationListener);
        }
        int i7 = length2 - i5;
        escherSerializationListener.afterRecordSerialize(length2, getRecordId(), i7, this);
        return i7;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public void setChildRecords(List<EscherRecord> list) {
        List<EscherRecord> list2 = this._childRecords;
        if (list == list2) {
            return;
        }
        list2.clear();
        this._childRecords.addAll(list);
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public UnknownEscherRecord copy() {
        return new UnknownEscherRecord(this);
    }

    public UnknownEscherRecord(UnknownEscherRecord unknownEscherRecord) {
        super(unknownEscherRecord);
        this.thedata = NO_BYTES;
        ArrayList arrayList = new ArrayList();
        this._childRecords = arrayList;
        unknownEscherRecord._childRecords.stream().map(new com.google.android.material.color.utilities.g(10)).forEach(new l(arrayList, 0));
    }
}
