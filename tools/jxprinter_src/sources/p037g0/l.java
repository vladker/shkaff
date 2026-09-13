package p037g0;

import com.appdev.standard.api.dto.VipPto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f3984a;

    public l(m mVar) {
        this.f3984a = mVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.f3984a.b;
        if (obj != null) {
            ((k) obj).getVipListFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        VipPto vipPto = (VipPto) jsonResult;
        Object obj = this.f3984a.b;
        if (obj != null) {
            ((k) obj).getVipListSuccess(vipPto.getData().getRows(), Integer.parseInt(vipPto.getData().getTotal()));
        }
    }
}
