package p028e4;

import E3.g;
import E3.q;
import p007a4.F;
import p007a4.InterfaceC0280h0;
import p007a4.InterfaceC0285k;
import p007a4.U;
import p007a4.Y;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends F implements Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y f3947a;
    private final F dispatcher;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public z(F f6, String str) {
        Y y6 = f6 instanceof Y ? (Y) f6 : null;
        this.f3947a = y6 == null ? U.getDefaultDelay() : y6;
        this.dispatcher = f6;
        this.name = str;
    }

    @Override // p007a4.Y
    public Object delay(long j6, g<? super Q> gVar) {
        return this.f3947a.delay(j6, gVar);
    }

    @Override // p007a4.F
    /* JADX INFO: renamed from: dispatch */
    public void mo1035dispatch(q qVar, Runnable runnable) {
        this.dispatcher.mo1035dispatch(qVar, runnable);
    }

    @Override // p007a4.F
    public void dispatchYield(q qVar, Runnable runnable) {
        this.dispatcher.dispatchYield(qVar, runnable);
    }

    @Override // p007a4.Y
    public InterfaceC0280h0 invokeOnTimeout(long j6, Runnable runnable, q qVar) {
        return this.f3947a.invokeOnTimeout(j6, runnable, qVar);
    }

    @Override // p007a4.F
    public boolean isDispatchNeeded(q qVar) {
        return this.dispatcher.isDispatchNeeded(qVar);
    }

    @Override // p007a4.Y
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo1036scheduleResumeAfterDelay(long j6, InterfaceC0285k interfaceC0285k) {
        this.f3947a.mo1036scheduleResumeAfterDelay(j6, interfaceC0285k);
    }

    @Override // p007a4.F
    public String toString() {
        return this.name;
    }
}
