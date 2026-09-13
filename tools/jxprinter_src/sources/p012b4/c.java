package p012b4;

import E3.q;
import Q0.b;
import W3.G;
import android.os.Handler;
import android.os.Looper;
import androidx.datastore.core.a;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.E;
import p007a4.C0271d1;
import p007a4.C0276f0;
import p007a4.InterfaceC0280h0;
import p007a4.InterfaceC0285k;
import p007a4.K0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1089a;
    private final Handler handler;
    private final c immediate;
    private final String name;

    public c(Handler handler, String str, boolean z6) {
        this.handler = handler;
        this.name = str;
        this.f1089a = z6;
        this.immediate = z6 ? this : new c(handler, str, true);
    }

    public static void a(c cVar, Runnable runnable) {
        cVar.handler.removeCallbacks(runnable);
    }

    public static Q c(c cVar, b bVar) {
        cVar.handler.removeCallbacks(bVar);
        return Q.INSTANCE;
    }

    public final void d(q qVar, Runnable runnable) {
        K0.cancel(qVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        C0276f0.getIO().mo1035dispatch(qVar, runnable);
    }

    @Override // p007a4.F
    /* JADX INFO: renamed from: dispatch */
    public void mo1035dispatch(q qVar, Runnable runnable) {
        if (this.handler.post(runnable)) {
            return;
        }
        d(qVar, runnable);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.handler == this.handler && cVar.f1089a == this.f1089a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.handler) ^ (this.f1089a ? 1231 : 1237);
    }

    @Override // p012b4.d, p007a4.Y
    public InterfaceC0280h0 invokeOnTimeout(long j6, Runnable runnable, q qVar) {
        Handler handler = this.handler;
        if (j6 > 4611686018427387903L) {
            j6 = 4611686018427387903L;
        }
        if (handler.postDelayed(runnable, j6)) {
            return new a(this, runnable, 1);
        }
        d(qVar, runnable);
        return C0271d1.INSTANCE;
    }

    @Override // p007a4.F
    public boolean isDispatchNeeded(q qVar) {
        return (this.f1089a && E.a(Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // p012b4.d, p007a4.Y
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo1036scheduleResumeAfterDelay(long j6, InterfaceC0285k interfaceC0285k) {
        b bVar = new b(interfaceC0285k, this, 4);
        Handler handler = this.handler;
        if (j6 > 4611686018427387903L) {
            j6 = 4611686018427387903L;
        }
        if (handler.postDelayed(bVar, j6)) {
            interfaceC0285k.invokeOnCancellation(new G(this, bVar, 1));
        } else {
            d(interfaceC0285k.getContext(), bVar);
        }
    }

    @Override // p007a4.AbstractC0265b1, p007a4.F
    public String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl != null) {
            return stringInternalImpl;
        }
        String string = this.name;
        if (string == null) {
            string = this.handler.toString();
        }
        return this.f1089a ? androidx.collection.a.n(string, ".immediate") : string;
    }

    @Override // p012b4.d, p007a4.AbstractC0265b1
    public c getImmediate() {
        return this.immediate;
    }

    public c(Handler handler, String str) {
        this(handler, str, false);
    }
}
