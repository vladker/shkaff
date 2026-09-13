package A3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class J extends I {
    private static final <T> Iterable<T> Iterable(O3.a iterator) {
        kotlin.jvm.internal.E.f(iterator, "iterator");
        return new A(iterator, 9);
    }

    public static <T> int collectionSizeOrDefault(Iterable<? extends T> iterable, int i5) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i5;
    }

    public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    public static final <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            O.addAll(arrayList, it.next());
        }
        return arrayList;
    }

    public static final <T, R> C1938s unzip(Iterable<? extends C1938s> iterable) {
        kotlin.jvm.internal.E.f(iterable, "<this>");
        int iCollectionSizeOrDefault = collectionSizeOrDefault(iterable, 10);
        ArrayList arrayList = new ArrayList(iCollectionSizeOrDefault);
        ArrayList arrayList2 = new ArrayList(iCollectionSizeOrDefault);
        for (C1938s c1938s : iterable) {
            arrayList.add(c1938s.f9134a);
            arrayList2.add(c1938s.b);
        }
        return p147z3.A.to(arrayList, arrayList2);
    }
}
