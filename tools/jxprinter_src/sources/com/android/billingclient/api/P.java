package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2446a;

    @Nullable
    private O zzb;

    @NonNull
    public Q build() {
        return new Q(this);
    }

    @NonNull
    public P setBillingProgram(int i5) {
        this.f2446a = i5;
        return this;
    }

    @NonNull
    public P setDeveloperProvidedBillingListener(@Nullable O o6) {
        return this;
    }
}
