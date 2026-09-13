package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaf extends zzeh implements zzfn {
    private static final zzaf zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private byte zzg = 2;

    static {
        zzaf zzafVar = new zzaf();
        zzb = zzafVar;
        zzeh.zzV(zzaf.class, zzafVar);
    }

    private zzaf() {
    }

    public static zzae zzc() {
        return (zzae) zzb.zzG();
    }

    public static /* synthetic */ void zze(zzaf zzafVar, int i5) {
        zzafVar.zzd |= 1;
        zzafVar.zze = i5;
    }

    public static /* synthetic */ void zzf(zzaf zzafVar, int i5) {
        zzafVar.zzd |= 2;
        zzafVar.zzf = i5;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i6 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i6 == 3) {
            return new zzaf();
        }
        zza zzaVar = null;
        if (i6 == 4) {
            return new zzae(zzaVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
