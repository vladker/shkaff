package M;

import S4.h;
import com.appdev.standard.api.AuthorityApi;
import com.appdev.standard.api.dto.LoginDto;
import com.google.common.net.HttpHeaders;
import com.library.base.util.http.Http;
import com.orhanobut.hawk.Hawk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends a {
    public AuthorityApi d;

    public static void a(g gVar, LoginDto loginDto) {
        gVar.getClass();
        try {
            LoginDto.DataBean data = loginDto.getData();
            Http.addHeader(HttpHeaders.AUTHORIZATION, data.getToken());
            h hVar = p042h2.e.f4031a;
            String appUserId = data.getAppUserId();
            String userName = data.getUserName();
            String avatar = data.getAvatar();
            String nickName = data.getNickName();
            p032f2.a aVar = new p032f2.a();
            hVar.b = aVar;
            aVar.c = appUserId;
            aVar.d = userName;
            aVar.b = avatar;
            aVar.f3961a = nickName;
            Hawk.put("user_util_user_data", aVar);
            Object obj = gVar.b;
            if (obj != null) {
                ((b) obj).loginSuccess();
            }
        } catch (Exception unused) {
            gVar.b(gVar.getString(p113u.g.login_failure));
        }
    }

    public final void b(String str) {
        p042h2.e.f4031a.i();
        Object obj = this.b;
        if (obj != null) {
            ((b) obj).loginFailed(2, str);
        }
    }
}
