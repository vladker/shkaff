package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzen extends zzgp implements zzhs {
    private static final zzen zzb;
    private zzgu zzd = zzgp.zzv();

    static {
        zzen zzenVar = new zzen();
        zzb = zzenVar;
        zzgp.zzB(zzen.class, zzenVar);
    }

    private zzen() {
    }

    public static zzem zza() {
        return (zzem) zzb.zzp();
    }

    public static /* synthetic */ void zzc(zzen zzenVar, Iterable iterable) {
        zzgu zzguVar = zzenVar.zzd;
        if (!zzguVar.zzc()) {
            int size = zzguVar.size();
            zzenVar.zzd = zzguVar.zzd(size + size);
        }
        zzfa.zzk(iterable, zzenVar.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgp
    public final Object zzd(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzgp.zzy(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzel.class});
        }
        if (i6 == 3) {
            return new zzen();
        }
        zzeo zzeoVar = null;
        if (i6 == 4) {
            return new zzem(zzeoVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        throw null;
    }
}
