package D3;

import java.util.Comparator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements Comparator {
    public static final i INSTANCE = new i();

    @Override // java.util.Comparator
    public final Comparator<Comparable<Object>> reversed() {
        return h.INSTANCE;
    }

    @Override // java.util.Comparator
    public int compare(Comparable<Object> a6, Comparable<Object> b) {
        E.f(a6, "a");
        E.f(b, "b");
        return b.compareTo(a6);
    }
}
