package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjb extends zzeh implements zzfn {
    private static final zzjb zzb;
    private int zzd;
    private String zze = "";
    private zzjh zzf;

    static {
        zzjb zzjbVar = new zzjb();
        zzb = zzjbVar;
        zzeh.zzV(zzjb.class, zzjbVar);
    }

    private zzjb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i6 == 3) {
            return new zzjb();
        }
        zzhi zzhiVar = null;
        if (i6 == 4) {
            return new zzja(zzhiVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zzb;
    }
}
