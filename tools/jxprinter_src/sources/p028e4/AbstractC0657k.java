package p028e4;

import O3.l;
import java.util.ArrayList;

/* JADX INFO: renamed from: e4.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0657k {
    /* JADX INFO: renamed from: forEachReversed-impl, reason: not valid java name */
    public static final void m1033forEachReversedimpl(Object obj, l lVar) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            lVar.invoke(obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            } else {
                lVar.invoke(arrayList.get(size));
            }
        }
    }

    /* JADX INFO: renamed from: plus-FjFbRPM, reason: not valid java name */
    public static final Object m1034plusFjFbRPM(Object obj, Object obj2) {
        if (obj == null) {
            return m1032constructorimpl(obj2);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return m1032constructorimpl(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return m1032constructorimpl(arrayList);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <E> Object m1032constructorimpl(Object obj) {
        return obj;
    }
}
