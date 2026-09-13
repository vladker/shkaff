package A3;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class P extends O {
    public static final <T> List<T> asReversed(List<? extends T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return new s0(list);
    }

    public static final <T> List<T> asReversedMutable(List<T> list) {
        kotlin.jvm.internal.E.f(list, "<this>");
        return new r0(list);
    }

    public static final int d(int i5, List list) {
        if (i5 >= 0 && i5 <= I.getLastIndex(list)) {
            return I.getLastIndex(list) - i5;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Element index ", " must be in range [");
        sbT.append(new U3.q(0, I.getLastIndex(list), 1));
        sbT.append("].");
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public static final int e(int i5, List list) {
        if (i5 >= 0 && i5 <= list.size()) {
            return list.size() - i5;
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Position index ", " must be in range [");
        sbT.append(new U3.q(0, list.size(), 1));
        sbT.append("].");
        throw new IndexOutOfBoundsException(sbT.toString());
    }
}
