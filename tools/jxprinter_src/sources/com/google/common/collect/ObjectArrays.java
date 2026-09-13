package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class ObjectArrays {
    private ObjectArrays() {
    }

    @CanIgnoreReturnValue
    public static Object checkElementNotNull(Object obj, int i5) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(com.google.android.gms.auth.api.accounttransfer.a.h(20, i5, "at index "));
    }

    @CanIgnoreReturnValue
    public static Object[] checkElementsNotNull(Object... objArr) {
        checkElementsNotNull(objArr, objArr.length);
        return objArr;
    }

    @GwtIncompatible
    public static <T> T[] concat(T[] tArr, T[] tArr2, Class<T> cls) {
        T[] tArr3 = (T[]) newArray(cls, tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static Object[] copyAsObjectArray(Object[] objArr, int i5, int i6) {
        Preconditions.checkPositionIndexes(i5, i5 + i6, objArr.length);
        if (i6 == 0) {
            return new Object[0];
        }
        Object[] objArr2 = new Object[i6];
        System.arraycopy(objArr, i5, objArr2, 0, i6);
        return objArr2;
    }

    @CanIgnoreReturnValue
    private static Object[] fillArray(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            objArr[i5] = it.next();
            i5++;
        }
        return objArr;
    }

    @GwtIncompatible
    public static <T> T[] newArray(Class<T> cls, int i5) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i5));
    }

    public static void swap(Object[] objArr, int i5, int i6) {
        Object obj = objArr[i5];
        objArr[i5] = objArr[i6];
        objArr[i6] = obj;
    }

    public static <T> T[] toArrayImpl(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) newArray(tArr, size);
        }
        fillArray(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    @CanIgnoreReturnValue
    public static Object[] checkElementsNotNull(Object[] objArr, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            checkElementNotNull(objArr[i6], i6);
        }
        return objArr;
    }

    public static <T> T[] newArray(T[] tArr, int i5) {
        return (T[]) Platform.newArray(tArr, i5);
    }

    public static <T> T[] concat(@ParametricNullness T t6, T[] tArr) {
        T[] tArr2 = (T[]) newArray(tArr, tArr.length + 1);
        tArr2[0] = t6;
        System.arraycopy(tArr, 0, tArr2, 1, tArr.length);
        return tArr2;
    }

    public static <T> T[] concat(T[] tArr, @ParametricNullness T t6) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length + 1);
        tArr2[tArr.length] = t6;
        return tArr2;
    }

    public static <T> T[] toArrayImpl(Object[] objArr, int i5, int i6, T[] tArr) {
        Preconditions.checkPositionIndexes(i5, i5 + i6, objArr.length);
        if (tArr.length < i6) {
            tArr = (T[]) newArray(tArr, i6);
        } else if (tArr.length > i6) {
            tArr[i6] = null;
        }
        System.arraycopy(objArr, i5, tArr, 0, i6);
        return tArr;
    }

    public static Object[] toArrayImpl(Collection<?> collection) {
        return fillArray(collection, new Object[collection.size()]);
    }
}
