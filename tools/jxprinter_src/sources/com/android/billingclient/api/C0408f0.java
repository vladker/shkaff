package com.android.billingclient.api;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: com.android.billingclient.api.f0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0408f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f2471a;
    public int b;
    public int c;
    public int d;

    @Nullable
    private String zze;

    @NonNull
    public C0410g0 build() {
        int i5 = this.c;
        if (i5 == 0) {
            throw new IllegalArgumentException("Link type is required.");
        }
        int i6 = this.b;
        if (i6 == 0) {
            throw new IllegalArgumentException("Launch mode is required.");
        }
        if (i6 != 1 && i5 == 2) {
            throw new IllegalArgumentException("App downloads must launch in an external browser or app.");
        }
        int i7 = this.d;
        if (i7 == 0) {
            throw new IllegalArgumentException("Billing program is required.");
        }
        if (i7 == 5) {
            if (TextUtils.isEmpty(this.zze)) {
                throw new IllegalArgumentException("External transaction token is required for billing choice with an external link.");
            }
            if (this.c != 1) {
                throw new IllegalArgumentException("Link type must be LINK_TO_DIGITAL_CONTENT_OFFER for billing choice with an external link.");
            }
        }
        Uri uri = this.f2471a;
        if (uri == null) {
            throw new IllegalArgumentException("URI must be set.");
        }
        if (uri.getScheme() != null) {
            return new C0410g0(this);
        }
        throw new IllegalArgumentException("URI must have a scheme.");
    }

    @NonNull
    public C0408f0 setBillingProgram(int i5) {
        this.d = i5;
        return this;
    }

    @NonNull
    public C0408f0 setExternalTransactionToken(@NonNull String str) {
        this.zze = str;
        return this;
    }

    @NonNull
    public C0408f0 setLaunchMode(int i5) {
        this.b = i5;
        return this;
    }

    @NonNull
    public C0408f0 setLinkType(int i5) {
        this.c = i5;
        return this;
    }

    @NonNull
    public C0408f0 setLinkUri(@NonNull Uri uri) {
        this.f2471a = uri;
        return this;
    }
}
