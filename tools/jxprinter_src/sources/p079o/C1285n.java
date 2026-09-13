package p079o;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import p067m.b;
import p067m.g;
import p073n.p;
import p096r.j;

/* JADX INFO: renamed from: o.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1285n implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1285n f6416a = new C1285n();

    @Override // p073n.p
    public final int a() {
        return 6;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        Boolean boolF;
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        if (i5 == 6) {
            gVar.n(16);
            boolF = Boolean.TRUE;
        } else if (i5 == 7) {
            gVar.n(16);
            boolF = Boolean.FALSE;
        } else if (i5 == 2) {
            int iG = gVar.g();
            gVar.n(16);
            boolF = iG == 1 ? Boolean.TRUE : Boolean.FALSE;
        } else {
            Object objH = bVar.h(null);
            if (objH == null) {
                return null;
            }
            boolF = j.f(objH);
        }
        return type == AtomicBoolean.class ? new AtomicBoolean(boolF.booleanValue()) : boolF;
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            b0Var.p(c0.WriteNullBooleanAsFalse);
        } else if (bool.booleanValue()) {
            b0Var.write("true");
        } else {
            b0Var.write("false");
        }
    }
}
