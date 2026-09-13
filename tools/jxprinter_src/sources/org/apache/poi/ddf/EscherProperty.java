package org.apache.poi.ddf;

import com.google.common.primitives.Shorts;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.GenericRecordXmlWriter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class EscherProperty implements GenericRecord {
    private static final int[] FLAG_MASK = {16384, 32768};
    private static final String[] FLAG_NAMES = {"IS_BLIP", "IS_COMPLEX"};
    static final int IS_BLIP = 16384;
    static final int IS_COMPLEX = 32768;
    private final short id;

    public EscherProperty(short s6) {
        this.id = s6;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<? extends GenericRecord> getGenericChildren() {
        return null;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier() { // from class: org.apache.poi.ddf.r
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Short.valueOf(this.getId());
                    case 1:
                        return this.getName();
                    case 2:
                        return Short.valueOf(this.getPropertyNumber());
                    default:
                        return Integer.valueOf(this.getPropertySize());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier() { // from class: org.apache.poi.ddf.r
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Short.valueOf(this.getId());
                    case 1:
                        return this.getName();
                    case 2:
                        return Short.valueOf(this.getPropertyNumber());
                    default:
                        return Integer.valueOf(this.getPropertySize());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier() { // from class: org.apache.poi.ddf.r
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Short.valueOf(this.getId());
                    case 1:
                        return this.getName();
                    case 2:
                        return Short.valueOf(this.getPropertyNumber());
                    default:
                        return Integer.valueOf(this.getPropertySize());
                }
            }
        };
        final int i8 = 3;
        final int i9 = 0;
        return GenericRecordUtil.getGenericProperties("id", supplier, "name", supplier2, "propertyNumber", supplier3, "propertySize", new Supplier() { // from class: org.apache.poi.ddf.r
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Short.valueOf(this.getId());
                    case 1:
                        return this.getName();
                    case 2:
                        return Short.valueOf(this.getPropertyNumber());
                    default:
                        return Integer.valueOf(this.getPropertySize());
                }
            }
        }, "flags", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier() { // from class: org.apache.poi.ddf.r
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Short.valueOf(this.getId());
                    case 1:
                        return this.getName();
                    case 2:
                        return Short.valueOf(this.getPropertyNumber());
                    default:
                        return Integer.valueOf(this.getPropertySize());
                }
            }
        }, FLAG_MASK, FLAG_NAMES));
    }

    public short getId() {
        return this.id;
    }

    public String getName() {
        return EscherPropertyTypes.forPropertyID(getPropertyNumber()).propName;
    }

    public short getPropertyNumber() {
        return (short) (this.id & 16383);
    }

    public int getPropertySize() {
        return 6;
    }

    public boolean isBlipId() {
        return (this.id & Shorts.MAX_POWER_OF_TWO) != 0;
    }

    public boolean isComplex() {
        return (this.id & Short.MIN_VALUE) != 0;
    }

    public abstract int serializeComplexPart(byte[] bArr, int i5);

    public abstract int serializeSimplePart(byte[] bArr, int i5);

    public final String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    public final String toXml(String str) {
        return GenericRecordXmlWriter.marshal(this);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public EscherPropertyTypes getGenericRecordType() {
        return EscherPropertyTypes.forPropertyID(this.id);
    }

    public EscherProperty(short s6, boolean z6, boolean z7) {
        this((short) (s6 | (z6 ? Short.MIN_VALUE : (short) 0) | (z7 ? 16384 : 0)));
    }

    public EscherProperty(EscherPropertyTypes escherPropertyTypes, boolean z6, boolean z7) {
        this((short) (escherPropertyTypes.propNumber | (z6 ? Short.MIN_VALUE : (short) 0) | (z7 ? 16384 : 0)));
    }
}
