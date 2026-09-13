package io.flutter.plugins.webviewflutter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class WebViewFlutterPlugin implements FlutterPlugin, ActivityAware {
    private FlutterPlugin.FlutterPluginBinding pluginBinding;
    private ProxyApiRegistrar proxyApiRegistrar;

    @Nullable
    public AndroidWebkitLibraryPigeonInstanceManager getInstanceManager() {
        return this.proxyApiRegistrar.getInstanceManager();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        ProxyApiRegistrar proxyApiRegistrar = this.proxyApiRegistrar;
        if (proxyApiRegistrar != null) {
            proxyApiRegistrar.setContext(activityPluginBinding.getActivity());
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = flutterPluginBinding;
        this.proxyApiRegistrar = new ProxyApiRegistrar(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext(), new FlutterAssetManager.PluginBindingFlutterAssetManager(flutterPluginBinding.getApplicationContext().getAssets(), flutterPluginBinding.getFlutterAssets()));
        flutterPluginBinding.getPlatformViewRegistry().registerViewFactory("plugins.flutter.io/webview", new FlutterViewFactory(this.proxyApiRegistrar.getInstanceManager()));
        this.proxyApiRegistrar.setUp();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.proxyApiRegistrar.setContext(this.pluginBinding.getApplicationContext());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.proxyApiRegistrar.setContext(this.pluginBinding.getApplicationContext());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        ProxyApiRegistrar proxyApiRegistrar = this.proxyApiRegistrar;
        if (proxyApiRegistrar != null) {
            proxyApiRegistrar.tearDown();
            this.proxyApiRegistrar.getInstanceManager().stopFinalizationListener();
            this.proxyApiRegistrar = null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        this.proxyApiRegistrar.setContext(activityPluginBinding.getActivity());
    }
}
