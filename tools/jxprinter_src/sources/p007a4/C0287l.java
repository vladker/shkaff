package p007a4;

import O3.l;
import O3.q;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import p018c4.C0370c;
import p018c4.C0376f;
import p028e4.A;
import p028e4.H;
import p044h4.o;
import p049i4.g;
import p049i4.m;
import p147z3.Q;

/* JADX INFO: renamed from: a4.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0287l implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f952a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0287l(Object obj, int i5) {
        this.f952a = i5;
        this.b = obj;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, final Object obj3) {
        int i5 = this.f952a;
        Object obj4 = this.b;
        switch (i5) {
            case 0:
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C0289m.f954a;
                ((l) obj4).invoke((Throwable) obj);
                return Q.INSTANCE;
            case 1:
                final C0376f c0376f = (C0376f) obj4;
                final o oVar = (o) obj;
                AtomicLongFieldUpdater atomicLongFieldUpdater = C0376f.b;
                return new q() { // from class: c4.d
                    @Override // O3.q
                    public final Object invoke(Object obj5, Object obj6, Object obj7) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = C0376f.b;
                        H channel_closed = AbstractC0388s.getCHANNEL_CLOSED();
                        Object obj8 = obj3;
                        if (obj8 != channel_closed) {
                            A.callUndeliveredElement(c0376f.onUndeliveredElement, obj8, oVar.getContext());
                        }
                        return Q.INSTANCE;
                    }
                };
            case 2:
                return new C0370c((g) obj4, obj2, 1);
            default:
                ((m) obj4).b();
                return Q.INSTANCE;
        }
    }
}
