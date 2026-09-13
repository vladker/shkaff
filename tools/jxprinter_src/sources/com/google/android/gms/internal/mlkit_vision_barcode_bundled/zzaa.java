package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaa extends zzeh implements zzfn {
    private static final zzaa zzb;
    private int zzd;
    private zzad zze;
    private boolean zzf;

    static {
        zzaa zzaaVar = new zzaa();
        zzb = zzaaVar;
        zzeh.zzV(zzaa.class, zzaaVar);
    }

    private zzaa() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i6 == 3) {
            return new zzaa();
        }
        zzy zzyVar = null;
        if (i6 == 4) {
            return new zzz(zzyVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zzb;
    }
}
