package p049i4;

import E3.g;
import F3.i;
import O3.a;
import p028e4.H;
import p028e4.I;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f4075a = I.systemProp("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 1, (8 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    private static final H PERMIT = new H("PERMIT");
    private static final H TAKEN = new H("TAKEN");
    private static final H BROKEN = new H("BROKEN");
    private static final H CANCELLED = new H("CANCELLED");
    public static final int b = I.systemProp("kotlinx.coroutines.semaphore.segmentSize", 16, 1, (8 & 8) != 0 ? Integer.MAX_VALUE : 2097150);

    public static final j Semaphore(int i5, int i6) {
        return new n(i5, i6);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Object withPermit(j jVar, a aVar, g<? super T> gVar) throws Throwable {
        o oVar;
        Object obj;
        if (gVar instanceof o) {
            oVar = (o) gVar;
            int i5 = oVar.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                oVar.d = i5 - Integer.MIN_VALUE;
            } else {
                oVar = new o(gVar);
            }
        } else {
            oVar = new o(gVar);
        }
        Object obj2 = oVar.c;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = oVar.d;
        if (i6 == 0) {
            v.throwOnFailure(obj2);
            oVar.f4074a = jVar;
            oVar.b = aVar;
            oVar.d = 1;
            if (((m) jVar).acquire(oVar) == coroutine_suspended) {
                obj = jVar;
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = oVar.b;
            Object obj3 = oVar.f4074a;
            v.throwOnFailure(obj2);
            obj = obj3;
        }
        try {
            obj = jVar;
            return aVar.invoke();
        } finally {
            ((m) obj).b();
        }
    }
}
