package com.android.billingclient.api;

import A3.AbstractC0157z;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import org.apache.commons.math3.geometry.VectorFormat;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2423a;
    public final String b;
    public final String c;
    public final int d;

    @Nullable
    private final String serializedDocid;

    public B0(String str) {
        this.f2423a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.b = jSONObject.optString("productId");
        String strOptString = jSONObject.optString("type");
        this.c = strOptString;
        this.d = jSONObject.has("statusCode") ? jSONObject.optInt("statusCode") : 0;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.serializedDocid = jSONObject.optString("serializedDocid");
    }

    @NonNull
    @VisibleForTesting
    public static B0 fromJson(@NonNull String str) {
        return new B0(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof B0) {
            return TextUtils.equals(this.f2423a, ((B0) obj).f2423a);
        }
        return false;
    }

    @NonNull
    public String getProductId() {
        return this.b;
    }

    @NonNull
    public String getProductType() {
        return this.c;
    }

    @Nullable
    public String getSerializedDocid() {
        return this.serializedDocid;
    }

    public int getStatusCode() {
        return this.d;
    }

    public final int hashCode() {
        return this.f2423a.hashCode();
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("UnfetchedProduct{productId='");
        sb.append(this.b);
        sb.append("', productType='");
        sb.append(this.c);
        sb.append("', statusCode=");
        return AbstractC0157z.l(VectorFormat.DEFAULT_SUFFIX, this.d, sb);
    }
}
