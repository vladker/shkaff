package E;

import android.content.Context;
import com.appdev.standard.api.CommonApi;
import com.library.base.util.http.Http;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends p038g2.a {
    public final CommonApi d;

    public e(Context context) {
        super(context);
        this.d = (CommonApi) Http.createApi(CommonApi.class);
    }

    public final void a() {
        this.d.getBqIndustryDict().b(new d(this, 0));
    }
}
