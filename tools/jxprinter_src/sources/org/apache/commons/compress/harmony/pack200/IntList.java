package org.apache.commons.compress.harmony.pack200;

import A3.AbstractC0157z;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IntList {
    private int[] array;
    private int firstIndex;
    private int lastIndex;
    private int modCount;

    public IntList() {
        this(10);
    }

    private void growAtEnd(int i5) {
        int i6 = this.lastIndex;
        int i7 = this.firstIndex;
        int i8 = i6 - i7;
        int[] iArr = this.array;
        if (i7 >= i5 - (iArr.length - i6)) {
            int i9 = i6 - i7;
            if (i8 > 0) {
                System.arraycopy(iArr, i7, iArr, 0, i8);
            }
            this.firstIndex = 0;
            this.lastIndex = i9;
            return;
        }
        int i10 = i8 / 2;
        if (i5 <= i10) {
            i5 = i10;
        }
        if (i5 < 12) {
            i5 = 12;
        }
        int[] iArr2 = new int[i5 + i8];
        if (i8 > 0) {
            System.arraycopy(iArr, i7, iArr2, 0, i8);
            this.firstIndex = 0;
            this.lastIndex = i8;
        }
        this.array = iArr2;
    }

    private void growAtFront(int i5) {
        int i6 = this.lastIndex;
        int i7 = this.firstIndex;
        int i8 = i6 - i7;
        int[] iArr = this.array;
        if ((iArr.length - i6) + i7 >= i5) {
            int length = iArr.length - i8;
            if (i8 > 0) {
                System.arraycopy(iArr, i7, iArr, length, i8);
            }
            this.firstIndex = length;
            this.lastIndex = this.array.length;
            return;
        }
        int i9 = i8 / 2;
        if (i5 <= i9) {
            i5 = i9;
        }
        if (i5 < 12) {
            i5 = 12;
        }
        int i10 = i5 + i8;
        int[] iArr2 = new int[i10];
        if (i8 > 0) {
            System.arraycopy(iArr, i7, iArr2, i10 - i8, i8);
        }
        this.firstIndex = i10 - i8;
        this.lastIndex = i10;
        this.array = iArr2;
    }

    private void growForInsert(int i5, int i6) {
        int i7 = this.lastIndex;
        int i8 = this.firstIndex;
        int i9 = i7 - i8;
        int i10 = i9 / 2;
        if (i6 > i10) {
            i10 = i6;
        }
        if (i10 < 12) {
            i10 = 12;
        }
        int i11 = i9 + i10;
        int[] iArr = new int[i11];
        int i12 = i10 - i6;
        System.arraycopy(this.array, i8 + i5, iArr, i12 + i5 + i6, i9 - i5);
        System.arraycopy(this.array, this.firstIndex, iArr, i12, i5);
        this.firstIndex = i12;
        this.lastIndex = i11;
        this.array = iArr;
    }

    public boolean add(int i5) {
        if (this.lastIndex == this.array.length) {
            growAtEnd(1);
        }
        int[] iArr = this.array;
        int i6 = this.lastIndex;
        this.lastIndex = i6 + 1;
        iArr[i6] = i5;
        this.modCount++;
        return true;
    }

    public void addAll(IntList intList) {
        growAtEnd(intList.size());
        for (int i5 = 0; i5 < intList.size(); i5++) {
            add(intList.get(i5));
        }
    }

    public void clear() {
        int i5 = this.firstIndex;
        int i6 = this.lastIndex;
        if (i5 != i6) {
            Arrays.fill(this.array, i5, i6, -1);
            this.lastIndex = 0;
            this.firstIndex = 0;
            this.modCount++;
        }
    }

    public int get(int i5) {
        if (i5 >= 0) {
            int i6 = this.lastIndex;
            int i7 = this.firstIndex;
            if (i5 < i6 - i7) {
                return this.array[i7 + i5];
            }
        }
        throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, ""));
    }

    public void increment(int i5) {
        if (i5 >= 0) {
            int i6 = this.lastIndex;
            int i7 = this.firstIndex;
            if (i5 < i6 - i7) {
                int[] iArr = this.array;
                int i8 = i7 + i5;
                iArr[i8] = iArr[i8] + 1;
                return;
            }
        }
        throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, ""));
    }

    public boolean isEmpty() {
        return this.lastIndex == this.firstIndex;
    }

    public int remove(int i5) {
        int i6;
        int i7 = this.lastIndex;
        int i8 = this.firstIndex;
        int i9 = i7 - i8;
        if (i5 < 0 || i5 >= i9) {
            throw new IndexOutOfBoundsException();
        }
        if (i5 == i9 - 1) {
            int[] iArr = this.array;
            int i10 = i7 - 1;
            this.lastIndex = i10;
            i6 = iArr[i10];
            iArr[i10] = 0;
        } else if (i5 == 0) {
            int[] iArr2 = this.array;
            int i11 = iArr2[i8];
            this.firstIndex = i8 + 1;
            iArr2[i8] = 0;
            i6 = i11;
        } else {
            int i12 = i8 + i5;
            int[] iArr3 = this.array;
            int i13 = iArr3[i12];
            if (i5 < i9 / 2) {
                System.arraycopy(iArr3, i8, iArr3, i8 + 1, i5);
                int[] iArr4 = this.array;
                int i14 = this.firstIndex;
                this.firstIndex = i14 + 1;
                iArr4[i14] = 0;
            } else {
                System.arraycopy(iArr3, i12 + 1, iArr3, i12, (i9 - i5) - 1);
                int[] iArr5 = this.array;
                int i15 = this.lastIndex - 1;
                this.lastIndex = i15;
                iArr5[i15] = 0;
            }
            i6 = i13;
        }
        if (this.firstIndex == this.lastIndex) {
            this.lastIndex = 0;
            this.firstIndex = 0;
        }
        this.modCount++;
        return i6;
    }

    public int size() {
        return this.lastIndex - this.firstIndex;
    }

    public int[] toArray() {
        int i5 = this.lastIndex;
        int i6 = this.firstIndex;
        int i7 = i5 - i6;
        int[] iArr = new int[i7];
        System.arraycopy(this.array, i6, iArr, 0, i7);
        return iArr;
    }

    public IntList(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException();
        }
        this.lastIndex = 0;
        this.firstIndex = 0;
        this.array = new int[i5];
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0021  */
    public void add(int i5, int i6) {
        int i7 = this.lastIndex;
        int i8 = this.firstIndex;
        int i9 = i7 - i8;
        if (i5 > 0 && i5 < i9) {
            if (i8 == 0 && i7 == this.array.length) {
                growForInsert(i5, 1);
            } else if (i5 >= i9 / 2 || i8 <= 0) {
                int[] iArr = this.array;
                if (i7 == iArr.length) {
                    int[] iArr2 = this.array;
                    int i10 = i8 - 1;
                    this.firstIndex = i10;
                    System.arraycopy(iArr2, i8, iArr2, i10, i5);
                } else {
                    int i11 = i8 + i5;
                    System.arraycopy(iArr, i11, iArr, i11 + 1, i9 - i5);
                    this.lastIndex++;
                }
            } else {
                int[] iArr3 = this.array;
                int i12 = i8 - 1;
                this.firstIndex = i12;
                System.arraycopy(iArr3, i8, iArr3, i12, i5);
            }
            this.array[i5 + this.firstIndex] = i6;
        } else if (i5 == 0) {
            if (i8 == 0) {
                growAtFront(1);
            }
            int[] iArr4 = this.array;
            int i13 = this.firstIndex - 1;
            this.firstIndex = i13;
            iArr4[i13] = i6;
        } else if (i5 == i9) {
            if (i7 == this.array.length) {
                growAtEnd(1);
            }
            int[] iArr5 = this.array;
            int i14 = this.lastIndex;
            this.lastIndex = i14 + 1;
            iArr5[i14] = i6;
        } else {
            throw new IndexOutOfBoundsException();
        }
        this.modCount++;
    }
}
