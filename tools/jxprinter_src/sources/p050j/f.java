package p050j;

import java.lang.reflect.Type;
import java.util.ArrayList;
import p079o.E;
import p079o.G;
import p079o.b0;
import p079o.c0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements E {
    public static final int c = c0.BrowserSecure.f6406a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5381a;
    public final ArrayList b = new ArrayList();

    public f(String str) {
        this.f5381a = str;
    }

    public final String toString() {
        return a.g(this);
    }

    @Override // p079o.E
    public void write(G g6, Object obj, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        int i6 = c;
        if ((i5 & i6) != 0 || (i6 & b0Var.c) != 0) {
            b0Var.write("/**/");
        }
        b0Var.write(this.f5381a);
        b0Var.write(40);
        int i7 = 0;
        while (true) {
            ArrayList arrayList = this.b;
            if (i7 >= arrayList.size()) {
                b0Var.write(41);
                return;
            }
            if (i7 != 0) {
                b0Var.write(44);
            }
            g6.h(arrayList.get(i7));
            i7++;
        }
    }
}
