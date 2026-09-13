package D3;

import java.util.Comparator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements Comparator {
    private final Comparator<Object> comparator;

    public j(Comparator<Object> comparator) {
        E.f(comparator, "comparator");
        this.comparator = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.comparator.compare(obj2, obj);
    }

    public final Comparator<Object> getComparator() {
        return this.comparator;
    }

    @Override // java.util.Comparator
    public final Comparator<Object> reversed() {
        return this.comparator;
    }
}
