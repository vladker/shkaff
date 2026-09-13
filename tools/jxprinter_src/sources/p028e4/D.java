package p028e4;

import E3.g;
import E3.q;
import F3.h;
import G3.e;
import p007a4.AbstractC0260a;
import p007a4.B;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class D extends AbstractC0260a implements e {
    public final g<Object> uCont;

    public D(q qVar, g<Object> gVar) {
        super(qVar, true, true);
        this.uCont = gVar;
    }

    @Override // p007a4.X0
    public void afterCompletion(Object obj) {
        AbstractC0655i.resumeCancellableWith(h.intercepted(this.uCont), B.recoverResult(obj, this.uCont));
    }

    @Override // p007a4.AbstractC0260a
    public void afterResume(Object obj) {
        g<Object> gVar = this.uCont;
        gVar.resumeWith(B.recoverResult(obj, gVar));
    }

    @Override // G3.e
    public final e getCallerFrame() {
        g<Object> gVar = this.uCont;
        if (gVar instanceof e) {
            return (e) gVar;
        }
        return null;
    }

    @Override // G3.e
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // p007a4.X0
    public final boolean l() {
        return true;
    }
}
