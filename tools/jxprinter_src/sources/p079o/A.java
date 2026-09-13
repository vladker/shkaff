package p079o;

import androidx.collection.a;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import p067m.b;
import p067m.g;
import p073n.p;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class A implements Q, p {
    public static final A b = new A();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DecimalFormat f6319a;

    @Override // p073n.p
    public final int a() {
        return 2;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        if (i5 == 2) {
            String strP = gVar.p();
            gVar.n(16);
            return Float.valueOf(Float.parseFloat(strP));
        }
        if (i5 == 3) {
            float fE = gVar.e();
            gVar.n(16);
            return Float.valueOf(fE);
        }
        Object objH = bVar.h(null);
        if (objH == null) {
            return null;
        }
        return j.j(objH);
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.p(c0.WriteNullNumberAsZero);
            return;
        }
        float fFloatValue = ((Float) obj).floatValue();
        DecimalFormat decimalFormat = this.f6319a;
        if (decimalFormat != null) {
            b0Var.write(decimalFormat.format(fFloatValue));
            return;
        }
        b0Var.getClass();
        if (Float.isNaN(fFloatValue) || Float.isInfinite(fFloatValue)) {
            b0Var.n();
            return;
        }
        String string = Float.toString(fFloatValue);
        if (b0Var.d(c0.WriteNullNumberAsZero) && string.endsWith(".0")) {
            string = a.g(2, 0, string);
        }
        b0Var.write(string);
        if (b0Var.d(c0.WriteClassName)) {
            b0Var.write(70);
        }
    }
}
