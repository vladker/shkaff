package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdf extends zzdh {
    public static zzdk zza(Object obj) {
        return new zzdi(obj);
    }

    public static zzdk zzb(zzdk zzdkVar, long j6, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return zzdkVar.isDone() ? zzdkVar : zzdp.zzs(zzdkVar, 28500L, timeUnit, scheduledExecutorService);
    }

    public static void zzc(zzdk zzdkVar, zzdd zzddVar, Executor executor) {
        zzdkVar.zzb(new zzde(zzdkVar, zzddVar), executor);
    }
}
