package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2422a;
    public final String b;

    public B(A a6) {
        this.f2422a = a6.f2420a;
        this.b = a6.b;
    }

    @NonNull
    public static A newBuilder() {
        return new A();
    }

    @NonNull
    public String getExternalTransactionToken() {
        return this.b;
    }
}
