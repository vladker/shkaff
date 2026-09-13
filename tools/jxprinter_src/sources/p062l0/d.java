package p062l0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.C0431r0;
import com.android.billingclient.api.H;
import com.android.billingclient.api.InterfaceC0435t0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements InterfaceC0435t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f5779a;

    public d(e eVar) {
        this.f5779a = eVar;
    }

    @Override // com.android.billingclient.api.InterfaceC0435t0
    public void onPurchasesUpdated(@NonNull H h6, @Nullable List<C0431r0> list) {
        c cVar = this.f5779a.b;
        if (cVar != null) {
            cVar.onPurchasesUpdated(h6, list);
        }
    }
}
