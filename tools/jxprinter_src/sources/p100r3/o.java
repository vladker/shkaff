package p100r3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f7969a;

    public o(Comparator comparator) {
        this.f7969a = comparator;
    }

    @Override // p027e3.o
    public List<Object> apply(List<Object> list) {
        Collections.sort(list, this.f7969a);
        return list;
    }
}
