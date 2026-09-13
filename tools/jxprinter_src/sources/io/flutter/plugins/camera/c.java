package io.flutter.plugins.camera;

import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements ErrorCallback, CameraPermissions.PermissionsRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4100a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f4100a = i5;
        this.b = obj;
    }

    @Override // io.flutter.plugins.camera.CameraPermissions.PermissionsRegistry
    public void addListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
        ((ActivityPluginBinding) this.b).addRequestPermissionsResultListener(requestPermissionsResultListener);
    }

    @Override // io.flutter.plugins.camera.ErrorCallback
    public void onError(String str, String str2) {
        switch (this.f4100a) {
            case 0:
                Camera.lambda$setExposureOffset$8((Messages.Result) this.b, str, str2);
                break;
            default:
                ((Camera.AnonymousClass2) this.b).lambda$onConfigured$0(str, str2);
                break;
        }
    }
}
