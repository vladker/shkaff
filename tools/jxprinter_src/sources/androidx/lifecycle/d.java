package androidx.lifecycle;

import p018c4.x0;
import p023d4.V1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1057a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d(Object obj, int i5) {
        this.f1057a = i5;
        this.b = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.f1057a) {
            case 0:
                ((x0) this.b).mo1011trySendJP2dKIU(event);
                break;
            default:
                Lifecycle._get_currentStateFlow_$lambda$0((V1) this.b, lifecycleOwner, event);
                break;
        }
    }
}
