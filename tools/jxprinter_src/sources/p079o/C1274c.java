package p079o;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/* JADX INFO: renamed from: o.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1274c implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1274c f6379a = new C1274c();

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        if (obj instanceof LongAdder) {
            b0Var.i('{', "value", ((LongAdder) obj).longValue());
            b0Var.write(125);
        } else if (obj instanceof DoubleAdder) {
            double dDoubleValue = ((DoubleAdder) obj).doubleValue();
            b0Var.write(123);
            b0Var.g("value");
            b0Var.f(dDoubleValue, false);
            b0Var.write(125);
        }
    }
}
