package p062l0;

import com.android.billingclient.api.C0431r0;
import com.android.billingclient.api.J;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public final void a(c cVar, C0431r0 c0431r0) {
        if (!e.b().c()) {
            a.d("GoogleBillHelper", "BillingClient 未准备好，无法消费");
            cVar.onConsumeFail("BillingClient not ready");
        } else {
            if (c0431r0 == null) {
                a.d("GoogleBillHelper", "Purchase 对象为空，无法消费");
                cVar.onConsumeFail("Purchase is null");
                return;
            }
            a.d("GoogleBillHelper", "开始消费商品，purchaseToken: " + c0431r0.getPurchaseToken());
            e.b().f5781a.consumeAsync(J.newBuilder().setPurchaseToken(c0431r0.getPurchaseToken()).build(), new a(this, cVar));
        }
    }
}
