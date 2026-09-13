package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzln extends zzgp implements zzhs {
    private static final zzln zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private long zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;

    static {
        zzln zzlnVar = new zzln();
        zzb = zzlnVar;
        zzgp.zzB(zzln.class, zzlnVar);
    }

    private zzln() {
    }

    public static zzll zza() {
        return (zzll) zzb.zzp();
    }

    public static /* synthetic */ void zzc(zzln zzlnVar, boolean z6) {
        zzlnVar.zzd |= 8;
        zzlnVar.zzh = z6;
    }

    public static /* synthetic */ void zze(zzln zzlnVar, int i5) {
        zzlnVar.zzd |= 16;
        zzlnVar.zzi = i5;
    }

    public static /* synthetic */ void zzf(zzln zzlnVar, long j6) {
        zzlnVar.zzd |= 4;
        zzlnVar.zzg = j6;
    }

    public static /* synthetic */ void zzg(zzln zzlnVar, int i5) {
        zzlnVar.zzd |= 32;
        zzlnVar.zzj = i5;
    }

    public static /* synthetic */ void zzh(zzln zzlnVar, boolean z6) {
        zzlnVar.zzd |= 2;
        zzlnVar.zzf = true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003ဂ\u0002\u0004ဇ\u0003\u0005င\u0004\u0006င\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i6 == 3) {
            return new zzln();
        }
        zzlm zzlmVar = null;
        if (i6 == 4) {
            return new zzll(zzlmVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
