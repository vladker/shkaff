package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.android.billingclient.api.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0425o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2568a;

    private C0425o(@Nullable String str, String str2) {
        this.f2568a = str2;
    }

    public static void a(String str) {
        new C0425o(null, str);
    }

    @NonNull
    public String getCountryCode() {
        return this.f2568a;
    }

    public C0425o(String str) {
        this.f2568a = new JSONObject(str).optString("countryCode");
    }
}
