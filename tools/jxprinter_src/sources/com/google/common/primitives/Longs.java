package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
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
@GwtCompatible
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AsciiDigits {
        private static final byte[] asciiDigits;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i5 = 0; i5 < 10; i5++) {
                bArr[i5 + 48] = (byte) i5;
            }
            for (int i6 = 0; i6 < 26; i6++) {
                byte b = (byte) (i6 + 10);
                bArr[i6 + 65] = b;
                bArr[i6 + 97] = b;
            }
            asciiDigits = bArr;
        }

        private AsciiDigits() {
        }

        public static int digit(char c) {
            if (c < 128) {
                return asciiDigits[c];
            }
            return -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int iMin = Math.min(jArr.length, jArr2.length);
            for (int i5 = 0; i5 < iMin; i5++) {
                int iCompare = Longs.compare(jArr[i5], jArr2[i5]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @GwtCompatible
    public static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        public LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Long) && Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i5 = 0; i5 < size; i5++) {
                if (this.array[this.start + i5] != longArrayAsList.array[longArrayAsList.start + i5]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode = 1;
            for (int i5 = this.start; i5 < this.end; i5++) {
                iHashCode = (iHashCode * 31) + Longs.hashCode(this.array[i5]);
            }
            return iHashCode;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iIndexOf;
            if (!(obj instanceof Long) || (iIndexOf = Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Long) || (iLastIndexOf = Longs.lastIndexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iLastIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i5, int i6) {
            Preconditions.checkPositionIndexes(i5, i6, size());
            if (i5 == i6) {
                return Collections.EMPTY_LIST;
            }
            long[] jArr = this.array;
            int i7 = this.start;
            return new LongArrayAsList(jArr, i5 + i7, i7 + i6);
        }

        public long[] toLongArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
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

        public LongArrayAsList(long[] jArr, int i5, int i6) {
            this.array = jArr;
            this.start = i5;
            this.end = i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int i5) {
            Preconditions.checkElementIndex(i5, size());
            return Long.valueOf(this.array[this.start + i5]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Long set(int i5, Long l6) {
            Preconditions.checkElementIndex(i5, size());
            long[] jArr = this.array;
            int i6 = this.start;
            long j6 = jArr[i6 + i5];
            jArr[i6 + i5] = ((Long) Preconditions.checkNotNull(l6)).longValue();
            return Long.valueOf(j6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class LongConverter extends Converter<String, Long> implements Serializable {
        static final LongConverter INSTANCE = new LongConverter();
        private static final long serialVersionUID = 1;

        private LongConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Longs.stringConverter()";
        }

        @Override // com.google.common.base.Converter
        public String doBackward(Long l6) {
            return l6.toString();
        }

        @Override // com.google.common.base.Converter
        public Long doForward(String str) {
            return Long.decode(str);
        }
    }

    private Longs() {
    }

    public static List<Long> asList(long... jArr) {
        return jArr.length == 0 ? Collections.EMPTY_LIST : new LongArrayAsList(jArr);
    }

    public static int compare(long j6, long j7) {
        if (j6 < j7) {
            return -1;
        }
        return j6 > j7 ? 1 : 0;
    }

    public static long[] concat(long[]... jArr) {
        int length = 0;
        for (long[] jArr2 : jArr) {
            length += jArr2.length;
        }
        long[] jArr3 = new long[length];
        int length2 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, length2, jArr4.length);
            length2 += jArr4.length;
        }
        return jArr3;
    }

    @Beta
    public static long constrainToRange(long j6, long j7, long j8) {
        Preconditions.checkArgument(j7 <= j8, "min (%s) must be less than or equal to max (%s)", j7, j8);
        return Math.min(Math.max(j6, j7), j8);
    }

    public static boolean contains(long[] jArr, long j6) {
        for (long j7 : jArr) {
            if (j7 == j6) {
                return true;
            }
        }
        return false;
    }

    public static long[] ensureCapacity(long[] jArr, int i5, int i6) {
        Preconditions.checkArgument(i5 >= 0, "Invalid minLength: %s", i5);
        Preconditions.checkArgument(i6 >= 0, "Invalid padding: %s", i6);
        return jArr.length < i5 ? Arrays.copyOf(jArr, i5 + i6) : jArr;
    }

    public static long fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 8, "array too small: %s < %s", bArr.length, 8);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long fromBytes(byte b, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, byte b12) {
        return ((((long) b6) & 255) << 48) | ((((long) b) & 255) << 56) | ((((long) b7) & 255) << 40) | ((((long) b8) & 255) << 32) | ((((long) b9) & 255) << 24) | ((((long) b10) & 255) << 16) | ((((long) b11) & 255) << 8) | (((long) b12) & 255);
    }

    public static int hashCode(long j6) {
        return (int) (j6 ^ (j6 >>> 32));
    }

    public static int indexOf(long[] jArr, long j6) {
        return indexOf(jArr, j6, 0, jArr.length);
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 10);
        sb.append(jArr[0]);
        for (int i5 = 1; i5 < jArr.length; i5++) {
            sb.append(str);
            sb.append(jArr[i5]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(long[] jArr, long j6) {
        return lastIndexOf(jArr, j6, 0, jArr.length);
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j6 = jArr[0];
        for (int i5 = 1; i5 < jArr.length; i5++) {
            long j7 = jArr[i5];
            if (j7 > j6) {
                j6 = j7;
            }
        }
        return j6;
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j6 = jArr[0];
        for (int i5 = 1; i5 < jArr.length; i5++) {
            long j7 = jArr[i5];
            if (j7 < j6) {
                j6 = j7;
            }
        }
        return j6;
    }

    public static void reverse(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        reverse(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    @Beta
    public static Converter<String, Long> stringConverter() {
        return LongConverter.INSTANCE;
    }

    public static long[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            return ((LongArrayAsList) collection).toLongArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            jArr[i5] = ((Number) Preconditions.checkNotNull(array[i5])).longValue();
        }
        return jArr;
    }

    public static byte[] toByteArray(long j6) {
        byte[] bArr = new byte[8];
        for (int i5 = 7; i5 >= 0; i5--) {
            bArr[i5] = (byte) (255 & j6);
            j6 >>= 8;
        }
        return bArr;
    }

    @Beta
    public static Long tryParse(String str) {
        return tryParse(str, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(long[] jArr, long j6, int i5, int i6) {
        while (i5 < i6) {
            if (jArr[i5] == j6) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(long[] jArr, long j6, int i5, int i6) {
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            if (jArr[i7] == j6) {
                return i7;
            }
        }
        return -1;
    }

    @Beta
    public static Long tryParse(String str, int i5) {
        if (((String) Preconditions.checkNotNull(str)).isEmpty()) {
            return null;
        }
        if (i5 < 2 || i5 > 36) {
            throw new IllegalArgumentException(a.h(65, i5, "radix must be between MIN_RADIX and MAX_RADIX but was "));
        }
        int i6 = str.charAt(0) == '-' ? 1 : 0;
        if (i6 == str.length()) {
            return null;
        }
        int i7 = i6 + 1;
        int iDigit = AsciiDigits.digit(str.charAt(i6));
        if (iDigit < 0 || iDigit >= i5) {
            return null;
        }
        long j6 = -iDigit;
        long j7 = i5;
        long j8 = Long.MIN_VALUE / j7;
        while (i7 < str.length()) {
            int i8 = i7 + 1;
            int iDigit2 = AsciiDigits.digit(str.charAt(i7));
            if (iDigit2 < 0 || iDigit2 >= i5 || j6 < j8) {
                return null;
            }
            long j9 = j6 * j7;
            long j10 = iDigit2;
            if (j9 < j10 - Long.MIN_VALUE) {
                return null;
            }
            j6 = j9 - j10;
            i7 = i8;
        }
        if (i6 != 0) {
            return Long.valueOf(j6);
        }
        if (j6 == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j6);
    }

    public static int indexOf(long[] jArr, long[] jArr2) {
        Preconditions.checkNotNull(jArr, "array");
        Preconditions.checkNotNull(jArr2, TypedValues.AttributesType.S_TARGET);
        if (jArr2.length == 0) {
            return 0;
        }
        for (int i5 = 0; i5 < (jArr.length - jArr2.length) + 1; i5++) {
            for (int i6 = 0; i6 < jArr2.length; i6++) {
                if (jArr[i5 + i6] != jArr2[i6]) {
                }
            }
            return i5;
        }
        return -1;
    }

    public static void reverse(long[] jArr, int i5, int i6) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i5, i6, jArr.length);
        for (int i7 = i6 - 1; i5 < i7; i7--) {
            long j6 = jArr[i5];
            jArr[i5] = jArr[i7];
            jArr[i7] = j6;
            i5++;
        }
    }

    public static void sortDescending(long[] jArr, int i5, int i6) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i5, i6, jArr.length);
        Arrays.sort(jArr, i5, i6);
        reverse(jArr, i5, i6);
    }
}
