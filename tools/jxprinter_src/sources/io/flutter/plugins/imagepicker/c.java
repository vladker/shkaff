package io.flutter.plugins.imagepicker;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements ImagePickerDelegate.OnPathReadyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4127a;
    public final /* synthetic */ ImagePickerDelegate b;

    public /* synthetic */ c(ImagePickerDelegate imagePickerDelegate, int i5) {
        this.f4127a = i5;
        this.b = imagePickerDelegate;
    }

    @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.OnPathReadyListener
    public final void onPathReady(String str) {
        switch (this.f4127a) {
            case 0:
                this.b.lambda$handleCaptureImageResult$7(str);
                break;
            default:
                this.b.finishWithSuccess(str);
                break;
        }
    }
}
