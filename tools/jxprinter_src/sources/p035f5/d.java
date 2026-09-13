package p035f5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p079o.AbstractC1282k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Collection f3977k;

    public final boolean G(int i5, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f3977k.iterator();
        while (it.hasNext()) {
            arrayList.add(((g5.d) it.next()).f4026a);
        }
        return !AbstractC1282k.c(str, arrayList) && i5 == 0;
    }
}
