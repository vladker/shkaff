package p079o;

import java.lang.reflect.Type;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1127c;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class K implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final K f6337a = new K();

    @Override // p079o.Q, p079o.InterfaceC1290t
    public final void write(G g6, Object obj, Object obj2, Type type, int i5) {
        int i6;
        b0 b0Var = g6.f6325j;
        Y y6 = g6.f6324i;
        boolean zD = b0Var.d(c0.WriteClassName);
        b0 b0Var2 = g6.f6325j;
        Type typeS = zD ? j.s(type) : null;
        if (obj == null) {
            b0Var2.p(c0.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj;
        if (list.size() == 0) {
            b0Var2.a("[]");
            return;
        }
        W w6 = g6.f6331p;
        g6.g(w6, obj, obj2, 0);
        try {
            int i7 = 93;
            int i8 = 44;
            if (b0Var2.d(c0.PrettyFormat)) {
                b0Var2.write(91);
                g6.f6326k++;
                int i9 = 0;
                for (Object obj3 : list) {
                    if (i9 != 0) {
                        b0Var2.write(44);
                    }
                    g6.f();
                    if (obj3 == null) {
                        b0Var2.n();
                    } else if (g6.e(obj3)) {
                        g6.j(obj3);
                    } else {
                        Q qB = y6.b(obj3.getClass());
                        g6.f6331p = new W(w6, obj, obj2, 0);
                        qB.write(g6, obj3, Integer.valueOf(i9), typeS, 0);
                    }
                    i9++;
                }
                g6.f6326k--;
                g6.f();
                b0Var2.write(93);
                return;
            }
            b0Var2.write(91);
            int size = list.size();
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10;
                Object obj4 = list.get(i11);
                if (i11 != 0) {
                    b0Var2.write(i8);
                }
                if (obj4 == null) {
                    b0Var2.a(AbstractC1127c.NULL);
                } else {
                    Class<?> cls = obj4.getClass();
                    if (cls == Integer.class) {
                        b0Var2.l(((Integer) obj4).intValue());
                    } else if (cls == Long.class) {
                        long jLongValue = ((Long) obj4).longValue();
                        if (zD) {
                            b0Var2.m(jLongValue);
                            b0Var2.write(76);
                        } else {
                            b0Var2.m(jLongValue);
                        }
                    } else {
                        if (!b0Var2.f6371g) {
                            g6.f6331p = new W(w6, obj, obj2, 0);
                        }
                        if (g6.e(obj4)) {
                            g6.j(obj4);
                        } else {
                            i6 = i11;
                            y6.b(obj4.getClass()).write(g6, obj4, Integer.valueOf(i6), typeS, 0);
                        }
                        i10 = i6 + 1;
                        size = size;
                        i7 = 93;
                        i8 = 44;
                    }
                }
                i6 = i11;
                i10 = i6 + 1;
                size = size;
                i7 = 93;
                i8 = 44;
            }
            b0Var2.write(i7);
        } finally {
            g6.f6331p = w6;
        }
    }
}
