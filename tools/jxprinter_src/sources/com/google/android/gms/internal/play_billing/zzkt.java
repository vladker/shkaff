package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkt extends zzgp implements zzhs {
    private static final zzkt zzb;
    private int zzd;
    private zzgu zze = zzgp.zzv();
    private String zzf = "";
    private boolean zzg;

    static {
        zzkt zzktVar = new zzkt();
        zzb = zzktVar;
        zzgp.zzB(zzkt.class, zzktVar);
    }

    private zzkt() {
    }

    public static zzkt zzb() {
        return zzb;
    }

    public static /* synthetic */ void zzc(zzkt zzktVar, boolean z6) {
        zzktVar.zzd |= 2;
        zzktVar.zzg = z6;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဇ\u0001", new Object[]{"zzd", "zze", zzkr.class, "zzf", "zzg"});
        }
        if (i6 == 3) {
            return new zzkt();
        }
        zzks zzksVar = null;
        if (i6 == 4) {
            return new zzko(zzksVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
