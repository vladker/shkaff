package p023d4;

import E3.g;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.C1112a;
import kotlinx.coroutines.flow.internal.E;
import p028e4.H;
import p147z3.Q;

/* JADX INFO: renamed from: d4.c1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0578c1 implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3861a;
    public final /* synthetic */ T b;

    public /* synthetic */ C0578c1(int i5, T t6) {
        this.f3861a = i5;
        this.b = t6;
    }

    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) {
        switch (this.f3861a) {
            case 0:
                this.b.f5689a = obj;
                throw new C1112a(this);
            case 1:
                this.b.f5689a = obj;
                throw new C1112a(this);
            case 2:
                this.b.f5689a = obj;
                return Q.INSTANCE;
            case 3:
                this.b.f5689a = obj;
                return Q.INSTANCE;
            case 4:
                T t6 = this.b;
                if (t6.f5689a != E.NULL) {
                    throw new IllegalArgumentException("Flow has more than one element");
                }
                t6.f5689a = obj;
                return Q.INSTANCE;
            default:
                T t7 = this.b;
                Object obj2 = t7.f5689a;
                H h6 = E.NULL;
                if (obj2 == h6) {
                    t7.f5689a = obj;
                    return Q.INSTANCE;
                }
                t7.f5689a = h6;
                throw new C1112a(this);
        }
    }
}
