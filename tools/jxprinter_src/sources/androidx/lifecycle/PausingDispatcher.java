package androidx.lifecycle;

import E3.q;
import kotlin.jvm.internal.E;
import p007a4.C0276f0;
import p007a4.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcher extends F {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // p007a4.F
    /* JADX INFO: renamed from: dispatch */
    public void mo1035dispatch(q context, Runnable block) {
        E.f(context, "context");
        E.f(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }

    @Override // p007a4.F
    public boolean isDispatchNeeded(q context) {
        E.f(context, "context");
        if (C0276f0.getMain().getImmediate().isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
