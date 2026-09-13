package p079o;

import androidx.collection.a;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import p050j.d;
import p050j.e;
import p067m.b;
import p067m.g;
import p073n.p;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C f6321a = new C();

    @Override // p073n.p
    public final int a() {
        return 2;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        Integer numValueOf;
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        if (i5 == 8) {
            gVar.n(16);
            return null;
        }
        if (i5 == 2) {
            try {
                int iG = gVar.g();
                gVar.n(16);
                numValueOf = Integer.valueOf(iG);
            } catch (NumberFormatException e) {
                throw new d(a.l(obj, "int value overflow, field : "), e);
            }
        } else if (i5 == 3) {
            BigDecimal bigDecimalD = gVar.d();
            gVar.n(16);
            numValueOf = Integer.valueOf(bigDecimalD.intValue());
        } else if (i5 == 12) {
            e eVar = new e(true, 0);
            bVar.m(eVar, null);
            numValueOf = j.k(eVar);
        } else {
            numValueOf = j.k(bVar.h(null));
        }
        return type == AtomicInteger.class ? new AtomicInteger(numValueOf.intValue()) : numValueOf;
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        Number number = (Number) obj;
        if (number == null) {
            b0Var.p(c0.WriteNullNumberAsZero);
            return;
        }
        if (obj instanceof Long) {
            b0Var.m(number.longValue());
        } else {
            b0Var.l(number.intValue());
        }
        if (b0Var.d(c0.WriteClassName)) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                b0Var.write(66);
            } else if (cls == Short.class) {
                b0Var.write(83);
            }
        }
    }
}
