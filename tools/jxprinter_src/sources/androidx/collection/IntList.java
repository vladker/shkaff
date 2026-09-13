package androidx.collection;

import A3.AbstractC0157z;
import O3.l;
import O3.p;
import U3.B;
import U3.q;
import androidx.annotation.IntRange;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntList {
    public int _size;
    public int[] content;

    public /* synthetic */ IntList(int i5, AbstractC1107v abstractC1107v) {
        this(i5);
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
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
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return intList.joinToString(charSequence, charSequence2, charSequence6, i5, charSequence5);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean contains(int i5) {
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (iArr[i7] == i5) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(IntList elements) {
        E.f(elements, "elements");
        q qVarUntil = B.until(0, elements._size);
        int i5 = qVarUntil.f732a;
        int i6 = qVarUntil.b;
        if (i5 > i6) {
            return true;
        }
        while (contains(elements.get(i5))) {
            if (i5 == i6) {
                return true;
            }
            i5++;
        }
        return false;
    }

    public final int count() {
        return this._size;
    }

    public final int elementAt(@IntRange(from = 0) int i5) {
        if (i5 < 0 || i5 >= this._size) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "Index ", " must be in 0.."), this._size, 1));
        }
        return this.content[i5];
    }

    public final int elementAtOrElse(@IntRange(from = 0) int i5, l defaultValue) {
        E.f(defaultValue, "defaultValue");
        return (i5 < 0 || i5 >= this._size) ? ((Number) defaultValue.invoke(Integer.valueOf(i5))).intValue() : this.content[i5];
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntList) {
            IntList intList = (IntList) obj;
            int i5 = intList._size;
            int i6 = this._size;
            if (i5 == i6) {
                int[] iArr = this.content;
                int[] iArr2 = intList.content;
                q qVarUntil = B.until(0, i6);
                int i7 = qVarUntil.f732a;
                int i8 = qVarUntil.b;
                if (i7 > i8) {
                    return true;
                }
                while (iArr[i7] == iArr2[i7]) {
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

    public final int first() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntList is empty.");
        }
        return this.content[0];
    }

    public final <R> R fold(R r6, p operation) {
        E.f(operation, "operation");
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            r6 = (R) operation.invoke(r6, Integer.valueOf(iArr[i6]));
        }
        return r6;
    }

    public final <R> R foldIndexed(R r6, O3.q operation) {
        E.f(operation, "operation");
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            R r7 = r6;
            r6 = (R) operation.invoke(Integer.valueOf(i6), r7, Integer.valueOf(iArr[i6]));
        }
        return r6;
    }

    public final <R> R foldRight(R r6, p operation) {
        E.f(operation, "operation");
        int[] iArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return r6;
            }
            r6 = (R) operation.invoke(Integer.valueOf(iArr[i5]), r6);
        }
    }

    public final <R> R foldRightIndexed(R r6, O3.q operation) {
        E.f(operation, "operation");
        int[] iArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return r6;
            }
            r6 = (R) operation.invoke(Integer.valueOf(i5), Integer.valueOf(iArr[i5]), r6);
        }
    }

    public final void forEach(l block) {
        E.f(block, "block");
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            block.invoke(Integer.valueOf(iArr[i6]));
        }
    }

    public final void forEachIndexed(p block) {
        E.f(block, "block");
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            block.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i6]));
        }
    }

    public final void forEachReversed(l block) {
        E.f(block, "block");
        int[] iArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return;
            } else {
                block.invoke(Integer.valueOf(iArr[i5]));
            }
        }
    }

    public final void forEachReversedIndexed(p block) {
        E.f(block, "block");
        int[] iArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return;
            } else {
                block.invoke(Integer.valueOf(i5), Integer.valueOf(iArr[i5]));
            }
        }
    }

    public final int get(@IntRange(from = 0) int i5) {
        if (i5 < 0 || i5 >= this._size) {
            throw new IndexOutOfBoundsException(AbstractC0157z.q(AbstractC0157z.t(i5, "Index ", " must be in 0.."), this._size, 1));
        }
        return this.content[i5];
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
        int[] iArr = this.content;
        int i5 = this._size;
        int iHashCode = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            iHashCode += Integer.hashCode(iArr[i6]) * 31;
        }
        return iHashCode;
    }

    public final int indexOf(int i5) {
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (i5 == iArr[i7]) {
                return i7;
            }
        }
        return -1;
    }

    public final int indexOfFirst(l predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i6]))).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfLast(l predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.content;
        int i5 = this._size;
        do {
            i5--;
            if (-1 >= i5) {
                return -1;
            }
        } while (!((Boolean) predicate.invoke(Integer.valueOf(iArr[i5]))).booleanValue());
        return i5;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final int last() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntList is empty.");
        }
        return this.content[this._size - 1];
    }

    public final int lastIndexOf(int i5) {
        int[] iArr = this.content;
        int i6 = this._size;
        do {
            i6--;
            if (-1 >= i6) {
                return -1;
            }
        } while (iArr[i6] != i5);
        return i6;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.content;
        for (int i5 = this._size - 1; -1 < i5; i5--) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i5]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    private IntList(int i5) {
        this.content = i5 == 0 ? IntSetKt.getEmptyIntArray() : new int[i5];
    }

    public final boolean any(l predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i6]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(l predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i7]))).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    public final String joinToString(CharSequence separator) {
        E.f(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final int first(l predicate) {
        E.f(predicate, "predicate");
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = iArr[i6];
            if (((Boolean) predicate.invoke(Integer.valueOf(i7))).booleanValue()) {
                return i7;
            }
        }
        throw new NoSuchElementException("IntList contains no element matching the predicate.");
    }

    public final String joinToString(CharSequence separator, CharSequence charSequence, l lVar) {
        E.f(separator, "separator");
        StringBuilder sbU = AbstractC0157z.u(charSequence, "prefix", lVar, "transform", charSequence);
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = iArr[i6];
            if (i6 == -1) {
                sbU.append((CharSequence) "...");
                String string = sbU.toString();
                E.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i6 != 0) {
                sbU.append(separator);
            }
            sbU.append((CharSequence) lVar.invoke(Integer.valueOf(i7)));
        }
        sbU.append((CharSequence) "");
        String string2 = sbU.toString();
        E.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence charSequence, l lVar, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                separator = ", ";
            }
            if ((i6 & 2) != 0) {
                prefix = "";
            }
            if ((i6 & 4) != 0) {
                postfix = "";
            }
            if ((i6 & 8) != 0) {
                i5 = -1;
            }
            if ((i6 & 16) != 0) {
                charSequence = "...";
            }
            E.f(separator, "separator");
            E.f(prefix, "prefix");
            E.f(postfix, "postfix");
            StringBuilder sbU = AbstractC0157z.u(charSequence, "truncated", lVar, "transform", prefix);
            int[] iArr = intList.content;
            int i7 = intList._size;
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = iArr[i8];
                if (i8 == i5) {
                    sbU.append(charSequence);
                    String string = sbU.toString();
                    E.e(string, "StringBuilder().apply(builderAction).toString()");
                    return string;
                }
                if (i8 != 0) {
                    sbU.append(separator);
                }
                sbU.append((CharSequence) lVar.invoke(Integer.valueOf(i9)));
            }
            sbU.append(postfix);
            String string2 = sbU.toString();
            E.e(string2, "StringBuilder().apply(builderAction).toString()");
            return string2;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final int last(l predicate) {
        int i5;
        E.f(predicate, "predicate");
        int[] iArr = this.content;
        int i6 = this._size;
        do {
            i6--;
            if (-1 < i6) {
                i5 = iArr[i6];
            } else {
                throw new NoSuchElementException("IntList contains no element matching the predicate.");
            }
        } while (!((Boolean) predicate.invoke(Integer.valueOf(i5))).booleanValue());
        return i5;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        E.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i5) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        E.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i5, null, 16, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i5, l lVar) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbU = AbstractC0157z.u(charSequence, "postfix", lVar, "transform", prefix);
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = iArr[i7];
            if (i7 == i5) {
                sbU.append((CharSequence) "...");
                String string = sbU.toString();
                E.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i7 != 0) {
                sbU.append(separator);
            }
            sbU.append((CharSequence) lVar.invoke(Integer.valueOf(i8)));
        }
        sbU.append(charSequence);
        String string2 = sbU.toString();
        E.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i5, CharSequence charSequence2) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbW = AbstractC0157z.w(charSequence, "postfix", charSequence2, "truncated", prefix);
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = iArr[i7];
            if (i7 == i5) {
                sbW.append(charSequence2);
                String string = sbW.toString();
                E.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i7 != 0) {
                sbW.append(separator);
            }
            sbW.append(i8);
        }
        sbW.append(charSequence);
        String string2 = sbW.toString();
        E.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i5, CharSequence charSequence, l lVar) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        E.f(postfix, "postfix");
        StringBuilder sbU = AbstractC0157z.u(charSequence, "truncated", lVar, "transform", prefix);
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = iArr[i7];
            if (i7 == i5) {
                sbU.append(charSequence);
                String string = sbU.toString();
                E.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i7 != 0) {
                sbU.append(separator);
            }
            sbU.append((CharSequence) lVar.invoke(Integer.valueOf(i8)));
        }
        sbU.append(postfix);
        String string2 = sbU.toString();
        E.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, l lVar) {
        E.f(separator, "separator");
        E.f(prefix, "prefix");
        StringBuilder sbU = AbstractC0157z.u(charSequence, "postfix", lVar, "transform", prefix);
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = iArr[i6];
            if (i6 == -1) {
                sbU.append((CharSequence) "...");
                String string = sbU.toString();
                E.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i6 != 0) {
                sbU.append(separator);
            }
            sbU.append((CharSequence) lVar.invoke(Integer.valueOf(i7)));
        }
        sbU.append(charSequence);
        String string2 = sbU.toString();
        E.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public final String joinToString(CharSequence separator, l transform) {
        E.f(separator, "separator");
        E.f(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = iArr[i6];
            if (i6 == -1) {
                sb.append((CharSequence) "...");
                String string = sb.toString();
                E.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i6 != 0) {
                sb.append(separator);
            }
            sb.append((CharSequence) transform.invoke(Integer.valueOf(i7)));
        }
        sb.append((CharSequence) "");
        String string2 = sb.toString();
        E.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public final String joinToString(l transform) {
        E.f(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = iArr[i6];
            if (i6 == -1) {
                sb.append((CharSequence) "...");
                String string = sb.toString();
                E.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i6 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append((CharSequence) transform.invoke(Integer.valueOf(i7)));
        }
        sb.append((CharSequence) "");
        String string2 = sb.toString();
        E.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }
}
