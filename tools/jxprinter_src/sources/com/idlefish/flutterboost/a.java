package com.idlefish.flutterboost;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Messages.FlutterRouterApi.Reply {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3552a;
    public final /* synthetic */ FlutterBoostPlugin b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Messages.FlutterRouterApi.Reply d;

    public /* synthetic */ a(FlutterBoostPlugin flutterBoostPlugin, String str, Messages.FlutterRouterApi.Reply reply, int i5) {
        this.f3552a = i5;
        this.b = flutterBoostPlugin;
        this.c = str;
        this.d = reply;
    }

    @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
    public final void reply(Object obj) {
        switch (this.f3552a) {
            case 0:
                this.b.lambda$popRoute$3(this.c, this.d, (Void) obj);
                break;
            default:
                this.b.lambda$removeRoute$5(this.c, this.d, (Void) obj);
                break;
        }
    }
}
