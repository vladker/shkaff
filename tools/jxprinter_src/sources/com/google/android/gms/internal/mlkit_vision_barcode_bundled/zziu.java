package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zziu extends zzeh implements zzfn {
    private static final zziu zzb;
    private int zzd;
    private boolean zzf;
    private int zzg;
    private boolean zzj;
    private int zzm;
    private int zzn;
    private boolean zzo;
    private int zze = -1;
    private zzdf zzh = zzdf.zzb;
    private String zzi = "";
    private boolean zzk = true;
    private boolean zzl = true;

    static {
        zziu zziuVar = new zziu();
        zzb = zziuVar;
        zzeh.zzV(zziu.class, zziuVar);
    }

    private zziu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            zzel zzelVar = zzis.zza;
            zzel zzelVar2 = zzit.zza;
            return zzeh.zzS(zzb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003᠌\u0002\u0004ည\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\t᠌\b\n᠌\t\u000bဇ\n", new Object[]{"zzd", "zze", "zzf", "zzg", zzelVar, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzelVar2, "zzn", zzelVar2, "zzo"});
        }
        if (i6 == 3) {
            return new zziu();
        }
        zzhi zzhiVar = null;
        if (i6 == 4) {
            return new zzir(zzhiVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zzb;
    }
}
