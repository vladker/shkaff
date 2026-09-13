package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzab;
import com.google.android.gms.internal.play_billing.zzdx;
import com.google.android.gms.internal.play_billing.zzjs;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class L extends zzab {
    private C parseReportingDetails(Bundle bundle) throws Exception {
        byte[] byteArray = bundle.getByteArray("RESPONSE_DATA");
        if (byteArray != null) {
            return new C(zzdx.zzb(byteArray).zzc().zzc());
        }
        throw new Exception("Response data is null");
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public void onDelegateToBackendResponse(Bundle bundle) {
        if (bundle == null) {
            l1.a(zzjs.NULL_BUNDLE_FROM_DELEGATE_TO_BACKEND_SERVICE_CALL, k1.f2514h, null, 35, 0);
            throw null;
        }
        l1.a(zzjs.NULL_LISTENER_IN_DELEGATE_TO_BACKEND_CALLBACK, p122v2.a.i(bundle, "CreateBillingProgramReportingDetailsDelegateToBackendCallback", 35, null, 0), null, 35, 0);
    }
}
