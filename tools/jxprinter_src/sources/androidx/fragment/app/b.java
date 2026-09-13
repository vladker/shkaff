package androidx.fragment.app;

import java.util.ArrayList;
import kotlin.jvm.internal.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1046a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i5) {
        this.f1046a = i5;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1046a) {
            case 0:
                DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$14((ArrayList) this.b);
                break;
            case 1:
                DefaultSpecialEffectsController.TransitionEffect.onStart$lambda$6$lambda$4((T) this.b);
                break;
            default:
                ((Fragment) this.b).lambda$performCreateView$0();
                break;
        }
    }
}
