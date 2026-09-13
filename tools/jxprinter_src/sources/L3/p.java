package L3;

import java.util.ArrayList;
import kotlin.jvm.internal.E;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f452a;
    public final /* synthetic */ ArrayList b;

    public /* synthetic */ p(ArrayList arrayList, int i5) {
        this.f452a = i5;
        this.b = arrayList;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        String it = (String) obj;
        switch (this.f452a) {
            case 0:
                E.f(it, "it");
                this.b.add(it);
                break;
            default:
                E.f(it, "it");
                this.b.add(it);
                break;
        }
        return Q.INSTANCE;
    }
}
