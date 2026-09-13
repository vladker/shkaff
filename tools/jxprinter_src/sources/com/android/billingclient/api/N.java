package com.android.billingclient.api;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f2443a;
    public final int b;
    public final int c;

    @Nullable
    private final String zzd;

    public /* synthetic */ N(M m6) {
        this.f2443a = m6.f2441a;
        this.b = m6.b;
        this.c = m6.c;
        this.zzd = m6.zzd;
    }

    @NonNull
    public static M newBuilder() {
        M m6 = new M();
        m6.b = 0;
        m6.c = 0;
        return m6;
    }

    @Nullable
    public String getExternalTransactionToken() {
        return this.zzd;
    }

    @Nullable
    public Uri getLinkUri() {
        return this.f2443a;
    }
}
