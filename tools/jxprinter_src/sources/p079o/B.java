package p079o;

import com.google.common.collect.Multimap;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class B implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B f6320a = new B();

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        if (obj instanceof Multimap) {
            g6.h(((Multimap) obj).asMap());
        }
    }
}
