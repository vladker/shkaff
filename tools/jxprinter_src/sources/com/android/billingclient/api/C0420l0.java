package com.android.billingclient.api;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.android.billingclient.api.l0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0420l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2533a;
    public final String b;

    public C0420l0(JSONObject jSONObject) {
        this.f2533a = jSONObject.optString("formattedDiscountAmount");
        jSONObject.optLong("discountAmountMicros");
        this.b = jSONObject.optString("discountAmountCurrencyCode");
    }

    @NonNull
    public String getDiscountAmountCurrencyCode() {
        return this.b;
    }

    @NonNull
    public String getFormattedDiscountAmount() {
        return this.f2533a;
    }
}
