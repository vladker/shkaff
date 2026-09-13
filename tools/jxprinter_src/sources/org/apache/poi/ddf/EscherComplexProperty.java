package org.apache.poi.ddf;

import com.google.common.primitives.Shorts;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherComplexProperty extends EscherProperty {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000000;
    private static int MAX_RECORD_LENGTH = 100000000;
    private byte[] complexData;

    public EscherComplexProperty(short s6, int i5) {
        super((short) (s6 | Short.MIN_VALUE));
        this.complexData = IOUtils.safelyAllocate(i5, MAX_RECORD_LENGTH);
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EscherComplexProperty) {
            return Arrays.equals(this.complexData, ((EscherComplexProperty) obj).complexData);
        }
        return false;
    }

    public byte[] getComplexData() {
        return this.complexData;
    }

    @Override // org.apache.poi.ddf.EscherProperty, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("base", new Supplier(this) { // from class: org.apache.poi.ddf.j
            public final /* synthetic */ EscherComplexProperty b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getComplexData();
                }
            }
        }, "data", new Supplier(this) { // from class: org.apache.poi.ddf.j
            public final /* synthetic */ EscherComplexProperty b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.getComplexData();
                }
            }
        });
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int getPropertySize() {
        return this.complexData.length + 6;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{this.complexData, Short.valueOf(getId())});
    }

    public void resizeComplexData(int i5) {
        resizeComplexData(i5, Integer.MAX_VALUE);
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeComplexPart(byte[] bArr, int i5) {
        byte[] bArr2 = this.complexData;
        System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
        return this.complexData.length;
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeSimplePart(byte[] bArr, int i5) {
        LittleEndian.putShort(bArr, i5, getId());
        LittleEndian.putInt(bArr, i5 + 2, this.complexData.length);
        return 6;
    }

    public int setComplexData(byte[] bArr) {
        return setComplexData(bArr, 0);
    }

    public void resizeComplexData(int i5, int i6) {
        if (i5 == this.complexData.length) {
            return;
        }
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, MAX_RECORD_LENGTH);
        byte[] bArr = this.complexData;
        System.arraycopy(bArr, 0, bArrSafelyAllocate, 0, Math.min(Math.min(bArr.length, i6), i5));
        this.complexData = bArrSafelyAllocate;
    }

    public int setComplexData(byte[] bArr, int i5) {
        if (bArr == null) {
            return 0;
        }
        int iMax = Math.max(0, Math.min(this.complexData.length, bArr.length - i5));
        System.arraycopy(bArr, i5, this.complexData, 0, iMax);
        return iMax;
    }

    public EscherComplexProperty(short s6, boolean z6, int i5) {
        this((short) (s6 | (z6 ? Shorts.MAX_POWER_OF_TWO : (short) 0)), i5);
    }

    public EscherComplexProperty(EscherPropertyTypes escherPropertyTypes, boolean z6, int i5) {
        this((short) (escherPropertyTypes.propNumber | (z6 ? Shorts.MAX_POWER_OF_TWO : (short) 0)), i5);
    }
}
