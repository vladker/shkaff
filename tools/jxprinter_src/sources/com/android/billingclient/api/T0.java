package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzaf;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjz;
import org.json.JSONException;
import p079o.AbstractC1282k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class T0 extends zzaf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j1 f2452a;
    public final int b;

    public /* synthetic */ T0(j1 j1Var, int i5) {
        this.f2452a = j1Var;
        this.b = i5;
    }

    @Override // com.google.android.gms.internal.play_billing.zzag
    public final void zza(Bundle bundle) {
        int i5 = this.b;
        j1 j1Var = this.f2452a;
        if (bundle == null) {
            zzjs zzjsVar = zzjs.NULL_BUNDLE_FROM_GET_BILLING_CONFIG_SERVICE_CALL;
            H h6 = k1.f2514h;
            int i6 = i1.f2481a;
            ((m1) j1Var).zzb(i1.zzb(zzjsVar, 13, h6, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), i5);
            throw null;
        }
        int iZzb = zzc.zzb(bundle, "BillingClient");
        String strZzj = zzc.zzj(bundle, "BillingClient");
        G gNewBuilder = H.newBuilder();
        gNewBuilder.setResponseCode(iZzb);
        gNewBuilder.setDebugMessage(strZzj);
        if (iZzb != 0) {
            zzc.zzn("BillingClient", AbstractC1282k.f(iZzb, "getBillingConfig() failed. Response code: "));
            H hBuild = gNewBuilder.build();
            zzjs zzjsVar2 = zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i7 = i1.f2481a;
            ((m1) j1Var).zzb(i1.zzb(zzjsVar2, 13, hBuild, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), i5);
            throw null;
        }
        if (!bundle.containsKey("BILLING_CONFIG")) {
            zzc.zzn("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            gNewBuilder.setResponseCode(6);
            H hBuild2 = gNewBuilder.build();
            zzjs zzjsVar3 = zzjs.MISSING_BILLING_CONFIG_IN_GET_BILLING_CONFIG_RESPONSE;
            int i8 = i1.f2481a;
            ((m1) j1Var).zzb(i1.zzb(zzjsVar3, 13, hBuild2, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), i5);
            throw null;
        }
        try {
            new C0425o(bundle.getString("BILLING_CONFIG"));
            gNewBuilder.build();
            throw null;
        } catch (JSONException e) {
            zzc.zzo("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e);
            zzjs zzjsVar4 = zzjs.ERROR_DECODING_BILLING_CONFIG_DATA;
            H h7 = k1.f2514h;
            int i9 = i1.f2481a;
            ((m1) j1Var).zzb(i1.zzb(zzjsVar4, 13, h7, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), i5);
            throw null;
        }
    }
}
