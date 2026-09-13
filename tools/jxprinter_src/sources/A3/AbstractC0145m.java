package A3;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: renamed from: A3.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0145m {
    public static final <T> T[] arrayOfNulls(T[] reference, int i5) {
        kotlin.jvm.internal.E.f(reference, "reference");
        Object objNewInstance = Array.newInstance(reference.getClass().getComponentType(), i5);
        kotlin.jvm.internal.E.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) objNewInstance);
    }

    public static final <T> int contentDeepHashCode(T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    public static final void copyOfRangeToIndexCheck(int i5, int i6) {
        if (i5 > i6) {
            throw new IndexOutOfBoundsException(androidx.collection.a.m("toIndex (", i5, i6, ") is greater than size (", ")."));
        }
    }

    private static final String toString(byte[] bArr, Charset charset) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(charset, "charset");
        return new String(bArr, charset);
    }
}
