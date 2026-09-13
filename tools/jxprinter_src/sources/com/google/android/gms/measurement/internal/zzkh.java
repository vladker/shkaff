package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkh implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzlj zzb;

    public zzkh(zzlj zzljVar, long j6) {
        this.zza = j6;
        Objects.requireNonNull(zzljVar);
        this.zzb = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.zzb;
        zzljVar.zzg();
        zzljVar.zzb();
        zzic zzicVar = zzljVar.zzu;
        zzicVar.zzaV().zzj().zza("Resetting analytics data (FE)");
        zzic zzicVar2 = zzljVar.zzu;
        zzoc zzocVarZzh = zzicVar2.zzh();
        zzocVarZzh.zzg();
        zzocVarZzh.zzb.zzc();
        zzicVar2.zzv().zzi();
        boolean z6 = !zzljVar.zzu.zzB();
        zzhh zzhhVarZzd = zzicVar.zzd();
        zzhhVarZzd.zzc.zzb(this.zza);
        zzic zzicVar3 = zzhhVarZzd.zzu;
        if (!TextUtils.isEmpty(zzicVar3.zzd().zzq.zza())) {
            zzhhVarZzd.zzq.zzb(null);
        }
        zzhhVarZzd.zzk.zzb(0L);
        zzhhVarZzd.zzl.zzb(0L);
        if (!zzicVar3.zzc().zzt()) {
            zzhhVarZzd.zzn(z6);
        }
        zzhhVarZzd.zzr.zzb(null);
        zzhhVarZzd.zzs.zzb(0L);
        zzhhVarZzd.zzt.zzb(null);
        zzicVar2.zzt().zzB();
        zzicVar2.zzh().zza.zza();
        zzljVar.zzc = z6;
        zzicVar2.zzt().zzC(new AtomicReference());
    }
}
