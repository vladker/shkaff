package p018c4;

import O3.q;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.jvm.internal.B;

/* JADX INFO: renamed from: c4.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0379i extends B implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0379i f1163a = new C0379i(3, C0376f.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) throws Throwable {
        C0376f c0376f = (C0376f) obj;
        AtomicLongFieldUpdater atomicLongFieldUpdater = C0376f.b;
        c0376f.getClass();
        if (obj3 != AbstractC0388s.getCHANNEL_CLOSED()) {
            return obj3;
        }
        throw c0376f.m();
    }
}
