package p023d4;

import E3.g;
import F3.i;
import G3.b;
import O3.p;
import kotlin.jvm.internal.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class T {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object count(InterfaceC0612o interfaceC0612o, g<? super Integer> gVar) throws Throwable {
        O o6;
        Q q6;
        if (gVar instanceof O) {
            o6 = (O) gVar;
            int i5 = o6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                o6.c = i5 - Integer.MIN_VALUE;
            } else {
                o6 = new O(gVar);
            }
        } else {
            o6 = new O(gVar);
        }
        Object obj = o6.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = o6.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            Q q7 = new Q();
            InterfaceC0615p l6 = new L(q7, 1);
            o6.f3818a = q7;
            o6.c = 1;
            if (interfaceC0612o.collect(l6, o6) == coroutine_suspended) {
                return coroutine_suspended;
            }
            q6 = q7;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q6 = o6.f3818a;
            v.throwOnFailure(obj);
        }
        return b.boxInt(q6.f5687a);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object count(InterfaceC0612o interfaceC0612o, p pVar, g<? super Integer> gVar) throws Throwable {
        P p6;
        Q q6;
        if (gVar instanceof P) {
            p6 = (P) gVar;
            int i5 = p6.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                p6.c = i5 - Integer.MIN_VALUE;
            } else {
                p6 = new P(gVar);
            }
        } else {
            p6 = new P(gVar);
        }
        Object obj = p6.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = p6.c;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            Q q7 = new Q();
            InterfaceC0615p s6 = new S(pVar, q7, 0);
            p6.f3821a = q7;
            p6.c = 1;
            if (interfaceC0612o.collect(s6, p6) == coroutine_suspended) {
                return coroutine_suspended;
            }
            q6 = q7;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q6 = p6.f3821a;
            v.throwOnFailure(obj);
        }
        return b.boxInt(q6.f5687a);
    }
}
