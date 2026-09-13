package cn.bertsir.zbar;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1193a;
    public final /* synthetic */ QRActivity b;

    public /* synthetic */ a(QRActivity qRActivity, int i5) {
        this.f1193a = i5;
        this.b = qRActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1193a) {
            case 0:
                this.b.lambda$recognitionLocation$1();
                break;
            default:
                this.b.lambda$recognitionLocation$0();
                break;
        }
    }
}
