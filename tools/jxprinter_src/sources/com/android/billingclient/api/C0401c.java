package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.android.billingclient.api.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0401c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2467a;

    @NonNull
    public static C0399b newBuilder() {
        return new C0399b();
    }

    @NonNull
    public String getPurchaseToken() {
        return this.f2467a;
    }
}
