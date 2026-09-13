package org.apache.poi.hpsf;

import androidx.exifinterface.media.a;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class Array {
    private static final int DEFAULT_MAX_NUMBER_OF_ARRAY_SCALARS = 100000;
    private static int MAX_NUMBER_OF_ARRAY_SCALARS = 100000;
    private final ArrayHeader _header = new ArrayHeader();
    private TypedPropertyValue[] _values;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ArrayDimension {
        private int _indexOffset;
        private long _size;

        public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
            this._size = littleEndianByteArrayInputStream.readUInt();
            this._indexOffset = littleEndianByteArrayInputStream.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ArrayHeader {
        private ArrayDimension[] _dimensions;
        private int _type;

        public long getNumberOfScalarValues() {
            long j6 = 1;
            for (ArrayDimension arrayDimension : this._dimensions) {
                j6 *= arrayDimension._size;
            }
            return j6;
        }

        public int getType() {
            return this._type;
        }

        public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
            this._type = littleEndianByteArrayInputStream.readInt();
            long uInt = littleEndianByteArrayInputStream.readUInt();
            if (1 > uInt || uInt > 31) {
                throw new IllegalPropertySetDataException(a.k("Array dimension number ", uInt, " is not in [1; 31] range"));
            }
            int i5 = (int) uInt;
            this._dimensions = new ArrayDimension[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                ArrayDimension arrayDimension = new ArrayDimension();
                arrayDimension.read(littleEndianByteArrayInputStream);
                this._dimensions[i6] = arrayDimension;
            }
        }
    }

    public static int getMaxNumberOfArrayScalars() {
        return MAX_NUMBER_OF_ARRAY_SCALARS;
    }

    public static void setMaxNumberOfArrayScalars(int i5) {
        MAX_NUMBER_OF_ARRAY_SCALARS = i5;
    }

    public TypedPropertyValue[] getValues() {
        return this._values;
    }

    public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        this._header.read(littleEndianByteArrayInputStream);
        long numberOfScalarValues = this._header.getNumberOfScalarValues();
        if (numberOfScalarValues > 2147483647L) {
            throw new UnsupportedOperationException(a.k("Sorry, but POI can't store array of properties with size of ", numberOfScalarValues, " in memory"));
        }
        int i5 = (int) numberOfScalarValues;
        IOUtils.safelyAllocateCheck(i5, getMaxNumberOfArrayScalars());
        this._values = new TypedPropertyValue[i5];
        int i6 = this._header._type == 12 ? 0 : this._header._type;
        for (int i7 = 0; i7 < i5; i7++) {
            TypedPropertyValue typedPropertyValue = new TypedPropertyValue(i6, null);
            typedPropertyValue.read(littleEndianByteArrayInputStream);
            this._values[i7] = typedPropertyValue;
            if (i6 != 0) {
                TypedPropertyValue.skipPadding(littleEndianByteArrayInputStream);
            }
        }
    }
}
