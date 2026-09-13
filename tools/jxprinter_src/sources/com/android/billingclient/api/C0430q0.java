package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.android.billingclient.api.q0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0430q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f2571a;

    public C0430q0(JSONObject jSONObject) {
        this.f2571a = jSONObject;
    }

    @NonNull
    public List<String> getProducts() {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = this.f2571a;
        if (jSONObject.has("productIds") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("productIds")) != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                arrayList.add(jSONArrayOptJSONArray.optString(i5));
            }
        }
        return arrayList;
    }

    @NonNull
    public String getPurchaseToken() {
        return this.f2571a.optString("purchaseToken");
    }
}
