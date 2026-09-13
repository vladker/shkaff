package p037g0;

import android.content.ContextWrapper;
import com.appdev.standard.api.MineApi;
import com.appdev.standard.api.pto.ActivateDevicePto;
import com.library.base.util.http.Http;
import p038g2.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {
    public final MineApi d;

    public c(ContextWrapper contextWrapper) {
        super(contextWrapper);
        this.d = (MineApi) Http.createApi(MineApi.class);
    }

    public final void a(String str, String str2, String str3, boolean z6) {
        this.d.activateDevice(new ActivateDevicePto(str, str2, str3, z6)).b(new b(this));
    }
}
