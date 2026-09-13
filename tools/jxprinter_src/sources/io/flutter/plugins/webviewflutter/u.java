package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u implements BasicMessageChannel.Reply {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4162a;
    public final /* synthetic */ O3.l b;

    public /* synthetic */ u(int i5, O3.l lVar) {
        this.f4162a = i5;
        this.b = lVar;
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
    public final void reply(Object obj) {
        switch (this.f4162a) {
            case 0:
                PigeonApiWebChromeClient.onGeolocationPermissionsHidePrompt$lambda$6(this.b, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsHidePrompt", obj);
                break;
            case 1:
                PigeonApiWebResourceError.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebResourceError.pigeon_newInstance", obj);
                break;
            case 2:
                PigeonApiWebResourceErrorCompat.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebResourceErrorCompat.pigeon_newInstance", obj);
                break;
            case 3:
                PigeonApiWebResourceRequest.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance", obj);
                break;
            case 4:
                PigeonApiWebResourceResponse.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebResourceResponse.pigeon_newInstance", obj);
                break;
            case 5:
                PigeonApiWebSettings.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebSettings.pigeon_newInstance", obj);
                break;
            case 6:
                PigeonApiWebSettingsCompat.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebSettingsCompat.pigeon_newInstance", obj);
                break;
            case 7:
                PigeonApiWebStorage.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebStorage.pigeon_newInstance", obj);
                break;
            case 8:
                PigeonApiWebView.onScrollChanged$lambda$1(this.b, "dev.flutter.pigeon.webview_flutter_android.WebView.onScrollChanged", obj);
                break;
            case 9:
                PigeonApiWebView.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebView.pigeon_newInstance", obj);
                break;
            case 10:
                PigeonApiWebViewClient.onReceivedRequestErrorCompat$lambda$5(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedRequestErrorCompat", obj);
                break;
            case 11:
                PigeonApiWebViewClient.onScaleChanged$lambda$17(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onScaleChanged", obj);
                break;
            case 12:
                PigeonApiWebViewClient.urlLoading$lambda$8(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.urlLoading", obj);
                break;
            case 13:
                PigeonApiWebViewClient.doUpdateVisitedHistory$lambda$9(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.doUpdateVisitedHistory", obj);
                break;
            case 14:
                PigeonApiWebViewClient.onReceivedHttpError$lambda$3(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedHttpError", obj);
                break;
            case 15:
                PigeonApiWebViewClient.onLoadResource$lambda$12(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onLoadResource", obj);
                break;
            case 16:
                PigeonApiWebViewClient.onReceivedLoginRequest$lambda$15(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedLoginRequest", obj);
                break;
            case 17:
                PigeonApiWebViewClient.onPageStarted$lambda$1(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageStarted", obj);
                break;
            case 18:
                PigeonApiWebViewClient.onReceivedClientCertRequest$lambda$14(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedClientCertRequest", obj);
                break;
            case 19:
                PigeonApiWebViewClient.requestLoading$lambda$7(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.requestLoading", obj);
                break;
            case 20:
                PigeonApiWebViewClient.onPageCommitVisible$lambda$13(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageCommitVisible", obj);
                break;
            case 21:
                PigeonApiWebViewClient.onReceivedRequestError$lambda$4(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedRequestError", obj);
                break;
            case 22:
                PigeonApiWebViewClient.onPageFinished$lambda$2(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageFinished", obj);
                break;
            case 23:
                PigeonApiWebViewClient.onReceivedError$lambda$6(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedError", obj);
                break;
            case 24:
                PigeonApiWebViewClient.onReceivedHttpAuthRequest$lambda$10(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedHttpAuthRequest", obj);
                break;
            case 25:
                PigeonApiWebViewClient.onFormResubmission$lambda$11(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onFormResubmission", obj);
                break;
            case 26:
                PigeonApiWebViewClient.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.pigeon_newInstance", obj);
                break;
            case 27:
                PigeonApiWebViewClient.onReceivedSslError$lambda$16(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedSslError", obj);
                break;
            case 28:
                PigeonApiWebViewFeature.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewFeature.pigeon_newInstance", obj);
                break;
            default:
                PigeonApiWebViewPoint.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.WebViewPoint.pigeon_newInstance", obj);
                break;
        }
    }
}
