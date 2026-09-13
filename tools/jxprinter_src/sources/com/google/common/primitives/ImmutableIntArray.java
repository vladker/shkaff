package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@Immutable
@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class ImmutableIntArray implements Serializable {
    private static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    private final int[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray parent;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i5 = this.parent.start;
            for (Object obj2 : list) {
                if (obj2 instanceof Integer) {
                    int i6 = i5 + 1;
                    if (this.parent.array[i5] == ((Integer) obj2).intValue()) {
                        i5 = i6;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i5, int i6) {
            return this.parent.subArray(i5, i6).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i5) {
            return Integer.valueOf(this.parent.get(i5));
        }
    }

    public static Builder builder(int i5) {
        Preconditions.checkArgument(i5 >= 0, "Invalid initialCapacity: %s", i5);
        return new Builder(i5);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public List<Integer> asList() {
        return new AsList();
    }

    public boolean contains(int i5) {
        return indexOf(i5) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i5 = 0; i5 < length(); i5++) {
            if (get(i5) != immutableIntArray.get(i5)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i5) {
        Preconditions.checkElementIndex(i5, length());
        return this.array[this.start + i5];
    }

    public int hashCode() {
        int iHashCode = 1;
        for (int i5 = this.start; i5 < this.end; i5++) {
            iHashCode = (iHashCode * 31) + Ints.hashCode(this.array[i5]);
        }
        return iHashCode;
    }

    public int indexOf(int i5) {
        for (int i6 = this.start; i6 < this.end; i6++) {
            if (this.array[i6] == i5) {
                return i6 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i5) {
        int i6;
        int i7 = this.end;
        do {
            i7--;
            i6 = this.start;
            if (i7 < i6) {
                return -1;
            }
        } while (this.array[i7] != i5);
        return i7 - i6;
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableIntArray subArray(int i5, int i6) {
        Preconditions.checkPositionIndexes(i5, i6, length());
        if (i5 == i6) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i7 = this.start;
        return new ImmutableIntArray(iArr, i5 + i7, i7 + i6);
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(length() * 5);
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

    public ImmutableIntArray trimmed() {
        return isPartialView() ? new ImmutableIntArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(Ints.toArray(collection));
    }

    public static ImmutableIntArray of(int i5) {
        return new ImmutableIntArray(new int[]{i5});
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @CanIgnoreReturnValue
    public static final class Builder {
        private int[] array;
        private int count = 0;

        public Builder(int i5) {
            this.array = new int[i5];
        }

        private void ensureRoomFor(int i5) {
            int i6 = this.count + i5;
            int[] iArr = this.array;
            if (i6 > iArr.length) {
                this.array = Arrays.copyOf(iArr, expandedCapacity(iArr.length, i6));
            }
        }

        private static int expandedCapacity(int i5, int i6) {
            if (i6 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i5 + (i5 >> 1) + 1;
            if (iHighestOneBit < i6) {
                iHighestOneBit = Integer.highestOneBit(i6 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        public Builder add(int i5) {
            ensureRoomFor(1);
            int[] iArr = this.array;
            int i6 = this.count;
            iArr[i6] = i5;
            this.count = i6 + 1;
            return this;
        }

        public Builder addAll(int[] iArr) {
            ensureRoomFor(iArr.length);
            System.arraycopy(iArr, 0, this.array, this.count, iArr.length);
            this.count += iArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableIntArray build() {
            if (this.count == 0) {
                return ImmutableIntArray.EMPTY;
            }
            return new ImmutableIntArray(this.array, 0, this.count);
        }

        public Builder addAll(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Integer>) iterable);
            }
            Iterator<Integer> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().intValue());
            }
            return this;
        }

        public Builder addAll(Collection<Integer> collection) {
            ensureRoomFor(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.array;
                int i5 = this.count;
                this.count = i5 + 1;
                iArr[i5] = num.intValue();
            }
            return this;
        }

        public Builder addAll(ImmutableIntArray immutableIntArray) {
            ensureRoomFor(immutableIntArray.length());
            System.arraycopy(immutableIntArray.array, immutableIntArray.start, this.array, this.count, immutableIntArray.length());
            this.count = immutableIntArray.length() + this.count;
            return this;
        }
    }

    private ImmutableIntArray(int[] iArr, int i5, int i6) {
        this.array = iArr;
        this.start = i5;
        this.end = i6;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) iterable);
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableIntArray of(int i5, int i6) {
        return new ImmutableIntArray(new int[]{i5, i6});
    }

    public static ImmutableIntArray of(int i5, int i6, int i7) {
        return new ImmutableIntArray(new int[]{i5, i6, i7});
    }

    public static ImmutableIntArray of(int i5, int i6, int i7, int i8) {
        return new ImmutableIntArray(new int[]{i5, i6, i7, i8});
    }

    public static ImmutableIntArray of(int i5, int i6, int i7, int i8, int i9) {
        return new ImmutableIntArray(new int[]{i5, i6, i7, i8, i9});
    }

    public static ImmutableIntArray of(int i5, int i6, int i7, int i8, int i9, int i10) {
        return new ImmutableIntArray(new int[]{i5, i6, i7, i8, i9, i10});
    }

    public static ImmutableIntArray of(int i5, int... iArr) {
        Preconditions.checkArgument(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[0] = i5;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }
}
