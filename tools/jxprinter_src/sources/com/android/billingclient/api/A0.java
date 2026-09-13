package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class A0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2421a;
    public final boolean b;

    public /* synthetic */ A0(C0447z0 c0447z0) {
        this.f2421a = c0447z0.f2596a;
        this.b = c0447z0.b;
    }

    @NonNull
    public static C0447z0 newBuilder() {
        C0447z0 c0447z0 = new C0447z0();
        c0447z0.b = false;
        return c0447z0;
    }

    @NonNull
    public final String zza() {
        return this.f2421a;
    }
}
