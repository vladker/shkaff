package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzld extends zzgp implements zzhs {
    private static final zzld zzb;
    private int zzd;
    private int zze;

    static {
        zzld zzldVar = new zzld();
        zzb = zzldVar;
        zzgp.zzB(zzld.class, zzldVar);
    }

    private zzld() {
    }

    public static zzla zza() {
        return (zzla) zzb.zzp();
    }

    public static /* synthetic */ void zzc(zzld zzldVar, int i5) {
        zzldVar.zze = i5 - 1;
        zzldVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzlb.zza});
        }
        if (i6 == 3) {
            return new zzld();
        }
        zzlc zzlcVar = null;
        if (i6 == 4) {
            return new zzla(zzlcVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
