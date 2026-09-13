package J;

import A.c;
import android.content.Context;
import com.appdev.standard.api.CommonApi;
import com.library.base.util.http.Http;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends p038g2.a {
    public final CommonApi d;

    public b(Context context) {
        super(context);
        this.d = (CommonApi) Http.createApi(CommonApi.class);
    }

    public final void a() {
        this.d.appFontLib().b(new c(this, 10));
    }
}
