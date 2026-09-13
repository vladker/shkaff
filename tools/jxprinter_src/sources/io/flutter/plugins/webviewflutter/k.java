package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4152a;
    public final /* synthetic */ Object b;

    public /* synthetic */ k(Object obj, int i5) {
        this.f4152a = i5;
        this.b = obj;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        switch (this.f4152a) {
            case 0:
                return PigeonApiCookieManager.Companion.setUpMessageHandlers$lambda$6$lambda$5$lambda$4((BasicMessageChannel.Reply) this.b, (p147z3.u) obj);
            case 1:
                return PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27$lambda$26((BasicMessageChannel.Reply) this.b, (p147z3.u) obj);
            default:
                return ResultCompat.Companion.asCompatCallback$lambda$0((O3.l) this.b, (p147z3.u) obj);
        }
    }
}
