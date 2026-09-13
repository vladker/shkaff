package p050j;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import p079o.H;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements p {
    public static final q b = new q(0);
    public static final q c = new q(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5391a;

    public /* synthetic */ q(int i5) {
        this.f5391a = i5;
    }

    public static Integer a(r rVar, Object obj) {
        int size = -1;
        if (obj != null) {
            if (obj instanceof Collection) {
                size = ((Collection) obj).size();
            } else if (obj instanceof Object[]) {
                size = ((Object[]) obj).length;
            } else if (obj.getClass().isArray()) {
                size = Array.getLength(obj);
            } else if (obj instanceof Map) {
                Iterator it = ((Map) obj).values().iterator();
                size = 0;
                while (it.hasNext()) {
                    if (it.next() != null) {
                        size++;
                    }
                }
            } else {
                H hC = rVar.c(obj.getClass());
                if (hC != null) {
                    try {
                        size = hC.getSize(obj);
                    } catch (Exception e) {
                        throw new s("evalSize error : " + rVar.f5392a, e);
                    }
                }
            }
        }
        return Integer.valueOf(size);
    }

    @Override // p050j.p
    public final Object c(r rVar, Object obj, Object obj2) {
        switch (this.f5391a) {
            case 0:
                return a(rVar, obj2);
            default:
                H hC = rVar.c(obj2.getClass());
                if (hC == null) {
                    if (obj2 instanceof Map) {
                        return ((Map) obj2).values();
                    }
                    throw new UnsupportedOperationException();
                }
                try {
                    return hC.getFieldValues(obj2);
                } catch (Exception e) {
                    throw new s("jsonpath error, path " + rVar.f5392a, e);
                }
        }
    }
}
