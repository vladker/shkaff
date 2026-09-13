package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkw extends zzgp implements zzhs {
    private static final zzkw zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private zzkg zzg;
    private zzkj zzh;

    static {
        zzkw zzkwVar = new zzkw();
        zzb = zzkwVar;
        zzgp.zzB(zzkw.class, zzkwVar);
    }

    private zzkw() {
    }

    public static /* synthetic */ void zzG(zzkw zzkwVar, zzlg zzlgVar) {
        zzlgVar.getClass();
        zzkwVar.zzf = zzlgVar;
        zzkwVar.zze = 8;
    }

    public static /* synthetic */ void zzH(zzkw zzkwVar, zzlk zzlkVar) {
        zzkwVar.zzf = zzlkVar;
        zzkwVar.zze = 4;
    }

    public static zzku zza() {
        return (zzku) zzb.zzp();
    }

    public static /* synthetic */ void zzc(zzkw zzkwVar, zzjl zzjlVar) {
        zzkwVar.zzf = zzjlVar;
        zzkwVar.zze = 2;
    }

    public static /* synthetic */ void zze(zzkw zzkwVar, zzjp zzjpVar) {
        zzkwVar.zzf = zzjpVar;
        zzkwVar.zze = 3;
    }

    public static /* synthetic */ void zzf(zzkw zzkwVar, zzjx zzjxVar) {
        zzjxVar.getClass();
        zzkwVar.zzf = zzjxVar;
        zzkwVar.zze = 7;
    }

    public static /* synthetic */ void zzg(zzkw zzkwVar, zzkd zzkdVar) {
        zzkdVar.getClass();
        zzkwVar.zzf = zzkdVar;
        zzkwVar.zze = 5;
    }

    public static /* synthetic */ void zzh(zzkw zzkwVar, zzkg zzkgVar) {
        zzkgVar.getClass();
        zzkwVar.zzg = zzkgVar;
        zzkwVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001\u0007<\u0000\b<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzjl.class, zzjp.class, zzlk.class, zzkd.class, "zzh", zzjx.class, zzlg.class});
        }
        if (i6 == 3) {
            return new zzkw();
        }
        zzkv zzkvVar = null;
        if (i6 == 4) {
            return new zzku(zzkvVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
