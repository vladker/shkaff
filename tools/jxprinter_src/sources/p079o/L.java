package p079o;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;
import p050j.e;
import p067m.b;
import p067m.g;
import p073n.p;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class L implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L f6338a = new L();

    @Override // p073n.p
    public final int a() {
        return 2;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        Long lM;
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        if (i5 == 2) {
            long jLongValue = gVar.longValue();
            gVar.n(16);
            lM = Long.valueOf(jLongValue);
        } else {
            if (i5 == 12) {
                e eVar = new e(true, 0);
                bVar.m(eVar, null);
                lM = j.m(eVar);
            } else {
                lM = j.m(bVar.h(null));
            }
            if (lM == null) {
                return null;
            }
        }
        return type == AtomicLong.class ? new AtomicLong(lM.longValue()) : lM;
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.p(c0.WriteNullNumberAsZero);
            return;
        }
        long jLongValue = ((Long) obj).longValue();
        b0Var.m(jLongValue);
        if (!b0Var.d(c0.WriteClassName) || jLongValue > 2147483647L || jLongValue < -2147483648L || type == Long.class || type == Long.TYPE) {
            return;
        }
        b0Var.write(76);
    }
}
