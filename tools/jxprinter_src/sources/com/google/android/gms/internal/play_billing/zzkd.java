package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkd extends zzgp implements zzhs {
    private static final zzkd zzb;
    private int zzd;
    private int zzf;
    private zzju zzi;
    private boolean zzj;
    private boolean zzk;
    private zzld zzl;
    private String zze = "";
    private zzgt zzg = zzgp.zzu();
    private zzgu zzh = zzgp.zzv();

    static {
        zzkd zzkdVar = new zzkd();
        zzb = zzkdVar;
        zzgp.zzB(zzkd.class, zzkdVar);
    }

    private zzkd() {
    }

    public static zzka zza() {
        return (zzka) zzb.zzp();
    }

    public static /* synthetic */ void zzc(zzkd zzkdVar, zzjz zzjzVar) {
        zzjzVar.getClass();
        zzgt zzgtVar = zzkdVar.zzg;
        if (!zzgtVar.zzc()) {
            int size = zzgtVar.size();
            zzkdVar.zzg = zzgtVar.zzd(size + size);
        }
        zzkdVar.zzg.zzh(zzjzVar.zza());
    }

    public static /* synthetic */ void zze(zzkd zzkdVar, zzju zzjuVar) {
        zzjuVar.getClass();
        zzkdVar.zzi = zzjuVar;
        zzkdVar.zzd |= 4;
    }

    public static /* synthetic */ void zzf(zzkd zzkdVar, String str) {
        zzkdVar.zzd |= 1;
        zzkdVar.zze = "ProxyBillingBroadcastReceiver";
    }

    public static /* synthetic */ void zzg(zzkd zzkdVar, zzld zzldVar) {
        zzldVar.getClass();
        zzkdVar.zzl = zzldVar;
        zzkdVar.zzd |= 32;
    }

    public static /* synthetic */ void zzh(zzkd zzkdVar, int i5) {
        zzkdVar.zzf = i5 - 1;
        zzkdVar.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001b\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004\bဉ\u0005", new Object[]{"zzd", "zze", "zzf", zzkb.zza, "zzg", zzjy.zza, "zzh", zzkz.class, "zzi", "zzj", "zzk", "zzl"});
        }
        if (i6 == 3) {
            return new zzkd();
        }
        zzkc zzkcVar = null;
        if (i6 == 4) {
            return new zzka(zzkcVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
