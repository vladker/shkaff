package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: com.android.billingclient.api.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0436u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0418k0 f2579a;

    @Nullable
    private final C0434t mSubscriptionProductReplacementParams;

    @Nullable
    private final String zzb;

    public /* synthetic */ C0436u(r rVar) {
        this.f2579a = rVar.f2572a;
        this.zzb = rVar.zzb;
        this.mSubscriptionProductReplacementParams = rVar.mSubscriptionProductReplacementParams;
    }

    @NonNull
    public static r newBuilder() {
        return new r();
    }

    @Nullable
    public C0434t getSubscriptionProductReplacementParams() {
        return this.mSubscriptionProductReplacementParams;
    }

    @NonNull
    public final C0418k0 zza() {
        return this.f2579a;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }
}
