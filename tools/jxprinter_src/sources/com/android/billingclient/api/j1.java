package com.android.billingclient.api;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzcd;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzlk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2483a = 0;

    static {
        zzcd.zzc("com.android.vending.billing.PURCHASES_UPDATED", zzjz.PURCHASES_UPDATED_ACTION, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", zzjz.LOCAL_PURCHASES_UPDATED_ACTION, "com.android.vending.billing.ALTERNATIVE_BILLING", zzjz.ALTERNATIVE_BILLING_ACTION);
    }

    void zzb(@Nullable zzjl zzjlVar, int i5);

    void zzf(@Nullable zzjp zzjpVar);

    void zzg(@Nullable zzjp zzjpVar, int i5);

    void zzj(@Nullable H h6, long j6);

    void zzn(@Nullable zzlk zzlkVar);
}
