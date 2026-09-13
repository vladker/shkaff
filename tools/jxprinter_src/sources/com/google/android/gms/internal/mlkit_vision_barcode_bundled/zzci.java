package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzci extends zzeh implements zzfn {
    private static final zzci zzb;
    private int zzd;
    private int zze;
    private zzf zzg;
    private byte zzh = 2;
    private zzeo zzf = zzeh.zzP();

    static {
        zzci zzciVar = new zzci();
        zzb = zzciVar;
        zzeh.zzV(zzci.class, zzciVar);
    }

    private zzci() {
    }

    public final List zzb() {
        return this.zzf;
    }

    public final int zzc() {
        int iZza = zzch.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i6 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001᠌\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"zzd", "zze", zzcg.zza, "zzf", "zzg"});
        }
        if (i6 == 3) {
            return new zzci();
        }
        zzce zzceVar = null;
        if (i6 == 4) {
            return new zzcf(zzceVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
