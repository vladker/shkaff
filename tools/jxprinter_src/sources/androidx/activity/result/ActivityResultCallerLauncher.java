package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.E;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<Q> {
    private final ActivityResultContract<I, O> callerContract;
    private final I callerInput;
    private final ActivityResultContract<Q, O> contract;
    private final ActivityResultLauncher<I> launcher;
    private final InterfaceC1934n resultContract$delegate;

    public ActivityResultCallerLauncher(ActivityResultLauncher<I> launcher, ActivityResultContract<I, O> callerContract, I i5) {
        E.f(launcher, "launcher");
        E.f(callerContract, "callerContract");
        this.launcher = launcher;
        this.callerContract = callerContract;
        this.callerInput = i5;
        this.resultContract$delegate = AbstractC1935o.lazy(new ActivityResultCallerLauncher$resultContract$2(this));
        this.contract = getResultContract();
    }

    private final ActivityResultContract<Q, O> getResultContract() {
        return (ActivityResultContract) this.resultContract$delegate.getValue();
    }

    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    public final I getCallerInput() {
        return this.callerInput;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public ActivityResultContract<Q, ?> getContract() {
        return this.contract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(Q input, ActivityOptionsCompat activityOptionsCompat) {
        E.f(input, "input");
        this.launcher.launch(this.callerInput, activityOptionsCompat);
    }
}
