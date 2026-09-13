package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzix extends zzeh implements zzfn {
    private static final zzix zzb;
    private int zzd;
    private int zze;
    private int zzf = 100;
    private int zzg;

    static {
        zzix zzixVar = new zzix();
        zzb = zzixVar;
        zzeh.zzV(zzix.class, zzixVar);
    }

    private zzix() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", zziv.zza, "zzf", "zzg"});
        }
        if (i6 == 3) {
            return new zzix();
        }
        zzhi zzhiVar = null;
        if (i6 == 4) {
            return new zziw(zzhiVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zzb;
    }
}
