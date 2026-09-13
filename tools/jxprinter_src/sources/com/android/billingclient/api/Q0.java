package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzw;
import org.json.JSONException;
import p079o.AbstractC1282k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class Q0 extends zzw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j1 f2449a;
    public final int b;

    public /* synthetic */ Q0(j1 j1Var, int i5) {
        this.f2449a = j1Var;
        this.b = i5;
    }

    @Override // com.google.android.gms.internal.play_billing.zzx
    public final void zza(Bundle bundle) {
        int i5 = this.b;
        j1 j1Var = this.f2449a;
        if (bundle == null) {
            zzjs zzjsVar = zzjs.NULL_BUNDLE_FROM_CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL;
            H h6 = k1.f2514h;
            int i6 = i1.f2481a;
            ((m1) j1Var).zzb(i1.zzb(zzjsVar, 15, h6, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), i5);
            throw null;
        }
        int iZzb = zzc.zzb(bundle, "BillingClient");
        H hA = k1.a(iZzb, zzc.zzj(bundle, "BillingClient"));
        if (iZzb != 0) {
            zzc.zzn("BillingClient", AbstractC1282k.f(iZzb, "createAlternativeBillingOnlyReportingDetailsAsync() failed. Response code: "));
            zzjs zzjsVar2 = zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i7 = i1.f2481a;
            ((m1) j1Var).zzb(i1.zzb(zzjsVar2, 15, hA, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), i5);
            throw null;
        }
        try {
            new C0409g(bundle.getString("CREATE_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS"));
            throw null;
        } catch (JSONException e) {
            zzc.zzo("BillingClient", "Error when parsing invalid alternative billing only reporting details. \n Exception: ", e);
            zzjs zzjsVar3 = zzjs.ERROR_DECODING_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS;
            H h7 = k1.f2514h;
            int i8 = i1.f2481a;
            ((m1) j1Var).zzb(i1.zzb(zzjsVar3, 15, h7, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), i5);
            throw null;
        }
    }
}
