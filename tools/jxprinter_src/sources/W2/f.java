package W2;

import androidx.annotation.NonNull;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f790a;

    public f(a aVar) {
        this.f790a = aVar;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (!"check".equals(methodCall.method)) {
            result.notImplemented();
        } else {
            a aVar = this.f790a;
            result.success(aVar.getCapabilitiesFromNetwork(aVar.f785a.getActiveNetwork()));
        }
    }
}
