package androidx.collection;

import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A3.C;
import androidx.annotation.IntRange;
import java.util.Arrays;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableIntList extends IntList {
    public MutableIntList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableIntList mutableIntList, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = mutableIntList._size;
        }
        mutableIntList.trim(i5);
    }

    public final boolean add(int i5) {
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        int i6 = this._size;
        iArr[i6] = i5;
        this._size = i6 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, int[] elements) {
        int i6;
        E.f(elements, "elements");
        if (i5 < 0 || i5 > (i6 = this._size)) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Index ", " must be in 0..");
            sbT.append(this._size);
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(i6 + elements.length);
        int[] iArr = this.content;
        int i7 = this._size;
        if (i5 != i7) {
            AbstractC0151t.copyInto(iArr, iArr, elements.length + i5, i5, i7);
        }
        AbstractC0151t.b(elements, iArr, i5, 0, 12);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i5) {
        int[] iArr = this.content;
        if (iArr.length < i5) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, Math.max(i5, (iArr.length * 3) / 2));
            E.e(iArrCopyOf, "copyOf(this, newSize)");
            this.content = iArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(int i5) {
        remove(i5);
    }

    public final void plusAssign(IntList elements) {
        E.f(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(int i5) {
        int iIndexOf = indexOf(i5);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(int[] elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        for (int i6 : elements) {
            remove(i6);
        }
        return i5 != this._size;
    }

    public final int removeAt(@IntRange(from = 0) int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this._size)) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "Index ", " must be in 0.."), this._size, 1));
        }
        int[] iArr = this.content;
        int i7 = iArr[i5];
        if (i5 != i6 - 1) {
            AbstractC0151t.copyInto(iArr, iArr, i5, i5 + 1, i6);
        }
        this._size--;
        return i7;
    }

    public final void removeRange(@IntRange(from = 0) int i5, @IntRange(from = 0) int i6) {
        int i7;
        if (i5 < 0 || i5 > (i7 = this._size) || i6 < 0 || i6 > i7) {
            StringBuilder sbS = a.s("Start (", i5, i6, ") and end (", ") must be in 0..");
            sbS.append(this._size);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException("Start (" + i5 + ") is more than end (" + i6 + ')');
        }
        if (i6 != i5) {
            if (i6 < i7) {
                int[] iArr = this.content;
                AbstractC0151t.copyInto(iArr, iArr, i5, i6, i7);
            }
            this._size -= i6 - i5;
        }
    }

    public final boolean retainAll(int[] elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        int[] iArr = this.content;
        int i6 = i5 - 1;
        while (true) {
            int i7 = -1;
            if (-1 >= i6) {
                break;
            }
            int i8 = iArr[i6];
            int length = elements.length;
            for (int i9 = 0; i9 < length; i9++) {
                if (elements[i9] == i8) {
                    i7 = i9;
                    break;
                }
            }
            if (i7 < 0) {
                removeAt(i6);
            }
            i6--;
        }
        return i5 != this._size;
    }

    public final int set(@IntRange(from = 0) int i5, int i6) {
        if (i5 < 0 || i5 >= this._size) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "set index ", " must be between 0 .. "), this._size, 1));
        }
        int[] iArr = this.content;
        int i7 = iArr[i5];
        iArr[i5] = i6;
        return i7;
    }

    public final void sort() {
        AbstractC0151t.sort(this.content, 0, this._size);
    }

    public final void sortDescending() {
        C.sortDescending(this.content, 0, this._size);
    }

    public final void trim(int i5) {
        int iMax = Math.max(i5, this._size);
        int[] iArr = this.content;
        if (iArr.length > iMax) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            E.e(iArrCopyOf, "copyOf(this, newSize)");
            this.content = iArrCopyOf;
        }
    }

    public /* synthetic */ MutableIntList(int i5, int i6, AbstractC1107v abstractC1107v) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final void minusAssign(int[] elements) {
        E.f(elements, "elements");
        for (int i5 : elements) {
            remove(i5);
        }
    }

    public final void plusAssign(int[] elements) {
        E.f(elements, "elements");
        addAll(this._size, elements);
    }

    public MutableIntList(int i5) {
        super(i5, null);
    }

    public final void plusAssign(int i5) {
        add(i5);
    }

    public final void add(@IntRange(from = 0) int i5, int i6) {
        int i7;
        if (i5 >= 0 && i5 <= (i7 = this._size)) {
            ensureCapacity(i7 + 1);
            int[] iArr = this.content;
            int i8 = this._size;
            if (i5 != i8) {
                AbstractC0151t.copyInto(iArr, iArr, i5 + 1, i5, i8);
            }
            iArr[i5] = i6;
            this._size++;
            return;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Index ", " must be in 0..");
        sbT.append(this._size);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public final void minusAssign(IntList elements) {
        E.f(elements, "elements");
        int[] iArr = elements.content;
        int i5 = elements._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(iArr[i6]);
        }
    }

    public final boolean removeAll(IntList elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        int i6 = elements._size - 1;
        if (i6 >= 0) {
            int i7 = 0;
            while (true) {
                remove(elements.get(i7));
                if (i7 == i6) {
                    break;
                }
                i7++;
            }
        }
        return i5 != this._size;
    }

    public final boolean retainAll(IntList elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        int[] iArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!elements.contains(iArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, IntList elements) {
        E.f(elements, "elements");
        if (i5 >= 0 && i5 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            int[] iArr = this.content;
            int i6 = this._size;
            if (i5 != i6) {
                AbstractC0151t.copyInto(iArr, iArr, elements._size + i5, i5, i6);
            }
            AbstractC0151t.copyInto(elements.content, iArr, i5, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Index ", " must be in 0..");
        sbT.append(this._size);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public final boolean addAll(IntList elements) {
        E.f(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(int[] elements) {
        E.f(elements, "elements");
        return addAll(this._size, elements);
    }
}
