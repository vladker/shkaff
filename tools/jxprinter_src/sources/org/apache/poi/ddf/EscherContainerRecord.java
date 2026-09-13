package org.apache.poi.ddf;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EscherContainerRecord extends EscherRecord implements Iterable<EscherRecord> {
    private final List<EscherRecord> _childRecords;
    private int _remainingLength;
    public static final short DGG_CONTAINER = EscherRecordTypes.DGG_CONTAINER.typeID;
    public static final short BSTORE_CONTAINER = EscherRecordTypes.BSTORE_CONTAINER.typeID;
    public static final short DG_CONTAINER = EscherRecordTypes.DG_CONTAINER.typeID;
    public static final short SPGR_CONTAINER = EscherRecordTypes.SPGR_CONTAINER.typeID;
    public static final short SP_CONTAINER = EscherRecordTypes.SP_CONTAINER.typeID;
    public static final short SOLVER_CONTAINER = EscherRecordTypes.SOLVER_CONTAINER.typeID;
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) EscherContainerRecord.class);

    public EscherContainerRecord() {
        this._childRecords = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return super.getGenericProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$hasChildOfType$0(short s6, EscherRecord escherRecord) {
        return escherRecord.getRecordId() == s6;
    }

    public void addChildBefore(EscherRecord escherRecord, int i5) {
        Iterator<EscherRecord> it = iterator();
        int i6 = 0;
        while (it.hasNext() && it.next().getRecordId() != ((short) i5)) {
            i6++;
        }
        this._childRecords.add(i6, escherRecord);
    }

    public void addChildRecord(EscherRecord escherRecord) {
        this._childRecords.add(escherRecord);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public void display(PrintWriter printWriter, int i5) {
        super.display(printWriter, i5);
        Iterator<EscherRecord> it = iterator();
        while (it.hasNext()) {
            it.next().display(printWriter, i5 + 1);
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i5);
        int i6 = 8;
        int i7 = i5 + 8;
        while (header > 0 && i7 < bArr.length) {
            EscherRecord escherRecordCreateRecord = escherRecordFactory.createRecord(bArr, i7);
            int iFillFields = escherRecordCreateRecord.fillFields(bArr, i7, escherRecordFactory);
            i6 += iFillFields;
            i7 += iFillFields;
            header -= iFillFields;
            addChildRecord(escherRecordCreateRecord);
            if (i7 >= bArr.length && header > 0) {
                this._remainingLength = header;
                LOGGER.atWarn().log("Not enough Escher data: {} bytes remaining but no space left", Unbox.box(header));
            }
        }
        return i6;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public EscherRecord getChild(int i5) {
        return this._childRecords.get(i5);
    }

    public <T extends EscherRecord> T getChildById(short s6) {
        Iterator<EscherRecord> it = iterator();
        while (it.hasNext()) {
            T t6 = (T) it.next();
            if (t6.getRecordId() == s6) {
                return t6;
            }
        }
        return null;
    }

    public List<EscherContainerRecord> getChildContainers() {
        ArrayList arrayList = new ArrayList();
        for (EscherRecord escherRecord : this) {
            if (escherRecord instanceof EscherContainerRecord) {
                arrayList.add((EscherContainerRecord) escherRecord);
            }
        }
        return arrayList;
    }

    public int getChildCount() {
        return this._childRecords.size();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public List<EscherRecord> getChildRecords() {
        return new ArrayList(this._childRecords);
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("base", new Supplier(this) { // from class: org.apache.poi.ddf.m
            public final /* synthetic */ EscherContainerRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return Boolean.valueOf(this.b.isContainerRecord());
                }
            }
        }, "isContainer", new Supplier(this) { // from class: org.apache.poi.ddf.m
            public final /* synthetic */ EscherContainerRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return Boolean.valueOf(this.b.isContainerRecord());
                }
            }
        });
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.forTypeID(getRecordId());
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        short recordId = getRecordId();
        EscherRecordTypes escherRecordTypesForTypeID = EscherRecordTypes.forTypeID(recordId);
        if (escherRecordTypesForTypeID != EscherRecordTypes.UNKNOWN) {
            return escherRecordTypesForTypeID.recordName;
        }
        return "Container 0x" + HexDump.toHex(recordId);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        Iterator<EscherRecord> it = iterator();
        int recordSize = 0;
        while (it.hasNext()) {
            recordSize += it.next().getRecordSize();
        }
        return recordSize + 8;
    }

    public void getRecordsById(short s6, List<EscherRecord> list) {
        for (EscherRecord escherRecord : this) {
            if (escherRecord instanceof EscherContainerRecord) {
                ((EscherContainerRecord) escherRecord).getRecordsById(s6, list);
            } else if (escherRecord.getRecordId() == s6) {
                list.add(escherRecord);
            }
        }
    }

    public boolean hasChildOfType(final short s6) {
        return this._childRecords.stream().anyMatch(new Predicate() { // from class: org.apache.poi.ddf.k
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return EscherContainerRecord.lambda$hasChildOfType$0(s6, (EscherRecord) obj);
            }
        });
    }

    @Override // java.lang.Iterable
    public Iterator<EscherRecord> iterator() {
        return Collections.unmodifiableList(this._childRecords).iterator();
    }

    public boolean removeChildRecord(EscherRecord escherRecord) {
        return this._childRecords.remove(escherRecord);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        Iterator<EscherRecord> it = iterator();
        int recordSize = 0;
        while (it.hasNext()) {
            recordSize += it.next().getRecordSize();
        }
        LittleEndian.putInt(bArr, i5 + 4, recordSize + this._remainingLength);
        int iSerialize = i5 + 8;
        Iterator<EscherRecord> it2 = iterator();
        while (it2.hasNext()) {
            iSerialize += it2.next().serialize(iSerialize, bArr, escherSerializationListener);
        }
        int i6 = iSerialize - i5;
        escherSerializationListener.afterRecordSerialize(iSerialize, getRecordId(), i6, this);
        return i6;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public void setChildRecords(List<EscherRecord> list) {
        List<EscherRecord> list2 = this._childRecords;
        if (list == list2) {
            throw new IllegalStateException("Child records private data member has escaped");
        }
        list2.clear();
        this._childRecords.addAll(list);
    }

    @Override // java.lang.Iterable
    public Spliterator<EscherRecord> spliterator() {
        return this._childRecords.spliterator();
    }

    public EscherContainerRecord(EscherContainerRecord escherContainerRecord) {
        super(escherContainerRecord);
        ArrayList arrayList = new ArrayList();
        this._childRecords = arrayList;
        this._remainingLength = escherContainerRecord._remainingLength;
        escherContainerRecord._childRecords.stream().map(new com.google.android.material.color.utilities.g(10)).forEach(new l(arrayList, 0));
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.Duplicatable
    public EscherContainerRecord copy() {
        return new EscherContainerRecord(this);
    }
}
