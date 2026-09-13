package org.apache.poi.ddf;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractEscherOptRecord extends EscherRecord {
    private final List<EscherProperty> properties;

    public AbstractEscherOptRecord() {
        this.properties = new ArrayList();
    }

    private int getPropertiesSize() {
        Iterator<EscherProperty> it = this.properties.iterator();
        int propertySize = 0;
        while (it.hasNext()) {
            propertySize += it.next().getPropertySize();
        }
        return propertySize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return super.getGenericProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$lookup$0(int i5, EscherProperty escherProperty) {
        return escherProperty.getPropertyNumber() == i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeEscherProperty$2(EscherPropertyTypes escherPropertyTypes, EscherProperty escherProperty) {
        return escherProperty.getPropertyNumber() == escherPropertyTypes.propNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setEscherProperty$1(EscherProperty escherProperty, EscherProperty escherProperty2) {
        return escherProperty2.getId() == escherProperty.getId();
    }

    public void addEscherProperty(EscherProperty escherProperty) {
        this.properties.add(escherProperty);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i5, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i5);
        if (header < 0) {
            throw new IllegalStateException(AbstractC0157z.k(header, "Invalid value for bytesRemaining: "));
        }
        short instance = EscherRecord.readInstance(bArr, i5);
        EscherPropertyFactory escherPropertyFactory = new EscherPropertyFactory();
        this.properties.clear();
        this.properties.addAll(escherPropertyFactory.createProperties(bArr, i5 + 8, instance));
        return header + 8;
    }

    public List<EscherProperty> getEscherProperties() {
        return this.properties;
    }

    public EscherProperty getEscherProperty(int i5) {
        return this.properties.get(i5);
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ddf.b
            public final /* synthetic */ AbstractEscherOptRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$3();
                    case 1:
                        return Boolean.valueOf(this.b.isContainerRecord());
                    default:
                        return this.b.getEscherProperties();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ddf.b
            public final /* synthetic */ AbstractEscherOptRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$3();
                    case 1:
                        return Boolean.valueOf(this.b.isContainerRecord());
                    default:
                        return this.b.getEscherProperties();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("base", supplier, "isContainer", supplier2, "properties", new Supplier(this) { // from class: org.apache.poi.ddf.b
            public final /* synthetic */ AbstractEscherOptRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$3();
                    case 1:
                        return Boolean.valueOf(this.b.isContainerRecord());
                    default:
                        return this.b.getEscherProperties();
                }
            }
        });
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return getPropertiesSize() + 8;
    }

    public <T extends EscherProperty> T lookup(EscherPropertyTypes escherPropertyTypes) {
        return (T) lookup(escherPropertyTypes.propNumber);
    }

    public void removeEscherProperty(EscherPropertyTypes escherPropertyTypes) {
        this.properties.removeIf(new E4.a(escherPropertyTypes, 3));
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i5, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i5, getRecordId(), this);
        LittleEndian.putShort(bArr, i5, getOptions());
        LittleEndian.putShort(bArr, i5 + 2, getRecordId());
        LittleEndian.putInt(bArr, i5 + 4, getPropertiesSize());
        int iSerializeComplexPart = i5 + 8;
        Iterator<EscherProperty> it = this.properties.iterator();
        while (it.hasNext()) {
            iSerializeComplexPart += it.next().serializeSimplePart(bArr, iSerializeComplexPart);
        }
        Iterator<EscherProperty> it2 = this.properties.iterator();
        while (it2.hasNext()) {
            iSerializeComplexPart += it2.next().serializeComplexPart(bArr, iSerializeComplexPart);
        }
        int i6 = iSerializeComplexPart - i5;
        escherSerializationListener.afterRecordSerialize(iSerializeComplexPart, getRecordId(), i6, this);
        return i6;
    }

    public void setEscherProperty(EscherProperty escherProperty) {
        this.properties.removeIf(new E4.a(escherProperty, 2));
        this.properties.add(escherProperty);
        sortProperties();
    }

    public void sortProperties() {
        this.properties.sort(Comparator.comparingInt(new O4.a(1)));
    }

    public <T extends EscherProperty> T lookup(final int i5) {
        return (T) this.properties.stream().filter(new Predicate() { // from class: org.apache.poi.ddf.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AbstractEscherOptRecord.lambda$lookup$0(i5, (EscherProperty) obj);
            }
        }).findFirst().orElse(null);
    }

    public AbstractEscherOptRecord(AbstractEscherOptRecord abstractEscherOptRecord) {
        super(abstractEscherOptRecord);
        ArrayList arrayList = new ArrayList();
        this.properties = arrayList;
        arrayList.addAll(abstractEscherOptRecord.properties);
    }
}
