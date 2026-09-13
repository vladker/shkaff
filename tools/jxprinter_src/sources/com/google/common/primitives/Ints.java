package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
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

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class Ints extends IntsMethodsForWeb {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @GwtCompatible
    public static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        public IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.indexOf(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i5 = 0; i5 < size; i5++) {
                if (this.array[this.start + i5] != intArrayAsList.array[intArrayAsList.start + i5]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode = 1;
            for (int i5 = this.start; i5 < this.end; i5++) {
                iHashCode = (iHashCode * 31) + Ints.hashCode(this.array[i5]);
            }
            return iHashCode;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iIndexOf;
            if (!(obj instanceof Integer) || (iIndexOf = Ints.indexOf(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Integer) || (iLastIndexOf = Ints.lastIndexOf(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iLastIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i5, int i6) {
            Preconditions.checkPositionIndexes(i5, i6, size());
            if (i5 == i6) {
                return Collections.EMPTY_LIST;
            }
            int[] iArr = this.array;
            int i7 = this.start;
            return new IntArrayAsList(iArr, i5 + i7, i7 + i6);
        }

        public int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i5 = this.start;
            while (true) {
                i5++;
                if (i5 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.array[i5]);
            }
        }

        public IntArrayAsList(int[] iArr, int i5, int i6) {
            this.array = iArr;
            this.start = i5;
            this.end = i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i5) {
            Preconditions.checkElementIndex(i5, size());
            return Integer.valueOf(this.array[this.start + i5]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer set(int i5, Integer num) {
            Preconditions.checkElementIndex(i5, size());
            int[] iArr = this.array;
            int i6 = this.start;
            int i7 = iArr[i6 + i5];
            iArr[i6 + i5] = ((Integer) Preconditions.checkNotNull(num)).intValue();
            return Integer.valueOf(i7);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class IntConverter extends Converter<String, Integer> implements Serializable {
        static final IntConverter INSTANCE = new IntConverter();
        private static final long serialVersionUID = 1;

        private IntConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Ints.stringConverter()";
        }

        @Override // com.google.common.base.Converter
        public String doBackward(Integer num) {
            return num.toString();
        }

        @Override // com.google.common.base.Converter
        public Integer doForward(String str) {
            return Integer.decode(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Ints.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int iMin = Math.min(iArr.length, iArr2.length);
            for (int i5 = 0; i5 < iMin; i5++) {
                int iCompare = Ints.compare(iArr[i5], iArr2[i5]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    private Ints() {
    }

    public static List<Integer> asList(int... iArr) {
        return iArr.length == 0 ? Collections.EMPTY_LIST : new IntArrayAsList(iArr);
    }

    public static int checkedCast(long j6) {
        int i5 = (int) j6;
        Preconditions.checkArgument(((long) i5) == j6, "Out of range: %s", j6);
        return i5;
    }

    public static int compare(int i5, int i6) {
        if (i5 < i6) {
            return -1;
        }
        return i5 > i6 ? 1 : 0;
    }

    public static int[] concat(int[]... iArr) {
        int length = 0;
        for (int[] iArr2 : iArr) {
            length += iArr2.length;
        }
        int[] iArr3 = new int[length];
        int length2 = 0;
        for (int[] iArr4 : iArr) {
            System.arraycopy(iArr4, 0, iArr3, length2, iArr4.length);
            length2 += iArr4.length;
        }
        return iArr3;
    }

    @Beta
    public static int constrainToRange(int i5, int i6, int i7) {
        Preconditions.checkArgument(i6 <= i7, "min (%s) must be less than or equal to max (%s)", i6, i7);
        return Math.min(Math.max(i5, i6), i7);
    }

    public static boolean contains(int[] iArr, int i5) {
        for (int i6 : iArr) {
            if (i6 == i5) {
                return true;
            }
        }
        return false;
    }

    public static int[] ensureCapacity(int[] iArr, int i5, int i6) {
        Preconditions.checkArgument(i5 >= 0, "Invalid minLength: %s", i5);
        Preconditions.checkArgument(i6 >= 0, "Invalid padding: %s", i6);
        return iArr.length < i5 ? Arrays.copyOf(iArr, i5 + i6) : iArr;
    }

    public static int fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 4, "array too small: %s < %s", bArr.length, 4);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int fromBytes(byte b, byte b6, byte b7, byte b8) {
        return (b << Ascii.CAN) | ((b6 & UnsignedBytes.MAX_VALUE) << 16) | ((b7 & UnsignedBytes.MAX_VALUE) << 8) | (b8 & UnsignedBytes.MAX_VALUE);
    }

    public static int indexOf(int[] iArr, int i5) {
        return indexOf(iArr, i5, 0, iArr.length);
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(iArr[0]);
        for (int i5 = 1; i5 < iArr.length; i5++) {
            sb.append(str);
            sb.append(iArr[i5]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(int[] iArr, int i5) {
        return lastIndexOf(iArr, i5, 0, iArr.length);
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static int max(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int i5 = iArr[0];
        for (int i6 = 1; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            if (i7 > i5) {
                i5 = i7;
            }
        }
        return i5;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static int min(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int i5 = iArr[0];
        for (int i6 = 1; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            if (i7 < i5) {
                i5 = i7;
            }
        }
        return i5;
    }

    public static void reverse(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        reverse(iArr, 0, iArr.length);
    }

    public static int saturatedCast(long j6) {
        if (j6 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j6 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j6;
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    @Beta
    public static Converter<String, Integer> stringConverter() {
        return IntConverter.INSTANCE;
    }

    public static int[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).toIntArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = ((Number) Preconditions.checkNotNull(array[i5])).intValue();
        }
        return iArr;
    }

    public static byte[] toByteArray(int i5) {
        return new byte[]{(byte) (i5 >> 24), (byte) (i5 >> 16), (byte) (i5 >> 8), (byte) i5};
    }

    @Beta
    public static Integer tryParse(String str) {
        return tryParse(str, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(int[] iArr, int i5, int i6, int i7) {
        while (i6 < i7) {
            if (iArr[i6] == i5) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(int[] iArr, int i5, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            if (iArr[i8] == i5) {
                return i8;
            }
        }
        return -1;
    }

    @Beta
    public static Integer tryParse(String str, int i5) {
        Long lTryParse = Longs.tryParse(str, i5);
        if (lTryParse == null || lTryParse.longValue() != lTryParse.intValue()) {
            return null;
        }
        return Integer.valueOf(lTryParse.intValue());
    }

    public static int indexOf(int[] iArr, int[] iArr2) {
        Preconditions.checkNotNull(iArr, "array");
        Preconditions.checkNotNull(iArr2, TypedValues.AttributesType.S_TARGET);
        if (iArr2.length == 0) {
            return 0;
        }
        for (int i5 = 0; i5 < (iArr.length - iArr2.length) + 1; i5++) {
            for (int i6 = 0; i6 < iArr2.length; i6++) {
                if (iArr[i5 + i6] != iArr2[i6]) {
                }
            }
            return i5;
        }
        return -1;
    }

    public static void reverse(int[] iArr, int i5, int i6) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i5, i6, iArr.length);
        for (int i7 = i6 - 1; i5 < i7; i7--) {
            int i8 = iArr[i5];
            iArr[i5] = iArr[i7];
            iArr[i7] = i8;
            i5++;
        }
    }

    public static void sortDescending(int[] iArr, int i5, int i6) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i5, i6, iArr.length);
        Arrays.sort(iArr, i5, i6);
        reverse(iArr, i5, i6);
    }

    public static int hashCode(int i5) {
        return i5;
    }
}
