package p062l0;

import com.android.billingclient.api.B0;
import com.android.billingclient.api.C0418k0;
import com.android.billingclient.api.C0445y0;
import com.android.billingclient.api.H;
import com.android.billingclient.api.InterfaceC0426o0;
import com.android.billingclient.api.K;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements K, InterfaceC0426o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f5778a;
    public final /* synthetic */ c b;

    public /* synthetic */ a(b bVar, c cVar) {
        this.f5778a = bVar;
        this.b = cVar;
    }

    @Override // com.android.billingclient.api.K
    public void onConsumeResponse(H h6, String str) {
        this.f5778a.getClass();
        int i5 = h6.f2433a;
        c cVar = this.b;
        if (i5 == 0) {
            p051j0.a.d("GoogleBillHelper", "消费成功，purchaseToken: " + str);
            if (cVar != null) {
                cVar.onConsumeSus(str);
                return;
            }
            return;
        }
        String str2 = "消费失败 - code: " + h6.f2433a + ", message: " + h6.getDebugMessage();
        p051j0.a.d("GoogleBillHelper", str2);
        if (cVar != null) {
            cVar.onConsumeFail(str2);
        }
    }

    @Override // com.android.billingclient.api.InterfaceC0426o0
    public void onProductDetailsResponse(H h6, C0445y0 c0445y0) {
        this.f5778a.getClass();
        int i5 = h6.f2433a;
        c cVar = this.b;
        if (i5 != 0) {
            if (cVar != null) {
                cVar.onProductDetailsFail();
            }
            p051j0.a.d("GoogleBillHelper", "code : " + h6.f2433a + " message : " + h6.getDebugMessage());
            return;
        }
        List<C0418k0> productDetailsList = c0445y0.getProductDetailsList();
        List<B0> unfetchedProductList = c0445y0.getUnfetchedProductList();
        if (unfetchedProductList != null) {
            for (B0 b1 : unfetchedProductList) {
                p051j0.a.d("GoogleBillHelper", "商品未获取: productId=" + b1.getProductId() + ", productType=" + b1.getProductType() + ", statusCode=" + b1.getStatusCode());
            }
        }
        if (productDetailsList == null || productDetailsList.isEmpty()) {
            if (cVar != null) {
                cVar.onProductDetailsFail();
            }
        } else if (cVar != null) {
            cVar.onProductDetailsSus(productDetailsList);
        }
    }
}
