package p079o;

import java.lang.reflect.Type;

/* JADX INFO: renamed from: o.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1276e implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1276e f6408a = new C1276e();

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        if (obj == null) {
            g6.f6325j.p(c0.WriteNullStringAsEmpty);
        } else {
            g6.i(obj.toString());
        }
    }
}
