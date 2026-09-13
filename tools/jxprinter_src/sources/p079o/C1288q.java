package p079o;

import androidx.collection.a;
import java.lang.reflect.Type;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import p050j.d;
import p067m.b;
import p073n.p;
import p096r.j;

/* JADX INFO: renamed from: o.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1288q implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1288q f6418a = new C1288q();

    @Override // p073n.p
    public final int a() {
        return 4;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        Object objH = bVar.h(null);
        if (objH != null) {
            boolean z6 = j.f7921a;
            if (objH instanceof Character) {
                return (Character) objH;
            }
            if (!(objH instanceof String)) {
                throw new d(a.l(objH, "can not cast to char, value : "));
            }
            String str = (String) objH;
            if (str.length() != 0) {
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                throw new d(a.l(objH, "can not cast to char, value : "));
            }
        }
        return null;
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        Character ch = (Character) obj;
        if (ch == null) {
            b0Var.q("");
        } else if (ch.charValue() == 0) {
            b0Var.q(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR);
        } else {
            b0Var.q(ch.toString());
        }
    }
}
