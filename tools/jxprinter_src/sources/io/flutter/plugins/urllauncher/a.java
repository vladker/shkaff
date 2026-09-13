package io.flutter.plugins.urllauncher;

import android.content.Context;
import android.content.Intent;
import io.flutter.plugin.common.BasicMessageChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler, UrlLauncher.IntentResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4131a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f4131a = i5;
        this.b = obj;
    }

    @Override // io.flutter.plugins.urllauncher.UrlLauncher.IntentResolver
    public String getHandlerComponentName(Intent intent) {
        return UrlLauncher.lambda$new$0((Context) this.b, intent);
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
    public void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        switch (this.f4131a) {
            case 0:
                Messages.UrlLauncherApi.lambda$setUp$0((Messages.UrlLauncherApi) this.b, obj, reply);
                break;
            case 1:
                Messages.UrlLauncherApi.lambda$setUp$1((Messages.UrlLauncherApi) this.b, obj, reply);
                break;
            case 2:
                Messages.UrlLauncherApi.lambda$setUp$2((Messages.UrlLauncherApi) this.b, obj, reply);
                break;
            case 3:
                Messages.UrlLauncherApi.lambda$setUp$3((Messages.UrlLauncherApi) this.b, obj, reply);
                break;
            default:
                Messages.UrlLauncherApi.lambda$setUp$4((Messages.UrlLauncherApi) this.b, obj, reply);
                break;
        }
    }
}
