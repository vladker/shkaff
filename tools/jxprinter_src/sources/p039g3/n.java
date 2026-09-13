package p039g3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p027e3.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f4000a;

    public n(Comparator comparator) {
        this.f4000a = comparator;
    }

    @Override // p027e3.o
    public Object apply(Object obj) {
        List list = (List) obj;
        Collections.sort(list, this.f4000a);
        return list;
    }
}
