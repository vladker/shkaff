package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements SavedStateRegistry.SavedStateProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1049a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e(Object obj, int i5) {
        this.f1049a = i5;
        this.b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        switch (this.f1049a) {
            case 0:
                return ((FragmentActivity) this.b).lambda$init$0();
            default:
                return ((FragmentManager) this.b).lambda$attachController$4();
        }
    }
}
