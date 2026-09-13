package io.flutter.plugins.webviewflutter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class G implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4138a;

    public /* synthetic */ G(int i5) {
        this.f4138a = i5;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        p147z3.u uVar = (p147z3.u) obj;
        switch (this.f4138a) {
            case 0:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$onFormResubmission$18(uVar);
            case 1:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$doUpdateVisitedHistory$14(uVar);
            case 2:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$onPageStarted$0(uVar);
            case 3:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedError$6(uVar);
            case 4:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedSslError$28(uVar);
            case 5:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$shouldOverrideUrlLoading$12(uVar);
            case 6:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedLoginRequest$26(uVar);
            case 7:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$shouldOverrideUrlLoading$10(uVar);
            case 8:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedHttpAuthRequest$16(uVar);
            case 9:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedClientCertRequest$24(uVar);
            case 10:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$onReceivedHttpError$4(uVar);
            case 11:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$onScaleChanged$30(uVar);
            case 12:
                return WebViewClientProxyApi.WebViewClientImpl.lambda$onPageFinished$2(uVar);
            default:
                return WebViewProxyApi.WebViewPlatformView.lambda$onScrollChanged$0(uVar);
        }
    }
}
