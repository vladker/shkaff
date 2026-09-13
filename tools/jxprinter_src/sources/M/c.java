package M;

import com.appdev.standard.api.dto.LoginDto;
import kotlin.jvm.internal.Y;
import retrofit2.InterfaceC1613k;
import retrofit2.InterfaceC1616n;
import retrofit2.r0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements InterfaceC1616n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f461a;
    public final /* synthetic */ g b;

    public c(g gVar, String str) {
        this.b = gVar;
        this.f461a = str;
    }

    @Override // retrofit2.InterfaceC1616n
    public final void onFailure(InterfaceC1613k interfaceC1613k, Throwable th) {
        int i5 = p113u.g.Wrong_account_or_password;
        g gVar = this.b;
        gVar.b(gVar.getString(i5));
    }

    @Override // retrofit2.InterfaceC1616n
    public final void onResponse(InterfaceC1613k interfaceC1613k, r0 r0Var) {
        boolean zA = r0Var.f8159a.a();
        String str = this.f461a;
        g gVar = this.b;
        if (zA && r0Var.body() != null) {
            LoginDto loginDto = (LoginDto) r0Var.body();
            if ("false".equals(loginDto.getExist())) {
                Object obj = gVar.b;
                if (obj != null) {
                    ((b) obj).userNotExist(str);
                    return;
                }
                return;
            }
            if (loginDto.getData() == null) {
                gVar.b(gVar.getString(p113u.g.Wrong_account_or_password));
                return;
            } else {
                g.a(gVar, loginDto);
                return;
            }
        }
        String string = gVar.getString(p113u.g.Wrong_account_or_password);
        try {
            if (r0Var.errorBody() != null) {
                LoginDto loginDto2 = (LoginDto) p052j2.c.c(LoginDto.class, r0Var.errorBody().string());
                if (loginDto2 != null && "false".equals(loginDto2.getExist())) {
                    Object obj2 = gVar.b;
                    if (obj2 != null) {
                        ((b) obj2).userNotExist(str);
                        return;
                    }
                    return;
                }
                if (loginDto2 != null && !Y.f(loginDto2.getMsg())) {
                    string = loginDto2.getMsg();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        gVar.b(string);
    }
}
