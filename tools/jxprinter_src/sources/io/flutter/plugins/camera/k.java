package io.flutter.plugins.camera;

import io.flutter.plugin.common.BasicMessageChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements BasicMessageChannel.Reply, CameraPermissions.ResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4112a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ k(Object obj, Object obj2, int i5) {
        this.f4112a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // io.flutter.plugins.camera.CameraPermissions.ResultCallback
    public void onResult(String str, String str2) {
        ((CameraPermissions) this.b).lambda$requestPermissions$0((CameraPermissions.ResultCallback) this.c, str, str2);
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
    public void reply(Object obj) {
        switch (this.f4112a) {
            case 0:
                Messages.CameraEventApi.lambda$error$1((Messages.VoidResult) this.b, (String) this.c, obj);
                break;
            case 1:
                Messages.CameraEventApi.lambda$closed$2((Messages.VoidResult) this.b, (String) this.c, obj);
                break;
            case 2:
                Messages.CameraEventApi.lambda$initialized$0((Messages.VoidResult) this.b, (String) this.c, obj);
                break;
            default:
                Messages.CameraGlobalEventApi.lambda$deviceOrientationChanged$0((Messages.VoidResult) this.b, (String) this.c, obj);
                break;
        }
    }
}
