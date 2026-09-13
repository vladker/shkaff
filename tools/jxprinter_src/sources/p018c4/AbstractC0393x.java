package p018c4;

import E3.g;
import F3.i;
import p147z3.v;

/* JADX INFO: renamed from: c4.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0393x {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object next(InterfaceC0395z interfaceC0395z, g gVar) throws Throwable {
        C0394y c0394y;
        InterfaceC0395z interfaceC0395z2;
        if (gVar instanceof C0394y) {
            c0394y = (C0394y) gVar;
            int i5 = c0394y.c;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c0394y.c = i5 - Integer.MIN_VALUE;
            } else {
                c0394y = new C0394y(gVar);
            }
        } else {
            c0394y = new C0394y(gVar);
        }
        Object objHasNext = c0394y.b;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = c0394y.c;
        if (i6 == 0) {
            v.throwOnFailure(objHasNext);
            c0394y.f1190a = interfaceC0395z;
            c0394y.c = 1;
            interfaceC0395z2 = (C0374e) interfaceC0395z;
            objHasNext = interfaceC0395z2.hasNext(c0394y);
            if (objHasNext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC0395z2 = c0394y.f1190a;
            v.throwOnFailure(objHasNext);
        }
        if (((Boolean) objHasNext).booleanValue()) {
            return ((C0374e) interfaceC0395z2).a();
        }
        throw new q0(F.DEFAULT_CLOSE_MESSAGE);
    }
}
