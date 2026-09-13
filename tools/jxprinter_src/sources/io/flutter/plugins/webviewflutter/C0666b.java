package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;

/* JADX INFO: renamed from: io.flutter.plugins.webviewflutter.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0666b implements BasicMessageChannel.Reply {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4143a;
    public final /* synthetic */ O3.l b;

    public /* synthetic */ C0666b(int i5, O3.l lVar) {
        this.f4143a = i5;
        this.b = lVar;
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
    public final void reply(Object obj) {
        switch (this.f4143a) {
            case 0:
                AndroidWebkitLibraryPigeonInstanceManagerApi.removeStrongReference$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference", obj);
                break;
            case 1:
                PigeonApiAndroidMessage.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.pigeon_newInstance", obj);
                break;
            case 2:
                PigeonApiCertificate.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.Certificate.pigeon_newInstance", obj);
                break;
            case 3:
                PigeonApiClientCertRequest.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.pigeon_newInstance", obj);
                break;
            case 4:
                PigeonApiConsoleMessage.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.ConsoleMessage.pigeon_newInstance", obj);
                break;
            case 5:
                PigeonApiCookieManager.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.CookieManager.pigeon_newInstance", obj);
                break;
            case 6:
                PigeonApiCustomViewCallback.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.CustomViewCallback.pigeon_newInstance", obj);
                break;
            case 7:
                PigeonApiDownloadListener.onDownloadStart$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.DownloadListener.onDownloadStart", obj);
                break;
            case 8:
                PigeonApiFileChooserParams.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.FileChooserParams.pigeon_newInstance", obj);
                break;
            case 9:
                PigeonApiFlutterAssetManager.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManager.pigeon_newInstance", obj);
                break;
            case 10:
                PigeonApiGeolocationPermissionsCallback.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallback.pigeon_newInstance", obj);
                break;
            case 11:
                PigeonApiHttpAuthHandler.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.pigeon_newInstance", obj);
                break;
            case 12:
                PigeonApiJavaScriptChannel.postMessage$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannel.postMessage", obj);
                break;
            case 13:
                PigeonApiPermissionRequest.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.pigeon_newInstance", obj);
                break;
            case 14:
                PigeonApiPrivateKey.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.PrivateKey.pigeon_newInstance", obj);
                break;
            case 15:
                PigeonApiSslCertificate.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.pigeon_newInstance", obj);
                break;
            case 16:
                PigeonApiSslCertificateDName.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.pigeon_newInstance", obj);
                break;
            case 17:
                PigeonApiSslError.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.SslError.pigeon_newInstance", obj);
                break;
            case 18:
                PigeonApiSslErrorHandler.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.pigeon_newInstance", obj);
                break;
            case 19:
                PigeonApiView.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.View.pigeon_newInstance", obj);
                break;
            case 20:
                PigeonApiWebChromeClient.onHideCustomView$lambda$4(this.b, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onHideCustomView", obj);
                break;
            case 21:
                PigeonApiWebChromeClient.onProgressChanged$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onProgressChanged", obj);
                break;
            case 22:
                PigeonApiWebChromeClient.onJsPrompt$lambda$10(this.b, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsPrompt", obj);
                break;
            case 23:
                PigeonApiWebChromeClient.onJsAlert$lambda$8(this.b, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsAlert", obj);
                break;
            case 24:
                PigeonApiWebChromeClient.onShowFileChooser$lambda$1(this.b, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowFileChooser", obj);
                break;
            case 25:
                PigeonApiWebChromeClient.onPermissionRequest$lambda$2(this.b, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onPermissionRequest", obj);
                break;
            case 26:
                PigeonApiWebChromeClient.onShowCustomView$lambda$3(this.b, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowCustomView", obj);
                break;
            case 27:
                PigeonApiWebChromeClient.onConsoleMessage$lambda$7(this.b, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onConsoleMessage", obj);
                break;
            default:
                PigeonApiWebChromeClient.onGeolocationPermissionsShowPrompt$lambda$5(this.b, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsShowPrompt", obj);
                break;
        }
    }
}
