package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbf {
    private static final zzbq zza;

    static {
        zzbq zzbeVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            zzbeVar = new zzbd();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            zzbeVar = new zzbe();
        }
        zza = zzbeVar;
    }

    public static zzbq zza() {
        return zza;
    }
}
