package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements BasicMessageChannel.MessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4150a;
    public final /* synthetic */ Object b;

    public /* synthetic */ i(Object obj, int i5) {
        this.f4150a = i5;
        this.b = obj;
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        switch (this.f4150a) {
            case 0:
                PigeonApiAndroidMessage.Companion.setUpMessageHandlers$lambda$1$lambda$0((PigeonApiAndroidMessage) this.b, obj, reply);
                break;
            case 1:
                PigeonApiCertificate.Companion.setUpMessageHandlers$lambda$1$lambda$0((PigeonApiCertificate) this.b, obj, reply);
                break;
            case 2:
                PigeonApiCustomViewCallback.Companion.setUpMessageHandlers$lambda$1$lambda$0((PigeonApiCustomViewCallback) this.b, obj, reply);
                break;
            case 3:
                PigeonApiDownloadListener.Companion.setUpMessageHandlers$lambda$1$lambda$0((PigeonApiDownloadListener) this.b, obj, reply);
                break;
            case 4:
                PigeonApiGeolocationPermissionsCallback.Companion.setUpMessageHandlers$lambda$1$lambda$0((PigeonApiGeolocationPermissionsCallback) this.b, obj, reply);
                break;
            case 5:
                PigeonApiJavaScriptChannel.Companion.setUpMessageHandlers$lambda$1$lambda$0((PigeonApiJavaScriptChannel) this.b, obj, reply);
                break;
            case 6:
                PigeonApiWebSettingsCompat.Companion.setUpMessageHandlers$lambda$1$lambda$0((PigeonApiWebSettingsCompat) this.b, obj, reply);
                break;
            default:
                PigeonApiWebViewFeature.Companion.setUpMessageHandlers$lambda$1$lambda$0((PigeonApiWebViewFeature) this.b, obj, reply);
                break;
        }
    }
}
