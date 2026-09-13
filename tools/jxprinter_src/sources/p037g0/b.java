package p037g0;

import com.appdev.standard.api.dto.ActivateDeviceResultDto;
import com.google.gson.Gson;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f3981a;

    public b(c cVar) {
        this.f3981a = cVar;
    }

    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        a.d("VIP_DEBUG", "激活请求失败: " + i5 + " - " + str);
        Object obj = this.f3981a.b;
        if (obj != null) {
            ((a) obj).activateDeviceFailed(i5, str);
        }
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        ActivateDeviceResultDto activateDeviceResultDto = (ActivateDeviceResultDto) jsonResult;
        c cVar = this.f3981a;
        if (cVar.b != null) {
            if (activateDeviceResultDto != null) {
                try {
                    if (activateDeviceResultDto.getData() != null) {
                        boolean zIsSuccess = activateDeviceResultDto.getData().isSuccess();
                        if (!zIsSuccess) {
                            a.d("VIP_DEBUG", "激活失败：服务器返回 success=false");
                            ((a) cVar.b).activateDeviceFailed(-1, "激活失败：服务器返回失败");
                            return;
                        }
                        int activateResult = activateDeviceResultDto.getData().getActivateResult();
                        a.c("VIP_DEBUG", "激活解析结果: success=" + zIsSuccess + ", activateResult=" + activateResult + " | 原始数据: " + new Gson().toJson(activateDeviceResultDto));
                        ((a) cVar.b).activateDeviceSuccess(activateResult);
                        return;
                    }
                } catch (Exception e) {
                    a.e("VIP_DEBUG", "解析激活结果异常", e);
                    ((a) cVar.b).activateDeviceFailed(-1, "解析激活结果失败");
                    return;
                }
            }
            a.d("VIP_DEBUG", "激活失败：返回数据为空");
            ((a) cVar.b).activateDeviceFailed(-1, "激活失败：返回数据为空");
        }
    }
}
