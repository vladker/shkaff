package G;

import com.appdev.standard.api.dto.BiaoQianMyLabelDocResp;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f278a;

    public e(f fVar) {
        this.f278a = fVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.f278a.b;
        if (obj != null) {
            ((d) obj).mineLabelFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        BiaoQianMyLabelDocResp biaoQianMyLabelDocResp = (BiaoQianMyLabelDocResp) jsonResult;
        Object obj = this.f278a.b;
        if (obj != null) {
            ((d) obj).mineLabelSuccess(biaoQianMyLabelDocResp.getData().getRows(), Integer.parseInt(biaoQianMyLabelDocResp.getData().getTotal()));
        }
    }
}
