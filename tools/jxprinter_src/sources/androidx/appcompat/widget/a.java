package androidx.appcompat.widget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f985a;
    public final /* synthetic */ Toolbar b;

    public /* synthetic */ a(Toolbar toolbar, int i5) {
        this.f985a = i5;
        this.b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f985a) {
            case 0:
                this.b.collapseActionView();
                break;
            default:
                this.b.invalidateMenu();
                break;
        }
    }
}
