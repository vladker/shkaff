package p080o0;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.internal.operators.observable.C0953x2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements FlutterPlugin, ActivityAware {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f6434a;
    public MethodChannel b;

    @Nullable
    private a methodCallHandler;

    @Nullable
    private ActivityPluginBinding pluginBinding;

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        Activity activity = activityPluginBinding.getActivity();
        d dVar = this.f6434a;
        if (dVar != null) {
            dVar.setActivity(activity);
        }
        this.pluginBinding = activityPluginBinding;
        activityPluginBinding.addActivityResultListener(this.f6434a);
        this.pluginBinding.addRequestPermissionsResultListener(this.f6434a);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f6434a = new d(flutterPluginBinding.getApplicationContext());
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter.baseflow.com/permissions/methods");
        this.b = methodChannel;
        a aVar = new a(applicationContext, new C0953x2(5), this.f6434a, new C0953x2(6));
        this.methodCallHandler = aVar;
        methodChannel.setMethodCallHandler(aVar);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivity() {
        d dVar = this.f6434a;
        if (dVar != null) {
            dVar.setActivity(null);
        }
        ActivityPluginBinding activityPluginBinding = this.pluginBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this.f6434a);
            this.pluginBinding.removeRequestPermissionsResultListener(this.f6434a);
        }
        this.pluginBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public final void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.b.setMethodCallHandler(null);
        this.b = null;
        this.methodCallHandler = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
