package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3164a;
    public final z b;
    public final L0.j c;
    public final B d = new B(this);

    public C(L0.j jVar, z zVar) {
        this.c = jVar;
        this.b = zVar;
    }

    @SuppressLint({"MissingPermission"})
    public boolean register() {
        L0.j jVar = this.c;
        this.f3164a = ((ConnectivityManager) jVar.get()).getActiveNetwork() != null;
        try {
            ((ConnectivityManager) jVar.get()).registerDefaultNetworkCallback(this.d);
            return true;
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register callback", e);
            }
            return false;
        }
    }
}
