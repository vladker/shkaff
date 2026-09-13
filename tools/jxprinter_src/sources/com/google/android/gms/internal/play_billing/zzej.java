package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzej extends zzgp implements zzhs {
    private static final zzej zzb;
    private int zzd;
    private int zze;
    private zzdu zzf;

    static {
        zzej zzejVar = new zzej();
        zzb = zzejVar;
        zzgp.zzB(zzej.class, zzejVar);
    }

    private zzej() {
    }

    public static zzej zzc(byte[] bArr) {
        return (zzej) zzgp.zzt(zzb, bArr);
    }

    public final zzdu zza() {
        zzdu zzduVar = this.zzf;
        return zzduVar == null ? zzdu.zzb() : zzduVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i6 == 3) {
            return new zzej();
        }
        zzei zzeiVar = null;
        if (i6 == 4) {
            return new zzeh(zzeiVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }

    public final boolean zze() {
        return (this.zzd & 2) != 0;
    }
}
