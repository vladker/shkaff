package T;

import com.appdev.standard.api.dto.AppPrintDataAddDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f699a;

    public b(c cVar) {
        this.f699a = cVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.f699a.b;
        if (obj != null) {
            ((a) obj).printDataAddFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        AppPrintDataAddDto appPrintDataAddDto = (AppPrintDataAddDto) jsonResult;
        Object obj = this.f699a.b;
        if (obj != null) {
            ((a) obj).printDataAddSuccess(appPrintDataAddDto.getData().isResult());
        }
    }
}
