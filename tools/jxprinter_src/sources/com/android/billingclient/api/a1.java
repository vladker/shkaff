package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzad;
import com.google.android.gms.internal.play_billing.zzbo;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjs;
import java.lang.ref.WeakReference;
import p079o.AbstractC1282k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends zzad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f2463a;
    public final ResultReceiver b;

    public /* synthetic */ a1(WeakReference weakReference, ResultReceiver resultReceiver) {
        this.f2463a = weakReference;
        this.b = resultReceiver;
    }

    @Override // com.google.android.gms.internal.play_billing.zzae
    public final void zza(Bundle bundle) {
        ResultReceiver resultReceiver = this.b;
        if (bundle == null) {
            resultReceiver.send(6, null);
            return;
        }
        if (!bundle.containsKey("RESPONSE_CODE")) {
            zzc.zzn("BillingClient", "Response bundle doesn't contain a response code");
            resultReceiver.send(6, bundle);
            return;
        }
        int iZzb = zzc.zzb(bundle, "BillingClient");
        if (iZzb != 0) {
            zzc.zzn("BillingClient", AbstractC1282k.f(iZzb, "Unable to launch intent for billing program information dialog"));
            resultReceiver.send(iZzb, bundle);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
        if (pendingIntent == null) {
            zzc.zzm("BillingClient", "User has acknowledged the billing program information dialog before.");
            resultReceiver.send(0, bundle);
            return;
        }
        try {
            Activity activity = (Activity) this.f2463a.get();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivityV2.class);
                intent.putExtra("billing_program_information_dialog_result_receiver", resultReceiver);
                intent.putExtra("billing_program_information_dialog_pending_intent", pendingIntent);
                activity.startActivity(intent);
                return;
            }
            zzc.zzn("BillingClient", "Activity is null or unavailable, unable to launch intent for billing program information dialog.");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("RESPONSE_CODE", 5);
            bundle2.putString("DEBUG_MESSAGE", "Activity is null or unavailable.");
            resultReceiver.send(5, bundle2);
        } catch (RuntimeException e) {
            zzc.zzo("BillingClient", "Runtime error while launching intent for billing program information dialog.", e);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("RESPONSE_CODE", 6);
            bundle3.putString("DEBUG_MESSAGE", "An internal error occurred.");
            bundle3.putInt("INTERNAL_LOG_ERROR_REASON", zzjs.RUNTIME_EXCEPTION_WHEN_LAUNCHING_INTENT.zza());
            bundle3.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", e.getClass().getName() + ": " + zzbo.zzc(e.getMessage()));
            resultReceiver.send(6, bundle3);
        }
    }
}
