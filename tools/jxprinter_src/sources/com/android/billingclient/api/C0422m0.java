package com.android.billingclient.api;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.android.billingclient.api.m0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0422m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2566a;
    public final String b;
    public final String c;

    public C0422m0(JSONObject jSONObject) {
        this.c = jSONObject.optString("billingPeriod");
        this.b = jSONObject.optString("priceCurrencyCode");
        this.f2566a = jSONObject.optString("formattedPrice");
        jSONObject.optLong("priceAmountMicros");
        jSONObject.optInt("recurrenceMode");
        jSONObject.optInt("billingCycleCount");
    }

    @NonNull
    public String getBillingPeriod() {
        return this.c;
    }

    @NonNull
    public String getFormattedPrice() {
        return this.f2566a;
    }

    @NonNull
    public String getPriceCurrencyCode() {
        return this.b;
    }
}
