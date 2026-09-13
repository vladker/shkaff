package androidx.activity.result;

import O3.l;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.jvm.internal.E;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerKt {
    public static final <I, O> ActivityResultLauncher<Q> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> contract, I i5, ActivityResultRegistry registry, l callback) {
        E.f(activityResultCaller, "<this>");
        E.f(contract, "contract");
        E.f(registry, "registry");
        E.f(callback, "callback");
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(contract, registry, new a(0, callback)), contract, i5);
    }

    public static final <I, O> ActivityResultLauncher<Q> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> contract, I i5, l callback) {
        E.f(activityResultCaller, "<this>");
        E.f(contract, "contract");
        E.f(callback, "callback");
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(contract, new a(1, callback)), contract, i5);
    }
}
