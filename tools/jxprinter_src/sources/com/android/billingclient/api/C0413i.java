package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: com.android.billingclient.api.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0413i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2479a;

    @Nullable
    private final String playBillingLoyaltyInfo;

    public C0413i(String str, @Nullable String str2) {
        this.f2479a = str;
        this.playBillingLoyaltyInfo = str2;
    }

    @NonNull
    public String getPlayBillingChoiceImageUrl() {
        return this.f2479a;
    }

    @Nullable
    public String getPlayBillingLoyaltyInfo() {
        return this.playBillingLoyaltyInfo;
    }
}
