package io.flutter.plugins.camera;

import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugins.camera.features.exposureoffset.ExposureOffsetFeature;
import io.flutter.plugins.camera.features.resolution.ResolutionFeature;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4099a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(Object obj, Object obj2, int i5) {
        this.f4099a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4099a) {
            case 0:
                Camera.lambda$setExposureOffset$7((Messages.Result) this.b, (ExposureOffsetFeature) this.c);
                break;
            case 1:
                ((Camera.AnonymousClass1) this.b).lambda$onOpened$0((ResolutionFeature) this.c);
                break;
            case 2:
                ((DartMessenger) this.b).lambda$sendDeviceOrientationChangeEvent$0((PlatformChannel.DeviceOrientation) this.c);
                break;
            case 3:
                ((Messages.Result) this.b).success(this.c);
                break;
            default:
                ((DartMessenger) this.b).lambda$sendCameraErrorEvent$3((String) this.c);
                break;
        }
    }
}
