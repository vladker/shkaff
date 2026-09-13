package G;

import com.appdev.standard.api.dto.AppMyDocResp;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f279a;

    public h(i iVar) {
        this.f279a = iVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.f279a.b;
        if (obj != null) {
            ((g) obj).myDocFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        AppMyDocResp appMyDocResp = (AppMyDocResp) jsonResult;
        Object obj = this.f279a.b;
        if (obj != null) {
            ((g) obj).myDocSuccess(appMyDocResp.getData().getRows(), Integer.parseInt(appMyDocResp.getData().getTotal()));
        }
    }
}
