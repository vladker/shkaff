package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzab;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzed;
import com.google.android.gms.internal.play_billing.zzjs;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 extends zzab {
    @Override // com.google.android.gms.internal.play_billing.zzac
    public final void onDelegateToBackendResponse(Bundle bundle) {
        if (bundle == null) {
            zzjs zzjsVar = zzjs.NULL_BUNDLE_FROM_DELEGATE_TO_BACKEND_SERVICE_CALL;
            H h6 = k1.f2514h;
            l1.a(zzjsVar, h6, null, 29, 0);
            l1.a(zzjs.NULL_LISTENER_IN_DELEGATE_TO_BACKEND_CALLBACK, h6, null, 29, 0);
            return;
        }
        H hI = p122v2.a.i(bundle, "GetBillingConfigDelegateToBackendCallback", 29, null, 0);
        if (hI.f2433a != 0) {
            l1.a(zzjs.NULL_LISTENER_IN_DELEGATE_TO_BACKEND_CALLBACK, hI, null, 29, 0);
            return;
        }
        try {
            byte[] byteArray = bundle.getByteArray("RESPONSE_DATA");
            if (byteArray == null) {
                throw new IllegalArgumentException("Response data is null");
            }
            C0425o.a(zzed.zzb(byteArray).zzc());
            throw null;
        } catch (Exception e) {
            zzc.zzo("GetBillingConfigDelegateToBackendCallback", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e);
            zzjs zzjsVar2 = zzjs.ERROR_DECODING_DELEGATE_TO_BACKEND_RESPONSE_DATA;
            H h7 = k1.f2514h;
            l1.zzb(zzjsVar2, h7, null, 29, 0, i1.zza(e));
            l1.a(zzjs.NULL_LISTENER_IN_DELEGATE_TO_BACKEND_CALLBACK, h7, null, 29, 0);
        }
    }
}
