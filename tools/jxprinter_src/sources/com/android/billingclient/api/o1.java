package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzab;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzea;
import com.google.android.gms.internal.play_billing.zzjs;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 extends zzab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j1 f2569a;
    public final int b;

    public o1(j1 j1Var, int i5) {
        this.f2569a = j1Var;
        this.b = i5;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public final void onDelegateToBackendResponse(Bundle bundle) {
        int i5 = this.b;
        j1 j1Var = this.f2569a;
        if (bundle == null) {
            l1.a(zzjs.NULL_BUNDLE_FROM_DELEGATE_TO_BACKEND_SERVICE_CALL, k1.f2514h, j1Var, 40, i5);
            throw null;
        }
        if (p122v2.a.i(bundle, "GetBillingChoiceInfoDelegateToBackendCallback", 40, j1Var, i5).f2433a != 0) {
            throw null;
        }
        try {
            byte[] byteArray = bundle.getByteArray("RESPONSE_DATA");
            if (byteArray == null) {
                throw new IllegalArgumentException("Response data is null");
            }
            zzea zzeaVarZzb = zzea.zzb(byteArray);
            new C0413i(zzeaVarZzb.zzc(), zzeaVarZzb.zze());
            throw null;
        } catch (Exception e) {
            zzc.zzo("GetBillingChoiceInfoDelegateToBackendCallback", "Got an exception trying to decode BillingChoiceInfo. \n Exception: ", e);
            l1.zzb(zzjs.ERROR_DECODING_DELEGATE_TO_BACKEND_RESPONSE_DATA, k1.f2514h, this.f2569a, 40, this.b, i1.zza(e));
            throw null;
        }
    }
}
