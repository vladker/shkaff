package A3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class N extends M {
    private static final <T> void fill(List<T> list, T t6) {
        kotlin.jvm.internal.E.f(list, "<this>");
        Collections.fill(list, t6);
    }

    private static final <T> void shuffle(List<T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        Collections.shuffle(list);
    }

    private static final <T> void sort(List<T> list, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        throw new p147z3.r();
    }

    public static <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    private static final <T> void shuffle(List<T> list, Random random) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        Collections.shuffle(list, random);
    }

    private static final <T> void sort(List<T> list, O3.p comparison) {
        kotlin.jvm.internal.E.f(list, "<this>");
        kotlin.jvm.internal.E.f(comparison, "comparison");
        throw new p147z3.r();
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }
}
