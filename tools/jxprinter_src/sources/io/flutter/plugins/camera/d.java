package io.flutter.plugins.camera;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements ErrorCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4101a;
    public final /* synthetic */ Camera b;

    public /* synthetic */ d(Camera camera, int i5) {
        this.f4101a = i5;
        this.b = camera;
    }

    @Override // io.flutter.plugins.camera.ErrorCallback
    public final void onError(String str, String str2) {
        switch (this.f4101a) {
            case 0:
                this.b.lambda$resumePreview$10(str, str2);
                break;
            case 1:
                this.b.lambda$runPrecaptureSequence$1(str, str2);
                break;
            default:
                this.b.lambda$unlockAutoFocus$2(str, str2);
                break;
        }
    }
}
