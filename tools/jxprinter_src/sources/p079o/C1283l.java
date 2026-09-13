package p079o;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import p067m.b;
import p067m.g;
import p073n.p;
import p096r.j;

/* JADX INFO: renamed from: o.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1283l implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1283l f6414a = new C1283l();

    @Override // p073n.p
    public final int a() {
        return 2;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        if (i5 == 2) {
            BigDecimal bigDecimalD = gVar.d();
            gVar.n(16);
            return bigDecimalD;
        }
        if (i5 == 3) {
            BigDecimal bigDecimalD2 = gVar.d();
            gVar.n(16);
            return bigDecimalD2;
        }
        Object objH = bVar.h(null);
        if (objH == null) {
            return null;
        }
        return j.d(objH);
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.p(c0.WriteNullNumberAsZero);
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        b0Var.write(b0Var.d(c0.WriteBigDecimalAsPlain) ? bigDecimal.toPlainString() : bigDecimal.toString());
        if (b0Var.d(c0.WriteClassName) && type != BigDecimal.class && bigDecimal.scale() == 0) {
            b0Var.write(46);
        }
    }
}
