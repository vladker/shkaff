package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.android.billingclient.api.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0434t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2577a;
    private int replacementMode;

    @NonNull
    public static C0432s newBuilder() {
        C0432s c0432s = new C0432s();
        c0432s.b = 0;
        return c0432s;
    }

    @NonNull
    public String getOldProductId() {
        return this.f2577a;
    }

    public int getReplacementMode() {
        return this.replacementMode;
    }
}
