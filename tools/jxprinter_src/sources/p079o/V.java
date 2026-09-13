package p079o;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;
import p067m.b;
import p073n.p;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class V implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final V f6343a = new V();

    @Override // p073n.p
    public final int a() {
        return 12;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Object objL = bVar.l(null, parameterizedType.getActualTypeArguments()[0]);
        Type rawType = parameterizedType.getRawType();
        if (rawType == AtomicReference.class) {
            return new AtomicReference(objL);
        }
        if (rawType == WeakReference.class) {
            return new WeakReference(objL);
        }
        if (rawType == SoftReference.class) {
            return new SoftReference(objL);
        }
        throw new UnsupportedOperationException(rawType.toString());
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        g6.h(obj instanceof AtomicReference ? ((AtomicReference) obj).get() : ((Reference) obj).get());
    }
}
