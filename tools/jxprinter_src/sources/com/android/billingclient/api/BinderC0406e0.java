package com.android.billingclient.api;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzab;
import com.google.android.gms.internal.play_billing.zzjs;

/* JADX INFO: renamed from: com.android.billingclient.api.e0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC0406e0 extends zzab {
    private void logErrorAndReturnDefaultAvailabilityDetails(int i5, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        l1.zzb(zzjsVar, h6, null, 33, 0, exc == null ? null : i1.zza(exc));
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public void onDelegateToBackendResponse(Bundle bundle) {
        if (bundle == null) {
            l1.a(zzjs.NULL_BUNDLE_FROM_DELEGATE_TO_BACKEND_SERVICE_CALL, k1.f2514h, null, 33, 0);
            throw null;
        }
        l1.a(zzjs.NULL_LISTENER_IN_DELEGATE_TO_BACKEND_CALLBACK, p122v2.a.i(bundle, "IsBillingProgramAvailableDelegateToBackendCallback", 33, null, 0), null, 33, 0);
    }
}
