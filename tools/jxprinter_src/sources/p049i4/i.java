package p049i4;

import E3.g;
import O3.a;
import p028e4.H;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {
    private static final H NO_OWNER = new H("NO_OWNER");
    private static final H ON_LOCK_ALREADY_LOCKED_BY_OWNER = new H("ALREADY_LOCKED_BY_OWNER");

    public static final b Mutex(boolean z6) {
        return new g(z6);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object withLock(b bVar, Object obj, a aVar, g<? super T> gVar) throws Throwable {
        h hVar;
        b bVar2;
        if (gVar instanceof h) {
            hVar = (h) gVar;
            int i5 = hVar.e;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                hVar.e = i5 - Integer.MIN_VALUE;
            } else {
                hVar = new h(gVar);
            }
        } else {
            hVar = new h(gVar);
        }
        Object obj2 = hVar.d;
        Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
        int i6 = hVar.e;
        if (i6 == 0) {
            v.throwOnFailure(obj2);
            hVar.f4069a = bVar;
            hVar.b = obj;
            hVar.c = aVar;
            hVar.e = 1;
            bVar2 = (g) bVar;
            if (bVar2.lock(obj, hVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = hVar.c;
            obj = hVar.b;
            bVar2 = hVar.f4069a;
            v.throwOnFailure(obj2);
        }
        try {
            return aVar.invoke();
        } finally {
            ((g) bVar2).unlock(obj);
        }
    }
}
