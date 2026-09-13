package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzah;
import com.google.android.gms.internal.play_billing.zzbo;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjs;
import java.lang.ref.WeakReference;
import p079o.AbstractC1282k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class V0 extends zzah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f2455a;
    public final ResultReceiver b;
    public final /* synthetic */ C0421m c;

    public /* synthetic */ V0(C0421m c0421m, WeakReference weakReference) {
        this.c = c0421m;
        this.f2455a = weakReference;
        this.b = new zzbw(c0421m, c0421m.d);
    }

    @Override // com.google.android.gms.internal.play_billing.zzai
    public final void zza(Bundle bundle) {
        C0421m c0421m = this.c;
        ResultReceiver resultReceiver = this.b;
        if (bundle == null) {
            zzc.zzn("BillingClient", "Response bundle is null.");
            c0421m.N(37, k1.f2514h, zzjs.NULL_BUNDLE_RETURNED_BY_PHONESKY);
            resultReceiver.send(6, null);
            return;
        }
        if (!bundle.containsKey("RESPONSE_CODE")) {
            zzc.zzn("BillingClient", "Response bundle doesn't contain a response code.");
            c0421m.N(37, k1.f2514h, zzjs.MISSING_RESPONSE_CODE_IN_PHONESKY_BUNDLE);
            resultReceiver.send(6, bundle);
            return;
        }
        int iZzb = zzc.zzb(bundle, "BillingClient");
        if (iZzb != 0) {
            zzc.zzn("BillingClient", AbstractC1282k.f(iZzb, "Unable to launch intent for launch external link dialog. Response code: "));
            resultReceiver.send(iZzb, bundle);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("EXTERNAL_PAYMENT_DIALOG_INTENT");
        if (pendingIntent == null) {
            zzc.zzn("BillingClient", "Pending intent not found in response bundle.");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("RESPONSE_CODE", 6);
            bundle2.putString("DEBUG_MESSAGE", "An internal error occurred.");
            resultReceiver.send(6, bundle);
            return;
        }
        try {
            Activity activity = (Activity) this.f2455a.get();
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivityV2.class);
            intent.putExtra("launch_external_link_result_receiver", resultReceiver);
            intent.putExtra("launch_external_link_flow_pending_intent", pendingIntent);
            activity.startActivity(intent);
        } catch (RuntimeException e) {
            zzc.zzo("BillingClient", "Runtime error while launching intent for launch external link dialog.", e);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("RESPONSE_CODE", 6);
            bundle3.putString("DEBUG_MESSAGE", "An internal error occurred.");
            bundle3.putInt("INTERNAL_LOG_ERROR_REASON", zzjs.RUNTIME_EXCEPTION_ON_LAUNCH_EXTERNAL_LINK_INTENT.zza());
            bundle3.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", e.getClass().getName() + ": " + zzbo.zzc(e.getMessage()));
            resultReceiver.send(6, bundle3);
        }
    }
}
