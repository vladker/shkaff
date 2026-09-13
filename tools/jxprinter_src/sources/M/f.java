package M;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.appdev.standard.api.pto.FaceBookLoginPto;
import com.appdev.standard.api.pto.TwitterLoginPto;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements PlatformActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f464a;
    public final /* synthetic */ g b;

    public /* synthetic */ f(g gVar, int i5) {
        this.f464a = i5;
        this.b = gVar;
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onCancel(Platform platform, int i5) {
        switch (this.f464a) {
            case 0:
                g gVar = this.b;
                p051j0.a.k(gVar.f3986a, "onCancel--->");
                Object obj = gVar.b;
                if (obj != null) {
                    ((b) obj).loginFailed(2, gVar.getString(p113u.g.text_408));
                }
                break;
            default:
                g gVar2 = this.b;
                p051j0.a.k(gVar2.f3986a, "Facebook onCancel--->");
                Object obj2 = gVar2.b;
                if (obj2 != null) {
                    ((b) obj2).loginFailed(2, gVar2.getString(p113u.g.text_411));
                }
                break;
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onComplete(Platform platform, int i5, HashMap map) {
        String str;
        switch (this.f464a) {
            case 0:
                g gVar = this.b;
                p051j0.a.k(gVar.f3986a, "onComplete--->" + p052j2.c.e(map));
                Map map2 = (Map) map.get("data");
                gVar.d.twitterLogin(new TwitterLoginPto("", (String) map2.get("name"), (String) map2.get("id"))).b(new A.c(this, 14));
                break;
            default:
                g gVar2 = this.b;
                p051j0.a.k(gVar2.f3986a, "Facebook onComplete--->" + p052j2.c.e(map));
                try {
                    String str2 = "";
                    String str3 = (String) map.get("id");
                    String str4 = (String) map.get("name");
                    Object obj = map.get("picture");
                    if (obj instanceof HashMap) {
                        Object obj2 = ((HashMap) obj).get("data");
                        if ((obj2 instanceof HashMap) && (str = (String) ((HashMap) obj2).get("url")) != null) {
                            str2 = str;
                        }
                    }
                    gVar2.d.faceBookLogin(new FaceBookLoginPto(str2, str4, str3)).b(new A.c(this, 15));
                } catch (Exception e) {
                    p051j0.a.d(gVar2.f3986a, "Facebook login error: " + e.getMessage());
                    Object obj3 = gVar2.b;
                    if (obj3 != null) {
                        ((b) obj3).loginFailed(2, gVar2.getString(p113u.g.text_410));
                    }
                    return;
                }
                break;
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onError(Platform platform, int i5, Throwable th) {
        switch (this.f464a) {
            case 0:
                g gVar = this.b;
                p051j0.a.k(gVar.f3986a, "onError--->");
                th.printStackTrace();
                Object obj = gVar.b;
                if (obj != null) {
                    ((b) obj).loginFailed(2, gVar.getString(p113u.g.text_407));
                }
                break;
            default:
                g gVar2 = this.b;
                p051j0.a.k(gVar2.f3986a, "Facebook onError--->");
                th.printStackTrace();
                Object obj2 = gVar2.b;
                if (obj2 != null) {
                    ((b) obj2).loginFailed(2, gVar2.getString(p113u.g.text_410));
                }
                break;
        }
    }
}
