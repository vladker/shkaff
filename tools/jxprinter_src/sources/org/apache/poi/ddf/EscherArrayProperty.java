package org.apache.poi.ddf;

import com.google.common.primitives.Shorts;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EscherArrayProperty extends EscherComplexProperty implements Iterable<byte[]> {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000;
    private static final int FIXED_SIZE = 6;
    private static int MAX_RECORD_LENGTH = 100000;
    private final boolean emptyComplexPart;
    private boolean sizeIncludesHeaderSize;

    @Internal
    public EscherArrayProperty(short s6, int i5) {
        super(s6, i5);
        this.sizeIncludesHeaderSize = true;
        this.emptyComplexPart = i5 == 0;
    }

    private static int getActualSizeOfElements(short s6) {
        return s6 < 0 ? (short) ((-s6) >> 2) : s6;
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return (List) StreamSupport.stream(spliterator(), false).collect(Collectors.toList());
    }

    private void rewriteArray(int i5, boolean z6) {
        int actualSizeOfElements = (i5 * getActualSizeOfElements(getSizeOfElements())) + 6;
        resizeComplexData(actualSizeOfElements, z6 ? actualSizeOfElements : getComplexData().length);
    }

    private static int safeSize(int i5) {
        if (i5 == 0) {
            return 6;
        }
        return i5;
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    public byte[] getElement(int i5) {
        int actualSizeOfElements = getActualSizeOfElements(getSizeOfElements());
        return IOUtils.safelyClone(getComplexData(), (i5 * actualSizeOfElements) + 6, actualSizeOfElements, MAX_RECORD_LENGTH);
    }

    @Override // org.apache.poi.ddf.EscherComplexProperty, org.apache.poi.ddf.EscherProperty, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ddf.c
            public final /* synthetic */ EscherArrayProperty b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getNumberOfElementsInArray());
                    case 2:
                        return Integer.valueOf(this.b.getNumberOfElementsInMemory());
                    case 3:
                        return Short.valueOf(this.b.getSizeOfElements());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ddf.c
            public final /* synthetic */ EscherArrayProperty b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getNumberOfElementsInArray());
                    case 2:
                        return Integer.valueOf(this.b.getNumberOfElementsInMemory());
                    case 3:
                        return Short.valueOf(this.b.getSizeOfElements());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ddf.c
            public final /* synthetic */ EscherArrayProperty b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getNumberOfElementsInArray());
                    case 2:
                        return Integer.valueOf(this.b.getNumberOfElementsInMemory());
                    case 3:
                        return Short.valueOf(this.b.getSizeOfElements());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.ddf.c
            public final /* synthetic */ EscherArrayProperty b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getNumberOfElementsInArray());
                    case 2:
                        return Integer.valueOf(this.b.getNumberOfElementsInMemory());
                    case 3:
                        return Short.valueOf(this.b.getSizeOfElements());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i9 = 4;
        return GenericRecordUtil.getGenericProperties("base", supplier, "numElements", supplier2, "numElementsInMemory", supplier3, "sizeOfElements", supplier4, "elements", new Supplier(this) { // from class: org.apache.poi.ddf.c
            public final /* synthetic */ EscherArrayProperty b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Integer.valueOf(this.b.getNumberOfElementsInArray());
                    case 2:
                        return Integer.valueOf(this.b.getNumberOfElementsInMemory());
                    case 3:
                        return Short.valueOf(this.b.getSizeOfElements());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    public int getNumberOfElementsInArray() {
        if (this.emptyComplexPart) {
            return 0;
        }
        return LittleEndian.getUShort(getComplexData(), 0);
    }

    public int getNumberOfElementsInMemory() {
        if (this.emptyComplexPart) {
            return 0;
        }
        return LittleEndian.getUShort(getComplexData(), 2);
    }

    public short getSizeOfElements() {
        if (this.emptyComplexPart) {
            return (short) 0;
        }
        return LittleEndian.getShort(getComplexData(), 4);
    }

    @Override // java.lang.Iterable
    public Iterator<byte[]> iterator() {
        return new Iterator<byte[]>() { // from class: org.apache.poi.ddf.EscherArrayProperty.1
            int idx;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.idx < EscherArrayProperty.this.getNumberOfElementsInArray();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("not yet implemented");
            }

            @Override // java.util.Iterator
            public byte[] next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                EscherArrayProperty escherArrayProperty = EscherArrayProperty.this;
                int i5 = this.idx;
                this.idx = i5 + 1;
                return escherArrayProperty.getElement(i5);
            }
        };
    }

    @Override // org.apache.poi.ddf.EscherComplexProperty, org.apache.poi.ddf.EscherProperty
    public int serializeSimplePart(byte[] bArr, int i5) {
        LittleEndian.putShort(bArr, i5, getId());
        int length = getComplexData().length;
        if (!this.sizeIncludesHeaderSize) {
            length -= 6;
        }
        LittleEndian.putInt(bArr, i5 + 2, length);
        return 6;
    }

    public int setArrayData(byte[] bArr, int i5) {
        if (this.emptyComplexPart) {
            resizeComplexData(0);
        } else {
            short s6 = LittleEndian.getShort(bArr, i5);
            short s7 = LittleEndian.getShort(bArr, i5 + 4);
            int length = getComplexData().length;
            int actualSizeOfElements = getActualSizeOfElements(s7) * s6;
            if (actualSizeOfElements == length) {
                resizeComplexData(actualSizeOfElements + 6, 0);
                this.sizeIncludesHeaderSize = false;
            }
            setComplexData(bArr, i5);
        }
        return getComplexData().length;
    }

    public void setElement(int i5, byte[] bArr) {
        if (this.emptyComplexPart) {
            return;
        }
        int actualSizeOfElements = getActualSizeOfElements(getSizeOfElements());
        System.arraycopy(bArr, 0, getComplexData(), (i5 * actualSizeOfElements) + 6, actualSizeOfElements);
    }

    public void setNumberOfElementsInArray(int i5) {
        if (this.emptyComplexPart) {
            return;
        }
        rewriteArray(i5, false);
        LittleEndian.putShort(getComplexData(), 0, (short) i5);
    }

    public void setNumberOfElementsInMemory(int i5) {
        if (this.emptyComplexPart) {
            return;
        }
        rewriteArray(i5, true);
        LittleEndian.putShort(getComplexData(), 2, (short) i5);
    }

    public void setSizeOfElements(int i5) {
        if (this.emptyComplexPart) {
            return;
        }
        LittleEndian.putShort(getComplexData(), 4, (short) i5);
        resizeComplexData((getNumberOfElementsInArray() * getActualSizeOfElements(getSizeOfElements())) + 6, 6);
    }

    @Override // java.lang.Iterable
    public Spliterator<byte[]> spliterator() {
        return Spliterators.spliterator(iterator(), getNumberOfElementsInArray(), 0);
    }

    @Removal(version = "5.0.0")
    @Deprecated
    public EscherArrayProperty(short s6, boolean z6, byte[] bArr) {
        this((short) (s6 | (z6 ? Shorts.MAX_POWER_OF_TWO : (short) 0)), safeSize(bArr != null ? bArr.length : 0));
        setComplexData(bArr);
    }

    public EscherArrayProperty(EscherPropertyTypes escherPropertyTypes, boolean z6, int i5) {
        this((short) (escherPropertyTypes.propNumber | (z6 ? Shorts.MAX_POWER_OF_TWO : (short) 0)), safeSize(i5));
    }
}
