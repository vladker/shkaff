package A;

import com.appdev.standard.api.CommonApi;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import kotlin.jvm.internal.Y;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends p038g2.a {
    public final CommonApi d;

    public f(MvpActivity mvpActivity) {
        super(mvpActivity);
        this.d = null;
        this.d = (CommonApi) Http.createApi(CommonApi.class);
    }

    public final void a(int i5, int i6, String str, String str2) {
        if (!Y.f(str)) {
            if (!Y.f(str2)) {
                this.d.verifySmsCode(i5, str2, i6, str).b(new c(this, 1));
                return;
            }
            Object obj = this.b;
            if (obj != null) {
                ((e) obj).checkCodeFailed(1, getString(g.The_verification_code_cannot_be_empty));
                return;
            }
            return;
        }
        Object obj2 = this.b;
        if (obj2 != null) {
            if (1 == i5) {
                ((e) obj2).checkCodeFailed(1, getString(g.mobile_phone_number_cannot_be_empty));
            } else if (2 == i5) {
                ((e) obj2).checkCodeFailed(1, getString(g.email_cannot_be_empty));
            }
        }
    }
}
