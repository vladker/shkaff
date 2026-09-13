package androidx.core.widget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1035a;
    public final /* synthetic */ ContentLoadingProgressBar b;

    public /* synthetic */ a(ContentLoadingProgressBar contentLoadingProgressBar, int i5) {
        this.f1035a = i5;
        this.b = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1035a) {
            case 0:
                this.b.lambda$new$0();
                break;
            case 1:
                this.b.lambda$new$1();
                break;
            case 2:
                this.b.showOnUiThread();
                break;
            default:
                this.b.hideOnUiThread();
                break;
        }
    }
}
