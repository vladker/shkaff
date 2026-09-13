package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkn extends zzgp implements zzhs {
    private static final zzkn zzb;
    private int zzd;
    private int zze;

    static {
        zzkn zzknVar = new zzkn();
        zzb = zzknVar;
        zzgp.zzB(zzkn.class, zzknVar);
    }

    private zzkn() {
    }

    public static zzkk zza() {
        return (zzkk) zzb.zzp();
    }

    public static /* synthetic */ void zzc(zzkn zzknVar, int i5) {
        zzknVar.zze = i5 - 1;
        zzknVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzkl.zza});
        }
        if (i6 == 3) {
            return new zzkn();
        }
        zzkm zzkmVar = null;
        if (i6 == 4) {
            return new zzkk(zzkmVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
