package p028e4;

import E3.g;
import E3.q;
import androidx.collection.a;
import p007a4.AbstractC0265b1;
import p007a4.F;
import p007a4.InterfaceC0280h0;
import p007a4.InterfaceC0285k;
import p007a4.X;
import p007a4.Y;
import p147z3.C1929i;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends AbstractC0265b1 implements Y {
    private final Throwable cause;
    private final String errorHint;

    public y(Throwable th, String str) {
        this.cause = th;
        this.errorHint = str;
    }

    public final void a() {
        String strConcat;
        if (this.cause == null) {
            x.throwMissingMainDispatcherException();
            throw new C1929i();
        }
        String str = this.errorHint;
        if (str == null || (strConcat = ". ".concat(str)) == null) {
            strConcat = "";
        }
        throw new IllegalStateException("Module with the Main dispatcher had failed to initialize".concat(strConcat), this.cause);
    }

    @Override // p007a4.Y
    public Object delay(long j6, g<? super Q> gVar) {
        return X.delay(this, j6, gVar);
    }

    @Override // p007a4.Y
    public InterfaceC0280h0 invokeOnTimeout(long j6, Runnable runnable, q qVar) {
        a();
        throw null;
    }

    @Override // p007a4.F
    public boolean isDispatchNeeded(q qVar) {
        a();
        throw null;
    }

    @Override // p007a4.AbstractC0265b1, p007a4.F
    public F limitedParallelism(int i5, String str) {
        a();
        throw null;
    }

    @Override // p007a4.AbstractC0265b1, p007a4.F
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dispatchers.Main[missing");
        if (this.cause != null) {
            str = ", cause=" + this.cause;
        } else {
            str = "";
        }
        return a.f(']', str, sb);
    }

    @Override // p007a4.F
    /* JADX INFO: renamed from: dispatch, reason: merged with bridge method [inline-methods] */
    public Void mo1035dispatch(q qVar, Runnable runnable) {
        a();
        throw null;
    }

    @Override // p007a4.Y
    /* JADX INFO: renamed from: scheduleResumeAfterDelay, reason: merged with bridge method [inline-methods] */
    public Void mo1036scheduleResumeAfterDelay(long j6, InterfaceC0285k interfaceC0285k) {
        a();
        throw null;
    }

    @Override // p007a4.AbstractC0265b1
    public AbstractC0265b1 getImmediate() {
        return this;
    }
}
