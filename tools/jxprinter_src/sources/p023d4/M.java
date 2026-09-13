package p023d4;

import E3.g;
import F3.i;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class M {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T, C extends Collection<? super T>> Object toCollection(InterfaceC0612o interfaceC0612o, C c, g<? super C> gVar) throws Throwable {
        K k6;
        if (gVar instanceof K) {
            k6 = (K) gVar;
            int i5 = k6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                k6.c = i5 - Integer.MIN_VALUE;
            } else {
                k6 = new K(gVar);
            }
        } else {
            k6 = new K(gVar);
        }
        Object obj = k6.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = k6.c;
        if (i6 != 0) {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Collection collection = k6.f3809a;
            v.throwOnFailure(obj);
            return collection;
        }
        v.throwOnFailure(obj);
        InterfaceC0615p l6 = new L(c, 0);
        k6.f3809a = c;
        k6.c = 1;
        return interfaceC0612o.collect(l6, k6) == coroutine_suspended ? coroutine_suspended : c;
    }

    public static final <T> Object toList(InterfaceC0612o interfaceC0612o, List<T> list, g<? super List<? extends T>> gVar) {
        return AbstractC0618q.toCollection(interfaceC0612o, list, gVar);
    }

    public static final <T> Object toSet(InterfaceC0612o interfaceC0612o, Set<T> set, g<? super Set<? extends T>> gVar) {
        return AbstractC0618q.toCollection(interfaceC0612o, set, gVar);
    }
}
