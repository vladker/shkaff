package io.flutter.plugins.webviewflutter;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebViewClientCompat;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class WebViewClientProxyApi extends PigeonApiWebViewClient {
    public WebViewClientProxyApi(@NonNull ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    @NonNull
    public WebViewClient pigeon_defaultConstructor() {
        return getPigeonRegistrar().sdkIsAtLeast(24) ? new WebViewClientImpl(this) : new WebViewClientCompatImpl(this);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    public void setSynchronousReturnValueForShouldOverrideUrlLoading(@NonNull WebViewClient webViewClient, boolean z6) {
        if (webViewClient instanceof WebViewClientCompatImpl) {
            ((WebViewClientCompatImpl) webViewClient).setReturnValueForShouldOverrideUrlLoading(z6);
        } else {
            if (!getPigeonRegistrar().sdkIsAtLeast(24) || !(webViewClient instanceof WebViewClientImpl)) {
                throw new IllegalStateException("This WebViewClient doesn't support setting the returnValueForShouldOverrideUrlLoading.");
            }
            ((WebViewClientImpl) webViewClient).setReturnValueForShouldOverrideUrlLoading(z6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class WebViewClientCompatImpl extends WebViewClientCompat {
        private final WebViewClientProxyApi api;
        private boolean returnValueForShouldOverrideUrlLoading = false;

        public WebViewClientCompatImpl(@NonNull WebViewClientProxyApi webViewClientProxyApi) {
            this.api = webViewClientProxyApi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$doUpdateVisitedHistory$14(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$doUpdateVisitedHistory$15(WebView webView, String str, boolean z6) {
            this.api.doUpdateVisitedHistory(this, webView, str, z6, new C0670f(20));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onFormResubmission$18(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFormResubmission$19(WebView webView, Message message, Message message2) {
            this.api.onFormResubmission(this, webView, message, message2, new C0670f(24));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onLoadResource$20(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoadResource$21(WebView webView, String str) {
            this.api.onLoadResource(this, webView, str, new C0670f(21));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onPageCommitVisible$22(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageCommitVisible$23(WebView webView, String str) {
            this.api.onPageCommitVisible(this, webView, str, new C0670f(22));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onPageFinished$2(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageFinished$3(WebView webView, String str) {
            this.api.onPageFinished(this, webView, str, new C0670f(14));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onPageStarted$0(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageStarted$1(WebView webView, String str) {
            this.api.onPageStarted(this, webView, str, new C0670f(18));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedClientCertRequest$24(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedClientCertRequest$25(WebView webView, ClientCertRequest clientCertRequest) {
            this.api.onReceivedClientCertRequest(this, webView, clientCertRequest, new C0670f(17));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedError$6(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedError$7(WebView webView, WebResourceRequest webResourceRequest, WebResourceErrorCompat webResourceErrorCompat) {
            this.api.onReceivedRequestErrorCompat(this, webView, webResourceRequest, webResourceErrorCompat, new C0670f(26));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedError$8(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedError$9(WebView webView, int i5, String str, String str2) {
            this.api.onReceivedError(this, webView, i5, str, str2, new C0670f(11));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedHttpAuthRequest$16(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedHttpAuthRequest$17(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            this.api.onReceivedHttpAuthRequest(this, webView, httpAuthHandler, str, str2, new C0670f(25));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedHttpError$4(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedHttpError$5(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            this.api.onReceivedHttpError(this, webView, webResourceRequest, webResourceResponse, new C0670f(16));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedLoginRequest$26(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedLoginRequest$27(WebView webView, String str, String str2, String str3) {
            this.api.onReceivedLoginRequest(this, webView, str, str2, str3, new C0670f(19));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedSslError$28(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedSslError$29(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.api.onReceivedSslError(this, webView, sslErrorHandler, sslError, new C0670f(15));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onScaleChanged$30(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onScaleChanged$31(WebView webView, float f6, float f7) {
            this.api.onScaleChanged(this, webView, f6, f7, new C0670f(12));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$shouldOverrideUrlLoading$10(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$shouldOverrideUrlLoading$11(WebView webView, WebResourceRequest webResourceRequest) {
            this.api.requestLoading(this, webView, webResourceRequest, new C0670f(13));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$shouldOverrideUrlLoading$12(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$shouldOverrideUrlLoading$13(WebView webView, String str) {
            this.api.urlLoading(this, webView, str, new C0670f(23));
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(@NonNull WebView webView, @NonNull String str, boolean z6) {
            this.api.getPigeonRegistrar().runOnMainThread(new com.appdev.standard.page.printerlabel.util.c(2, this, webView, str, z6));
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(@NonNull WebView webView, @NonNull Message message, @NonNull Message message2) {
            this.api.getPigeonRegistrar().runOnMainThread(new M1.a(this, webView, message, message2, 5));
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(@NonNull WebView webView, @NonNull String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new E(this, webView, str, 3));
        }

        @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
        public void onPageCommitVisible(@NonNull WebView webView, @NonNull String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new E(this, webView, str, 2));
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NonNull WebView webView, @NonNull String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new E(this, webView, str, 4));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@NonNull WebView webView, @NonNull String str, @NonNull Bitmap bitmap) {
            this.api.getPigeonRegistrar().runOnMainThread(new E(this, webView, str, 0));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(@NonNull WebView webView, @NonNull ClientCertRequest clientCertRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new androidx.webkit.a(this, 6, webView, clientCertRequest));
        }

        @Override // androidx.webkit.WebViewClientCompat
        public void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceErrorCompat webResourceErrorCompat) {
            this.api.getPigeonRegistrar().runOnMainThread(new M1.a(this, webView, webResourceRequest, webResourceErrorCompat, 7));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(@NonNull WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new com.appdev.standard.page.scene.d(this, webView, httpAuthHandler, str, str2, 1));
        }

        @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
        public void onReceivedHttpError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceResponse webResourceResponse) {
            this.api.getPigeonRegistrar().runOnMainThread(new M1.a(this, webView, webResourceRequest, webResourceResponse, 8));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(@NonNull WebView webView, @NonNull String str, @Nullable String str2, @NonNull String str3) {
            this.api.getPigeonRegistrar().runOnMainThread(new com.appdev.standard.page.scene.d(this, webView, str, str2, str3, 2));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(@NonNull WebView webView, @NonNull SslErrorHandler sslErrorHandler, @NonNull SslError sslError) {
            this.api.getPigeonRegistrar().runOnMainThread(new M1.a(this, webView, sslErrorHandler, sslError, 6));
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(@NonNull WebView webView, float f6, float f7) {
            this.api.getPigeonRegistrar().runOnMainThread(new D(this, webView, f6, f7, 0));
        }

        public void setReturnValueForShouldOverrideUrlLoading(boolean z6) {
            this.returnValueForShouldOverrideUrlLoading = z6;
        }

        @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new androidx.webkit.a(this, 7, webView, webResourceRequest));
            return webResourceRequest.isForMainFrame() && this.returnValueForShouldOverrideUrlLoading;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@NonNull WebView webView, int i5, @NonNull String str, @NonNull String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new com.appdev.standard.page.scene.g(this, webView, i5, str, str2, 2));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new E(this, webView, str, 1));
            return this.returnValueForShouldOverrideUrlLoading;
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(@NonNull WebView webView, @NonNull KeyEvent keyEvent) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @RequiresApi(24)
    public static class WebViewClientImpl extends WebViewClient {
        private final WebViewClientProxyApi api;
        private boolean returnValueForShouldOverrideUrlLoading = false;

        public WebViewClientImpl(@NonNull WebViewClientProxyApi webViewClientProxyApi) {
            this.api = webViewClientProxyApi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$doUpdateVisitedHistory$14(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$doUpdateVisitedHistory$15(WebView webView, String str, boolean z6) {
            this.api.doUpdateVisitedHistory(this, webView, str, z6, new G(1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onFormResubmission$18(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFormResubmission$19(WebView webView, Message message, Message message2) {
            this.api.onFormResubmission(this, webView, message, message2, new G(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onLoadResource$20(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoadResource$21(WebView webView, String str) {
            this.api.onLoadResource(this, webView, str, new C0670f(29));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onPageCommitVisible$22(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageCommitVisible$23(WebView webView, String str) {
            this.api.onPageCommitVisible(this, webView, str, new C0670f(27));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onPageFinished$2(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageFinished$3(WebView webView, String str) {
            this.api.onPageFinished(this, webView, str, new G(12));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onPageStarted$0(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageStarted$1(WebView webView, String str) {
            this.api.onPageStarted(this, webView, str, new G(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedClientCertRequest$24(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedClientCertRequest$25(WebView webView, ClientCertRequest clientCertRequest) {
            this.api.onReceivedClientCertRequest(this, webView, clientCertRequest, new G(9));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedError$6(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedError$7(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            this.api.onReceivedRequestError(this, webView, webResourceRequest, webResourceError, new G(3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedError$8(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedError$9(WebView webView, int i5, String str, String str2) {
            this.api.onReceivedError(this, webView, i5, str, str2, new C0670f(28));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedHttpAuthRequest$16(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedHttpAuthRequest$17(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            this.api.onReceivedHttpAuthRequest(this, webView, httpAuthHandler, str, str2, new G(8));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedHttpError$4(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedHttpError$5(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            this.api.onReceivedHttpError(this, webView, webResourceRequest, webResourceResponse, new G(10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedLoginRequest$26(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedLoginRequest$27(WebView webView, String str, String str2, String str3) {
            this.api.onReceivedLoginRequest(this, webView, str, str2, str3, new G(6));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onReceivedSslError$28(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceivedSslError$29(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.api.onReceivedSslError(this, webView, sslErrorHandler, sslError, new G(4));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$onScaleChanged$30(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onScaleChanged$31(WebView webView, float f6, float f7) {
            this.api.onScaleChanged(this, webView, f6, f7, new G(11));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$shouldOverrideUrlLoading$10(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$shouldOverrideUrlLoading$11(WebView webView, WebResourceRequest webResourceRequest) {
            this.api.requestLoading(this, webView, webResourceRequest, new G(7));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Q lambda$shouldOverrideUrlLoading$12(p147z3.u uVar) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$shouldOverrideUrlLoading$13(WebView webView, String str) {
            this.api.urlLoading(this, webView, str, new G(5));
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(@NonNull WebView webView, @NonNull String str, boolean z6) {
            this.api.getPigeonRegistrar().runOnMainThread(new com.appdev.standard.page.printerlabel.util.c(3, this, webView, str, z6));
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(@NonNull WebView webView, @NonNull Message message, @NonNull Message message2) {
            this.api.getPigeonRegistrar().runOnMainThread(new M1.a(this, webView, message, message2, 9));
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(@NonNull WebView webView, @NonNull String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new F(this, webView, str, 4));
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(@NonNull WebView webView, @NonNull String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new F(this, webView, str, 1));
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NonNull WebView webView, @NonNull String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new F(this, webView, str, 0));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@NonNull WebView webView, @NonNull String str, @NonNull Bitmap bitmap) {
            this.api.getPigeonRegistrar().runOnMainThread(new F(this, webView, str, 2));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(@NonNull WebView webView, @NonNull ClientCertRequest clientCertRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new androidx.webkit.a(this, 9, webView, clientCertRequest));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceError webResourceError) {
            this.api.getPigeonRegistrar().runOnMainThread(new M1.a(this, webView, webResourceRequest, webResourceError, 11));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(@NonNull WebView webView, @NonNull HttpAuthHandler httpAuthHandler, @NonNull String str, @NonNull String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new com.appdev.standard.page.scene.d(this, webView, httpAuthHandler, str, str2, 4));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceResponse webResourceResponse) {
            this.api.getPigeonRegistrar().runOnMainThread(new M1.a(this, webView, webResourceRequest, webResourceResponse, 12));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(@NonNull WebView webView, @NonNull String str, @Nullable String str2, @NonNull String str3) {
            this.api.getPigeonRegistrar().runOnMainThread(new com.appdev.standard.page.scene.d(this, webView, str, str2, str3, 3));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(@NonNull WebView webView, @NonNull SslErrorHandler sslErrorHandler, @NonNull SslError sslError) {
            this.api.getPigeonRegistrar().runOnMainThread(new M1.a(this, webView, sslErrorHandler, sslError, 10));
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(@NonNull WebView webView, float f6, float f7) {
            this.api.getPigeonRegistrar().runOnMainThread(new D(this, webView, f6, f7, 1));
        }

        public void setReturnValueForShouldOverrideUrlLoading(boolean z6) {
            this.returnValueForShouldOverrideUrlLoading = z6;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
            this.api.getPigeonRegistrar().runOnMainThread(new androidx.webkit.a(this, 8, webView, webResourceRequest));
            return webResourceRequest.isForMainFrame() && this.returnValueForShouldOverrideUrlLoading;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@NonNull WebView webView, int i5, @NonNull String str, @NonNull String str2) {
            this.api.getPigeonRegistrar().runOnMainThread(new com.appdev.standard.page.scene.g(this, webView, i5, str, str2, 3));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull String str) {
            this.api.getPigeonRegistrar().runOnMainThread(new F(this, webView, str, 3));
            return this.returnValueForShouldOverrideUrlLoading;
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(@NonNull WebView webView, @NonNull KeyEvent keyEvent) {
        }
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebViewClient
    @NonNull
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
