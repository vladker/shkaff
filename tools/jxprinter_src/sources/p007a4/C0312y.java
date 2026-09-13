package p007a4;

import O3.q;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: a4.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0312y {
    public final Throwable cancelCause;
    public final InterfaceC0283j cancelHandler;
    public final Object idempotentResume;
    public final q onCancellation;
    public final Object result;

    public C0312y(Object obj, InterfaceC0283j interfaceC0283j, q qVar, Object obj2, Throwable th) {
        this.result = obj;
        this.cancelHandler = interfaceC0283j;
        this.onCancellation = qVar;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }

    public static /* synthetic */ C0312y a(C0312y c0312y, InterfaceC0283j interfaceC0283j, Throwable th, int i5) {
        Object obj = c0312y.result;
        if ((i5 & 2) != 0) {
            interfaceC0283j = c0312y.cancelHandler;
        }
        InterfaceC0283j interfaceC0283j2 = interfaceC0283j;
        q qVar = c0312y.onCancellation;
        Object obj2 = c0312y.idempotentResume;
        if ((i5 & 16) != 0) {
            th = c0312y.cancelCause;
        }
        return c0312y.copy(obj, interfaceC0283j2, qVar, obj2, th);
    }

    public final InterfaceC0283j component2() {
        return this.cancelHandler;
    }

    public final q component3() {
        return this.onCancellation;
    }

    public final Object component4() {
        return this.idempotentResume;
    }

    public final Throwable component5() {
        return this.cancelCause;
    }

    public final C0312y copy(Object obj, InterfaceC0283j interfaceC0283j, q qVar, Object obj2, Throwable th) {
        return new C0312y(obj, interfaceC0283j, qVar, obj2, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0312y)) {
            return false;
        }
        C0312y c0312y = (C0312y) obj;
        return E.a(this.result, c0312y.result) && E.a(this.cancelHandler, c0312y.cancelHandler) && E.a(this.onCancellation, c0312y.onCancellation) && E.a(this.idempotentResume, c0312y.idempotentResume) && E.a(this.cancelCause, c0312y.cancelCause);
    }

    public final int hashCode() {
        Object obj = this.result;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        InterfaceC0283j interfaceC0283j = this.cancelHandler;
        int iHashCode2 = (iHashCode + (interfaceC0283j == null ? 0 : interfaceC0283j.hashCode())) * 31;
        q qVar = this.onCancellation;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj2 = this.idempotentResume;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.cancelCause;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final void invokeHandlers(C0289m c0289m, Throwable th) {
        InterfaceC0283j interfaceC0283j = this.cancelHandler;
        if (interfaceC0283j != null) {
            c0289m.callCancelHandler(interfaceC0283j, th);
        }
        q qVar = this.onCancellation;
        if (qVar != null) {
            c0289m.callOnCancellation(qVar, th, this.result);
        }
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }

    public /* synthetic */ C0312y(Object obj, InterfaceC0283j interfaceC0283j, q qVar, Object obj2, Throwable th, int i5) {
        this(obj, (i5 & 2) != 0 ? null : interfaceC0283j, (i5 & 4) != 0 ? null : qVar, (i5 & 8) != 0 ? null : obj2, (i5 & 16) != 0 ? null : th);
    }
}
