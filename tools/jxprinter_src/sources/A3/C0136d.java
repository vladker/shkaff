package A3;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: A3.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0136d {
    public static void a(int i5, int i6, int i7) {
        if (i5 < 0 || i6 > i7) {
            StringBuilder sbS = androidx.collection.a.s("startIndex: ", i5, i6, ", endIndex: ", ", size: ");
            sbS.append(i7);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
        if (i5 > i6) {
            throw new IllegalArgumentException(androidx.collection.a.h(i5, i6, "startIndex: ", " > endIndex: "));
        }
    }

    public static void b(int i5, int i6) {
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException(androidx.collection.a.h(i5, i6, "index: ", ", size: "));
        }
    }

    public static void c(int i5, int i6) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(androidx.collection.a.h(i5, i6, "index: ", ", size: "));
        }
    }

    public static void d(int i5, int i6, int i7) {
        if (i5 < 0 || i6 > i7) {
            StringBuilder sbS = androidx.collection.a.s("fromIndex: ", i5, i6, ", toIndex: ", ", size: ");
            sbS.append(i7);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
        if (i5 > i6) {
            throw new IllegalArgumentException(androidx.collection.a.h(i5, i6, "fromIndex: ", " > toIndex: "));
        }
    }

    public static int e(int i5, int i6) {
        int i7 = i5 + (i5 >> 1);
        if (i7 - i6 < 0) {
            i7 = i6;
        }
        if (i7 - 2147483639 > 0) {
            return i6 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        return i7;
    }

    public final boolean orderedEquals$kotlin_stdlib(Collection<?> c, Collection<?> other) {
        kotlin.jvm.internal.E.f(c, "c");
        kotlin.jvm.internal.E.f(other, "other");
        if (c.size() != other.size()) {
            return false;
        }
        Iterator<?> it = other.iterator();
        Iterator<?> it2 = c.iterator();
        while (it2.hasNext()) {
            if (!kotlin.jvm.internal.E.a(it2.next(), it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int orderedHashCode$kotlin_stdlib(Collection<?> c) {
        kotlin.jvm.internal.E.f(c, "c");
        Iterator<?> it = c.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }
}
