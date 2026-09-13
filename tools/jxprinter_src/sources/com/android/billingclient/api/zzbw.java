package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjz;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
final class zzbw extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0421m f2600a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbw(C0421m c0421m, Handler handler) {
        super(handler);
        this.f2600a = c0421m;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i5, @Nullable Bundle bundle) {
        G gNewBuilder = H.newBuilder();
        gNewBuilder.setResponseCode(i5);
        if (i5 != 0) {
            C0421m c0421m = this.f2600a;
            if (bundle == null) {
                c0421m.zzbk(null, k1.f2514h, zzjs.NULL_BUNDLE_IN_LAUNCH_EXTERNAL_LINK_RESULT_RECEIVER, null);
                return;
            }
            gNewBuilder.setDebugMessage(zzc.zzj(bundle, "BillingClient"));
            int i6 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
            zzjs zzjsVarZzb = i6 != 0 ? zzjs.zzb(i6) : zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            H hBuild = gNewBuilder.build();
            String string = bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS");
            int i7 = i1.f2481a;
            c0421m.Q(i1.zzb(zzjsVarZzb, 37, hBuild, string, zzjz.BROADCAST_ACTION_UNSPECIFIED));
        }
        gNewBuilder.build();
        throw null;
    }
}
