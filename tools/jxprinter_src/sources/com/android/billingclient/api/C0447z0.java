package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.android.billingclient.api.z0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0447z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2596a;
    public boolean b;

    @NonNull
    public A0 build() {
        String str = this.f2596a;
        if (str == null) {
            throw new IllegalArgumentException("Product type must be set");
        }
        if (!this.b || str.equals("subs")) {
            return new A0(this);
        }
        throw new IllegalArgumentException("includeSuspendedSubscriptions is only supported for subscription purchases");
    }

    @NonNull
    public C0447z0 includeSuspendedSubscriptions(boolean z6) {
        this.b = z6;
        return this;
    }

    @NonNull
    public C0447z0 setProductType(@NonNull String str) {
        this.f2596a = str;
        return this;
    }
}
