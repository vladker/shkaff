package org.apache.poi.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IntList {
    private static final int _default_size = 128;
    private int[] _array;
    private int _limit;

    public IntList() {
        this(128);
    }

    private void growArray(int i5) {
        int[] iArr = this._array;
        if (i5 == iArr.length) {
            i5++;
        }
        int[] iArr2 = new int[i5];
        System.arraycopy(iArr, 0, iArr2, 0, this._limit);
        this._array = iArr2;
    }

    public void add(int i5, int i6) {
        int i7 = this._limit;
        if (i5 > i7) {
            throw new IndexOutOfBoundsException();
        }
        if (i5 == i7) {
            add(i6);
            return;
        }
        if (i7 == this._array.length) {
            growArray(i7 * 2);
        }
        int[] iArr = this._array;
        System.arraycopy(iArr, i5, iArr, i5 + 1, this._limit - i5);
        this._array[i5] = i6;
        this._limit++;
    }

    public boolean addAll(IntList intList) {
        int i5 = intList._limit;
        if (i5 == 0) {
            return true;
        }
        int i6 = this._limit;
        if (i6 + i5 > this._array.length) {
            growArray(i6 + i5);
        }
        System.arraycopy(intList._array, 0, this._array, this._limit, intList._limit);
        this._limit += intList._limit;
        return true;
    }

    public void clear() {
        this._limit = 0;
    }

    public boolean contains(int i5) {
        for (int i6 = 0; i6 < this._limit; i6++) {
            if (this._array[i6] == i5) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(IntList intList) {
        if (this == intList) {
            return true;
        }
        for (int i5 = 0; i5 < intList._limit; i5++) {
            if (!contains(intList._array[i5])) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntList)) {
            return false;
        }
        IntList intList = (IntList) obj;
        if (intList._limit != this._limit) {
            return false;
        }
        for (int i5 = 0; i5 < this._limit; i5++) {
            if (intList._array[i5] != this._array[i5]) {
                return false;
            }
        }
        return true;
    }

    public int get(int i5) {
        if (i5 < this._limit) {
            return this._array[i5];
        }
        throw new IndexOutOfBoundsException(i5 + " not accessible in a list of length " + this._limit);
    }

    public int hashCode() {
        int i5 = 0;
        for (int i6 = 0; i6 < this._limit; i6++) {
            i5 = (i5 * 31) + this._array[i6];
        }
        return i5;
    }

    public int indexOf(int i5) {
        for (int i6 = 0; i6 < this._limit; i6++) {
            if (this._array[i6] == i5) {
                return i6;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this._limit == 0;
    }

    public int lastIndexOf(int i5) {
        for (int i6 = this._limit - 1; i6 >= 0; i6--) {
            if (this._array[i6] == i5) {
                return i6;
            }
        }
        return -1;
    }

    public int remove(int i5) {
        int i6 = this._limit;
        if (i5 >= i6) {
            throw new IndexOutOfBoundsException();
        }
        int[] iArr = this._array;
        int i7 = iArr[i5];
        System.arraycopy(iArr, i5 + 1, iArr, i5, i6 - i5);
        this._limit--;
        return i7;
    }

    public boolean removeAll(IntList intList) {
        boolean z6 = false;
        for (int i5 = 0; i5 < intList._limit; i5++) {
            if (removeValue(intList._array[i5])) {
                z6 = true;
            }
        }
        return z6;
    }

    public boolean removeValue(int i5) {
        int i6 = 0;
        while (true) {
            int i7 = this._limit;
            if (i6 >= i7) {
                return false;
            }
            int[] iArr = this._array;
            if (i5 == iArr[i6]) {
                int i8 = i6 + 1;
                if (i8 < i7) {
                    System.arraycopy(iArr, i8, iArr, i6, i7 - i6);
                }
                this._limit--;
                return true;
            }
            i6++;
        }
    }

    public boolean retainAll(IntList intList) {
        int i5 = 0;
        boolean z6 = false;
        while (i5 < this._limit) {
            if (intList.contains(this._array[i5])) {
                i5++;
            } else {
                remove(i5);
                z6 = true;
            }
        }
        return z6;
    }

    public int set(int i5, int i6) {
        if (i5 >= this._limit) {
            throw new IndexOutOfBoundsException();
        }
        int[] iArr = this._array;
        int i7 = iArr[i5];
        iArr[i5] = i6;
        return i7;
    }

    public int size() {
        return this._limit;
    }

    public int[] toArray() {
        int i5 = this._limit;
        int[] iArr = new int[i5];
        System.arraycopy(this._array, 0, iArr, 0, i5);
        return iArr;
    }

    public IntList(int i5) {
        this._array = new int[i5];
        this._limit = 0;
    }

    public int[] toArray(int[] iArr) {
        int length = iArr.length;
        int i5 = this._limit;
        if (length == i5) {
            System.arraycopy(this._array, 0, iArr, 0, i5);
            return iArr;
        }
        return toArray();
    }

    public IntList(IntList intList) {
        this(intList._array.length);
        int[] iArr = intList._array;
        int[] iArr2 = this._array;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        this._limit = intList._limit;
    }

    public boolean addAll(int i5, IntList intList) {
        int i6 = this._limit;
        if (i5 <= i6) {
            int i7 = intList._limit;
            if (i7 == 0) {
                return true;
            }
            if (i6 + i7 > this._array.length) {
                growArray(i6 + i7);
            }
            int[] iArr = this._array;
            System.arraycopy(iArr, i5, iArr, intList._limit + i5, this._limit - i5);
            System.arraycopy(intList._array, 0, this._array, i5, intList._limit);
            this._limit += intList._limit;
            return true;
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean add(int i5) {
        int i6 = this._limit;
        if (i6 == this._array.length) {
            growArray(i6 * 2);
        }
        int[] iArr = this._array;
        int i7 = this._limit;
        this._limit = i7 + 1;
        iArr[i7] = i5;
        return true;
    }
}
