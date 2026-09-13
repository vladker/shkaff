package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.android.billingclient.api.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0399b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2464a;

    @NonNull
    public C0401c build() {
        String str = this.f2464a;
        if (str == null) {
            throw new IllegalArgumentException("Purchase token must be set");
        }
        C0401c c0401c = new C0401c();
        c0401c.f2467a = str;
        return c0401c;
    }

    @NonNull
    public C0399b setPurchaseToken(@NonNull String str) {
        this.f2464a = str;
        return this;
    }
}
