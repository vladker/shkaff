package org.apache.poi.ddf;

import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherSimpleProperty extends EscherProperty {
    private final int propertyValue;

    public EscherSimpleProperty(short s6, int i5) {
        super(s6);
        this.propertyValue = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EscherSimpleProperty)) {
            return false;
        }
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) obj;
        return this.propertyValue == escherSimpleProperty.propertyValue && getId() == escherSimpleProperty.getId();
    }

    @Override // org.apache.poi.ddf.EscherProperty, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("base", new Supplier(this) { // from class: org.apache.poi.ddf.u
            public final /* synthetic */ EscherSimpleProperty b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return Integer.valueOf(this.b.getPropertyValue());
                }
            }
        }, "value", new Supplier(this) { // from class: org.apache.poi.ddf.u
            public final /* synthetic */ EscherSimpleProperty b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return Integer.valueOf(this.b.getPropertyValue());
                }
            }
        });
    }

    public int getPropertyValue() {
        return this.propertyValue;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.propertyValue), Short.valueOf(getId()));
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeComplexPart(byte[] bArr, int i5) {
        return 0;
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeSimplePart(byte[] bArr, int i5) {
        LittleEndian.putShort(bArr, i5, getId());
        LittleEndian.putInt(bArr, i5 + 2, this.propertyValue);
        return 6;
    }

    public EscherSimpleProperty(EscherPropertyTypes escherPropertyTypes, int i5) {
        this(escherPropertyTypes, false, false, i5);
    }

    public EscherSimpleProperty(short s6, boolean z6, boolean z7, int i5) {
        super(s6, z6, z7);
        this.propertyValue = i5;
    }

    public EscherSimpleProperty(EscherPropertyTypes escherPropertyTypes, boolean z6, boolean z7, int i5) {
        super(escherPropertyTypes, z6, z7);
        this.propertyValue = i5;
    }
}
