package K;

import com.appdev.standard.api.dto.HelpCenterDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f385a;
    public final /* synthetic */ c b;

    public b(c cVar, int i5) {
        this.b = cVar;
        this.f385a = i5;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        Object obj = this.b.b;
        if (obj != null) {
            ((a) obj).getHelpCenterListFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        HelpCenterDto helpCenterDto = (HelpCenterDto) jsonResult;
        c cVar = this.b;
        if (cVar.b != null) {
            ((a) cVar.b).getHelpCenterListSuccess(helpCenterDto.getData().getRows(), this.f385a, (int) Math.ceil(((double) Integer.parseInt(helpCenterDto.getData().getTotal())) / 10.0d));
        }
    }
}
