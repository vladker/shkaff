package p025e0;

import com.appdev.standard.api.MineApi;
import com.appdev.standard.api.pto.EditUserNamePto;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import kotlin.jvm.internal.Y;
import p020d0.d;
import p038g2.a;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends a {
    public final MineApi d;

    public h(MvpActivity mvpActivity) {
        super(mvpActivity);
        this.d = (MineApi) Http.createApi(MineApi.class);
    }

    public final void a(int i5, String str, String str2, String str3) {
        if (!Y.f(str)) {
            this.d.editUserName(new EditUserNamePto(i5, str, str2, str3)).b(new d(this, 4));
        } else {
            Object obj = this.b;
            if (obj != null) {
                ((g) obj).editUserNameFailed(1, getString(g.The_verification_code_cannot_be_empty));
            }
        }
    }
}
