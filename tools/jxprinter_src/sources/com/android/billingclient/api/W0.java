package com.android.billingclient.api;

import A3.AbstractC0157z;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzaj;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzce;
import com.google.android.gms.internal.play_billing.zzjs;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class W0 extends zzaj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P0 f2457a;
    public final Boolean b;
    public final int c;
    public final /* synthetic */ C0421m d;

    public /* synthetic */ W0(C0421m c0421m, P0 p1, Boolean bool, int i5) {
        Objects.requireNonNull(c0421m);
        this.d = c0421m;
        this.f2457a = p1;
        this.b = bool;
        this.c = i5;
    }

    private final void zzb(P0 p1, H h6, zzjs zzjsVar, boolean z6, @Nullable String str, int i5) {
        this.d.T(0);
        p1.zzi(h6, zzjsVar, str, z6, i5);
        p1.d(h6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzak
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            zzc.zzn("BillingClient", "Response bundle is null.");
            zzb(this.f2457a, k1.f2514h, zzjs.NULL_BUNDLE_RETURNED_BY_PHONESKY, this.b.booleanValue(), null, this.c);
            return;
        }
        if (!bundle.containsKey("RESPONSE_CODE")) {
            zzc.zzn("BillingClient", "Response bundle doesn't contain a response code");
            zzb(this.f2457a, k1.f2514h, zzjs.RESPONSE_CODE_NOT_SET_IN_BUNDLE, this.b.booleanValue(), null, this.c);
            return;
        }
        if (bundle.getInt("RESPONSE_CODE") != 0) {
            zzb(this.f2457a, k1.a(bundle.getInt("RESPONSE_CODE"), bundle.getString("DEBUG_MESSAGE", "")), zzjs.NON_OK_CODE_RETURNED_BY_PHONESKY, this.b.booleanValue(), AbstractC0157z.k(bundle.getInt("RESPONSE_CODE"), "Response code from Phonesky: "), this.c);
            return;
        }
        if (!bundle.containsKey("BILLING_API_VERSION_KEY")) {
            zzc.zzn("BillingClient", "Billing API version not found in response bundle.");
            zzb(this.f2457a, k1.f2514h, zzjs.BILLING_API_VERSION_NOT_SET_IN_BUNDLE, this.b.booleanValue(), null, this.c);
            return;
        }
        int i5 = bundle.getInt("BILLING_API_VERSION_KEY");
        C0421m c0421m = this.d;
        C0421m.J(c0421m, i5);
        c0421m.f2549j = i5 >= 5;
        c0421m.f2548i = i5 >= 3;
        Bundle bundle2 = bundle.getBundle("EXPERIMENT_VALUES_KEY");
        if (bundle2 != null) {
            try {
                p002a.c.f904a = bundle2.getBoolean("DELEGATION_API_ENABLED_KEY");
            } catch (Throwable th) {
                zzc.zzo("BillingClient", "Error reading EnableDelegationApi experiment flag: ".concat(bundle2.toString()), th);
            }
            try {
                p002a.c.b = bundle2.getLong("AUTO_SERVICE_RECONNECTION_SYNCHRONOUS_TIMEOUT_MS_KEY");
            } catch (Throwable th2) {
                zzc.zzo("BillingClient", "Error reading AutoServiceReconnectionSynchronousTimeoutMs experiment flag: ".concat(bundle2.toString()), th2);
            }
            try {
                p002a.c.c = bundle2.getLong("AUTO_SERVICE_RECONNECTION_ASYNCHRONOUS_TIMEOUT_MS_KEY");
            } catch (Throwable th3) {
                zzc.zzo("BillingClient", "Error reading AutoServiceReconnectionAsynchronousTimeoutMs experiment flag: ".concat(bundle2.toString()), th3);
            }
            try {
                p002a.c.d = bundle2.getInt("AUTO_SERVICE_RECONNECTION_MAX_NUM_RETRIES_KEY");
            } catch (Throwable th4) {
                zzc.zzo("BillingClient", "Error reading AutoServiceReconnectionMaxNumRetries experiment flag: ".concat(bundle2.toString()), th4);
            }
            try {
                p002a.c.e = bundle2.getBoolean("ENABLE_DEDUPLICATE_SERVICE_DISCONNECTED_CALLBACK");
            } catch (Throwable th5) {
                zzc.zzo("BillingClient", "Error reading EnableDeduplicateServiceDisconnectedCallback experiment flag: ".concat(bundle2.toString()), th5);
            }
        }
        Bundle bundle3 = bundle.getBundle("ENABLED_SUBSCRIPTION_CLIENT_ACTIONS_KEY");
        if (bundle3 != null) {
            zzce zzceVar = new zzce();
            for (w1 w1Var : w1.values()) {
                if (bundle3.getBoolean(w1Var.name(), false)) {
                    zzceVar.zzb(w1Var);
                }
            }
            C0421m c0421m2 = this.d;
            c0421m2.f2540G = zzceVar.zzc();
            if (c0421m2.zzf != null) {
                c0421m2.zzf.f2595g = c0421m2.f2540G;
            }
        }
        C0421m c0421m3 = this.d;
        if (c0421m3.f2550k < 3) {
            zzc.zzn("BillingClient", "In-app billing API version 3 is not supported on this device.");
            zzb(this.f2457a, k1.b, zzjs.ONE_TIME_PRODUCT_NOT_SUPPORTED, this.b.booleanValue(), null, this.c);
            return;
        }
        P0 p1 = this.f2457a;
        Boolean bool = this.b;
        int i6 = this.c;
        boolean zBooleanValue = bool.booleanValue();
        C0421m.K(c0421m3, 0);
        synchronized (c0421m3.f2544a) {
            try {
                if (c0421m3.b == 3) {
                    return;
                }
                p1.c(i6, zBooleanValue);
                p1.d(k1.f2515i);
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }
}
