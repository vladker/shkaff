package p079o;

import java.lang.reflect.Type;

/* JADX INFO: renamed from: o.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1294x implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1294x f6423a = new C1294x();

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        String string;
        b0 b0Var = g6.f6325j;
        Enum r6 = (Enum) obj;
        if (r6 == null) {
            b0Var.n();
            return;
        }
        if (!b0Var.f6375k || b0Var.f6376l) {
            string = b0Var.f6376l ? r6.toString() : null;
        } else {
            string = r6.name();
        }
        if (string == null) {
            b0Var.l(r6.ordinal());
            return;
        }
        int i6 = b0Var.d(c0.UseSingleQuotes) ? 39 : 34;
        b0Var.write(i6);
        b0Var.write(string);
        b0Var.write(i6);
    }
}
