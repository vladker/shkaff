package p023d4;

import E3.g;
import java.util.Collection;
import kotlin.jvm.internal.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3811a;
    public final /* synthetic */ Object b;

    public /* synthetic */ L(Object obj, int i5) {
        this.f3811a = i5;
        this.b = obj;
    }

    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) {
        switch (this.f3811a) {
            case 0:
                ((Collection) this.b).add(obj);
                break;
            default:
                ((Q) this.b).f5687a++;
                break;
        }
        return p147z3.Q.INSTANCE;
    }
}
