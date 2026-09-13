package io.flutter.plugins.webviewflutter;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugin.common.BinaryMessenger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ProxyApiRegistrar extends AndroidWebkitLibraryPigeonProxyApiRegistrar {

    @NonNull
    private Context context;

    @NonNull
    private final FlutterAssetManager flutterAssetManager;

    public ProxyApiRegistrar(@NonNull BinaryMessenger binaryMessenger, @NonNull Context context, @NonNull FlutterAssetManager flutterAssetManager) {
        super(binaryMessenger);
        this.context = context;
        this.flutterAssetManager = flutterAssetManager;
    }

    @NonNull
    public IllegalArgumentException createUnknownEnumException(@NonNull Object obj) {
        return new IllegalArgumentException(obj + " doesn't represent a native value.");
    }

    @NonNull
    public String createUnsupportedVersionMessage(@NonNull String str, @NonNull String str2) {
        return androidx.exifinterface.media.a.A(str, " requires ", str2, Consts.DOT);
    }

    @NonNull
    public Context getContext() {
        return this.context;
    }

    @NonNull
    public FlutterAssetManager getFlutterAssetManager() {
        return this.flutterAssetManager;
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiAndroidMessage getPigeonApiAndroidMessage() {
        return new MessageProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiCertificate getPigeonApiCertificate() {
        return new CertificateProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiClientCertRequest getPigeonApiClientCertRequest() {
        return new ClientCertRequestProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiConsoleMessage getPigeonApiConsoleMessage() {
        return new ConsoleMessageProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiCookieManager getPigeonApiCookieManager() {
        return new CookieManagerProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiCustomViewCallback getPigeonApiCustomViewCallback() {
        return new CustomViewCallbackProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiDownloadListener getPigeonApiDownloadListener() {
        return new DownloadListenerProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiFileChooserParams getPigeonApiFileChooserParams() {
        return new FileChooserParamsProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiFlutterAssetManager getPigeonApiFlutterAssetManager() {
        return new FlutterAssetManagerProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiGeolocationPermissionsCallback getPigeonApiGeolocationPermissionsCallback() {
        return new GeolocationPermissionsCallbackProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiHttpAuthHandler getPigeonApiHttpAuthHandler() {
        return new HttpAuthHandlerProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiJavaScriptChannel getPigeonApiJavaScriptChannel() {
        return new JavaScriptChannelProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiPermissionRequest getPigeonApiPermissionRequest() {
        return new PermissionRequestProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiSslCertificate getPigeonApiSslCertificate() {
        return new SslCertificateProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiSslCertificateDName getPigeonApiSslCertificateDName() {
        return new SslCertificateDNameProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiSslError getPigeonApiSslError() {
        return new SslErrorProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiSslErrorHandler getPigeonApiSslErrorHandler() {
        return new SslErrorHandlerProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiView getPigeonApiView() {
        return new ViewProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiWebChromeClient getPigeonApiWebChromeClient() {
        return new WebChromeClientProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    @RequiresApi(api = 23)
    public PigeonApiWebResourceError getPigeonApiWebResourceError() {
        return new WebResourceErrorProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiWebResourceErrorCompat getPigeonApiWebResourceErrorCompat() {
        return new WebResourceErrorCompatProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiWebResourceRequest getPigeonApiWebResourceRequest() {
        return new WebResourceRequestProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiWebResourceResponse getPigeonApiWebResourceResponse() {
        return new WebResourceResponseProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiWebSettings getPigeonApiWebSettings() {
        return new WebSettingsProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiWebSettingsCompat getPigeonApiWebSettingsCompat() {
        return new WebSettingsCompatProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiWebStorage getPigeonApiWebStorage() {
        return new WebStorageProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiWebView getPigeonApiWebView() {
        return new WebViewProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiWebViewClient getPigeonApiWebViewClient() {
        return new WebViewClientProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiWebViewFeature getPigeonApiWebViewFeature() {
        return new WebViewFeatureProxyApi(this);
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar
    @NonNull
    public PigeonApiWebViewPoint getPigeonApiWebViewPoint() {
        return new WebViewPointProxyApi(this);
    }

    public void logError(String str, Throwable th) {
        Log.e(str, th.getClass().getSimpleName() + ", Message: " + th.getMessage() + ", Stacktrace: " + Log.getStackTraceString(th));
    }

    public void runOnMainThread(Runnable runnable) {
        Context context = this.context;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    @ChecksSdkIntAtLeast(parameter = 0)
    public boolean sdkIsAtLeast(int i5) {
        return Build.VERSION.SDK_INT >= i5;
    }

    public void setContext(@NonNull Context context) {
        this.context = context;
    }
}
