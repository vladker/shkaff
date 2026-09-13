package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class A implements BasicMessageChannel.Reply {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4132a;
    public final /* synthetic */ O3.l b;

    public /* synthetic */ A(int i5, O3.l lVar) {
        this.f4132a = i5;
        this.b = lVar;
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
    public final void reply(Object obj) {
        switch (this.f4132a) {
            case 0:
                PigeonApiX509Certificate.pigeon_newInstance$lambda$0(this.b, "dev.flutter.pigeon.webview_flutter_android.X509Certificate.pigeon_newInstance", obj);
                break;
            default:
                PigeonApiWebChromeClient.onJsConfirm$lambda$9(this.b, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsConfirm", obj);
                break;
        }
    }
}
