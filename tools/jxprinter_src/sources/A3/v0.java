package A3;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v0 {
    public static <E> Set<E> build(Set<E> builder) {
        kotlin.jvm.internal.E.f(builder, "builder");
        return (Set<E>) ((B3.v) builder).build();
    }

    private static final <E> Set<E> buildSetInternal(O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        Set setCreateSetBuilder = createSetBuilder();
        builderAction.invoke(setCreateSetBuilder);
        return build(setCreateSetBuilder);
    }

    public static final <E> Set<E> createSetBuilder() {
        return new B3.v(new B3.m());
    }

    public static <T> Set<T> setOf(T t6) {
        Set<T> setSingleton = Collections.singleton(t6);
        kotlin.jvm.internal.E.e(setSingleton, "singleton(...)");
        return setSingleton;
    }

    public static final <T> TreeSet<T> sortedSetOf(T... elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return (TreeSet) C.toCollection(elements, new TreeSet());
    }

    private static final <E> Set<E> buildSetInternal(int i5, O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        Set setCreateSetBuilder = createSetBuilder(i5);
        builderAction.invoke(setCreateSetBuilder);
        return build(setCreateSetBuilder);
    }

    public static final <T> TreeSet<T> sortedSetOf(Comparator<? super T> comparator, T... elements) {
        kotlin.jvm.internal.E.f(comparator, "comparator");
        kotlin.jvm.internal.E.f(elements, "elements");
        return (TreeSet) C.toCollection(elements, new TreeSet(comparator));
    }

    public static <E> Set<E> createSetBuilder(int i5) {
        return new B3.v(new B3.m(i5));
    }
}
