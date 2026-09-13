package p079o;

import java.lang.reflect.Type;
import p067m.b;
import p067m.g;
import p073n.p;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f6407a = new d0();

    public static String c(b bVar) {
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        if (i5 == 4) {
            String strJ = gVar.J();
            gVar.n(16);
            return strJ;
        }
        if (i5 == 2) {
            String strP = gVar.p();
            gVar.n(16);
            return strP;
        }
        Object objH = bVar.h(null);
        if (objH == null) {
            return null;
        }
        return objH.toString();
    }

    @Override // p073n.p
    public final int a() {
        return 4;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        g gVar = bVar.e;
        if (type == StringBuffer.class) {
            if (gVar.f6092a == 4) {
                String strJ = gVar.J();
                gVar.n(16);
                return new StringBuffer(strJ);
            }
            Object objH = bVar.h(null);
            if (objH != null) {
                return new StringBuffer(objH.toString());
            }
        } else {
            if (type != StringBuilder.class) {
                return c(bVar);
            }
            if (gVar.f6092a == 4) {
                String strJ2 = gVar.J();
                gVar.n(16);
                return new StringBuilder(strJ2);
            }
            Object objH2 = bVar.h(null);
            if (objH2 != null) {
                return new StringBuilder(objH2.toString());
            }
        }
        return null;
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        String str = (String) obj;
        b0 b0Var = g6.f6325j;
        if (str == null) {
            b0Var.p(c0.WriteNullStringAsEmpty);
        } else {
            b0Var.q(str);
        }
    }
}
