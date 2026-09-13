package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzea extends zzgp implements zzhs {
    private static final zzea zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzea zzeaVar = new zzea();
        zzb = zzeaVar;
        zzgp.zzB(zzea.class, zzeaVar);
    }

    private zzea() {
    }

    public static zzea zzb(byte[] bArr) {
        return (zzea) zzgp.zzt(zzb, bArr);
    }

    public final String zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i6 == 3) {
            return new zzea();
        }
        zzdz zzdzVar = null;
        if (i6 == 4) {
            return new zzdy(zzdzVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }

    public final String zze() {
        return this.zzf;
    }
}
