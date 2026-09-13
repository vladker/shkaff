package U;

import android.content.Context;
import com.appdev.standard.api.ReceiptApi;
import com.appdev.standard.api.dto.AppDeleteReceiptBodyV2;
import com.library.base.util.http.Http;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends p038g2.a {
    public final ReceiptApi d;

    public e(Context context) {
        super(context);
        this.d = (ReceiptApi) Http.createApi(ReceiptApi.class);
    }

    public final void a(String str) {
        AppDeleteReceiptBodyV2 appDeleteReceiptBodyV2 = new AppDeleteReceiptBodyV2();
        appDeleteReceiptBodyV2.setReceiptIds(Arrays.asList(Long.valueOf(str)));
        this.d.deleteReceipt(appDeleteReceiptBodyV2).b(new d(this, 0));
    }
}
