package p079o;

import java.lang.reflect.Type;
import java.math.BigInteger;
import p067m.b;
import p067m.g;
import p073n.p;
import p096r.j;

/* JADX INFO: renamed from: o.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1284m implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1284m f6415a = new C1284m();

    @Override // p073n.p
    public final int a() {
        return 2;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        g gVar = bVar.e;
        if (gVar.f6092a == 2) {
            String strP = gVar.p();
            gVar.n(16);
            return new BigInteger(strP);
        }
        Object objH = bVar.h(null);
        if (objH == null) {
            return null;
        }
        return j.e(objH);
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.p(c0.WriteNullNumberAsZero);
        } else {
            b0Var.write(((BigInteger) obj).toString());
        }
    }
}
