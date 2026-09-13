package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2426a;
    public int b;

    @NonNull
    public F build() {
        int i5 = this.f2426a;
        if (i5 == 0) {
            throw new IllegalArgumentException("Billing program is not specified.");
        }
        if (i5 == 5 && this.b == 0) {
            throw new IllegalArgumentException("Developer billing type must be specified for billing choice.");
        }
        return new F(this);
    }

    @NonNull
    public E setBillingProgram(int i5) {
        this.f2426a = i5;
        return this;
    }

    @NonNull
    public E setDeveloperBillingType(int i5) {
        this.b = i5;
        return this;
    }
}
