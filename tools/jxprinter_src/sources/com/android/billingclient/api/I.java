package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2435a;

    @NonNull
    public J build() {
        String str = this.f2435a;
        if (str == null) {
            throw new IllegalArgumentException("Purchase token must be set");
        }
        J j6 = new J();
        j6.f2437a = str;
        return j6;
    }

    @NonNull
    public I setPurchaseToken(@NonNull String str) {
        this.f2435a = str;
        return this;
    }
}
