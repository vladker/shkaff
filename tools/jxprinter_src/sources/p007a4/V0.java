package p007a4;

import O3.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.B;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class V0 extends B implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final V0 f947a = new V0(3, X0.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) throws Throwable {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = X0.f949a;
        ((X0) obj).getClass();
        if (obj3 instanceof C0314z) {
            throw ((C0314z) obj3).cause;
        }
        return obj3;
    }
}
