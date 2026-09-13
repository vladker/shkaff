package p018c4;

import O3.l;
import O3.q;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import p028e4.A;
import p049i4.c;
import p049i4.g;
import p147z3.Q;

/* JADX INFO: renamed from: c4.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0370c implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1137a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C0370c(Object obj, Object obj2, int i5) {
        this.f1137a = i5;
        this.c = obj;
        this.b = obj2;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i5 = this.f1137a;
        Object obj4 = this.b;
        Object obj5 = this.c;
        switch (i5) {
            case 0:
                AtomicLongFieldUpdater atomicLongFieldUpdater = C0376f.b;
                A.callUndeliveredElement((l) obj5, obj4, (E3.q) obj3);
                break;
            case 1:
                ((g) obj5).unlock(obj4);
                break;
            default:
                g gVar = (g) obj5;
                c cVar = (c) obj4;
                g.f4068g.set(gVar, cVar.owner);
                gVar.unlock(cVar.owner);
                break;
        }
        return Q.INSTANCE;
    }
}
