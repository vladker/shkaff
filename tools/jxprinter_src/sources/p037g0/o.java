package p037g0;

import com.appdev.standard.api.dto.VipPayDto;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3985a;
    public final /* synthetic */ p b;

    public /* synthetic */ o(p pVar, int i5) {
        this.f3985a = i5;
        this.b = pVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        switch (this.f3985a) {
            case 0:
                Object obj = this.b.b;
                if (obj != null) {
                    ((n) obj).vipPayFailed(i5, str);
                }
                break;
            default:
                Object obj2 = this.b.b;
                if (obj2 != null) {
                    ((n) obj2).googlePayFailed(i5, str);
                }
                break;
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        switch (this.f3985a) {
            case 0:
                VipPayDto vipPayDto = (VipPayDto) jsonResult;
                Object obj = this.b.b;
                if (obj != null) {
                    ((n) obj).vipPaySuccess(vipPayDto);
                }
                break;
            default:
                Object obj2 = this.b.b;
                if (obj2 != null) {
                    ((n) obj2).googlePaySuccess();
                }
                break;
        }
    }
}
