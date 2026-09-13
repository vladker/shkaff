package p079o;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import p050j.a;
import p050j.d;
import p067m.b;
import p067m.g;
import p073n.p;

/* JADX INFO: renamed from: o.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1287p implements p {
    @Override // p073n.p
    public final int a() {
        return 4;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        if (i5 == 4) {
            String strJ = gVar.J();
            gVar.n(16);
            return strJ.toCharArray();
        }
        if (i5 == 2) {
            Number numberIntegerValue = gVar.integerValue();
            gVar.n(16);
            return numberIntegerValue.toString().toCharArray();
        }
        Object objH = bVar.h(null);
        if (objH instanceof String) {
            return ((String) objH).toCharArray();
        }
        if (!(objH instanceof Collection)) {
            if (objH == null) {
                return null;
            }
            return a.g(objH).toCharArray();
        }
        Collection collection = (Collection) objH;
        for (Object obj2 : collection) {
            if ((obj2 instanceof String) && ((String) obj2).length() != 1) {
                throw new d("can not cast to char[]");
            }
        }
        char[] cArr = new char[collection.size()];
        Iterator it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            cArr[i6] = ((String) it.next()).charAt(0);
            i6++;
        }
        return cArr;
    }
}
