package androidx.fragment.app;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1047a;
    public final /* synthetic */ SpecialEffectsController.Operation b;
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect c;

    public /* synthetic */ c(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController.TransitionEffect transitionEffect, int i5) {
        this.f1047a = i5;
        this.b = operation;
        this.c = transitionEffect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1047a) {
            case 0:
                DefaultSpecialEffectsController.TransitionEffect.onStart$lambda$6$lambda$5(this.b, this.c);
                break;
            default:
                DefaultSpecialEffectsController.TransitionEffect.onCommit$lambda$11$lambda$10(this.b, this.c);
                break;
        }
    }
}
