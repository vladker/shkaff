package io.flutter.plugins.camera;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4102a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e(Object obj, int i5) {
        this.f4102a = i5;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4102a) {
            case 0:
                ((Camera) this.b).lambda$startCapture$0();
                break;
            case 1:
                ((Messages.VoidResult) this.b).success();
                break;
            default:
                ((DartMessenger) this.b).lambda$sendCameraClosingEvent$2();
                break;
        }
    }
}
