package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.android.billingclient.api.i0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0414i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2480a;
    public boolean b;

    @NonNull
    public C0416j0 build() {
        if (this.f2480a) {
            return new C0416j0(this.b);
        }
        throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
    }

    @NonNull
    public C0414i0 enableOneTimeProducts() {
        this.f2480a = true;
        return this;
    }

    @NonNull
    public C0414i0 enablePrepaidPlans() {
        this.b = true;
        return this;
    }
}
