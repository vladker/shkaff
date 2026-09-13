package B3;

import A3.AbstractC0140h;
import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final String a(Object[] objArr, int i5, int i6, AbstractC0140h abstractC0140h) {
        StringBuilder sb = new StringBuilder((i6 * 3) + 2);
        sb.append("[");
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i5 + i7];
            if (obj == abstractC0140h) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        E.e(string, "toString(...)");
        return string;
    }

    public static final <E> E[] arrayOfUninitializedElements(int i5) {
        if (i5 >= 0) {
            return (E[]) new Object[i5];
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public static final <T> T[] copyOfUninitializedElements(T[] tArr, int i5) {
        E.f(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i5);
        E.e(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static final <E> void resetAt(E[] eArr, int i5) {
        E.f(eArr, "<this>");
        eArr[i5] = null;
    }

    public static final <E> void resetRange(E[] eArr, int i5, int i6) {
        E.f(eArr, "<this>");
        while (i5 < i6) {
            resetAt(eArr, i5);
            i5++;
        }
    }
}
