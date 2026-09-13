package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
public final class Bytes {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @GwtCompatible
    public static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final byte[] array;
        final int end;
        final int start;

        public ByteArrayAsList(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Byte) && Bytes.indexOf(this.array, ((Byte) obj).byteValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteArrayAsList)) {
                return super.equals(obj);
            }
            ByteArrayAsList byteArrayAsList = (ByteArrayAsList) obj;
            int size = size();
            if (byteArrayAsList.size() != size) {
                return false;
            }
            for (int i5 = 0; i5 < size; i5++) {
                if (this.array[this.start + i5] != byteArrayAsList.array[byteArrayAsList.start + i5]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode = 1;
            for (int i5 = this.start; i5 < this.end; i5++) {
                iHashCode = (iHashCode * 31) + Bytes.hashCode(this.array[i5]);
            }
            return iHashCode;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iIndexOf;
            if (!(obj instanceof Byte) || (iIndexOf = Bytes.indexOf(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Byte) || (iLastIndexOf = Bytes.lastIndexOf(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iLastIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Byte> subList(int i5, int i6) {
            Preconditions.checkPositionIndexes(i5, i6, size());
            if (i5 == i6) {
                return Collections.EMPTY_LIST;
            }
            byte[] bArr = this.array;
            int i7 = this.start;
            return new ByteArrayAsList(bArr, i5 + i7, i7 + i6);
        }

        public byte[] toByteArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
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

        public ByteArrayAsList(byte[] bArr, int i5, int i6) {
            this.array = bArr;
            this.start = i5;
            this.end = i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public Byte get(int i5) {
            Preconditions.checkElementIndex(i5, size());
            return Byte.valueOf(this.array[this.start + i5]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Byte set(int i5, Byte b) {
            Preconditions.checkElementIndex(i5, size());
            byte[] bArr = this.array;
            int i6 = this.start;
            byte b6 = bArr[i6 + i5];
            bArr[i6 + i5] = ((Byte) Preconditions.checkNotNull(b)).byteValue();
            return Byte.valueOf(b6);
        }
    }

    private Bytes() {
    }

    public static List<Byte> asList(byte... bArr) {
        return bArr.length == 0 ? Collections.EMPTY_LIST : new ByteArrayAsList(bArr);
    }

    public static byte[] concat(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    public static boolean contains(byte[] bArr, byte b) {
        for (byte b6 : bArr) {
            if (b6 == b) {
                return true;
            }
        }
        return false;
    }

    public static byte[] ensureCapacity(byte[] bArr, int i5, int i6) {
        Preconditions.checkArgument(i5 >= 0, "Invalid minLength: %s", i5);
        Preconditions.checkArgument(i6 >= 0, "Invalid padding: %s", i6);
        return bArr.length < i5 ? Arrays.copyOf(bArr, i5 + i6) : bArr;
    }

    public static int indexOf(byte[] bArr, byte b) {
        return indexOf(bArr, b, 0, bArr.length);
    }

    public static int lastIndexOf(byte[] bArr, byte b) {
        return lastIndexOf(bArr, b, 0, bArr.length);
    }

    public static void reverse(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        reverse(bArr, 0, bArr.length);
    }

    public static byte[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ByteArrayAsList) {
            return ((ByteArrayAsList) collection).toByteArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr[i5] = ((Number) Preconditions.checkNotNull(array[i5])).byteValue();
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(byte[] bArr, byte b, int i5, int i6) {
        while (i5 < i6) {
            if (bArr[i5] == b) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(byte[] bArr, byte b, int i5, int i6) {
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            if (bArr[i7] == b) {
                return i7;
            }
        }
        return -1;
    }

    public static int indexOf(byte[] bArr, byte[] bArr2) {
        Preconditions.checkNotNull(bArr, "array");
        Preconditions.checkNotNull(bArr2, TypedValues.AttributesType.S_TARGET);
        if (bArr2.length == 0) {
            return 0;
        }
        for (int i5 = 0; i5 < (bArr.length - bArr2.length) + 1; i5++) {
            for (int i6 = 0; i6 < bArr2.length; i6++) {
                if (bArr[i5 + i6] != bArr2[i6]) {
                }
            }
            return i5;
        }
        return -1;
    }

    public static void reverse(byte[] bArr, int i5, int i6) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i5, i6, bArr.length);
        for (int i7 = i6 - 1; i5 < i7; i7--) {
            byte b = bArr[i5];
            bArr[i5] = bArr[i7];
            bArr[i7] = b;
            i5++;
        }
    }

    public static int hashCode(byte b) {
        return b;
    }
}
