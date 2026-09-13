package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjl extends zzgp implements zzhs {
    private static final zzjl zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private zzju zzh;
    private int zzi;

    static {
        zzjl zzjlVar = new zzjl();
        zzb = zzjlVar;
        zzgp.zzB(zzjl.class, zzjlVar);
    }

    private zzjl() {
    }

    public static /* synthetic */ void zzG(zzjl zzjlVar, zzkt zzktVar) {
        zzktVar.getClass();
        zzjlVar.zzf = zzktVar;
        zzjlVar.zze = 7;
    }

    public static /* synthetic */ void zzH(zzjl zzjlVar, zzln zzlnVar) {
        zzlnVar.getClass();
        zzjlVar.zzf = zzlnVar;
        zzjlVar.zze = 6;
    }

    public static /* synthetic */ void zzI(zzjl zzjlVar, int i5) {
        zzjlVar.zzg = i5 - 1;
        zzjlVar.zzd |= 1;
    }

    public static zzjj zza() {
        return (zzjj) zzb.zzp();
    }

    public static zzjl zzc(byte[] bArr) {
        return (zzjl) zzgp.zzt(zzb, bArr);
    }

    public static /* synthetic */ void zzf(zzjl zzjlVar, zzjz zzjzVar) {
        zzjlVar.zzi = zzjzVar.zza();
        zzjlVar.zzd |= 4;
    }

    public static /* synthetic */ void zzg(zzjl zzjlVar, zzju zzjuVar) {
        zzjuVar.getClass();
        zzjlVar.zzh = zzjuVar;
        zzjlVar.zzd |= 2;
    }

    public static /* synthetic */ void zzh(zzjl zzjlVar, zzkn zzknVar) {
        zzknVar.getClass();
        zzjlVar.zzf = zzknVar;
        zzjlVar.zze = 4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0006\u0001\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000\u0005᠌\u0002\u0006<\u0000\u0007<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzjm.zza, "zzh", zzkn.class, "zzi", zzjy.zza, zzln.class, zzkt.class});
        }
        if (i6 == 3) {
            return new zzjl();
        }
        zzjk zzjkVar = null;
        if (i6 == 4) {
            return new zzjj(zzjkVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }

    public final zzkt zze() {
        return this.zze == 7 ? (zzkt) this.zzf : zzkt.zzb();
    }
}
