package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzia extends zzeh implements zzfn {
    private static final zzia zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzeo zzg = zzeh.zzP();
    private int zzh;

    static {
        zzia zziaVar = new zzia();
        zzb = zziaVar;
        zzeh.zzV(zzia.class, zziaVar);
    }

    private zzia() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002င\u0001\u0003\u001a\u0004င\u0002", new Object[]{"zzd", "zze", zzhz.zza, "zzf", "zzg", "zzh"});
        }
        if (i6 == 3) {
            return new zzia();
        }
        zzhi zzhiVar = null;
        if (i6 == 4) {
            return new zzhy(zzhiVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zzb;
    }
}
