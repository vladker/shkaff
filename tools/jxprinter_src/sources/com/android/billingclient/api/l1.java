package com.android.billingclient.api;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjz;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l1 {
    public static void a(zzjs zzjsVar, H h6, j1 j1Var, int i5, int i6) {
        int i7 = i1.f2481a;
        ((m1) j1Var).zzb(i1.zzb(zzjsVar, i5, h6, null, zzjz.BROADCAST_ACTION_UNSPECIFIED), i6);
    }

    public static void zzb(zzjs zzjsVar, H h6, j1 j1Var, int i5, int i6, @Nullable String str) {
        int i7 = i1.f2481a;
        ((m1) j1Var).zzb(i1.zzb(zzjsVar, i5, h6, str, zzjz.BROADCAST_ACTION_UNSPECIFIED), i6);
    }
}
