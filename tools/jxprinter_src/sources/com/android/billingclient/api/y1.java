package com.android.billingclient.api;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzcf;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2593a;
    public final InterfaceC0435t0 b;
    public final j1 c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zzcf f2595g = zzcf.zzk();
    public final x1 d = new x1(this, true);
    public final x1 e = new x1(this, false);

    public y1(Context context, InterfaceC0435t0 interfaceC0435t0, j1 j1Var) {
        this.f2593a = context;
        this.b = interfaceC0435t0;
        this.c = j1Var;
    }

    @Nullable
    public final O zzc() {
        return null;
    }

    @Nullable
    public final InterfaceC0435t0 zze() {
        return this.b;
    }
}
