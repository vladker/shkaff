package com.idlefish.flutterboost;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Messages.FlutterRouterApi.Reply {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3554a;
    public final /* synthetic */ FlutterBoostPlugin b;

    public /* synthetic */ c(FlutterBoostPlugin flutterBoostPlugin, int i5) {
        this.f3554a = i5;
        this.b = flutterBoostPlugin;
    }

    @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
    public final void reply(Object obj) {
        switch (this.f3554a) {
            case 0:
                this.b.lambda$onForeground$6((Void) obj);
                break;
            case 1:
                this.b.lambda$onBackground$7((Void) obj);
                break;
            default:
                this.b.lambda$onBackPressed$4((Void) obj);
                break;
        }
    }
}
