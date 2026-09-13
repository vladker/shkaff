package G;

import android.content.Context;
import com.appdev.standard.api.DocumentApi;
import com.library.base.util.http.Http;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends p038g2.a {
    public final DocumentApi d;

    public f(Context context) {
        super(context);
        this.d = (DocumentApi) Http.createApi(DocumentApi.class);
    }

    public final void a(String str, int i5, Integer num, Integer num2) {
        this.d.mineLabel(str, i5, 10, num, num2).b(new e(this));
    }
}
