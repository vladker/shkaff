package com.android.billingclient.api;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzc;

/* JADX INFO: renamed from: com.android.billingclient.api.d0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0404d0 {

    @Nullable
    private final String zzb;

    public C0404d0(int i5, @Nullable String str) {
        this.zzb = null;
    }

    public static void a(Bundle bundle) {
        if (bundle == null) {
            new C0404d0(0, null);
        } else {
            new C0404d0(zzc.zza(bundle, "InAppMessageResult"), bundle.getString("IN_APP_MESSAGE_PURCHASE_TOKEN"), bundle.getString("IN_APP_MESSAGE_PURCHASE_ID"));
        }
    }

    @Nullable
    public String getPurchaseToken() {
        return this.zzb;
    }

    private C0404d0(int i5, @Nullable String str, @Nullable String str2) {
        this.zzb = str;
    }
}
