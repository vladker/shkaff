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
public final class MutableLongList extends LongList {
    public MutableLongList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableLongList mutableLongList, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = mutableLongList._size;
        }
        mutableLongList.trim(i5);
    }

    public final boolean add(long j6) {
        ensureCapacity(this._size + 1);
        long[] jArr = this.content;
        int i5 = this._size;
        jArr[i5] = j6;
        this._size = i5 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, long[] elements) {
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
        long[] jArr = this.content;
        int i7 = this._size;
        if (i5 != i7) {
            AbstractC0151t.copyInto(jArr, jArr, elements.length + i5, i5, i7);
        }
        AbstractC0151t.copyInto(elements, jArr, i5, 0, elements.length);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i5) {
        long[] jArr = this.content;
        if (jArr.length < i5) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(i5, (jArr.length * 3) / 2));
            E.e(jArrCopyOf, "copyOf(this, newSize)");
            this.content = jArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(long j6) {
        remove(j6);
    }

    public final void plusAssign(LongList elements) {
        E.f(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(long j6) {
        int iIndexOf = indexOf(j6);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(long[] elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        for (long j6 : elements) {
            remove(j6);
        }
        return i5 != this._size;
    }

    public final long removeAt(@IntRange(from = 0) int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this._size)) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "Index ", " must be in 0.."), this._size, 1));
        }
        long[] jArr = this.content;
        long j6 = jArr[i5];
        if (i5 != i6 - 1) {
            AbstractC0151t.copyInto(jArr, jArr, i5, i5 + 1, i6);
        }
        this._size--;
        return j6;
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
                long[] jArr = this.content;
                AbstractC0151t.copyInto(jArr, jArr, i5, i6, i7);
            }
            this._size -= i6 - i5;
        }
    }

    public final boolean retainAll(long[] elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        long[] jArr = this.content;
        int i6 = i5 - 1;
        while (true) {
            int i7 = -1;
            if (-1 >= i6) {
                break;
            }
            long j6 = jArr[i6];
            int length = elements.length;
            for (int i8 = 0; i8 < length; i8++) {
                if (elements[i8] == j6) {
                    i7 = i8;
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

    public final long set(@IntRange(from = 0) int i5, long j6) {
        if (i5 < 0 || i5 >= this._size) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "set index ", " must be between 0 .. "), this._size, 1));
        }
        long[] jArr = this.content;
        long j7 = jArr[i5];
        jArr[i5] = j6;
        return j7;
    }

    public final void sort() {
        AbstractC0151t.sort(this.content, 0, this._size);
    }

    public final void sortDescending() {
        C.sortDescending(this.content, 0, this._size);
    }

    public final void trim(int i5) {
        int iMax = Math.max(i5, this._size);
        long[] jArr = this.content;
        if (jArr.length > iMax) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            E.e(jArrCopyOf, "copyOf(this, newSize)");
            this.content = jArrCopyOf;
        }
    }

    public /* synthetic */ MutableLongList(int i5, int i6, AbstractC1107v abstractC1107v) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final void minusAssign(long[] elements) {
        E.f(elements, "elements");
        for (long j6 : elements) {
            remove(j6);
        }
    }

    public final void plusAssign(long[] elements) {
        E.f(elements, "elements");
        addAll(this._size, elements);
    }

    public MutableLongList(int i5) {
        super(i5, null);
    }

    public final void plusAssign(long j6) {
        add(j6);
    }

    public final void add(@IntRange(from = 0) int i5, long j6) {
        int i6;
        if (i5 >= 0 && i5 <= (i6 = this._size)) {
            ensureCapacity(i6 + 1);
            long[] jArr = this.content;
            int i7 = this._size;
            if (i5 != i7) {
                AbstractC0151t.copyInto(jArr, jArr, i5 + 1, i5, i7);
            }
            jArr[i5] = j6;
            this._size++;
            return;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Index ", " must be in 0..");
        sbT.append(this._size);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public final void minusAssign(LongList elements) {
        E.f(elements, "elements");
        long[] jArr = elements.content;
        int i5 = elements._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(jArr[i6]);
        }
    }

    public final boolean removeAll(LongList elements) {
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

    public final boolean retainAll(LongList elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        long[] jArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!elements.contains(jArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, LongList elements) {
        E.f(elements, "elements");
        if (i5 >= 0 && i5 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            long[] jArr = this.content;
            int i6 = this._size;
            if (i5 != i6) {
                AbstractC0151t.copyInto(jArr, jArr, elements._size + i5, i5, i6);
            }
            AbstractC0151t.copyInto(elements.content, jArr, i5, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Index ", " must be in 0..");
        sbT.append(this._size);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public final boolean addAll(LongList elements) {
        E.f(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(long[] elements) {
        E.f(elements, "elements");
        return addAll(this._size, elements);
    }
}
