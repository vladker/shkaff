package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.android.billingclient.api.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0438v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2582a;
    public String b;
    public boolean c;
    public int d;

    @NonNull
    public C0440w build() {
        boolean z6 = true;
        if (TextUtils.isEmpty(this.f2582a) && TextUtils.isEmpty(null)) {
            z6 = false;
        }
        boolean zIsEmpty = TextUtils.isEmpty(this.b);
        if (z6 && !zIsEmpty) {
            throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
        }
        if (!this.c && !z6 && zIsEmpty) {
            throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
        }
        C0440w c0440w = new C0440w();
        c0440w.f2584a = this.f2582a;
        c0440w.c = this.d;
        c0440w.b = this.b;
        return c0440w;
    }

    @NonNull
    public C0438v setOldPurchaseToken(@NonNull String str) {
        this.f2582a = str;
        return this;
    }

    @NonNull
    public C0438v setOriginalExternalTransactionId(@NonNull String str) {
        this.b = str;
        return this;
    }

    @NonNull
    @Deprecated
    public C0438v setSubscriptionReplacementMode(int i5) {
        this.d = i5;
        return this;
    }
}
