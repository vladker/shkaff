package com.android.billingclient.api;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f2441a;
    public int b;
    public int c;

    @Nullable
    private String zzd;

    @NonNull
    public N build() {
        int i5 = this.c;
        if (i5 == 0) {
            throw new IllegalArgumentException("Billing program is required.");
        }
        if (i5 == 5 && this.f2441a != null && TextUtils.isEmpty(this.zzd)) {
            throw new IllegalArgumentException("External transaction token is required for billing choice with an external link.");
        }
        Uri uri = this.f2441a;
        if (uri == null || uri.getScheme() != null) {
            return new N(this);
        }
        throw new IllegalArgumentException("URI must have a scheme.");
    }

    @NonNull
    public M setBillingProgram(int i5) {
        this.c = i5;
        return this;
    }

    @NonNull
    public M setExternalTransactionToken(@Nullable String str) {
        this.zzd = str;
        return this;
    }

    @NonNull
    public M setLaunchMode(int i5) {
        this.b = i5;
        return this;
    }

    @NonNull
    public M setLinkUri(@NonNull Uri uri) {
        this.f2441a = uri;
        return this;
    }
}
