package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2428a;
    public final int b;

    public /* synthetic */ F(E e) {
        this.f2428a = e.f2426a;
        this.b = e.b;
    }

    @NonNull
    public static E newBuilder() {
        E e = new E();
        e.f2426a = 0;
        e.b = 0;
        return e;
    }

    public int getDeveloperBillingType() {
        return this.b;
    }
}
