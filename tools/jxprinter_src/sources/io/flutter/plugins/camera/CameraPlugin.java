package io.flutter.plugins.camera;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.view.TextureRegistry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class CameraPlugin implements FlutterPlugin, ActivityAware {
    private static final String TAG = "CameraPlugin";

    @Nullable
    private CameraApiImpl cameraApi;

    @Nullable
    private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;

    private void maybeStartListening(Activity activity, BinaryMessenger binaryMessenger, CameraPermissions.PermissionsRegistry permissionsRegistry, TextureRegistry textureRegistry) {
        this.cameraApi = new CameraApiImpl(activity, binaryMessenger, new CameraPermissions(), permissionsRegistry, textureRegistry);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        maybeStartListening(activityPluginBinding.getActivity(), this.flutterPluginBinding.getBinaryMessenger(), new c(activityPluginBinding, 2), this.flutterPluginBinding.getTextureRegistry());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.flutterPluginBinding = flutterPluginBinding;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        CameraApiImpl cameraApiImpl = this.cameraApi;
        if (cameraApiImpl != null) {
            cameraApiImpl.tearDownMessageHandler();
            this.cameraApi = null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.flutterPluginBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
