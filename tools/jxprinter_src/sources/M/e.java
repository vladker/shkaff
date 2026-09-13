package M;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDKCallback;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements ShareSDKCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f463a;
    public final /* synthetic */ Platform b;
    public final /* synthetic */ g c;

    public /* synthetic */ e(g gVar, Platform platform, int i5) {
        this.f463a = i5;
        this.c = gVar;
        this.b = platform;
    }

    @Override // cn.sharesdk.framework.ShareSDKCallback
    public final void onCallback(Object obj) {
        switch (this.f463a) {
            case 0:
                if (!((Boolean) obj).booleanValue()) {
                    g gVar = this.c;
                    Object obj2 = gVar.b;
                    if (obj2 != null) {
                        ((b) obj2).loginFailed(2, gVar.getString(p113u.g.no_wechat_app));
                    }
                } else {
                    d dVar = new d(0, this);
                    Platform platform = this.b;
                    platform.setPlatformActionListener(dVar);
                    platform.showUser(null);
                }
                break;
            default:
                if (!((Boolean) obj).booleanValue()) {
                    g gVar2 = this.c;
                    Object obj3 = gVar2.b;
                    if (obj3 != null) {
                        ((b) obj3).loginFailed(2, gVar2.getString(p113u.g.text_406));
                    }
                } else {
                    d dVar2 = new d(1, this);
                    Platform platform2 = this.b;
                    platform2.setPlatformActionListener(dVar2);
                    platform2.showUser(null);
                }
                break;
        }
    }
}
