package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzoo {
    final Unsafe zza;

    public zzoo(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract void zza(Object obj, long j6, byte b);

    public abstract boolean zzb(Object obj, long j6);

    public abstract void zzc(Object obj, long j6, boolean z6);

    public abstract float zzd(Object obj, long j6);

    public abstract void zze(Object obj, long j6, float f6);

    public abstract double zzf(Object obj, long j6);

    public abstract void zzg(Object obj, long j6, double d);
}
