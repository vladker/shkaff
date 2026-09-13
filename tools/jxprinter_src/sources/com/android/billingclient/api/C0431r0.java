package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzcf;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.android.billingclient.api.r0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class C0431r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2573a;
    public final String b;
    public final JSONObject c;

    public C0431r0(@NonNull String str, @NonNull String str2) {
        this.f2573a = str;
        this.b = str2;
        this.c = new JSONObject(str);
        zzcf.zzk();
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = this.c;
        if (jSONObject.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i5));
                }
            }
        } else if (jSONObject.has("productId")) {
            arrayList.add(jSONObject.optString("productId"));
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0431r0)) {
            return false;
        }
        C0431r0 c0431r0 = (C0431r0) obj;
        return TextUtils.equals(this.f2573a, c0431r0.getOriginalJson()) && TextUtils.equals(this.b, c0431r0.getSignature());
    }

    @Nullable
    public C0397a getAccountIdentifiers() {
        JSONObject jSONObject = this.c;
        String strOptString = jSONObject.optString("obfuscatedAccountId");
        String strOptString2 = jSONObject.optString("obfuscatedProfileId");
        if (strOptString == null && strOptString2 == null) {
            return null;
        }
        return new C0397a(strOptString, strOptString2);
    }

    @NonNull
    public String getDeveloperPayload() {
        return this.c.optString("developerPayload");
    }

    @Nullable
    public String getOrderId() {
        String strOptString = this.c.optString("orderId");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    @NonNull
    public String getOriginalJson() {
        return this.f2573a;
    }

    @NonNull
    public String getPackageName() {
        return this.c.optString("packageName");
    }

    @Nullable
    public C0430q0 getPendingPurchaseUpdate() {
        JSONObject jSONObjectOptJSONObject = this.c.optJSONObject("pendingPurchaseUpdate");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        return new C0430q0(jSONObjectOptJSONObject);
    }

    @NonNull
    public List<String> getProducts() {
        return a();
    }

    @NonNull
    public String getPurchaseToken() {
        JSONObject jSONObject = this.c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    @NonNull
    public String getSignature() {
        return this.b;
    }

    @NonNull
    @Deprecated
    public ArrayList<String> getSkus() {
        return a();
    }

    public final int hashCode() {
        return this.f2573a.hashCode();
    }

    @NonNull
    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f2573a));
    }
}
