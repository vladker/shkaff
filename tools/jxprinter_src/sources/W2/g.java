package W2;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements FlutterPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MethodChannel f791a;
    public EventChannel b;
    public e c;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        this.f791a = new MethodChannel(binaryMessenger, "dev.fluttercommunity.plus/connectivity");
        this.b = new EventChannel(binaryMessenger, "dev.fluttercommunity.plus/connectivity_status");
        a aVar = new a((ConnectivityManager) applicationContext.getSystemService("connectivity"));
        f fVar = new f(aVar);
        this.c = new e(applicationContext, aVar);
        this.f791a.setMethodCallHandler(fVar);
        this.b.setStreamHandler(this.c);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f791a.setMethodCallHandler(null);
        this.b.setStreamHandler(null);
        this.c.onCancel(null);
        this.f791a = null;
        this.b = null;
        this.c = null;
    }
}
