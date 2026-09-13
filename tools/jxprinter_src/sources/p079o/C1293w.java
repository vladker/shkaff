package p079o;

import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* JADX INFO: renamed from: o.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1293w implements Q {
    public static final C1293w b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DecimalFormat f6422a;

    static {
        C1293w c1293w = new C1293w();
        c1293w.f6422a = null;
        b = c1293w;
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.p(c0.WriteNullNumberAsZero);
            return;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
            b0Var.n();
            return;
        }
        DecimalFormat decimalFormat = this.f6422a;
        if (decimalFormat == null) {
            b0Var.f(dDoubleValue, true);
        } else {
            b0Var.write(decimalFormat.format(dDoubleValue));
        }
    }
}
