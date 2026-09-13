package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class D {
    public static volatile D b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f3165a;

    @GuardedBy("this")
    private boolean isRegistered;

    @GuardedBy("this")
    final Set<InterfaceC0533c> listeners = new HashSet();

    private D(@NonNull Context context) {
        this.f3165a = new C(new L0.j(new y(context)), new z(this));
    }

    public static D get(@NonNull Context context) {
        if (b == null) {
            synchronized (D.class) {
                try {
                    if (b == null) {
                        b = new D(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @GuardedBy("this")
    private void maybeRegisterReceiver() {
        if (this.isRegistered || this.listeners.isEmpty()) {
            return;
        }
        this.isRegistered = this.f3165a.register();
    }

    @GuardedBy("this")
    private void maybeUnregisterReceiver() {
        if (this.isRegistered && this.listeners.isEmpty()) {
            C c = this.f3165a;
            ((ConnectivityManager) c.c.get()).unregisterNetworkCallback(c.d);
            this.isRegistered = false;
        }
    }

    @VisibleForTesting
    public static void reset() {
        b = null;
    }

    public final synchronized void a(InterfaceC0533c interfaceC0533c) {
        this.listeners.add(interfaceC0533c);
        maybeRegisterReceiver();
    }

    public final synchronized void b(InterfaceC0533c interfaceC0533c) {
        this.listeners.remove(interfaceC0533c);
        maybeUnregisterReceiver();
    }
}
