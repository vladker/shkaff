package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdu extends zzgp implements zzhs {
    private static final zzdu zzb;
    private int zzd;
    private int zze;
    private boolean zzf;

    static {
        zzdu zzduVar = new zzdu();
        zzb = zzduVar;
        zzgp.zzB(zzdu.class, zzduVar);
    }

    private zzdu() {
    }

    public static zzdu zzb() {
        return zzb;
    }

    public final boolean zzc() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i6 == 3) {
            return new zzdu();
        }
        zzdt zzdtVar = null;
        if (i6 == 4) {
            return new zzds(zzdtVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }

    public final int zze() {
        int i5 = this.zze;
        int i6 = 2;
        if (i5 != 0) {
            if (i5 != 1) {
                i6 = i5 != 2 ? 0 : 4;
            } else {
                i6 = 3;
            }
        }
        if (i6 == 0) {
            return 1;
        }
        return i6;
    }
}
