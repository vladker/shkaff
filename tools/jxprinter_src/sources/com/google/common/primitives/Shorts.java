package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.apache.poi.ss.usermodel.Font;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class Shorts extends ShortsMethodsForWeb {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(short[] sArr, short[] sArr2) {
            int iMin = Math.min(sArr.length, sArr2.length);
            for (int i5 = 0; i5 < iMin; i5++) {
                int iCompare = Shorts.compare(sArr[i5], sArr2[i5]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return sArr.length - sArr2.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @GwtCompatible
    public static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        public ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Short) && Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i5 = 0; i5 < size; i5++) {
                if (this.array[this.start + i5] != shortArrayAsList.array[shortArrayAsList.start + i5]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode = 1;
            for (int i5 = this.start; i5 < this.end; i5++) {
                iHashCode = (iHashCode * 31) + Shorts.hashCode(this.array[i5]);
            }
            return iHashCode;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iIndexOf;
            if (!(obj instanceof Short) || (iIndexOf = Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iLastIndexOf;
            if (!(obj instanceof Short) || (iLastIndexOf = Shorts.lastIndexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iLastIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int i5, int i6) {
            Preconditions.checkPositionIndexes(i5, i6, size());
            if (i5 == i6) {
                return Collections.EMPTY_LIST;
            }
            short[] sArr = this.array;
            int i7 = this.start;
            return new ShortArrayAsList(sArr, i5 + i7, i7 + i6);
        }

        public short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 6);
            sb.append('[');
            sb.append((int) this.array[this.start]);
            int i5 = this.start;
            while (true) {
                i5++;
                if (i5 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append((int) this.array[i5]);
            }
        }

        public ShortArrayAsList(short[] sArr, int i5, int i6) {
            this.array = sArr;
            this.start = i5;
            this.end = i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public Short get(int i5) {
            Preconditions.checkElementIndex(i5, size());
            return Short.valueOf(this.array[this.start + i5]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Short set(int i5, Short sh) {
            Preconditions.checkElementIndex(i5, size());
            short[] sArr = this.array;
            int i6 = this.start;
            short s6 = sArr[i6 + i5];
            sArr[i6 + i5] = ((Short) Preconditions.checkNotNull(sh)).shortValue();
            return Short.valueOf(s6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ShortConverter extends Converter<String, Short> implements Serializable {
        static final ShortConverter INSTANCE = new ShortConverter();
        private static final long serialVersionUID = 1;

        private ShortConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }

        @Override // com.google.common.base.Converter
        public String doBackward(Short sh) {
            return sh.toString();
        }

        @Override // com.google.common.base.Converter
        public Short doForward(String str) {
            return Short.decode(str);
        }
    }

    private Shorts() {
    }

    public static List<Short> asList(short... sArr) {
        return sArr.length == 0 ? Collections.EMPTY_LIST : new ShortArrayAsList(sArr);
    }

    public static short checkedCast(long j6) {
        short s6 = (short) j6;
        Preconditions.checkArgument(((long) s6) == j6, "Out of range: %s", j6);
        return s6;
    }

    public static int compare(short s6, short s7) {
        return s6 - s7;
    }

    public static short[] concat(short[]... sArr) {
        int length = 0;
        for (short[] sArr2 : sArr) {
            length += sArr2.length;
        }
        short[] sArr3 = new short[length];
        int length2 = 0;
        for (short[] sArr4 : sArr) {
            System.arraycopy(sArr4, 0, sArr3, length2, sArr4.length);
            length2 += sArr4.length;
        }
        return sArr3;
    }

    @Beta
    public static short constrainToRange(short s6, short s7, short s8) {
        Preconditions.checkArgument(s7 <= s8, "min (%s) must be less than or equal to max (%s)", (int) s7, (int) s8);
        if (s6 < s7) {
            return s7;
        }
        return s6 < s8 ? s6 : s8;
    }

    public static boolean contains(short[] sArr, short s6) {
        for (short s7 : sArr) {
            if (s7 == s6) {
                return true;
            }
        }
        return false;
    }

    public static short[] ensureCapacity(short[] sArr, int i5, int i6) {
        Preconditions.checkArgument(i5 >= 0, "Invalid minLength: %s", i5);
        Preconditions.checkArgument(i6 >= 0, "Invalid padding: %s", i6);
        return sArr.length < i5 ? Arrays.copyOf(sArr, i5 + i6) : sArr;
    }

    @GwtIncompatible
    public static short fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static short fromBytes(byte b, byte b6) {
        return (short) ((b << 8) | (b6 & UnsignedBytes.MAX_VALUE));
    }

    public static int indexOf(short[] sArr, short s6) {
        return indexOf(sArr, s6, 0, sArr.length);
    }

    public static String join(String str, short... sArr) {
        Preconditions.checkNotNull(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(sArr.length * 6);
        sb.append((int) sArr[0]);
        for (int i5 = 1; i5 < sArr.length; i5++) {
            sb.append(str);
            sb.append((int) sArr[i5]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(short[] sArr, short s6) {
        return lastIndexOf(sArr, s6, 0, sArr.length);
    }

    public static Comparator<short[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short max(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s6 = sArr[0];
        for (int i5 = 1; i5 < sArr.length; i5++) {
            short s7 = sArr[i5];
            if (s7 > s6) {
                s6 = s7;
            }
        }
        return s6;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short min(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s6 = sArr[0];
        for (int i5 = 1; i5 < sArr.length; i5++) {
            short s7 = sArr[i5];
            if (s7 < s6) {
                s6 = s7;
            }
        }
        return s6;
    }

    public static void reverse(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        reverse(sArr, 0, sArr.length);
    }

    public static short saturatedCast(long j6) {
        if (j6 > 32767) {
            return Font.COLOR_NORMAL;
        }
        if (j6 < -32768) {
            return Short.MIN_VALUE;
        }
        return (short) j6;
    }

    public static void sortDescending(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        sortDescending(sArr, 0, sArr.length);
    }

    @Beta
    public static Converter<String, Short> stringConverter() {
        return ShortConverter.INSTANCE;
    }

    public static short[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ShortArrayAsList) {
            return ((ShortArrayAsList) collection).toShortArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i5 = 0; i5 < length; i5++) {
            sArr[i5] = ((Number) Preconditions.checkNotNull(array[i5])).shortValue();
        }
        return sArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(short s6) {
        return new byte[]{(byte) (s6 >> 8), (byte) s6};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(short[] sArr, short s6, int i5, int i6) {
        while (i5 < i6) {
            if (sArr[i5] == s6) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(short[] sArr, short s6, int i5, int i6) {
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            if (sArr[i7] == s6) {
                return i7;
            }
        }
        return -1;
    }

    public static int indexOf(short[] sArr, short[] sArr2) {
        Preconditions.checkNotNull(sArr, "array");
        Preconditions.checkNotNull(sArr2, TypedValues.AttributesType.S_TARGET);
        if (sArr2.length == 0) {
            return 0;
        }
        for (int i5 = 0; i5 < (sArr.length - sArr2.length) + 1; i5++) {
            for (int i6 = 0; i6 < sArr2.length; i6++) {
                if (sArr[i5 + i6] != sArr2[i6]) {
                }
            }
            return i5;
        }
        return -1;
    }

    public static void reverse(short[] sArr, int i5, int i6) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i5, i6, sArr.length);
        for (int i7 = i6 - 1; i5 < i7; i7--) {
            short s6 = sArr[i5];
            sArr[i5] = sArr[i7];
            sArr[i7] = s6;
            i5++;
        }
    }

    public static void sortDescending(short[] sArr, int i5, int i6) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i5, i6, sArr.length);
        Arrays.sort(sArr, i5, i6);
        reverse(sArr, i5, i6);
    }

    public static int hashCode(short s6) {
        return s6;
    }
}
