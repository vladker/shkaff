package p062l0;

import com.android.billingclient.api.C0431r0;
import com.android.billingclient.api.H;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface c {
    void onConsumeFail(String str);

    void onConsumeSus(String str);

    void onPendingPurchaseFound(C0431r0 c0431r0);

    void onProductDetailsFail();

    void onProductDetailsSus(List list);

    void onPurchasesUpdated(H h6, List list);
}
