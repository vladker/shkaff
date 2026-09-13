package A3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w0 extends v0 {
    private static final <E> Set<E> buildSet(O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        Set setCreateSetBuilder = v0.createSetBuilder();
        builderAction.invoke(setCreateSetBuilder);
        return v0.build(setCreateSetBuilder);
    }

    public static <T> Set<T> emptySet() {
        return Y.INSTANCE;
    }

    private static final <T> HashSet<T> hashSetOf() {
        return new HashSet<>();
    }

    private static final <T> LinkedHashSet<T> linkedSetOf() {
        return new LinkedHashSet<>();
    }

    private static final <T> Set<T> mutableSetOf() {
        return new LinkedHashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        kotlin.jvm.internal.E.f(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : v0.setOf(set.iterator().next());
        }
        return emptySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Set<T> orEmpty(Set<? extends T> set) {
        return set == 0 ? emptySet() : set;
    }

    public static <T> Set<T> setOf(T... elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return C.toSet(elements);
    }

    public static final <T> Set<T> setOfNotNull(T t6) {
        return t6 != null ? v0.setOf(t6) : emptySet();
    }

    private static final <E> Set<E> buildSet(int i5, O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        Set setCreateSetBuilder = v0.createSetBuilder(i5);
        builderAction.invoke(setCreateSetBuilder);
        return v0.build(setCreateSetBuilder);
    }

    public static final <T> HashSet<T> hashSetOf(T... elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return (HashSet) C.toCollection(elements, new HashSet(j0.mapCapacity(elements.length)));
    }

    public static final <T> LinkedHashSet<T> linkedSetOf(T... elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return (LinkedHashSet) C.toCollection(elements, new LinkedHashSet(j0.mapCapacity(elements.length)));
    }

    public static final <T> Set<T> mutableSetOf(T... elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return (Set) C.toCollection(elements, new LinkedHashSet(j0.mapCapacity(elements.length)));
    }

    private static final <T> Set<T> setOf() {
        return emptySet();
    }

    public static final <T> Set<T> setOfNotNull(T... elements) {
        kotlin.jvm.internal.E.f(elements, "elements");
        return (Set) C.filterNotNullTo(elements, new LinkedHashSet());
    }
}
