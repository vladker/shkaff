package com.android.billingclient.api;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: com.android.billingclient.api.g0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0410g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f2474a;
    public final int b;
    public final int c;
    public final int d;

    @Nullable
    private final String zze;

    public /* synthetic */ C0410g0(C0408f0 c0408f0) {
        this.f2474a = c0408f0.f2471a;
        this.b = c0408f0.b;
        this.c = c0408f0.c;
        this.d = c0408f0.d;
        this.zze = c0408f0.zze;
    }

    @NonNull
    public static C0408f0 newBuilder() {
        C0408f0 c0408f0 = new C0408f0();
        c0408f0.b = 0;
        c0408f0.c = 0;
        c0408f0.d = 0;
        return c0408f0;
    }

    public int getBillingProgram() {
        return this.d;
    }

    @Nullable
    public String getExternalTransactionToken() {
        return this.zze;
    }

    public int getLaunchMode() {
        return this.b;
    }

    public int getLinkType() {
        return this.c;
    }

    @NonNull
    public Uri getLinkUri() {
        return this.f2474a;
    }
}
