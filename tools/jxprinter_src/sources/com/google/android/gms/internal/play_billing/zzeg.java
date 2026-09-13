package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeg extends zzgp implements zzhs {
    private static final zzeg zzb;
    private int zzd;
    private String zze = "";

    static {
        zzeg zzegVar = new zzeg();
        zzb = zzegVar;
        zzgp.zzB(zzeg.class, zzegVar);
    }

    private zzeg() {
    }

    public static zzeg zzb() {
        return zzb;
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
            return zzgp.zzy(zzb, "\u0004\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i6 == 3) {
            return new zzeg();
        }
        zzef zzefVar = null;
        if (i6 == 4) {
            return new zzee(zzefVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
