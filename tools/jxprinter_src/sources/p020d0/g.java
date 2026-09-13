package p020d0;

import androidx.fragment.app.FragmentActivity;
import com.appdev.standard.api.MainApi;
import com.library.base.util.http.Http;
import p038g2.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends a {
    public final MainApi d;

    public g(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.d = (MainApi) Http.createApi(MainApi.class);
    }
}
