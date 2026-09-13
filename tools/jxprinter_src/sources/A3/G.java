package A3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.AbstractC1106u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class G {
    public static <E> List<E> build(List<E> builder) {
        kotlin.jvm.internal.E.f(builder, "builder");
        return (List<E>) ((B3.e) builder).build();
    }

    private static final <E> List<E> buildListInternal(O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        List listCreateListBuilder = createListBuilder();
        builderAction.invoke(listCreateListBuilder);
        return build(listCreateListBuilder);
    }

    private static final int checkCountOverflow(int i5) {
        if (i5 >= 0) {
            return i5;
        }
        if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            throw new ArithmeticException("Count overflow has happened.");
        }
        I.throwCountOverflow();
        return i5;
    }

    private static final int checkIndexOverflow(int i5) {
        if (i5 >= 0) {
            return i5;
        }
        if (!I3.c.apiVersionIsAtLeast(1, 3, 0)) {
            throw new ArithmeticException("Index overflow has happened.");
        }
        I.throwIndexOverflow();
        return i5;
    }

    private static final Object[] collectionToArray(Collection<?> collection) {
        kotlin.jvm.internal.E.f(collection, "collection");
        return AbstractC1106u.toArray(collection);
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z6) {
        kotlin.jvm.internal.E.f(tArr, "<this>");
        if (z6 && tArr.getClass().equals(Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.E.e(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static <E> List<E> createListBuilder() {
        return new B3.e(10);
    }

    public static <T> List<T> listOf(T t6) {
        List<T> listSingletonList = Collections.singletonList(t6);
        kotlin.jvm.internal.E.e(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        List<T> mutableList = T.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    public static <T> T[] terminateCollectionToArray(int i5, T[] array) {
        kotlin.jvm.internal.E.f(array, "array");
        if (i5 < array.length) {
            array[i5] = null;
        }
        return array;
    }

    private static final <T> List<T> toList(Enumeration<T> enumeration) {
        kotlin.jvm.internal.E.f(enumeration, "<this>");
        ArrayList list = Collections.list(enumeration);
        kotlin.jvm.internal.E.e(list, "list(...)");
        return list;
    }

    private static final <E> List<E> buildListInternal(int i5, O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        List listCreateListBuilder = createListBuilder(i5);
        builderAction.invoke(listCreateListBuilder);
        return build(listCreateListBuilder);
    }

    private static final <T> T[] collectionToArray(Collection<?> collection, T[] array) {
        kotlin.jvm.internal.E.f(collection, "collection");
        kotlin.jvm.internal.E.f(array, "array");
        return (T[]) AbstractC1106u.toArray(collection, array);
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        List<T> mutableList = T.toMutableList(iterable);
        Collections.shuffle(mutableList, random);
        return mutableList;
    }

    public static <E> List<E> createListBuilder(int i5) {
        return new B3.e(i5);
    }
}
