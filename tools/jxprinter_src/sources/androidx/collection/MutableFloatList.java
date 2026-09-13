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
public final class MutableFloatList extends FloatList {
    public MutableFloatList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableFloatList mutableFloatList, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = mutableFloatList._size;
        }
        mutableFloatList.trim(i5);
    }

    public final boolean add(float f6) {
        ensureCapacity(this._size + 1);
        float[] fArr = this.content;
        int i5 = this._size;
        fArr[i5] = f6;
        this._size = i5 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, float[] elements) {
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
        float[] fArr = this.content;
        int i7 = this._size;
        if (i5 != i7) {
            AbstractC0151t.copyInto(fArr, fArr, elements.length + i5, i5, i7);
        }
        AbstractC0151t.copyInto(elements, fArr, i5, 0, elements.length);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i5) {
        float[] fArr = this.content;
        if (fArr.length < i5) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, Math.max(i5, (fArr.length * 3) / 2));
            E.e(fArrCopyOf, "copyOf(this, newSize)");
            this.content = fArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(float f6) {
        remove(f6);
    }

    public final void plusAssign(FloatList elements) {
        E.f(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(float f6) {
        int iIndexOf = indexOf(f6);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(float[] elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        for (float f6 : elements) {
            remove(f6);
        }
        return i5 != this._size;
    }

    public final float removeAt(@IntRange(from = 0) int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this._size)) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "Index ", " must be in 0.."), this._size, 1));
        }
        float[] fArr = this.content;
        float f6 = fArr[i5];
        if (i5 != i6 - 1) {
            AbstractC0151t.copyInto(fArr, fArr, i5, i5 + 1, i6);
        }
        this._size--;
        return f6;
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
                float[] fArr = this.content;
                AbstractC0151t.copyInto(fArr, fArr, i5, i6, i7);
            }
            this._size -= i6 - i5;
        }
    }

    public final boolean retainAll(float[] elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        float[] fArr = this.content;
        int i6 = i5 - 1;
        while (true) {
            int i7 = -1;
            if (-1 >= i6) {
                break;
            }
            float f6 = fArr[i6];
            int length = elements.length;
            for (int i8 = 0; i8 < length; i8++) {
                if (elements[i8] == f6) {
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

    public final float set(@IntRange(from = 0) int i5, float f6) {
        if (i5 < 0 || i5 >= this._size) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "set index ", " must be between 0 .. "), this._size, 1));
        }
        float[] fArr = this.content;
        float f7 = fArr[i5];
        fArr[i5] = f6;
        return f7;
    }

    public final void sort() {
        AbstractC0151t.sort(this.content, 0, this._size);
    }

    public final void sortDescending() {
        C.sortDescending(this.content, 0, this._size);
    }

    public final void trim(int i5) {
        int iMax = Math.max(i5, this._size);
        float[] fArr = this.content;
        if (fArr.length > iMax) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, iMax);
            E.e(fArrCopyOf, "copyOf(this, newSize)");
            this.content = fArrCopyOf;
        }
    }

    public /* synthetic */ MutableFloatList(int i5, int i6, AbstractC1107v abstractC1107v) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final void minusAssign(float[] elements) {
        E.f(elements, "elements");
        for (float f6 : elements) {
            remove(f6);
        }
    }

    public final void plusAssign(float[] elements) {
        E.f(elements, "elements");
        addAll(this._size, elements);
    }

    public MutableFloatList(int i5) {
        super(i5, null);
    }

    public final void plusAssign(float f6) {
        add(f6);
    }

    public final void add(@IntRange(from = 0) int i5, float f6) {
        int i6;
        if (i5 >= 0 && i5 <= (i6 = this._size)) {
            ensureCapacity(i6 + 1);
            float[] fArr = this.content;
            int i7 = this._size;
            if (i5 != i7) {
                AbstractC0151t.copyInto(fArr, fArr, i5 + 1, i5, i7);
            }
            fArr[i5] = f6;
            this._size++;
            return;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Index ", " must be in 0..");
        sbT.append(this._size);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public final void minusAssign(FloatList elements) {
        E.f(elements, "elements");
        float[] fArr = elements.content;
        int i5 = elements._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(fArr[i6]);
        }
    }

    public final boolean removeAll(FloatList elements) {
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

    public final boolean retainAll(FloatList elements) {
        E.f(elements, "elements");
        int i5 = this._size;
        float[] fArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!elements.contains(fArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, FloatList elements) {
        E.f(elements, "elements");
        if (i5 >= 0 && i5 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            float[] fArr = this.content;
            int i6 = this._size;
            if (i5 != i6) {
                AbstractC0151t.copyInto(fArr, fArr, elements._size + i5, i5, i6);
            }
            AbstractC0151t.copyInto(elements.content, fArr, i5, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Index ", " must be in 0..");
        sbT.append(this._size);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public final boolean addAll(FloatList elements) {
        E.f(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(float[] elements) {
        E.f(elements, "elements");
        return addAll(this._size, elements);
    }
}
