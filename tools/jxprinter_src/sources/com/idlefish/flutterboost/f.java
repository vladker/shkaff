package com.idlefish.flutterboost;

import io.flutter.plugin.common.BasicMessageChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements BasicMessageChannel.Reply {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3558a;
    public final /* synthetic */ Messages.FlutterRouterApi.Reply b;

    public /* synthetic */ f(Messages.FlutterRouterApi.Reply reply, int i5) {
        this.f3558a = i5;
        this.b = reply;
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
    public final void reply(Object obj) {
        switch (this.f3558a) {
            case 0:
                this.b.reply(null);
                break;
            case 1:
                this.b.reply(null);
                break;
            case 2:
                this.b.reply(null);
                break;
            case 3:
                this.b.reply(null);
                break;
            case 4:
                this.b.reply(null);
                break;
            case 5:
                this.b.reply(null);
                break;
            case 6:
                this.b.reply(null);
                break;
            case 7:
                this.b.reply(null);
                break;
            case 8:
                this.b.reply(null);
                break;
            default:
                this.b.reply(null);
                break;
        }
    }
}
