package M;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import com.appdev.standard.api.pto.GoogleLoginPto;
import com.appdev.standard.api.pto.WxLoginPto;
import com.appdev.standard.model.GoogleLoginModel;
import com.google.android.gms.common.Scopes;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements PlatformActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f462a;
    public final /* synthetic */ ShareSDKCallback b;

    public /* synthetic */ d(int i5, ShareSDKCallback shareSDKCallback) {
        this.f462a = i5;
        this.b = shareSDKCallback;
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onCancel(Platform platform, int i5) {
        switch (this.f462a) {
            case 0:
                e eVar = (e) this.b;
                p051j0.a.k(eVar.c.f3986a, "onCancel--->");
                g gVar = eVar.c;
                Object obj = gVar.b;
                if (obj != null) {
                    ((b) obj).loginFailed(2, gVar.getString(p113u.g.cancel_wechat_login));
                }
                break;
            default:
                e eVar2 = (e) this.b;
                p051j0.a.k(eVar2.c.f3986a, "onCancel--->");
                g gVar2 = eVar2.c;
                Object obj2 = gVar2.b;
                if (obj2 != null) {
                    ((b) obj2).loginFailed(2, gVar2.getString(p113u.g.text_405));
                }
                break;
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onComplete(Platform platform, int i5, HashMap map) {
        switch (this.f462a) {
            case 0:
                g gVar = ((e) this.b).c;
                p051j0.a.k(gVar.f3986a, "onComplete--->" + p052j2.c.e(map));
                gVar.d.fastLoginWeChat(new WxLoginPto((String) map.get("headimgurl"), (String) map.get("unionid"), (String) map.get("nickname"), (String) map.get(Scopes.OPEN_ID))).b(new A.c(this, 12));
                break;
            default:
                g gVar2 = ((e) this.b).c;
                p051j0.a.k(gVar2.f3986a, "onComplete--->" + platform.getDb().exportData());
                GoogleLoginModel googleLoginModel = (GoogleLoginModel) p052j2.c.c(GoogleLoginModel.class, platform.getDb().exportData());
                gVar2.d.loginByGoogle(new GoogleLoginPto(googleLoginModel.getPicture(), googleLoginModel.getNickname(), googleLoginModel.getUserID())).b(new A.c(this, 13));
                break;
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onError(Platform platform, int i5, Throwable th) {
        switch (this.f462a) {
            case 0:
                e eVar = (e) this.b;
                p051j0.a.k(eVar.c.f3986a, "onError--->");
                th.printStackTrace();
                g gVar = eVar.c;
                Object obj = gVar.b;
                if (obj != null) {
                    ((b) obj).loginFailed(2, gVar.getString(p113u.g.error_wechat_login));
                }
                break;
            default:
                e eVar2 = (e) this.b;
                p051j0.a.k(eVar2.c.f3986a, "onError--->");
                th.printStackTrace();
                g gVar2 = eVar2.c;
                Object obj2 = gVar2.b;
                if (obj2 != null) {
                    ((b) obj2).loginFailed(2, gVar2.getString(p113u.g.text_404));
                }
                break;
        }
    }
}
