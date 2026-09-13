package io.flutter.plugins.camera;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements ErrorCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4098a;
    public final /* synthetic */ Messages.VoidResult b;

    public /* synthetic */ a(Messages.VoidResult voidResult, int i5) {
        this.f4098a = i5;
        this.b = voidResult;
    }

    @Override // io.flutter.plugins.camera.ErrorCallback
    public final void onError(String str, String str2) {
        switch (this.f4098a) {
            case 0:
                Camera.lambda$setFocusPoint$6(this.b, str, str2);
                break;
            case 1:
                Camera.lambda$setExposureMode$4(this.b, str, str2);
                break;
            case 2:
                Camera.lambda$setFlashMode$3(this.b, str, str2);
                break;
            case 3:
                Camera.lambda$setExposurePoint$5(this.b, str, str2);
                break;
            default:
                Camera.lambda$setZoomLevel$9(this.b, str, str2);
                break;
        }
    }
}
