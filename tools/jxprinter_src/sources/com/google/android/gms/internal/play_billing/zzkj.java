package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkj extends zzgp implements zzhs {
    private static final zzkj zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzkj zzkjVar = new zzkj();
        zzb = zzkjVar;
        zzgp.zzB(zzkj.class, zzkjVar);
    }

    private zzkj() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i6 == 3) {
            return new zzkj();
        }
        zzki zzkiVar = null;
        if (i6 == 4) {
            return new zzkh(zzkiVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
