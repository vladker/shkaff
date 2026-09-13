package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzig implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzjd zze;

    public zzig(zzjd zzjdVar, String str, String str2, String str3, long j6) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j6;
        Objects.requireNonNull(zzjdVar);
        this.zze = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.zza;
        if (str == null) {
            zzjd zzjdVar = this.zze;
            zzjdVar.zzL().zzat(this.zzb, null);
        } else {
            zzlu zzluVar = new zzlu(this.zzc, str, this.zzd);
            zzjd zzjdVar2 = this.zze;
            zzjdVar2.zzL().zzat(this.zzb, zzluVar);
        }
    }
}
