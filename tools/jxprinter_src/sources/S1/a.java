package S1;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends ThreadLocal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f614a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f614a) {
            case 0:
                b bVar = new b();
                bVar.f615a = new int[0];
                bVar.b = new int[0];
                bVar.c = new double[0];
                return bVar;
            case 1:
                h hVar = new h();
                hVar.f627a = new double[0];
                hVar.b = new double[0];
                return hVar;
            case 2:
                return new S4.c();
            case 3:
                U1.f fVar = new U1.f();
                fVar.f710a = new double[][]{new double[]{1.0d}};
                return fVar;
            case 4:
                return new Stack();
            default:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(p107s4.d.f8238h);
                return simpleDateFormat;
        }
    }
}
