package androidx.collection;

import A3.AbstractC0157z;
import O3.l;
import O3.p;
import U3.B;
import U3.q;
import androidx.annotation.IntRange;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ObjectList<E> {
    public int _size;
    public Object[] content;

    /* JADX INFO: renamed from: androidx.collection.ObjectList$toString$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 extends F implements l {
        final /* synthetic */ ObjectList<E> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ObjectList<E> objectList) {
            super(1);
            this.this$0 = objectList;
        }

        @Override // O3.l
        public final CharSequence invoke(E e) {
            return e == this.this$0 ? "(this)" : String.valueOf(e);
        }
    }

    public /* synthetic */ ObjectList(int i5, AbstractC1107v abstractC1107v) {
        this(i5);
    }

    public static /* synthetic */ String joinToString$default(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i6 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        l lVar2 = lVar;
        return objectList.joinToString(charSequence, charSequence2, charSequence3, i5, charSequence5, lVar2);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public abstract List<E> asList();

    public final boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public final boolean containsAll(E[] elements) {
        E.f(elements, "elements");
        for (E e : elements) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    public final int count() {
        return this._size;
    }

    public final E elementAt(@IntRange(from = 0) int i5) {
        if (i5 < 0 || i5 >= this._size) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "Index ", " must be in 0.."), this._size, 1));
        }
        return (E) this.content[i5];
    }

    public final E elementAtOrElse(@IntRange(from = 0) int i5, l defaultValue) {
        E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= this._size) ? (E) defaultValue.invoke(Integer.valueOf(i5)) : (E) this.content[i5];
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectList) {
            ObjectList objectList = (ObjectList) obj;
            int i5 = objectList._size;
            int i6 = this._size;
            if (i5 == i6) {
                Object[] objArr = this.content;
                Object[] objArr2 = objectList.content;
                q qVarUntil = B.until(0, i6);
                int i7 = qVarUntil.f732a;
                int i8 = qVarUntil.b;
                if (i7 > i8) {
                    return true;
                }
                while (E.a(objArr[i7], objArr2[i7])) {
                    if (i7 == i8) {
                        return true;
                    }
                    i7++;
                }
                return false;
            }
        }
        return false;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ObjectList is empty.");
        }
        return (E) this.content[0];
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public final <R> R fold(R r6, p operation) {
        E.f(operation, "operation");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            r6 = (R) operation.invoke(r6, objArr[i6]);
        }
        return r6;
    }

    public final <R> R foldIndexed(R r6, O3.q operation) {
        E.f(operation, "operation");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            r6 = (R) operation.invoke(Integer.valueOf(i6), r6, objArr[i6]);
        }
        return r6;
    }

    public final <R> R foldRight(R r6, p operation) {
        E.f(operation, "operation");
        Object[] objArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return r6;
            }
            r6 = (R) operation.invoke(objArr[i5], r6);
        }
    }

    public final <R> R foldRightIndexed(R r6, O3.q operation) {
        E.f(operation, "operation");
        Object[] objArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return r6;
            }
            r6 = (R) operation.invoke(Integer.valueOf(i5), objArr[i5], r6);
        }
    }

    public final void forEach(l block) {
        E.f(block, "block");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            block.invoke(objArr[i6]);
        }
    }

    public final void forEachIndexed(p block) {
        E.f(block, "block");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            block.invoke(Integer.valueOf(i6), objArr[i6]);
        }
    }

    public final void forEachReversed(l block) {
        E.f(block, "block");
        Object[] objArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return;
            } else {
                block.invoke(objArr[i5]);
            }
        }
    }

    public final void forEachReversedIndexed(p block) {
        E.f(block, "block");
        Object[] objArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return;
            } else {
                block.invoke(Integer.valueOf(i5), objArr[i5]);
            }
        }
    }

    public final E get(@IntRange(from = 0) int i5) {
        if (i5 < 0 || i5 >= this._size) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "Index ", " must be in 0.."), this._size, 1));
        }
        return (E) this.content[i5];
    }

    public final q getIndices() {
        return B.until(0, this._size);
    }

    @IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        Object[] objArr = this.content;
        int i5 = this._size;
        int iHashCode = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            Object obj = objArr[i6];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final int indexOf(E e) {
        int i5 = 0;
        if (e == null) {
            Object[] objArr = this.content;
            int i6 = this._size;
            while (i5 < i6) {
                if (objArr[i5] == null) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        Object[] objArr2 = this.content;
        int i7 = this._size;
        while (i5 < i7) {
            if (e.equals(objArr2[i5])) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public final int indexOfFirst(l predicate) {
        E.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (((Boolean) predicate.invoke(objArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfLast(l predicate) {
        E.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        do {
            i5--;
            if (-1 >= i5) {
                return -1;
            }
        } while (!((Boolean) predicate.invoke(objArr[i5])).booleanValue());
        return i5;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ObjectList is empty.");
        }
        return (E) this.content[this._size - 1];
    }

    public final int lastIndexOf(E e) {
        if (e == null) {
            Object[] objArr = this.content;
            for (int i5 = this._size - 1; -1 < i5; i5--) {
                if (objArr[i5] == null) {
                    return i5;
                }
            }
        } else {
            Object[] objArr2 = this.content;
            for (int i6 = this._size - 1; -1 < i6; i6--) {
                if (e.equals(objArr2[i6])) {
                    return i6;
                }
            }
        }
        return -1;
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.content[this._size - 1];
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l predicate) {
        E.f(predicate, "predicate");
        Object[] objArr = this.content;
        for (int i5 = this._size - 1; -1 < i5; i5--) {
            if (((Boolean) predicate.invoke(objArr[i5])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new AnonymousClass1(this), 25, null);
    }

    private ObjectList(int i5) {
        this.content = i5 == 0 ? ObjectListKt.EmptyArray : new Object[i5];
    }

    public final boolean any(l predicate) {
        E.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (((Boolean) predicate.invoke(objArr[i6])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(l predicate) {
        E.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            if (((Boolean) predicate.invoke(objArr[i7])).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    public final E firstOrNull(l predicate) {
        E.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            E e = (E) objArr[i6];
            if (((Boolean) predicate.invoke(e)).booleanValue()) {
                return e;
            }
        }
        return null;
    }

    public final String joinToString(CharSequence separator) {
        E.f(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, null, 62, null);
    }

    public final boolean containsAll(List<? extends E> elements) {
        E.f(elements, "elements");
        int size = elements.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!contains(elements.get(i5))) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, null, 60, null);
    }

    public final E lastOrNull(l predicate) {
        E e;
        E.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        do {
            i5--;
            if (-1 >= i5) {
                return null;
            }
            e = (E) objArr[i5];
        } while (!((Boolean) predicate.invoke(e)).booleanValue());
        return e;
    }

    public final E first(l predicate) {
        E.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            E e = (E) objArr[i6];
            if (((Boolean) predicate.invoke(e)).booleanValue()) {
                return e;
            }
        }
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        E.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, null, 56, null);
    }

    public final boolean containsAll(Iterable<? extends E> elements) {
        E.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i5) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        E.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i5, null, null, 48, null);
    }

    public final E last(l predicate) {
        E e;
        E.f(predicate, "predicate");
        Object[] objArr = this.content;
        int i5 = this._size;
        do {
            i5--;
            if (-1 < i5) {
                e = (E) objArr[i5];
            } else {
                throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
            }
        } while (!((Boolean) predicate.invoke(e)).booleanValue());
        return e;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence truncated) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        E.f(postfix, "postfix");
        E.f(truncated, "truncated");
        return joinToString$default(this, separator, prefix, postfix, i5, truncated, null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(ObjectList<E> elements) {
        E.f(elements, "elements");
        Object[] objArr = elements.content;
        int i5 = elements._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (!contains(objArr[i6])) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i5, CharSequence charSequence2, l lVar) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbW = AbstractC0157z.w(charSequence, "postfix", charSequence2, "truncated", prefix);
        Object[] objArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            Object obj = objArr[i7];
            if (i7 == i5) {
                sbW.append(charSequence2);
                String string = sbW.toString();
                E.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i7 != 0) {
                sbW.append(separator);
            }
            if (lVar == null) {
                sbW.append(obj);
            } else {
                sbW.append((CharSequence) lVar.invoke(obj));
            }
        }
        sbW.append(charSequence);
        String string2 = sbW.toString();
        E.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }
}
