package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2420a;
    public String b;

    @NonNull
    public B build() {
        int i5 = this.f2420a;
        if (i5 == 0) {
            throw new IllegalArgumentException("Billing program must be set.");
        }
        if (i5 != 5) {
            throw new IllegalArgumentException("The requested billing program is not supported for the billing program information dialog API.");
        }
        if (this.b != null) {
            return new B(this);
        }
        throw new IllegalArgumentException("External transaction token must be set.");
    }

    @NonNull
    public A setBillingProgram(int i5) {
        this.f2420a = i5;
        return this;
    }

    @NonNull
    public A setExternalTransactionToken(@NonNull String str) {
        this.b = str;
        return this;
    }
}
