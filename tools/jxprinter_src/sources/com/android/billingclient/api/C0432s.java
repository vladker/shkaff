package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.android.billingclient.api.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0432s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2575a;
    public int b;

    @NonNull
    public C0434t build() {
        C0434t c0434t = new C0434t();
        c0434t.f2577a = this.f2575a;
        c0434t.replacementMode = this.b;
        return c0434t;
    }

    @NonNull
    public C0432s setOldProductId(@NonNull String str) {
        this.f2575a = str;
        return this;
    }

    @NonNull
    public C0432s setReplacementMode(int i5) {
        this.b = i5;
        return this;
    }
}
