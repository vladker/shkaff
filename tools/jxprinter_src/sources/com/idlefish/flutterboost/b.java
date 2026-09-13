package com.idlefish.flutterboost;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Messages.FlutterRouterApi.Reply {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3553a;
    public final /* synthetic */ FlutterBoostPlugin b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(FlutterBoostPlugin flutterBoostPlugin, String str, int i5) {
        this.f3553a = i5;
        this.b = flutterBoostPlugin;
        this.c = str;
    }

    @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
    public final void reply(Object obj) {
        switch (this.f3553a) {
            case 0:
                this.b.lambda$onContainerShow$8(this.c, (Void) obj);
                break;
            case 1:
                this.b.lambda$onAttachedToActivity$12(this.c, (Void) obj);
                break;
            default:
                this.b.lambda$onContainerHide$9(this.c, (Void) obj);
                break;
        }
    }
}
