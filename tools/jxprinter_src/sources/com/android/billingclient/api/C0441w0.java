package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: com.android.billingclient.api.w0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0441w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2585a;
    public final String b;

    @Nullable
    private final String dynamicProductToken;

    public /* synthetic */ C0441w0(C0439v0 c0439v0) {
        this.f2585a = c0439v0.f2583a;
        this.b = c0439v0.b;
        this.dynamicProductToken = c0439v0.dynamicProductToken;
    }

    @NonNull
    public static C0439v0 newBuilder() {
        return new C0439v0();
    }

    @Nullable
    public String getDynamicProductToken() {
        return this.dynamicProductToken;
    }

    @NonNull
    public final String zza() {
        return this.f2585a;
    }

    @NonNull
    public final String zzb() {
        return this.b;
    }
}
