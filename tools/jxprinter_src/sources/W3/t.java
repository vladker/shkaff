package W3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t {
    public static <T> Iterator<T> iterator(O3.p block) {
        kotlin.jvm.internal.E.f(block, "block");
        r rVar = new r();
        rVar.setNextStep(F3.h.createCoroutineUnintercepted(block, rVar, rVar));
        return rVar;
    }

    public static <T> InterfaceC0233q sequence(O3.p block) {
        kotlin.jvm.internal.E.f(block, "block");
        return new A3.B(block, 10);
    }
}
