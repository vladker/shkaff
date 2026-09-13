package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2431a;
    public int b;
    public String c;

    @NonNull
    public H build() {
        H h6 = new H();
        h6.f2433a = this.f2431a;
        h6.b = this.b;
        h6.c = this.c;
        return h6;
    }

    @NonNull
    public G setDebugMessage(@NonNull String str) {
        this.c = str;
        return this;
    }

    @NonNull
    public G setOnPurchasesUpdatedSubResponseCode(int i5) {
        this.b = i5;
        return this;
    }

    @NonNull
    public G setResponseCode(int i5) {
        this.f2431a = i5;
        return this;
    }
}
