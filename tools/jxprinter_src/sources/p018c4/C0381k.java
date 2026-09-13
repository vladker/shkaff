package p018c4;

import O3.q;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.jvm.internal.B;

/* JADX INFO: renamed from: c4.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0381k extends B implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0381k f1167a = new C0381k(3, C0376f.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C0376f c0376f = (C0376f) obj;
        AtomicLongFieldUpdater atomicLongFieldUpdater = C0376f.b;
        c0376f.getClass();
        return B.b(obj3 == AbstractC0388s.getCHANNEL_CLOSED() ? B.Companion.m1008closedJP2dKIU(c0376f.getCloseCause()) : B.Companion.m1010successJP2dKIU(obj3));
    }
}
