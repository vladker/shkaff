package A;

import android.widget.Button;
import com.appdev.standard.api.CommonApi;
import com.appdev.standard.api.pto.SendCodePto;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import kotlin.jvm.internal.Y;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends p038g2.a {
    public final CommonApi d;
    public final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Button f6f;

    public d(MvpActivity mvpActivity, Button button) {
        super(mvpActivity);
        this.d = null;
        this.e = null;
        this.f6f = null;
        this.d = (CommonApi) Http.createApi(CommonApi.class);
        this.f6f = button;
        this.e = new b(this);
    }

    public final void a(int i5, int i6, String str) {
        if (this.b != null) {
            if (1 == i5) {
                if (Y.f(str)) {
                    ((a) this.b).sendCodeFailed(1, getString(g.The_phone_number_sending_the_verification_code_is_wrong));
                    return;
                } else if (!str.matches("^((13[0-9])|(14[05679])|(15([0-3]|[5-9]))|(16[2567])|(17[01235678])|(18[0-9])|(19[135689]))\\d{8}$")) {
                    ((a) this.b).sendCodeFailed(1, getString(g.The_phone_number_sending_the_verification_code_is_wrong));
                    return;
                }
            } else if (2 == i5) {
                if (Y.f(str)) {
                    ((a) this.b).sendCodeFailed(1, getString(g.The_email_sending_the_verification_code_is_wrong));
                    return;
                } else if (!str.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")) {
                    ((a) this.b).sendCodeFailed(1, getString(g.The_email_sending_the_verification_code_is_wrong));
                    return;
                }
            }
        }
        this.d.sendCode(new SendCodePto(i5, i6, str)).b(new c(this, 0));
    }
}
