package S;

import A.c;
import com.appdev.standard.api.DocumentApi;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends p038g2.a {
    public final DocumentApi d;

    public a(MvpActivity mvpActivity) {
        super(mvpActivity);
        this.d = (DocumentApi) Http.createApi(DocumentApi.class);
    }

    public final void a(int i5, String str, String str2) {
        HashMap map = new HashMap();
        map.put("recName", str);
        map.put("recDevice", str2);
        map.put("recCount", Integer.valueOf(i5));
        this.d.insertJxAppPrintLog(map).b(new c(this, 20));
    }
}
