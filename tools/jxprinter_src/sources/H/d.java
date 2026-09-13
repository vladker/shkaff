package H;

import com.appdev.standard.api.dto.CollectLabelDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f281a;

    public d(e eVar) {
        this.f281a = eVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.f281a.b;
        if (obj != null) {
            ((c) obj).publishLabelFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        CollectLabelDto collectLabelDto = (CollectLabelDto) jsonResult;
        Object obj = this.f281a.b;
        if (obj != null) {
            ((c) obj).publishLabelSuccess(collectLabelDto.getData().getRows(), Integer.parseInt(collectLabelDto.getData().getTotal()));
        }
    }
}
