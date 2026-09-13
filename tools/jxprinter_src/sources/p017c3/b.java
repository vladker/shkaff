package p017c3;

import java.io.PrintStream;
import java.io.PrintWriter;
import p079o.AbstractC1275d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends AbstractC1275d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1100a;
    public final Object b;

    public /* synthetic */ b(Object obj, int i5) {
        this.f1100a = i5;
        this.b = obj;
    }

    @Override // p079o.AbstractC1275d
    public final void a(String str) {
        switch (this.f1100a) {
            case 0:
                ((PrintStream) this.b).println((Object) str);
                break;
            default:
                ((PrintWriter) this.b).println((Object) str);
                break;
        }
    }
}
