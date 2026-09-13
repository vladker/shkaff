package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
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
public final class Booleans {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @GwtCompatible
    public static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final boolean[] array;
        final int end;
        final int start;

        public BooleanArrayAsList(boolean[] zArr) {
            this(zArr, 0, zArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Boolean) && Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BooleanArrayAsList)) {
                return super.equals(obj);
            }
            BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList) obj;
            int size = size();
            if (booleanArrayAsList.size() != size) {
                return false;
            }
            for (int i5 = 0; i5 < size; i5++) {
                if (this.array[this.start + i5] != booleanArrayAsList.array[booleanArrayAsList.start + i5]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode = 1;
            for (int i5 = this.start; i5 < this.end; i5++) {
                iHashCode = (iHashCode * 31) + Booleans.hashCode(this.array[i5]);
            }
            return iHashCode;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iIndexOf;
            if (!(obj instanceof Boolean) || (iIndexOf = Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Boolean) || (iLastIndexOf = Booleans.lastIndexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iLastIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Boolean> subList(int i5, int i6) {
            Preconditions.checkPositionIndexes(i5, i6, size());
            if (i5 == i6) {
                return Collections.EMPTY_LIST;
            }
            boolean[] zArr = this.array;
            int i7 = this.start;
            return new BooleanArrayAsList(zArr, i5 + i7, i7 + i6);
        }

        public boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 7);
            sb.append(this.array[this.start] ? "[true" : "[false");
            int i5 = this.start;
            while (true) {
                i5++;
                if (i5 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(this.array[i5] ? ", true" : ", false");
            }
        }

        public BooleanArrayAsList(boolean[] zArr, int i5, int i6) {
            this.array = zArr;
            this.start = i5;
            this.end = i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public Boolean get(int i5) {
            Preconditions.checkElementIndex(i5, size());
            return Boolean.valueOf(this.array[this.start + i5]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Boolean set(int i5, Boolean bool) {
            Preconditions.checkElementIndex(i5, size());
            boolean[] zArr = this.array;
            int i6 = this.start;
            boolean z6 = zArr[i6 + i5];
            zArr[i6 + i5] = ((Boolean) Preconditions.checkNotNull(bool)).booleanValue();
            return Boolean.valueOf(z6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");

        private final String toString;
        private final int trueValue;

        BooleanComparator(int i5, String str) {
            this.trueValue = i5;
            this.toString = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.toString;
        }

        @Override // java.util.Comparator
        public int compare(Boolean bool, Boolean bool2) {
            return (bool2.booleanValue() ? this.trueValue : 0) - (bool.booleanValue() ? this.trueValue : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(boolean[] zArr, boolean[] zArr2) {
            int iMin = Math.min(zArr.length, zArr2.length);
            for (int i5 = 0; i5 < iMin; i5++) {
                int iCompare = Booleans.compare(zArr[i5], zArr2[i5]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return zArr.length - zArr2.length;
        }
    }

    private Booleans() {
    }

    public static List<Boolean> asList(boolean... zArr) {
        return zArr.length == 0 ? Collections.EMPTY_LIST : new BooleanArrayAsList(zArr);
    }

    public static int compare(boolean z6, boolean z7) {
        if (z6 == z7) {
            return 0;
        }
        return z6 ? 1 : -1;
    }

    public static boolean[] concat(boolean[]... zArr) {
        int length = 0;
        for (boolean[] zArr2 : zArr) {
            length += zArr2.length;
        }
        boolean[] zArr3 = new boolean[length];
        int length2 = 0;
        for (boolean[] zArr4 : zArr) {
            System.arraycopy(zArr4, 0, zArr3, length2, zArr4.length);
            length2 += zArr4.length;
        }
        return zArr3;
    }

    public static boolean contains(boolean[] zArr, boolean z6) {
        for (boolean z7 : zArr) {
            if (z7 == z6) {
                return true;
            }
        }
        return false;
    }

    @Beta
    public static int countTrue(boolean... zArr) {
        int i5 = 0;
        for (boolean z6 : zArr) {
            if (z6) {
                i5++;
            }
        }
        return i5;
    }

    public static boolean[] ensureCapacity(boolean[] zArr, int i5, int i6) {
        Preconditions.checkArgument(i5 >= 0, "Invalid minLength: %s", i5);
        Preconditions.checkArgument(i6 >= 0, "Invalid padding: %s", i6);
        return zArr.length < i5 ? Arrays.copyOf(zArr, i5 + i6) : zArr;
    }

    @Beta
    public static Comparator<Boolean> falseFirst() {
        return BooleanComparator.FALSE_FIRST;
    }

    public static int hashCode(boolean z6) {
        return z6 ? 1231 : 1237;
    }

    public static int indexOf(boolean[] zArr, boolean z6) {
        return indexOf(zArr, z6, 0, zArr.length);
    }

    public static String join(String str, boolean... zArr) {
        Preconditions.checkNotNull(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append(zArr[0]);
        for (int i5 = 1; i5 < zArr.length; i5++) {
            sb.append(str);
            sb.append(zArr[i5]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(boolean[] zArr, boolean z6) {
        return lastIndexOf(zArr, z6, 0, zArr.length);
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static void reverse(boolean[] zArr) {
        Preconditions.checkNotNull(zArr);
        reverse(zArr, 0, zArr.length);
    }

    public static boolean[] toArray(Collection<Boolean> collection) {
        if (collection instanceof BooleanArrayAsList) {
            return ((BooleanArrayAsList) collection).toBooleanArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i5 = 0; i5 < length; i5++) {
            zArr[i5] = ((Boolean) Preconditions.checkNotNull(array[i5])).booleanValue();
        }
        return zArr;
    }

    @Beta
    public static Comparator<Boolean> trueFirst() {
        return BooleanComparator.TRUE_FIRST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(boolean[] zArr, boolean z6, int i5, int i6) {
        while (i5 < i6) {
            if (zArr[i5] == z6) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(boolean[] zArr, boolean z6, int i5, int i6) {
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            if (zArr[i7] == z6) {
                return i7;
            }
        }
        return -1;
    }

    public static int indexOf(boolean[] zArr, boolean[] zArr2) {
        Preconditions.checkNotNull(zArr, "array");
        Preconditions.checkNotNull(zArr2, TypedValues.AttributesType.S_TARGET);
        if (zArr2.length == 0) {
            return 0;
        }
        for (int i5 = 0; i5 < (zArr.length - zArr2.length) + 1; i5++) {
            for (int i6 = 0; i6 < zArr2.length; i6++) {
                if (zArr[i5 + i6] != zArr2[i6]) {
                }
            }
            return i5;
        }
        return -1;
    }

    public static void reverse(boolean[] zArr, int i5, int i6) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i5, i6, zArr.length);
        for (int i7 = i6 - 1; i5 < i7; i7--) {
            boolean z6 = zArr[i5];
            zArr[i5] = zArr[i7];
            zArr[i7] = z6;
            i5++;
        }
    }
}
