package androidx.activity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f967a;
    public final /* synthetic */ ComponentActivity b;

    public /* synthetic */ g(ComponentActivity componentActivity, int i5) {
        this.f967a = i5;
        this.b = componentActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f967a) {
            case 0:
                ComponentActivity$onBackPressedDispatcher$2.invoke$lambda$0(this.b);
                break;
            default:
                this.b.invalidateMenu();
                break;
        }
    }
}
