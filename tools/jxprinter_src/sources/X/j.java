package X;

import android.content.Context;
import com.appdev.standard.api.SceneApi;
import com.library.base.util.http.Http;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends p038g2.a {
    public final SceneApi d;

    public j(Context context) {
        super(context);
        this.d = (SceneApi) Http.createApi(SceneApi.class);
    }

    public final void a(List list) {
        HashMap map = new HashMap();
        map.put("biaoqianCloudIds", list);
        this.d.deleteCloudSpace(map).b(new A.c(this, 26));
    }
}
