package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class y implements L0.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3182a;

    public y(Context context) {
        this.f3182a = context;
    }

    @Override // L0.k
    public final Object get() {
        return (ConnectivityManager) this.f3182a.getSystemService("connectivity");
    }
}
