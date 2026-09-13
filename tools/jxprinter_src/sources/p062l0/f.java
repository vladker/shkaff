package p062l0;

import com.library.base.util.http.CallBack;
import com.library.base.util.http.JsonResult;
import com.orhanobut.hawk.Hawk;
import kotlin.jvm.internal.Y;
import p042h2.d;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends CallBack {
    @Override // com.library.base.util.http.CallBack
    public final void fail(int i5, String str) {
        a.d("GooglePaymentRecovery", "服务器验证失败 - code: " + i5 + ", message: " + str);
        Y.f5691a = false;
    }

    @Override // com.library.base.util.http.CallBack
    public final void success(JsonResult jsonResult) {
        a.d("GooglePaymentRecovery", "服务器验证成功，清除本地订单信息");
        Hawk.delete("PENDING_GOOGLE_ORDER_ID");
        Hawk.delete("PENDING_GOOGLE_PACKAGE_ID");
        Hawk.delete("PENDING_PURCHASE_TOKEN");
        a.d("GooglePaymentRecovery", "清除本地Google支付信息");
        Y.f5691a = false;
        d.a("VIP payment verified successfully");
    }
}
