package p018c4;

import O3.l;
import O3.q;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.E;
import p028e4.A;
import p147z3.Q;

/* JADX INFO: renamed from: c4.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0377g extends B implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1158a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0377g(C0376f c0376f, int i5) {
        super(3, c0376f, C0376f.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
        this.f1158a = i5;
        switch (i5) {
            case 1:
                super(3, c0376f, C0376f.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
                break;
            default:
                break;
        }
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f1158a) {
            case 0:
                l lVar = ((C0376f) this.receiver).onUndeliveredElement;
                E.c(lVar);
                A.callUndeliveredElement(lVar, obj2, (E3.q) obj3);
                break;
            default:
                Object objC = ((B) obj2).c();
                l lVar2 = ((C0376f) this.receiver).onUndeliveredElement;
                E.c(lVar2);
                Object objM1004getOrNullimpl = B.m1004getOrNullimpl(objC);
                E.c(objM1004getOrNullimpl);
                A.callUndeliveredElement(lVar2, objM1004getOrNullimpl, (E3.q) obj3);
                break;
        }
        return Q.INSTANCE;
    }
}
