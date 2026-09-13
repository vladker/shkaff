package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzbl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0418k0 f2572a;

    @Nullable
    private C0434t mSubscriptionProductReplacementParams;

    @Nullable
    private String zzb;

    @NonNull
    public C0436u build() {
        zzbl.zzc(this.f2572a, "ProductDetails is required for constructing ProductDetailsParams.");
        return new C0436u(this);
    }

    @NonNull
    public r setOfferToken(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("offerToken can not be empty");
        }
        this.zzb = str;
        return this;
    }

    @NonNull
    public r setProductDetails(@NonNull C0418k0 c0418k0) {
        this.f2572a = c0418k0;
        if (c0418k0.getOneTimePurchaseOfferDetails() != null) {
            c0418k0.getOneTimePurchaseOfferDetails().getClass();
            C0418k0.b oneTimePurchaseOfferDetails = c0418k0.getOneTimePurchaseOfferDetails();
            if (oneTimePurchaseOfferDetails.getOfferToken() != null) {
                this.zzb = oneTimePurchaseOfferDetails.getOfferToken();
            }
        }
        return this;
    }

    @NonNull
    public r setSubscriptionProductReplacementParams(@NonNull C0434t c0434t) {
        this.mSubscriptionProductReplacementParams = c0434t;
        return this;
    }
}
