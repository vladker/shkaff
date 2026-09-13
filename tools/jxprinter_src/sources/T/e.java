package T;

import com.appdev.standard.api.MainApi;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import kotlin.jvm.internal.Y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends p038g2.a {
    public final MainApi d;

    public e(MvpActivity mvpActivity) {
        super(mvpActivity);
        this.d = (MainApi) Http.createApi(MainApi.class);
    }

    public final void a(String str) {
        if (!Y.f(str)) {
            this.d.printPersonalBiaoqian(str).b(new A.c(this, 21));
            return;
        }
        Object obj = this.b;
        if (obj != null) {
            ((d) obj).printPersonalBiaoqianFailed(1, "");
        }
    }
}
